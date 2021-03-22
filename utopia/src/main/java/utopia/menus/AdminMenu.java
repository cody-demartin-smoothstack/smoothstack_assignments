package utopia.menus;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import utopia.admin.PassengersAdmin;
import utopia.dao.FlightDAO;
import utopia.entity.Flight;
import utopia.entity.Passenger;
import utopia.jdbc.DefaultConnection;

public class AdminMenu {
	static DefaultConnection def = new DefaultConnection();

	public static void printSelections() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please select the model you wish to control.");
		System.out.println("Enter your selection number (1 - 6) or press 0 to quit.");
		System.out.println("1) Flights");
		System.out.println("2) Passengers");
		System.out.println("3) Aiports");
		System.out.println("4) Customers");
		System.out.println("5) Employees");
		System.out.println("6) Overwrite cancellations");
		
		try {
			Integer selection;
			do {
				selection = input.nextInt();
				if(selection == 1) {
					AdminMenu.flightListAdminMenu();
				}
				else if(selection == 2) {
					
				}
				else if(selection == 3) {
					
				}
				else if(selection == 4) {
					
				}
				else if(selection == 5) {
					
				}
				else if(selection == 6) {
					
				}
				else if (selection != 0) {
					System.out.println("Invalid pick another.");
				}
			} while(selection != 0);
			if (selection == 0) {
				MainMenu.printMain();
			}
		} catch (Exception e) {
			
		}
		finally {
			input.close();
		}
	}

	
	public static void flightListAdminMenu() throws SQLException {
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
					FlightCRUDMenu.selectAction(flights.get(selection - 1));
				} else if (selection != 0) {
					System.out.println("Enter a valid selection please.");
					AdminMenu.flightListAdminMenu();
				}

			} while (selection != 0);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			conn.close();
			input.close();
		}
		
	}
	
	public static void passengerListAdminMenu() throws SQLException {
		Scanner input = new Scanner(System.in);
		PassengersAdmin pa = new PassengersAdmin();
		List<Passenger> passengers = pa.index();
		System.out.print("Please enter the number of the passenger you would like to view (press 0 to go back): ");
		Integer selection;
		do {
			selection = input.nextInt();
			if (selection >= 1 && selection <= passengers.size()) {
				passengers.get(selection - 1);
			}
		} while (selection != 0);
		
	}

}
