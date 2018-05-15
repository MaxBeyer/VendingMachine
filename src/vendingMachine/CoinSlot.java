package vendingMachine;

import coins.Coin;
import coins.CoinIdentifierObject;

public class CoinSlot {
	
	private static CoinIdentifierObject coinIdentifierObject = new CoinIdentifierObject();

	public Coin identifyCoin(Coin coin) {
		Coin identifiedCoin = coinIdentifierObject.identifyCoin(coin);
		return identifiedCoin;
	}

	public void insert(Coin coin) {
		// TODO Auto-generated method stub
		
	}

	public Object coinReturn() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object currentAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	public String display() {
		// TODO Auto-generated method stub
		return null;
	}

}
