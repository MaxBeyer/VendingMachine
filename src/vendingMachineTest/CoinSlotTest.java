package vendingMachineTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import coins.Coin;
import coinsTest.CoinsObject;
import vendingMachine.CoinSlot;

class CoinSlotTest {
	
	private CoinsObject coinsObject = new CoinsObject();

	@Test
	void identifyQuaterTest() {
		Coin quarter = coinsObject.getCoin("quarter");
		double coinValue = CoinSlot.generateCoinValue(quarter);
		assertEquals(coinValue, .25);
	}
	
	@Test
	void validateCoinTest() {
		Coin dime = coinsObject.getCoin("dime");
		Coin penny = coinsObject.getCoin("penny");
		assertEquals(CoinSlot.isValid(dime), true);
		assertEquals(CoinSlot.isValid(penny), false);
	}
	
	@Test
	void currentAmountTest() {
		CoinSlot coinSlot = new CoinSlot();
		Coin dime = coinsObject.getCoin("dime");
		coinSlot.insert(dime);
		assertEquals(coinSlot.currentAmount(), .10);
		coinSlot.insert(dime);
		assertEquals(coinSlot.currentAmount(), .20);
	}
	
	@Test
	void returnCoinTest() {
		CoinSlot coinSlot = new CoinSlot();
		Coin penny = coinsObject.getCoin("penny");
		List<Coin> returnedCoins = new ArrayList<Coin>(Arrays.asList(new Coin[] {penny}));
		assertEquals(coinSlot.coinReturn(), returnedCoins);
	}
	
	@Test
	void displayTest() {
		CoinSlot coinSlot = new CoinSlot();
		Coin dime = coinsObject.getCoin("dime");
		String display = coinSlot.display();
		assertEquals(display, "INSERT COIN");
		coinSlot.insert(dime);
		assertEquals(display, coinSlot.currentAmount());
		coinSlot.insert(dime);
		assertEquals(display, coinSlot.currentAmount());
	}
}
