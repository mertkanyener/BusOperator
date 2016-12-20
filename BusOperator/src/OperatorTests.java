import static org.junit.Assert.*;

import org.junit.Test;

public class OperatorTests {

	@Test
	public void testAddBus() {
		Operator o = new Operator();
		o.addBus("34 HG 4678", "20", "30", "01", "45", "City A Main Station", "City A", "City B Main Station", "City B", 36, 40);
		assertEquals("34 HG 4678", o.getAllBuses()[0].getPlateNum());
		o.addBus("34 ABC 12", "15", "30", "00", "15", "City A Main Station", "City B" , "City C Main Station", "City C", 40, 45);
		assertEquals("34 ABC 12", o.getAllBuses()[1].getPlateNum());
	}

	@Test
	public void testAddTicket() {
		Operator o = new Operator();
		o.addBus("34 HG 4678", "20", "30", "01", "45", "City A Main Station", "City A", "City B Main Station", "City B", 36, 40);
		o.addTicket(o.getAllBuses()[0], 12, "John", "Smith", 'M', 32.4);
		assertEquals("John", o.getAllTickets()[0].getPassenger().getFirstName());
		assertEquals("Smith", o.getAllTickets()[0].getPassenger().getLastName());
		assertEquals(1000, o.getAllTickets()[0].getTicketNo());
	}

	@Test
	public void testExchangeTicket() {
		Operator o = new Operator();
		Time t1 = new Time("20", "30");
		Time t2 = new Time("01", "45");
		Time t3 = new Time("15", "30");
		Time t4 = new Time("00", "15");
		Schedule s1 = new Schedule(t1, t2);
		Schedule s2 = new Schedule(t3, t4);
		Route r1 = new Route("City A Main Station", "City A", "City B Main Station", "City B", s1);
		Route r2 = new Route("City A Main Station", "City B" , "City C Main Station", "City C", s2);
		Passenger[] p1 = new Passenger[36];
		Passenger[] p2 = new Passenger[40];
		Bus b1 = new Bus(r1, "34 HG 4678", p1, 40);
		Bus b2 = new Bus(r2, "34 ABC 12", p2, 45);
		Passenger pas1 = new Passenger("Mertkan", "Yener", 'M');
		Passenger pas2 = new Passenger("Alpay", "Özilban", 'M');
		Baggage bag1 = new Baggage(567, 24.2);
		Baggage bag2 = new Baggage(789, 32.4);
		Ticket ticket1 = new Ticket(1234, b1, pas1, 12, bag1);
		Ticket ticket2 = new Ticket(2345, b2, pas2, 23, bag2);
		
		o.exchangeTicket(ticket1, ticket2);
		//assertEquals("34 HG 4678", ticket2.getBus().getPlateNum());
		assertEquals("Alpay", ticket1.getPassenger().getFirstName());
		assertEquals("Özilban", ticket1.getPassenger().getLastName());
		assertEquals("Mertkan", ticket2.getPassenger().getFirstName());
		
		
		
	}

	@Test
	public void testGetTicket() {
		Operator o = new Operator();
		o.addBus("34 HG 4678", "20", "30", "01", "45", "City A Main Station", "City A", "City B Main Station", "City B", 36, 40);
		o.addTicket(o.getAllBuses()[0], 12, "John", "Smith", 'M', 32.4);
		Ticket t1 = o.getTicket(1000);
		assertEquals(t1, o.getAllTickets()[0]);
	}

	@Test
	public void testRemoveTicket() {
		Operator o = new Operator();
		o.addBus("34 HG 4678", "20", "30", "01", "45", "City A Main Station", "City A", "City B Main Station", "City B", 36, 40);
		o.addTicket(o.getAllBuses()[0], 12, "John", "Smith", 'M', 32.4);
		Bus b = o.getAllBuses()[0];
		o.removeTicket(1000);
		assertEquals(null, o.getAllTickets()[0]);
		assertEquals(null, b.getPassengers()[11]);
	}
	
	@Test
	public void testFindBus(){
		Operator o = new Operator();
		o.addBus("34 HG 4678", "20", "30", "01", "45", "City A Main Station", "City A", "City B Main Station", "City B", 36, 40);
		o.addBus("34 ABC 12", "15", "30", "00", "15", "City A Main Station", "City B" , "City C Main Station", "City C", 40, 45);
		Bus b = o.findBus("34 ABC 12");
		assertEquals(b, o.getAllBuses()[1]);
		
	}
	
	@Test
	public void testCheckSeat(){
		Operator o = new Operator();
		o.addBus("34 HG 4678", "20", "30", "01", "45", "City A Main Station", "City A", "City B Main Station", "City B", 36, 40);
		o.addTicket(o.getAllBuses()[0], 12, "John", "Smith", 'M', 32.4);
		boolean b1 = o.checkSeat(o.getAllBuses()[0], 12);
		boolean b2 = o.checkSeat(o.getAllBuses()[0], 11);
		assertEquals(false, b1);
		assertEquals(true, b2);
		
	}

}
