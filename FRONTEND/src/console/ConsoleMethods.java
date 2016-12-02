package console;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ConsoleMethods {
	
	/*
	 * Static void function which only displays a welcome message
	 */
	public static void welcome(){
		System.out.println("**************************************************************************");
		System.out.println("********** WELCOME TO THE DISTRIBUTED FLIGHT RESERVATION SYSTEM **********");
		System.out.println("**************************************************************************");
		System.out.println();
		
	}//end of welcome method definition
	
	
	/*
	 * Static function that returns a string corresponding to the 
	 * current location from which the passenger wants to book a flight
	 * 
	 * This method has one argument:
	 * 		1. Argument 1 of type Scanner to enable the user 
	 * 		   to enter value from the console.
	 */
	public static String passengerLocation(Scanner sc){
		System.out.println();
		System.out.println("Enter the number corresponding to your location.");
		System.out.println("	1. Departure from Montreal.");
		System.out.println("	2. Departure from New Delhi.");
		System.out.println("	3. Departure from Washington.");
		System.out.println("	4. Exit.\n");
		System.out.print("Choice: ");
		
		int chosenNumber = 0;
		String passengerLocation = "";
		
		try{
			chosenNumber = sc.nextInt();
			
			//verify whether or not the chose number is between 1 and 4
			while((chosenNumber < 1)||(chosenNumber > 4)){
				System.out.println("The entered number is not an option. Please try again.\n");
				System.out.print("Choice: ");
				chosenNumber = sc.nextInt();
			}
			
			if(chosenNumber == 1)
				passengerLocation = "MTL";
				
			else if(chosenNumber == 2)
				passengerLocation = "NDL";
		
			else if(chosenNumber == 3)
				passengerLocation = "WST";
			
			else{
				System.out.println("Thanks for using the Flight Reservation System. See you soon!");
				System.exit(0);
			}
		}
		catch(InputMismatchException e){
			System.out.println("Invalid input. You should enter an integer. Please try again. \n");
			System.out.print("Choice: ");
			chosenNumber = sc.nextInt();
		}
		return passengerLocation;
		
	}//end of passengerLocation method definition
	
	
	
	/*
	 * Static function that returns a string corresponding to the 
	 * city manager on which the client wants to perform its operations
	 * 
	 * This method has one argument:
	 * 		1. Argument 1 of type Scanner to enable the user 
	 * 		   to enter value from the console.
	 */
	public static String managerLocation(Scanner sc){
		System.out.println();
		System.out.println("Enter the number corresponding to your location.");
		System.out.println("	1. Loggin from Montreal's manager.");
		System.out.println("	2. Loggin from New Delhi's manager.");
		System.out.println("	3. Loggin from Washington's manager.");
		System.out.println("	4. Exit.\n");
		System.out.print("Choice: ");
		
		int chosenNumber = 0;
		String managerLocation = "";
		
		try{
			chosenNumber = sc.nextInt();
			
			//verify whether or not the chose number is between 1 and 4
			while((chosenNumber < 1)||(chosenNumber > 4)){
				System.out.println("The entered number is not an option. Please try again.\n");
				System.out.print("Choice: ");
				chosenNumber= sc.nextInt();
			}
			
			if(chosenNumber == 1)
				managerLocation = "MTL";
				
			else if(chosenNumber == 2)
				managerLocation = "NDL";
		
			else if(chosenNumber == 3)
				managerLocation = "WST";
			
			else{
				System.out.println("Thanks for using the Flight Reservation System. See you soon!");
				System.exit(0);
			}
		}
		catch(InputMismatchException e){
			System.out.println("Invalid input. You should enter an integer. Please try again. \n");
			System.out.print("Choice: ");
			chosenNumber = sc.nextInt();
		}
		return managerLocation;
		
	}//end of managerLocation method definition
	
	
	
	/*
	 * Static function that returns the integer
	 * corresponding to the appropriate type
	 * of user.
	 * 
	 * This method has one argument:
	 * 		1. Argument 1 of type Scanner to enable the user 
	 * 		   to enter value from the console.
	*/
	public static int choicePassengerOrManager(Scanner sc){
		int choice = 0;
		try{
			System.out.println("Select the appropriate number.");
			System.out.println("\t1. Passenger");
			System.out.println("\t2. Manager");
			System.out.println("\t3. Exit.");
			System.out.print("Choice: ");
			
			choice = sc.nextInt();
			
			while((choice < 1) || (choice > 3)){
				System.out.println("The entered number is not an option. Please try again.");
				choice = sc.nextInt();
			}
			
			if(choice == 3){
				System.out.println("Thanks for using the Flight Reservation System. See You soon !");
				System.exit(0);
			}
		}
		catch(InputMismatchException e){
			System.out.println("Invalid input. You should enter an integer. Please try again. \n");
			System.out.print("Decision: ");
			choice = sc.nextInt();
		}
		return choice;
		
	}//end of choiceOfPassengerOrManager method definition
	
	
	
	/*
	 * Static function that returns the integer corresponding 
	 * to the operation that the passenger wants to execute.
	 * 
	 * This method has one argument:
	 * 		1. Argument 1 of type Scanner to enable the user 
	 * 		   to enter value from the console.
	 * 
	 * If the passenger enters 1, the system will allow him
	 * to book a flight
	 * 
	 * If the passenger enters 2, the system will allow him
	 * to see the complete list of flights
	 * 
	 * If the passenger enters 3, the program will terminate.
	 * 
	 * */ 
	public static int actionToBePerformedByPassenger(Scanner sc){
		System.out.println("*******************************************************");
		System.out.println();
		System.out.println("	1. Book Flight");
		System.out.println("	2. See the list of scheduled flights");
		System.out.println("	3. Exit\n");
		System.out.print("Choice: ");
		
					
		int chosenNumber = 0;
		int option = 0;
					
		try{
			chosenNumber = sc.nextInt();
						
			while((chosenNumber < 1)||(chosenNumber > 3)){
				System.out.println("The entered number is not an option. Please try again.\n");
				System.out.print("Choice: ");
				chosenNumber= sc.nextInt();
			}
						
			if(chosenNumber == 1)
				option = 1;
			else if(chosenNumber == 2)
				option = 2;
			else if(chosenNumber == 3)
				option = 3;
			else{
				System.out.println("Thanks for using the Flight Reservation System. See you soon!");
				System.exit(0);
			}
		}
		catch(InputMismatchException e){
			System.out.println("Invalid input. You should enter an integer. Please try again. \n");
			System.out.print("Choice: ");
		}
		return option;
					
	}//end of actionToBePerformedByPassenger method definition
	
	
	
	/*
	 * Static function that returns the integer corresponding 
	 * to the operation that the manager wants to execute.
	 * 
	 * 
	 * This method has one argument:
	 * 		1. Argument 1 of type Scanner to enable the user 
	 * 		   to enter value from the console.
	 * 
	 * 
	 * If the manager enters 1, the system will allow it
	 * to see the list of scheduled flights
	 * 
	 * If the manager enters 2, the system will allow it
	 * to see the complete list of passenger records
	 * 
	 * If the manager enters 3, the system will allow it
	 * to edit a flight
	 * 
	 * If the manager enters 4, the system will allow
	 * it to get the number of booked flights
	 * 
	 * If the manager enters 5, the system will allow 
	 * it to transfer a booking from the current city
	 * to another manager city
	 * 
	 * If the manager enters 6, the program will terminate.
	 * 
	 * */ 
	public static int actionToBePerformedByManager(Scanner sc){
		System.out.println("*******************************************************");
		System.out.println("	1. See the list of scheduled flights");
		System.out.println("	2. See the list of passenger records");
		System.out.println("	3. Edit flight");
		System.out.println("	4. Get number of booked flights");
		System.out.println("	5. Transfer reservation");
		System.out.println("	6. Exit\n");
		System.out.print("Choice: ");
		
		int chosenNumber = 0;
		int option = 0;
		
		try{
			chosenNumber = sc.nextInt();
			
			while((chosenNumber < 1)||(chosenNumber > 6)){
				System.out.println("The entered number is not an option. Please try again.\n");
				System.out.print("Choice: ");
				chosenNumber= sc.nextInt();
			}
			
			if(chosenNumber == 1)
				option = 1;
			else if(chosenNumber == 2)
				option = 2;
			else if(chosenNumber == 3)
				option = 3;
			else if(chosenNumber == 4)
				option = 4;
			else if(chosenNumber == 5)
				option = 5;
			else if (chosenNumber == 6)
				option = 6;
			else{
				System.out.println("Thanks for using the Flight Reservation System. See you soon!");
				System.exit(0);
			}
		}
		catch(InputMismatchException e){
			System.out.println("Invalid input. You should enter an integer. Please try again. \n");
			System.out.print("Choice: ");

		}
		return option;
		
	}//end of actionToBePerformedByManager method definition
	
	
	
	
	/*
	 * Static function that returns an array of type String containing 
	 * the passenger's information
	 * 
	 * 
	 * This method has one argument:
	 * 		1. Argument 1 of type Scanner to enable the user 
	 * 		   to enter value from the console.
	 * 
	 * The array size is four (range of elements: 0 to 3)
	 * 
	 * The element with index 0 is the passenger's firstName
	 * The element with index 1 is the passenger's lastName
	 * The element with index 2 is the passenger's phoneNumber
	 * The element with index 3 is the passenger's address
	 * */
	public static  String [] initializePersonalInformation(Scanner sc){
		String [] personalData = new String[4];
	
		System.out.println();
		System.out.println("*******ENTER YOUR PERSONAL INFORMATION***********");
		System.out.println("Enter your first name:\n");
		sc.nextLine();
		personalData[0] = sc.nextLine();
		
		System.out.println("Enter your last name:\n");
		personalData[1] = sc.nextLine();	
		
		System.out.println("Enter your phone number (xxx-xxx-xxxx):\n");
		personalData[2] = sc.nextLine();
			
		System.out.println("Enter your address:\n");
		personalData[3] = sc.nextLine();
			
		
		return personalData;
		
	}//end of initializePersonalInformation method definition
	
	

	
	
	
	/*
	 * Static method that returns a String corresponding to the 
	 * flight class in which the passenger wants to travel.
	 * 
	 * This method has one argument:
	 * 		1. Argument 1 of type Scanner to enable the user 
	 * 		   to enter value from the console.
	 */
	
	/*
	 * Static method that returns a String
	 * 
	 * This method has two arguments:
	 * 		1. Argument 1 of type Scanner to enable the user 
	 * 		   to enter value from the console.
	 *
	 * 		2. Argument 2 of type String to tell the function
	 * 		   what is the city of departure to consequently choose
	 * 		   the destination has the destination cannot be the same
	 * 		   same as the city of departure.
	 */
	
	public static String getDestination(Scanner sc, String location){
		int destinationValue = 0;
		String destination = null;
		String departureCityAndDestination = null;
		
		System.out.println();
		System.out.println("*******************************************************");
		System.out.println("Where would you like to travel?");
		System.out.println("Enter the corresponding destination: ");
		
		try{
			if(location.equalsIgnoreCase("Montreal") || location.equalsIgnoreCase("MTL")){
				System.out.println("\tDestination 1: New Delhi");
				System.out.println("\tDestination 2: Washington");
				System.out.print("Chosen Destination: ");
				
				destinationValue = sc.nextInt();
				if(destinationValue == 1)
					destination = "NDL";
				else
					destination = "WST";
			}
			
			else if (location.equalsIgnoreCase("New Delhi") || location.equalsIgnoreCase("NDL")){
				System.out.println("\tDestination 1: Montreal");
				System.out.println("\tDestination 2: Washington");
				
				destinationValue = sc.nextInt();
				if(destinationValue == 1)
					destination = "MTL";
				else
					destination = "WST";
			}
			else if (location.equalsIgnoreCase("Washington") || location.equalsIgnoreCase("WST")){
				System.out.println("\tDestination 1: Montreal");
				System.out.println("\tDestination 2: New Delhi");
				
				destinationValue = sc.nextInt();
				if(destinationValue == 1)
					destination = "MTL";
				else
					destination = "NDL";
					
			}
	
			while((destinationValue <1) || (destinationValue > 2)){
				System.out.println("The entered number is not an option. Please try again.");
				destinationValue = sc.nextInt();
			}
		}
		catch(InputMismatchException e){
			System.out.println("The entered value is not an integer. Please try again");
			destinationValue = sc.nextInt();
		}
			
		departureCityAndDestination = location.toUpperCase() + "-" + destination;
		return departureCityAndDestination;
	
	}


	public static String getFlightClass(Scanner sc){
		int flightClassValue = 0;
		String flightClass = null;
		
		
		System.out.println();
		System.out.println("*******************************************************");
		System.out.println("In which class do you want to do your reservation?");
		System.out.println("Enter the corresponding flight class: ");
		System.out.println("\t1. Economic Class");
		System.out.println("\t2. Business Class");
		System.out.println("\t3. First Class");
		System.out.print("Chosen class: ");
		
		
		try{
			
			flightClassValue = sc.nextInt();
			
			while((flightClassValue <1) || (flightClassValue> 3)){
				System.out.println("The entered number is not an option. Please try again.");
				flightClassValue = sc.nextInt();
			}
			
			
			if(flightClassValue == 1)
				flightClass = "Economic";
			else if (flightClassValue == 2)
				flightClass = "Business";
			else 
				flightClass = "First";
				
		}
		catch(InputMismatchException e){
			System.out.println("The entered value is not an integer. Please try again");
			flightClassValue = sc.nextInt();
		}
		
		
		return flightClass;
		
	}//end of getFlightClass method definition
	
	public static String getDateOfFlight(Scanner sc){
		
		System.out.println("Enter the departure date (dd/mm/yyyy).");
		System.out.print("Departure Date: ");
		sc.nextLine();
		String departureDate = sc.nextLine();
		
	
		return departureDate;
		
	}//end of getDateOfFlight method definition
	
	
	
	/*
	 * Static method that returns an array of string corresponding to the arguments
	 * that are used for editing a flight
	 * 
	 * This method has two arguments:
	 * 		1. Argument 1 of type Scanner to enable the user 
	 * 		   to enter value from the console.
	 *
	 *      2. Argument 2 of type String to tell the function
	 * 		   what is the city of departure to consequently choose
	 * 		   the destination has the destination cannot be the same
	 * 		   same as the city of departure.
	 */
	public static String [] getArgumentsForEditingFlights(Scanner sc, String location){
		String [] arguments = new String[3];
		
		System.out.println();
		System.out.println("*******************************************************");
		System.out.println();
		System.out.println("What action do you want to perform?");
		System.out.println("\tEnter 1 for adding a flight.");
		System.out.println("\tEnter 2 for deleting a flight.");
		System.out.println("\tEnter 3 for editing a flight.");
		System.out.print("Decision: ");
		
	
		int decision;
		
		try{
			decision = sc.nextInt();
			
			while((decision < 1)||(decision > 3)){
				System.out.println("The entered number is not an option. Please try again.\n");
				System.out.print("Decision: ");
				decision = sc.nextInt();
			}
			
			//for adding a flight
			if(decision == 1){
				
				//to obtain the new flight's ID
				System.out.println("Enter the flight's ID (ABC123)");
				System.out.print("ID: ");
				sc.nextLine();
				arguments[0] = sc.nextLine().toUpperCase();
				
				//to set the fieldName
				arguments[1] = "ADD";
				
				//to set the flight's city of departure
				String departureCity =  location;
				
				//to set the flight's destination
				int destinationValue = 0;
				String destination = null;
				System.out.println("Enter the corresponding destination: ");
				if(location.equalsIgnoreCase("Montreal") || location.equalsIgnoreCase("MTL")){
					System.out.println("\tDestination 1: New Delhi");
					System.out.println("\tDestination 2: Washington");
					System.out.print("Chosen Destination: ");
						
						destinationValue = sc.nextInt();
						if(destinationValue == 1)
							destination = "NDL";
						else
							destination = "WST";
					}
					
					else if (location.equalsIgnoreCase("New Delhi") || location.equalsIgnoreCase("NDL")){
						System.out.println("\tDestination 1: Montreal");
						System.out.println("\tDestination 2: Washington");
						
						destinationValue = sc.nextInt();
						if(destinationValue == 1)
							destination = "MTL";
						else
							destination = "WST";
					}
					else if (location.equalsIgnoreCase("Washington") || location.equalsIgnoreCase("WST")){
						System.out.println("\tDestination 1: Montreal");
						System.out.println("\tDestination 2: New Delhi");
						
						destinationValue = sc.nextInt();
						if(destinationValue == 1)
							destination = "MTL";
						else
							destination = "NDL";
							
					}

					while((destinationValue <1) || (destinationValue > 2)){
						System.out.println("The entered number is not an option. Please try again.");
						destinationValue = sc.nextInt();
					}	
				
				
				//to set the departure date
				String departureDate = null;
				System.out.println();
				System.out.println("Enter flight's departure date (dd/mm/yyyy).");
				System.out.print("Departure Date:");
				sc.nextLine();
				departureDate = sc.nextLine();
				System.out.println();
				
				arguments[2] = departureCity + "-" + destination + "-" + departureDate;
			}
			//for deleting a flight
			else if(decision == 2){
			
				System.out.println("Enter the ID of the flight that you want to delete.");
				System.out.print("Flight's ID: ");
				sc.nextLine();
				
				//to set the recordID
				arguments[0] = sc.nextLine().toUpperCase();
				
				//to set the fieldName
				arguments[1] = "DELETE";
				
				//to set the newValue
				arguments[2] = "";
				
			}
			
			//for editing a flight
			else{
				arguments = new String[3];
				System.out.println("Enter the ID of the flight that you want to edit as it is written.");
				System.out.println("Flight ID: ");
				
				//to set the recordID
				arguments[0] = sc.nextLine().toUpperCase();
				
				//to set the fieldName
				arguments[1] = "EDIT";
				
				
				System.out.println();
				System.out.println("What would you like to edit?");
				System.out.println("\tEnter 1 for changing the flight's destination");
				System.out.println("\tEnter 2 for changing the flight's departure date");
				System.out.println("\tEnter 3 for changing the flight's return date");
				System.out.println("\tEnter 4 for changing the number of seats");
				System.out.print("Decision: ");
				
				decision = sc.nextInt();
				
				while((decision < 1)||(decision > 4)){
					System.out.println("The entered number is not an option. Please try again.\n");
					System.out.print("Decision: ");
					decision = sc.nextInt();
				}
				
				//modify the flight's destination
				String fieldToChange = null;
				String fieldToChangeNewValue = null;
				String newValueSeats = null;
				
				if(decision == 1){
					fieldToChange = "DESTINATION";
					
					System.out.println("Enter the new destination");
					System.out.println("Destination: ");
					fieldToChangeNewValue = sc.nextLine();
				}
				//to modify the flight's departure date
				else if (decision == 2){
					fieldToChange = "DEPARTURE";
					
					System.out.println("Enter the flight's departure date (dd/mm/yyyy).");
					System.out.print("Departure Date:");
					fieldToChangeNewValue = sc.nextLine();
					
				}
				//to modify the flihgt's return date
				else if (decision == 3){
					fieldToChangeNewValue = "RETURN";
					
					System.out.println("Enter the flight's return date (dd/mm/yyyy).");
					System.out.print("Return Date:");
					fieldToChangeNewValue = sc.nextLine();
				}
				//to modify the number of seats
				else if(decision == 4){
					fieldToChange = "SEATS";
					int chosenClass = 0;
					
					System.out.println("Enter the value corresponding to the class in which you want to perform the modification");
					System.out.println("\t1. Economic class");
					System.out.println("\t2. Business class");
					System.out.println("\t3. First class");
					
					System.out.println("Flight Class: ");
					chosenClass = sc.nextInt();
			
					if(chosenClass == 1)
						fieldToChangeNewValue = "ECONOMIC";
					else if(chosenClass == 2)
						fieldToChangeNewValue = "BUSINESS";
					else 
						fieldToChangeNewValue = "FIRST";
					
					System.out.println("Enter the new number of seats");
					System.out.print("Seats: ");
					newValueSeats = sc.nextLine();
					
					while((chosenClass < 1)||(chosenClass > 3)){
						System.out.println("The entered number is not an option. Please try again.\n");
						System.out.print("Flight Class: ");
						decision = sc.nextInt();
					}
				}
				arguments[2] = fieldToChange + "-" + fieldToChangeNewValue + "-" + newValueSeats;
			
			}
		}
		catch(InputMismatchException e){
			System.out.println("Invalid input. You should enter an integer. Please try again. \n");
			System.out.print("Decision: ");
			decision = sc.nextInt();	
			
		}
		return arguments;
		
	}//end of getArgumentsForEditingFlights method definition
	
	
	
	
	/*
	 * Static method that returns an array of string corresponding to the arguments
	 * that are used for transferring a reservation.
	 * 
	 * This method has two arguments:
	 * 		1. Argument 1 of type Scanner to enable the user 
	 * 		   to enter value from the console.
	 *
	 *      2. Argument 2 of type String to tell the function
	 * 		   what is the city of departure to consequently choose
	 * 		   the destination has the destination cannot be the same
	 * 		   same as the city of departure.
	 */
	public static String[] getArgumentsForTransferringAReservation(Scanner sc, String location){
		String[] arguments = new String[3];
		
		System.out.println();
		System.out.println("*******************************************************");
		System.out.println("Enter the passenger's ID: ");
		System.out.print("ID: ");
		sc.nextLine();
		arguments[0] = sc.nextLine().toUpperCase();
	
				
		arguments[1] = location;
		
		System.out.println("Enter the name of city to which you want to transfer the reservation");
		System.out.print("Other city: ");
		arguments[2] = sc.nextLine().toUpperCase();
		
		return arguments;
		
	}//end of getArgumentsForTransferringAReservation method definition
	
	
	
	/*
	* Static method which returns an interger corresponding
	* to the client`s decision of exiting the program or not.
	*
	* This method has one argument:
	* 		1. Argument 1 of type Scanner to enable the user 
	* 		   to enter value from the console.
	*/
	public static int continueOrNot(Scanner sc){
		System.out.println();
		System.out.println("*****************************************************************************");
		System.out.println();
		System.out.println("Do you want anything else?");
		System.out.println("   1. YES");
		System.out.println("   2. NO");
		System.out.print("Decision: ");
		
		int continueOrExit = 0;
				
		try{
			continueOrExit = sc.nextInt();
					
			while((continueOrExit < 1)||(continueOrExit> 2)){
				System.out.println("The entered number is not an option. Please try again.\n");
				System.out.print("Decision: ");
				continueOrExit = sc.nextInt();
			}
					
			if(continueOrExit == 1){
				System.out.println("*******************************************************");
			}
			else{
				System.out.println("Thanks for using the Flight Reservation System. See You soon !");
				System.exit(0);
			}
		}
		catch(InputMismatchException e){
			e.printStackTrace();
				
		}

		return continueOrExit;	
	}//end of continueOfNotMethod definition
	
	
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		String [] passengerInformation = initializePersonalInformation(sc);
		for(int i = 0; i<passengerInformation.length; i++){
			System.out.println(passengerInformation[i]);
		}
	}
	
	


	
}//end of ConsoleMethods class definition