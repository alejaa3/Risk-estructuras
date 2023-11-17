package co.edu.unbosque.beans;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;

import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import co.edu.unbosque.model.Country;
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

@Named("diagramHierarchicalView")
@RequestScoped
public class LoginBean {
	//private Controller c;
	private int numberOfPlayers=6;
	private MyLinkedList<Element> nodes;
	private List<Graph> graph;
	private String selectedRegion;
	public LoginBean() {
		//c=new Controller();
		nodes=new MyLinkedList<Element>();
		
		
		
		
		countries = new MyLinkedList<Vertex<Country>>();
		g=new Graph();
		fillRecionList();
		createBoard();
		//userRepo.save(g);
		
		
	}
	
	
	public void test() {
		System.out.println("the link is working");
	}

	private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
			.connectTimeout(Duration.ofSeconds(10)).build();
	
	
    private DefaultDiagramModel model;

    @PostConstruct
    public void init() {
        model = new DefaultDiagramModel();
        model.setMaxConnections(-1);
        model.setConnectionsDetachable(false);
        
        
        String name;
        Element temp;
    	nodes.add(new Element(countries.get(0).getInfo().getName(), "25em", "6em"));
    	nodes.add(new Element(countries.get(1).getInfo().getName(), "25em", "6em"));

        for (int i = 0; i < 2; i++) {
        	//System.out.println(countries.get(i).getInfo().getName());
        	
        	//name=countries.get(1).getInfo().getName().toString();
        	//name=countries.get(2).getInfo().getName().toString();
        	
        	//System.out.println(name);
        	//System.out.println(temp.getData());

        	nodes.get(i).addEndPoint(createEndPoint(EndPointAnchor.BOTTOM));
        	nodes.get(i).addEndPoint(createEndPoint(EndPointAnchor.TOP));
            
            model.addElement(nodes.get(i));
		}
        
        StraightConnector connector = new StraightConnector();
        connector.setPaintStyle("{stroke:'#404a4e', strokeWidth:3}");
        connector.setHoverPaintStyle("{stroke:'#20282b'}");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //model.connect(new Connection(nodes.get(0).getEndPoints().get(0), nodes.get(1).getEndPoints().get(0), connector));


        Element ceo = new Element("CEO", "25em", "6em");
        ceo.addEndPoint(createEndPoint(EndPointAnchor.BOTTOM));
        model.addElement(ceo);

        //CFO
        Element cfo = new Element();
        cfo.addEndPoint(createEndPoint(EndPointAnchor.TOP));
        cfo.addEndPoint(createEndPoint(EndPointAnchor.BOTTOM));

        Element fin = new Element("FIN", "25em", "30em");
        fin.addEndPoint(createEndPoint(EndPointAnchor.TOP));

        Element pur = new Element("PUR", "250em", "30em");
        pur.addEndPoint(createEndPoint(EndPointAnchor.TOP));

        model.addElement(cfo);
        model.addElement(fin);
        model.addElement(pur);

        //CTO
        Element cto = new Element("CTO", "25em", "18em");
        cto.addEndPoint(createEndPoint(EndPointAnchor.TOP));
        cto.addEndPoint(createEndPoint(EndPointAnchor.BOTTOM));

        Element dev = new Element("DEV", "25em", "30em");
        dev.addEndPoint(createEndPoint(EndPointAnchor.TOP));

        Element tst = new Element("TST", "25em", "30em");
        tst.addEndPoint(createEndPoint(EndPointAnchor.TOP));

        model.addElement(cto);
        model.addElement(dev);
        model.addElement(tst);

        

        //connections
        model.connect(new Connection(ceo.getEndPoints().get(0), cfo.getEndPoints().get(0), connector));
        model.connect(new Connection(ceo.getEndPoints().get(0), cto.getEndPoints().get(0), connector));
        model.connect(new Connection(cfo.getEndPoints().get(1), fin.getEndPoints().get(0), connector));
        model.connect(new Connection(cfo.getEndPoints().get(1), pur.getEndPoints().get(0), connector));
        model.connect(new Connection(cto.getEndPoints().get(1), dev.getEndPoints().get(0), connector));
        model.connect(new Connection(cto.getEndPoints().get(1), tst.getEndPoints().get(0), connector));
    }

