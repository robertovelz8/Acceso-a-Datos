package controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.Arbitro;
import models.Equipo;
import models.Estadio;
import models.Jugador;
import models.Liga;
import models.Manager;
import models.Partido;
import services.Service;

/**
 * Clase que gestiona la creación, actualización, obtención y eliminación de
 * entidades relacionadas con un torneo de fútbol, como Ligas, Equipos, 
 * Jugadores, Arbitros, Partidos, Estadios y Managers.
 * 
 * Esta clase actúa como controlador en una aplicación para gestionar torneos,
 * utilizando la capa de servicios que interactúa con los DAOs para manejar las
 * operaciones CRUD sobre las entidades del modelo.
 * 
 * Los datos de ejemplo se crean en el método {@link #main(String[])} y se 
 * utilizan para realizar las operaciones CRUD sobre las entidades.
 */
public class GestionTorneosController {
    
    /**
     * Logger utilizado para registrar los eventos y actividades del controlador.
     */
    private static final Logger logger = LogManager.getLogger(GestionTorneosController.class);

    /**
     * Método principal que simula la gestión de un torneo de fútbol.
     * Este método crea objetos de las entidades Liga, Equipo, Partido, Arbitro, 
     * Manager, Jugador y Estadio, y luego realiza operaciones CRUD como:
     * 
     * - Crear nuevas entidades.
     * - Actualizar las entidades existentes.
     * - Obtener todas las entidades de la base de datos.
     * - Eliminar entidades.
     * 
     * Utiliza el servicio {@link services.Service} para realizar las operaciones
     * sobre la base de datos.
     * 
     * @param args argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        Service service = new Service();
        
        // Crear e inicializar entidades
        Liga liga1 = new Liga();
        liga1.setNombre("Liga Santander");
        liga1.setPais("España");
        liga1.setNivel("Primera División");

        Equipo eq1 = new Equipo("Betis", "1843", liga1);
        Equipo eq2 = new Equipo("Cádiz", "1911", liga1);
        List<Equipo> equipos = new ArrayList<>();
        equipos.add(eq1);
        equipos.add(eq2);
        liga1.setEquipos(equipos);

        Partido p1 = new Partido();
        List<Partido> partidos = new ArrayList<Partido>();
        partidos.add(p1);

        Arbitro a1 = new Arbitro("Mateu Lahoz", "española", "11 años", partidos);
        Arbitro a2 = new Arbitro("Del Cerro", "española", "5 años", partidos);
        List<Arbitro> arbitros = new ArrayList<>();
        arbitros.add(a2);
        arbitros.add(a1);
        
        p1.setFecha("2011-12-03");
        p1.setResultado("2-0");
        p1.setArbitros(arbitros);
        liga1.setArbitros(arbitros);
        
        Manager m1 = new Manager();
        m1.setNombre("Jorge");
        m1.setApellido("Mendes");
        m1.setNacionalidad("portuguesa");
        service.createManager(m1);

        Jugador j1 = new Jugador("Leo Messi", "CF", "1983-07-12", 10, m1);
        m1.setJugador(j1);

        Estadio estadio1 = new Estadio("Benito Villamarín", 47213, "Heliópolis");
        
        // CREATE operaciones
        service.createLiga(liga1);
        service.createPartido(p1);
        service.createEstadio(estadio1);
        service.createJugador(j1);

        // Se maneja el error relacionado con las entidades de relaciones como Liga y Arbitro
        Equipo eq3 = new Equipo("Málaga CF", "1963-11-21", liga1);
        equipos.add(eq3);
        service.createEquipo(eq3);
        
        // UPDATE operaciones
        a1.setNacionalidad("inglesa");
        service.updateArbitro(a1);
        
        j1.setDorsal(1);
        service.updateJugador(j1);
        
        p1.setResultado("3-4");
        service.updatePartido(p1);
        
        estadio1.setNombre("Santiago Bernabéu");
        service.updateEstadio(estadio1);
        
        liga1.setNombre("Liga BBVA");
        service.updateLiga(liga1);
        
        eq1.setFundacion("1911-02-05");
        service.updateEquipo(eq1);
        m1.setNombre("Padre de Neymar");
        service.updateManager(m1);
        
        // GET operaciones
        logger.debug(service.getAllLigas());
        logger.debug(service.getAllArbitros());
        logger.debug(service.getAllEstadios());
        logger.debug(service.getAllJugadores());
        logger.debug(service.getAllPartidos());
        logger.debug(service.getAllEquipos());
        
        // DELETE operación
        service.deleteEstadio(estadio1);
    }
}
