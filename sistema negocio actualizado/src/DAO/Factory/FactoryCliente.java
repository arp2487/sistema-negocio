package DAO.Factory;

import DAO.Implementaciones.ClienteDAOimplArchivo;
import DAO.Implementaciones.ClienteDAOimplBD;
import DAO.Interfaces.ClienteDAO;

public class FactoryCliente {
	public static ClienteDAO getDAO(String source) {
		if(source.equals("archivo") == true) {
			return new ClienteDAOimplArchivo();
		}
		if(source.equals("BD") == true) {
			return new ClienteDAOimplBD();
		}
		return null;
	}
}