    private EndPoint createEndPoint(EndPointAnchor anchor) {
        DotEndPoint endPoint = new DotEndPoint(anchor);
        endPoint.setStyle("{fill:'#404a4e'}");
        endPoint.setHoverStyle("{fill:'#20282b'}");

        return endPoint;
    }
    /*
public void create() {
		
		boolean error=false;
		average=calculateAverage(newGrade1, newGrade2, newGrade3);
		//System.out.println(average);
		if(newName==""||newGrade1==""||newGrade2==""||newGrade2=="") {
			errorMessage("asegurese de llenar todos los campos");
			error=true;
		}
			try {
			Integer.parseInt(newGrade1);
			Integer.parseInt(newGrade2);
			Integer.parseInt(newGrade3);
			}catch(NumberFormatException e) {
				e.printStackTrace();
				errorMessage("Por favor, recuerde que las notas no contienen letras");
				error=true;
				return;
				
			}
			if (containsNumbers(newName)==true) {
				errorMessage("Por favor, digite un nombre sin números ni carácteres especiales");
				error=true;
			}
			if (newName.length()==1) {
				errorMessage("Por favor, digite un nombre válido");
				error=true;
			}
		if(error==false) {
		int suma=Integer.parseInt(newGrade1)+Integer.parseInt(newGrade2)+Integer.parseInt(newGrade3);
		int aver=suma/3;
		String average=String.valueOf(aver);
		String iv = "holamundohfooooo";
		String key = "holamundohfmmmmm";
		//String average=String.valueOf(newGrade1);
		newName=AESUtil.encrypt(key, iv, newName);
		newGrade1=AESUtil.encrypt(key, iv, newGrade1);
		newGrade2=AESUtil.encrypt(key, iv, newGrade2);
		newGrade3=AESUtil.encrypt(key, iv, newGrade3);
		
		//serv.createEncrypted(newName, newGrade1, newGrade2, newGrade3);
		
		//usersMessage("Agregado correctamente");
		System.out.println(doPost("http://localhost:8081/user/createuserjason",
				"{\"name\": \"" + newName + "\",\"grade1\": \"" + newGrade1 + "\",\"grade2\": \"" + newGrade2 + "\",\"grade3\": \"" + newGrade3 + "\",}"));
		infoMessage("Su promedio es de "+average);
		
		
		
		

	
	}
		
		
		
		

	}
/*
	public void delete() {
		System.out.println(doDelete("http://localhost:8081/user/deletebyid/{id}", id.toString()));
		usersMessage("Success");

	}
*/
    
	public String mostrar() {
		
		System.out.println(doGet("http://localhost:8081/user/getall"));

		String graph1 = doGet("http://localhost:8081/user/getall");
		//Message("Success");
		return "";

	}
/*
	public void update() {
		System.out.println(doPut("http://localhost:8081/user/modifyuserjason/{id}",
				"{\"userName\": \"" + newUsername + "\",\"password\": \"" + newPass1 + "\"}", id.toString()));
		usersMessage("Success");
	}
*/
    
	public static String doGet(String url) {
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url))
				.setHeader("User-Agent", "Java 11 HttpClient Bot").build();

		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("status code -> " + response.statusCode());

		String uglyJson = response.body();
		return "";
	}
/*
	public static String doPut(String url, String json, String id) {
		url = url.replace("{id}", id);

		// add json header
		HttpRequest request = HttpRequest.newBuilder().PUT(HttpRequest.BodyPublishers.ofString(json))
				.uri(URI.create(url)).setHeader("User-Agent", "Java 11 HttpClient Bot")
				.header("Content-Type", "application/json").build();

		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("status code -> " + response.statusCode());
		System.out.println(response.body());
		return response.body();
	}

	public static String doDelete(String url, String id) {
		url = url.replace("{id}", id);

		// add json header
		HttpRequest request = HttpRequest.newBuilder().DELETE().uri(URI.create(url))
				.setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
				.header("Content-Type", "application/json").build();

		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("status code -> " + response.statusCode());

		return response.body();
	}

	public static String mostrarJason(String url) {
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url))
				.setHeader("User-Agent", "Java 11 HttpClient Bot").build();

		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("status code -> " + response.statusCode());

		String uglyJson = response.body();
		return prettyPrintUsingGson(uglyJson);
	}
*/
	public static String prettyPrintUsingGson(String uglyJson) {
		//Gson gson = new GsonBuilder().setLenient().setPrettyPrinting().create();
		Gson gson = new Gson();
		JsonElement jsonElement = JsonParser.parseString(uglyJson);
		String prettyJsonString = gson.toJson(jsonElement);
		return prettyJsonString;
	}
