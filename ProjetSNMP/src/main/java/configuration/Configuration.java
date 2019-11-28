package configuration;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Configuration {
	
	ArrayList<Materiel> objList;
	//JSONObject objList;
	
	
	public Configuration() {
		super();
		objList = new ArrayList<Materiel>();
		readJsonFile();
	}
	
	
	public void newEquipement(String ip, String name, List<String> oIDS) throws IOException {
		
		if(isIpExist(ip) == false) {
			Materiel mat = new Materiel(ip, name, oIDS);
			objList.add(mat);
			System.out.println("Successfully Added New Materiel To The Curent Config...");
			System.out.println(mat.toString());
		}
		
	}
	
	
	public boolean isIpExist (String ip) {
		boolean isIP = false;
		
		for(Materiel temp : objList) {
			if(temp.getIp() == ip)
					{
						isIP=true;
					} 
		}
		return isIP;
	}
	
	
	
	
	public void sauvEquipement() throws IOException {
		
		 
		JSONArray jsonArr = new JSONArray();
		try (FileWriter file = new FileWriter("/home/saaam/eclipse-workspace/LogitielSNMP/materiels.json")) {
			
				
			for(Materiel temp : objList) {
				
				JSONObject objJSON = new JSONObject();
				JSONObject obj = new JSONObject();
				
				objJSON.put("ip", temp.getIp()); 
				objJSON.put("name", temp.getName());
			
				JSONArray oids = new JSONArray();
				Iterator<String> iterator = temp.getOIDS().iterator();
				while(iterator.hasNext()) {
					oids.add(iterator.next());
				}
				
				objJSON.put("list oids", oids);
				obj.put("materiel", objJSON);
				jsonArr.add(obj);
				
				
				//jsonArr.add(obj);//toJSONString?
				System.out.println("Successfully Copied JSON Object to File...");
				System.out.println("JSON Object: " + objJSON);
				}
			
	
				file.write(jsonArr.toJSONString());
				file.flush();
	
			}
		}
	
	public void listEquipement() {
		for(Object temp : objList) {
			System.out.println(temp.toString());
		}
	}
	
	public List<Materiel> getEquipement() {
		
		return objList;
	}

	public void readJsonFile() {
		//JSON parser object to parse read file
	    JSONParser jsonParser = new JSONParser();
	     
	    try (FileReader reader = new FileReader("/home/saaam/eclipse-workspace/LogitielSNMP/materiels.json"))
	    {
	        //Read JSON file
	        Object obj = jsonParser.parse(reader);
	
	        JSONArray materielList = (JSONArray) obj;
	        System.out.println(materielList);
	         
	        //Iterate over materiel array
	        materielList.forEach( mat -> parseMaterielObject((JSONObject) mat));

	
	    } catch (FileNotFoundException e) {
	        //e.printStackTrace();
	        System.out.println("fichier inexistant");
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (ParseException e) {
	        //e.printStackTrace();
	        System.out.println("fichier vide");
	    }
	}
	
	private void parseMaterielObject(JSONObject materiel) 
	{

	    JSONObject materielObject = (JSONObject) materiel.get("materiel");
	     

	    String ip = (String) materielObject.get("ip");    
	    //System.out.println(ip);
	     

	    String name = (String) materielObject.get("name");  
	    //System.out.println(name);
	     

	    List<String> oIDS = (List<String>) materielObject.get("list oids");    
        //System.out.println(oIDS.toString());
	    
	    Materiel mat = new Materiel(ip, name, oIDS);
	    objList.add(mat);
	    
	}
}





//private void readJsonFile() {
//
//JSONParser parser = new JSONParser();
//
//try {
//    Object obj = parser.parse(new FileReader("/home/saaam/eclipse-workspace/LogitielSNMP/materiels.json")); // origine
//    
//    JSONObject jsonObject = (JSONObject) obj; //origine
//    
//    //JSONArray jsonArr = (JSONArray) obj;
//    
//    //for (JSONObject jsonObject : jsonArr) {
//    	
//        
//        
//        String ip = (String) jsonObject.get("ip");
//        String name = (String) jsonObject.get("name");
//        JSONArray oids = (JSONArray) jsonObject.get("list oids");
//        List<String> listOids = new ArrayList<String>();
//        
//        
//        System.out.println("ip: " + ip);
//        System.out.println("name: " + name);
//        System.out.println("list oids:");
//       
//        //System.out.println(oids.toJSONString());
//        
//        Iterator<String> iterator = oids.iterator();
//        while (iterator.hasNext()) {
//        	String str = iterator.next();
//            listOids.add(str);
//            System.out.println(str);
//        }
//        
//        Materiel mat = new Materiel(ip, name, listOids);
//        //mat.toString();
//        System.out.println("test");
//        objList.add(mat); //err
//    //} // fin for
//    
//} catch (Exception e) {
//    e.printStackTrace();
//}
//}

