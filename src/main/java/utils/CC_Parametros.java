package main.java.utils;

public interface CC_Parametros {
    String url = "https://demo.testfire.net/login.jsp";
    
    String nombreAutomatizador = "[Flujo-Automatizado]";
    String nombreProyecto = "[*Proyecto*]";
    
    String gloDir = "C:\\Estructura_Base\\CC_Logs_2p";
    
    //Archivo CSV con los datos de entrada
    int gloFilas = 1; //Total de Casos de Pruebas - NO incluye la fila 1 de Titulos
    int gloColumnas = 3;
    String gloNombreCSV = "CSVParametersCarritoCompras.csv";
    //Fin
}
