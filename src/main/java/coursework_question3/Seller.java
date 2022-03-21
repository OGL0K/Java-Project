package coursework_question3;

public class Seller extends User {

	
	public Seller(String fullname) {
		super(fullname);
		
		if(fullname.matches("([a-z]+[A-Z]+)")) {
			throw new IllegalArgumentException();
	}  
	}
	
	public String toString() {
		return this.getName() + " " + this.getSecondName().charAt(0) +". ()";
	}
	
}
