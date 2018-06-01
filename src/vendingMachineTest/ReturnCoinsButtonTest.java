package vendingMachineTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import coins.Coin;
import coinsTest.CoinsObject;
import vendingMachine.CoinSlot;
import vendingMachine.Display;
import vendingMachine.ReturnCoinsButton;

/*
As a customer
I want to have my money returned
So that I can change my mind about buying stuff from the vending machine
*/

class ReturnCoinsButtonTest {

	private CoinsObject coinsObject = new CoinsObject();
	private Display display = new Display();
	
	@Test
	void displayReturnNoCoinsTest() {
		CoinSlot coinSlot = new CoinSlot();
		Coin dime = coinsObject.getCoin("dime");
		Coin quarter = coinsObject.getCoin("quarter");
		ReturnCoinsButton returnCoinsButton = new ReturnCoinsButton();
		//verify that machine is empty and calibrated
		assertEquals("INSERT COIN", display.displayValue());
		returnCoinsButton.press();
		//verify that machine displays correctly, the currentAmount is 0, and returns no coins after returnedCoins is pressed with no coins
		assertEquals("INSERT COIN", display.displayValue());
		assertEquals(0, coinSlot.getCurrentAmount());
		assertEquals(0, coinSlot.getCoinReturn().size());
		//insert dime and quarter to machine, verify the correct value is in the currentAmount, displays, and that coin return is empty
		coinSlot.insert(dime);
		coinSlot.insert(quarter);
		assertEquals("0.35", display.displayValue());
		assertEquals(0.35, coinSlot.getCurrentAmount());
		assertEquals(0, coinSlot.getCoinReturn().size());
		//press returnCoinsButton, verify that display resets, currentAmount back to 0, and all inserted coins are contained in the coin slot
		returnCoinsButton.press();
		assertEquals("INSERT COIN", display.displayValue());
		assertEquals(0, coinSlot.getCurrentAmount());
		assertEquals(2, coinSlot.getCoinReturn().size());
		assertEquals("dime", coinSlot.getCoinReturn().get(0).getName());
		assertEquals("quarter", coinSlot.getCoinReturn().get(1).getName());
	}

}
