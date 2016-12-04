
public class Time {
	private String hour, minute;
	
	public Time(String hour, String minute){
		this.setHour(hour);
		this.setMinute(minute);
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}
	
	public String toString(){
		return hour + ":" + minute;
	}
	

}
