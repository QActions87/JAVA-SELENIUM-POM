package suite;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.LoginPage;

public class LoginTest {
    // Variável que receberá a instância e inicialização do ChromeDriver:
    WebDriver driver;
    // Variável que receberá a instância da classe LoginPage, passando o driver inicializado:
    LoginPage loginPage;

    @Before
    public void before() {
        // Instanciação do driver:
        driver = new ChromeDriver();
        // Instanciação da classe 'LoginPage' recebendo o driver inicializado como argumento:
        loginPage = new LoginPage(driver);
    }
}



















