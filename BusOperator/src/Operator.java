

public class Operator {
	
	private Bus[] allBuses = new Bus[10];
	private Passenger[] allPassengers;
	private Ticket[] allTickets = new Ticket[1000];
	private int busCounter = 0;
	private int ticketNoCounter = 1000;
	private int baggageNoCounter = 100;
	
	
	
	public void addBus(String plateNum, String depHour, String depMinute, String arrHour, String arrMinute, String depStation, String depCity,
			String arrStation, String arrCity, int seatCap, float baggageWeightCap){
			
			Time depTime = new Time(depHour, depMinute);
			Time arrTime = new Time(arrHour, arrMinute);
			Schedule schedule = new Schedule(depTime, arrTime);
			Route route = new Route(depStation, depCity, arrStation, arrCity, schedule);
			Passenger[] passengers = new Passenger[seatCap];
			Bus newBus = new Bus(route, plateNum, passengers, baggageWeightCap);
			allBuses[busCounter] = newBus;
			busCounter += 1;
	}
	
	public String addTicket(Bus bus, int seatNo, String firstName, String lastName, char gender, float weight){
		
		if(gender != 'M' || gender != 'F'){
			return "Gender";
		}
		else if((seatNo - 1) > bus.getPassengers().length || seatNo < 1 ){
			return "Seat Number";
		}
		else if(weight > bus.getBaggageWeightCap()){
			return "Weight";
		}
		else{
			
			Passenger passenger = new Passenger(firstName, lastName, gender);
			Baggage baggage = new Baggage(baggageNoCounter, weight);
			Ticket ticket = new Ticket(ticketNoCounter, bus, passenger, seatNo, baggage);
			allTickets[ticketNoCounter] = ticket;
			Passenger[] p = bus.getPassengers();
			p[seatNo - 1] = passenger;
		
			baggageNoCounter += 1;
			ticketNoCounter += 1;
			
			return "Success";
		}
		
	}
	
	public String exchangeTicket(Ticket t1, Ticket t2){
		
		if(t1.getBaggage().getWeight() > t2.getBus().getBaggageWeightCap() || t2.getBaggage().getWeight() > t1.getBus().getBaggageWeightCap()){
			return "Weight";
		}
		else if(t1.getPassenger().getGender() != getAdjacentGender(t2) || t2.getPassenger().getGender() != getAdjacentGender(t1)){
			return "Gender";
		}
		else{
			Ticket temp1 = t1;
			
			t1.setSeatNo(t2.getSeatNo());
			t1.setBus(t2.getBus());
			t1.setPassenger(t2.getPassenger());
			t1.setBaggage(t2.getBaggage());
			Passenger[] p1 = t1.getBus().getPassengers();
			p1[t1.getSeatNo() - 1] = t1.getPassenger();
			
			t2.setSeatNo(temp1.getSeatNo());
			t2.setBus(temp1.getBus());
			t2.setPassenger(temp1.getPassenger());
			t2.setBaggage(temp1.getBaggage());
			Passenger[] p2 = t2.getBus().getPassengers();
			p2[t2.getSeatNo() - 1] = t2.getPassenger();
			
			return "Success";
			
		}
		
		
		
	}
	
	public char getAdjacentGender(Ticket t1){
		Passenger[] p1 = t1.getBus().getPassengers();
		
		if((t1.getTicketNo() % 2) == 0){
			return p1[t1.getTicketNo() - 1].getGender();
		}
		else{
			return p1[t1.getTicketNo() + 1].getGender();
		}
		
	}
	
	
	
	public Bus[] getAllBuses() {
		return allBuses;
	}
	public void setAllBuses(Bus[] allBuses) {
		this.allBuses = allBuses;
	}
	public Passenger[] getAllPassengers() {
		return allPassengers;
	}
	public void setAllPassengers(Passenger[] allPassengers) {
		this.allPassengers = allPassengers;
	}
	public Ticket[] getAllTickets() {
		return allTickets;
	}
	public void setAllTickets(Ticket[] allTickets) {
		this.allTickets = allTickets;
	}


	public int getBusCounter() {
		return busCounter;
	}


	public void setBusCounter(int busCounter) {
		this.busCounter = busCounter;
	}


	public int getTicketNoCounter() {
		return ticketNoCounter;
	}


	public void setTicketNoCounter(int ticketNoCounter) {
		this.ticketNoCounter = ticketNoCounter;
	}


	public int getBaggageNoCounter() {
		return baggageNoCounter;
	}


	public void setBaggageNoCounter(int baggageNoCounter) {
		this.baggageNoCounter = baggageNoCounter;
	}
	
	

}
