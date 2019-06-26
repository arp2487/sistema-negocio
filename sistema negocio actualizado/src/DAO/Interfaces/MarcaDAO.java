package DAO.Interfaces;

import java.util.ArrayList;

import DAO.Dominio.Marca;

public interface MarcaDAO {

	public void alta(Marca Marca);
	public boolean baja(String nombre);
	public boolean modificacion(String nombre, String nombrenuevo);
	public Marca consulta(String nombre);
	public String buscar(int id);
	public ArrayList<Marca> getall();
}
