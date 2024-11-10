package modelos;

import java.util.ArrayList;
import java.util.List;

public class Droguita  {
	public enum TipoDroguita{  INYECTADA, ESNIFADA, FUMADA, INGERIDA}
	private TipoDroguita tipo;
	private String nombre;
	private double dosis;
	private String paisDeProcedencia;
	private boolean mortal;
	private List<Yonki> enganchaos;
	
	public Droguita() {
		this.enganchaos= new ArrayList<>();
	}
	public Droguita(TipoDroguita tipo, String nombre, double dosis, String paisDeProcedencia, boolean mortal,
			List<Yonki> enganchaos) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
		this.dosis = dosis;
		this.paisDeProcedencia = paisDeProcedencia;
		this.mortal = mortal;
		this.enganchaos = enganchaos;
	}
	public TipoDroguita getTipo() {
		return tipo;
	}
	public void setTipo(TipoDroguita tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getDosis() {
		return dosis;
	}
	public void setDosis(double dosis) {
		this.dosis = dosis;
	}
	public String getPaisDeProcedencia() {
		return paisDeProcedencia;
	}
	public void setPaisDeProcedencia(String paisDeProcedencia) {
		this.paisDeProcedencia = paisDeProcedencia;
	}
	public boolean isMortal() {
		return mortal;
	}
	public void setMortal(boolean mortal) {
		this.mortal = mortal;
	}
	public List<Yonki> getEnganchaos() {
		return enganchaos;
	}
	public void setEnganchaos(List<Yonki> enganchaos) {
		this.enganchaos = enganchaos;
	}
	
	

}
