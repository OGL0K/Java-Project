package coursework_question4;

import java.text.DecimalFormat;

public class Car {
	
	private int id;
	private String name;
	private String colour;
	private double price;
	private CarType gearbox;
	private CarBody body;
	private int numberOfSeats;
	private Condition condition;
	private SaleType type;
	
	
	public Car(int id, String name, double price, Condition condition, SaleType type) {
		super();
		
		
		if(id < 0) {
			throw new IllegalArgumentException();
		}
		
		if(name == null) {
			throw new IllegalArgumentException();
		}
		
		if(price < 0) {
			throw new IllegalArgumentException();
		}
		
		
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.condition = condition;
		this.type = type;
	}


	public int getID() {
		return id;
	}


	public String getName() {
		return name;
	}


	public double getPrice() {
		return price;
	}
	
	public String getColour() {
		return colour;
	}


	public CarType getGearbox() {
		return gearbox;
	}


	public CarBody getBodyStyle() {
		return body;
	}


	public int getNumberOfSeats() {
		return numberOfSeats;
	}


	public Condition getCondition() {
		return condition;
	}

	public SaleType getType() {
		return type;
	}
	
	public void setColour(String colour) {
		this.colour = colour;
	}


	public void setGearbox(CarType gearbox) {
		this.gearbox = gearbox;
	}


	public void setBody(CarBody body) {
		this.body = body;
	}


	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}


	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	
	public String displayCarSpecification() {
		DecimalFormat style1 = new DecimalFormat("0.00");
		
		String a = this.id  + " - " + this.name + " (£" + style1.format(this.price) + ")\n" 
				+ "	 Type: " + this.gearbox + "\n" + "	 Style: " + this.body + "\n" + "	 Colour: " + this.colour
				+ "\n" + "	 No. of Seats: " + this.numberOfSeats + "\n" + "	 Condition: " + this.condition;
		
		return a;
	}
	
	public String toString() {
		
		return this.id  + " - " + this.name;
	}
	
	
	
}
