import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import configuration.Configuration;

public class Menu {

	public static void displayMenu() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.println("\n\n         Menu SNMP");
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
			case 2:  // do something
				break;
			}
		} catch (NumberFormatException e) {  }


	}
	
	@SuppressWarnings("resource")
	public static void displayMenuConfig() {
		
		Scanner input = new Scanner(System.in);
		Configuration conf = new Configuration();
			
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
				System.out.println("Entrer une addresse IP");
				Scanner input_ip = new Scanner(System.in);
				String ip = input_ip.next(); 
				System.out.println("Entrer un nom d'équipement");
				Scanner input_name = new Scanner(System.in);
				String name = (input_name.next());
				int i = 1;
				List<String> listOids = new ArrayList<String>();
				while (i != 0) {
					System.out.println("Entrer un OID (Q pour quitter)");
					Scanner input_oid = new Scanner(System.in);
					String oid = input_oid.nextLine(); 
					listOids.add(oid);
					char  reponse = oid.charAt(0);
					if ( reponse == 'q' ) {
				 		i = 0;
						listOids.remove(oid);
					}					
				}				
				
				try {
					conf.newEquipement(ip, name, listOids);
					conf.sauvEquipement();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		public static void displayMenuMonitoring() {
			
			Scanner input = new Scanner(System.in);
			Configuration conf = new Configuration();
				
			System.out.println("\n\n         Menu Monitoring");
			System.out.println("--------------------------------------");
			System.out.println("1 - ");
			System.out.println("2 - ");
			System.out.println("5 - Revenir au menu précedent");

			System.out.print("\nChoisissez ce que vous voulez faire: ");
			try {

				int input1 = (input.nextInt()); 

				switch (input1) {
				case 1:  
									
					break;
					
				case 2: 
					
					break;
				
				case 3: 
					
					break;
				
				case 4: 
					
					break;
					
				case 5: 
					displayMenu();
					break;
					
				
				}
			} catch (NumberFormatException e) {  }
			
	}
	
		@SuppressWarnings("resource")
		public static void displayMenuLog() {
			
			Scanner input = new Scanner(System.in);
			Configuration conf = new Configuration();
				
			System.out.println("\n\n         Menu Log");
			System.out.println("--------------------------------------");
			System.out.println("1 - Lister le fichier de Log Erreur");
			System.out.println("2 - Lister le fichier de Log Succés");
			System.out.println("5 - Revenir au menu précedent");

			System.out.print("\nChoisissez ce que vous voulez faire: ");
			try {

				int input1 = (input.nextInt()); 

				switch (input1) {
				case 1:  
									
					break;
					
				case 2: 
					
					break;
				
				case 3: 
					
					break;
				
				case 4: 
					
					break;
					
				case 5: 
					displayMenu();
					break;
					
				
				}
			} catch (NumberFormatException e) {  }
			
	}

}
