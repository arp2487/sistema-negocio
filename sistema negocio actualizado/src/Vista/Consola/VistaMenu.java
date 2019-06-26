package Vista.Consola;

import util.IOGeneral;

public class VistaMenu {
	public int PresentarMenuGeneral() {
		return IOGeneral.leerInt("1) manejo de precios\n2) manejo clientes\n"
				+"3) manejo de marcas\n4) manejo de tipos\n5) ver compras\n"
				+ "6) salir", "ingresar valor valido");
	}
}
