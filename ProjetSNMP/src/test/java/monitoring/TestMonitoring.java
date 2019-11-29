package monitoring;

import java.io.IOException;

public class TestMonitoring {

	public static void main(String[] args) {
		
		Monitoring moni = new Monitoring();
		
		
		try {
			
			moni.snmpRequest("127.0.0.1", "161", "1.3.6.1.2.1.1.6.0");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
