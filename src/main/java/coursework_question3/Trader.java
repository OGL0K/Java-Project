package coursework_question3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trader extends Dealership {


	protected String name;
	protected Map<Advert , User> carForSale = new HashMap<Advert , User>();
	protected Map<Advert , User> soldCars = new HashMap<Advert , User>();
	protected Map<Advert , User> unsoldCars = new HashMap<Advert , User>();
	private List<Seller> sellers;
	
	public Trader(String name) {
		super(name);
		this.sellers = new ArrayList<Seller>();
	}
	
	private boolean checkExistence(Car car) {
		if(car != null) {return true;}
		
		else {return false;}
	}
	
	public String displayStatistics() {
		
		return "Statistics";
		
	}
	
	
	 public String displaySoldCars() {
		StringBuilder a = new StringBuilder();
		a.append("SOLD CARS:\n");
		for (Map.Entry<Advert, User> key : this.soldCars.entrySet()) {
				a.append(key.getKey().getCar().getID());
				a.append(" - Purchased by ");
				a.append(key.getValue().getName().charAt(0));
				a.append("***");
				a.append(key.getValue().getName().charAt(key.getValue().getName().length() -1));
				a.append(" with a successful £");
				a.append(key.getKey().getHighestOffer().getValue());
				a.append("0 bid. \n");
				
				
		}
		
		return a.toString();
	}	


		
		
		
	
	
	public String displayUnsoldCars() {
		StringBuilder a = new StringBuilder();
		a.append("UNSOLD CARS:\n");
		for(Advert values : this.unsoldCars.keySet()) {
			if(values.getHighestOffer().getValue() > values.getCar().getPrice()) {break;}
			if(values.getHighestOffer().getValue() < values.getCar().getPrice()) {break;}
			a.append("Ad: ");
			a.append(values.getCar().displayCarSpecification());
		}
		
		return a.toString();
	}
	
	
	public void endSale(Advert advert) {
		
		if(advert == null) {
			throw new IllegalArgumentException();
		}
		
		
		if(advert.getCar().getPrice() < advert.getHighestOffer().getValue()) {
			this.soldCars.remove(advert);
			this.unsoldCars.remove(advert);
		}
	}
	
	public boolean placeOffer(Advert carAdvert , User user , double value) {
		

		if(carAdvert == null && user == null) {throw new IllegalArgumentException();}
		
		else {
			
			if(this.checkExistence(carAdvert.getCar())) {
				carAdvert.placeOffer(user, value);
		if(carAdvert.getHighestOffer().getValue() >= carAdvert.getCar().getPrice() ) {
				this.soldCars.put(carAdvert, user);
				this.unsoldCars.put(carAdvert, user);
				    return true;
		}
			return false;
		}		
		}
		
			return false;
		}
 
	
	
		 

	 public void registerCar(Advert carAdvert , User user, String colour, CarType type, CarBody body, int noOfSeats) {
		
		if(carAdvert == null || user == null) {throw new IllegalArgumentException();}
		
		carAdvert.getCar().setColour(colour);
		carAdvert.getCar().setGearbox(type);
		carAdvert.getCar().setBody(body);
		carAdvert.getCar().setNumberOfSeats(noOfSeats);
		carForSale.put(carAdvert, user);
		
		
		
	}
	
}
