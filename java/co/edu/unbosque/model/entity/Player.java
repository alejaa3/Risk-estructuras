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

@Entity
@Table(name = "player")
public class Player implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 847336276894759554L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private int id;
	private String user;
	private String state;
	private int tropas;
	private int Ganancia;

	public Player() {
		// TODO Auto-generated constructor stub
	}

	public Player(String user, String state, int tropas, int ganancia) {
		super();
		this.user = user;
		this.state = state;
		this.tropas = tropas;
		Ganancia = ganancia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getTropas() {
		return tropas;
	}

	public void setTropas(int tropas) {
		this.tropas = tropas;
	}

	public int getGanancia() {
		return Ganancia;
	}

	public void setGanancia(int ganancia) {
		Ganancia = ganancia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", user=" + user + ", state=" + state + ", tropas=" + tropas + ", Ganancia="
				+ Ganancia + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Ganancia, id, state, tropas, user);
	}

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
