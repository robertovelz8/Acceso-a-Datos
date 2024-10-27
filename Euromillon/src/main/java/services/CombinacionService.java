package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Combinacion;
import repositories.HistoricoCombinaciones;

public class CombinacionService {
	 private HistoricoCombinaciones historico;

	    public CombinacionService (HistoricoCombinaciones historico) {
	        this.historico = historico;
	    }

	    
	    public int estrellaMasRepetida() {
	    	List<Integer> estrellas = new ArrayList<>();

	        for (Combinacion combi : historico.getCombinaciones()) {
	            for (int estrella : combi.getEstrellas()) {
	                estrellas.add(estrella);
	            }
	        }

	        Map<Integer, Integer> frecuencia = new HashMap<>();
	        int estrellaMasRepetida = -1; //No se ha encontrado de momento ninguna estrella repetida
	        int maxRepeticiones = 0; //Numero de ocurrencias de cada estrella

	        for (int estrella : estrellas) {
	            int contador = frecuencia.getOrDefault(estrella, 0) + 1;
	            frecuencia.put(estrella, contador);

	            // Actualizar la estrella más repetida si es necesario
	            if (contador > maxRepeticiones) {
	                maxRepeticiones = contador;
	                estrellaMasRepetida = estrella;
	            }
	        }

	        return estrellaMasRepetida;
	    }
	    
	    public Map<List<Integer>, Integer> contarCombinacion() {
	    	Map<List<Integer>, Integer> frecuenciaCombinaciones = new HashMap<List<Integer>, Integer>();
	    	for (Combinacion combi : historico.getCombinaciones()) {
	    		List<Integer> combinacionesGanadoras = combi.getNumeros();
	    		
	    		int contador = frecuenciaCombinaciones.getOrDefault(combinacionesGanadoras, 0) + 1;
	    		frecuenciaCombinaciones.put(combinacionesGanadoras, contador);
	    	}
	    	return frecuenciaCombinaciones;
	    }
	    
	    public List<Integer> combinacionMasFrecuente () {
	    	Map<List<Integer>, Integer> frecuenciaCombinaciones = contarCombinacion();
	    	
	    	List<Integer> combinacionMasFrecuente = new ArrayList<Integer>();
	    	int frecuencia = 0;
	    	
	    	for (Map.Entry<List<Integer>, Integer> entry : frecuenciaCombinaciones.entrySet()) {
	    		if (entry.getValue() > frecuencia) {
	    			frecuencia = entry.getValue();
	    			combinacionMasFrecuente = entry.getKey();
	    		}
	    	}
	    	return combinacionMasFrecuente;
	    }
}
