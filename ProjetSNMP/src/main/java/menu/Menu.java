package menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import configuration.Configuration;
import configuration.Create;
import log.Log;
import monitoring.Monitoring;
import monitoring.Request;

public class Menu {
	
	public static Configuration conf = new Configuration();
	

	public static void displayMenu() throws IOException {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.println("\n\n         Menu Principal");
		System.out.println("--------------------------------------");
		System.out.println("1 - Configuration d'un équipement");
		System.out.println("2 - Monitoring d'un équipement");
		System.out.println("3 - Accéder au log de l'équipement");
		System.out.println("4 - Quitter");
		System.out.print("\nChoisissez ce que vous voulez faire: ");
		try {
			int input1 = (input.nextInt()); 

			switch (input1) {
			case 1:  
				displayMenuConfig();
				break;
			case 2:  
				displayMenuMonitoring();
				break;
			case 3:  
				displayMenuLog();
				break;

			case 4:  
				System.out.println("\n!!!!! FIN !!!!!");
				break;
			}
		} catch (NumberFormatException e) {  }
	}

	@SuppressWarnings("resource")
	public static void displayMenuConfig() throws IOException {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("\n\n         Menu Configuration");
		System.out.println("--------------------------------------");
		System.out.println("1 - Créer un équipement ");
		System.out.println("2 - Lister/Afficher un configuration");
		System.out.println("3 - Importer configuration depuis un Json");
		System.out.println("4 - Sauvergarde et restauration");
		System.out.println("5 - Revenir au menu précedent");
		System.out.print("\nChoisissez ce que vous voulez faire: ");
		try {

			int input1 = (input.nextInt()); 

			switch (input1) {
			case 1:  
				Create.creerMateriel();
				displayMenuConfig();

				break;

			case 2: 
				conf.listEquipement();
				displayMenuConfig();
				break;

			case 3: 

				displayMenuConfig();
				break;

			case 4: 

				displayMenuConfig();
				break;

			case 5: 
				displayMenu();
				break;


			}
		} catch (NumberFormatException e) {  }

	}

	@SuppressWarnings("resource")
	public static void displayMenuMonitoring() throws IOException {

		Scanner input = new Scanner(System.in);

		System.out.println("\n\n         Menu Monitoring");
		System.out.println("--------------------------------------");
		System.out.println("1 - SNMP Request");
		System.out.println("2 - ");
		System.out.println("5 - Revenir au menu précedent");

		System.out.print("\nChoisissez ce que vous voulez faire: ");
		try {

			int input1 = (input.nextInt()); 

			switch (input1) {
			case 1:  
				conf.listEquipement();
				Request.snmpRequest();
				displayMenuMonitoring();
				break;

			case 2: 
				displayMenuMonitoring();
				break;

			case 3: 
				displayMenuMonitoring();
				break;

			case 5: 
				displayMenu();
				break;


			}
		} catch (NumberFormatException e) {  }

	}

	@SuppressWarnings("resource")
	public static void displayMenuLog() throws IOException {

		Scanner input = new Scanner(System.in);

		System.out.println("\n\n         Menu Log");
		System.out.println("--------------------------------------");
		System.out.println("1 - Lister le fichier de Log Erreur");
		System.out.println("2 - Lister le fichier de Log Success");
		System.out.println("3 - Voir les modifications faites sur l'équipement");
		System.out.println("4 - Revenir au menu précedent");

		System.out.print("\nChoisissez ce que vous voulez faire: ");
		try {

			int input1 = (input.nextInt()); 

			switch (input1) {
			case 1:  
				Log.voirErreur();
				displayMenuLog();
				break;

			case 2: 
				Log.voirSuccess();
				displayMenuLog();
				break;

			case 3: 
				Log.voirModif();
				displayMenuLog();
				break;

			case 4: 
				displayMenu();
				break;			

			}
		} catch (NumberFormatException e) {  }

	}

}