package DAO.Implementaciones;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import DAO.Dominio.Tipo;
import DAO.Interfaces.TipoDAO;
import util.Configuracion;

public class TipoDAOimplArchivo implements TipoDAO {
	
	public void Guardar(ArrayList<Tipo> lista) {
		String clase = "tipo";
		File file = new File(Configuracion.getProperty(clase));
		
		try {
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream objout = new ObjectOutputStream(fout);
			
			for(int i = 0; i < lista.size(); i++) {
				objout.writeObject(lista.get(i));
				objout.flush();
			}
			
			objout.close();
			fout.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Tipo> cargar(){
		String clase = "tipo";
		File file = new File(Configuracion.getProperty(clase));
		ArrayList<Tipo> lista = new ArrayList();
		
		try {
			
			FileInputStream fin = new FileInputStream(file);
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			while(true) {
				Tipo tipo = new Tipo();
				tipo = (Tipo) oin.readObject();
				lista.add(tipo);
			}
			
			
		}catch(ClassNotFoundException e) {	
		}catch(EOFException i) {
		}catch(IOException o) {
			o.printStackTrace();		
		}
		
		return lista;
	}

	
	public void alta(Tipo tipo) {
		ArrayList<Tipo> lista = cargar();
		int idmaximo = 0;
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getIdtipo() > idmaximo) {
				idmaximo = lista.get(i).getIdtipo();
			}
		}
		tipo.setIdtipo(idmaximo + 1);
		lista.add(tipo);
		
		Guardar(lista);	
	}


	public boolean baja(String nombre) {
		ArrayList<Tipo> lista = cargar();
		
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
		ArrayList<Tipo> lista = cargar();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {
				lista.get(i).setNombre(nombrenuevo);
				Guardar(lista);
				return true;
			}
		}
		return false;
	}

	public Tipo consulta(String nombre) {
		ArrayList<Tipo> lista = cargar();
		int posicion = lista.size() + 3;
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equals(nombre) == true) {
				posicion = i;
			}
		}
		
		return lista.get(posicion);
	}

	public String buscar(int id) {
		ArrayList<Tipo> lista = cargar();
		int posicion = lista.size() + 3;
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getIdtipo() == id) {
				posicion = i;
			}
		}
		return lista.get(posicion).getNombre();
	}

	public ArrayList<Tipo> getall() {
		ArrayList<Tipo> lista = cargar();
		return lista;
	}

}
