import javax.swing.JOptionPane;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        GestorEquipos gestorEquipos = new GestorEquipos();
        GestorRondas gestorRondas = new GestorRondas();

        String[] opcionesMenu = {"Seleccionar equipo", "Seleccionar jugadores", "Jugar rondas", "Salir"};
        boolean salir = false;

        while (!salir) {
            int opcionSeleccionada = JOptionPane.showOptionDialog(null, "Selecciona una opción:", "Menú Principal",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcionesMenu, opcionesMenu[0]);

            switch (opcionSeleccionada) {
                case 0:
                    gestorEquipos.seleccionarEquipo();
                    break;
                case 1:
                    gestorEquipos.seleccionarJugadores();
                    break;
                case 2:
                    gestorRondas.jugarRondas(gestorEquipos.getEquipo1(), gestorEquipos.getEquipo2());
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        }
    }
}







