/**
 * 
 */
package utopia.menus;

import java.util.Scanner;

/**
 * @author codydemartin
 *
 */
public class MainMenu {

	/**
	 * @param args
	 */
	public static void printMain() {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Utopia Airlines management system. What category of user are you?");
		System.out.println("Enter your selection number (1 - 3) or press 0 to quit.");
		System.out.println("1) Employee");
		System.out.println("2) Customer");
		System.out.println("3) Admin");

		try {
			int answer;
			do {
				answer = input.nextInt();
				if (answer == 1) {
					System.out.print("\033[H\033[2J");
					System.out.flush();
					EmployeeMenu.printMain();
				} else if (answer == 2) {
					TravelerMenu.mainMenu();
				} else if (answer == 3) {
					AdminMenu.printSelections();
				} else if (answer != 0) {
					System.out.println("Please enter a valid selection.");
					MainMenu.printMain();
				}
			} while (answer != 0);

			if (answer == 0) {
				System.out.print("\033[H\033[2J");
				System.out.flush();
				System.exit(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			input.close();
		}

	}

}
