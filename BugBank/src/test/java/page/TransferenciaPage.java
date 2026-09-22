package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferenciaPage {

    // Mapeia os elementos dos campos e botão da página Transferência:
    public String campoNumeroDaConta = "//body/div[@id='__next']/div[1]/div[3]/form[1]/div[1]/div[1]/input[1]";
    public String campoDigitoConta = "//body/div[@id='__next']/div[1]/div[3]/form[1]/div[1]/div[2]/input[1]";
    public String campoValor = "//body/div[@id='__next']/div[1]/div[3]/form[1]/div[2]/input[1]";
    public String campoDescricao = "//body/div[@id='__next']/div[1]/div[3]/form[1]/div[3]/input[1]";
    public String btnTransferir = "//button[contains(text(), 'Transferir agora')]";

    // Variável de referência do WebDriver:
    WebDriver driver;

    // Construtor com injeção do WebDriver:
    public TransferenciaPage(WebDriver driver) {
        this.driver = driver;
    }

    // Metodo para preencher os valores nos campos digitáveis:
    public void preencherValorPorXpath(String elemento, String valor) {
        driver.findElement(By.xpath(elemento)).sendKeys(valor);
    }

    // Metodo genérico para clicar aguardando o elemento estar visível via expressão Lambda:
    public void clicarPorXpath(String elemento) {
        // Declaração do Wait usando a interface genérica Wait<WebDriver>
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Aguarda até que o elemento esteja visível no DOM usando a sintaxe de expressão Lambda
        wait.until(d -> d.findElement(By.xpath(elemento)).isDisplayed());

        // Dispara o clique no elemento
        driver.findElement(By.xpath(elemento)).click();
    }

    // Metodo para validar se a transferência foi efetuada com sucesso:
    public void validarTransferenciaComSucesso() {
        // 1. Cria a espera dinâmica de até 5 segundos
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // 2. Aguarda até que o código fonte do HTML (getPageSource) contenha a frase informada
        wait.until(d -> d.getPageSource().contains("Transferencia realizada com sucesso"));

        // 3. Realiza a asserção final verificando se o texto está no código fonte do HTML
        Assert.assertTrue("Erro ao validar a transferencia!", driver.getPageSource().contains("Transferencia realizada com sucesso"));
    }
}