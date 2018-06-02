package vendingMachineTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import coins.Coin;
import coinsTest.CoinsObject;
import vendingMachine.CoinSlot;
import vendingMachine.ReturnCoinsButton;

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
	void identifyQuaterTest() {
		Coin quarter = coinsObject.getCoin("quarter");
		Coin identifiedCoin = coinSlot.identifyCoin(quarter);
		assertEquals("quarter", identifiedCoin.getName());
		assertEquals(5.670, identifiedCoin.getWeight());
		assertEquals(0.955, identifiedCoin.getSize());
		assertEquals(.25, identifiedCoin.getValue());
	}
	
	@Test
	void validateCoinTest() {
		Coin dime = coinSlot.identifyCoin(coinsObject.getCoin("dime"));
		Coin penny = coinSlot.identifyCoin(coinsObject.getCoin("penny"));
		assertEquals(true, dime.isValid());
		assertEquals(false, penny.isValid());
	}
	
	@Test
	void currentAmountTest() {
		Coin dime = coinsObject.getCoin("dime");
		coinSlot.insert(dime);
		assertEquals(.10, coinSlot.getCurrentAmount());
		coinSlot.insert(dime);
		assertEquals(.20, coinSlot.getCurrentAmount());
		//reset currentAmount
		coinSlot.setCurrentAmount(0);
	}
	
	@Test
	void returnCoinTest() {
		Coin penny = coinsObject.getCoin("penny");
		coinSlot.insert(penny);
		assertEquals(1, coinSlot.getCoinReturn().size());
		assertEquals(penny.getWeight(), coinSlot.getCoinReturn().get(0).getWeight());
	}
	
	@Test
	void displayReturnNoCoinsTest() {
		Coin dime = coinsObject.getCoin("dime");
		Coin quarter = coinsObject.getCoin("quarter");
		ReturnCoinsButton returnCoinsButton = new ReturnCoinsButton();
		//verify that machine is empty and calibrated
		assertEquals(0, coinSlot.getCurrentAmount());
		assertEquals(0, coinSlot.getCoinsInserted().size());
		returnCoinsButton.press();
		//verify that the currentAmount is 0 and contains no inserted coins
		assertEquals(0, coinSlot.getCurrentAmount());
		assertEquals(0, coinSlot.getCoinsInserted().size());
		//insert dime and quarter to machine, verify the correct inserted coins and the value of currentAmount
		coinSlot.insert(dime);
		coinSlot.insert(quarter);
		assertEquals(0.35, coinSlot.getCurrentAmount());
		assertTrue(coinSlot.getCoinsInserted().contains(dime));
		assertTrue(coinSlot.getCoinsInserted().contains(quarter));
		assertEquals(2, coinSlot.getCoinsInserted().size());
		//press returnCoinsButton, verify that currentAmount resets back to 0 and there are no inserted coins
		returnCoinsButton.press();
		assertEquals(0, coinSlot.getCurrentAmount());
		assertEquals(0, coinSlot.getCoinsInserted().size());
	}
	

}
