package page;

import org.openqa.selenium.WebDriver;

public class CadastroPage {
    // Declarando web driver:
    WebDriver driver;
    // Mapeamento dos elementos da paǵina de cadastro:
    public String email = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input";
    public String nome = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[3]/input";
    public String senha = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input";
    public String confirmacaoSenha = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/input";
    public String contaComSaldoToggle = "//*[@id=\"toggleAddBalance\"]";
    public String btnCadastrar = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button";
}
