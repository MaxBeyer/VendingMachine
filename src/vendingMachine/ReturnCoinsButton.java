package vendingMachine;

import coins.Coin;

/*
As a customer
I want to have my money returned
So that I can change my mind about buying stuff from the vending machine
*/

public class ReturnCoinsButton extends CoinSlot{
	
	public void press() {
		setCurrentAmount(0);
		for(Coin coin:getCoinsInserted()) {
			getCoinReturn().add(coin);
		}
		getCoinsInserted().clear();
	}

}
