
public class Baggage {
	private int baggageNo;
	private float weight;
	
	public Baggage(int baggageNo, float weight){
		this.setBaggageNo(baggageNo);
		this.setWeight(weight);

	}

	public int getBaggageNo() {
		return baggageNo;
	}

	public void setBaggageNo(int baggageNo) {
		this.baggageNo = baggageNo;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	
	public String toString(){
		return "Baggage no: " + this.baggageNo + "\nKg: " + this.weight;
	}

	
	

}
