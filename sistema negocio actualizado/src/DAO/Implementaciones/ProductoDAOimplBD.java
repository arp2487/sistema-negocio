package DAO.Implementaciones;

import java.util.ArrayList;

import DAO.Dominio.Marca;
import DAO.Dominio.Producto;
import DAO.Dominio.Tipo;
import DAO.Interfaces.ProductoDAO;

public class ProductoDAOimplBD implements ProductoDAO {

	@Override
	public void alta(Producto producto, int porcentajeganancia, int idmarca, int idtipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alta(Producto producto, float ganancia, int idmarca, int idtipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean baja(String nombre, String nombremarca) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Producto consulta(String nombre, String marca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Producto> getall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean moficarnombre(String nombre, String marca, String nombrenuevo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarprecio(String nombre, String marca, float preciocompra, int porcentajeganancia) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarprecio(String nombre, String marca, float preciocompra, float ganancia) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificartamaño(String nombre, String marca, String nuevotamaño) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarmarca(String nombre, String marca, String marcanueva) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificartipo(String nombre, String marca, String tiponuevo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float calcularPrecioVenta(float preciocompra, int porcentajeGanancia) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float calcularPrecioVenta(float preciocompra, float ganancia) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean aumentarProducto(String nombre, String marca, int aumento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean aumentarTipo(String tipo, int aumento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean aumentarMarca(String marca, int aumento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bajarProducto(String producto, String marca, int bajada) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bajarTipo(String tipo, int bajada) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bajarMarca(String marca, int bajada) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
