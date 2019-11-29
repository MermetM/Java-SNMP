package monitoring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import configuration.Materiel;

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
		monitoring.Monitoring.snmpRequest(mat.getIp(), "22", oid);
		
		
	}
}
