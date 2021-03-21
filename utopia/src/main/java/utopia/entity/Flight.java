/**
 * 
 */
package utopia.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author codydemartin
 *
 */
public class Flight {
	private int id;
	private Route route;
	private Airplane airplane;
	private Timestamp departureTime;
	private int reservedSeats;
	private float seatPrice;
	private Timestamp arrivalTime;

	public Timestamp getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Timestamp arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getId() {
		return id;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public Timestamp getDepartureTime() {
		return departureTime;
	}

	public int getReservedSeats() {
		return reservedSeats;
	}

	public float getSeatPrice() {
		return seatPrice;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDepartureTime(Timestamp date) {
		this.departureTime = date;
	}

	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	public void setSeatPrice(float seatPrice) {
		this.seatPrice = seatPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
