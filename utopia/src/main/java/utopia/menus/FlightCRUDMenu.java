package utopia.menus;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Scanner;

import utopia.admin.FlightsAdmin;
import utopia.dao.AirplaneDAO;
import utopia.dao.AirplaneTypeDAO;
import utopia.dao.AirportDAO;
import utopia.dao.RouteDAO;
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
					newInput();
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

	public static void newInput() {
		FlightsAdmin fa = new FlightsAdmin();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter route id.");
		Flight nf = new Flight();
		Connection conn = null;

		try {
			Integer routeId;
			conn = def.getConnection();
			do {
				routeId = input.nextInt();
				RouteDAO airportSearch = new RouteDAO(conn);
				if (airportSearch.getSingleRoute(routeId) == null) {
					System.out.println("Invalid airport. Pick another.");
				} else {
					nf.setRoute(airportSearch.getSingleRoute(routeId));
					break;
				}
			} while (routeId != 0);

			System.out.println("Enter airplane id.");
			Integer planeId;
			do {
				planeId = input.nextInt();
				AirplaneDAO airportSearch = new AirplaneDAO(conn);
				if (airportSearch.getSingleAirplane(planeId) == null) {
					System.out.println("Invalid airport. Pick another.");
				} else {
					nf.setAirplane(airportSearch.getSingleAirplane(planeId));
					break;
				}
			} while (planeId != 0);

			System.out.println("Enter new departure date and time (YYYY-MM-DD HH:MM:SS format).");
			String newDepartureInfo;
			do {
				newDepartureInfo = input.nextLine();
				Timestamp ts = Timestamp.valueOf(newDepartureInfo);
				if (ts != null) {
					nf.setDepartureTime(ts);
					break;
				} else {
					System.out.println("Invalid datetime entry.");
				}
			} while (!newDepartureInfo.equals("quit"));
			System.out.println("Enter new arrival date and time (YYYY-MM-DD HH:MM:SS format).");
			String arrivalInfo;
			do {
				arrivalInfo = input.nextLine();
				Timestamp ts = Timestamp.valueOf(arrivalInfo);
				if (ts != null) {
					nf.setArrivalTime(ts);
					break;
				} else {
					System.out.println("Invalid datetime entry.");
				}
			} while (!arrivalInfo.equals("quit"));
			System.out.println("Enter allowed first class seats as integer.");
			Integer first;
			do {
				first = input.nextInt();
				if (first >= 0 && first <= nf.getAirplane().getType().getMaxFirstClass()) {
					nf.setAllowedFirst(first);
					break;
				} else {
					System.out.println("Invalid input.");
				}

			} while (first != -1);

			System.out.println("Enter allowed business class seats as integer.");
			Integer business;
			do {
				business = input.nextInt();
				if (business >= 0 && business <= nf.getAirplane().getType().getMaxBusinessClass()) {
					nf.setAllowedBusiness(business);
					break;
				} else {
					System.out.println("Invalid input.");
				}
			} while (business != -1);

			System.out.println("Enter allowed econ class seats as integer.");
			Integer econ;
			do {
				econ = input.nextInt();
				if (econ >= 0 && econ <= nf.getAirplane().getType().getMaxEconClass()) {
					nf.setAllowedEcon(econ);
					break;
				} else {
					System.out.println("Invalid input.");
				}
			} while (econ != -1);
			fa.addFlight(nf);
			System.out.println("Added. Press enter to continue.");
			System.in.read();
			AdminMenu.printSelections();;
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
				} else {
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
				} else {
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
				} else {
					System.out.println("Invalid input.");
				}
			} while (econ != -1);
			fa.updateFlight(flight);
			System.out.println("Updated. Press enter to continue.");
			System.in.read();
			selectAction(flight);
		} catch (Exception e) {

		} finally {
			input.close();
		}
	}

}
