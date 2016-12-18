
public class Baggage {
	private int baggageNo;
	private double weight;
	
	public Baggage(int baggageNo, double weight){
		this.setBaggageNo(baggageNo);
		this.setWeight(weight);

	}

	public int getBaggageNo() {
		return baggageNo;
	}

	public void setBaggageNo(int baggageNo) {
		this.baggageNo = baggageNo;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	public String toString(){
		return "Baggage no: " + this.baggageNo + "\nKg: " + this.weight;
	}

	
	

}
