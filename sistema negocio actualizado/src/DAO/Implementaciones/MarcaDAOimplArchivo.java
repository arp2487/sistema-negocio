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
import DAO.Interfaces.MarcaDAO;
import util.Configuracion;

public class MarcaDAOimplArchivo implements MarcaDAO {
	
	public void Guardar(ArrayList<Marca> lista) {
		String clase = "marca";
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
	
	public ArrayList<Marca> cargar(){
		String clase = "marca";
		File file = new File(Configuracion.getProperty(clase));
		ArrayList<Marca> lista = new ArrayList();
		
		try {
			
			FileInputStream fin = new FileInputStream(file);
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			while(true) {
				Marca marca = new Marca();
				marca = (Marca) oin.readObject();
				lista.add(marca);
			}
			
			
		}catch(ClassNotFoundException e) {	
		}catch(EOFException i) {
		}catch(IOException o) {
			o.printStackTrace();		
		}
		
		return lista;
	}
	
	public void alta(Marca marca) {
		ArrayList<Marca> lista = cargar();
		int idmaximo = 0;
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getIdmarca() > idmaximo) {
				idmaximo = lista.get(i).getIdmarca();
			}
		}
		marca.setIdmarca(idmaximo + 1);
		
		lista.add(marca);
		
		Guardar(lista);	
	}


	public boolean baja(String nombre) {
		ArrayList<Marca> lista = cargar();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {
				lista.remove(i);
				Guardar(lista);
				return true;
			}
		}
		return false;
	}

	
	public boolean modificacion(String nombre, String nombrenuevo) {
		ArrayList<Marca> lista = cargar();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {
				lista.get(i).setNombre(nombrenuevo);
				Guardar(lista);
				return true;
			}
		}
		return false;
	}

	public Marca consulta(String nombre) {
		ArrayList<Marca> lista = cargar();
		int posicion = lista.size() + 3;
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {
				posicion = i;
			}
		}
		
		return lista.get(posicion);
	}

	public String buscar(int id) {
		ArrayList<Marca> lista = cargar();
		int posicion = lista.size() + 3;
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getIdmarca() == id) {
				posicion = i;
			}
		}
		return lista.get(posicion).getNombre();
	}

	public ArrayList<Marca> getall() {
		ArrayList<Marca> lista = cargar();
		return lista;
	}
}
