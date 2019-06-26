package DAO.Interfaces;

import java.util.ArrayList;

import DAO.Dominio.Tipo;

public interface TipoDAO {
	public void alta(Tipo tipo);
	public boolean baja(String nombre);
	public boolean modificacion(String nombre, String nombrenuevo);
	public Tipo consulta(String nombre);
	public String buscar(int id);
	public ArrayList<Tipo> getall();
}
