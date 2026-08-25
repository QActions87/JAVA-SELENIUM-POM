package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroPage {
    // Declarando web driver:
    WebDriver driver;
    // Criando o method construtor com o driver desta classe recebendo o drive de fora, recebido no parâmetro:
    public CadastroPage(WebDriver driver) {
        this.driver = driver;
    }
    // Mapeamento dos elementos da paǵina de cadastro:
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
    public void clicarPorXpath(String elemento) {
        driver.findElement(By.xpath(elemento)).click();
    }
}
