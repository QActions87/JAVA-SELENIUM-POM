package suite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CadastroPage;
import page.HomePage;
import page.LoginPage;

import java.time.Duration;

public class SaldoInicialTest {
    // Variável que receberá a instância e inicialização do ChromeDriver:
    WebDriver driver;
    // Variável que receberá a instância da classe LoginPage, passando o driver inicializado:
    LoginPage loginPage;
    // Variável do tipo CadastroPage para receber uma instância e cadastrar antes do teste de login:
    CadastroPage cadastroPage;
    // Variável que receberá a instância da HomePage:
    HomePage homePage;

    @Before
    public void before() {
        // Configurações para estabilizar a sessão do Chrome no Linux (Zorin OS):
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Instanciação do driver passando as opções configuradas:
        driver = new ChromeDriver(options);

        // Espera implícita:
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Espera de carregamento de página:
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        // Instanciação dos Page Objects:
        cadastroPage = new CadastroPage(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        // Acessando a URL:
        driver.get("http://localhost:3000/#");
    }

    // Teste:
    @Test
    public void testeSaldoInicial() {
        //----------------------- Cadastro ----------------------------------------------
        // Clica no botão inicial 'Registrar' para abrir o formulário de cadastro na tela:
        cadastroPage.clicarPorXpath(cadastroPage.btnRegistrar);

        // Preenche o campo de e-mail com o endereço do usuário:
        cadastroPage.preencherValorPorXpath(cadastroPage.campoEmail, "qaction@gmail.com");

        // Preenche o campo de nome do usuário:
        cadastroPage.preencherValorPorXpath(cadastroPage.campoNome, "Tiago");

        // Preencher o campo de senha:
        cadastroPage.preencherValorPorXpath(cadastroPage.campoSenha, "senha123");

        // Preenche o campo de confirmação para validar a senha digitada:
        cadastroPage.preencherValorPorXpath(cadastroPage.campoConfirmacaoSenha, "senha123");

        // Clica no toggle para ativar a opção de criar a conta já com saldo inicial:
        cadastroPage.clicarPorXpath(cadastroPage.campoContaComSaldoToggle);

        // Clica no botão final 'Cadastrar' para submeter os dados do formulário:
        cadastroPage.clicarPorXpath(cadastroPage.btnCadastrar);

        // O method espera o modal, pega o texto interno e retorna para a variável:
        String textoModal = cadastroPage.obterTextoDoModal();

        // Valida se a mensagem esperada está contida na String capturada:
        Assert.assertTrue(textoModal.contains("foi criada com sucesso"));

        // Fechando o modal de confirmação do cadastro com o method clicarPorXpath,
        // que clica no elemento 'btnFecharModalSucessoDoCadastro':
        cadastroPage.clicarPorXpath(cadastroPage.btnFecharModalSucessoDoCadastro);

        //----------------------- Login com os dados do cadastro ------------------------
        // Preencher E-mail:
        loginPage.preencherCampo(loginPage.campoEmail, "qaction@gmail.com");

        // Preencher Senha:
        loginPage.preencherCampo(loginPage.campoSenha, "senha123");

        // Pressionar botão Acessar:
        loginPage.clicarPorXpath(loginPage.btnAcessar);

        // Validando login:
        loginPage.validarLogin();

        // Validando valor inicial do saldo:
        homePage.validarSaldo("R$ 1.000,00");
    }

    // Finalizando o recurso 'driver':
    @After
    public void after() {
        driver.quit();
    }
}



















