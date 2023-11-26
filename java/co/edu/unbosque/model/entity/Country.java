package co.edu.unbosque.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa una entidad de Territorio (Country).
 * Esta entidad está mapeada a una tabla llamada "country" en la base de datos.
 * @author Sebastian Cardenas Garcia.
 */
@Entity
@Table(name = "country")
public class Country implements Serializable {

	/**
	 * Numero de version para la serializacion.
	 */
	private static final long serialVersionUID = 881213333929990342L;
	
	/**
	 * Identificador unico del territorio.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private int id;
	
	/**
	 * Nombre del territorio.
	 */
	private String name;
	
	/**
	 * Numero de tropas que tiene el terriotiro.
	 */
	private int tropas;
	
	/**
	 * Dueño del territorio.
	 */
	private String owner;
	
	/**
	 * Estado del terriotorio.
	 */
	private String state;

	/**
	 * Constructor por defecto que inicializa sus valores en null.
	 */
	public Country() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que inicializa su valores segun la informacion suministrada.
	 * 
	 * @param name Nombre del territorio.
	 * @param tropas Numero de tropas del territorio.
	 * @param owner Nombre del dueño del territorio.
	 * @param state
	 */
	public Country(String name, int tropas, String owner, String state) {
		super();
		this.name = name.toUpperCase().trim();
		this.tropas = tropas;
		this.owner = owner;
		this.state = state;
	}

	/**
	 * Obtiene el identificador unico del territorio.
	 * 
	 * @return El identificador unico del territorio.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador unico del territorio.
	 * 
	 * @param id El nuevo identificador unico del territorio.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Obtiene el nombre del territorio.
	 * 
	 * @return El nombre del territorio.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre del territorio.
	 * 
	 * @param name El nuevo nombre del territorio.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene el numero de tropas del territorio.
	 * 
	 * @return El numero de tropas del territorio.
	 */
	public int getTropas() {
		return tropas;
	}

	/**
	 * Establce el numero de tropas del territorio.
	 * 
	 * @param tropas El nuevo numero de tropas del territorio.
	 */
	public void setTropas(int tropas) {
		this.tropas = tropas;
	}

	/**
	 * Obtiene el nombre del dueño del territorio.
	 * 
	 * @return El nombre del dueño del territorio.
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Establce el nombre del dueño del territorio.
	 * 
	 * @param owner El nuevo nombre del dueño del territorio.
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Obtiene el estado del territorio.
	 * 
	 * @return El estado del territorio.
	 */
	public String getState() {
		return state;
	}

	/**
	 * Establce el estado del territorio.
	 * 
	 * @param state El nuevo estado del territorio.
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Obtiene el numero de serializado del objeto.
	 * 
	 * @return Numero de serializado del objeto.
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Convierte un territorio en una representacion en cadena.
	 * 
	 * @return Representacion en cadena de un territorio.
	 */
	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", tropas=" + tropas + ", owner=" + owner + ", state=" + state
				+ "]";
	}

	/**
	 * Calcula y devuelve el numereo hash del territorio a partir del id, nombre, propietario y numero de tropas.
	 * 
	 * @return El numero hash del territorio.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, name, owner, state, tropas);
	}

	/**
	 * Compara este territorio con otro objeto para determinar si son iguales, Dos territorios
	 * son iguales si tienen la misma informacion.
	 * 
	 * @param obj El objeto que se va a comparar.
	 * @retun true si los territorios son iguales, false en caso contrario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(owner, other.owner)
				&& Objects.equals(state, other.state) && tropas == other.tropas;
	}

}
