package configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Create {
	@SuppressWarnings("resource")
	public static void creerMateriel() {
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
			char reponse = oid.charAt(0);
			if ( reponse == 'q' ) {
				i = 0;
				listOids.remove(oid);
			}					
		}				

		try {
			menu.Menu.conf.newEquipement(ip, name, listOids);
			menu.Menu.conf.sauvEquipement();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
