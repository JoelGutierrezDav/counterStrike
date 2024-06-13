import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class GestorEquipos {
	
	    private Equipo equipo1;
	    private Equipo equipo2;

	    public void seleccionarEquipo() {
	        String[] opciones = {"9Z", "G2"};
	        int equipoElegido = JOptionPane.showOptionDialog(null, "Selecciona un equipo:", "Seleccionar equipo",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

	        if (equipoElegido != JOptionPane.CLOSED_OPTION) {
	            if (equipoElegido == 0) {
	                equipo1 = crearEquipo9Z();
	            } else {
	                equipo2 = crearEquipoG2();
	            }
	        }
	    }

	    public void seleccionarJugadores() {
	        if (equipo1 == null || equipo2 == null) {
	            JOptionPane.showMessageDialog(null, "Primero selecciona ambos equipos.");
	            return;
	        }

	        seleccionarJugadoresEquipo(equipo1);
	        seleccionarJugadoresEquipo(equipo2);
	    }

	    private Equipo crearEquipo9Z() {
	        LinkedList<Jugador> jugadores9Z = new LinkedList<>();
	        jugadores9Z.add(new Jugador("Dgt", "Uruguay", 25));
	        jugadores9Z.add(new Jugador("Max", "Uruguay", 22));
	        jugadores9Z.add(new Jugador("Buda", "Argentina", 30));
	        jugadores9Z.add(new Jugador("Huasopeek", "Chile", 27));
	        jugadores9Z.add(new Jugador("Martinez", "España", 29));
	        jugadores9Z.add(new Jugador("Tge", "Brasil", 26));

	        return new Equipo("9Z", jugadores9Z);
	    }

	    private Equipo crearEquipoG2() {
	        LinkedList<Jugador> jugadoresG2 = new LinkedList<>();
	        jugadoresG2.add(new Jugador("Hunter", "Bosnia", 28));
	        jugadoresG2.add(new Jugador("Niko", "Bosnia", 26));
	        jugadoresG2.add(new Jugador("Monesy", "Rusia", 34));
	        jugadoresG2.add(new Jugador("Hooxi", "Dinarmica", 27));
	        jugadoresG2.add(new Jugador("Nexa", "Serbia", 25));
	        jugadoresG2.add(new Jugador("Taz", "Polonia", 31));

	        return new Equipo("G2", jugadoresG2);
	    }

	    private void seleccionarJugadoresEquipo(Equipo equipo) {
	        LinkedList<Jugador> jugadoresDisponibles = equipo.getJugadores();
	        List<String> nombresJugadores = new ArrayList<>();
	        for (Jugador jugador : jugadoresDisponibles) {
	            nombresJugadores.add(jugador.getNombre());
	        }

	        LinkedList<Jugador> jugadoresSeleccionados = new LinkedList<>();
	        for (int i = 0; i < 5; i++) {
	            String nombreSeleccionado = (String) JOptionPane.showInputDialog(null, "Selecciona un jugador:",
	                    "Seleccionar Jugador", JOptionPane.DEFAULT_OPTION, null, nombresJugadores.toArray(), nombresJugadores.get(0));

	            Iterator<Jugador> iterator = jugadoresDisponibles.iterator();
	            while (iterator.hasNext()) {
	                Jugador jugador = iterator.next();
	                if (jugador.getNombre().equals(nombreSeleccionado)) {
	                    jugadoresSeleccionados.add(jugador);
	                    iterator.remove();
	                    break;
	                }
	            }
	        }

	        equipo = new Equipo(equipo.getNombre(), jugadoresSeleccionados);
	    }

	    public Equipo getEquipo1() {
	        return equipo1;
	    }

	    public Equipo getEquipo2() {
	        return equipo2;
	    }
	}

