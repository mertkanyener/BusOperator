
public class Ticket {
	private int ticketNo;
	private Seat seat;
	
	public Ticket(int ticketNo, Seat seat){
		this.setTicketNo(ticketNo);
		this.setSeat(seat);
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
	
	public String toString(){
		return "Ticket no: " + this.ticketNo + "\nSeat: " + this.seat; 
	}
	
	
	

}
