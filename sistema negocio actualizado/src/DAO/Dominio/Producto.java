package DAO.Dominio;

import java.io.Serializable;

public class Producto implements Serializable{
	private int idProducto;
	private String nombre;
	private float precioCompra;
	private float precioVenta;
	private String tamaño;
	private Marca marca;
	private Tipo tipo;
	private String nombreClase = "producto";
	
	
	
	public Producto(int idProducto, String nombre, float precioCompra, float precioVenta, String tamaño, Marca marca,
			Tipo tipo, String nombreClas4e) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.tamaño = tamaño;
		this.marca = marca;
		this.tipo = tipo;
		this.nombreClase = nombreClas4e;
	}



	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", precioCompra=" + precioCompra
				+ ", precioVenta=" + precioVenta + ", tamaño=" + tamaño + ", marca=" + marca + ", tipo=" + tipo
				+ ", nombreClas4e=" + nombreClase + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProducto;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((nombreClase == null) ? 0 : nombreClase.hashCode());
		result = prime * result + Float.floatToIntBits(precioCompra);
		result = prime * result + Float.floatToIntBits(precioVenta);
		result = prime * result + ((tamaño == null) ? 0 : tamaño.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Producto other = (Producto) obj;
		if (idProducto != other.idProducto)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
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
		if (Float.floatToIntBits(precioCompra) != Float.floatToIntBits(other.precioCompra))
			return false;
		if (Float.floatToIntBits(precioVenta) != Float.floatToIntBits(other.precioVenta))
			return false;
		if (tamaño == null) {
			if (other.tamaño != null)
				return false;
		} else if (!tamaño.equals(other.tamaño))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}



	public int getIdProducto() {
		return idProducto;
	}



	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public float getPrecioCompra() {
		return precioCompra;
	}



	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}



	public float getPrecioVenta() {
		return precioVenta;
	}



	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}



	public String getTamaño() {
		return tamaño;
	}



	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}



	public Marca getMarca() {
		return marca;
	}



	public void setMarca(Marca marca) {
		this.marca = marca;
	}



	public Tipo getTipo() {
		return tipo;
	}



	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}



	public String getNombreClase() {
		return nombreClase;
	}



	public void setNombreClase(String nombreClas4e) {
		this.nombreClase = nombreClas4e;
	}



	public Producto() {
	}
}
