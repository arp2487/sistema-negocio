package Vista.Consola;

import java.util.ArrayList;

import DAO.Dominio.Marca;
import DAO.Dominio.Tipo;
import util.IOGeneral;

public class VistaMarca {
	public int menuMarca() {
		return IOGeneral.leerInt("1) alta\n"+"2) baja\n"+"3) modificacion\n"
				+ "4) mostrar una marca \n"+"5) mostrar todas las marcas\n"
						+ "6) salir", "ingresar un valor valido");
	}
	// alta
	public int menuAlta() {
		return IOGeneral.leerInt("1) ingresar nueva marca\n"
				+ "2) no ingresar mas marcas", "ingresar un valor valido");
	}
	
	public Marca altaMarca() {
		Marca marca = new Marca();
		marca.setNombre(IOGeneral.leerFrase("ingresar nombra de marca"));
		marca.setIdmarca(0);
		return marca;
	}
	
	// baja
	
	public int menuBaja() {
		return IOGeneral.leerInt("1) eliminar marca\n"+"2) salir", "ingresar valor valido");
	}
	
	public String bajaMarca() {
		return IOGeneral.leerFrase("ingresar nombre de marca a eliminar");
	}
	
	public void BAjaok(boolean ok, String nombre) {
		if(ok == true) {
			IOGeneral.pritln("marca: "+nombre+" eliminado con exito");
		}else {
			IOGeneral.pritln("no se encontro marca "+nombre);
		}
	}
	
	//modificacion
	
	public int menumodificacion() {
		return IOGeneral.leerInt("1) modificar marca\n"+"2) salir", "ingresar valor valido");
	}
	
	public String modificarMarca() {
		return IOGeneral.leerFrase("ingresar marca a modificar");
	}
	
	public String leernombrenuevo(String nombre) {
		return IOGeneral.leerFrase("ingresar nuevo nombre de la marca: " +nombre);
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
		return IOGeneral.leerInt("1)consultar una marca\n"+"2)salir", "ingresar valor valido");
	}
	
	public String consultaMarca() {
		return IOGeneral.leerFrase("ingresar marca a buscar: ");
	}
	
	public void imprimirMarca(Marca marca) {
		IOGeneral.pritln("marca : "+marca.getNombre()+" | "+" id: "+marca.getIdmarca());
	}
	
	
	// getall
	
	public int menugetall() {
		return IOGeneral.leerInt("1)mostrar todas las marcas\n"+"2)salir", "ingresar valor valido");
	}
	
	public void imprimirMarcas(ArrayList<Marca> lista) {
		if(lista.size() > 0) {
			for(int i = 0; i < lista.size(); i++) {
				imprimirMarca(lista.get(i));
			}
		}else {
			IOGeneral.pritln("no hay marcas cargadas");
		}
	}
	
}
