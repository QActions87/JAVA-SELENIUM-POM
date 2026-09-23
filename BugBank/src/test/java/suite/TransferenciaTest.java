package suite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.CadastroPage;
import page.HomePage;
import page.LoginPage;
import page.TransferenciaPage;

import java.time.Duration;

public class TransferenciaTest {

    WebDriver driver;
    LoginPage loginPage;
    CadastroPage cadastroPage;
    TransferenciaPage transferenciaPage;
    HomePage homePage;

    @Before
    public void before() {
        // Configurações essenciais do Chrome para execução em Linux
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        // Inicializa o driver com as opções
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

        // Instancia os Page Objects
        loginPage = new LoginPage(driver);
        cadastroPage = new CadastroPage(driver);
        transferenciaPage = new TransferenciaPage(driver);
        homePage = new HomePage(driver);

        driver.get("http://localhost:3000/");
    }

    @Test
    public void testeTransferenciaComSucesso() {
        // 1. Cadastra a primeira conta (remetente)
        cadastroPage.cadastrarNovaConta("qactionI@gmail.com.br", "qactionI", "123456");

        // 2. Cadastra a segunda conta (destinatário) e armazena os dados gerados
        cadastroPage.cadastrarNovaContaSemSaldo("qactionII@gmail.com.br", "qactionII", "123456");
        String conta2 = cadastroPage.conta;
        String digito2 = cadastroPage.digito;

        // 3. Faz login com a primeira conta
        loginPage.fazerLogin("qactionI@gmail.com.br", "123456");

        // 4. Navega até a tela de transferência
        homePage.clicarPorXpath(homePage.btnTransferencia);

        // 5. Preenche os dados da transferência utilizando as variáveis da segunda conta
        transferenciaPage.preencherValorPorXpath(transferenciaPage.campoNumeroDaConta, conta2);
        transferenciaPage.preencherValorPorXpath(transferenciaPage.campoDigitoConta, digito2);
        transferenciaPage.preencherValorPorXpath(transferenciaPage.campoValor, "500.00");
        transferenciaPage.preencherValorPorXpath(transferenciaPage.campoDescricao, "Aula QA Academy");

        // 6. Confirma a transferência e valida a mensagem no modal
        transferenciaPage.clicarPorXpath(transferenciaPage.btnTransferir);
        transferenciaPage.validarTransferenciaSucesso();
    }

    @After
    public void after() {
        // Evita o NullPointerException caso a sessão falhe no @Before
        if (driver != null) {
            driver.quit();
        }
    }
}