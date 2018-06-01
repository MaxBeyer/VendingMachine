package vendingMachineTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import coins.Coin;
import coinsTest.CoinsObject;
import vendingMachine.CoinSlot;
import vendingMachine.Display;

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
	}
	
	@Test
	void displayReturnCoinTest() {
		assertEquals(true, false);
	}
	
}
