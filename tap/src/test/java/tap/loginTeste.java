package tap;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginTeste {
	
	private static WebDriver driver;
	private PaginaInicial paginaInicial;
	private PaginaLogin paginaLogin;

	@BeforeClass
	public static void antesDeTodosOsTestes(){
		AssistenteTeste.carregarPropriedadeChrome();
		driver = new ChromeDriver();
	}
	
	@Before
	public void antesDeCadaTeste(){
		paginaInicial = new PaginaInicial(driver);
		paginaInicial.abrir();
		
		paginaLogin = paginaInicial.clicarBotaoLogin();
	}
	
	@AfterClass
	public static void depoisDeTodosOsTestes(){
		driver.quit();
	}

	@Test
	public void fazerLogin (){
		paginaLogin.preencherNumeroVictoria("1231231");
		paginaLogin.preencherPin("123");
		paginaLogin.logar();
				
		String mensagemEsperada = "Blablabla";
		Assert.assertEquals(mensagemEsperada , paginaLogin.mensagemErroExibida());
		Assert.assertTrue(paginaLogin.exibiuMensagemErro());
	}
}
