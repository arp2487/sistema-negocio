import Controlador.Consola.ClienteControlador;
import Controlador.Consola.CompraControlador;
import Controlador.Consola.MarcaControlador;
import Controlador.Consola.ProductoControlador;
import Controlador.Consola.Tipocontrolador;
import DAO.Dominio.Fecha;

public class main {

	public static void main(String[] args) {
		Tipocontrolador tc = new Tipocontrolador();
		MarcaControlador mc = new MarcaControlador();
		ProductoControlador pc = new ProductoControlador();
		CompraControlador cc = new CompraControlador();
		ClienteControlador clc = new ClienteControlador();
		clc.abm(cc);
	}

}
