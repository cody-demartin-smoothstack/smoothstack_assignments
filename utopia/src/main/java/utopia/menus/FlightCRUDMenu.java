package utopia.menus;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Scanner;

import utopia.admin.FlightsAdmin;
import utopia.dao.AirportDAO;
import utopia.entity.Flight;
import utopia.jdbc.DefaultConnection;

public class FlightCRUDMenu {
	static DefaultConnection def = new DefaultConnection();

	public static void selectAction(Flight flight) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your selection number (1 - 3) or press 0 to quit.");
		System.out.println("1) Create new flight");
		System.out.println("2) Update");
		System.out.println("3) Destroy");

		try {
			FlightsAdmin fa = new FlightsAdmin();

			Integer selection;
			do {
				selection = input.nextInt();
				if (selection == 1) {

				}
				if (selection == 2) {
					updateInput(flight);
				}
				if (selection == 3) {
					fa.deleteFlight(flight);
					System.out.println("Flight deleted.");
					break;
				}
			} while (selection != 0);
			if (selection == 0) {
				AdminMenu.printSelections();
			}
		} catch (Exception e) {

		} finally {
			input.close();
		}

	}

	public static void updateInput(Flight flight) {
		FlightsAdmin fa = new FlightsAdmin();
		Scanner input = new Scanner(System.in);
		Connection conn = null;
		System.out.println("Viewing flight with ID " + flight.getId() + ", and Departure Airport: "
				+ flight.getRoute().getOrigin().getIataId() + " and Arrival Airport: "
				+ flight.getRoute().getDestination().getIataId());
		System.out.println("Enter quit at anytime to exit.");
		System.out.println();
		System.out.println("Enter new origin code. NA to skip.");
		try {
			conn = def.getConnection();
			AirportDAO airportSearch = new AirportDAO(conn);
			String newOrigin;
			do {
				newOrigin = input.nextLine();
				if (airportSearch.getSingleAirport(newOrigin) == null) {
					System.out.println("Invalid airport. Pick another.");
				} else if (newOrigin == "NA") {
					break;
				} else {
					flight.getRoute().setOrigin(airportSearch.getSingleAirport(newOrigin));
					break;
				}
			} while (!newOrigin.equals("quit"));
			if (newOrigin == "quit") {

			}
			System.out.println("Enter new destination code. NA to skip.");
			String newDestination;
			do {
				newDestination = input.nextLine();
				if (airportSearch.getSingleAirport(newDestination) == null) {
					System.out.println("Invalid airport. Pick another.");
				} else if (newOrigin == "NA") {
					break;
				} else {
					flight.getRoute().setDestination(airportSearch.getSingleAirport(newDestination));
					break;
				}
			} while (!newDestination.equals("quit"));
			System.out.println("Enter new departure date and time (YYYY-MM-DD HH:MM:SS format). NA to skip.");
			String newDepartureInfo;
			do {
				newDepartureInfo = input.nextLine();
				Timestamp ts = Timestamp.valueOf(newDepartureInfo);
				if (ts != null) {
					flight.setDepartureTime(ts);
					break;
				} else if (newDepartureInfo == "NA") {
					break;
				} else {
					System.out.println("Invalid datetime entry.");
				}
			} while (!newDepartureInfo.equals("quit"));
			System.out.println("Enter new arrival date and time (YYYY-MM-DD HH:MM:SS format). NA to skip.");
			String arrivalInfo;
			do {
				arrivalInfo = input.nextLine();
				Timestamp ts = Timestamp.valueOf(arrivalInfo);
				if (ts != null) {
					flight.setArrivalTime(ts);
					break;
				} else if (arrivalInfo == "NA") {
					break;
				} else {
					System.out.println("Invalid datetime entry.");
				}
			} while (!arrivalInfo.equals("quit"));
			System.out.println("Enter allowed first class seats as integer, -1 to skip.");
			Integer first;
			do {
				first = input.nextInt();
				if (first >= 0 && first <= flight.getAirplane().getType().getMaxFirstClass()) {
					flight.setAllowedFirst(first);
					break;
				}
				else {
					System.out.println("Invalid input.");
				}
				
			} while (first != -1);
			
			System.out.println("Enter allowed business class seats as integer, -1 to skip.");
			Integer business;
			do {
				business = input.nextInt();
				if (business >= 0 && business <= flight.getAirplane().getType().getMaxBusinessClass()) {
					flight.setAllowedBusiness(business);
					break;
				}
				else {
					System.out.println("Invalid input.");
				}
			} while (business != -1);
			
			System.out.println("Enter allowed econ class seats as integer, -1 to skip.");
			Integer econ;
			do {
				econ = input.nextInt();
				if (econ >= 0 && econ <= flight.getAirplane().getType().getMaxEconClass()) {
					flight.setAllowedEcon(econ);
					break;
				}
				else {
					System.out.println("Invalid input.");
				}
			} while (econ != -1);
			fa.updateFlight(flight);
			System.out.println("Updated. Press enter to continue.");
			System.in.read();
			selectAction(flight);
		} catch (Exception e) {

		}
		finally {
			input.close();
		}
	}
}

