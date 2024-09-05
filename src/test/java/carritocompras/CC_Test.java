package test.java.carritocompras;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import main.java.pageEvents.CC_PasosFuncionales;
import main.java.utils.GG_OpenCSV;
import main.java.utils.GG_Utils;
import test.java.GG_BaseTest;
import main.java.utils.CC_Parametros;

//Clase que contiene los Pasos Funcionales automatizados
public class CC_Test extends GG_BaseTest {

	@Test(enabled = true, dataProvider = "carritoComprasData")
	public void CC_QA_Automatizacion(String args[]) throws InterruptedException {

		GG_Utils.infoTestCase("Carrito de compras",
				"Validar la generacion de una compra al agregar un producto al carrito de compras");

		CC_PasosFuncionales.iniciarSesion(args[0], args[1], "1");
		CC_PasosFuncionales.TransferFunds(args[2],"2");
	}
	
	@DataProvider(name = "carritoComprasData")
	public Object[][] dataBrokerAPAlternative() throws CsvValidationException, InterruptedException, IOException {

		int xFilas = CC_Parametros.gloFilas;
		int xColumnas = CC_Parametros.gloColumnas;
		
		Object[][] data = GG_OpenCSV.getCSVParameters(CC_Parametros.gloNombreCSV, xFilas, xColumnas);
		return data;
	}
}
