package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class GestionaHistorico {

	private CombinacionService servicio;

    public GestionaHistorico(CombinacionService servicio) {
        this.servicio = servicio;
    }

    public void generarFicheroResumen(String filePath) {
        String combinacionMasFrecuente = servicio.obtenerCombinacionMasFrecuente();
        Map<String, Integer> masFrecuentes = servicio.calcularMasFrecuentes();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Combinación más frecuente: " + combinacionMasFrecuente + "\n");
            writer.write("Estrella más frecuente: " + masFrecuentes.get("estrella") + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
