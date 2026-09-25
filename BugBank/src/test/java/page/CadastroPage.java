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

    private WebDriver driver;

    // Atributos alterados para public para permitirem o acesso direto no teste (cadastroPage.conta)
    public String conta;
    public String digito;

    // Mapeamento dos elementos por Xpath
    public String btnRegistrar = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]";
    public String campoEmail = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input";
    public String campoNome = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[3]/input";
    public String campoSenha = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input";
    public String campoConfirmacaoSenha = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/input";
    public String campoContaComSaldoToggle = "//*[@id=\"toggleAddBalance\"]";
    public String btnCadastrar = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button";
    public String textoModalSucesso = "//*[@id=\"modalText\"]";
    public String btnFecharModalSucessoDoCadastro = "//*[@id=\"btnCloseModal\"]";

    // Construtor recebendo a referência do WebDriver
    public CadastroPage(WebDriver driver) {
        this.driver = driver;
    }

    // Getters mantidos para boa prática de encapsulamento
    public String getConta() {
        return conta;
    }

    public String getDigito() {
        return digito;
    }

    // Métodos auxiliares de interação
    public void preencherValorPorXpath(String elemento, String valor) {
        driver.findElement(By.xpath(elemento)).clear();
        driver.findElement(By.xpath(elemento)).sendKeys(valor);
    }

    public void clicarPorXpath(String xpath) {
        WebElement elemento = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemento);
    }

    public String obterTextoDoModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementoModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(textoModalSucesso)));
        return elementoModal.getText();
    }

    // Metodo 1: Cadastra conta COM saldo (clica no toggle de saldo)
    public String cadastrarNovaConta(String email, String nome, String senha) {
        clicarPorXpath(btnRegistrar);
        preencherValorPorXpath(campoEmail, email);
        preencherValorPorXpath(campoNome, nome);
        preencherValorPorXpath(campoSenha, senha);
        preencherValorPorXpath(campoConfirmacaoSenha, senha);

        // Ativa o toggle para adicionar saldo na conta
        clicarPorXpath(campoContaComSaldoToggle);
        clicarPorXpath(btnCadastrar);

        return processarModalExtrairDados();
    }

    // Metodo 2: Cadastra conta SEM saldo (NÃO clica no toggle de saldo)
    public String cadastrarNovaContaSemSaldo(String email, String nome, String senha) {
        clicarPorXpath(btnRegistrar);
        preencherValorPorXpath(campoEmail, email);
        preencherValorPorXpath(campoNome, nome);
        preencherValorPorXpath(campoSenha, senha);
        preencherValorPorXpath(campoConfirmacaoSenha, senha);

        // Sem o clique no campoContaComSaldoToggle
        clicarPorXpath(btnCadastrar);

        return processarModalExtrairDados();
    }

    // Metodo privado reutilizável para extrair o número da conta e dígito do modal
    private String processarModalExtrairDados() {
        String mensagemCadastro = obterTextoDoModal();

        Assert.assertTrue(mensagemCadastro.contains("foi criada com sucesso"));

        // Isola a estrutura "123-4" vinda do texto do modal
        String[] numConta = mensagemCadastro.split("conta | foi");
        String txtContaEDigito = numConta[1].trim();

        // Separa conta e dígito pelo hífen
        String[] contaDigito = txtContaEDigito.split("-");

        this.conta = contaDigito[0];
        this.digito = contaDigito[1];

        System.out.println("Conta extraída: " + this.conta);
        System.out.println("Dígito extraído: " + this.digito);

        clicarPorXpath(btnFecharModalSucessoDoCadastro);
        return mensagemCadastro;
    }
}






