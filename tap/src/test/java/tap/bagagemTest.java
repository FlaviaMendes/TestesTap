package tap;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class bagagemTest {
	
	private static WebDriver driver;
	private PaginaInicial paginaInicial;
	private PaginaDetalheBagagem paginaBagagem;

	@BeforeClass
	public static void antesDeTodosOsTestes(){
		AssistenteTeste.carregarPropriedadeChrome();
		driver = new ChromeDriver();
	}

	@Before
	public void antesDeCadaTeste(){
		paginaInicial = new PaginaInicial(driver);
		paginaInicial.abrir();
		
		paginaBagagem = paginaInicial.clicarBotaoBagagem();
	}
	
	@AfterClass
	public static void depoisDeTodosOsTestes(){
		driver.quit();
	}
	
	@Test
	public void exibirNoveModulosPaginaBagagem(){
		int quantidadeExibida = paginaBagagem.quantidadeBagagem();
		int quantidadeEsperada = 9;
		assertEquals(quantidadeEsperada, quantidadeExibida);
	}
	
	@Test
	public void verInformacoesBagagemDeMao(){
		PaginaDetalheBagagem detalhes = paginaBagagem.clicarBotaoBagagemMao();
		
		String tituloExibido = detalhes.obterTituloDaPagina();
		String tituloEsperado = "Bagagem de mão autorizada";
		assertEquals(tituloEsperado, tituloExibido);
	}
	
	
	
	
	

}
