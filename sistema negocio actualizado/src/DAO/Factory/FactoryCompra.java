package DAO.Factory;

import DAO.Implementaciones.ClienteDAOimplArchivo;
import DAO.Implementaciones.CompraDAOimplArchivo;
import DAO.Implementaciones.CompraDAOimplBD;
import DAO.Interfaces.CompraDAO;

public class FactoryCompra {
	public static CompraDAO getDAO(String source) {
		if(source.equals("archivo") == true) {
			return new CompraDAOimplArchivo();
		}
		if(source.equals("BD") == true) {
			return new CompraDAOimplBD();
		}
		return null;
	}
}
