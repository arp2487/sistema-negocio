package DAO.Interfaces;

import java.util.ArrayList;

import DAO.Dominio.Compra;

public interface CompraDAO {

	public boolean alta(String nombreproducto, String marcaproducto,Compra compra);
	public boolean baja(int idCompra);
	public Compra consulta(int IdCompra);
	public ArrayList<Compra> getall();
}
