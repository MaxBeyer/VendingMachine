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

/*
As a customer
I want to have my money returned
So that I can change my mind about buying stuff from the vending machine
*/

public class ReturnCoinsButtonTest {

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
	
	@Test
	public void displayReturnNoCoinsTest() {
		Display display = new Display();
		Coin dime = coinsObject.getCoin("dime");
		Coin quarter = coinsObject.getCoin("quarter");
		ReturnCoinsButton returnCoinsButton = new ReturnCoinsButton();
		//verify that machine is empty and calibrated
		assertEquals("INSERT COIN", display.displayValue());
		returnCoinsButton.press();
		//verify that machine displays correctly, the currentAmount is 0, and returns no coins after returnedCoins is pressed with no coins
		assertEquals("INSERT COIN", display.displayValue());
		assertWithTolerance(0, coinSlot.getCurrentAmount());
		assertEquals(0, coinSlot.getCoinReturn().size());
		//insert dime and quarter to machine, verify the correct value is in the currentAmount, displays, and that coin return is empty
		coinSlot.insert(dime);
		coinSlot.insert(quarter);
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
