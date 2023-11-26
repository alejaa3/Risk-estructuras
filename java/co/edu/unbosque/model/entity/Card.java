package co.edu.unbosque.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que representa una entidad de tarjeta (Card).
 * Esta entidad está mapeada a una tabla llamada "card" en la base de datos.
 * @author Sebastian Cardenas Garcia.
 */
@Entity
@Table(name = "card")
public class Card implements Serializable{

	/**
	 * Numero de version para la serializacion.
	 */
	private static final long serialVersionUID = 8675993920657473964L;
	
	/**
	 *Identificardor unico de la clase Card
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
	private int id;
	/**
	 * Nombre de la carta.
	 */
	private String name;
	/**
	 * Nombre del tipo de tropa que maneja la carta. 
	 */
	private String tropaName;
	/**
	 * Numero de tropas que otorga la carta.
	 */
	private int tropas;
	
	/**
	 * Constructor vacio que inicializa sus atributos en null.
	 */
	public Card() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructo de la clase que incicializa el objeto con los datos proporcionados.
	 * 
	 * @param name El nombre de la carta
	 * @param tropaName El nombre del tipo de tropa que tiene la carta.
	 * @param tropas El numero de tropas que otroga la carta.
	 */
	public Card(String name, String tropaName, int tropas) {
		super();
		this.name = name.toUpperCase().trim();
		this.tropaName = tropaName.toUpperCase().trim();
		this.tropas = tropas;
	}

	/**
	 * Obtiene el identificador unico de la carta.
	 * 
	 * @return El indentificador unico de la carta.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador unico de la carta.
	 * 
	 * @param id El nuevo identificador unico de la carta.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre de la carta.
	 * 
	 * @return El nombre de la carta.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Establce el nombre de la carta.
	 * 
	 * @param name El nuevo nombre de la carta.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene el nombre de las tropa de la carta.
	 * 
	 * @return El nombre de la tropa de la carta.
	 */
	public String getTropaName() {
		return tropaName;
	}

	/**
	 * Establce el nombre de la tropa de la carta.
	 * 
	 * @param tropaName El nuevo nombre de la tropa de la carta.
	 */
	public void setTropaName(String tropaName) {
		this.tropaName = tropaName;
	}

	/**
	 * Obtiene el numero de tropas de la carta.
	 * 
	 * @return El numero de tropas de la carta.
	 */
	public int getTropas() {
		return tropas;
	}

	/**
	 * Establece el numero de tropas de la carta.
	 * 
	 * @param tropas El nuevo numero de tropas de la carta.
	 */
	public void setTropas(int tropas) {
		this.tropas = tropas;
	}

	/**
	 * Obtiene el numero de serializado de la carta.
	 * @return El numero de serializado de la carta.
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Obtiene la representacion en cadena de la clase carta.
	 * 
	 * @return La representancion en cadena de la clase carta.
	 */
	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", tropaName=" + tropaName + ", tropas=" + tropas + "]";
	}

	/**
	 * Calcula y devuelve el numereo hash de la carta a partir de el id, nombre , nombre de la tropa y el numero de tropas de la carta.
	 * 
	 * @return El numero hash de la carta.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, name, tropaName, tropas);
	}

	/**
	 * Compara esta carta con otro objeto para determinar si son iguales, Dos cartas
	 * son iguales si tienen la misma informacion.
	 * 
	 * @param obj El objeto que se va a comparar.
	 * @retun true si las cartas son iguales, false en caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(tropaName, other.tropaName)
				&& tropas == other.tropas;
	}
	
}
