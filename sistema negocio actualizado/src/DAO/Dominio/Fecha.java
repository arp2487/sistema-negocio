package DAO.Dominio;

import java.util.Calendar;


public class Fecha {
		public int dia;
		public int mes;
		public int a�o;
		

		public int getDia() {
			return dia;
		}

		public void setDia(int dia) {
			this.dia = dia;
		}

		public int getMes() {
			return mes;
		}

		public void setMes(int mes) {
			this.mes = mes;
		}

		public int getA�o() {
			return a�o;
		}

		public void setA�o(int a�o) {
			this.a�o = a�o;
		}

		public void setFecha() {
			Calendar calendario = Calendar.getInstance();
			
			this.dia = calendario.get(Calendar.DATE);
			this.mes = calendario.get(Calendar.MONTH) + 1;
			this.a�o = calendario.get(Calendar.YEAR);
		}
		

		public Fecha getFecha() {
			Fecha fecha = new Fecha(this.dia,this.mes,this.a�o);
			return fecha;
		}
		
		public Fecha() {
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + a�o;
			result = prime * result + dia;
			result = prime * result + mes;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Fecha other = (Fecha) obj;
			if (a�o != other.a�o)
				return false;
			if (dia != other.dia)
				return false;
			if (mes != other.mes)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Fecha [" + dia + "/" + mes + "/" + a�o + "]";
		}

		public Fecha(int dia, int mes, int a�o) {
			super();
			this.dia = dia;
			this.mes = mes;
			this.a�o = a�o;
		}
	
}
