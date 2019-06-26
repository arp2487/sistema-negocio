package DAO.Implementaciones;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import DAO.Dominio.Cliente;
import DAO.Dominio.Compra;
import DAO.Dominio.Producto;
import DAO.Interfaces.ClienteDAO;
import util.Configuracion;

public class ClienteDAOimplArchivo implements ClienteDAO {

	
	public void alta(Cliente cliente) {
		ArrayList<Cliente> lista = cargar();

		lista.add(cliente);
		
		Guardar(lista);
	}

	
	public boolean baja(String nombre) {
		ArrayList<Cliente> lista = cargar();
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre)) {
				lista.remove(i);
				Guardar(lista);
				return true;
			}
		}
		return false;
	}


	public Cliente consulta(String nombre) {
		ArrayList<Cliente> lista = cargar();
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre)) {
				return lista.get(i);
			}
		}
		return null;
	}


	public Cliente buscar(int id) {
		ArrayList<Cliente> lista = cargar();
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getIdCliente() == id) {
				
				return lista.get(i);
			}
		}
		return null;
	}

	
	public ArrayList<Cliente> getall() {
		ArrayList<Cliente> lista = cargar();
		
		return lista;
	}

	
	public float sumarCuenta(String nombre, int porcentajeInteres) {
		ArrayList<Cliente> lista = cargar();
		float cuenta = 0;
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {
				for(int j = 0; j < lista.get(i).getCompras().size(); j++) {
					cuenta = cuenta + lista.get(i).getCompras().get(j).getProducto()
							.getPrecioVenta();
				}
				
				cuenta = cuenta + (cuenta * (porcentajeInteres / 100));
				lista.get(i).setCuenta(cuenta);
				
				Guardar(lista);
				return cuenta;
			}
		}
		return 0;
	}

	public boolean pagoCuenta(String nombre) {
		ArrayList<Cliente> lista = cargar();
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {

				lista.get(i).setCuenta(0);
				Guardar(lista);
				return true;
				
			}
		}
		return false;
	}

	
	public float pagoCuentaParcial(String nombre, float pago) {
		ArrayList<Cliente> lista = cargar();
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {

				float cuentaactualizada = lista.get(i).getCuenta() - pago;
				lista.get(i).setCuenta(cuentaactualizada);
				Guardar(lista);
				return cuentaactualizada;
			}
		}
		return 0;
	}
	public void Guardar(ArrayList<Cliente> lista) {
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
	
	public ArrayList<Cliente> cargar(){
		String clase = "cliente";
		File file = new File(Configuracion.getProperty(clase));
		ArrayList<Cliente> lista = new ArrayList();
		
		try {
			
			FileInputStream fin = new FileInputStream(file);
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			while(true) {
				Cliente cliente = new Cliente();
				cliente = (Cliente) oin.readObject();
				lista.add(cliente);
			}
			
			
		}catch(ClassNotFoundException e) {	
		}catch(EOFException i) {
		}catch(IOException o) {
			o.printStackTrace();		
		}
		
		return lista;
	}


	
	public boolean modificarNombre(String nombre, String nombrenuevo) {
		ArrayList<Cliente> lista = cargar();
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {

				lista.get(i).setNombre(nombrenuevo);
				Guardar(lista);
				return true;
				
			}
		}
		return false;
	}



	public boolean añadircompra(String nombre, Compra compra) {
		ArrayList<Cliente> lista = cargar();
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {

				lista.get(i).getCompras().add(compra);
				Guardar(lista);
				return true;
				
			}
		}
		return false;
	}
}
