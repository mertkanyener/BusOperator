
public class Route {
	private String depStation, depCity, arrStation, arrCity;
	private Schedule schedule;
	
	public Route(String depStation, String depCity, String arrStation, String arrCity, Schedule schedule){
		this.setDepStation(depStation);
		this.setDepCity(depCity);
		this.setArrStation(arrStation);
		this.setArrCity(arrCity);
		this.setSchedule(schedule);
	}

	public String getDepStation() {
		return depStation;
	}

	public void setDepStation(String depStation) {
		this.depStation = depStation;
	}

	public String getDepCity() {
		return depCity;
	}

	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}

	public String getArrStation() {
		return arrStation;
	}

	public void setArrStation(String arrStation) {
		this.arrStation = arrStation;
	}

	public String getArrCity() {
		return arrCity;
	}

	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	public String toString(){
		return "Departure station: " + depStation + "\nDeparture city: " + depCity + "\nArrival Station: " + arrStation
				+ "\nArrival city: " + arrCity + "\nSchedule:\n" + schedule;
	}
	

}
