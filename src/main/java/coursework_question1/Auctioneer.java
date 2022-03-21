package coursework_question1;

import java.util.HashMap;
import java.util.Map;

	// Welcome to the Auctioneer class.

public class Auctioneer {
	
	// We have 1 protected String variable and 3 protected Hashmaps.
	
	protected String name;
	protected Map<Advert , User> carForSale = new HashMap<Advert , User>();
	protected Map<Advert , User> soldCars = new HashMap<Advert , User>();
	protected Map<Advert , User> unsoldCars = new HashMap<Advert , User>();
	
	public Auctioneer(String name) {
	//This is the parameterized constructor for Auctioneer. 
		
		super();
		this.name = name;
	}
	
	private boolean checkExistence(Car car) {
	/**This is the checkExistince method and in this method we check the cars existence. .
	* If the car is not null it will return true but If it is null it will return false
	*/
		if(car != null) {return true;}
		else {return false;}
	}
	
	public String displayStatistics() {
		/** This is the displayStatistics method and this method displays "Statics".
		 */
		return "Statistics";
		
	}
	
	
	 public String displaySoldCars() {
		/** This is the displaySoldCars method and this method displays the sold cars.
		 * First of all we have created a StringBuilder and after creating a StringBuilder
		 *  we have created two for loops to iterate through the hashmaps and lastly we append string or values
		 *  to our StringBuffer. 
		 */
		StringBuilder a = new StringBuilder();
		a.append("SOLD CARS:\n");
		for(Advert values : this.soldCars.keySet()) {
			for(User key : this.soldCars.values()) {
				a.append(values.getCar().getID());
				a.append(" - Purchased by ");
				a.append(key.getName());
				a.append(" with a successful £");
				a.append(values.getHighestOffer().getValue());
				a.append("0 bid. \n");
			}
			
		}
		
		return a.toString();
	}		
		
	public String displayUnsoldCars() {
		/** This displayUnsoldCars is same as displaySoldCars method but instead of displaying sold cars this method displays unsold cars.
		 * Also in this method we create a StringBuilder and a for loop. 
		 */
		StringBuilder a = new StringBuilder();
		a.append("UNSOLD CARS:\n");
		for(Advert values : this.unsoldCars.keySet()) {
			a.append("Ad: ");
			a.append(values.getCar().displayCarSpecification());
		}
		return a.toString();
	}
	
	
	public void endSale(Advert advert) {
		/** In this endSale method if the highest offer is greater than cars price it will end the sale.
		 * Also if the advert is null it will throw IllgealArgumentException.
		 */
		if(advert == null) {
			throw new IllegalArgumentException();
		}
		
		if(advert.getCar().getPrice() < advert.getHighestOffer().getValue()) {
			this.soldCars.remove(advert);
			this.unsoldCars.remove(advert);
		}
		
	}
	
	public boolean placeOffer(Advert carAdvert , User user , double value) {
		/** In this method if the carAdvert and user is null it will throw IllegalArgumentException.
		 *  If the carAdvert is not null it will placeOffer.
		 */
		if(carAdvert == null && user == null) {throw new IllegalArgumentException();}
		
		else {
			
			if(this.checkExistence(carAdvert.getCar())) {
				carAdvert.placeOffer(user, value);
				this.soldCars.put(carAdvert, user);
				this.unsoldCars.put(carAdvert, user);
				    return true;
				}
			
			return false;
		}
     }
	
	
		 

	 public void registerCar(Advert carAdvert , User user, String colour, CarType type, CarBody body, int noOfSeats) {
		/**	In this registerCar method it will registerCar by setting colour, gearbox, body and number of seats of the car. After registering the car it will put to carForSale.
		 * However, If the carAdvert or user is null method will throw IllegalArgumentException.
		 */
		 
		 
		if(carAdvert == null || user == null) {throw new IllegalArgumentException();}
		
		carAdvert.getCar().setColour(colour);
		carAdvert.getCar().setGearbox(type);
		carAdvert.getCar().setBody(body);
		carAdvert.getCar().setNumberOfSeats(noOfSeats);
		carForSale.put(carAdvert, user);
		
		
		
	}
}
