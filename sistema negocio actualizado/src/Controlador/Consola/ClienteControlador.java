package Controlador.Consola;

import DAO.Factory.FactoryCliente;
import DAO.Interfaces.ClienteDAO;
import Vista.Consola.VistaCliente;

public class ClienteControlador {
	private ClienteDAO modelo = FactoryCliente.getDAO("archivo");
	private VistaCliente vista = new VistaCliente();
	public ClienteDAO getModelo() {
		return modelo;
	}
	public void setModelo(ClienteDAO modelo) {
		this.modelo = modelo;
	}
	public VistaCliente getVista() {
		return vista;
	}
	public void setVista(VistaCliente vista) {
		this.vista = vista;
	}
	public void alta() {
		int op = vista.menualta();
		while(op == 1) {
			modelo.alta(vista.leercliente());
			
			op = vista.menualta();
		}
	}
	public void baja() {
		int op = vista.menubaja();
		while(op == 1) {
			String nombre = vista.leecliente();
			boolean ok = modelo.baja(nombre);
			vista.bajaok(nombre, ok);
			
			op = vista.menubaja();
		}
	}
	
	public void modificacion() {
		int op = vista.menumod();
		while(op == 1) {
			String nombre = vista.leecliente();
			String nombrenuevo = vista.leernuevonombrecliente(nombre);
			boolean ok = modelo.modificarNombre(nombre, nombrenuevo);
			vista.modok(nombre, nombrenuevo, ok);
			
			op = vista.menumod();
		}
	}
	public void consulta(){
		int op = vista.menuconsulta();
		while(op == 1) {
			String nombre = vista.leecliente();
			vista.imprimir(modelo.consulta(nombre));
			op = vista.menuconsulta();
		}
	}
	public void getall() {
		int op = vista.menugetall();
		while(op == 1) {
			vista.imprimirtodos(modelo.getall());
			op = vista.menugetall();
		}
	}
	public void sumarcuenta() {
		int op = vista.menusumacuenta();
		while(op == 1) {
			String nombre = vista.leecliente();
			int interes = vista.porcentajeinteres();
			float cuenta = modelo.sumarCuenta(nombre, interes);
			vista.mostrarcuenta(cuenta);
			op = vista.menusumacuenta();
		}
	}
	public void pagoparcial() {
		int op = vista.menupagoparcial();
		while(op == 1) {
			String nombre = vista.leecliente();
			float pago = vista.leerpago(nombre);
			float debe = modelo.pagoCuentaParcial(nombre, pago);
			vista.pagoparcialok(nombre, debe);
			op = vista.menupagoparcial();
		}
	}
	public void pagototal() {
		int op = vista.menupagocuentatotal();
		while(op == 1) {
			String nombre = vista.leecliente();
			boolean ok = modelo.pagoCuenta(nombre);
			vista.pagototalol(nombre, ok);
			
			op = vista.menupagocuentatotal();
		}
	}
	
	public void añadircompra(CompraControlador cc) {
		int op = vista.menuañadir();
		while(op == 1) {
			String nombre = vista.leecliente();
			boolean ok = modelo.añadircompra(nombre, cc.alta());
			vista.añadirok(ok);
			op = vista.menuañadir();
		}
	}
	public void abm(CompraControlador cc) {
		int op = vista.menuprincipal();
		while(op != 10) {
			if(op == 1) {
				alta();
			}
			if(op == 2) {
				baja();
			}
			if(op == 3) {
				modificacion();
			}
			if(op == 4) {
				consulta();
			}
			if(op == 5) {
				getall();
			}
			if(op == 6) {
				sumarcuenta();
			}
			if(op == 7) {
				pagoparcial();
			}
			if(op == 8) {
				pagototal();
			}
			if(op == 9) {
				añadircompra(cc);
			}
			op = vista.menuprincipal();
		}
	}
}
