import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class equipo {
	private String nombre;
	private jugador[] jugadores;
	
	public equipo(String nombre, jugador[] jugadores) {
		this.nombre = nombre;
		this.jugadores = jugadores;
	}
	public String getNombre() {
		return nombre;
	}
	public jugador[] getJugadores() {
		return jugadores;
	}
}

