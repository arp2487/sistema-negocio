package DAO.Implementaciones;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import DAO.Dominio.Marca;
import DAO.Dominio.Producto;
import DAO.Dominio.Tipo;
import DAO.Factory.FactoryMarca;
import DAO.Factory.FactoryTipo;
import DAO.Interfaces.MarcaDAO;
import DAO.Interfaces.ProductoDAO;
import DAO.Interfaces.TipoDAO;
import util.Configuracion;

public class ProductoDAOimplArchivo implements ProductoDAO {

	public void Guardar(ArrayList<Producto> lista) {
		String clase = lista.get(0).getNombreClase();
		File file = new File(Configuracion.getProperty(clase));
		
		try {
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream objout = new ObjectOutputStream(fout);
			
			for(int i = 0; i < lista.size(); i++) {
				objout.writeObject(lista.get(i));
			}
			
			objout.close();
			fout.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Producto> cargar(){
		String clase = "producto";
		File file = new File(Configuracion.getProperty(clase));
		ArrayList<Producto> lista = new ArrayList();
		
		try {
			
			FileInputStream fin = new FileInputStream(file);
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			while(true) {
				Producto producto = new Producto();
				producto = (Producto) oin.readObject();
				lista.add(producto);
			}
			
			
		}catch(ClassNotFoundException e) {	
		}catch(EOFException i) {
		}catch(IOException o) {
			o.printStackTrace();		
		}
		
		return lista;
	}


	public void alta(Producto producto, int porcentajeganancia,int idmarca, int idtipo) {
		ArrayList<Producto> lista = cargar();
		producto.setPrecioVenta(calcularPrecioVenta(producto.getPrecioCompra(),porcentajeganancia));
		int idmaximo = 0;
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getIdProducto() > idmaximo) {
				idmaximo = lista.get(i).getIdProducto();
			}
		}
		producto.setIdProducto(idmaximo + 1);
		TipoDAO td = FactoryTipo.getDAO("archivo");
		MarcaDAO md = FactoryMarca.getDAO("archivo");
		
		producto.setMarca(md.consulta(md.buscar(idmarca)));
		producto.setTipo(td.consulta(td.buscar(idtipo)));
		lista.add(producto);
		
		Guardar(lista);
		
	}
	
