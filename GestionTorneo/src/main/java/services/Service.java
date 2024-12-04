package services;

import java.util.List;
import java.util.Optional;

import dao.*;
import models.*;

/**
 * La clase Service actúa como intermediario entre los DAOs y los controladores
 * de la aplicación, proporcionando métodos CRUD para manejar las operaciones
 * sobre las entidades del modelo.
 */
public class Service {

    // Attributes

    /**
     * DAO para manejar las operaciones relacionadas con la entidad Arbitro.
     */
    private ArbitroDAO arbitroDAO;

    /**
     * DAO para manejar las operaciones relacionadas con la entidad Equipo.
     */
    private EquipoDAO equipoDAO;

    /**
     * DAO para manejar las operaciones relacionadas con la entidad Estadio.
     */
    private EstadioDAO estadioDAO;

    /**
     * DAO para manejar las operaciones relacionadas con la entidad Jugador.
     */
    private JugadorDAO jugadorDAO;

    /**
     * DAO para manejar las operaciones relacionadas con la entidad Liga.
     */
    private LigaDAO ligaDAO;

    /**
     * DAO para manejar las operaciones relacionadas con la entidad Partido.
     */
    private PartidoDAO partidoDAO;

    /**
     * DAO para manejar las operaciones relacionadas con la entidad Manager.
     */
    private ManagerDAO managerDAO;

    // Constructor

    /**
     * Crea una nueva instancia del servicio e inicializa los DAOs.
     */
    public Service() {
        arbitroDAO = new ArbitroDAO();
        equipoDAO = new EquipoDAO();
        estadioDAO = new EstadioDAO();
        jugadorDAO = new JugadorDAO();
        ligaDAO = new LigaDAO();
        partidoDAO = new PartidoDAO();
        managerDAO = new ManagerDAO();
    }

    // CRUD Arbitro

    /**
     * Crea un nuevo árbitro.
     *
     * @param arbitro el árbitro a crear.
     */
    public void createArbitro(Arbitro arbitro) {
        arbitroDAO.create(arbitro);
    }

    /**
     * Obtiene un árbitro por su ID.
     *
     * @param idArbitro el ID del árbitro.
     * @return un Optional que contiene el árbitro si se encuentra.
     */
    public Optional<Arbitro> getArbitro(int idArbitro) {
        return arbitroDAO.get(idArbitro);
    }

    /**
     * Obtiene todos los árbitros registrados.
     *
     * @return una lista de árbitros.
     */
    public List<Arbitro> getAllArbitros() {
        return arbitroDAO.getAll();
    }

    /**
     * Actualiza los datos de un árbitro existente.
     *
     * @param arbitro el árbitro con los datos actualizados.
     */
    public void updateArbitro(Arbitro arbitro) {
        arbitroDAO.update(arbitro);
    }

    /**
     * Elimina un árbitro.
     *
     * @param arbitro el árbitro a eliminar.
     */
    public void deleteArbitro(Arbitro arbitro) {
        arbitroDAO.delete(arbitro);
    }

    // CRUD Equipo

    /**
     * Crea un nuevo equipo.
     *
     * @param equipo el equipo a crear.
     */
    public void createEquipo(Equipo equipo) {
        equipoDAO.create(equipo);
    }

    /**
     * Obtiene un equipo por su ID.
     *
     * @param idEquipo el ID del equipo.
     * @return un Optional que contiene el equipo si se encuentra.
     */
    public Optional<Equipo> getEquipo(int idEquipo) {
        return equipoDAO.get(idEquipo);
    }

    /**
     * Obtiene todos los equipos registrados.
     *
     * @return una lista de equipos.
     */
    public List<Equipo> getAllEquipos() {
        return equipoDAO.getAll();
    }

    /**
     * Actualiza los datos de un equipo existente.
     *
     * @param equipo el equipo con los datos actualizados.
     */
    public void updateEquipo(Equipo equipo) {
        equipoDAO.update(equipo);
    }

    /**
     * Elimina un equipo.
     *
     * @param equipo el equipo a eliminar.
     */
    public void deleteEquipo(Equipo equipo) {
        equipoDAO.delete(equipo);
    }

    // CRUD Estadio

    /**
     * Crea un nuevo estadio.
     *
     * @param estadio el estadio a crear.
     */
    public void createEstadio(Estadio estadio) {
        estadioDAO.create(estadio);
    }

    /**
     * Obtiene un estadio por su ID.
     *
     * @param idEstadio el ID del estadio.
     * @return un Optional que contiene el estadio si se encuentra.
     */
    public Optional<Estadio> getEstadio(int idEstadio) {
        return estadioDAO.get(idEstadio);
    }

    /**
     * Obtiene todos los estadios registrados.
     *
     * @return una lista de estadios.
     */
    public List<Estadio> getAllEstadios() {
        return estadioDAO.getAll();
    }

