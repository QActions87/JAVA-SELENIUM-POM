package suite;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.LoginPage;

import java.time.Duration;

public class LoginTest {
    // Variável que receberá a instância e inicialização do ChromeDriver:
    WebDriver driver;
    // Variável que receberá a instância da classe LoginPage, passando o driver inicializado:
    LoginPage loginPage;

    @Before
    public void before() {
        // Instanciação do driver:
        driver = new ChromeDriver();
        // Espera implícita, antes de falhar o teste:
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Espera até 5 segundos o carregamento da página:
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        // Instanciação da classe 'LoginPage' recebendo o driver inicializado como argumento:
        loginPage = new LoginPage(driver);
        // Acessando URL:
        driver.get("http://localhost:3000/#");
    }

    // Teste:
    @Test
    public void testeLogin() {
        loginPage.preencherCampo(loginPage.campoEmail, "qaction@gmail.com");
        loginPage.preencherCampo(loginPage.campoSenha, "senha123");
        loginPage.clicarPorXpath(loginPage.btnAcessar);
    }
}



















