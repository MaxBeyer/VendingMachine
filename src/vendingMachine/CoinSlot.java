package vendingMachine;

import coins.Coin;
import coins.CoinIdentifierObject;

public class CoinSlot {
	
	private static CoinIdentifierObject coinIdentifierObject = new CoinIdentifierObject();

	public Coin identifyCoin(Coin coin) {
		Coin identifiedCoin = coinIdentifierObject.identifyCoin(coin);
		return identifiedCoin;
	}

	public static boolean isValid(Coin penny) {
		// TODO Auto-generated method stub
		return true;
	}

	public void insert(Coin penny) {
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