	public void alta(Producto producto, float ganancia, int idmarca, int idtpo) {
		ArrayList<Producto> lista = cargar();
		
		producto.setPrecioVenta(calcularPrecioVenta(producto.getPrecioCompra(),ganancia));
		int idmaximo = 0;
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getIdProducto() > idmaximo) {
				idmaximo = lista.get(i).getIdProducto();
			}
		}
		producto.setIdProducto(idmaximo + 1);
		TipoDAO td = FactoryTipo.getDAO("archivo");
		MarcaDAO md = FactoryMarca.getDAO("archivo");
		
		producto.setMarca(md.consulta(md.buscar(idmarca)));
		producto.setTipo(td.consulta(td.buscar(idtpo)));
		lista.add(producto);
		
		Guardar(lista);
	}

	
	public boolean baja(String nombre, String nombremarca) {
		ArrayList<Producto> lista = cargar();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {
				if(lista.get(i).getMarca().getNombre().equals(nombremarca) == true) {
					lista.remove(i);
					Guardar(lista);
					return true;
				}
			}
		}
		return false;
	}

	
	public Producto consulta(String nombre,String marca) {
		ArrayList<Producto> lista = cargar();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre)) {
				if(lista.get(i).getMarca().getNombre().equals(marca)) {
				
					return lista.get(i);
				}
			}
		}
		return null;
	}

	@Override
	public Producto buscar(int id) {
		ArrayList<Producto> lista = cargar();

		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getIdProducto() == id) {
				return lista.get(i);
			}
		}
		
		return null;
	}


	public ArrayList<Producto> getall() {
		ArrayList<Producto> lista = cargar();
		return lista;
	}

	@Override
	public boolean moficarnombre(String nombre, String marca,String nombrenuevo) {
		ArrayList<Producto> lista = cargar();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {
				if(lista.get(i).getMarca().getNombre().equals(marca) == true) {
					lista.get(i).setNombre(nombrenuevo);	
					Guardar(lista);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean modificarprecio(String nombre, String marca,float preciocompra, int porcentajeganancia) {
		ArrayList<Producto> lista = cargar();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {
				if(lista.get(i).getMarca().getNombre().equals(marca) == true) {
					lista.get(i).setPrecioCompra(preciocompra);
					lista.get(i).setPrecioVenta(calcularPrecioVenta(
							preciocompra,porcentajeganancia));
					Guardar(lista);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean modificarprecio(String nombre, String marca,float preciocompra, float ganancia) {
		ArrayList<Producto> lista = cargar();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {
				if(lista.get(i).getMarca().getNombre().equals(marca)== true) {
					lista.get(i).setPrecioCompra(preciocompra);
					lista.get(i).setPrecioVenta(calcularPrecioVenta(
							preciocompra,ganancia));
					Guardar(lista);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean modificartamaño(String nombre,String marca, String nuevotamaño) {
		ArrayList<Producto> lista = cargar();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {
				if(lista.get(i).getMarca().getNombre().equals(marca)== true) {
					lista.get(i).setTamaño(nuevotamaño);
					
					Guardar(lista);
					
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean modificarmarca(String nombre,String marca, String marcanueva) {
		ArrayList<Producto> lista = cargar();
		MarcaDAO md = FactoryMarca.getDAO("archivo");
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {
				if(lista.get(i).getMarca().getNombre().equals(marca)) {
					lista.get(i).setMarca(md.consulta(marcanueva));
					
					Guardar(lista);
					
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean modificartipo(String nombre, String marca,String tiponuevo) {
		ArrayList<Producto> lista = cargar();
		TipoDAO td = FactoryTipo.getDAO("archivo");
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {
				if(lista.get(i).getMarca().getNombre().equals(marca) == true) {
					lista.get(i).setTipo(td.consulta(tiponuevo));;
					
					Guardar(lista);
					
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public float calcularPrecioVenta(float preciocompra, int porcentajeGanancia) {
		
		float porcentaje = (float) porcentajeGanancia / 100;
		float aumento = (float) preciocompra*porcentaje;
		return preciocompra + aumento;
	}

	
	public float calcularPrecioVenta(float preciocompra, float ganancia) {
			
		return preciocompra + ganancia;
	}

	@Override
	public boolean aumentarProducto(String nombre,String marca, int aumento) {
		ArrayList<Producto> lista = cargar();
		int posicion = lista.size() + 3;
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {
				if(lista.get(i).getMarca().getNombre().equals(marca) == true) {
				posicion = i;

				float preciocompra = lista.get(posicion).getPrecioCompra();
				float porcentaje = (float) aumento / 100;
				float aumentoclone =  preciocompra * porcentaje;
				lista.get(posicion).setPrecioCompra(preciocompra + aumentoclone);
				float precioventa = calcularPrecioVenta(lista.get(posicion).getIdProducto()
						,lista.get(posicion).getPrecioCompra());
				lista.get(posicion).setPrecioVenta(precioventa);
				
				Guardar(lista);
				return true;
				}
			}
		}
		return false;
	}

	
	public boolean aumentarTipo(String tipo, int aumento) {
		ArrayList<Producto> lista = cargar();
		int posicion = lista.size() + 3;
		int ok = 0;
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getTipo().getNombre().equals(tipo) == true) {
				posicion  = i;
				float preciocompra = lista.get(posicion).getPrecioCompra();
				float porcentaje = (float) aumento / 100;
				float aumentoclone =  preciocompra * porcentaje;
				lista.get(posicion).setPrecioCompra(preciocompra + aumentoclone);
				float precioventa = calcularPrecioVenta(lista.get(posicion).getIdProducto()
						,lista.get(posicion).getPrecioCompra());
				lista.get(posicion).setPrecioVenta(precioventa);
				
				Guardar(lista);
				ok++;
			}
		}
		Guardar(lista);
		if(ok > 0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean aumentarMarca(String marca, int aumento) {
		ArrayList<Producto> lista = cargar();
		int posicion = lista.size() + 3;
		int ok = 0;
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getMarca().getNombre().equals(marca) == true) {
				posicion  = i;
				float preciocompra = lista.get(posicion).getPrecioCompra();
				float porcentaje = (float) aumento / 100;
				float aumentoclone =  preciocompra * porcentaje;
				lista.get(posicion).setPrecioCompra(preciocompra + aumentoclone);
				float precioventa = calcularPrecioVenta(lista.get(posicion).getIdProducto()
						,lista.get(posicion).getPrecioCompra());
				lista.get(posicion).setPrecioVenta(precioventa);
				
				Guardar(lista);
				ok++;
			}
		}
		Guardar(lista);
		if(ok > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean bajarProducto(String producto, String marca,int bajada) {
		ArrayList<Producto> lista = cargar();
		int posicion = lista.size() + 3;
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(producto) == true) {
				if(lista.get(i).getMarca().getNombre().equals(marca) == true) {
				posicion = i;

				float preciocompra = lista.get(posicion).getPrecioCompra();
				float porcentaje = (float) bajada / 100;
				float aumentoclone =  (float) preciocompra * porcentaje;
				lista.get(posicion).setPrecioCompra(preciocompra - aumentoclone);
				float precioventa = calcularPrecioVenta(lista.get(posicion).getIdProducto()
						,lista.get(posicion).getPrecioCompra());
				lista.get(posicion).setPrecioVenta(precioventa);
				
				Guardar(lista);
				return true;
				}
			}
		}
		return false;
		
	}

	@Override
	public boolean bajarTipo(String tipo, int bajada) {
		ArrayList<Producto> lista = cargar();
		int posicion = lista.size() + 3;
		int ok = 0;
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getTipo().getNombre().equals(tipo) == true) {
				posicion  = i;
				float preciocompra = lista.get(posicion).getPrecioCompra();
				float porcentaje = (float) bajada / 100;
				float aumentoclone =  (float) preciocompra * porcentaje;
				lista.get(posicion).setPrecioCompra(preciocompra - aumentoclone);
				float precioventa = calcularPrecioVenta(lista.get(posicion).getIdProducto()
						,lista.get(posicion).getPrecioCompra());
				lista.get(posicion).setPrecioVenta(precioventa);
				
				Guardar(lista);
				ok++;
			}
		}
		Guardar(lista);
		if(ok > 0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean bajarMarca(String marca, int bajada) {
		ArrayList<Producto> lista = cargar();
		int posicion = lista.size() + 3;
		int ok = 0;
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getMarca().getNombre().equals(marca) == true) {
				posicion  = i;
				float preciocompra = lista.get(posicion).getPrecioCompra();
				float porcentaje = (float) bajada / 100;
				float aumentoclone =  (float) preciocompra * porcentaje;
				lista.get(posicion).setPrecioCompra(preciocompra - aumentoclone);
				float precioventa = calcularPrecioVenta(lista.get(posicion).getIdProducto()
						,lista.get(posicion).getPrecioCompra());
				lista.get(posicion).setPrecioVenta(precioventa);
				
				Guardar(lista);
				ok++;
			}
		}
		Guardar(lista);
		if(ok > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void alta(Producto producto, int idmarca, int idtipo) {
		ArrayList<Producto> lista = cargar();
		int idmaximo = 0;
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getIdProducto() > idmaximo) {
				idmaximo = lista.get(i).getIdProducto();
			}
		}
		producto.setIdProducto(idmaximo + 1);
		TipoDAO td = FactoryTipo.getDAO("archivo");
		MarcaDAO md = FactoryMarca.getDAO("archivo");
		
		producto.setMarca(md.consulta(md.buscar(idmarca)));
		producto.setTipo(td.consulta(td.buscar(idtipo)));
		lista.add(producto);
		
		Guardar(lista);
	}

	@Override
	public boolean modificarprecio(String nombre, String marca, float precioventa) {
		ArrayList<Producto> lista = cargar();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {
				if(lista.get(i).getMarca().getNombre().equals(marca) == true) {
					lista.get(i).setPrecioVenta(precioventa);
					Guardar(lista);
					return true;
				}
			}
		}
		return false;
	}

	
}
