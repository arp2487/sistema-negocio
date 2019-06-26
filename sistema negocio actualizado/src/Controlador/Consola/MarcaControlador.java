package Controlador.Consola;

import DAO.Factory.FactoryMarca;
import DAO.Interfaces.MarcaDAO;
import Vista.Consola.VistaMarca;

public class MarcaControlador {
	private MarcaDAO modelo = FactoryMarca.getDAO("archivo");
	private VistaMarca vista = new VistaMarca();
	
	

	
	public MarcaDAO getModelo() {
		return modelo;
	}

	public void setModelo(MarcaDAO modelo) {
		this.modelo = modelo;
	}

	public VistaMarca getVista() {
		return vista;
	}

	public void setVista(VistaMarca vista) {
		this.vista = vista;
	}

	public void alta() {
		int op = vista.menuAlta();
		
		while(op ==1) {
			modelo.alta(vista.altaMarca());
			op = vista.menuAlta();
		}
	}
	
	public void baja() {
		int op = vista.menuBaja();
		while(op == 1) {
			String nombre = vista.bajaMarca();
			boolean ok = modelo.baja(nombre);
			vista.BAjaok(ok, nombre);
			op = vista.menuBaja();
		}
	}
	
	public void modificacion() {
		int op = vista.menumodificacion();
		
		while(op == 1) {
			String nombre = vista.modificarMarca();
			String nuevonombre = vista.leernombrenuevo(nombre);
			boolean ok = modelo.modificacion(nombre, nuevonombre);
			vista.modificacionok(ok, nombre, nuevonombre);
			
			op = vista.menumodificacion();
		}
	}
	
	public void consulta() {
		int op = vista.menuconsulta();
		
		while(op == 1) {
			String nombre = vista.consultaMarca();
			vista.imprimirMarca(modelo.consulta(nombre));
			op = vista.menuconsulta();
		}
	}
	
	public void getall() {
			vista.imprimirMarcas(modelo.getall());
		
	}
	
	public void abm() {
		int op = vista.menuMarca();
		
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
			op = vista.menuMarca();
		}
	}
}
