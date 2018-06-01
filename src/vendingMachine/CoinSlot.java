package vendingMachine;

import java.util.ArrayList;
import java.util.List;

import coins.Coin;
import coins.CoinIdentifierObject;

public class CoinSlot {
	
	private static CoinIdentifierObject coinIdentifierObject = new CoinIdentifierObject();
	private static double currentAmount = 0;
	private List<Coin> coinReturn = new ArrayList<Coin>();
	private static List<Coin> coinsInserted = new ArrayList<Coin>();

	public double getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(double currentAmount) {
		CoinSlot.currentAmount = currentAmount;
	}

	public List<Coin> getCoinReturn() {
		return coinReturn;
	}

	public static List<Coin> getCoinsInserted() {
		return coinsInserted;
	}

	public static void setCoinsInserted(List<Coin> coinsInserted) {
		CoinSlot.coinsInserted = coinsInserted;
	}

	public Coin identifyCoin(Coin coin) {
		Coin identifiedCoin = coinIdentifierObject.identifyCoin(coin);
		return identifiedCoin;
	}

	public void insert(Coin coin) {
		//make new coin object every time, since every coin is different 
		Coin insertedCoin = coinIdentifierObject.identifyCoin(coin);
		if(insertedCoin.isValid()) {
			coinsInserted.add(insertedCoin);
			//setting the current amount this way is faster than looping through the inserted coins and adding them
			//HOWEVER, perhaps this is bad practice since currentAmount and coinsInserted SHOULD be dependent on eachother
			//right now they are independent
			setCurrentAmount(getCurrentAmount() + insertedCoin.getValue());
		} else {
			coinReturn.add(insertedCoin);
		}
		
	}

}
