package main.java.pageEvents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import main.java.pageObjects.CC_Localizadores;
import main.java.utils.GG_ElementFetch;
import main.java.utils.GG_Eventos;
import main.java.utils.GG_Utils;
import main.java.utils.GG_Validations;
import test.java.carritocompras.CC_Test;

//En esta clase se ejecutan los Pasos de la P�gina.
public class CC_PasosFuncionales extends CC_Test {

	public CC_PasosFuncionales(WebDriver driver) {
		CC_Test.driver = driver;
	}

	public static void iniciarSesion(String usuario, String contrasena, String xNumero) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();

			Thread.sleep(1000);

			// Se escribe el Nombre del Usuario
			WebElement inputNombreUsuarioElement = elementFetch.getWebElement("XPATH", CC_Localizadores.inputUsuario);
			wait.until(ExpectedConditions.visibilityOf(inputNombreUsuarioElement));
			GG_Eventos.writeOnInput(inputNombreUsuarioElement, usuario);

			Thread.sleep(3000);

			// Se escribe la Contrase�a
			WebElement inputContrasenaElement = elementFetch.getWebElement("XPATH", CC_Localizadores.inputContrasena);
			wait.until(ExpectedConditions.visibilityOf(inputContrasenaElement));
			GG_Eventos.writeOnInput(inputContrasenaElement, contrasena);

			Thread.sleep(3000);

			// Click en Bot�n rojo LOGIN
			WebElement buttonIniciarSesionElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores.buttonIniciarSesion);
			wait.until(ExpectedConditions.elementToBeClickable(buttonIniciarSesionElement));
			GG_Eventos.clickButton(buttonIniciarSesionElement);

			Thread.sleep(2000);

			// Verific� si se lleg� a la segunda pantalla.
			WebElement labelPaginaProductosElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores.LabelSesionIniciada);
			wait.until(ExpectedConditions.visibilityOf(labelPaginaProductosElement));
			String textoPagina = labelPaginaProductosElement.getText();

			GG_Validations.trueBooleanCondition(textoPagina.equalsIgnoreCase("Hello John Smith"),
					"Hello John Smith " + textoPagina,
					"Login Failed: We're sorry, but this username or password was not found in our system. Please try again. ", currentEvent);

		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}
	
	public static void TransferFunds(String Monto, String xNumero) {

		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();

			Thread.sleep(1000);

			// Click en Bot�n de transfer funds
			WebElement buttonTransferFundsElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores.buttonTransferFunds);
			wait.until(ExpectedConditions.elementToBeClickable(buttonTransferFundsElement));
			GG_Eventos.clickButton(buttonTransferFundsElement);

			Thread.sleep(2000);
			
			//Seleccionar desde que de cuenta enviar
			Select inputFromAccount = new Select(driver.findElement(By.id("fromAccount")));
			inputFromAccount.selectByValue("800003");
			
			Thread.sleep(2000);
			
			//Seleccionar a que cuenta enviar
			Select inputToAccount = new Select(driver.findElement(By.id("toAccount")));
			inputToAccount.selectByValue("4539082039396288");
			
			Thread.sleep(2000);
			
			//Monto a transferir
			WebElement inputAmountTransfer = elementFetch.getWebElement("XPATH", CC_Localizadores.inputAmountTransfer);
			wait.until(ExpectedConditions.visibilityOf(inputAmountTransfer));
			GG_Eventos.writeOnInput(inputAmountTransfer, Monto);
			
			//Click en boton transferir
			WebElement buttonTransferMoney = elementFetch.getWebElement("XPATH",
					CC_Localizadores.buttonTransferMoney);
			wait.until(ExpectedConditions.elementToBeClickable(buttonTransferMoney));
			GG_Eventos.clickButton(buttonTransferMoney);
			
			Thread.sleep(2000);
			
			//Verificar que se mando el monto emitido
			
			WebElement LabelMontoTransferidoElement = elementFetch.getWebElement("XPATH",
					CC_Localizadores.LabelMontoTransferido);
			
			String test = LabelMontoTransferidoElement.getText();
			
			Assert.assertEquals(Monto,test.substring(0,3) );
			
			// Click en SignOff
			
			WebElement buttonSignOff = elementFetch.getWebElement("XPATH",
					CC_Localizadores.buttonSignOff);
			wait.until(ExpectedConditions.elementToBeClickable(buttonSignOff));
			GG_Eventos.clickButton(buttonSignOff);
			

		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}
}
