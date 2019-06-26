package DAO.Interfaces;

import java.util.ArrayList;

import DAO.Dominio.Cliente;
import DAO.Dominio.Compra;

public interface ClienteDAO {

	public void alta(Cliente cliente);
	public boolean baja(String nombre);
	public Cliente consulta(String nombre);
	public Cliente buscar(int id);
	public ArrayList<Cliente> getall();
	
	public boolean modificarNombre(String nombre, String nombrenuevo);
	public boolean añadircompra(String nombre, Compra compra);
	
	public float sumarCuenta(String nombre, int porcentajeInteres);
	public boolean pagoCuenta(String nombre);
	public float pagoCuentaParcial(String nombre, float pago);

}
