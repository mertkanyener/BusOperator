
public class Ticket {
	private int ticketNo;
	private Passenger passenger;
	private Seat seat;
	private Baggage baggage;
	
	public Ticket(int ticketNo, Passenger passenger , Seat seat, Baggage baggage){
		this.setTicketNo(ticketNo);
		this.setPassenger(passenger);
		this.setSeat(seat);
		this.setBaggage(baggage);
	}
	
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public Baggage getBaggage(){
		return this.baggage;
	}
	public void setBaggage(Baggage baggage){
		this.baggage = baggage;
	}
	public Passenger getPassenger(){
		return passenger;
	}
	public void setPassenger(Passenger passenger){
		this.passenger = passenger;
	}
	
	public String toString(){
		return "Ticket no: " + this.ticketNo + "\n:Owner First Name: " + this.passenger.getFirstName() + "\nOwner Last Name: " + this.passenger.getLastName() + "\nSeat: " + this.seat; 
	}
	
	
	

}
