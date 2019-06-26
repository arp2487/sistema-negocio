package Vista.Consola;

import java.util.ArrayList;

import DAO.Dominio.Compra;
import util.IOGeneral;

public class VistaCompra {
	public int menuprincipal() {
		return IOGeneral.leerInt("1) alta\n"+"2) baja\n"+"3) consulta"+"4) getall\n"
				+ "5) salir", "ingresar valor valido");
	}
	//alta
	public int menualta() {
		return IOGeneral.leerInt("1) nueva compra\n"+"2) salir", "ingresar valor valido");
	}
	public Compra crearcompra() {
		Compra compra = new Compra();
		return compra;
	}
	public String leernombreproducto() {
		return IOGeneral.leerFrase("ingrese nombre de producto");
	}
	public String leermarcaproducto() {
		return IOGeneral.leerFrase("ingresar marca de producto");
	}
	public void altaok(String nombre, String marca, boolean ok) {
		if(ok == true) {
			IOGeneral.pritln("se creo la compra de "+nombre+" de la marca "+marca+" con exito");
		}else {
			IOGeneral.pritln("no se encotro "+nombre+" de la marca "+marca);
		}
	}
	//baja
		public int menubaja() {
			return IOGeneral.leerInt("1) eliminar compra\n"+"2) salir", "ingresar valor valido");
		}
		public int leeridbaja() {
			return IOGeneral.leerInt("ingresar id de compra", "ingresar valor valido");
		}
		public void bajaok(int id, boolean ok) {
			if(ok == true) {
				IOGeneral.pritln("se elimino compra con id "+id+" con exito");
			}else{
				IOGeneral.pritln("no se encontro compra con id "+id);
			}
		}
	//consulta
		public int menuconsullta() {
			return IOGeneral.leerInt("1) buscar compra\n"+"2) salir", "ingresar valor valido");
		}
		public int leeid() {
			return IOGeneral.leerInt("ingresar id de compra", "ingresar valor valido");
		}
		public void imprimir(Compra compra) {
			IOGeneral.pritln("producto: "+compra.getProducto().getNombre()+" marca "+
						compra.getProducto().getMarca().getNombre());
			int dia = compra.getFecha().getDia();
			int mes = compra.getFecha().getMes();
			int año = compra.getFecha().getAño();
			IOGeneral.pritln(dia+"/"+mes+"/"+año);
		}
		public void noencotrado(int id) {
			IOGeneral.pritln("no se encontro compra con id "+id);
		}
		
	//getall
		public int menugetall() {
			return IOGeneral.leerInt("1) mostrar todas las compras", "ingresar valor valido");
		}
		public void imprimirtodos(ArrayList<Compra> lista) {
			for(int i = 0; i < lista.size(); i++) {
				imprimir(lista.get(i));
			}
		}
}
