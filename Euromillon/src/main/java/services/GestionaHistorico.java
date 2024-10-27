package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GestionaHistorico {

	private CombinacionService servicio;

    public GestionaHistorico(CombinacionService servicio) {
        this.servicio = servicio;
    }

    public void generarFicheroResumen(String filePath) {
         

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Combinación más frecuente: "+servicio.combinacionMasFrecuente()+"\n");
            writer.write("Estrella más frecuente: "+servicio.estrellaMasRepetida());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
