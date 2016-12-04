
public class Baggage {
	private int baggageNo;
	
	public Baggage(int baggageNo){
		this.setBaggageNo(baggageNo);
	}

	public int getBaggageNo() {
		return baggageNo;
	}

	public void setBaggageNo(int baggageNo) {
		this.baggageNo = baggageNo;
	}
	
	public String toString(){
		return "Baggage no: " + this.baggageNo;
	}
	
	
	

}
