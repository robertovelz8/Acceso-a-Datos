package utilidadesFicheros;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;

import models.Criatura;
import models.Tipo;
import services.CriaturaServicio;

public class ManejaFicheroCriaturas {
    
	private static final Logger logger = LogManager.getLogger(ManejaFicheroCriaturas.class);
    public List<Criatura> leoCSVCriatura(String rutaFichero) {
        List<Criatura> listaCriaturas = new ArrayList<>();
        Set<Criatura> criaturasRegistradas = new HashSet<>();
        Scanner sc = null;
        try {
            FileReader fichero = new FileReader(rutaFichero);
            sc = new Scanner(fichero);
            sc.useLocale(Locale.ENGLISH);
            
            if (sc.hasNextLine()) {
                sc.nextLine(); 
            }
            
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] datos = linea.split(",");
                
                Criatura cr1 = new Criatura();
                cr1.setNombre(datos[0]);
                cr1.setInmortal(Boolean.parseBoolean(datos[1]));
                cr1.setPeligrosidad(Integer.parseInt(datos[2]));
                cr1.setMagia(Integer.parseInt(datos[3]));
                
                Tipo tipo = Tipo.valueOf(datos[4].toUpperCase());
                cr1.setTipo(tipo);
                
                if (criaturasRegistradas.contains(cr1)) {
                    logger.error("Criatura duplicada: " + cr1.getNombre());
                } else {
                    listaCriaturas.add(cr1);
                    criaturasRegistradas.add(cr1);
                }
            }
        } catch (FileNotFoundException e) {
            logger.error("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            logger.error("Error al leer el archivo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("Error en el formato del tipo: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Error inesperado: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        return listaCriaturas;
    }
    
    public void imprimirCriaturasCSV(List<Criatura> criaturas) {
        logger.debug("nombre,inmortal,peligrosidad,magia,tipo");
        
        for (Criatura cr : criaturas) {
            logger.debug(
                cr.getNombre() + "," +
                cr.isInmortal() + "," +
                cr.getPeligrosidad() + "," +
                cr.getMagia() + "," +
                cr.getTipo()
            );
        }
    }
    
    public void generaFicheroResumen(String rutaFichero, List<Criatura> criaturas) {
        try (FileWriter fw = new FileWriter(rutaFichero); 
             PrintWriter pw = new PrintWriter(fw)) {
            
            for (Tipo tipo : Tipo.values()) {
                pw.println("=================================================");
                pw.println(tipo);
                pw.println("=================================================");
                
                List<Criatura> criaturasPorTipo = criaturas.stream()
                        .filter(criatura -> criatura.getTipo() == tipo)
                        .collect(Collectors.toList());
                
                for (Criatura cr : criaturasPorTipo) {
                    pw.println(cr.getNombre() + " " +
                               cr.isInmortal() + " " +
                               cr.getPeligrosidad() + " " +
                               cr.getMagia());
                }
                
                pw.println();
            }
            
            logger.debug("Resumen generado correctamente en: " + rutaFichero);
        } catch (IOException e) {
            logger.error("Error al escribir el archivo: " + e.getMessage());
        }
    }
}