// allAirports.forEach(airport -> {
//System.out.print("Iata_id: "+airport.getAirportCode()+" ");
//System.out.print("City: "+airport.getCity()+"\n");
//});

//for (User u : allUsers) {
//    System.out.print("\nUserId: "+u.getId()+" Username: "+u.getUsername()+" Name: "+ u.getGiven_name() +" "+ u.getGiven_name());
//}

//public static void newAirportPrompts(Scanner airportInfo, Airport a){
//    System.out.println("Please enter the 3 char Iata Id: ");
//    String iata_id = airportInfo.nextLine();
//    System.out.println("Please enter the city of the aiport");
//    String city = airportInfo.nextLine();
//
//    a.setAirportCode(iata_id.toUpperCase(Locale.ROOT));
//    a.setCity(city);
//}
//
//public static void updateAirportPrompts(Scanner airportInfo, Airport a){
//    System.out.println("If you do not want to change the value please enter N/A");
//    System.out.println("Please enter the city of the aiport");
//    String city = airportInfo.nextLine();
//    if(!city.equalsIgnoreCase("N/A")) a.setCity(city);
//
//}
//
//public static void newUserPrompts(Scanner userInfo, User u) {
//    System.out.println("Please enter user First name: ");
//    String first = userInfo.nextLine();
//    System.out.println("Please enter user Last name: ");
//    String last = userInfo.nextLine();
//    System.out.println("Please enter user username: ");
//    String username = userInfo.nextLine();
//    System.out.println("Please enter user email: ");
//    String email = userInfo.nextLine();
//    System.out.println("Please enter user password: ");
//    String password = userInfo.nextLine();
//    System.out.println("Please enter user phone: ");
//    String phone = userInfo.nextLine();
//
//    u.setGiven_name(first);
//    u.setFamily_name(last);
//    u.setUsername(username);
//    u.setEmail(email);
//    u.setPassword(password);
//    u.setPhone(phone);
//}
//
//public static void updateUserPrompts(Scanner userInfo, User u){
//
//   System.out.println("If you do not want to change the value please enter N/A");
//    System.out.println("Please enter user First name: ");
//    String first = userInfo.nextLine();
//     if(!first.equalsIgnoreCase("N/A") )u.setGiven_name(first);
//    System.out.println("Please enter user Last name: ");
//    String last = userInfo.nextLine();
//    if(!last.equalsIgnoreCase("N/A") )u.setFamily_name(last);
//    System.out.println("Please enter user username: ");
//    String username = userInfo.nextLine();
//    if(!username.equalsIgnoreCase("N/A") )u.setUsername(username);
//    System.out.println("Please enter user email: ");
//    String email = userInfo.nextLine();
//    if(!email.equalsIgnoreCase("N/A") )u.setEmail(email);
//
//    System.out.println("Please enter user password: ");
//    String password = userInfo.nextLine();
//    if(!password.equalsIgnoreCase("N/A") )u.setPassword(password);
//
//    System.out.println("Please enter user phone: ");
//    String phone = userInfo.nextLine();
//    if(!phone.equalsIgnoreCase("N/A") )u.setPhone(phone);
//
//}
