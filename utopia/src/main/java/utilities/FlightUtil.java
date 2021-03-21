package utilities;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import utopia.entity.Flight;

public class FlightUtil {

	public static void displayInformation(Flight flight) {
		System.out.println("Viewing flight with ID " + flight.getId() + ", and Departure Airport: "
				+ flight.getRoute().getOrigin().getIataId() + " and Arrival Airport: "
				+ flight.getRoute().getDestination().getIataId());
		System.out.println();
		System.out.println("Departure Airport: " + flight.getRoute().getOrigin().getIataId() + " | Arrival Airport: "
				+ flight.getRoute().getDestination().getIataId());
		System.out.println("Departure Date: " + FlightUtil.toDate(flight.getDepartureTime()) + " | Departure Time: " +
				FlightUtil.toTime(flight.getDepartureTime()));
	}

	private static String toDate(Timestamp timestamp) {
		LocalDate date = timestamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
	}
	
	private static String toTime(Timestamp timestamp) {
		LocalDateTime time = timestamp.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		return time.format(DateTimeFormatter.ISO_LOCAL_TIME);
	}
	
}
