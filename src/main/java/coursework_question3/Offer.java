package coursework_question3;

public class Offer {

	private double value;
	private User buyer;
	
	public Offer(User buyer, double value ) {
		super();
		
		if(buyer == null) {
			throw new IllegalArgumentException();
		}
		
		if(value < 0) {
			throw new IllegalArgumentException();
		}
		
		this.value = value;
		this.buyer = buyer;
	}


	public User getBuyer() {
		return (Buyer) buyer;
	}


	public double getValue() {
		return value;
	}
	
	public String toString() {
		
		return this.buyer.toString() + " offered " + "£"  + this.value; 
	}
	
	
}
