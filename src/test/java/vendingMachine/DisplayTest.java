package vendingMachine;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import coins.CoinLikeObject;

public class DisplayTest {
	
	
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
	
	private Display display = new Display();

	@Test
	public void displayTest() {
		//initiate a new coinSlot object and get a dime object
		assertEquals("INSERT COIN", display.displayValue());
		coinSlot.insert(DIME);
		assertEquals("0.1", display.displayValue());
		coinSlot.insert(DIME);
		assertEquals("0.2", display.displayValue());
		//reset the coinSlot
		coinSlot.setCurrentAmount(0);
		assertEquals("INSERT COIN", display.displayValue());
	}
	
	@Test
	public void displayReturnCoinsButtonTest() {
		ReturnCoinsButton returnCoinsButton = new ReturnCoinsButton();
		//verify that machine is empty and calibrated
		assertEquals("INSERT COIN", display.displayValue());
		returnCoinsButton.press();
		//verify that machine displays correctly
		assertEquals("INSERT COIN", display.displayValue());
		//insert dime and quarter to machine, verify the correct value displays
		coinSlot.insert(DIME);
		coinSlot.insert(QUARTER);
		assertEquals("0.35", display.displayValue());
		//press returnCoinsButton, verify that display resets
		returnCoinsButton.press();
		assertEquals("INSERT COIN", display.displayValue());
	}
	
}
