package configuration;

//singloton : la classe conf aurai du etre un objet avec constructeur en private et une methode qui le gere
//ca rendai cette obj singulier unique

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

import exceptions.MaterielExeption;



public class Configuration {


	private static ArrayList<Materiel> objList;
	private static final String DEFAULT_PATH = "C:\\SNMP\\materiels.json";
	private String aPath;
	//JSONObject objList;


	public Configuration() {
		super();
		objList = new ArrayList<Materiel>();
		aPath = "";
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


	public void sauvEquipement() throws IOException {

		JSONArray jsonArr = new JSONArray();
		String path;
		if(aPath.isEmpty())
			{
				path = DEFAULT_PATH;
			} else path = aPath;
		
		try (FileWriter file = new FileWriter(path)) {


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
	
	public Materiel getEquipementByName(String name) {
		Materiel mat = null;
		
		for(Materiel temp : objList) {
			if(temp.getName().equals(name))
			{
				mat = temp;
			}
		}
	
		return mat;
	}
	
	public void removeEquipByIndex(int nSup) throws MaterielExeption {
		objList.remove(nSup);
		System.out.println("Successfully removed...");
	}

	public void readJsonFile() {
		//JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		String path;
		if(aPath.isEmpty())
			{
				path = DEFAULT_PATH;
			} else path = aPath;
		
		try (FileReader reader = new FileReader(path))
		{
			//Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONArray materielList = (JSONArray) obj;
			//System.out.println(materielList);

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
	
	public static ArrayList<Materiel> getObjList() {
		return objList;
	}

	public boolean isIpExist (String ip) {
		boolean isIP = false;
		for(Materiel temp : objList) {

			if(temp.getIp().equals(ip))
			{
				isIP=true;
			} 
		}
		return isIP;
	}


	public String getaPath() {
		return aPath;
	}


	public void setaPath(String aPath) {
		this.aPath = aPath;
	}
}

