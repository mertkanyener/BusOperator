
public class Passenger {
	private String firstName, lastName;
	private char gender;
	private Ticket ticket;
	private Baggage baggage;
	
	public Passenger(String firstName, String lastName, char gender, Ticket ticket, Baggage baggage){
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setGender(gender);
		this.setTicket(ticket);
		this.setBaggage(baggage);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public Baggage getBaggage() {
		return baggage;
	}
	public void setBaggage(Baggage baggage) {
		this.baggage = baggage;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public String toString(){
		return "Name: " + this.firstName + " " + this.lastName + "\nSex: " + this.gender + "\nTicket: " + this.ticket + "\nBaggage: " + this.baggage;
	}
	
	
	

}
