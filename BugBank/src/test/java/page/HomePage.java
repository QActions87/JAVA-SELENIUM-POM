package page;

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

    // Method para acessar e validar o saldo:
    public void validarSaldo() {
        driver.findElement(By.xpath(elementoSaldo)).getText();
    }
}

































