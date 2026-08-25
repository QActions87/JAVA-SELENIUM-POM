package suite;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CadastroPage;

public class CadastroTest {
    // Variável para receber a instância de ChromeDriver:
    WebDriver driver;
    // Variável para receber a instância de CadastroPage:
    CadastroPage cadastroPage;

    public void before(){
        // driver recebendo a instância do ChromeDriver():
        driver = new ChromeDriver();
        // cadastroPage recebendo a instância de CadastroPage:
        cadastroPage = new CadastroPage(driver);
    }
    // Teste de cadastro:
    @Test
    public void testeCadastro() {
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

























