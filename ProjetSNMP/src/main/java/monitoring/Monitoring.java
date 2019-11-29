package monitoring;

import java.io.IOException;
import java.net.SocketException;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.ScopedPDU;
import org.snmp4j.Snmp;
import org.snmp4j.Target;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

//https://www.snmp4j.org/doc/org/snmp4j/package-summary.html
//
//PDU Packet Data Unit  

public class Monitoring {
	
	private static int snmpVersion  = SnmpConstants.version1;
	
	public static void snmpRequest(String ipAddress, String port, String oid) throws IOException {
	     Snmp snmp = new Snmp(transportMapping());
	     Target target = targetCom(ipAddress, port, snmpVersion);
	     PDU responsePDU = snmpGet(snmp, target, oid);
	     
	     System.out.println(responsePDU.getVariableBindings());
	}
	
	
	
	private static TransportMapping transportMapping() throws IOException {
	    TransportMapping transport = new DefaultUdpTransportMapping();
	    transport.listen();
	    return transport;
	}
	
	public static CommunityTarget targetCom(String ipAddress,String port,int snmpVersion) {
		CommunityTarget comtarget = new CommunityTarget();
	    comtarget.setCommunity(new OctetString("public"));
	    comtarget.setVersion(snmpVersion);
	    comtarget.setAddress(new UdpAddress(ipAddress + "/" + port));
	    comtarget.setRetries(2);
	    comtarget.setTimeout(1000);
		return comtarget;
	}
	
	public static PDU snmpGet(Snmp snmp, Target target, String oid) throws IOException {
		
	    PDU pdu = new PDU();
	    
	    pdu.setType(PDU.GET);
	    pdu.add(new VariableBinding(new OID(oid)));
	    pdu.setRequestID(new Integer32(1));

	    //System.out.println("test");
	    ResponseEvent responseEvent = snmp.send(pdu, target);
	    PDU response = responseEvent.getResponse();
	    
	    if(response == null){
	    	
//	        log.warn("response null - error:{} peerAddress:{} source:{} request:{}",
//	                responseEvent.getError(),
//	                responseEvent.getPeerAddress());
	    	
	    	System.out.println("pas de reponses");
	    } 
	    System.out.println(response.getVariableBindings());
	    return response;
	}
}