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
        // Permite conexões WebSocket/HTTP de qualquer origem,
        // evitando erro de CORS/segurança de comunicação do ChromeDriver (necessário a partir do Chrome 111)
        options.addArguments("--remote-allow-origins=*");
        // Desativa o isolamento de segurança (sandbox) do Chrome;
        // essencial para rodar o navegador em ambiente Linux sem interface gráfica, containers Docker ou rotinas de CI/CD
        options.addArguments("--no-sandbox");
        // Força o Chrome a usar o diretório /tmp em vez de /dev/shm para memória compartilhada;
        // previne travamentos e crashes por falta de espaço em ambientes Linux/Docker
        options.addArguments("--disable-dev-shm-usage");
        // Instanciação do driver passando as opções configuradas:
        driver = new ChromeDriver(options);
        // define quanto tempo o Selenium deve esperar pelo carregamento completo do HTML da página ao dar um driver.get():
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        // Instâncias Page objects:
        loginPage = new LoginPage(driver);
        cadastroPage = new CadastroPage(driver);
        transferenciaPage = new TransferenciaPage(driver);
        homePage = new HomePage(driver);
    }
    //Testes:
    @Test
    public void testeTransferenciaComSucesso() {
        // Cadastrando duas contas:
        cadastroPage.cadastrarNovaConta("qaction@gmail.com", "Tiago", "senha123");
        cadastroPage.cadastrarNovaConta("qactionII@gmail.com", "Atom", "senha1234");

        // Fazendo login:
        loginPage.fazerLogin("qaction@gmail.com","senha123");
        // Clicando no botão 'Transferência' após o login:
        homePage.clicarPorXpath(homePage.btnTransferencia);
    }
}





















