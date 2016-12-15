
public class Ticket {
	private int ticketNo, seatNo;
	private Bus bus;
	private Passenger passenger;
	private Baggage baggage;
	
	
	public Ticket(int ticketNo, Bus bus, Passenger passenger, int seatNo, Baggage baggage){
		this.setTicketNo(ticketNo);
		this.setBus(bus);
		this.setPassenger(passenger);
		this.setSeatNo(seatNo);
		this.setBaggage(baggage);
	
		
	}
	
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	
	public Baggage getBaggage(){
		return this.baggage;
	}
	public void setBaggage(Baggage baggage){
		this.baggage = baggage;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	public Passenger getPassenger(){
		return passenger;
	}
	
	public void setPassenger(Passenger passenger){
		this.passenger = passenger;
	}
	public String toString(){
		return "Ticket no: " + this.ticketNo + "\nBus: " + this.bus + "\nPassenger information:\nFirst Name: " + this.passenger.getFirstName() +
				"\nLast Name: " + this.passenger.getLastName() + "\nBaggage information:\n" + this.baggage;
	}

	


	
	
	
	

}
