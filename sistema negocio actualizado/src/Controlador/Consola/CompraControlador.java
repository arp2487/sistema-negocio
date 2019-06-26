package Controlador.Consola;

import DAO.Factory.FactoryCompra;
import DAO.Interfaces.CompraDAO;
import Vista.Consola.VistaCompra;

public class CompraControlador {
	private CompraDAO modelo = FactoryCompra.getDAO("archivo");
	private VistaCompra vista = new VistaCompra();
	public CompraDAO getModelo() {
		return modelo;
	}
	public void setModelo(CompraDAO modelo) {
		this.modelo = modelo;
	}
	public VistaCompra getVista() {
		return vista;
	}
	public void setVista(VistaCompra vista) {
		this.vista = vista;
	}
	
	public void alta(ProductoControlador pc) {
		int op = vista.menualta();
		while(op == 1) {
			String nombreproducto = vista.leernombreproducto();
			String marcaproducto = vista.leermarcaproducto();
			boolean ok =  modelo.alta(nombreproducto, marcaproducto, vista.crearcompra());
			vista.altaok(nombreproducto, marcaproducto, ok);
			
			op = vista.menualta();
		}
	}
	public void baja() {
		int op = vista.menubaja();
		while(op == 1) {
			int id = vista.leeridbaja();
			boolean ok = modelo.baja(id);
			vista.bajaok(id, ok);
			op = vista.menubaja();
		}
	}
	
	public void consulta() {
		int op = vista.menuconsullta();
		while(op == 1) {
			int idcompra = vista.leeid();
			vista.imprimir(modelo.consulta(idcompra));
			
			op = vista.menuconsullta();
		}
	}
	public void getall() {
		int op = vista.menugetall();
		while(op == 1) {
			vista.imprimirtodos(modelo.getall());
			op = vista.menugetall();
		}
	}
	
	public void abc(ProductoControlador pc) {
		int op = vista.menuprincipal();
		while(op != 5) {
			if(op == 1) {
				alta(pc);
			}
			if(op == 2) {
				baja();
			}
			if(op == 3) {
				consulta();
			}
			if(op == 4) {
				getall();
			}
			op = vista.menuprincipal();
		}
	}
}
