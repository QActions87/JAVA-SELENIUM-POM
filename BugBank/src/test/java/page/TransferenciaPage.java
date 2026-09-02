package page;

import org.openqa.selenium.WebDriver;

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
}
