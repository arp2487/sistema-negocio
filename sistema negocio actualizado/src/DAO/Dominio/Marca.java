package DAO.Dominio;

import java.io.Serializable;

public class Marca implements Serializable{
	private int idmarca;
	private String nombre;
	private String nombreClase = "marca";
	
	
	public Marca(int idmarca, String nombre, String nombreClase) {
		super();
		this.idmarca = idmarca;
		this.nombre = nombre;
		this.nombreClase = nombreClase;
	}


	@Override
	public String toString() {
		return "Marca [idmarca=" + idmarca + ", nombre=" + nombre + ", nombreClase=" + nombreClase + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idmarca;
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
		Marca other = (Marca) obj;
		if (idmarca != other.idmarca)
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


	public int getIdmarca() {
		return idmarca;
	}


	public void setIdmarca(int idmarca) {
		this.idmarca = idmarca;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNombreClase() {
		return nombreClase;
	}


	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}


	public Marca() {
	}

	
	
}
