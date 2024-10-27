package models;

import java.util.List;
import java.util.Objects;

public class Combinacion {
	//Attributes
		private String fecha;
		private List<Integer> combinacion_ganadora;
		private List<Integer> estrellas;
		
		//Constructors
		public Combinacion(String fecha, List<Integer> combinacion_ganadora, List<Integer> estrellas) {
			super();
			this.fecha = fecha;
			this.combinacion_ganadora = combinacion_ganadora;
			this.estrellas = estrellas;
		}
		public Combinacion() {
			super();
		}
		
		//Getters & Setters
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		public List<Integer> getNumeros() {
			return combinacion_ganadora;
		}
		public void setNumeros(List<Integer> numeros) {
			this.combinacion_ganadora = numeros;
		}
		public List<Integer> getEstrellas() {
			return estrellas;
		}
		public void setEstrellas(List<Integer> estrellas) {
			this.estrellas = estrellas;
		}
		
		//hashCode, equals & toString
		@Override
		public int hashCode() {
			return Objects.hash(estrellas, fecha, combinacion_ganadora);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Combinacion other = (Combinacion) obj;
			return Objects.equals(estrellas, other.estrellas) && Objects.equals(fecha, other.fecha)
					&& Objects.equals(combinacion_ganadora, other.combinacion_ganadora);
		}
		@Override
		public String toString() {
			return "Combinacion [fecha=" + fecha + ", numeros=" + combinacion_ganadora + ", estrellas=" + estrellas + "]";
		}
}
