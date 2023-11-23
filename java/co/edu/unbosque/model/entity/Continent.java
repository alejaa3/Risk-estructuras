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

@Entity
@Table(name = "continet")
public class Continent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -640938963655975184L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private int id;
	private String name;
	private String owner;
	private int value;

	public Continent() {
		// TODO Auto-generated constructor stub
	}

	public Continent(String name, String owner, int value) {
		super();
		this.name = name.toUpperCase().trim();
		this.owner = owner;
		this.value = value;
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Continent [id=" + id + ", name=" + name + ", owner=" + owner + ", value=" + value + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, owner, value);
	}

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
