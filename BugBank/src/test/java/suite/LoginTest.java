package suite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CadastroPage;
import page.LoginPage;

import java.time.Duration;

public class LoginTest {
    // Variável que receberá a instância e inicialização do ChromeDriver:
    WebDriver driver;
    // Variável que receberá a instância da classe LoginPage, passando o driver inicializado:
    LoginPage loginPage;
    // Variável do tipo CadastroPage para receber uma instância e cadastrar antes do teste de login:
    CadastroPage cadastroPage;

    @Before
    public void before() {
        // Instanciação do driver:
        driver = new ChromeDriver();
        // Espera implícita, antes de falhar o teste:
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Espera até 5 segundos o carregamento da página:
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        // Variável 'cadastroPage' recebendo a instância e criando o objeto recebendo o driver:
        cadastroPage = new CadastroPage(driver);
        // Instanciação da classe 'LoginPage' recebendo o driver inicializado como argumento:
        loginPage = new LoginPage(driver);
        // Acessando URL:
        driver.get("http://localhost:3000/#");
    }

    // Teste:
    @Test
    public void testeLogin() {
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
    }
}



















