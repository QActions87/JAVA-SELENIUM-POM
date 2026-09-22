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

    // Atributos de Estado para armazenar os dados extraídos do cadastro
    private String conta;
    private String digito;

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

    // Getters encapsulados para acessar a conta e o dígito após a execução do cadastro
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

    // Method para realizar o fluxo de cadastro e separar a conta do dígito
    public String cadastrarNovaConta(String email, String nome, String senha) {
        clicarPorXpath(btnRegistrar);
        preencherValorPorXpath(campoEmail, email);
        preencherValorPorXpath(campoNome, nome);
        preencherValorPorXpath(campoSenha, senha);
        preencherValorPorXpath(campoConfirmacaoSenha, senha);
        clicarPorXpath(campoContaComSaldoToggle);
        clicarPorXpath(btnCadastrar);

        // 1. Obtém a mensagem de sucesso usando o Explicit Wait
        String mensagemCadastro = obterTextoDoModal();

        // 2. Valida se o modal realmente abriu confirmando a criação da conta
        Assert.assertTrue(mensagemCadastro.contains("foi criada com sucesso"));

        // 3. Separa a mensagem para isolar a estrutura "123-4" (Lógica do Print do Professor)
        String[] numConta = mensagemCadastro.split("conta | foi");
        String txtContaEDigito = numConta[1].trim();

        // 4. Separa a conta do dígito pelo hífen
        String[] contaDigito = txtContaEDigito.split("-");

        // 5. Guarda nos atributos de instância da classe
        this.conta = contaDigito[0];
        this.digito = contaDigito[1];

        // Debug no terminal para ver os valores separados
        System.out.println("Conta extraída: " + this.conta);
        System.out.println("Dígito extraído: " + this.digito);

        // 6. Fecha o modal de confirmação no final
        clicarPorXpath(btnFecharModalSucessoDoCadastro);
        return mensagemCadastro;
    }
}







