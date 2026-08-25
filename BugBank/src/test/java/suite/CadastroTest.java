package suite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CadastroPage;

public class CadastroTest {
    // Variável para receber a instância de ChromeDriver:
    WebDriver driver;
    // Variável para receber a instância de CadastroPage:
    CadastroPage cadastroPage;

    public void before(){
        //
        driver = new ChromeDriver();
        // cadastroPage recebendo a instância de CadastroPage:
        cadastroPage = new CadastroPage();

    }
}

























