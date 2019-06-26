package DAO.Dominio;

import java.io.Serializable;

public class Tipo implements Serializable{
	private int idtipo;
	private String nombre;
	private String nombreClase = "tipo";
	
	
	public Tipo(int idtipo, String nombre, String nombreClase) {
		super();
		this.idtipo = idtipo;
		this.nombre = nombre;
		this.nombreClase = nombreClase;
	}


	@Override
	public String toString() {
		return "Tipo [idtipo=" + idtipo + ", nombre=" + nombre + ", nombreClase=" + nombreClase + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idtipo;
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
		Tipo other = (Tipo) obj;
		if (idtipo != other.idtipo)
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


	public int getIdtipo() {
		return idtipo;
	}


	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
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


	public Tipo() {
	}
}
