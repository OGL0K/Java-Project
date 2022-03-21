package coursework_question2;

import static org.junit.Assert.*;
import org.junit.Test;

public class AdvertJTest {
	
	
	
	@Test (expected =IllegalArgumentException.class)
	public void coursework_testNullCar() {
		@SuppressWarnings("unused")
		Advert advert = new Advert(null);
	}
	
	
	@Test
	public void highestOffer() {
		
		User buyer = new User("Osman Gültekin");
		User buyer2 = new User("Aykut Elmas");
		Car car = new Car(3456, "Toyota Corolla", 7000, Condition.NEW, SaleType.FORSALE);
		Advert advert = new Advert(car);
		advert.placeOffer(buyer, 7000);
		advert.placeOffer(buyer2, 7500);
		assertEquals(buyer2, advert.getHighestOffer().getBuyer());
		
		
	}
	
	@Test
	public void coursework_placeOffer() {
		User user = new User("Osman Gultekin");	
		Car	car = new Car(3456, "Toyota Corolla", 7000, Condition.NEW, SaleType.AUCTION);
		Advert advert = new Advert(car);
		assertEquals(true, advert.placeOffer(user, 7500));
	}
	
	@Test
	public void coursework_placeOffer2() {
		User user = new User("Osman Gultekin");	
		Car	car = new Car(3456, "Toyota Corolla", 7000, Condition.NEW, SaleType.FORSALE);
		Advert advert = new Advert(car);
		assertEquals(false, advert.placeOffer(user, 6000));
	}
	
	@Test
	public void coursework_toString() {
		Car	car = new Car(3456, "Toyota Corolla", 7000, Condition.NEW, SaleType.AUCTION);
		Advert advert = new Advert(car);
			
		car.setBody(CarBody.MICRO);
		car.setColour("Red");
		car.setGearbox(CarType.MANUAL);
		car.setNumberOfSeats(4);

		assertEquals("Ad: \n	 3456 - Toyota Corolla (£7000.00)\n" + "	 Type: MANUAL\n" + "	 Style: MICRO\n"
				+ "	 Colour: Red\n" + "	 No. of Seats: 4\n" + "	 Condition: NEW", advert.toString());
	}
	
	@Test
	public void coursework_toString2() {
		Car	car = new Car(3169, "Audi A3", 15000, Condition.NEW, SaleType.FORSALE);
		Advert advert = new Advert(car);
			
		car.setBody(CarBody.HATCHBACK);
		car.setColour("Dark Blue");
		car.setGearbox(CarType.AUTOMATIC);
		car.setNumberOfSeats(4);

		assertEquals("Ad: \n	 3169 - Audi A3 (£15000.00)\n" + "	 Type: AUTOMATIC\n" + "	 Style: HATCHBACK\n"
				+ "	 Colour: Dark Blue\n" + "	 No. of Seats: 4\n" + "	 Condition: NEW", advert.toString());
	}

}


