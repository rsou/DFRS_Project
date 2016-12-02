package console;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import console.ConsoleMethods;
import frontend.DFRSFrontEnd;
import frontend.DFRSFrontEndHelper;


public class ConsoleClient {

	static DFRSFrontEnd frontEndImpl;
	
	
	public ConsoleClient() throws NotBoundException , RemoteException{
		this.initiateOrb();
		
	}//end of class constructor method definition
	
	
	
	public void initiateOrb(){
		try {
			String[] args = new String[1];
			ORB orb = ORB.init(args, null);
			
		
			BufferedReader br = new BufferedReader(new FileReader("FRONTENDior.txt"));
			String FRONTENDior = br.readLine();
			br.close();
			
			org.omg.CORBA.Object obj = orb.string_to_object(FRONTENDior);
			frontEndImpl = DFRSFrontEndHelper.narrow(obj);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//end of initializeOrb method definition

	
	
	
	public String allFlights()throws NotFound, CannotProceed, InvalidName{	
		return frontEndImpl.allFlights();
		
	}//end of getFlights method definition
	
	
	
	public String allBookings()throws NotFound, CannotProceed, InvalidName{
		return frontEndImpl.allBookings();
		
	}//end of getFlights method definition
	
	
	
	public String bookFlight(String firstName, String lastName, String phoneNumber, String address,String destination, String dateOfFlight, String flightClass) throws CannotProceed, InvalidName, NotFound{
		return frontEndImpl.bookFlight(firstName, lastName, phoneNumber, address, destination, dateOfFlight, flightClass);
	
	}//end of bookFlight method definition
	
	
	public String editFlightRecord(String recordID, String fieldName,String newValue) throws CannotProceed, InvalidName, NotFound{
		return frontEndImpl.editFlightRecord(recordID, fieldName, newValue);
		
		
	}//end of editflightRecord method definition
	
	
	public String transferReservation(String passengerID, String currentCity, String otherCity) throws CannotProceed, InvalidName, NotFound{
		return frontEndImpl.editFlightRecord(passengerID, currentCity, otherCity);
		
	}//end of transferReservation method definition
	
	
	
	public String getBookedFlightCount(int recordType) throws CannotProceed, InvalidName, NotFound{
		return frontEndImpl.getBookedFlightCount(recordType);
		
	}//end of getBookedFlightCount method definition
	
	
	
	
	
	
	//Driver
	public static void main(String [] args){
		
		Scanner sc = new Scanner(System.in);
		
		ConsoleClient client = null;
		try{
			client = new ConsoleClient();
		}
		catch(Exception e){
			System.out.println("An error has occured: " + e.getMessage());
		}
		
		//welcome message
		ConsoleMethods.welcome();
		
		//the user informs the system as to whether he is a passenger or a manager
		int clientType = 0;
		clientType = ConsoleMethods.choicePassengerOrManager(sc);
		
		//when the client is a passenger
		if(clientType == 1){
			
			int operationToBeExecuted = 0;
			String location = ConsoleMethods.passengerLocation(sc);
			
			String [] passengerInformation = ConsoleMethods.initializePersonalInformation(sc);
			
			while(true){
				
				operationToBeExecuted = ConsoleMethods.actionToBePerformedByPassenger(sc);
	
				//to book a flight
				if(operationToBeExecuted == 1){
					String firstName = passengerInformation[0];
					String lastName = passengerInformation[1];
					String phoneNumber = passengerInformation[2];
					String address = passengerInformation[3];
					String dates = ConsoleMethods.getDateOfFlight(sc);
					String destination = ConsoleMethods.getDestination(sc, location);
					String flightClass = ConsoleMethods.getFlightClass(sc);
					
					try{
						System.out.println();
						System.out.println("****************** Booking a Flight **********************");
						System.out.println();
						
						client.bookFlight(firstName, lastName, phoneNumber, address,dates, destination, flightClass);
					}
					catch(CannotProceed | InvalidName | NotFound e){
						System.out.println("An error has occurred: The system could not complete the reservation. We are sorry about that.");
						e.printStackTrace();
					}
					
				}
				
				//to see the complete list of scheduledFlights
				else if (operationToBeExecuted == 2){
					try{
						System.out.println();
						System.out.println("*************** LIST OF SCHEDULED FLIGHTS FROM " + (location.toUpperCase())+ " ***************");
						System.out.println();
						
						client.allFlights();
					}
					catch(CannotProceed | InvalidName | NotFound e){
						System.out.println("An error has occurred: The system could not display the complete list of scheduled flights. We are sorry about that.");
						e.printStackTrace();
					}
				}	
				else{
					System.out.println("Thanks for using the Flight Reservation System. See you soon !");
					System.exit(0);
					
				}
				int number = ConsoleMethods.continueOrNot(sc);
				if(number == 1)
					continue;
				else
					break;
			}
		}
			
		
		//when the client is a manager
		else if (clientType == 2){
			
			int operationToBeExecuted = 0;
			String managerCity = ConsoleMethods.managerLocation(sc);
			
			while(true){
				
				operationToBeExecuted = ConsoleMethods.actionToBePerformedByManager(sc);
				switch(operationToBeExecuted){
				
				//to see the list of scheduled flights
				case 1:
					try{
						
						System.out.println();
						System.out.println("*************** LIST OF SCHEDULED FLIGHTS FROM " + (managerCity.toUpperCase())+ " ***************");
						System.out.println();
						
						client.allFlights();
					}
					catch(CannotProceed | InvalidName | NotFound e){
						System.out.println("An error has occurred: The system could not display the complete list of scheduled flights. We are sorry about that.");
						e.printStackTrace();
					}
					ConsoleMethods.continueOrNot(sc);

				//to see the list of passenger records
				case 2:
					try{
						System.out.println();
						System.out.println("*************** LIST OF PASSENGER RECORDS FROM " + (managerCity.toUpperCase())+ " ***************");
						System.out.println();
						
						client.allBookings();
					}
					catch(CannotProceed | InvalidName | NotFound e){
						System.out.println("An error has occurred: The system could not display the complete list of passenger records. We are sorry about that.");
						e.printStackTrace();
					}
					
					ConsoleMethods.continueOrNot(sc);
					
					
				//to edit a flight
				case 3:
					try{
						System.out.println();
						System.out.println("*************** EDITING FLIGHTS FROM " + (managerCity.toUpperCase())+ " ***************");
						System.out.println();
						
						String [] arguments = ConsoleMethods.getArgumentsForEditingFlights(sc, managerCity);
						client.editFlightRecord(arguments[0], arguments[1], arguments[2]);
					}
					catch(CannotProceed | InvalidName | NotFound e){
						System.out.println("An error has occurred: The system could not display the complete the operation. We are sorry about that.");
						e.printStackTrace();
					}

					ConsoleMethods.continueOrNot(sc);
					
				//to obtain the number of booked flights
				case 4:
					try{
						System.out.println();
						System.out.println("*************** ACCESSING THE NUMBER OF BOOKED FLIGHTS ***************");
						System.out.println();
						
						client.getBookedFlightCount(0);
					}
					catch(CannotProceed | InvalidName | NotFound e){
						System.out.println("An error has occurred: The system could not retrieve the number of booked flights from other managers. We are sorry about that.");
						e.printStackTrace();
					}
					
					ConsoleMethods.continueOrNot(sc);
					
				//to transfer a reservation
				case 5: 
					try{
						String [] arguments = ConsoleMethods.getArgumentsForTransferringAReservation(sc, managerCity);
						client.transferReservation(arguments[0], arguments[1], arguments[2]);
					}
					catch(CannotProceed | InvalidName | NotFound e){
						System.out.println("An error has occurred: The system could not transfer the reservation. We are sorry about that.");
						e.printStackTrace();
					}
					
					ConsoleMethods.continueOrNot(sc);
					
				default:
					System.out.println("Thanks for using the Flight Reservation System. See you soon !");
					System.exit(0);
					
				}//end of switch
			}
		}
	}//end of main
	
	


}//end of ConsoleClient class definition
