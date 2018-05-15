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
		CoinSlot coinSlot= new CoinSlot();
		Coin identifiedCoin = coinSlot.identifyCoin(quarter);
		assertEquals("quarter", identifiedCoin.getName());
		assertEquals(5.670, identifiedCoin.getWeight());
		assertEquals(0.955, identifiedCoin.getSize());
		assertEquals(.25, identifiedCoin.getValue());
	}
	
	@Test
	void validateCoinTest() {
		CoinSlot coinSlot= new CoinSlot();
		Coin dime = coinSlot.identifyCoin(coinsObject.getCoin("dime"));
		Coin penny = coinSlot.identifyCoin(coinsObject.getCoin("penny"));
		assertEquals(dime.isValid(), true);
		assertEquals(penny.isValid(), false);
	}
	
	@Test
	void currentAmountTest() {
		CoinSlot coinSlot = new CoinSlot();
		Coin dime = coinsObject.getCoin("dime");
		coinSlot.insert(dime);
		assertEquals(coinSlot.getCurrentAmount(), .10);
		coinSlot.insert(dime);
		assertEquals(coinSlot.getCurrentAmount(), .20);
	}
	
	@Test
	void returnCoinTest() {
		CoinSlot coinSlot = new CoinSlot();
		Coin penny = coinsObject.getCoin("penny");
		coinSlot.insert(penny);
		List<Coin> returnedCoins = new ArrayList<Coin>(Arrays.asList(new Coin[] {penny}));
		assertEquals(coinSlot.getCoinReturn().size(), returnedCoins.size());
		assertEquals(coinSlot.getCoinReturn().get(0).getWeight(), returnedCoins.get(0).getWeight());
		assertEquals(coinSlot.getCoinReturn().get(0).getSize(), returnedCoins.get(0).getSize());
	}
	
	@Test
	void displayTest() {
		CoinSlot coinSlot = new CoinSlot();
		Coin dime = coinsObject.getCoin("dime");
		String display = coinSlot.display();
		assertEquals(display, "INSERT COIN");
		coinSlot.insert(dime);
		assertEquals(display, coinSlot.getCurrentAmount());
		coinSlot.insert(dime);
		assertEquals(display, coinSlot.getCurrentAmount());
	}
}
