package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferenciaPage {
    // Mapeia os elementos dos campos e botão da página Transferência:
    String campoNumeroDaConta = "//*[@id=\"__next\"]/div/div[3]/form/div[1]/div[1]/input";
    String campoDigitoConta = "//*[@id=\"__next\"]/div/div[3]/form/div[1]/div[2]/input";
    String campoValor = "//*[@id=\"__next\"]/div/div[3]/form/div[2]/input";
    String campoDescricao = "//*[@id=\"__next\"]/div/div[3]/form/div[3]/input";
    String btnTransferir = "//*[@id=\"__next\"]/div/div[3]/form/button";

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

    // Method para clicar por xpath:
    /** Clique Direto via JavaScript:
     * Se o formulário tiver algum footer fixo ou modal invisível por cima do botão,
     * o clique nativo do Selenium falha. Com esta solução,
     * o JavaScript ignora a camada visual e dispara o evento direto no DOM. */
    public void clicarPorXpath(String xpath) {
        WebElement elemento = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemento);
    }
}
