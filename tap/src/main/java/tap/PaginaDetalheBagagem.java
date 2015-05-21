package tap;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaginaDetalheBagagem {

	private WebDriver driver;

	public PaginaDetalheBagagem(WebDriver driverUtilizado) {
		this.driver = driverUtilizado;
	}

	public int quantidadeBagagem() {
		List<WebElement> listaBagagem = driver.findElements(By.id("checkin_opt"));
		
		return listaBagagem.size();
	}

	public PaginaDetalheBagagem clicarBotaoBagagemMao() {
		String xpath = "//*[@id=\"2ebb6b00e59f5fcc8c9d5ac99970bb4d\"]/span[1]/img";
		WebElement bagagemDeMao = driver.findElement(By.xpath(xpath));
		bagagemDeMao.click();
		
		System.out.println("Url atual: " + driver.getCurrentUrl());
		
		return new PaginaDetalheBagagem(driver);
	}

	public String obterTituloDaPagina() {
		String xpath = "//*[@id=\"1676a7acbe38e20157fcf190a2f4abf4_50afb0bb0385fd3ffd96743947c73ee8\"]/div/div/div/h2[1]/strong";
		WebElement tituloDaPagina = driver.findElement(By.xpath(xpath));
		
		return tituloDaPagina.getText();
	}

	

}
