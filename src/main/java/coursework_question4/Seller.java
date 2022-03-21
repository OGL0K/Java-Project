package coursework_question4;

public class Seller extends User {

	private int sales;
	
	public Seller(String fullname) {
		super(fullname);
		
		if(fullname.matches("([a-z]+[A-Z]+)")) {
			throw new IllegalArgumentException();
	}  
	}
	
	public String toString() {
		return this.getName() + " " + this.getSecondName().charAt(0) +". (Sales: " + this.sales + ", " + "Rating: " + this.identifyRating() + ")";
	} 
	
	public String identifyRating() {
		String a = "";
		
		if(this.sales == 0) {
			a = "Level 0";
		}
		
		if(this.sales >= 1 && this.sales <= 5) {
			a = "Level 1";
		}
		
		if(this.sales >= 6 && this.sales <= 10) {
			a = "Level 2";		
		}
		
		if(this.sales > 10) {
			a = "Level 3";
		}
		
		return a;
	}

	public int getSales() {
		return sales;
	}
}
