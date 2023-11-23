package co.edu.unbosque.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8675993920657473964L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
	private int id;
	private String name;
	private String tropaName;
	private int tropas;
	
	public Card() {
		// TODO Auto-generated constructor stub
	}

	public Card(String name, String tropaName, int tropas) {
		super();
		this.name = name.toUpperCase().trim();
		this.tropaName = tropaName.toUpperCase().trim();
		this.tropas = tropas;
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

	public String getTropaName() {
		return tropaName;
	}

	public void setTropaName(String tropaName) {
		this.tropaName = tropaName;
	}

	public int getTropas() {
		return tropas;
	}

	public void setTropas(int tropas) {
		this.tropas = tropas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", tropaName=" + tropaName + ", tropas=" + tropas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, tropaName, tropas);
	}

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
