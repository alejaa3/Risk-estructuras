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

@Entity
@Table(name = "country")
public class Country implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 881213333929990342L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private int id;
	private String name;
	private int tropas;
	private String owner;
	private String state;

	public Country() {
		// TODO Auto-generated constructor stub
	}

	public Country(String name, int tropas, String owner, String state) {
		super();
		this.name = name.toUpperCase().trim();
		this.tropas = tropas;
		this.owner = owner;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTropas() {
		return tropas;
	}

	public void setTropas(int tropas) {
		this.tropas = tropas;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", tropas=" + tropas + ", owner=" + owner + ", state=" + state
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, owner, state, tropas);
	}

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
