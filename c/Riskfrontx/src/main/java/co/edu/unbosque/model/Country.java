package co.edu.unbosque.model;

public class Country {
private String name;
private int troops;
public Country(String name, int troops) {
	super();
	this.name = name;
	this.troops = troops;
}
public Country(String name) {
	super();
	this.name = name;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getTroops() {
	return troops;
}
public void setTroops(int troops) {
	this.troops = troops;
}



}