    /**
     * Actualiza los datos de un estadio existente.
     *
     * @param estadio el estadio con los datos actualizados.
     */
    public void updateEstadio(Estadio estadio) {
        estadioDAO.update(estadio);
    }

    /**
     * Elimina un estadio.
     *
     * @param estadio el estadio a eliminar.
     */
    public void deleteEstadio(Estadio estadio) {
        estadioDAO.delete(estadio);
    }

    // CRUD Liga

    /**
     * Crea una nueva liga.
     *
     * @param liga la liga a crear.
     */
    public void createLiga(Liga liga) {
        ligaDAO.create(liga);
    }

    /**
     * Obtiene una liga por su ID.
     *
     * @param idLiga el ID de la liga.
     * @return un Optional que contiene la liga si se encuentra.
     */
    public Optional<Liga> getLiga(int idLiga) {
        return ligaDAO.get(idLiga);
    }

    /**
     * Obtiene todas las ligas registradas.
     *
     * @return una lista de ligas.
     */
    public List<Liga> getAllLigas() {
        return ligaDAO.getAll();
    }

    /**
     * Actualiza los datos de una liga existente.
     *
     * @param liga la liga con los datos actualizados.
     */
    public void updateLiga(Liga liga) {
        ligaDAO.update(liga);
    }

    /**
     * Elimina una liga.
     *
     * @param liga la liga a eliminar.
     */
    public void deleteLiga(Liga liga) {
        ligaDAO.delete(liga);
    }

    // CRUD Jugador

    /**
     * Crea un nuevo jugador.
     *
     * @param jugador el jugador a crear.
     */
    public void createJugador(Jugador jugador) {
        jugadorDAO.create(jugador);
    }

    /**
     * Obtiene un jugador por su ID.
     *
     * @param idJugador el ID del jugador.
     * @return un Optional que contiene el jugador si se encuentra.
     */
    public Optional<Jugador> getJugador(int idJugador) {
        return jugadorDAO.get(idJugador);
    }

    /**
     * Obtiene todos los jugadores registrados.
     *
     * @return una lista de jugadores.
     */
    public List<Jugador> getAllJugadores() {
        return jugadorDAO.getAll();
    }

    /**
     * Actualiza los datos de un jugador existente.
     *
     * @param jugador el jugador con los datos actualizados.
     */
    public void updateJugador(Jugador jugador) {
        jugadorDAO.update(jugador);
    }

    /**
     * Elimina un jugador.
     *
     * @param jugador el jugador a eliminar.
     */
    public void deleteJugador(Jugador jugador) {
        jugadorDAO.delete(jugador);
    }

    // CRUD Partido

    /**
     * Crea un nuevo partido.
     *
     * @param partido el partido a crear.
     */
    public void createPartido(Partido partido) {
        partidoDAO.create(partido);
    }

    /**
     * Obtiene un partido por su ID.
     *
     * @param idPartido el ID del partido.
     * @return un Optional que contiene el partido si se encuentra.
     */
    public Optional<Partido> getPartido(int idPartido) {
        return partidoDAO.get(idPartido);
    }

    /**
     * Obtiene todos los partidos registrados.
     *
     * @return una lista de partidos.
     */
    public List<Partido> getAllPartidos() {
        return partidoDAO.getAll();
    }

    /**
     * Actualiza los datos de un partido existente.
     *
     * @param partido el partido con los datos actualizados.
     */
    public void updatePartido(Partido partido) {
        partidoDAO.update(partido);
    }

    /**
     * Elimina un partido.
     *
     * @param partido el partido a eliminar.
     */
    public void deletePartido(Partido partido) {
        partidoDAO.delete(partido);
    }

    // CRUD Manager

    /**
     * Crea un nuevo manager.
     *
     * @param manager el manager a crear.
     */
    public void createManager(Manager manager) {
        managerDAO.create(manager);
    }

    /**
     * Obtiene todos los managers registrados.
     *
     * @return una lista de managers.
     */
    public List<Manager> getAllManager() {
        return managerDAO.getAll();
    }

    /**
     * Obtiene un manager por su ID.
     *
     * @param id el ID del manager.
     * @return un Optional que contiene el manager si se encuentra.
     */
    public Optional<Manager> getManager(int id) {
        return managerDAO.get(id);
    }

    /**
     * Actualiza los datos de un manager existente.
     *
     * @param manager el manager con los datos actualizados.
     */
    public void updateManager(Manager manager) {
        managerDAO.update(manager);
    }

    /**
     * Elimina un manager.
     *
     * @param manager el manager a eliminar.
     */
    public void deleteManager(Manager manager) {
        managerDAO.delete(manager);
    }

    
}
