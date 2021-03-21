package utopia.menus;

import java.util.List;
import java.util.Scanner;

import utopia.dao.FlightDAO;
import utopia.entity.Flight;
import utopia.jdbc.DefaultConnection;

public class EmployeeMenu {

	public static void printMain() {
		System.out.println("1) Enter flight management system");
		System.out.println("Press 0 to go back.");
		Scanner input = new Scanner(System.in);

		try {
			int selection;

			do {
				selection = input.nextInt();
				if (selection == 1) {
					EmployeeMenu.printFlightList();
				} else if (selection != 0) {
					System.out.println("Enter a valid selection.");
					EmployeeMenu.printMain();
				}
			} while (selection != 0);

			if (selection == 0) {
				MainMenu.printMain();
			}
		}

		catch (Exception e) {

		} finally {
			input.close();
		}
	}

	public static void printFlightList() {
		Scanner input = new Scanner(System.in);

		try {
			FlightDAO flightData = new FlightDAO(DefaultConnection.getConnection());
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
					EmployeeMenu.getFlightInfo(flights.get(selection - 1));
				} else if (selection != 0) {
					System.out.println("Enter a valid selection please.");
					EmployeeMenu.printFlightList();
				}

			} while (selection != 0);
			if (selection == 0) {
				EmployeeMenu.printMain();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			input.close();
		}
	}

	public static void getFlightInfo(Flight flight) {
		Scanner input = new Scanner(System.in);

		try {
			System.out.println("1) View more details");
			System.out.println("2) Update flight details");
			System.out.println("3) Add seats to flight");
			System.out.println("Enter 0 to go back");
			Integer selection;
			do {
				selection = input.nextInt();
			} while (selection != 0);
			if (selection == 0) {
				EmployeeMenu.printFlightList();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			input.close();
		}
	}
}
