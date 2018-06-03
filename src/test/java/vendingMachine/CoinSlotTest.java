package vendingMachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import coins.Coin;
import coins.CoinsObject;

public class CoinSlotTest {
	
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
	public void identifyQuaterTest() {
		Coin quarter = coinsObject.getCoin("quarter");
		Coin identifiedCoin = coinSlot.identifyCoin(quarter);
		assertEquals("quarter", identifiedCoin.getName());
		assertWithTolerance(5.670, identifiedCoin.getWeight());
		assertWithTolerance(0.955, identifiedCoin.getSize());
		assertWithTolerance(.25, identifiedCoin.getValue());
	}
	
	@Test
	public void validateCoinTest() {
		Coin dime = coinSlot.identifyCoin(coinsObject.getCoin("dime"));
		Coin penny = coinSlot.identifyCoin(coinsObject.getCoin("penny"));
		assertEquals(true, dime.isValid());
		assertEquals(false, penny.isValid());
	}
	
	@Test
	public void currentAmountTest() {
		Coin dime = coinsObject.getCoin("dime");
		coinSlot.insert(dime);
		assertWithTolerance(.10, coinSlot.getCurrentAmount());
		coinSlot.insert(dime);
		assertWithTolerance(.20, coinSlot.getCurrentAmount());
		//reset currentAmount
		coinSlot.setCurrentAmount(0);
	}
	
	@Test
	public void returnCoinTest() {
		Coin penny = coinsObject.getCoin("penny");
		coinSlot.insert(penny);
		assertEquals(1, coinSlot.getCoinReturn().size());
		assertWithTolerance(penny.getWeight(), coinSlot.getCoinReturn().get(0).getWeight());
	}
	
	@Test
	public void displayReturnNoCoinsTest() {
		Coin dime = coinsObject.getCoin("dime");
		Coin quarter = coinsObject.getCoin("quarter");
		ReturnCoinsButton returnCoinsButton = new ReturnCoinsButton();
		//verify that machine is empty and calibrated
		assertWithTolerance(0, coinSlot.getCurrentAmount());
		assertEquals(0, coinSlot.getCoinsInserted().size());
		returnCoinsButton.press();
		//verify that the currentAmount is 0 and contains no inserted coins
		assertWithTolerance(0, coinSlot.getCurrentAmount());
		assertEquals(0, coinSlot.getCoinsInserted().size());
		//insert dime and quarter to machine, verify the correct inserted coins and the value of currentAmount
		coinSlot.insert(dime);
		coinSlot.insert(quarter);
		assertWithTolerance(0.35, coinSlot.getCurrentAmount());
		assertTrue(coinSlot.getCoinsInserted().contains(dime));
		assertTrue(coinSlot.getCoinsInserted().contains(quarter));
		assertEquals(2, coinSlot.getCoinsInserted().size());
		//press returnCoinsButton, verify that currentAmount resets back to 0 and there are no inserted coins
		returnCoinsButton.press();
		assertWithTolerance(0, coinSlot.getCurrentAmount());
		assertEquals(0, coinSlot.getCoinsInserted().size());
	}
	

	private void assertWithTolerance(double expected, double actual) {
		assertEquals(expected, actual, 0.001);
	}
	
}
