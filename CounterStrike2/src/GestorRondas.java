import java.util.Random;

import javax.swing.JOptionPane;

public class GestorRondas {
	
	    private Random random = new Random();

	    public void jugarRondas(Equipo equipo1, Equipo equipo2) {
	        int puntosequipo1 = 0;
	        int puntosequipo2 = 0;

	        int rondasJugadas = 0;

	        while (puntosequipo1 < 13 && puntosequipo2 < 13 && rondasJugadas < 24) {
	            rondasJugadas++;
	            double probabilidadEquipo1 = random.nextDouble();
	            double probabilidadEquipo2 = random.nextDouble();
	            
	            if (probabilidadEquipo1 > 0.5) {
	                puntosequipo1++;
	                JOptionPane.showMessageDialog(null, "¡Punto para " + equipo1.getNombre() + "! Puntos: " + puntosequipo1 + " Puntos " + equipo2.getNombre()
	                        + ": " + puntosequipo2);
	            } else {
	                puntosequipo2++;
	                JOptionPane.showMessageDialog(null, "¡Punto para " + equipo2.getNombre() + "! Puntos: " + puntosequipo2 + " Puntos " + equipo1.getNombre() + ": " + puntosequipo1);
	            }
	        }

	        if (puntosequipo1 >= 13) {
	            JOptionPane.showMessageDialog(null, "¡El equipo " + equipo1.getNombre() + " ganó con: " + puntosequipo1 + " puntos!");
	        } else if (puntosequipo2 >= 13) {
	            JOptionPane.showMessageDialog(null, "¡El equipo " + equipo2.getNombre() + " ganó con: " + puntosequipo2 + " puntos!");
	        } else if (puntosequipo1 == 12 && puntosequipo2 == 12) {
	           	JOptionPane.showMessageDialog(null, "¡Empate, se juega el tiempo extra!");

	            int puntosextraequipo1 = 0;
	            int puntosextraequipo2 = 0;

	            while (puntosextraequipo1 < 6 && puntosextraequipo2 < 6) {
	                double probabilidadExtraEquipo1 = random.nextDouble();
	                double probabilidadExtraEquipo2 = random.nextDouble();

	                if (probabilidadExtraEquipo1 > 0.5) {
	                    puntosextraequipo1++;
	                    JOptionPane.showMessageDialog(null, "¡Punto para " + equipo1.getNombre() + "! Puntos: " + puntosextraequipo1 + " Puntos " + equipo2.getNombre()
                        + ": " + puntosextraequipo2);
	                }else{
	                	puntosextraequipo2++;
	                	JOptionPane.showMessageDialog(null, "¡Punto para " + equipo2.getNombre() + "! Puntos: " + puntosextraequipo2 + " Puntos " + equipo1.getNombre()
                        + ": " + puntosextraequipo1);
	                }

	                if (puntosextraequipo1 == 5 && puntosextraequipo2 == 5) {
	                    JOptionPane.showMessageDialog(null, "¡Empate en el tiempo extra, se reinicia!");
	                    puntosextraequipo1 = 0;
	                    puntosextraequipo2 = 0;
	                }
	            }

	            if (puntosextraequipo1 >= 6) {
	                JOptionPane.showMessageDialog(null, "¡El equipo " + equipo1.getNombre() + " ganó en el tiempo extra con " + puntosextraequipo1 + " puntos!");
	            } else if (puntosextraequipo2 >= 6) {
	                JOptionPane.showMessageDialog(null, "¡El equipo " + equipo2.getNombre() + " ganó en el tiempo extra con " + puntosextraequipo2 + " puntos!");
	            }
	        }
	    }
	}

