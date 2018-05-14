package vendingMachineTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import coins.Coin;
import vendingMachine.CoinSlot;

class CoinSlotTest {

	@Test
	void identifyQuaterTest() {
		Coin quarter = new Coin();
		quarter.setWeight(5.670);
		quarter.setSize(0.955);
		double coinValue = CoinSlot.generateCoinValue(quarter);
		assertEquals(coinValue, .25);
	}
}
