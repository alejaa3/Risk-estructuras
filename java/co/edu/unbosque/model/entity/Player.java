package co.edu.unbosque.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import co.edu.unbosque.util.MyLinkedList;

/**
 * Clase que representa una entidad de jugador (Player).
 * Esta entidad está mapeada a una tabla llamada "player" en la base de datos.
 * @author Sebastian Cardenas Garcia.
 */
@Entity
@Table(name = "player")
public class Player implements Serializable {

	/**
	 * Numero de version para la serializacion.
	 */
	private static final long serialVersionUID = 847336276894759554L;

	/**
	 * El identificador unico del jugador.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private int id;
	
	/**
	 * El nombre de usuario del jugador.
	 */
	private String user;
	
	/**
	 * Estado del jugador en la partida.
	 */
	private String state;
	
	/**
	 * Tropas que tiene el jugador.
	 */
	private int tropas;
	/**
	 * Tropas que gana el jugador por ronda.
	 */
	private int Ganancia;

	/**
	 * Constructor por defecto que inicializa los atributos en null.
	 */
	public Player() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de la clase que inicializa los valores con los datos proporcionados.
	 * 
	 * @param user El nombre de usuario del jugador.
	 * @param state El estado del jugador.
	 * @param tropas El numero de tropas que tiene el jugador.
	 * @param ganancia El numero de tropas que gana el jugador.
	 */
	public Player(String user, String state, int tropas, int ganancia) {
		super();
		this.user = user;
		this.state = state;
		this.tropas = tropas;
		Ganancia = ganancia;
	}

	/**
	 * Obtiene el identificador unico del jugador.
	 * 
	 * @return El identificador unico del jugador.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador unico del jugador.
	 * 
	 * @param id El nuevo identidicador unico del jugador.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre de usuario del jugador.
	 * 
	 * @return El nombre de usuario del jugador.
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Establece el nombre de usuario del jugador.
	 * 
	 * @param user El nuevo nombre de usuario del jugador.
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Obtiene el estado del jugador.
	 * 
	 * @return El estado del jugador.
	 */
	public String getState() {
		return state;
	}

	/**
	 * Establece el estado del jugador.
	 * 
	 * @param state El nuevo estado del jugador.
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Obtienen el numero de tropas del jufador.
	 * 
	 * @return El numero de tropas del jugador.
	 */
	public int getTropas() {
		return tropas;
	}

	/**
	 * Establece el numero de tropas del jugador.
	 * 
	 * @param tropas El nuevo numero de tropas del jugador.
	 */
	public void setTropas(int tropas) {
		this.tropas = tropas;
	}

	/**
	 * Obtiene el numero de tropas que gana el jugador.
	 * 
	 * @return El numero de tropas que gana el jugador.
	 */
	public int getGanancia() {
		return Ganancia;
	}

	/**
	 * Establece el numero de tropas que gana el jugador.
	 *  
	 * @param ganancia El nuevo numero de tropas que gana el jugador.
	 */
	public void setGanancia(int ganancia) {
		Ganancia = ganancia;
	}

	/**
	 * El numero de serializacion del jugador.
	 * 
	 * @return El numero de serializacion.
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Convierte el jugador en una representacion en cadena del objeto
	 * 
	 * @return Una representacion en cadena del objeto.
	 */
	@Override
	public String toString() {
		return "Player [id=" + id + ", user=" + user + ", state=" + state + ", tropas=" + tropas + ", Ganancia="
				+ Ganancia + "]";
	}

	/**
	 * Calcula y devuelve el numereo hash del jugador a partir del id, la ganancia , el numero de tropas y el nombre de usuario.
	 * 
	 * @return El numero hash del jugador.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(Ganancia, id, state, tropas, user);
	}

	/**
	 * Compara este jugador con otro objeto para determinar si son iguales, Dos jugadores
	 * son iguales si tienen la misma informacion.
	 * 
	 * @param obj El objeto que se va a comparar.
	 * @retun true si los juadores son iguales, false en caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Ganancia == other.Ganancia && id == other.id && Objects.equals(state, other.state)
				&& tropas == other.tropas && Objects.equals(user, other.user);
	}

}
