package Controlador.Consola;

import DAO.Factory.FactoryTipo;
import DAO.Interfaces.TipoDAO;
import Vista.Consola.VistaTipo;

public class Tipocontrolador {
	private TipoDAO modelo = FactoryTipo.getDAO("archivo");
	private VistaTipo vista = new VistaTipo();
	
	
	public TipoDAO getModelo() {
		return modelo;
	}

	public void setModelo(TipoDAO modelo) {
		this.modelo = modelo;
	}

	public VistaTipo getVista() {
		return vista;
	}

	public void setVista(VistaTipo vista) {
		this.vista = vista;
	}
	
	
	
	public void alta() {
		int op = vista.menuAlta();
		
		while(op ==1) {
			modelo.alta(vista.altaTipo());
			op = vista.menuAlta();
		}
	}
	
	public void baja() {
		int op = vista.menuBaja();
		while(op == 1) {
			String nombre = vista.bajaTipo();
			boolean ok = modelo.baja(nombre);
			vista.BAjaok(ok, nombre);
			op = vista.menuBaja();
		}
	}
	
	public void modificacion() {
		int op = vista.menumodificacion();
		
		while(op == 1) {
			String nombre = vista.modificartipo();
			String nuevonombre = vista.leernombrenuevo(nombre);
			boolean ok = modelo.modificacion(nombre, nuevonombre);
			vista.modificacionok(ok, nombre, nuevonombre);
			
			op = vista.menumodificacion();
		}
	}
	
	public void consulta() {
		int op = vista.menuconsulta();
		
		while(op == 1) {
			String nombre = vista.consultatipo();
			vista.imprimirtipo(modelo.consulta(nombre));
			op = vista.menuconsulta();
		}
	}
	
	public void getall() {
			vista.imprimirtipos(modelo.getall());
		
	}
	
	public void abm() {
		int op = vista.menuTipo();
		
		while(op != 6){
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
			op = vista.menuTipo();
		}
	}
}
