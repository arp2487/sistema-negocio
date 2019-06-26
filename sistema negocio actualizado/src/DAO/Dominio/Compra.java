package DAO.Dominio;

import java.io.Serializable;

public class Compra implements Serializable{
	private int idcompra;
	private String nombreClase = "compra";
	private Producto producto;
	private Fecha fecha;
	public int getIdcompra() {
		return idcompra;
	}
	public void setIdcompra(int idcompra) {
		this.idcompra = idcompra;
	}
	public String getNombreClase() {
		return nombreClase;
	}
	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Fecha getFecha() {
		return fecha;
	}
	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	
	public Compra() {
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + idcompra;
		result = prime * result + ((nombreClase == null) ? 0 : nombreClase.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
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
		Compra other = (Compra) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idcompra != other.idcompra)
			return false;
		if (nombreClase == null) {
			if (other.nombreClase != null)
				return false;
		} else if (!nombreClase.equals(other.nombreClase))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Compra [idcompra=" + idcompra + ", nombreClase=" + nombreClase + ", producto=" + producto + ", fecha="
				+ fecha + "]";
	}
	public Compra(Producto producto) {
		super();
		
		Fecha fecha = new Fecha();
		fecha.setFecha();
	
		this.producto = producto;
		this.fecha = fecha.getFecha();
	}
	public Compra(int idcompra,Producto producto, Fecha fecha) {
		super();
		this.idcompra = idcompra;
		this.producto = producto;
		this.fecha = fecha;
	}
	
	
}
