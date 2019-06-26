package DAO.Dominio;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable{
	private int idCliente;
	private String nombreClase = "cliente";
	private float cuenta = 0;
	private ArrayList<Compra> compras;
	private String nombre;
	
	public Cliente(int idCliente, String nombreClase, float cuenta, ArrayList<Compra> compras, String nombre) {
		super();
		this.idCliente = idCliente;
		this.nombreClase = nombreClase;
		this.cuenta = cuenta;
		this.compras = compras;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombreClase=" + nombreClase + ", cuenta=" + cuenta + ", compras="
				+ compras + ", nombre=" + nombre + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compras == null) ? 0 : compras.hashCode());
		result = prime * result + Float.floatToIntBits(cuenta);
		result = prime * result + idCliente;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((nombreClase == null) ? 0 : nombreClase.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (compras == null) {
			if (other.compras != null)
				return false;
		} else if (!compras.equals(other.compras))
			return false;
		if (Float.floatToIntBits(cuenta) != Float.floatToIntBits(other.cuenta))
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (nombreClase == null) {
			if (other.nombreClase != null)
				return false;
		} else if (!nombreClase.equals(other.nombreClase))
			return false;
		return true;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreClase() {
		return nombreClase;
	}

	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}

	public float getCuenta() {
		return cuenta;
	}

	public void setCuenta(float cuenta) {
		this.cuenta = cuenta;
	}

	public ArrayList<Compra> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Compra> compras) {
		this.compras = compras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Cliente(){
		this.compras = new ArrayList(); 
	}
}
