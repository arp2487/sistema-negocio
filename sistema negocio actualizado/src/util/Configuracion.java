package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {
	public static String getProperty(String clase) {
		Properties prop = new Properties();
		File file = new File("rutas.properties");
		String ruta = "";
		
		try {
			prop.load(new FileInputStream(file));
			ruta = (String) prop.get(clase);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ruta;
	}
	
	public static void setProperties() {
		Properties pro = new Properties();
		File file = new File("rutas.properties");
		
		try {
			pro.load(new FileInputStream(file));
			pro.setProperty("cliente", "clientes.txt");
			pro.setProperty("compra", "compras.txt");
			pro.setProperty("marca", "marcas.txt");
			pro.setProperty("producto", "productos.txt");
			pro.setProperty("tipo", "tipos.txt");
			
			pro.store(new FileOutputStream(file), "primer seteo de archivo configuraciones");
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
