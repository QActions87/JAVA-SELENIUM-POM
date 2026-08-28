package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    // Methods para interagir com os elementos mapeados por xpath:
    public void clicarPorXpath(String elemento) {
        driver.findElement(By.xpath(elemento)).click();
    }

    public void preencherCampo(String elemento, String valor) {
        driver.findElement(By.xpath(elemento)).sendKeys(valor) ;
    }

    // Method para validar login:
    public void validarLogin() {
        // Cria a espera explícita de até 10 segundos para a mudança de URL
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Aguarda especificamente até que a URL do navegador seja exatamente 'http://localhost:3000/home'
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/home"));

        // Opcional: Assert para confirmar após o término da espera
        Assert.assertEquals("http://localhost:3000/home", driver.getCurrentUrl());
    }
}











