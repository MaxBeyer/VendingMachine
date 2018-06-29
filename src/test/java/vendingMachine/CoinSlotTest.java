package vendingMachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import coins.CoinEnum;
import coins.CoinLikeObject;

public class CoinSlotTest {
	
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
	public void identifyQuaterTest() {
		CoinEnum identifiedCoin = coinSlot.identifyCoin(QUARTER.getWeight(), QUARTER.getSize());
		assertEquals("quarter", identifiedCoin.getName());
		assertWithTolerance(5.670, identifiedCoin.getWeight());
		assertWithTolerance(0.955, identifiedCoin.getSize());
		assertWithTolerance(.25, identifiedCoin.getValue());
		assertTrue(identifiedCoin.isValid());
	}
	
	@Test
	public void identifyPennyTest() {
		CoinEnum identifiedCoin = coinSlot.identifyCoin(PENNY.getWeight(), PENNY.getSize());
		assertEquals("invalid coin", identifiedCoin.getName());
		assertWithTolerance(0, identifiedCoin.getWeight());
		assertWithTolerance(0, identifiedCoin.getSize());
		assertWithTolerance(0, identifiedCoin.getValue());
		assertFalse(identifiedCoin.isValid());
	}
	
	//need to make a separate Test Enum that is similar to CoinEnum but only having weight and size values
	//A bug is happening when multiple coins are inserted, every coin is being set to the enum value of the last most inserted coin
	//for example, if you insert a nickle, dime, and quarter:
	//	nickle inserterd, nickle identified as nickle
	//	dime inserted, nickle  and dime identified as dime
	//	quarter inserted, nickle, dime, and quarter identified as quarter
	//this only started happening after the CoinEnum replaced the Coin.java class and CoinIdentifierObject
	@Test
	public void validateCoinTest() {
		CoinEnum penny = coinSlot.identifyCoin(PENNY.getWeight(), PENNY.getSize());
		CoinEnum dime = coinSlot.identifyCoin(DIME.getWeight(), DIME.getSize());
		assertEquals(true, dime.isValid());
		assertEquals(false, penny.isValid());
	}
	
	@Test
	public void currentAmountTest() {
		coinSlot.insert(DIME);
		assertWithTolerance(.10, coinSlot.getCurrentAmount());
		coinSlot.insert(DIME);
		assertWithTolerance(.20, coinSlot.getCurrentAmount());
		//reset currentAmount
		coinSlot.setCurrentAmount(0);
	}
	
	@Test
	public void returnInvalidCoinTest() {
		coinSlot.insert(PENNY);
		assertEquals(1, coinSlot.getCoinReturn().size());
		assertTrue(coinSlot.getCoinReturn().get(0).getName() == "invalid coin");
	}
	
	@Test
	public void displayReturnNoCoinsTest() {
		//define dime and quarter now for later assertions
		CoinEnum dime = CoinEnum.DIME;
		CoinEnum quarter = CoinEnum.QUARTER;
		ReturnCoinsButton returnCoinsButton = new ReturnCoinsButton();
		//verify that machine is empty and calibrated
		assertWithTolerance(0, coinSlot.getCurrentAmount());
		assertEquals(0, coinSlot.getCoinsInserted().size());
		returnCoinsButton.press();
		//verify that the currentAmount is 0 and contains no inserted coins
		assertWithTolerance(0, coinSlot.getCurrentAmount());
		assertEquals(0, coinSlot.getCoinsInserted().size());
		//insert dime and quarter to machine, verify the correct inserted coins and the value of currentAmount
		coinSlot.insert(DIME);
		coinSlot.insert(QUARTER);
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
