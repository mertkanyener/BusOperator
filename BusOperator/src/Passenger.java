
public class Passenger {
	private String firstName, lastName;
	private char gender;
	
	public Passenger(String firstName, String lastName, char gender){
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setGender(gender);
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String toString(){
		return "Name: " + this.firstName + " " + this.lastName + "\nSex: " + this.gender;
	}
	
	
	

}
