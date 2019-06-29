package Controlador.Consola;

import DAO.Factory.FactoryProducto;
import DAO.Factory.FactoryTipo;
import DAO.Interfaces.ProductoDAO;
import DAO.Interfaces.TipoDAO;
import Vista.Consola.VistaProducto;

public class ProductoControlador {
	private ProductoDAO modelo = FactoryProducto.getDAO("archivo");
	private VistaProducto vista = new VistaProducto();
	public ProductoDAO getModelo() {
		return modelo;
	}
	public void setModelo(ProductoDAO modelo) {
		this.modelo = modelo;
	}
	public VistaProducto getVista() {
		return vista;
	}
	public void setVista(VistaProducto vista) {
		this.vista = vista;
	}
	
	public void alta(Tipocontrolador tc, MarcaControlador mc) {
		int op = vista.menualta();
		while(op == 1){
			int opseteoprecio = vista.menutipodealta();

			if(opseteoprecio == 1) {
				mc.getall();
				tc.getall();
				
				modelo.alta(vista.altaProducto(),vista.leerporcentaje(), vista.elegirmarca(), vista.elegirtipo());
			}
			if(opseteoprecio == 2) {
				mc.getall();
				tc.getall();
				
				modelo.alta(vista.altaProducto(), vista.leerganancia(), vista.elegirmarca(), vista.elegirtipo());
			}
			if(opseteoprecio == 3) {
				mc.getall();
				tc.getall();
				
				modelo.alta(vista.altaProductoCPrecioVenta(), vista.elegirmarca(), vista.elegirtipo());
			}
			op = vista.menualta();
		}
	}
	public void baja(MarcaControlador mc) {
		int op = vista.menubaja();
		while(op == 1) {
			String nombre = vista.bajaProducto();
			mc.getall();
			boolean ok =modelo.baja(nombre,vista.leermarcanombre());
			vista.bajaok(nombre, ok);
			op = vista.menubaja();
		}
	}
	
	public void getall() {
		int op = vista.menugetall();
		while(op == 1) {
			vista.imprimirtodos(modelo.getall());
			op = vista.menugetall();
		}
	}
	
	public void consulta(MarcaControlador mc) {
		int op = vista.menuconsulta();
		while(op == 1) {
			mc.getall();
		
			vista.imprimir(modelo.consulta(vista.leernombreproducto(), vista.leermarcanombre()));
			op = vista.menuconsulta();
		}
	}
	
	public void manipulacionPrecios(MarcaControlador md, Tipocontrolador tc) {
		int op = vista.menumaniopulacionprecio();
		
		while(op != 3){
			if(op == 1) {
				int opsubir = vista.menusubir();
				while(opsubir != 4) {{
					if(op == 1) {
						String nombre = vista.leernombre();
						int porcentaje = vista.leersubidaporcentaje();
						md.getall();
						String marca = vista.leermarcanombre();
						boolean ok = modelo.aumentarProducto(nombre, marca, porcentaje);
						vista.subirprecioproductook(nombre, ok);
					}
					if(op == 2) {
						tc.getall();
						String nombretipo = vista.leertiponombre();
						int porcentaje = vista.leersubidaporcentaje();
						boolean ok = modelo.aumentarTipo(nombretipo, porcentaje);
						vista.subirpreciotipopook(nombretipo, ok);
					}
					if(op == 3) {
						md.getall();
						String marca = vista.leermarcanombre();
						int porcentaje = vista.leersubidaporcentaje();
						boolean ok = modelo.aumentarMarca(marca, porcentaje);
						vista.subirpreciomarcaok(marca, ok);
					}
					opsubir = vista.menusubir();
				  }
				}
			}
			if(op == 2) {
				int opbajar = vista.menubajar();
				while(opbajar != 4){
					if(op == 1) {
						String nombre = vista.leernombre();
						md.getall();
						String marca = vista.leermarcanombre();
						int porcentaje = vista.leerporcentajebajada();
						boolean ok = modelo.bajarProducto(nombre, marca, porcentaje);
						vista.bajaprecioproductook(nombre, ok);
					}
					if(op == 3) {
						md.getall();
						String marca = vista.leermarcanombre();
						int porcentaje = vista.leerporcentajebajada();
						boolean ok = modelo.bajarMarca(marca, porcentaje);
						vista.bajapreciomarcaok(marca, ok);
					}
					if(op == 2) {
						tc.getall();
						String tipo = vista.leertiponombre();
						int porcentaje = vista.leerporcentajebajada();
						boolean ok = modelo.bajarTipo(tipo, porcentaje);
						vista.bajapreciotipopook(tipo, ok);
					}
					opbajar = vista.menubajar();
				}
			}
			op = vista.menumaniopulacionprecio();
		}
	}
	
