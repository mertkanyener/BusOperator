

public class Operator {
	
	private Bus[] allBuses = new Bus[10];
	private Passenger[] allPassengers;
	private Ticket[] allTickets = new Ticket[1000];
	private int busCounter = 0;
	private int ticketNoCounter = 1000;
	private int baggageNoCounter = 100;
	private int ticketCounter = 0;
	
	
	
	public void addBus(String plateNum, String depHour, String depMinute, String arrHour, String arrMinute, String depStation, String depCity,
			String arrStation, String arrCity, int seatCap, double baggageWeightCap){
			
			Time depTime = new Time(depHour, depMinute);
			Time arrTime = new Time(arrHour, arrMinute);
			Schedule schedule = new Schedule(depTime, arrTime);
			Route route = new Route(depStation, depCity, arrStation, arrCity, schedule);
			Passenger[] passengers = new Passenger[seatCap];
			Bus newBus = new Bus(route, plateNum, passengers, baggageWeightCap);
			allBuses[busCounter] = newBus;
			busCounter += 1;
	}
	
	public void addTicket(Bus bus, int seatNo, String firstName, String lastName, char gender, double weight){
		
		Passenger passenger = new Passenger(firstName, lastName, gender);
		Baggage baggage = new Baggage(baggageNoCounter, weight);
		Ticket ticket = new Ticket(ticketNoCounter, bus, passenger, seatNo, baggage);
		allTickets[ticketCounter] = ticket;
		Passenger[] p = bus.getPassengers();
		p[seatNo - 1] = passenger;
	
		
		baggageNoCounter += 1;
		ticketNoCounter += 1;
		ticketCounter += 1;
	
	}
	
	public void exchangeTicket(Ticket t1, Ticket t2){
		
		Bus b1 = t2.getBus();
		Bus b2 = t1.getBus();
		Passenger p1 = t2.getPassenger();
		Passenger p2 = t1.getPassenger();
		Baggage bag1 = t2.getBaggage();
		Baggage bag2 = t1.getBaggage();
	
		
		t1.setBus(b1);
		t1.setPassenger(p1);
		t1.setBaggage(bag1);
		t1.getBus().getPassengers()[t1.getSeatNo() - 1] = p1;
		
		t2.setBus(b2);
		t2.setPassenger(p2);
		t2.setBaggage(bag2);
		t2.getBus().getPassengers()[t2.getSeatNo() - 1] = p2;
		
		
		
	}
	
	public Ticket getTicket(int ticketNo){
		Ticket t = null;
		for(int i = 0; i < allTickets.length; i++){
			if(allTickets[i].getTicketNo() == ticketNo){
				t = allTickets[i];
				break;
			}
		}
		return t;
	}
	
	public String removeTicket(int ticketNo){
		String result = null;
		for(int i = 0; i < allTickets.length; i++){
			if(allTickets[i].getTicketNo() == ticketNo){
				allTickets[i].getBus().getPassengers()[allTickets[i].getSeatNo() - 1] = null;
				allTickets[i] = null;
				result = "Success";
				break;
			}
			else{
				result = "Fail";
			}
		}
		return result;
	}
	
	
	
	//Returns the gender of the passenger adjacent to the t1's owner
	public char getAdjacentGender(Ticket t1){
		Passenger[] p1 = t1.getBus().getPassengers();
		
		if((t1.getTicketNo() % 2) == 0){
			return p1[t1.getSeatNo() - 2].getGender();
		}
		else{
			return p1[t1.getSeatNo()].getGender();
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
