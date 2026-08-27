package suite;

import org.junit.After;
import org.junit.Assert;
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
    }

    @After
    public void after() {
        driver.quit();
    }
}

























