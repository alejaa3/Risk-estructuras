package co.edu.unbosque.beans;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import co.edu.unbosque.model.Country;
import co.edu.unbosque.model.Player;
import co.edu.unbosque.util.AESUtil;
import co.edu.unbosque.util.grafo.generico.Edge;
import co.edu.unbosque.util.grafo.generico.Graph;
import co.edu.unbosque.util.grafo.generico.Vertex;
import co.edu.unbosque.util.simple.MyLinkedList;
import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.StraightConnector;
import org.primefaces.model.diagram.endpoint.DotEndPoint;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;

import jakarta.inject.Named;

//@Named("diagramHierarchicalView")
@RequestScoped
public class LoginBean {

private String text1;
private String text2;
private String text3;
private String text4;
private String text5;
private int number;
private Map<String, Map<String, String>> data = new HashMap<>();
private String country;
private String city;
private Map<String, String> countries;
private Map<String, String> cities;
private MyLinkedList<Vertex<String>> regions;

private MyLinkedList<String> nAmerica;
private MyLinkedList<String> sAmerica;
private MyLinkedList<String> europe;
private MyLinkedList<String> asia;
private MyLinkedList<String> oceania;
private MyLinkedList<String> africa;
private MyLinkedList<Player> listOfPlayers;

int numberOfPlayers=3;
private Graph g;

@PostConstruct
public void init() {
	
	
	
	regions=new MyLinkedList<Vertex<String>>();
	nAmerica=new MyLinkedList<String>();
	sAmerica=new MyLinkedList<String>();
	europe=new MyLinkedList<String>();
	asia=new MyLinkedList<String>();
	oceania=new MyLinkedList<String>();
	africa=new MyLinkedList<String>();
	listOfPlayers=new MyLinkedList<Player>();
	
	g=new Graph();
	
	fillRecionList();
	createBoard();
	fillContinents();
	
    countries = new HashMap<>();
    
    countries.put("Alaska", "Alaska");
	//System.out.println("first vertex"+regions.get(0).getInfo(, );
	countries.put("Northwest Territory", "Northwest Territory");
	countries.put("Greenland", "Greenland");
	countries.put("Alberta", "Alberta");
	countries.put("Ontario", "Ontario");
	countries.put("Quebec", "Quebec");
	countries.put("Western United States", "Western United States");
	countries.put("Eastern United States", "Eastern United States");
	countries.put("Central America", "Central America");
	//countries.put("Hawaii*", );
	countries.put("Venezuela", "Venezuela");
	countries.put("Peru", "Peru");
	countries.put("Brazil", "Brazil");
	countries.put("Argentina", "Argentina");
	//countries.put("Falkland Islands*", );
	countries.put("North Africa", "North Africa");
	countries.put("Egypt", "Egypt");
	countries.put("East Africa", "East Africa");
	countries.put("Congo", "Congo");
	countries.put("South Africa", "South Africa");
	countries.put("Madagascar", "Madagascar");
	countries.put("Iceland", "Iceland");
	countries.put("Svalbard*", "Svalbard*");
	countries.put("Scandinavia", "Scandinavia");
	countries.put("Ukraine", "Ukraine");
	countries.put("Great Britain", "Great Britain");
	countries.put("Northern Europe", "Northern Europe");
	countries.put("Southern Europe", "Southern Europe");
	countries.put("Western Europe", "Western Europe");
	countries.put("Indonesia", "Indonesia");
	//countries.put("Phillipines*", );
	countries.put("New Guinea", "New Guinea");
	countries.put("Western Australia", "Western Australia");
	countries.put("Eastern Australia", "Eastern Australia");
	//countries.put("New Zealand*", );
	countries.put("Siam", "Siam");
	countries.put("India", "India");
	countries.put("China", "China");
	countries.put("Mongolia", "Mongolia");
	countries.put("Japan", "Japan");
	countries.put("Irkutsk", "Irkutsk");
	countries.put("Yakutsk", "Yakutsk");
	countries.put("Kamchatka", "Kamchatka");
	countries.put("Siberia", "Siberia");
	countries.put("Afghanistan", "Afghanistan");
	countries.put("Ural", "Ural");
	countries.put("Middle East", "Middle East");
    
    //countries.put("", "");

	for (int i = 0; i < countries.size(); i++) {
		cities = new HashMap<>();
		for (int j = 0; j < regions.get(i).getAdyacentEdges().size(); j++) {
		    //cities.put(regions.get(i).getAdyacentEdges().get(j).getDestination().getInfo().toString()+"", regions.get(i).getAdyacentEdges().get(j).getDestination().getInfo().toString()+"");
		}
		//data.put(regions.get(i).getAdyacentEdges().get(0).getSource().getInfo().toString()+"", cities);
	    //cities.put("Berlin", "Berlin");
	    //cities.put("Munich", "Munich");
	    //cities.put("Frankfurt", "Frankfurt");
	    //data.put(regions.get(i).getInfo()+"", cities);
	}
	

    

    cities = new HashMap<>();
    cities.put("Sao Paulo", "Sao Paulo");
    cities.put("Rio de Janerio", "Rio de Janerio");
    cities.put("Salvador", "Salvador");
    data.put("Brazil", cities);
    
    //cities = new HashMap<>();
    //for (int i = 0; i < regions.get(0).getAdyacentEdges().size(); i++) {
      //  cities.put(regions.get(0).getAdyacentEdges().get(i).getDestination().getInfo()+"", regions.get(0).getAdyacentEdges().get(0).getDestination().getInfo()+"");
	//}
    
    //data.put(regions.get(0).getInfo(), cities);
}

public void increment() {
    number++;
}

public void handleKeyEvent() {
    text5 = text5.toUpperCase();
}

public String getText1() {
    return text1;
}

public void setText1(String text1) {
    this.text1 = text1;
}

public String getText2() {
    return text2;
}

public void setText2(String text2) {
    this.text2 = text2;
}

public String getText3() {
    return text3;
}

public void setText3(String text3) {
    this.text3 = text3;
}

public String getText4() {
    return text4;
}

public void setText4(String text4) {
    this.text4 = text4;
}

public String getText5() {
    return text5;
}

public void setText5(String text5) {
    this.text5 = text5;
}

public int getNumber() {
    return number;
}

public Map<String, Map<String, String>> getData() {
    return data;
}

public String getCountry() {
    return country;
}

public void setCountry(String country) {
    this.country = country;
}

public String getCity() {
    return city;
}

public void setCity(String city) {
    this.city = city;
}

public Map<String, String> getCountries() {
    return countries;
}

public Map<String, String> getCities() {
    return cities;
}

public void onCountryChange() {
	System.out.println(222);
	System.out.println(country);
	
	cities = new HashMap<>();
    cities.put("New York", "New York");
    cities.put("San Francisco", "San Francisco");
    //cities.put("country", cities);
	
    if (country != null && !"".equals(country)) {
        cities = data.get(country);
    }
    else {
        cities = new HashMap<>();
        
    }
}

public void displayLocation() {
    FacesMessage msg;
    if (city != null && country != null) {
        msg = new FacesMessage("Selected", city + " of " + country);
    }
    else {
        msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected.");
    }

    FacesContext.getCurrentInstance().addMessage(null, msg);
}

private void fillContinents() {
	nAmerica.add("Alaska");
	nAmerica.add("Northwest Territory");
	nAmerica.add("Greenland");
	nAmerica.add("Alberta");
	nAmerica.add("Ontario");
	nAmerica.add("Quebec");
	nAmerica.add("Western United States");
	nAmerica.add("Eastern United States");
	nAmerica.add("Central America");
	//regions.add(new Vertex("Hawaii*");
	sAmerica.add("Venezuela");
	sAmerica.add("Peru");
	sAmerica.add("Brazil");
	sAmerica.add("Argentina");
	//regions.add(new Vertex("Falkland Islands*");
	africa.add("North Africa");
	africa.add("Egypt");
	africa.add("East Africa");
	africa.add("Congo");
	africa.add("South Africa");
	africa.add("Madagascar");
	europe.add("Iceland");
	europe.add("Svalbard*");
	europe.add("Scandinavia");
	europe.add("Ukraine");
	europe.add("Great Britain");
	europe.add("Northern Europe");
	europe.add("Southern Europe");
	europe.add("Western Europe");
	oceania.add("Indonesia");
	//oceania.add("Phillipines*");
	oceania.add("New Guinea");
	oceania.add("Western Australia");
	oceania.add("Eastern Australia");
	//oceania.add("New Zealand*");
	asia.add("Siam");
	asia.add("India");
	asia.add("China");
	asia.add("Mongolia");
	asia.add("Japan");
	asia.add("Irkutsk");
	asia.add("Yakutsk");
	asia.add("Kamchatka");
	asia.add("Siberia");
	asia.add("Afghanistan");
	asia.add("Ural");
	asia.add("Middle East");
}

private void fillRecionList() {
	regions.add(new Vertex("Alaska"));
	//System.out.println("first vertex"+regions.get(0).getInfo());
	regions.add(new Vertex("Northwest Territory"));
	regions.add(new Vertex("Greenland"));
	regions.add(new Vertex("Alberta"));
	regions.add(new Vertex("Ontario"));
	regions.add(new Vertex("Quebec"));
	regions.add(new Vertex("Western United States"));
	regions.add(new Vertex("Eastern United States"));
	regions.add(new Vertex("Central America"));
	//regions.add(new Vertex("Hawaii*"));
	regions.add(new Vertex("Venezuela"));
	regions.add(new Vertex("Peru"));
	regions.add(new Vertex("Brazil"));
	regions.add(new Vertex("Argentina"));
	//regions.add(new Vertex("Falkland Islands*"));
	regions.add(new Vertex("North Africa"));
	regions.add(new Vertex("Egypt"));
	regions.add(new Vertex("East Africa"));
	regions.add(new Vertex("Congo"));
	regions.add(new Vertex("South Africa"));
	regions.add(new Vertex("Madagascar"));
	regions.add(new Vertex("Iceland"));
	regions.add(new Vertex("Svalbard*"));
	regions.add(new Vertex("Scandinavia"));
	regions.add(new Vertex("Ukraine"));
	regions.add(new Vertex("Great Britain"));
	regions.add(new Vertex("Northern Europe"));
	regions.add(new Vertex("Southern Europe"));
	regions.add(new Vertex("Western Europe"));
	regions.add(new Vertex("Indonesia"));
	//regions.add(new Vertex("Phillipines*"));
	regions.add(new Vertex("New Guinea"));
	regions.add(new Vertex("Western Australia"));
	regions.add(new Vertex("Eastern Australia"));
	//regions.add(new Vertex("New Zealand*"));
	regions.add(new Vertex("Siam"));
	regions.add(new Vertex("India"));
	regions.add(new Vertex("China"));
	regions.add(new Vertex("Mongolia"));
	regions.add(new Vertex("Japan"));
	regions.add(new Vertex("Irkutsk"));
	regions.add(new Vertex("Yakutsk"));
	regions.add(new Vertex("Kamchatka"));
	regions.add(new Vertex("Siberia"));
	regions.add(new Vertex("Afghanistan"));
	regions.add(new Vertex("Ural"));
	regions.add(new Vertex("Middle East"));

}

private void createBoard() {
	// creacion del grafo
	// 0-->Alaska
	// 1-->Northwest Territory
	// 2-->Greenland
	// 3-->Alberta
	// 4-->Ontario
	// 5-->Quebec
	// 6-->Western United States
	// 7-->Eastern United States
	// 8-->Central America
	// 9-->Hawaii*
	// 10-->Venezuela
	// 11-->Peru
	// 12-->Brazil
	// 13-->Argentina
	// 14-->Falkland Islands*
	// 15-->North Africa
	// 16-->Egypt
	// 17-->East Africa
	// 18-->Congo
	// 19-->South Africa
	// 20-->Madagascar
	// 21-->Iceland
	// 22-->Svalbard*
	// 23-->Scandinavia
	// 24-->Ukraine
	// 25-->Great Britain
	// 26-->Northern Europe
	// 27-->Southern Europe
	// 28-->Western Europe
	// 29-->Indonesia
	// 30-->Phillipines*
	// 31-->New Guinea
	// 32-->Western Australia
	// 33-->Eastern Australia
	// 34-->New Zealand*
	// 35-->Siam
	// 36-->India
	// 37-->China
	// 38-->Mongolia
	// 39-->Japan
	// 40-->Irkutsk
	// 41-->Yakutsk
	// 42-->Kamchatka
	// 43-->Siberia
	// 44-->Afghanistan
	// 45-->Ural
	// 46-->Middle East

	createGraph("Alaska", "Kamchatka");
	createGraph("Alaska", "Alberta");
	createGraph("Alaska", "Northwest Territory");
	createGraph("Alberta", "Northwest Territory");
	createGraph("Alberta", "Western United States");
	createGraph("Western United States", "Central America");
	createGraph("Western United States", "Eastern United States");
	createGraph("Eastern United States", "Central America");
	createGraph("Greenland", "Northwest Territory");

	createGraph("Venezuela", "Brazil");
	createGraph("Venezuela", "Peru");
	createGraph("Brazil", "Argentina");
	createGraph("Peru", "Argentina");

	createGraph("Iceland", "Great Britain");
	createGraph("Iceland", "Scandinavia");
	createGraph("Great Britain", "Scandinavia");
	createGraph("Great Britain", "Northern Europe");
	createGraph("Scandinavia", "Northern Europe");
	createGraph("Northern Europe", "Western Europe");
	createGraph("Northern Europe", "Southern Europe");
	createGraph("Western Europe", "Southern Europe");
	createGraph("Northern Europe", "Ukraine");

	createGraph("North Africa", "Egypt");
	createGraph("North Africa", "East Africa");
	createGraph("North Africa", "Congo");
	createGraph("East Africa", "South Africa");
	createGraph("Egypt", "East Africa");

	createGraph("Middle East", "India");
	createGraph("Middle East", "Afghanistan");
	createGraph("India", "Southeast Asia");
	createGraph("India", "China");
	createGraph("India", "Middle East");
	createGraph("Afghanistan", "China");
	createGraph("Afghanistan", "Ural");
	createGraph("China", "Ural");
	createGraph("China", "Mongolia");
	createGraph("Ural", "Siberia");
	createGraph("Ural", "Yakutsk");
	createGraph("Siberia", "Yakutsk");
	createGraph("Siberia", "Irkutsk");
	createGraph("Yakutsk", "Irkutsk");
	createGraph("Kamchatka", "Irkutsk");
	createGraph("Kamchatka", "Mongolia");
	createGraph("Kamchatka", "Japan");

	createGraph("Indonesia", "New Guinea");
	createGraph("Western Australia", "Eastern Australia");
	
	for (int i = 0; i < regions.size(); i++) {
		g.addVertex(regions.get(i));
	}

}
private void createGraph(String origin, String destination) {
	Vertex or = new Vertex(numberOfPlayers);
	Vertex dest = new Vertex(numberOfPlayers);
	for (int i = 0; i < regions.size(); i++) {
		if (origin.equals(regions.get(i).getInfo())) {
			
			//System.out.println("origin"+regions.get(i).getInfo());
			
			for (int j = 0; j < regions.size(); j++) {
				if (destination.equals(regions.get(j).getInfo())) {
					
					regions.get(i).addEdge(new Edge(regions.get(i), regions.get(j), 1));
					regions.get(j).addEdge(new Edge(regions.get(j), regions.get(i), 1));
					
					//System.out.println("edge"+regions.get(i).getAdyacentEdges().getFirst().getInfo().getDestination().getInfo().toString());

				}
			}


		}
		
	}
	

}

private boolean ocupiesContinent(Player player) {
	boolean resp=false;
	int cuantity=player.getCountries().size();
	for (int i = 0; i < player.getCountries().size(); i++) {
		for(int j=0; j<regions.size(); j++) {
			
		}
		
	}
	return true;
}

private int calculateTroops(int numberOfPlayers) {
	if (numberOfPlayers == 3) {
		return 35;
	}
	if (numberOfPlayers == 4) {
		return 30;
	}
	if (numberOfPlayers == 5) {
		return 25;
	}
	if (numberOfPlayers == 6) {
		return 20;
	}
	return 0;

}

}

