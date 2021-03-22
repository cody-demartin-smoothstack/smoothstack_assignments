package utopia.menus;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import utilities.FlightUtil;
import utopia.admin.FlightsAdmin;
import utopia.admin.OverrideAdmin;
import utopia.admin.UserAdmin;
import utopia.dao.FlightDAO;
import utopia.entity.Booking;
import utopia.entity.Flight;
import utopia.entity.User;
import utopia.jdbc.DefaultConnection;

public class TravelerMenu {
	static DefaultConnection def = new DefaultConnection();

	public static void mainMenu() {

		Scanner input = new Scanner(System.in);
		UserAdmin ua = new UserAdmin();
		try {
			String username;
			String password;
			do {
				System.out.println("Enter username: ");
				System.out.println("Press 0 to go back");
				username = input.nextLine();
				System.out.println("Enter password: ");
				System.out.println("Press 0 to go back");
				password = input.nextLine();
				User authUser = ua.getUser(username, password);
				if (!authUser.equals(null)) {
					optionsMenu(authUser);
				} else {
					System.out.println("Wrong username/pass try again");
				}

			} while (!username.equals("0") || !password.equals("0"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			input.close();
		}

	}

	public static void optionsMenu(User user) {
		Scanner input = new Scanner(System.in);
		System.out.println("1) Book flight");
		System.out.println("2) Cancel flight");

		try {
			Integer selection;
			do {
				selection = input.nextInt();
				if (selection == 1) {
					printFlightMenu(user);
				} else if (selection == 2) {

				} else if (selection != 0) {
					System.out.println("Invalid selection try again.");
				}

			} while (selection != 0);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			input.close();
		}
	}

	public static void printFlightMenu(User user) throws SQLException {
		Scanner input = new Scanner(System.in);
		Connection conn = null;

		try {
			conn = def.getConnection();
			FlightDAO flightData = new FlightDAO(conn);
			List<Flight> flights = flightData.index(null);
			for (int i = 0; i < flights.size(); i++) {
				System.out.println((i + 1) + ") " + flights.get(i).getRoute().getDestination().getIataId() + ", "
						+ flights.get(i).getRoute().getDestination().getCity() + " ---> "
						+ flights.get(i).getRoute().getOrigin().getIataId() + ", "
						+ flights.get(i).getRoute().getOrigin().getCity());
			}
			System.out.print("Please enter the number of the flight you would like to view (press 0 to go back): ");
			int selection;
			do {
				selection = input.nextInt();
				if (selection >= 1 && selection <= flights.size()) {
					bookFlight(user, flights.get(selection - 1));
				} else if (selection != 0) {
					System.out.println("Enter a valid selection please.");
					printFlightMenu(user);
				}

			} while (selection != 0);
			if (selection == 0) {
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			input.close();
			if (conn != null) {
				conn.close();
			}
		}
	}
	
	static public void bookFlight(User user, Flight flight) throws SQLException {
		Scanner input = new Scanner(System.in);
		FlightsAdmin fa = new FlightsAdmin();
		OverrideAdmin oa = new OverrideAdmin();
		System.out.println("a) Flight info");
		fa.printClassOptions(flight);
		try {
			String selection;
			do {
				selection = input.nextLine();
				if (selection.equals("a")) {
					viewFlight(user, flight);
				}
				else if (selection.equals("f")) {
					Booking book = oa.handleInput("first");
					Booking b = oa.createBooking(book);
//					oa.createBookingUser(b, user.getId());
//					oa.createFlightBooking(flight.getId(), b);
					break;
				}
				else if (selection.equals("b")) {
					Booking book = oa.handleInput("business");
					Booking b = oa.createBooking(book);
//					oa.createBookingUser(b, user.getId());
//					oa.createFlightBooking(flight.getId(), b);
					break;
				}
				else if(selection.equals("e")) {
					Booking book = oa.handleInput("econ");
					oa.createBooking(book);
//					oa.createBookingUser(book, user.getId());
//					oa.createFlightBooking(flight.getId(), book);
					break;
				}
				else if(!selection.equals("0")) {
					System.out.println("invalid selection");
				}
				
			} while (!selection.equals("0"));
			if(selection.equals("0")) {
				printFlightMenu(user);
			}
			
			System.out.println("Flight added. Press enter to go back.");
			System.in.read();
			printFlightMenu(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			input.close();
		}
		
	}
	
	static public void viewFlight(User user, Flight flight) {
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
				bookFlight(user, flight); 
			}
		} catch (Exception e) {

		} finally {
			input.close();
		}
	}

//	byte[] array = new byte[7]; // length is bounded by 7
//    new Random().nextBytes(array);
//    String generatedString = new String(array, Charset.forName("UTF-8"));
}
