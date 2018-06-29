package vendingMachine;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import coins.CoinLikeObject;

/*
As a customer
I want to have my money returned
So that I can change my mind about buying stuff from the vending machine
*/

public class ReturnCoinsButtonTest {

	CoinSlot coinSlot;
	
	public static final CoinLikeObject PENNY = new CoinLikeObject(1.55517, 0.75);
	public static final CoinLikeObject NICKEL = new CoinLikeObject(5.000, 0.835);
	public static final CoinLikeObject DIME = new CoinLikeObject(2.268, 0.053);
	public static final CoinLikeObject QUARTER = new CoinLikeObject(5.670, 0.955);
	public static final CoinLikeObject HALF_DOLLAR = new CoinLikeObject(12.5, 1.205);
	
	@Before public void initializeCoinSlot() {
		coinSlot = new CoinSlot();
	}
	
	@After public void resetCoinSlot() {
		coinSlot.setCurrentAmount(0);
		coinSlot.getCoinReturn().clear();
		coinSlot.getCoinsInserted().clear();
	}
	
	@Test
	public void displayReturnNoCoinsTest() {
		Display display = new Display();
		ReturnCoinsButton returnCoinsButton = new ReturnCoinsButton();
		//verify that machine is empty and calibrated
		assertEquals("INSERT COIN", display.displayValue());
		returnCoinsButton.press();
		//verify that machine displays correctly, the currentAmount is 0, and returns no coins after returnedCoins is pressed with no coins
		assertEquals("INSERT COIN", display.displayValue());
		assertWithTolerance(0, coinSlot.getCurrentAmount());
		assertEquals(0, coinSlot.getCoinReturn().size());
		//insert dime and quarter to machine, verify the correct value is in the currentAmount, displays, and that coin return is empty
		coinSlot.insert(DIME);
		coinSlot.insert(QUARTER);
		assertEquals("0.35", display.displayValue());
		assertWithTolerance(0.35, coinSlot.getCurrentAmount());
		assertEquals(0, coinSlot.getCoinReturn().size());
		//press returnCoinsButton, verify that display resets, currentAmount back to 0, and all inserted coins are contained in the coin slot
		returnCoinsButton.press();
		assertEquals("INSERT COIN", display.displayValue());
		assertWithTolerance(0, coinSlot.getCurrentAmount());
		assertEquals(2, coinSlot.getCoinReturn().size());
		assertEquals("dime", coinSlot.getCoinReturn().get(0).getName());
		assertEquals("quarter", coinSlot.getCoinReturn().get(1).getName());
	}
	

	private void assertWithTolerance(double expected, double actual) {
		assertEquals(expected, actual, 0.001);
	}

}
