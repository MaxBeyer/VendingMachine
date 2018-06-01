package vendingMachineTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import coins.Coin;
import coinsTest.CoinsObject;
import vendingMachine.CoinSlot;
import vendingMachine.Display;
import vendingMachine.ReturnCoinsButton;

class DisplayTest {
	
	private CoinsObject coinsObject = new CoinsObject();
	private Display display = new Display();

	@Test
	void displayTest() {
		//initiate a new coinSlot object and get a dime object
		CoinSlot coinSlot = new CoinSlot();
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
	void displayReturnCoinsButtonTest() {
		CoinSlot coinSlot = new CoinSlot();
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
