package monitoring;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import configuration.Configuration;
import configuration.Materiel;
import monitoring.Monitoring;

public class Request {
	public static void snmpRequest() throws IOException {
		System.out.println("Choisissez l'equipement pour la requete");
		Scanner input_nom = new Scanner(System.in);
		String nom = input_nom.next(); 
		Materiel mat = menu.Menu.conf.getEquipementByName(nom);
		System.out.println(mat);
		System.out.println("Choisissez l'OID pour la requete");
		Scanner input_oid = new Scanner(System.in);
		String oid = input_oid.next(); 
		monitoring.Monitoring.snmpRequest(mat.getIp(), "161", oid);		
	}
	public static void requestAll() throws IOException {
		ArrayList<Materiel> listMat = Configuration.getObjList();
		
		for (Materiel materiel : listMat) {
			List<String> listOid = materiel.getOIDS();
			for (String materiel2 : listOid) {			
			monitoring.Monitoring.snmpRequest(materiel.getIp(), "161", materiel2);	
			}
		}
	}
}
