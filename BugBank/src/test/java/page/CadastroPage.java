package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CadastroPage {
    // Declarando web driver:
    WebDriver driver;
    // Mapeamento do Xpath do texto no modal do BugBank
    public String textoModalSucesso = "//*[@id=\"modalText\"]";
    /** Method construtor com o driver desta classe recebendo o drive de fora, recebido no parâmetro: */
    public CadastroPage(WebDriver driver) {
        this.driver = driver;
    }

    /** Method para esperar o modal aparecer e capturar a mensagem: */
    public String obterTextoDoModal() {
        // 1. Cria a espera explícita de até 10 segundos:
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // 2. Aguarda até que o elemento do modal esteja visível na tela:
        WebElement elementoModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(textoModalSucesso)));
        // 3. Captura e retorna o texto contido dentro da tag HTML:
        return elementoModal.getText();
    }

    // Mapeamento dos elementos da paǵina de cadastro:
    public  String btnRegistrar = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]";
    public String campoEmail = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input";
    public String campoNome = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[3]/input";
    public String campoSenha = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input";
    public String campoConfirmacaoSenha = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/input";
    public String campoContaComSaldoToggle = "//*[@id=\"toggleAddBalance\"]";
    public String btnCadastrar = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button";

    // Method para preencher o campo Email:
    public void preencherValorPorXpath(String elemento, String valor) {
        driver.findElement(By.xpath(elemento)).sendKeys(valor);
    }


    // Method para clicar no toggle e botão 'Cadastrar':
    /** Clique Direto via JavaScript:
     * Se o formulário tiver algum footer fixo ou modal invisível por cima do botão,
     * o clique nativo do Selenium falha. Com esta solução,
     * o JavaScript ignora a camada visual e dispara o evento direto no DOM. */
    public void clicarPorXpath(String xpath) {
        WebElement elemento = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemento);
    }

    /*
    // O 'getPageSource()' baixa o HTML da página para fazer a busca em texto bruto, sendo mais custoso para a memória.
    // Substituido pelo assertion no próprio teste:
    public void validarCriacaoDeContaComSucesso() {
        // Assert do JUnit:
        Assert.assertTrue(driver.getPageSource().contains("foi criada com sucesso"));
    }

    */
}










