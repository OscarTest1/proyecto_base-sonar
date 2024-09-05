package main.java.pageObjects;
//Dentro de esta clase se almacenaran todos los localizadores que se ocuparan.
public interface CC_Localizadores {

	// LogIn
	String inputUsuario = "//*[@id=\"uid\"]"; //XPATH
	String inputContrasena = "//*[@id=\"passw\"]"; //XPATH
	String buttonIniciarSesion = "//*[@id=\"login\"]/table/tbody/tr[3]/td[2]/input"; //XPATH
	
	//Label 
	String LabelSesionIniciada = "/html/body/table[2]/tbody/tr/td[2]/div/h1";
	String LabelMontoTransferido = "//*[@id=\"_ctl0__ctl0_Content_Main_postResp\"]/span";
	// Transferencia
	String buttonTransferFunds = "//*[@id=\"MenuHyperLink3\"]";
	String inputFromAccount = "//*[@id=\"fromAccount\"]";
	String inputToAccount= "//*[@id=\"toAccount\"]";
	String inputAmountTransfer= "//*[@id=\"transferAmount\"]";
	String buttonTransferMoney= "//*[@id=\"transfer\"]";
	String buttonSignOff = "//*[@id=\"LoginLink\"]/font";
	

}