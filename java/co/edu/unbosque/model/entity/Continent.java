package co.edu.unbosque.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import co.edu.unbosque.util.MyLinkedList;

/**
 * Clase que representa una entidad de tarjeta (Card).
 * Esta entidad está mapeada a una tabla llamada "card" en la base de datos.
 * @author Sebastian Cardenas Garcia.
 */
@Entity
@Table(name = "continet")
public class Continent implements Serializable {

	/**
	 * Numero de version para la serializacion.
	 */
	private static final long serialVersionUID = -640938963655975184L;
	
	/**
	 * identificador unico del continente
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private int id;
	
	/**
	 * nombre del continente.
	 */
	private String name;
	
	/**
	 * Nombre del dueño del continente.
	 */
	private String owner;
	
	/**
	 * Numero de tropas que otorga el continente.
	 */
	private int value;

	/**
	 * Constructor por defecto que inicializa sus atributos en null.
	 */
	public Continent() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor por defecto que inicializa con los datos proporcionados.
	 * 
	 * @param name Nombre del continente.
	 * @param owner El dueño del continente.
	 * @param value El numero de tropas que otorga el continente.
	 */
	public Continent(String name, String owner, int value) {
		super();
		this.name = name.toUpperCase().trim();
		this.owner = owner;
		this.value = value;
	}

	/**
	 * Obtiene el identificador unico del continente.
	 * 
	 * @return El identificador unico del continente.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador unico del continente.
	 * 
	 * @param id El nuevo identificador unico del continente.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del contiente.
	 * 
	 * @return El nombre del contiente.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Establce el nombre del contiente.
	 * 
	 * @param name El nuevo nombre del continente.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene el nombre del dueño del continente.
	 * 
	 * @return El nombre del dueño del continente.
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Establce el nombre del dueño del continente.
	 * 
	 * @param owner El nuevo nombre del dueño del continente.
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Obtiene el numero de tropas que otorga el continente.
	 * 
	 * @return El numeor de tropas que otorga el continente.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Establece el numero de tropas que otorga el continente.
	 * 
	 * @param value El nuevo numero de tropas que otorga el continente.
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Obtiene el numereo de serializado del objeto.
	 * 
	 * @return El numero de serializado.
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Convierte en una representacion de cadena una instancia del cobjeto continente.
	 * 
	 * @retun Una representacion en cadena del objeto.
	 */
	@Override
	public String toString() {
		return "Continent [id=" + id + ", name=" + name + ", owner=" + owner + ", value=" + value + "]";
	}

	/**
	 * Calcula y devuelve el numereo hash del continente a partir de el id, nombre , dueño y numero de tropas que otorga.
	 * 
	 * @return El numero hash del continente.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, name, owner, value);
	}

	/**
	 * Compara este continente con otro objeto para determinar si son iguales, Dos continentes
	 * son iguales si tienen la misma informacion.
	 * 
	 * @param obj El objeto que se va a comparar.
	 * @retun true si los continentes son iguales, false en caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Continent other = (Continent) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(owner, other.owner)
				&& value == other.value;
	}

}
