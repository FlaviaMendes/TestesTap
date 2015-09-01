package tap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaLogin {
	
	private WebDriver driver;

	public PaginaLogin(WebDriver driverUtilizado){
		this.driver = driverUtilizado;
	}

	public void preencherNumeroVictoria(String numeroVictoria) {
		WebElement campoNumeroVictoria = driver.findElement(By.name("num_client_victoria"));
		campoNumeroVictoria.sendKeys(numeroVictoria);
	}

	public void preencherPin(String pin) {
		WebElement campoPin = driver.findElement(By.name("pin_client_victoria"));
		campoPin.sendKeys(pin);
		
	}

	public void logar() {
		WebElement botaoLogin = driver.findElement(By.id("loginvictoriabutton"));
		botaoLogin.click();
	}

	public boolean exibiuMensagemErro() {
		WebElement mensagem = driver.findElement(By.id("error_messages"));
		return mensagem.isDisplayed();
	}

	public String mensagemErroExibida() {
		WebElement mensagem = driver.findElement(By.id("error_messages"));
		return mensagem.getText();
	}

}
