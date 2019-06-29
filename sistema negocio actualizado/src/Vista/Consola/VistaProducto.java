package Vista.Consola;

import java.util.ArrayList;

import DAO.Dominio.Marca;
import DAO.Dominio.Producto;
import DAO.Dominio.Tipo;
import util.IOGeneral;

public class VistaProducto {
	public int menuproducto() {
		return IOGeneral.leerInt("1) alta\n"+"2) baja\n"+"3) modificacion\n"
									+"4) consulta\n"+"5) getall\n"+"6) manipular precios\n"
											+ "7) salir", "ingresar valor valido");
	}
	
	//alta
	public int menualta() {
		return IOGeneral.leerInt("1)ingresar nuevo producto\n"+"2)salir", "ingresar valor valido");
	}
	
	public int menutipodealta() {
		return IOGeneral.leerInt("1) calcular precio por porcentaje\n"
				+"2) calcular precio pasando ganancia\n"
				+ "3) ingresar precios de venta directo", "ingresar valor valido");
	}
	public float leerganancia() {
		return IOGeneral.leerInt("ingresar ganancia ", "ingresar valor valido");
	}
	public int leerporcentaje() {
		return IOGeneral.leerInt("ingresar porcentaje de ganancia", "ingresar valor valido");
	}
	public int menumarca() {
		return IOGeneral.leerInt("!) elegir marca\n"+
									"2) cargar marca nueva", "ingresar valor valido");
	}
	public int elegirmarca() {
		return IOGeneral.leerInt("ingresar id de marca ", "ingresar valor valido");
	}
	public int menutipo() {
		return IOGeneral.leerInt("1) elegir tipo\n"+
									"2) ingresar tipo nuevo", "ingresar valor valido");
	}
	public int elegirtipo() {
		return IOGeneral.leerInt("ingresar id de tipo ", "ingresar valor valido");
	}
	public Producto altaProducto() {
		
		Producto producto = new Producto();
		producto.setNombre(IOGeneral.leerFrase("ingresar nombre "));
		producto.setTamaño(IOGeneral.leerFrase("ingresar tamaño"));
		producto.setPrecioCompra(IOGeneral.leerFloat("ingresar precio de compra: ", "ingresar valor valido"));
		producto.setPrecioVenta(0);
		producto.setMarca(null);
		producto.setTipo(null);
		
		return producto;
	}
	public Producto altaProductoCPrecioVenta() {
		
		Producto producto = new Producto();
		producto.setNombre(IOGeneral.leerFrase("ingresar nombre "));
		producto.setTamaño(IOGeneral.leerFrase("ingresar tamaño"));
		producto.setPrecioCompra(0);
		producto.setPrecioVenta(IOGeneral.leerFloat("ingresar precio de venta", "iingresar valor valido"));
		producto.setMarca(null);
		producto.setTipo(null);
		
		return producto;
	}
//baja
	public int menubaja() {
		return IOGeneral.leerInt("1) eliminar producto\n"+"2) salir", "ingresar valor valido");
	}
	
	public String bajaProducto() {
		return IOGeneral.leerFrase("ingresar nombre de producto a borrar");
	}
	
	public void bajaok(String nombre, boolean ok) {
		if(ok == true) {
			IOGeneral.pritln("se borro "+nombre+" con exito");
		}else {
			IOGeneral.pritln("no se encontro "+nombre);
		}
	}
//modificacion
	public int menumod() {
		return IOGeneral.leerInt("1) modificar producto\n"+"2) salir", "ingresar valor valido");
	}
	
