package utilities;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import utopia.dao.AirportDAO;
import utopia.dao.FlightDAO;
import utopia.dao.RouteDAO;
import utopia.entity.Flight;
import utopia.entity.Route;
import utopia.jdbc.DefaultConnection;
import utopia.menus.EmployeeMenu;

public class FlightUtil {
	static DefaultConnection dfltConn = new DefaultConnection();

	public static void displayInformation(Flight flight) {
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("Viewing flight with ID " + flight.getId() + ", and Departure Airport: "
					+ flight.getRoute().getOrigin().getIataId() + " and Arrival Airport: "
					+ flight.getRoute().getDestination().getIataId());
			System.out.println();
			System.out.println("Departure Airport: " + flight.getRoute().getOrigin().getIataId()
					+ " | Arrival Airport: " + flight.getRoute().getDestination().getIataId());
			System.out.println("Departure Date: " + FlightUtil.toDate(flight.getDepartureTime()) + " | Departure Time: "
					+ FlightUtil.toTime(flight.getDepartureTime()));
			System.out.println("Arrival Date: " + FlightUtil.toDate(flight.getArrivalTime()) + " | Arrival Time: "
					+ FlightUtil.toTime(flight.getArrivalTime()));
			System.out.println();
			System.out.println("Remaining seats by class:");
			System.out.println("First ---> " + FlightUtil.getRemainingFirst(flight));
			System.out.println("Business ---> " + FlightUtil.getRemainingBusiness(flight));
			System.out.println("Economy ---> " + FlightUtil.getRemainingEcon(flight));
			System.out.println("(Enter 0 to return)");
			Integer selection;
			do { 
				selection = input.nextInt();
			} while (selection != 0);
			if (selection == 0) {
				EmployeeMenu.getFlightInfo(flight);
			}
		} catch (Exception e) {

		} finally {
			input.close();
		}

	}

	private static String toDate(Timestamp timestamp) {
		LocalDate date = timestamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
	}

	private static String toTime(Timestamp timestamp) {
		LocalDateTime time = timestamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		return time.format(DateTimeFormatter.ISO_LOCAL_TIME);
	}

	private static Integer getRemainingFirst(Flight flight) {
		return flight.getAirplane().getType().getMaxFirstClass() - flight.getAllowedFirst();
	}

	private static Integer getRemainingEcon(Flight flight) {
		return flight.getAirplane().getType().getMaxEconClass() - flight.getAllowedEcon();
	}

	private static Integer getRemainingBusiness(Flight flight) {
		return flight.getAirplane().getType().getMaxBusinessClass() - flight.getAllowedBusiness();
	}

	public static void beginUpdate(Flight flight) throws SQLException {
		Scanner input = new Scanner(System.in);
		Connection conn = null;

		try {
			conn = dfltConn.getConnection();
			AirportDAO airportSearch = new AirportDAO(conn);
			System.out.println("Viewing flight with ID " + flight.getId() + ", and Departure Airport: "
					+ flight.getRoute().getOrigin().getIataId() + " and Arrival Airport: "
					+ flight.getRoute().getDestination().getIataId());
			System.out.println("Enter quit at anytime to exit.");
			System.out.println();
			System.out.println("Enter new origin code. NA to skip.");
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
			if (newOrigin == "quit")
				FlightUtil.displayInformation(flight);
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
			if (newDestination == "quit")
				FlightUtil.displayInformation(flight);
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
			if (newDepartureInfo == "quit")
				FlightUtil.displayInformation(flight);
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
			if (arrivalInfo == "quit")
				FlightUtil.displayInformation(flight);
			System.out.println(FlightUtil.updateFlight(flight));
			System.out.println("Press enter to return to previous screen.");
			System.in.read();
			EmployeeMenu.getFlightInfo(flight);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
			input.close();
		}
	}

	private static String updateFlight(Flight flight) throws SQLException {
		Connection conn = null;

		try {
			conn = dfltConn.getConnection();
			RouteDAO routeUpdater = new RouteDAO(conn);
			FlightDAO flightUpdater = new FlightDAO(conn);
			Route r = flight.getRoute();
			routeUpdater.updateRoute(r);
			flightUpdater.updateFLightEmployee(flight);
			conn.commit();
			return "Flight updated successfully";
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			return "Unable to update flight.";
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	public static void addSeats(Flight flight) {
		Connection conn = null;
		Scanner input = new Scanner(System.in);

		System.out.println("Pick the class to add seats of.");
		System.out.println("1) First");
		System.out.println("2) Business");
		System.out.println("3) Economy");

		try {
			Integer selection;
			do {
				selection = input.nextInt();
				if (selection == 1) {
					FlightUtil.seatsMenu("first", flight);
				} else if (selection == 2) {
					FlightUtil.seatsMenu("business", flight);
				} else if (selection == 3) {
					FlightUtil.seatsMenu("econ", flight);
				}
			} while (selection != 0);

		} catch (Exception e) {

		} finally {

		}
	}

	private static void seatsMenu(String string, Flight flight) throws SQLException {
		Integer n;
		Scanner input = new Scanner(System.in);
		Connection conn = null;

		if (string.equals("first")) {
			n = FlightUtil.getRemainingFirst(flight);
		} else if (string.equals("business")) {
			n = FlightUtil.getRemainingBusiness(flight);
		} else {
			n = FlightUtil.getRemainingEcon(flight);
		}

		System.out.println("Existing number of seats: " + n);
		System.out.println("New Number of seats: ");
		System.out.println("(Press 0 to go back");
		try {
			conn = dfltConn.getConnection();
			FlightDAO flightUpdater = new FlightDAO(conn);
			Integer selection;
			do {
				selection = input.nextInt();
				if (string.equals("first") && selection <= FlightUtil.getRemainingFirst(flight)) {
					flight.setAllowedFirst(flight.getAllowedFirst() + n);
					flightUpdater.updateSeatCountFirst(flight);
					break;
				} else if (string.equals("business") && selection <= FlightUtil.getRemainingBusiness(flight)) {
					flight.setAllowedBusiness(flight.getAllowedBusiness() + n);
					flightUpdater.updateSeatCountBusiness(flight);
					break;
				} else if (string.equals("econ") && selection <= FlightUtil.getRemainingEcon(flight)) {
					flight.setAllowedEcon(flight.getAllowedEcon() + n);
					flightUpdater.updateSeatCountEcon(flight);
					break;
				} else if (selection != 0) {
					System.out.println("Invalid entry. Not enough space.");
				}
			} while (selection != 0);
			conn.commit();
			EmployeeMenu.getFlightInfo(flight);
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			input.close();
			conn.close();
		}

	}
}
