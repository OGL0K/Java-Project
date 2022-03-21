package coursework_question1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Advert {

	private Car car;
	private List<Offer> offers;

	public Advert(Car car) {
		super();
		this.car = car;
		this.offers = new ArrayList<Offer>();
		
		if(car  == null) {
			throw new IllegalArgumentException();
		}
	}
	
	public Offer getHighestOffer() {
		Offer highest = null;
		double a = 0;
		for(int i = 0; i < offers.size(); i++) {
			if(a < offers.get(i).getValue()) {
				a = offers.get(i).getValue();
				highest = this.offers.get(i);			
	}
			if(offers.get(i) == null) {continue;}
			
}
	return highest;
}

	public boolean placeOffer(User buyer, double value) {

		Offer offer = new Offer(buyer, value);
		this.offers.add(offer);
	
		if(value >= this.car.getPrice()) {
			return true;
		}
	
		else {
			return false;
		}
		
}
	
	
	
	public String toString() {
		DecimalFormat style1 = new DecimalFormat("0.00");
		return "Ad: \n	 " + this.car.getID()  + " - " + this.car.getName() + " (£" + style1.format(this.car.getPrice()) + ")\n" 
				+ "	 Type: " + this.car.getGearbox() + "\n" + "	 Style: " + this.car.getBodyStyle() + "\n" + "	 Colour: " + this.car.getColour()
				+ "\n" + "	 No. of Seats: " + this.car.getNumberOfSeats() + "\n" + "	 Condition: " + this.car.getCondition();
	}

	public Car getCar() {
		return car;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	
	
}
