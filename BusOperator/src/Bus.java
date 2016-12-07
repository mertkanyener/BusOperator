
public class Bus {
	private Route route;
	private String plateNum;
	private int[] seats;
	public Bus(Route route, String plateNum, int[] seats){
		this.setRoute(route);
		this.setPlateNum(plateNum);
		this.setSeats(seats);
	 
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
	
	public int[] getSeats() {
		return seats;
	}

	public void setSeats(int[] seats) {
		this.seats = seats;
	}
	
	public String toString(){
		return "Bus: " + plateNum + "\nSeats: " + seats.length + "\nRoute:\n" + route; 
	}
	
	
	

}
