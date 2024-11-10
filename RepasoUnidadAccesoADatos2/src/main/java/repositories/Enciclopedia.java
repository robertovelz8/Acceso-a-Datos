package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Pokemon;

public class Enciclopedia {
	
	//Attributes
	private List<Pokemon> pokemons;

	public Enciclopedia() {
		super();
		pokemons = new ArrayList<Pokemon>();
	}
	
	public void createPokemon(String identificador) {
		Pokemon p1 = new Pokemon(identificador);
		pokemons.add(p1);
	}
	
	public Pokemon consultarPokemon(String identificador) {
		Pokemon p = null;
		boolean encontrado = false;
		int i = 0;
		Pokemon p2 = new Pokemon();
		p2.setIdPokemon(identificador);
		while(i<pokemons.size() && !encontrado) {
			if(pokemons.get(i).equals(p2)) {
				p = pokemons.get(i);
				encontrado = true;
			}else {
				i++;
			}
		}
		
		return p;
	}
	
}
