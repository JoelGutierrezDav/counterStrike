import javax.swing.JOptionPane;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public class main {
    public static void main(String[] args) {
        jugador[] jugadores9Z = {
                new jugador("Dgt", "Uruguay", 25),
                new jugador("Max", "Uruguay", 22),
                new jugador("Buda", "Argentina", 30),
                new jugador("Huasopeek", "Chile", 27),
                new jugador("Martinez", "España", 29),
                new jugador("Tge", "Brasil", 26)
        };

        jugador[] jugadoresG2 = {
                new jugador("Hunter", "Bosnia", 28),
                new jugador("Niko", "Bosnia", 26),
                new jugador("Monesy", "Rusia", 34),
                new jugador("Hooxi", "Dinarmica", 27),
                new jugador("Nexa", "Serbia", 25),
                new jugador("Taz", "Polonia", 31)
        };

        equipo equipo9Z = new equipo("9Z", jugadores9Z);
        equipo equipoG2 = new equipo("G2", jugadoresG2);

        String[] opciones = {"9Z","G2"};
        String equipoelegido = (String) JOptionPane.showInputDialog(null, "Selecciona un equipo: ", "Seleccionar equipo",
                JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        jugador[] jugadoresequipoelegido = equipoelegido.equals("9Z") ? jugadores9Z : jugadoresG2;
        jugador[] jugadoresseleccionados = seleccionarJugadores(jugadoresequipoelegido);

        int puntosequipoelegido = 0;
        int puntosotroequipo = 0;
        String otroequipo = equipoelegido.equals("9Z") ? equipoG2.getNombre() : equipo9Z.getNombre();
        Random random = new Random();
        
        while (puntosequipoelegido < 13 && puntosotroequipo < 13) {
        	double probabilidadequipoelegido = random.nextDouble();
            double probabilidadotroequipo = random.nextDouble();
            if (probabilidadequipoelegido > 0.5) {
                puntosequipoelegido++;
                JOptionPane.showMessageDialog(null, "¡Punto para " + equipoelegido + "! Puntos: " + puntosequipoelegido + " Puntos " + otroequipo
                        + ": " + puntosotroequipo);
            } else {
                puntosotroequipo++;
                JOptionPane.showMessageDialog(null, "¡Punto para " + otroequipo + "! Puntos: " + puntosotroequipo + " Puntos " + equipoelegido + ": " + puntosequipoelegido);
            }
        }

        if (puntosequipoelegido >= 13) {
            JOptionPane.showMessageDialog(null, "¡El equipo " + equipoelegido + " ganó con: " + puntosequipoelegido + " puntos!");
        } else if (puntosotroequipo >= 13) {
            JOptionPane.showMessageDialog(null, "¡El equipo " + otroequipo + " ganó con: " + puntosotroequipo + " puntos!");
       
        } else if (puntosequipoelegido == 12 && puntosotroequipo == 12) {
        	
        	JOptionPane.showMessageDialog(null, "¡Empate, se juega el tiempo extra!");

            int puntosextraequipoelegido = 0;
            int puntosextraotroequipo = 0;

            while (puntosextraequipoelegido < 6 && puntosextraotroequipo < 6) {
                double probabilidadExtraEquipoElegido = random.nextDouble();
                double probabilidadExtraOtroEquipo = random.nextDouble();

                if (probabilidadExtraEquipoElegido > 0.5) {
                    puntosextraequipoelegido++;
                }

                if (probabilidadExtraOtroEquipo > 0.5) {
                    puntosextraotroequipo++;
                }

                if (puntosextraequipoelegido == 5 && puntosextraotroequipo == 5) {
                    JOptionPane.showMessageDialog(null, "¡Empate en el tiempo extra, se reinicia!");
                    puntosextraequipoelegido = 0;
                    puntosextraotroequipo = 0;
                }
            }

            if (puntosextraequipoelegido >= 6) {
                JOptionPane.showMessageDialog(null, "¡El equipo " + equipoelegido + " ganó en el tiempo extra con " + puntosextraequipoelegido + " puntos!");
            } else if (puntosextraotroequipo >= 6) {
                JOptionPane.showMessageDialog(null, "¡El equipo " + otroequipo + " ganó en el tiempo extra con " + puntosextraotroequipo + " puntos!");
            }
		} else {
			JOptionPane.showMessageDialog(null, "Error!!!!!!");
		} {
            
        }
    }


    private static jugador[] seleccionarJugadores(jugador[] jugadores) {
        jugador[] jugadoresseleccionados = new jugador[5];
        String[] nombresjugadores = new String[jugadores.length];
        for (int i = 0; i < jugadores.length; i++) {
            nombresjugadores[i] = jugadores[i].getNombre();
        }

        for (int i = 0; i < 5; i++) {
            String nombreseleccionado = (String) JOptionPane.showInputDialog(null, "Selecciona un jugador: ", "Seleccionar Jugador", JOptionPane.PLAIN_MESSAGE,
                    null, nombresjugadores, nombresjugadores[0]);

            for (jugador jugador : jugadores) {
                if (jugador.getNombre().equals(nombreseleccionado)) {
                    jugadoresseleccionados[i] = jugador;
                    break;
                }
            }
        }
        return jugadoresseleccionados;
    }
}
