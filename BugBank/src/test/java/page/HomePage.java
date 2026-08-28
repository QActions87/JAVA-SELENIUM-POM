package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    // Variável para receber o driver inicializado da classe de teste por meio do construtor:
    WebDriver driver;

    // Mapeando o soldo na home:
    public String elementoSaldo = "//*[@id=\"textBalance\"]/span";

    // Construtor:
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method para acessar e validar o saldo (Valor esperado vindo do teste):
    public void validarSaldo(String valorEsperado) {
        String valorAtual = driver.findElement(By.xpath(elementoSaldo)).getText();
        Assert.assertEquals(valorEsperado, valorAtual);
    }
    /*
    // Method para acessar e validar o saldo (Valor esperado chumbado):
    public void validarSaldo() {
        String valorAtual = driver.findElement(By.xpath(elementoSaldo)).getText();
        String valorEsperado = "R$ 1.000,00";
        // Valida se a mensagem esperada está contida na String capturada:
        Assert.assertTrue(valorAtual.contains(valorEsperado));
    }
    */
}

































