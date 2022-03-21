package coursework_question1;

public class User {

	private String fullname;

	
	public User(String fullname) {
		super();
		if(fullname.matches("([a-z]+)")) {
			throw new IllegalArgumentException();
	}  
		else {
			this.fullname = fullname;
	}
		
		this.fullname = fullname;
	}
	
	
	public String getName() {
		return fullname.split(" ")[0];
	}
	
	public String toString() {
		return fullname;
	}
}
