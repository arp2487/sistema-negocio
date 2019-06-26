package DAO.Factory;

import DAO.Implementaciones.ProductoDAOimplArchivo;
import DAO.Implementaciones.ProductoDAOimplBD;
import DAO.Interfaces.ProductoDAO;

public class FactoryProducto {
	public static ProductoDAO getDAO(String source) {
		if(source.equals("archivo") == true) {
			return new ProductoDAOimplArchivo();
		}
		if(source.equals("BD") == true) {
			return new ProductoDAOimplBD();
		}
		return null;
	}
}
