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
        Manager m2 = new Manager();
        Manager m3 = new Manager();
        m1.setNombre("Jorge");
        m1.setApellido("Mendes");
        m1.setNacionalidad("portuguesa");
        m2.setNombre("Pere");
        m3.setNombre("Mino");
        m2.setApellido("Guardiola");
        m3.setApellido("Raiola");
        m2.setNacionalidad("española");
        m3.setNacionalidad("italiana");
        service.createManager(m1);
        service.createManager(m2);
        service.createManager(m3);

        Jugador j1 = new Jugador("Leo Messi", "CF", "1983-07-12", 10, m1);
        Jugador j2 = new Jugador("Cristiano Ronaldo", "DC", "1912-04-22", 7, m1);
        Jugador j3 = new Jugador("Lamine Yamal", "ED", "2006-11-01", 32, m1);
        Jugador j4 = new Jugador("Fede Valverde", "MC", "2001-03-17", 15, m1);
        Jugador j5 = new Jugador("Keylor Navas", "POR", "1949-11-23", 1, m1);
        Jugador j6 = new Jugador("Karamoko Dembélé", "MP", "2003-12-11", 7, m1);

        m1.setJugador(j1);
        m1.setJugador(j2);
        m1.setJugador(j3);
        m1.setJugador(j4);
        m1.setJugador(j5);
        m1.setJugador(j6);

        Estadio estadio1 = new Estadio("Benito Villamarín", 47213, "Heliópolis");
        Estadio estadio2 = new Estadio("Sánchez Pizjuán", 19312, "Nervión");
        // CREATE operaciones
        service.createLiga(liga1);
        service.createPartido(p1);
        service.createEstadio(estadio1);
        service.createEstadio(estadio2);
        service.createJugador(j1);
        service.createJugador(j2);
        service.createJugador(j3);
        service.createJugador(j4);
        service.createJugador(j5);
        service.createJugador(j6);

        // Se maneja el error relacionado con las entidades de relaciones como Liga y Arbitro
        Equipo eq3 = new Equipo("Málaga CF", "1963-11-21", liga1);
        Equipo eq4 = new Equipo("FC Barcelona", "1972-03-19", liga1);
        Equipo eq5 = new Equipo("RCD Espanyol", "1921-05-12", liga1);
        Equipo eq6 = new Equipo("Rayo Vallecano de Madrid", "1943-09-12", liga1);
        equipos.add(eq3);
        equipos.add(eq4);
        equipos.add(eq5);
        equipos.add(eq6);
        service.createEquipo(eq3);
        service.createEquipo(eq4);
        service.createEquipo(eq5);
        service.createEquipo(eq6);
        
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
        //service.deleteEstadio(estadio1);
        
        //1.1 Una consulta a la BBDD que restrinja el número de elementos devueltos de una lista a 1.
        logger.debug(service.findEquipo());
        
        //1.2. Una consulta que devuelva un campo de una tabla
        logger.debug(service.findNombreByArbitro());
        
        //1.3. Una consulta que devuelva dos campos o más de una misma tabla.
        service.findFechaNacimientoAndPosicionByJugador();
        
        //1.4. Dos consultas parametrizadas.
        logger.debug(service.findEstadioByCapacidad());
        logger.debug(service.findEstadioByUbicacion());
        
        //1.5. Una consulta con avg y otra con count
        logger.debug(service.findNumeroEstadiosByCount()); //COUNT
        logger.debug(service.findPromedioCapacidadByAvg()); //AVG
        
        //1.6. Una consulta que filtre y ordene
        logger.debug(service.findJugadoresJugadoresByFilterAndOrderBy());
        
        //2
        service.actualizarNacionalidadManager(); //CRITERIA UPDATE
        service.eliminarManager(); //CRITERIA DELETE
    }
}
