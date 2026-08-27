package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    // Mapeamento da página de Login:
    public String campoEmail = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[1]/input";
    public String campoSenha = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[2]/div/input";
    public String btnAcessar= "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[1]";

    // Driver para o driver da classe de teste, por meio do construtor:
    WebDriver driver;

    /** Construtor que recebe o driver dda página de testes por parâmetro.
     * Depois, injeta este parâmetro no atributo da classe LoginPage: */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods para interagir com os elementos mapeados:
    public void clicarPorXpath() {

    }

    public void preencherCampo(String elemento, String valor) {
        driver.findElement(By.xpath(elemento)).sendKeys("qaction@gmail.com") ;
    }
}
