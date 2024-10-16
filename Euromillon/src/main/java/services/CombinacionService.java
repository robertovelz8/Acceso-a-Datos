package services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import models.Combinacion;
import repositories.HistoricoCombinaciones;

public class CombinacionService {
	 private HistoricoCombinaciones historico;

	    public CombinacionService (HistoricoCombinaciones historico) {
	        this.historico = historico;
	    }

	    // Método que calcula el número y la estrella más frecuentes
	    public Map<String, Integer> calcularMasFrecuentes() {
	        Map<Integer, Integer> numeroFrecuencias = new HashMap<>();
	        Map<Integer, Integer> estrellaFrecuencias = new HashMap<>();

	        for (Combinacion combinacion : historico.getCombinaciones()) {
	            for (int numero : combinacion.getNumeros()) {
	                numeroFrecuencias.put(numero, numeroFrecuencias.getOrDefault(numero, 0) + 1);
	            }
	            for (int estrella : combinacion.getEstrellas()) {
	                estrellaFrecuencias.put(estrella, estrellaFrecuencias.getOrDefault(estrella, 0) + 1);
	            }
	        }

	        int numMasFrecuente = Collections.max(numeroFrecuencias.entrySet(), Map.Entry.comparingByValue()).getKey();
	        int estrellaMasFrecuente = Collections.max(estrellaFrecuencias.entrySet(), Map.Entry.comparingByValue()).getKey();

	        Map<String, Integer> resultado = new HashMap<>();
	        resultado.put("numero", numMasFrecuente);
	        resultado.put("estrella", estrellaMasFrecuente);
	        return resultado;
	    }

	    // Método que cuenta la frecuencia de cada combinación
	    public Map<String, Integer> calcularFrecuenciaCombinaciones() {
	        Map<String, Integer> combinacionFrecuencias = new HashMap<>();

	        for (Combinacion combinacion : historico.getCombinaciones()) {
	            String combinacionStr = combinacion.getNumeros().stream().map(Object::toString).collect(Collectors.joining("-"))
	                    + " Estrellas: " + combinacion.getEstrellas().stream().map(Object::toString).collect(Collectors.joining("-"));

	            combinacionFrecuencias.put(combinacionStr, combinacionFrecuencias.getOrDefault(combinacionStr, 0) + 1);
	        }
	        return combinacionFrecuencias;
	    }

	    // Método que devuelve la combinación más frecuente
	    public String obtenerCombinacionMasFrecuente() {
	        Map<String, Integer> frecuencias = calcularFrecuenciaCombinaciones();
	        return Collections.max(frecuencias.entrySet(), Map.Entry.comparingByValue()).getKey();
	    }
}
