package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferenciaPage {
    // Mapeia os elementos dos campos e botão da página Transferência:
    public String campoNumeroDaConta = "//*[@id=\"__next\"]/div/div[3]/form/div[1]/div[1]/input";
    public String campoDigitoConta = "//*[@id=\"__next\"]/div/div[3]/form/div[1]/div[2]/input";
    public String campoValor = "//*[@id=\"__next\"]/div/div[3]/form/div[2]/input";
    public String campoDescricao = "//*[@id=\"__next\"]/div/div[3]/form/div[3]/input";
    public String btnTransferir = "//*[@id=\"__next\"]/div/div[3]/form/button";

    // Variável para receber o driver inicializado da classe de teste por meio do construtor:
    WebDriver driver;

    // Construtor:
    public TransferenciaPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method para preencher o campo Email:
    public void preencherValorPorXpath(String elemento, String valor) {
        driver.findElement(By.xpath(elemento)).sendKeys(valor);
    }

    // Metodo genérico para clicar aguardando o elemento ficar clicável
    public void clicarPorXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        elemento.click();
    }
}
