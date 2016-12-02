package frontendserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import frontendserver.DFRSFrontEndImpl;

public class FrontEndServer implements Runnable{
	
	private String host = null;
	private int port = 0;
	private boolean isActive = true;
	private DFRSFrontEndImpl frontEndImpl = null;
	
	public FrontEndServer(String host, int port, DFRSFrontEndImpl frontEndImpl) {
		
		this.host = host;
		this.port = port;
		this.frontEndImpl= frontEndImpl;
	
	}//end of constructor definition
	
	
	public FrontEndServer(String host, int port){
		this.host = host;
		this.port = port;
	
	}//end of constructor definition
	
	
	public void stop() {
		this.isActive = false;
		
	}//end of stop method definition
	
	public void start()throws IOException, ClassNotFoundException {
			
		DatagramSocket server = new DatagramSocket(port);
		byte[] data = new byte[2048];
		
		while(isActive) {
			
			// create a datagram packet to store the incoming data
			DatagramPacket in = new DatagramPacket(data, data.length);
			server.receive(in);
			
			// get the information we need to reply from the incoming data
			InetAddress ip = in.getAddress();
			port = in.getPort();
			
			// unmarshall the incoming data and execute the method
			IUDPObject unmarshalledData = Marshaller.unmarshall(in.getData());
			unmarshalledData.execute(this.frontEndImpl);
			
			// send the response out
			byte[] data_out = Marshaller.marshall(unmarshalledData);
			DatagramPacket out = new DatagramPacket(data_out, data_out.length, ip, port);
			server.send(out);
		}

	}//end of start method definition
	
	public void run() {
		try {
			start();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}//end of run method definition
	

}//end of FrontEndServer class definition