/*
	public void matchPasswords() {

	}

	public static String doPost(String url, String json) {
		System.out.println(1);

		// add json header
		HttpRequest request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(json))
				.uri(URI.create(url)).setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
				.header("Content-Type", "application/json").build();

		HttpResponse<String> response = null;

		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("status code -> " + response.statusCode());

		return response.body();
	}
}
*/
    public DiagramModel getModel() {
        return model;
    }



	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		//c.setNumberOfPlayers(numberOfPlayers);
		this.numberOfPlayers = numberOfPlayers;
	}

	public void setModel(DefaultDiagramModel model) {
		this.model = model;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private MyLinkedList<Vertex<Country>> countries;
	private Graph g;
	//private GraphRepository userRepo;

/*
	private static final Logger LOG=LoggerFactory.getLogger(LoadDataBase.class);
	
	private CommandLineRunner initDataBase(UserRepository userRepo) {
		return args -> {
			Optional<Player> found=userRepo.findByName("admin");
			if(found.isPresent()) {
				LOG.info("admin already exists, skipping admin creation");
			}else {
				userRepo.save(new Player(AESUtil.encrypt("admin"), AESUtil.encrypt("0"),AESUtil.encrypt("0"),AESUtil.encrypt("0"),AESUtil.encrypt("0")));
				LOG.info("pre-loading admin-user");
			}
		};//landa
	}
		
	
	*/
	private void fillRecionList() {
		countries.add(new Vertex(new Country("Alaska")));
		countries.add(new Vertex(new Country("Northwest Territory")));
		countries.add(new Vertex(new Country("Greenland")));
		countries.add(new Vertex(new Country("Alberta")));
		countries.add(new Vertex(new Country("Ontario")));
		countries.add(new Vertex(new Country("Quebec")));
		countries.add(new Vertex(new Country("Western United States")));
		countries.add(new Vertex(new Country("Eastern United States")));
		countries.add(new Vertex(new Country("Central America")));
		countries.add(new Vertex(new Country("Hawaii*")));
		countries.add(new Vertex(new Country("Venezuela")));
		countries.add(new Vertex(new Country("Peru")));
		countries.add(new Vertex(new Country("Brazil")));
		countries.add(new Vertex(new Country("Argentina")));
		countries.add(new Vertex(new Country("Falkland Islands*")));
		countries.add(new Vertex(new Country("North Africa")));
		countries.add(new Vertex(new Country("Egypt")));
		countries.add(new Vertex(new Country("East Africa")));
		countries.add(new Vertex(new Country("Congo")));
		countries.add(new Vertex(new Country("South Africa")));
		countries.add(new Vertex(new Country("Madagascar")));
		countries.add(new Vertex(new Country("Iceland")));
		countries.add(new Vertex(new Country("Svalbard*")));
		countries.add(new Vertex(new Country("Scandinavia")));
		countries.add(new Vertex(new Country("Ukraine")));
		countries.add(new Vertex(new Country("Great Britain")));
		countries.add(new Vertex(new Country("Northern Europe")));
		countries.add(new Vertex(new Country("Southern Europe")));
		countries.add(new Vertex(new Country("Western Europe")));
		countries.add(new Vertex(new Country("Indonesia")));
		countries.add(new Vertex(new Country("Phillipines*")));
		countries.add(new Vertex(new Country("New Guinea")));
		countries.add(new Vertex(new Country("Western Australia")));
		countries.add(new Vertex(new Country("Eastern Australia")));
		countries.add(new Vertex(new Country("New Zealand*")));
		countries.add(new Vertex(new Country("Siam")));
		countries.add(new Vertex(new Country("India")));
		countries.add(new Vertex(new Country("China")));
		countries.add(new Vertex(new Country("Mongolia")));
		countries.add(new Vertex(new Country("Japan")));
		countries.add(new Vertex(new Country("Irkutsk")));
		countries.add(new Vertex(new Country("Yakutsk")));
		countries.add(new Vertex(new Country("Kamchatka")));
		countries.add(new Vertex(new Country("Siberia")));
		countries.add(new Vertex(new Country("Afghanistan")));
		countries.add(new Vertex(new Country("Ural")));
		countries.add(new Vertex(new Country("Middle East")));

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
		
		for (int i = 0; i < countries.size(); i++) {
			g.addVertex(countries.get(i));
		}

	}
	private void createGraph(String origin, String destination) {
		Vertex or = new Vertex(numberOfPlayers);
		Vertex dest = new Vertex(numberOfPlayers);
		for (int i = 0; i < countries.size(); i++) {
			if (origin.equals(countries.get(i))) {
				or = countries.get(i);
			}
			if (destination.equals(countries.get(i))) {
				dest = countries.get(i);
			}
		}
		or.addEdge(new Edge(or, dest, 1));
		dest.addEdge(new Edge(dest, or, 1));

	}


	public MyLinkedList<Element> getNodes() {
		return nodes;
	}


	public void setNodes(MyLinkedList<Element> nodes) {
		this.nodes = nodes;
	}


	public List<Graph> getGraph() {
		return graph;
	}


	public void setGraph(List<Graph> graph) {
		this.graph = graph;
	}


	public String getSelectedRegion() {
		return selectedRegion;
	}


	public void setSelectedRegion(String selectedRegion) {
		this.selectedRegion = selectedRegion;
	}


	public MyLinkedList<Vertex<Country>> getCountries() {
		return countries;
	}


	public void setCountries(MyLinkedList<Vertex<Country>> countries) {
		this.countries = countries;
	}


	public Graph getG() {
		return g;
	}


	public void setG(Graph g) {
		this.g = g;
	}


	public static HttpClient getHttpclient() {
		return httpClient;
	}

	
	
	
	
	
	
	
	
	
	
	
    
}
