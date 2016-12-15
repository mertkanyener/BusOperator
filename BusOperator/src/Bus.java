

public class Bus {
	
	private Route route;
	private String plateNum;
	private Passenger[] passengers;
	private float baggageWeightCap;
	
	public Bus(Route route, String plateNum, Passenger[] passengers, float baggageWeightCap){
		this.setRoute(route);
		this.setPlateNum(plateNum);
		this.setPassengers(passengers);
		this.setBaggageWeightCap(baggageWeightCap);
	
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
	public Passenger[] getPassengers() {
		return passengers;
	}

	public void setPassengers(Passenger[] passengers) {
		this.passengers = passengers;
	}

	public float getBaggageWeightCap() {
		return baggageWeightCap;
	}

	public void setBaggageWeightCap(float baggageWeightCap) {
		this.baggageWeightCap = baggageWeightCap;
	}

	public String toString(){
		return "Plate: " + this.plateNum + "\nRoute: " + this.route;
	}



	


	
	

}
