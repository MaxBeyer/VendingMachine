package vendingMachine;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import coins.Coin;
import coins.CoinsObject;
import vendingMachine.CoinSlot;
import vendingMachine.Display;
import vendingMachine.ReturnCoinsButton;

public class DisplayTest {
	
	
	CoinSlot coinSlot;
	CoinsObject coinsObject;
	
	@Before public void initializeCoinSlot() {
		coinSlot = new CoinSlot();
		coinsObject = new CoinsObject();
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
		Coin dime = coinsObject.getCoin("dime");
		assertEquals("INSERT COIN", display.displayValue());
		coinSlot.insert(dime);
		assertEquals("0.1", display.displayValue());
		coinSlot.insert(dime);
		assertEquals("0.2", display.displayValue());
		//reset the coinSlot
		coinSlot.setCurrentAmount(0);
		assertEquals("INSERT COIN", display.displayValue());
	}
	
	@Test
	public void displayReturnCoinsButtonTest() {
		Coin dime = coinsObject.getCoin("dime");
		Coin quarter = coinsObject.getCoin("quarter");
		ReturnCoinsButton returnCoinsButton = new ReturnCoinsButton();
		//verify that machine is empty and calibrated
		assertEquals("INSERT COIN", display.displayValue());
		returnCoinsButton.press();
		//verify that machine displays correctly
		assertEquals("INSERT COIN", display.displayValue());
		//insert dime and quarter to machine, verify the correct value displays
		coinSlot.insert(dime);
		coinSlot.insert(quarter);
		assertEquals("0.35", display.displayValue());
		//press returnCoinsButton, verify that display resets
		returnCoinsButton.press();
		assertEquals("INSERT COIN", display.displayValue());
	}
	
}
