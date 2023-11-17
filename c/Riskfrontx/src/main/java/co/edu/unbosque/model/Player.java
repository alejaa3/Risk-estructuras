
package co.edu.unbosque.model;

import co.edu.unbosque.util.simple.MyLinkedList;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//@Entity
//@Table(name = "students")
public class Player {
	//private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	//@Column(unique = true)
	private String name;
	private int troops;
	private MyLinkedList<Country> countries;



	public Player(String name, int troops) {
		super();
		this.name = name;
		this.troops = troops;
		countries=new MyLinkedList<Country>();

	}

	public MyLinkedList<Country> getCountries() {
		return countries;
	}

	public void setCountries(MyLinkedList<Country> countries) {
		this.countries = countries;
	}

	public int getTroops() {
		return troops;
	}

	public void setTroops(int troops) {
		this.troops = troops;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