	public void modificacion(Tipocontrolador tc, MarcaControlador mc) {
		int op = vista.menumod();
		while(op == 1) {
			int optipomod = vista.menutipodemod();
			while(optipomod != 6) {
				if(optipomod ==1) {
					//nombre
					mc.getall();
					String nombre = vista.leernombre();
					String marca = vista.leermarcanombre();
					String nobrenuevo = vista.leernombrenuevo(nombre);
					boolean ok = modelo.moficarnombre(nombre,marca, nobrenuevo);
					vista.modnombreok(nombre, nobrenuevo, ok);
				}
				if(optipomod ==2) {
					//precio
					int opmodpreciotipo = vista.menumodprecio();
					while(opmodpreciotipo != 3) {
						if(opmodpreciotipo == 1) {
							String nombre = vista.leernombre();
							mc.getall();
							String marca = vista.leermarcanombre();
							float preciocompranuevo = vista.leerpreciodecompranuevo();
							float ganancia = vista.leerganancia();
							boolean ok = modelo.modificarprecio(nombre,marca, preciocompranuevo, ganancia);
							vista.modpreciook(nombre, ok);
						}
						if(opmodpreciotipo == 2) {
							String nombre = vista.leernombre();
							mc.getall();
							String marca = vista.leermarcanombre();
							float preciocompra = vista.leerpreciodecompranuevo();
							int porcentaje = vista.leerporcentaje();
							boolean ok = modelo.modificarprecio(nombre, marca,preciocompra, porcentaje);
							vista.modpreciook(nombre, ok);
						}
						if(opmodpreciotipo == 3) {
							String nombre = vista.leernombre();
							mc.getall();
							String marca = vista.leermarcanombre();
							float precioventanuevo = vista.leerPrecioVentaNuevo();
							boolean ok = modelo.modificarprecio(nombre, marca,precioventanuevo);
							vista.modpreciook(nombre, ok);
						}
						opmodpreciotipo = vista.menumodprecio();
					}
				}
				if(optipomod ==3) {
					//tamaño
					String nombre = vista.leernombre();
					mc.getall();
					String marca = vista.leermarcanombre();
					String nuevotamaño = vista.leertamañonuevo(nombre);
					boolean ok = modelo.modificartamaño(nombre, marca,nuevotamaño);
					vista.modtamañook(nombre, nuevotamaño, ok);
				}
				if(optipomod ==4) {
					//tipo
					String nombre = vista.leernombre();
					mc.getall();
					String marca = vista.leermarcanombre();
					tc.getall();
					String tiponuevo = vista.leertiponuevo(nombre);
					boolean ok = modelo.modificartipo(nombre, marca,tiponuevo);
					vista.modtipook(nombre, tiponuevo, ok);
					
				}
				if(optipomod ==5) {
					//marca
					String nombre = vista.leernombre();
					mc.getall();
					String marca = vista.leermarcanombre();
					String marcanueva = vista.leermarcanueva(nombre);
					boolean ok = modelo.modificarmarca(nombre, marca, marcanueva);
					vista.modtipook(nombre, marcanueva, ok);
				}
				optipomod = vista.menutipodemod();
			}
			
			op = vista.menumod();
		}
	}
	
	public void abmc(Tipocontrolador tc, MarcaControlador mc) {
		int op = vista.menuproducto();
		while(op != 7) {
			if(op == 1) {
				alta(tc,mc);
			}
			if(op == 2) {
				baja(mc);
			}
			if(op == 3) {
				modificacion(tc,mc);
			}
			if(op == 4) {
				consulta(mc);
			}
			if(op == 5) {
				getall();
			}
			if(op == 6) {
				manipulacionPrecios(mc,tc);
			}
			op = vista.menuproducto();
		}
	}
}
