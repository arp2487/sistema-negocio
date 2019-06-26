package Vista.Consola;

import java.util.ArrayList;

import DAO.Dominio.Tipo;
import util.IOGeneral;

public class VistaTipo {
	public int menuTipo() {
		return IOGeneral.leerInt("1) alta\n"+"2) baja\n"+"3) modificacion\n"
				+ "4) mostrar un tipo\n"+"5) mostrar todos los tipos\n"
						+ "6) salir", "ingresar un valor valido");
	}
	// alta
	public int menuAlta() {
		return IOGeneral.leerInt("1) ingresar nuevo tipo\n"
				+ "2) no ingresar mas tipos", "ingresar un valor valido");
	}
	
	public Tipo altaTipo() {
		Tipo tipo = new Tipo();
		tipo.setNombre(IOGeneral.leerFrase("ingresar nombra de tipo"));
		tipo.setIdtipo(0);
		return tipo;
	}
	
	// baja
	
	public int menuBaja() {
		return IOGeneral.leerInt("1) eliminar tipo\n"+"2) salir", "ingresar valor valido");
	}
	
	public String bajaTipo() {
		return IOGeneral.leerFrase("ingresar nombre de tipo a eliminar");
	}
	
	public void BAjaok(boolean ok, String nombre) {
		if(ok == true) {
			IOGeneral.pritln("tipo: "+nombre+" eliminado con exito");
		}else {
			IOGeneral.pritln("no se encontro tipo");
		}
	}
	
	//modificacion
	
	public int menumodificacion() {
		return IOGeneral.leerInt("1) modificar tipo\n"+"2) salir", "ingresar valor valido");
	}
	
	public String modificartipo() {
		return IOGeneral.leerFrase("ingresar tipo a modificar");
	}
	
	public String leernombrenuevo(String nombre) {
		return IOGeneral.leerFrase("ingresar nuevo nombre del tipo: " +nombre);
	}
	
	public void modificacionok(boolean ok,String nombre, String nombrenuevo) {
		if(ok == true) {
			IOGeneral.pritln("se modifico "+nombre+" con exito a "+nombrenuevo);
		}else {
			IOGeneral.pritln("no se encontro "+nombre);
		}
	}
	
	// consulta
	
	public int menuconsulta() {
		return IOGeneral.leerInt("1)consultar un tipo\n"+"2)salir", "ingresar valor valido");
	}
	
	public String consultatipo() {
		return IOGeneral.leerFrase("ingresar tipo a buscar: ");
	}
	
	public void imprimirtipo(Tipo tipo) {
		IOGeneral.pritln("tipo : "+tipo.getNombre()+" | "+" id: "+tipo.getIdtipo());
	}
	
	
	// getall
	
	public int menugetall() {
		return IOGeneral.leerInt("1)mostrar todos los tipo\n"+"2)salir", "ingresar valor valido");
	}
	
	public void imprimirtipos(ArrayList<Tipo> lista) {
		if(lista.size() > 0) {
			for(int i = 0; i < lista.size(); i++) {
				imprimirtipo(lista.get(i));
			}
		}else {
			IOGeneral.pritln("no hay tipos cargados");
		}
	}
	
}
