package DAO.Implementaciones;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import DAO.Dominio.Compra;
import DAO.Dominio.Fecha;
import DAO.Dominio.Producto;
import DAO.Factory.FactoryProducto;
import DAO.Interfaces.CompraDAO;
import DAO.Interfaces.ProductoDAO;
import util.Configuracion;

public class CompraDAOimplArchivo implements CompraDAO {

	
	public Compra alta(String nombreproducto, String marcaProducto, Compra compra) {
		ArrayList<Compra> lista = cargar();
		ProductoDAO pd = FactoryProducto.getDAO("archivo");
		int idmaximo = 0;
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getIdcompra() > idmaximo) {
				idmaximo = lista.get(i).getIdcompra();
				
			}
		}
		Producto p = pd.consulta(nombreproducto, marcaProducto);
		Fecha fecha = new Fecha();
		fecha.setFecha();
		compra.setFecha(fecha.getFecha());
		compra.setIdcompra(idmaximo+1);
		compra.setProducto(p);
		lista.add(compra);
		Guardar(lista);
		return compra;
	}

	public boolean baja(int idCompra) {
		ArrayList<Compra> lista = cargar();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getIdcompra() == idCompra) {
				lista.remove(i);
				Guardar(lista);
				return true;
			}
		}
		return false;
	}

	@Override
	public Compra consulta(int IdCompra) {
		ArrayList<Compra> lista = cargar();
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getIdcompra() == IdCompra) {
				return lista.get(i)
						;
			}
		}
		return null;
	}

	
	public ArrayList<Compra> getall() {
		ArrayList<Compra> lista = cargar();
		return lista;
	}
	public void Guardar(ArrayList<Compra> lista) {
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
	
	public ArrayList<Compra> cargar(){
		String clase = "compra";
		File file = new File(Configuracion.getProperty(clase));
		ArrayList<Compra> lista = new ArrayList();
		
		try {
			
			FileInputStream fin = new FileInputStream(file);
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			while(true) {
				Compra compra = new Compra();
				compra = (Compra) oin.readObject();
				lista.add(compra);
			}
			
			
		}catch(ClassNotFoundException e) {	
		}catch(EOFException i) {
		}catch(IOException o) {
			o.printStackTrace();		
		}
		
		return lista;
	}
}
