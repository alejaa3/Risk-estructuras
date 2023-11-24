package co.edu.unbosque.model;

import co.edu.unbosque.util.grafo.generico.Edge;
import co.edu.unbosque.util.grafo.generico.Graph;
import co.edu.unbosque.util.grafo.generico.Vertex;
import co.edu.unbosque.util.simple.MyLinkedList;

public class InitGraph {
	
	
	
	private MyLinkedList<Vertex<String>> regions;
	private MyLinkedList<String> nAmerica;
	private MyLinkedList<String> sAmerica;
	private MyLinkedList<String> europe;
	private MyLinkedList<String> asia;
	private MyLinkedList<String> oceania;
	private MyLinkedList<String> africa;
	private MyLinkedList<Player> listOfPlayers;
	private Graph g;
	
	
	public InitGraph(){
		
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
		////System.out.println("first vertex"+regions.get(0).getInfo());
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
		//Vertex or = new Vertex(numberOfPlayers);
		//Vertex dest = new Vertex(numberOfPlayers);
		for (int i = 0; i < regions.size(); i++) {
			if (origin.equals(regions.get(i).getInfo())) {
				
				////System.out.println("origin"+regions.get(i).getInfo());
				
				for (int j = 0; j < regions.size(); j++) {
					if (destination.equals(regions.get(j).getInfo())) {
						
						regions.get(i).addEdge(new Edge(regions.get(i), regions.get(j), 1));
						regions.get(j).addEdge(new Edge(regions.get(j), regions.get(i), 1));
						
						////System.out.println("edge"+regions.get(i).getAdyacentEdges().getFirst().getInfo().getDestination().getInfo().toString());

					}
				}


			}
			
		}
		

	}

	public MyLinkedList<Vertex<String>> getRegions() {
		return regions;
	}

	public void setRegions(MyLinkedList<Vertex<String>> regions) {
		this.regions = regions;
	}

	public MyLinkedList<String> getnAmerica() {
		return nAmerica;
	}

	public void setnAmerica(MyLinkedList<String> nAmerica) {
		this.nAmerica = nAmerica;
	}

	public MyLinkedList<String> getsAmerica() {
		return sAmerica;
	}

	public void setsAmerica(MyLinkedList<String> sAmerica) {
		this.sAmerica = sAmerica;
	}

	public MyLinkedList<String> getEurope() {
		return europe;
	}

	public void setEurope(MyLinkedList<String> europe) {
		this.europe = europe;
	}

	public MyLinkedList<String> getAsia() {
		return asia;
	}

	public void setAsia(MyLinkedList<String> asia) {
		this.asia = asia;
	}

	public MyLinkedList<String> getOceania() {
		return oceania;
	}

	public void setOceania(MyLinkedList<String> oceania) {
		this.oceania = oceania;
	}

	public MyLinkedList<String> getAfrica() {
		return africa;
	}

	public void setAfrica(MyLinkedList<String> africa) {
		this.africa = africa;
	}

	public MyLinkedList<Player> getListOfPlayers() {
		return listOfPlayers;
	}

	public void setListOfPlayers(MyLinkedList<Player> listOfPlayers) {
		this.listOfPlayers = listOfPlayers;
	}

	public Graph getG() {
		return g;
	}

	public void setG(Graph g) {
		this.g = g;
	}
	
}
