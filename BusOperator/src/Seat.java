
public class Seat {
	private int seatNo;
	private Bus bus;
	private String status;
	
	public Seat(int seatNo, Bus bus, String status){
		this.setSeatNo(seatNo);
		this.setBus(bus);
		this.setStatus(status);
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String toString(){
		return "Seat no: " + this.seatNo + "\nBus: " + this.bus + "\nStatus: " + this.status;
	}
	
	

}
