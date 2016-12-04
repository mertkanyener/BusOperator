
public class Bus {
	private Route route;
	private String plateNum;
	private int seatCap;
	
	public Bus(Route route, String plateNum, int seatCap){
		this.setRoute(route);
		this.setPlateNum(plateNum);
		this.setSeatCap(seatCap);
	}
	
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public String getPlateNum() {
		return plateNum;
	}
	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}
	public int getSeatCap() {
		return seatCap;
	}
	public void setSeatCap(int seatCap) {
		this.seatCap = seatCap;
	}
	
	public String toString(){
		return "Bus: " + plateNum + "\nSeats: " + seatCap + "\nRoute:\n" + route; 
	}
	
	
	

}
