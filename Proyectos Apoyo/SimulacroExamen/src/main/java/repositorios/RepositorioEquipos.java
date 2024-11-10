package repositorios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelos.Equipo;
import modelos.Piloto;

public class RepositorioEquipos {
	private static final Logger logger = LogManager.getLogger(RepositorioEquipos.class);

	private List<Equipo> listaEquipos;

	public RepositorioEquipos() {
		this.listaEquipos = new ArrayList<Equipo>();
	}

	public RepositorioEquipos(List<Equipo> listaEquipos) {
		super();
		this.listaEquipos = listaEquipos;
	}

	public void addEquipo(Equipo equipo) {
		listaEquipos.add(equipo);
	}

	public Equipo getEquipo(int idEquipo) throws IOException {
		for (Equipo e : this.listaEquipos) {
			if (e.getIdentificador() == idEquipo) {
				return e;
			}
		}
		throw new IOException("El id no corresponde a ningun equipo");
	}

	public void addPiloto(int idEquipo, Piloto p) {
		try {
			Equipo equipo = this.getEquipo(idEquipo);
			equipo.getPilotos().put(p.getIdentificadorPiloto(), p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("Equipo no encontrado");
		}
	}

	public List<Piloto> pilotosConMayorPuntuacionQue(int puntuacion) {
		List<Piloto> listaPilotosPuntuados = new ArrayList<Piloto>();
		for (Equipo e : this.listaEquipos) {
			// e.Map<Integer, Piloto>= e.getPilotos();
			for (Entry<Integer, Piloto> entrada : e.getPilotos().entrySet()) {
				if (entrada.getValue().getPuntos() > puntuacion) {
					listaPilotosPuntuados.add(entrada.getValue());
				}
			}
		}
		return listaPilotosPuntuados;

	}
}
