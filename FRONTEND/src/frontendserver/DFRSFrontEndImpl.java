package frontendserver;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.omg.CORBA.ORB;

import frontend.DFRSFrontEndPOA;
import console.ConsoleMethodsInformation;
import frontendserver.FrontEndServer;

import java.util.Date;

public class DFRSFrontEndImpl extends DFRSFrontEndPOA {
	
	private ORB orb = null;
	private FrontEndServer frontEndServer = null;
	private int UDPPort = 0;
	private String UDPHost = null;
	
	private static String message = "";

	//private Map<String, ConsoleMethodsInformation> repositoryInfo = new HashMap<String, ConsoleMethodsInformation>();
	private Logger log = null;

	private Date theTime = null;
	
	private String sequencerHost = "localhost";
	private int sequencerPort = 2001;
	
	
	//class constructor
	public DFRSFrontEndImpl(ORB orb,String UDPHost, int UDPPort){
	
		this.orb = orb;
		this.UDPHost = UDPHost;
		this.UDPPort = UDPPort;
		this.frontEndServer = new FrontEndServer(UDPHost, UDPPort, this);
		
		initialize();
		
		this.log = this.startLogger();
		
	}//end of class constructor definition
	
	
	
	
	private Logger startLogger(){
		Logger log = Logger.getLogger("Logs:/FRONTEND-Log");
		FileHandler fileHandler;
		
		try{
			fileHandler = new FileHandler("FRONTEND-Log.log");
			log.setUseParentHandlers(false);
			log.addHandler(fileHandler);
			
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
			
		}catch(SecurityException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return log;
		
	}//end of startLogger method definition
	
	
	private void initialize(){
			Thread thread = new Thread(this.frontEndServer);
			thread.start();
			
			/*this.repositoryInfo.put("ALLBOOKINGS", new ConsoleMethodsInformation("127.0.0.1", 44810));
			this.repositoryInfo.put("ALLFLIGHTS", new ConsoleMethodsInformation("127.0.0.1", 44811));
			this.repositoryInfo.put("BOOKFLIGHT", new ConsoleMethodsInformation("127.0.0.1", 44812));
			this.repositoryInfo.put("EDITFLIGHTRECORD", new ConsoleMethodsInformation("127.0.0.1", 44813));
			this.repositoryInfo.put("GETBOOKEDFLIGHTCOUNT", new ConsoleMethodsInformation("127.0.0.1", 44814));
			this.repositoryInfo.put("TRANSFERRESERVATION", new ConsoleMethodsInformation("127.0.0.1", 44815));*/
		
	}//end of initialize method definition
	
	
	/*
	* Method which sends a datagram packet
	* to the sequencer whenever the client calls
	* the bookFlight method
	*/
	@Override
	public String bookFlight(String firstName, String lastName,
			String phoneNumber, String address, String destination,
			String dateOfFlight, String flightClass) {
		// TODO Auto-generated method stub

		
		theTime = new Date();
		this.log.info("Time of BOOKFLIGHT method invocation: " + theTime.getTime());
		this.log.info("Information " + "|" + "BOOKFLIGHT" + "|" + firstName + "|" + lastName + "|" + phoneNumber + "|" + address + "|" + destination + "|" + dateOfFlight+ "|" + flightClass);
		
		String bookFlightInformationToSendToSequencer = "BOOKFLIGHT" + "|" + firstName + "|" + lastName + "|" + phoneNumber + "|" + address + "|"  + destination + "|" + dateOfFlight+ "|" + flightClass; 
		DatagramSocket aSocket = null;
		
		try{
			aSocket = new DatagramSocket();
			byte[] requestedMessage = bookFlightInformationToSendToSequencer.getBytes();
			
			DatagramPacket theRequest = new DatagramPacket(requestedMessage, requestedMessage.length, new InetSocketAddress(sequencerHost, sequencerPort));
			aSocket.send(theRequest);
			this.log.info("Time at which Front end send requests to Sequencer: " + theTime.getTime());
		
			
		}//end of try block
		catch(SocketException e){
			System.out.println("A SocketException has occured: " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("A IOException has occured: " + e.getMessage());
		} 
		 finally {
			if (aSocket != null)
				aSocket.close();
		}
		
		return message;
		
		
	}//end of bookFlight method definition
	
	
	
	/*
	* Method which sends a datagram packet
	* to the sequencer whenever the client calls
	* the getBookedFlightCount method
	*/
	@Override
	public String getBookedFlightCount(int recordType) {
		// TODO Auto-generated method stub
		
			
		theTime = new Date();
		this.log.info("Time of GETBOOKEDFLIGHTCOUNT method invocation: " + theTime.getTime());
		this.log.info("Information " + "|" + "GETBOOKEDFLIGHTCOUNT");
		
		
		String bookFlightInformationToSendToSequencer = "GETBOOKEDFLIGHTCOUNT"; 
		DatagramSocket aSocket = null;
		
		try{
			aSocket = new DatagramSocket();
			byte[] requestedMessage = bookFlightInformationToSendToSequencer.getBytes();
			
			DatagramPacket theRequest = new DatagramPacket(requestedMessage, requestedMessage.length, new InetSocketAddress(sequencerHost, sequencerPort));
			aSocket.send(theRequest);
			this.log.info("Time at which Front end send requests to Sequencer: " + theTime.getTime());
			
			
		}//end of try block
		catch(SocketException e){
			System.out.println("A SocketException has occured: " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("A IOException has occured: " + e.getMessage());
		} 
		finally {
			if (aSocket != null)
				aSocket.close();
		}
		
		return message;
		
	}//end of getBookedFlightCount method definition
	
	
	
	/*
	* Method which sends a datagram packet
	* to the sequencer whenever the client calls
	* the editFlightRecord method
	*/
	@Override
	public String editFlightRecord(String recordID, String fieldName,String newValue) {
		// TODO Auto-generated method stub
			
		theTime = new Date();
		this.log.info("Time of EDITFLIGHTRECORD method invocation: " + theTime.getTime());
		this.log.info("Information " + "|" + "EDITFLIGHTRECORD" + "|" + recordID + "|" + fieldName + "|" + newValue);
		
		
		String bookFlightInformationToSendToSequencer = "EDITFLIGHTRECORD" + "|" + recordID + "|" + fieldName + "|" + newValue;
		DatagramSocket aSocket = null;
		
		try{
			aSocket = new DatagramSocket();
			byte[] requestedMessage = bookFlightInformationToSendToSequencer.getBytes();
			
			DatagramPacket theRequest = new DatagramPacket(requestedMessage, requestedMessage.length, new  InetSocketAddress(sequencerHost, sequencerPort));
			aSocket.send(theRequest);
			this.log.info("Time at which Front end send requests to Sequencer: " + theTime.getTime());
			
			
		}//end of try block
		catch(SocketException e){
			System.out.println("A SocketException has occured: " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("A IOException has occured: " + e.getMessage());
		} 
		finally {
			if (aSocket != null)
				aSocket.close();
		}
		
		return message;
	}//end of editFlightRecord method definition
	
	
	
	/*
	* Method which sends a datagram packet
	* to the sequencer whenever the client calls
	* the transferReservation method
	*/
	@Override
	public String transferReservation(String passengerID, String currentCity,
			String otherCity) {
		// TODO Auto-generated method stub
		theTime = new Date();
		this.log.info("Time of TRANSFERRESERVATION method invocation: " + theTime.getTime());
		this.log.info("Information " + "|" + "TRANSFERRESERVATION" + "|" + passengerID + "|" + currentCity + "|" + otherCity);
		
		
		String bookFlightInformationToSendToSequencer = "TRANSFERRESERVATION" + "|" + passengerID + "|" + currentCity + "|" + otherCity ; 
		DatagramSocket aSocket = null;
		
		try{
			aSocket = new DatagramSocket();
			byte[] requestedMessage = bookFlightInformationToSendToSequencer.getBytes();
			
			DatagramPacket theRequest = new DatagramPacket(requestedMessage, requestedMessage.length, new InetSocketAddress(sequencerHost, sequencerPort));
			aSocket.send(theRequest);
			this.log.info("Time at which Front end send requests to Sequencer: " + theTime.getTime());
			
			
		}//end of try block
		catch(SocketException e){
			System.out.println("A SocketException has occured: " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("A IOException has occured: " + e.getMessage());
		} 
		finally {
			if (aSocket != null)
				aSocket.close();
		}
		
		return message;
		
	}//end of transferReservation method definition
	
	
	
	
	/*
	* Method which sends a datagram packet
	* to the sequencer whenever the client calls
	* the allFlights method
	*/
	@Override
	public String allFlights() {
		// TODO Auto-generated method stub
		theTime = new Date();
		this.log.info("Time of ALLFLIGHTS method invocation: " + theTime.getTime());
		this.log.info("Information " + "|" + "ALLFLIGHTS");
		
		
		String bookFlightInformationToSendToSequencer = "ALLFLIGHTS"; 
		DatagramSocket aSocket = null;
		
		try{
			aSocket = new DatagramSocket();
			byte[] requestedMessage = bookFlightInformationToSendToSequencer.getBytes();
			
			DatagramPacket theRequest = new DatagramPacket(requestedMessage, requestedMessage.length, new InetSocketAddress(sequencerHost, sequencerPort));
			aSocket.send(theRequest);
			this.log.info("Time at which Front end send requests to Sequencer: " + theTime.getTime());
	
			
		}//end of try block
		catch(SocketException e){
			System.out.println("A SocketException has occured: " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("A IOException has occured: " + e.getMessage());
		} 
		finally {
			if (aSocket != null)
				aSocket.close();
		}
		
		return message;
		
	}//end of allFlights method definition
	
	
	
	
	
	/*
	* Method which sends a datagram packet
	* to the sequencer whenever the client calls
	* the allBookings method
	*/
	@Override
	public String allBookings() {
		// TODO Auto-generated method stub
		
		theTime = new Date();
		this.log.info("Time of ALLBOOKINGS method invocation: " + theTime.getTime());
		this.log.info("Information " + "|" + "ALLBOOKINGS");
		
		
		String bookFlightInformationToSendToSequencer = "ALLBOOKINGS"; 
		DatagramSocket aSocket = null;
		
		try{
			aSocket = new DatagramSocket();
			byte[] requestedMessage = bookFlightInformationToSendToSequencer.getBytes();
			
			DatagramPacket theRequest = new DatagramPacket(requestedMessage, requestedMessage.length, new InetSocketAddress(sequencerHost, sequencerPort));
			aSocket.send(theRequest);
			this.log.info("Time at which Front end send requests to Sequencer: " + theTime.getTime());
			

			
		}//end of try block
		catch(SocketException e){
			System.out.println("A SocketException has occured: " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("A IOException has occured: " + e.getMessage());
		} 
		finally {
			if (aSocket != null)
				aSocket.close();
		}
		
		return message;
		
	}//end of allBookings class definition


	
	
	//method which sets the value of the ORB
	public void setORB(ORB orbValue) {
		this.orb = orbValue;
		
	}//end of setORB method definition
	


	//method which shut downs the orb
	@Override
	public void shutDown() {
		// TODO Auto-generated method stub
		this.orb.shutdown(false);
	}//end of shutDown method definition
	
	
	public int getUDPPort() {
		// TODO Auto-generated method stub
		return this.UDPPort;
		
	}//end of getUDPPort method definition

	

	public String getUDPHost() {
		// TODO Auto-generated method stub
		return this.UDPHost;
		
	}//end of getUDPHost method definition







	
	
}//end of DFRSFrontEndImpl class definition
