package modelo;

import java.util.Objects;

public class Editorial {
	
	private String cif;
	private String nombre;
	private String direccion;
	private String web;
	private String email;
	
	public Editorial(String cif) {
		super();
		this.cif = cif;
	}

	public Editorial(String cif, String nombre) {
		super();
		this.cif = cif;
		this.nombre = nombre;
	}

	
	public Editorial(String cif, String nombre, String direccion, String web, String email) {
		super();
		this.cif = cif;
		this.nombre = nombre;
		this.direccion = direccion;
		this.web = web;
		this.email = email;
	}

	public String getCif() {
		return cif;
	}


	public void setCif(String cif) {
		this.cif = cif;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getWeb() {
		return web;
	}


	public void setWeb(String web) {
		this.web = web;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Editorial [cif=" + cif + ", nombre=" + nombre + ", direccion=" + direccion + ", web=" + web + ", email="
				+ email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cif);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Editorial other = (Editorial) obj;
		return Objects.equals(cif, other.cif);
	}
	
	

}
