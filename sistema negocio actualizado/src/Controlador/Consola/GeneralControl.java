package Controlador.Consola;

import Vista.Consola.VistaMenu;

public class GeneralControl {
	private VistaMenu vista = new VistaMenu();

	public VistaMenu getVista() {
		return vista;
	}

	public void setVista(VistaMenu vista) {
		this.vista = vista;
	}
	public void abmcGeneral(ProductoControlador pc, ClienteControlador cc,Tipocontrolador tc,
			MarcaControlador mc, CompraControlador cxc) {
		
		int op = vista.PresentarMenuGeneral();
		while(op != 6) {
			if(op ==1) {
				pc.abmc(tc, mc);
			}
			if(op ==2) {
				cc.abm(cxc);
			}
			if(op ==3) {
				mc.abm();
			}
			if(op ==4) {
				tc.abm();
			}
			if(op == 27) {
				cxc.abc(pc);
			}
			op = vista.PresentarMenuGeneral();
		}
	}
}
