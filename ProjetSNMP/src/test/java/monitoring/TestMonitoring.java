package monitoring;

import java.io.IOException;

public class TestMonitoring {

	public static void main(String[] args) {
		
		Monitoring moni = new Monitoring();
		
		
		try {
			
			moni.snmpRequest("10.0.0.0", "8080", ".1.3.6.1.2.1.1.1.0");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
