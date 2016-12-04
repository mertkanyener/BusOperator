
public class Schedule {
	private Time depTime, arrTime;
	
	public Schedule(Time depTime, Time arrTime){
		this.setDepTime(depTime);
		this.setArrTime(arrTime);
	}

	public Time getDepTime() {
		return depTime;
	}

	public void setDepTime(Time depTime) {
		this.depTime = depTime;
	}

	public Time getArrTime() {
		return arrTime;
	}

	public void setArrTime(Time arrTime) {
		this.arrTime = arrTime;
	}
	
	public String toString(){
		return "Departure time: " + depTime + "\nArrival time: " + arrTime;
	}
	

}
