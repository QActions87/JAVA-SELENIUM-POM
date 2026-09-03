package suite;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CadastroPage;
import page.HomePage;
import page.LoginPage;
import page.TransferenciaPage;

import java.time.Duration;

public class TransferenciaTest {
    // Atributos driver e variáveis que receberão as instâncias das Page Objects,
    // para proverem os passos anteriores a transferẽncia:
    WebDriver driver;
    LoginPage loginPage;
    CadastroPage cadastroPage;
    HomePage homePage;
    TransferenciaPage transferenciaPage;

    // Preparando o ambiente:
    @Before
    public void before() {
        // Configurações para estabilizar a sessão do Chrome no Linux (Zorin OS):
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Instanciação do driver passando as opções configuradas:
        driver = new ChromeDriver(options);
        // define quanto tempo o Selenium deve esperar pelo carregamento completo do HTML da página ao dar um driver.get():
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
        cadastroPage = new CadastroPage(driver);
        transferenciaPage = new TransferenciaPage(driver);
        homePage = new HomePage(driver);
    }

    //Testes:
    @Test
    public void testeTransferenciaComSucesso() {

    }
}





















