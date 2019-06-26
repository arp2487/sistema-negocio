package DAO.Factory;

import DAO.Implementaciones.TipoDAOimplArchivo;
import DAO.Implementaciones.TipoDAOimplBD;
import DAO.Interfaces.TipoDAO;

public class FactoryTipo {

	public static TipoDAO getDAO(String source) {
		if(source.equals("archivo") == true) {
			return new TipoDAOimplArchivo();
		}
		if(source.equals("BD") == true) {
			return new TipoDAOimplBD();
		}
		return null;
	}
}
