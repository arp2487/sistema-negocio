package DAO.Interfaces;

import java.util.ArrayList;

import DAO.Dominio.Marca;
import DAO.Dominio.Producto;
import DAO.Dominio.Tipo;

public interface ProductoDAO {

	public void alta(Producto producto, int porcentajeganancia,int idmarca, int idtipo);
	public void alta(Producto producto, float ganancia,int idmarca,int idtipo);
	public boolean baja(String nombre, String nombremarca);
	public Producto consulta(String nombre,	String marca);
	public Producto buscar(int id);
	public ArrayList<Producto> getall();
	
	public boolean moficarnombre(String nombre,String marca, String nombrenuevo);
	public boolean modificarprecio(String nombre, String marca,float preciocompra, int porcentajeganancia);
	public boolean modificarprecio(String nombre,String marca, float preciocompra, float ganancia);
	public boolean modificartamaño(String nombre,String marca, String nuevotamaño);
	public boolean modificarmarca(String nombre, String marca,String marcanueva);
	public boolean modificartipo(String nombre,String marca, String tiponuevo);
	
	public float calcularPrecioVenta(float preciocompra, int porcentajeGanancia);
	public float calcularPrecioVenta(float preciocompra, float ganancia);
	
	public boolean aumentarProducto(String nombre,String marca, int aumento);
	public boolean aumentarTipo(String tipo, int aumento);
	public boolean aumentarMarca(String marca, int aumento);
	public boolean bajarProducto(String producto,String marca, int bajada);
	public boolean bajarTipo(String tipo, int bajada);
	public boolean bajarMarca(String marca, int bajada);
	
	
}
