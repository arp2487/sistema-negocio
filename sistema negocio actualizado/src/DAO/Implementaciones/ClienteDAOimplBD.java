package DAO.Implementaciones;

import java.util.ArrayList;

import DAO.Dominio.Cliente;
import DAO.Dominio.Compra;
import DAO.Interfaces.ClienteDAO;

public class ClienteDAOimplBD implements ClienteDAO {

	@Override
	public void alta(Cliente cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean baja(String nombre) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Cliente consulta(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Cliente> getall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float sumarCuenta(String nombre, int porcentajeInteres) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean pagoCuenta(String nombre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float pagoCuentaParcial(String nombre, float pago) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean modificarNombre(String nombre, String nombrenuevo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean añadircompra(String nombre, Compra compra) {
		// TODO Auto-generated method stub
		return false;
	}

}
