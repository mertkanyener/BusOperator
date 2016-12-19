

public class Operator {
	
	private Bus[] allBuses = new Bus[30];
	private Passenger[] allPassengers;
	private Ticket[] allTickets = new Ticket[1000];
	private int busCounter = 0;
	private int ticketNoCounter = 1000;
	private int baggageNoCounter = 100;
	private int ticketCounter = 0;
	
	
	
	public void addBus(String plateNum, String depHour, String depMinute, String arrHour, String arrMinute, String depStation, String depCity,
			String arrStation, String arrCity, int seatCap, int baggageWeightCap){
			
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
	
	public boolean checkSeat(Bus b, int n){
		if(!b.getPassengers()[n - 1].equals(null)){
			return false;
		}
		else{
			return true;
		}
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
	
	public void removeTicket(int ticketNo){
		for(int i = 0; i < allTickets.length; i++){
			if(allTickets[i].getTicketNo() == ticketNo){
				allTickets[i].getBus().getPassengers()[allTickets[i].getSeatNo() - 1] = null;
				Ticket[] copy = new Ticket[allTickets.length - 1];
				System.arraycopy(allTickets, 0, copy, 0, i);
				System.arraycopy(allTickets, i+1, copy, i, allTickets.length-i-1);
				allTickets = copy;
				ticketCounter -= 1;
				break;
			}
		}
		
			
	}
	
	
	
	
	
	public Bus findBus(String plateNo){
		Bus b = null;
		for(int i = 0; i < busCounter; i++){
			if(allBuses[i].getPlateNum().equals(plateNo)){
				b = allBuses[i];
			}
		}
		return b;
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
	
	public int getTicketCounter(){
		return ticketCounter;
	}
	
	public void setTicketCounter(int ticketCounter){
		this.ticketCounter = ticketCounter;
	}

}
