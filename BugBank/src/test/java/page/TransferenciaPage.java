package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TransferenciaPage {

    // Mapeamento dos elementos da tela de transferência via Xpath
    public String campoNumeroDaConta = "//body/div[@id='__next']/div[1]/div[3]/form[1]/div[1]/div[1]/input[1]";
    public String campoDigitoConta = "//body/div[@id='__next']/div[1]/div[3]/form[1]/div[1]/div[2]/input[1]";
    public String campoValor = "//body/div[@id='__next']/div[1]/div[3]/form[1]/div[2]/input[1]";
    public String campoDescricao = "//body/div[@id='__next']/div[1]/div[3]/form[1]/div[3]/input[1]";
    public String btnTransferir = "//button[contains(text(),'Transferir agora')]";

    WebDriver driver;

    // Construtor que recebe a instância ativa do WebDriver
    public TransferenciaPage(WebDriver driver) {
        this.driver = driver;
    }

    // Preenche os campos de texto localizando o elemento pelo Xpath
    public void preencherValorPorXpath(String elemento, String valor) {
        driver.findElement(By.xpath(elemento)).sendKeys(valor);
    }

    // Aguarda até o elemento estar visível na tela e clica nele
    public void clicarPorXpath(String elemento) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> d.findElement(By.xpath(elemento)).isDisplayed());
        driver.findElement(By.xpath(elemento)).click();
    }

    // Valida a mensagem de sucesso consultando diretamente o código-fonte HTML da página
    public void validarTransferenciaSucesso() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> d.getPageSource().contains("Transferencia realizada com sucesso"));
        Assert.assertTrue("Erro ao validar a transferencia!", driver.getPageSource().contains("Transferencia realizada com sucesso"));
    }

    /** Valida a mensagem de ERRO na transferência, ao tentar transferir sem saldo o suficiente. */
    public void validarErroNaTransferencia() {
        String mensagemDeErro = "Você não tem saldo suficiente para essa transação";
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> d.getPageSource().contains(mensagemDeErro));
        Assert.assertTrue("Erro ao validar a transferencia!", driver.getPageSource().contains(mensagemDeErro));
    }
}








