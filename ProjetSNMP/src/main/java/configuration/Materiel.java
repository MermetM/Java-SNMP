package configuration;


import java.util.ArrayList;
import java.util.List;




//import org.json.simple.JSONObject;  
//import org.json.simple.JSONArray;  
// config le classpath

public class Materiel {

	private String ip;
	private String name;
	private String port;
	
	public static final String DEFAULT_PORT = "161";
	
	//private String[] OIDS; 
	List<String> OIDS;

	//	public Materiel(String ip, String name, String[] oIDS) throws IOException {

	public Materiel(String ip, String name, List<String> oIDS) {
		super();
		this.ip = ip;
		this.name = name;
		this.port = DEFAULT_PORT; 
		OIDS = oIDS;
	}
	public Materiel(String ip, String name,String port, List<String> oIDS) {
		super();
		this.ip = ip;
		this.name = name;
		this.port = port; 
		OIDS = oIDS;
	}

	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public List<String> getOIDS() {
		return OIDS;
	}



	public void setOIDS(List<String> oIDS) {
		OIDS = oIDS;
	}
	
	public void insertOID(String oIDS) {
		OIDS.add(oIDS);
	}



	@Override
	public String toString() {
		return "Materiel [ip=" + ip + ", name=" + name + ", OIDS=" + OIDS + "]";
	}


}
