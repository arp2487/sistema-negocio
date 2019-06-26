package DAO.Factory;

import DAO.Implementaciones.MarcaDAOimplArchivo;
import DAO.Implementaciones.MarcaDAOimplBD;
import DAO.Interfaces.MarcaDAO;

public class FactoryMarca {
	public static MarcaDAO getDAO(String source) {
		if(source.equals("archivo") == true) {
			return new MarcaDAOimplArchivo();
		}
		if(source.equals("BD") == true) {
			return new MarcaDAOimplBD();
		}
		return null;
	}
}
