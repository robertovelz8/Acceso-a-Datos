package models;

import java.util.Objects;

public class Pokemon {
	
	//Attributes
	private String idPokemon;
	private String species;
	private int dex;
	private String type;
	private Abilities abilities;
	private int life;
	private RateType puntuacion;
	
	//Constructors
	public Pokemon(String idPokemon, String species, int dex, String type, Abilities abilities, int life,
			RateType puntuacion) {
		super();
		this.idPokemon = idPokemon;
		this.species = species;
		this.dex = dex;
		this.type = type;
		this.abilities = abilities;
		this.life = life;
		this.puntuacion = puntuacion;
	}

	public Pokemon(String idPokemon) {
		super();
		this.idPokemon = idPokemon;
	}

	public Pokemon() {
		super();
	}

	
	//Getters & Setters
	
	public String getIdPokemon() {
		return idPokemon;
	}

	public void setIdPokemon(String idPokemon) {
		this.idPokemon = idPokemon;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Abilities getAbilities() {
		return abilities;
	}

	public void setAbilities(Abilities abilities) {
		this.abilities = abilities;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public RateType getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(RateType puntuacion) {
		this.puntuacion = puntuacion;
	}

	//hasCode(), equals() & toString()
	@Override
	public int hashCode() {
		return Objects.hash(idPokemon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return Objects.equals(idPokemon, other.idPokemon);
	}

	@Override
	public String toString() {
		return "Pokemon [idPokemon=" + idPokemon + ", species=" + species + ", dex=" + dex + ", type=" + type
				+ ", abilities=" + abilities + ", life=" + life + ", puntuacion=" + puntuacion + "]";
	}
	
	

	
	
}
