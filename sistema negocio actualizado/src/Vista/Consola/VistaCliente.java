package Vista.Consola;

import java.util.ArrayList;

import DAO.Dominio.Cliente;
import DAO.Dominio.Compra;
import util.IOGeneral;

public class VistaCliente {
public int menuprincipal() {
	return IOGeneral.leerInt("1) alta\n"+"2) baja\n"+"3) modificacion\n"+"4) consulta\n"
			+ "5) mostrar todos\n"+"6) sumar cuenta\n"+"7) pago cuenta parcial\n"
					+ "8) pago cuenta total\n"+"9) añadir compra a cliente\n"
							+ "10) salir", "ingresar valor valido");
}
	
//alta
	public int menualta() {
		return IOGeneral.leerInt("1) ingresar nuevo cliente\n"+"2) salir", "ingresar valor valido");
	}
	public Cliente leercliente() {
		Cliente cliente = new Cliente();
		
		cliente.setNombre(IOGeneral.leerFrase("ingresar nombre de cliente"));
		return cliente;
	}
//baja
	public int menubaja() {
		return IOGeneral.leerInt("1) eliminar cleinte\n"+"2) salir", "ingresar valor valido");
	}
	public String leecliente() {
		return IOGeneral.leerFrase("ingresar nombre de cliente");
	}
	public void bajaok(String nombre, boolean ok) {
		if(ok == true) {
			IOGeneral.pritln("se elimino "+nombre+" con exito");
		}else {
			IOGeneral.pritln("no se encontro "+nombre);
		}
	}
//consulta
	public int menuconsulta() {
		return IOGeneral.leerInt("1) consulta\n "+"2) salir", "ingresar valor valido");
	}
	public void imprimir(Cliente cliente) {
		VistaCompra vc = new VistaCompra();
		IOGeneral.pritln("nombre: "+cliente.getNombre());
		IOGeneral.pritln("cuenta: "+cliente.getCuenta());
		ArrayList<Compra> lista = cliente.getCompras();
		vc.imprimirtodos(cliente.getCompras());
	}
//getall
	public int menugetall() {
		return IOGeneral.leerInt("1) mostrar todos\n"+"2) salir", "ingresar valor valido");
	}
	public void imprimirtodos(ArrayList<Cliente> lista) {
		if(lista.size() > 0 ) {
			for(int i = 0; i < lista.size(); i++) {
				imprimir(lista.get(i));
			}
		}else {
			IOGeneral.pritln("lista de clientes vacia");
		}
	}
//modificar nombre
	public int menumod() {
		return IOGeneral.leerInt("1) modificar nombre\n"+"2) salir", "ingresar valor valido");
	}
	public String leernuevonombrecliente(String nombre) {
		return IOGeneral.leerFrase("ingresar nombre nuevo de "+nombre);
	}
	public void modok(String nombre, String nombrenuevo,boolean ok) {
		if(ok == true) {
			IOGeneral.pritln("se modifico "+nombre+" a "+nombrenuevo+" con exito");
		}else {
			IOGeneral.pritln("no se encontro "+nombre);
		}
	}
//añadircompra
	public int menuañadir() {
		return IOGeneral.leerInt("1) añadir compra\n"+"2) salir", "ingresar valor valido");	
	}
	public void añadirok(boolean ok) {
		if(ok == true) {
			IOGeneral.pritln("se añadio con exito");
		}else {
			IOGeneral.pritln("no se encontro producto");
		}
	}
//sumar cuenta
	public int menusumacuenta() {
		return IOGeneral.leerInt("1) sumar cuenta\n"+"2) salir", "ingresar valor valido");
	}
	public int porcentajeinteres() {
		return IOGeneral.leerInt("ingresar porcentaje de interes", "ingresar valor valido");
	}
	public void mostrarcuenta(float cuenta){
		IOGeneral.pritln("cuenta : "+cuenta);
	}
//pago cuenta total
	public int menupagocuentatotal() {
		return IOGeneral.leerInt("1) pagar cuenta total cliente\n"+"2) salir", "ingresar valor valido");
	}
	public void pagototalol(String nombre, boolean ok) {
		if(ok == true) {
			IOGeneral.pritln("cliente "+nombre+" no debe nada");
		}else {
			IOGeneral.pritln("no se encotro "+nombre);
		}
	}
//pago cuenta parcial
	public int menupagoparcial() {
		return IOGeneral.leerInt("1) pagar cuenta parcialmente\n"+"2) salir", "ingresar valor validoi");
	}
	public float leerpago(String nombre) {
		return IOGeneral.leerFloat("ingresar pago: ", "ingresar valor valido");
	}
	public void pagoparcialok(String nombre, float debe) {
		if(debe != 0) {
			IOGeneral.pritln("Cliente debe: "+debe);
		}else {
			IOGeneral.pritln("no se encontro "+nombre);
		}

	}
}
