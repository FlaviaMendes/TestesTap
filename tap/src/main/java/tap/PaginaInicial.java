package tap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaInicial {
	
	private WebDriver driver;

	public PaginaInicial(WebDriver driverUtilizado){
		driver = driverUtilizado;
	}

	public void abrir() {
		String url = "http://www.flytap.com/";
		driver.get(url);
	}

	public PaginaDetalheBagagem clicarBotaoBagagem() {
		String xpath = "//*[@id=\"GA_bagagem\"]";
		WebElement botaoBagagem = driver.findElement(By.xpath(xpath));
		botaoBagagem.click();
		
		return new PaginaDetalheBagagem(driver);
	}

}
