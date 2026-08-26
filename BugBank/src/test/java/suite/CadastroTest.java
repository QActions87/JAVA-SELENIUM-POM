package suite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CadastroPage;

import java.time.Duration;

public class CadastroTest {
    // Variável para receber a instância de ChromeDriver:
    WebDriver driver;
    // Variável para receber a instância de CadastroPage:
    CadastroPage cadastroPage;

    @Before
    public void before() {
        // Configurações para estabilizar o processo no Linux
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Instancia o driver passando as opções
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        cadastroPage = new CadastroPage(driver);
        driver.get("http://localhost:3000/#");
    }
    // Teste de cadastro:
    @Test
    public void testeCadastro() {
        cadastroPage.clicarPorXpath(cadastroPage.btnRegistrar);
        cadastroPage.preencherValorPorXpath(cadastroPage.campoEmail, "qaction@gmail.com");
        cadastroPage.preencherValorPorXpath(cadastroPage.campoNome, "Tiago");
        cadastroPage.preencherValorPorXpath(cadastroPage.campoSenha, "senha123");
        cadastroPage.preencherValorPorXpath(cadastroPage.campoConfirmacaoSenha, "senha123");
        cadastroPage.clicarPorXpath(cadastroPage.campoContaComSaldoToggle);
        cadastroPage.clicarPorXpath(cadastroPage.btnCadastrar);
    }

    @After
    public void after() {

    }
}

