	public int menutipodemod() {
		return IOGeneral.leerInt("1) modificar nombre\n"+"2) modificar precio\n"
				+ "3) modificar tamaño\n"+"4) modificar tipo\n"
						+ "5) modificar marca\n"+"6) salir", "ingresar valor valido");
	}
	//modificar nombre
	public String leernombre() {
		return IOGeneral.leerFrase("ingresar nombre de producto a buscar");
	}
	public String leernombrenuevo(String  nombre) {
		return IOGeneral.leerFrase("ingresar nuevo nombre para "+nombre);
	}
	public void modnombreok(String nombre, String nombrenuevo, boolean ok) {
		if(ok == true) {
			IOGeneral.pritln("se modifico "+nombre+" por "+nombrenuevo+" con exito");
		}else {
			IOGeneral.pritln("no se encontro "+nombre);
		}
	}
	//modificar precio
		public int menumodprecio() {
			return IOGeneral.leerInt("1) modificar precio venta con ganancia establecida\n"
					+ "2) modificar precio venta con porcentaje de ganancia\n"
					+ "3) modificar precio venta directo"
					+ "4) salir", "ingresar valor valido");
		}
		public float leerPrecioVentaNuevo() {
			return IOGeneral.leerFloat("ingresar nuevo precio de venta: ", "ingresar valor valido");
		}
		public float leerpreciodecompranuevo() {
			return IOGeneral.leerFloat("ingresar precio de compra nuevo: ", "ingresar valor valido");
		}
		public void modpreciook(String nombre, boolean ok) {
			if(ok == true) {
				IOGeneral.pritln("se modifico "+nombre+" con exito");
			}else {
				IOGeneral.pritln("no se encontro "+nombre);
			}
		}
	//modificar marca
		public int menumodmarca() {
			return IOGeneral.leerInt("1) modificar marca de un producto\n"+"2) salir", "ingresar valor valido");
		}
		public String leernombreproductomarca() {
			return IOGeneral.leerFrase("ingresar nombre de producto");
		}
		public String leermarcanueva(String nombre) {
			return IOGeneral.leerFrase("ingrese nueva marca (nombre) de "+nombre);
		}
		public void modmarcaeok(String nombre, String marcanueva, boolean ok) {
			if(ok == true) {
				IOGeneral.pritln("se modifico marca de "+nombre+" por "+marcanueva+" con exito");
			}else {
				IOGeneral.pritln("no se encontro "+nombre);
			}
		}
	//modificar tamaño
	public String leertamañonuevo(String  nombre) {
		return IOGeneral.leerFrase("ingresar nuevo tamaño para "+nombre);
	}
	public void modtamañook(String nombre,String tamaño, boolean ok) {
		if(ok == true) {
			IOGeneral.pritln("se modifico el tamaño de "+nombre
					+" por "+tamaño+" con exito");
		}else {
			IOGeneral.pritln("no se encontro "+nombre);
		}
	}	
	//modificar tipo
	public int menumodtipo() {
		return IOGeneral.leerInt("1) modificar tipo de un producto\n"+"2) salir", "ingresar valor valido");
	}
	public String leernombreproductotipo() {
		return IOGeneral.leerFrase("ingresar nombre de producto a modificar tipo");
	}
	public String leertiponuevo(String nombre){
			return IOGeneral.leerFrase("ingresar tipo nuevo del producto "+nombre);
	}
	public void modtipook(String nombre, String tiponuevo, boolean ok) {
		if(ok == true) {
			IOGeneral.pritln("se modifico tipo de "+nombre+" por "+tiponuevo+" con exito");
		}else {
			IOGeneral.pritln("no se encontro "+nombre);
		}
	}
//consulta
	public int menuconsulta() {
		return IOGeneral.leerInt("1) consultar producto\n"+"2) salir", "ingresar valor valido");
	}
	public String leernombreproducto() {
		return IOGeneral.leerFrase("ingresar nombre de producto a buscar");
	}
	public String leermarcanombre() {
		return IOGeneral.leerFrase("ingresar NOMBRE de marca del producto");
	}
	public String leertiponombre() {
		return IOGeneral.leerFrase("ingresar Nombre de tipo");
	}
	public void imprimir(Producto producto) {
		IOGeneral.pritln("---------------------------------------------------");
		IOGeneral.pritln("nombre: "+producto.getNombre());
		IOGeneral.pritln("tipo: "+producto.getTipo().getNombre()+" | "+" marca: "+producto.getMarca().getNombre());
		IOGeneral.pritln("precio de compra: "+producto.getPrecioCompra()+" | "+" precio de venta: "+producto.getPrecioVenta());
		IOGeneral.pritln("tamaño: "+producto.getTamaño());
		IOGeneral.pritln("-------------------------------------------------- ");
	}
//getall
	public int menugetall() {
		return IOGeneral.leerInt("1) mostrar todos los productos\n"+"2) salir", "ongresar valor valido");
	}
	public void imprimirtodos(ArrayList<Producto> lista) {
		for(int i = 0; i < lista.size();i++ ) {
			imprimir(lista.get(i));
		}
	}
//manipulacionde precios	
	public int menumaniopulacionprecio() {
		return IOGeneral.leerInt("1) subir\n"+"2) bajar\n"+"3) salir","inngresar valoir valido");
	}
	//baja precio
		public int  menubajar() {
			return IOGeneral.leerInt("1) baja5 precio de un producto\n"
					+ "2) bajar precio de tipo\n"+"3) bajar precio de marca\n"
							+ "4) salir", "ingresar valor valido");
		}

			public int leerporcentajebajada() {
				return IOGeneral.leerInt("ingresar porcentaje a bajar", "ingresar valor valido");
			}
			public void bajaprecioproductook(String nombre, boolean ok) {
				if(ok == true) {
					IOGeneral.pritln("se bajo precio de "+nombre);
				}else {
					IOGeneral.pritln("no se encontro "+nombre);
				}
			}
			public void bajapreciotipopook(String tipo, boolean ok) {
				if(ok == true) {
					IOGeneral.pritln("se bajo precio de "+tipo);
				}else {
					IOGeneral.pritln("no se encontro "+tipo);
				}
			}
			public void bajapreciomarcaok(String marca, boolean ok) {
				if(ok == true) {
					IOGeneral.pritln("se bajo precio de "+marca);
				}else {
					IOGeneral.pritln("no se encontro "+marca);
				}
			}
			
	//subir precio
		public int menusubir() {
			return IOGeneral.leerInt("1) subir un producto\n"+"2) subir tipo\n"
					+ "3) subir marca", "ingresar valor valido");
		}
		
		public  int leersubidaporcentaje() {
			return IOGeneral.leerInt("ingresar porcentaje a aumentar", "ingresar valor valido");
		}
		
		public void subirprecioproductook(String nombre, boolean ok) {
			if(ok == true) {
				IOGeneral.pritln("se subio precio de "+nombre);
			}else {
				IOGeneral.pritln("no se encontro "+nombre);
			}
		}
		public void subirpreciotipopook(String tipo, boolean ok) {
			if(ok == true) {
				IOGeneral.pritln("se subio precio de "+tipo);
			}else {
				IOGeneral.pritln("no se encontro "+tipo);
			}
		}
		public void subirpreciomarcaok(String marca, boolean ok) {
			if(ok == true) {
				IOGeneral.pritln("se subio precio de "+marca);
			}else {
				IOGeneral.pritln("no se encontro "+marca);
			}
		}
}
