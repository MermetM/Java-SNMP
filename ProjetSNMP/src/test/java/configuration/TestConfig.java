package configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exeptions.MaterielExeption;

public class TestConfig {

	public static void main(String[] args) throws MaterielExeption {
		// TODO Auto-generated method stub


		Configuration conf = new Configuration();

		//conf.listEquipement();

		List<String> listOids = new ArrayList<String>();
		listOids.add("5555");
		listOids.add("6666");
		
		

			conf.removeEquipByIndex(1);


		//System.out.println(conf.getEquipementByName("sw2").toString()); //affiche un equipement 
		
		try {
			conf.newEquipement("10.1.1.2", "sw1", listOids);
			
			//conf.newEquipement("10.2.2.2", "sw2", listOids);



			conf.sauvEquipement();

			//conf.listEquipement();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
