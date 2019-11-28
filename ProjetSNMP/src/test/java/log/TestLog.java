package log;

import java.io.IOException;

public class TestLog {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String message = "Equipement = R2, OID = .1.2.5.6.4, Etat = OK";
		String error = "Equipement = SW5, OID = .1.2.5.6.4, Etat = NOK";
		String modif = "Conf du SW2";
		Log.success(message); 
		Log.error(error); 
		Log.modif(modif); 
	}

}
