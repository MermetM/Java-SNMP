package configuration;
  

import java.util.ArrayList;
import java.util.List;




//import org.json.simple.JSONObject;  
//import org.json.simple.JSONArray;  
// config le classpath

public class Materiel {

	private String ip;
	private String name;
	
	//private String[] OIDS; 
	List<String> OIDS;
	
//	public Materiel(String ip, String name, String[] oIDS) throws IOException {
	
	public Materiel(String ip, String name, List<String> oIDS) {
	super();
	this.ip = ip;
	this.name = name;
	
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



	@Override
	public String toString() {
		return "Materiel [ip=" + ip + ", name=" + name + ", OIDS=" + OIDS + "]";
	}

	
}
