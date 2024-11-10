package utilidades;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import modelos.Droguita;
import modelos.Yonki;

public class ManejaJsonCSVDroguitas {
	private static final Logger logger = LogManager.getLogger(ManejaJsonCSVDroguitas.class);

	
//JSON
	
	//TRAER DATOS DE JSON
	
public Droguita getDroguita(String rutaFichero) {
	Droguita e = null;

	try {
		FileReader fichero = new FileReader(rutaFichero);
		Gson gson = new Gson();
		e = gson.fromJson(fichero, Droguita.class); //cuando solo hay 1 para recibir 

	}
	catch(FileNotFoundException err) {
		
	}
	return e;
}

public List<Droguita> getDroguitasJson(String rutaFichero) {
	Droguita[] e = null;
	List<Droguita> droguitas=null;

	try {
		FileReader fichero = new FileReader(rutaFichero);
		Gson gson = new Gson();
		e = gson.fromJson(fichero, Droguita[].class); //cuando  hay muchos para recibir 
		droguitas = Arrays.asList(e);
	}
	catch(FileNotFoundException err) {
		
	}
	return droguitas;
}
public List<Yonki> getYonkisJson(String rutaFichero) {
	Yonki[] e = null;
	List<Yonki> yonketas=null;

	try {
		FileReader fichero = new FileReader(rutaFichero);
		Gson gson = new Gson();
		e = gson.fromJson(fichero, Yonki[].class); //cuando  hay muchos para recibir 
		yonketas = Arrays.asList(e);
	}
	catch(FileNotFoundException err) {
		
	}
	return yonketas;
} 

//ESCRIBIR DATOS EN JSON
public void escribeDroguitasJson(List<Droguita> lista, String ruta) {	// Convertir el objeto a JSON
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String json = gson.toJson(lista);
	// Escribir el JSON en un archivo
	FileWriter writer = null;
	try {
		writer = new FileWriter(ruta);
		writer.write(json);
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (writer != null) {
			try { 	writer.close(); } 
catch (IOException e) {e.printStackTrace();	}
}	}	}
public void escribeYonkisJson(List<Yonki> lista, String ruta) {	// Convertir el objeto a JSON
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String json = gson.toJson(lista);
	// Escribir el JSON en un archivo
	FileWriter writer = null;
	try {
		writer = new FileWriter(ruta);
		writer.write(json);
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (writer != null) {
			try { 	writer.close(); } 
catch (IOException e) {e.printStackTrace();	}
}	}	}


//CSV
//Leer CSV
public List<Droguita> leeDroguitasDeFicheroCsv(String rutayNombreFichero) {
	Scanner in = null;
	List <Droguita> droguis= new ArrayList<Droguita>();
	try {
		FileReader fichero = new FileReader(rutayNombreFichero);
		in = new Scanner(fichero);
        in.useDelimiter("\n"); //el delimitador es para que coja el salto de línea
		in.useLocale(Locale.ENGLISH);
		in.nextLine();
		while(in.hasNextLine()) {
			String linea = in.next(); // Leer la línea completa
            String[] partes = linea.split(","); // Dividir la línea en partes

            Droguita p = new Droguita();
            p.setTipo(Droguita.TipoDroguita.valueOf(partes[0].toUpperCase())); // Asignar el nombre con el primer índice del array
            p.setNombre(partes[1]);
            p.setDosis(Double.parseDouble(partes[2]));
            p.setPaisDeProcedencia(partes[3]);
            p.setMortal(Boolean.parseBoolean(partes[4]));
            // Leer las notas, si hay
           /* for (int i = 1; i < partes.length; i++) {
                try {
                    p.add(Double.parseDouble(partes[i].trim())); // Convertir y agregar las notas
                } catch (NumberFormatException e) {
                    logger.error("Error al convertir la nota: " + partes[i]);
                }
            }*/
            droguis.add(p);
		}

	}catch(FileNotFoundException e) {//para no propagarlo al main. EL manejo de excepciones debe hacerse antes del controlador
		logger.error("Excepcion al acceder al fichero " + rutayNombreFichero + e.getMessage());
	}
	finally {
		if (in != null) {
			in.close();
		}
	}
	return droguis;
}
public List<Yonki> leeYonkisDeFicheroCsv(String rutayNombreFichero) {
	Scanner in = null;
	List <Yonki> yonkarras= new ArrayList<Yonki>();
	try {
		FileReader fichero = new FileReader(rutayNombreFichero);
		in = new Scanner(fichero);
        in.useDelimiter("\n"); //el delimitador es para que coja el salto de línea
		in.useLocale(Locale.ENGLISH);
		in.nextLine();

		while(in.hasNextLine()) {
			String linea = in.next(); // Leer la línea completa
            String[] partes = linea.split(","); // Dividir la línea en partes

            Yonki p = new Yonki();
            p.setDetenciones(Integer.parseInt(partes[0])); // Asignar el nombre con el primer índice del array
            p.setNombre(partes[1]);
            p.setEdad(Integer.parseInt(partes[2]));
            p.setCiudadDeProcedencia(partes[3]);
            p.setAdiccion(partes[4]);
            p.setProyectoHombre(Boolean.parseBoolean(partes[5]));
            p.setDineroInvertido(Double.parseDouble(partes[6]));
            p.setGenero(Yonki.Genero.valueOf(partes[7].trim().toUpperCase()));
            // Leer las notas, si hay
           /* for (int i = 1; i < partes.length; i++) {
                try {
                    p.add(Double.parseDouble(partes[i].trim())); // Convertir y agregar las notas
                } catch (NumberFormatException e) {
                    logger.error("Error al convertir la nota: " + partes[i]);
                }
            }*/
            yonkarras.add(p);
		}

	}catch(FileNotFoundException e) {//para no propagarlo al main. EL manejo de excepciones debe hacerse antes del controlador
		logger.error("Excepcion al acceder al fichero " + rutayNombreFichero + e.getMessage());
	}
	finally {
		if (in != null) {
			in.close();
		}
	}
	return yonkarras;
}

//Escribir CSV
	public  void escribeDroguitasCSV(List<Droguita> droguis, String rutaFichero){
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
				ficheroSalida = new FileWriter(rutaFichero);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			out.printf("%s%n", escribeCabecera());
			for(Droguita p: droguis) {
				out.printf(Locale.US,"%s,%s,%.1f,%s,%s%n", //Locale.US es para que use puntos en lugar de comas al crear el csv
						p.getTipo(),p.getNombre(),p.getDosis(), p.getPaisDeProcedencia(),p.isMortal());
			}		}
		catch (IOException e) {
					System.out.println("IOException");		}
		finally		{
			if (out!=null)
				out.close();
		}	
	}
	private String escribeCabecera() {
		String cabecera = "tipo,nombre,dosis,paisDeProcedencia,mortal";
		return cabecera;
	}
	public  void escribeYonkisCSV(List<Yonki> coleguillas, String rutaFichero){
		PrintWriter out = null;
		try {
			FileWriter ficheroSalida;
				ficheroSalida = new FileWriter(rutaFichero);
			// abre el fichero de texto
			out = new PrintWriter(ficheroSalida);
			// escribe el listado persona a persona
			out.printf("%s%n", escribeCabeceraY());
			for(Yonki p: coleguillas) {
				out.printf(Locale.US,"%d,%s,%d,%s,%s,%s,%.2f,%s%n", 
						p.getDetenciones(),p.getNombre(),p.getEdad(), p.getCiudadDeProcedencia(),p.getAdiccion(), p.isProyectoHombre(),p.getDineroInvertido(),p.getGenero());
			}		}
		catch (IOException e) {
					System.out.println("IOException");		}
		finally		{
			if (out!=null)
				out.close();
		}	
	}
	private String escribeCabeceraY() {
		String cabecera = "detenciones,nombre,edad,ciudadDeProcedencia,adiccion,proyectoHombre,dineroInvertido,genero";
		return cabecera;
	}
}

