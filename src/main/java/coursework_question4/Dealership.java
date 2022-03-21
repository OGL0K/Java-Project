package coursework_question4;

import java.util.HashMap;
import java.util.Map;

public class Dealership {

	
	protected String name;
	protected Map<Advert , Seller> carForSale = new HashMap<Advert , Seller>();
	protected Map<Advert , Buyer> soldCars = new HashMap<Advert , Buyer>();
	protected Map<Advert , Seller> unsoldCars = new HashMap<Advert , Seller>();

	
	
	public Dealership(String name) {
		super();
		this.name = name;
	}
	
	
	
	private boolean checkExistence(Car car) {
		if(car != null) {return true;}
		
		else {return false;}
	} 

		
	public String displaySoldCars() {
			StringBuilder a = new StringBuilder();
			a.append("SOLD CARS:\n");
			for (Map.Entry<Advert, Buyer> key : this.soldCars.entrySet()) {
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
				a.append("Ad: ");
				a.append(values.getCar().displayCarSpecification());
				a.append("\n");
			}
			
			return a.toString();
		}
		
		public String displayStatistics() {
			
			return "Statistics";
			
		}
		
	
		public boolean placeOffer(Advert carAdvert , User user , double value) {
		
		if(carAdvert == null && user == null) {throw new IllegalArgumentException();}
		
		else {
			
			if(this.checkExistence(carAdvert.getCar())) {
				carAdvert.placeOffer(user, value);
		if(carAdvert.getHighestOffer().getValue() >= carAdvert.getCar().getPrice() ) {
				this.unsoldCars.put(carAdvert, (Seller) user);
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
		carForSale.put(carAdvert, (Seller) user);
		
		
		
	}
	
	
	
	

		
		public void endSale(Advert advert) {
			
			if(advert == null) {
				throw new IllegalArgumentException();
			}
			
			
			if(advert.getCar().getPrice() < advert.getHighestOffer().getValue() ) {
				this.soldCars.remove(advert);
				this.unsoldCars.remove(advert);
			}
			
	}
	
	
}
