package vendingMachine;

import java.util.ArrayList;
import java.util.List;

import coins.CoinEnum;
import coins.CoinLikeObject;

public class CoinSlot {
	
	private static double currentAmount = 0;
	private static List<CoinEnum> coinReturn = new ArrayList<CoinEnum>();
	private static List<CoinEnum> coinsInserted = new ArrayList<CoinEnum>();

	public double getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(double currentAmount) {
		CoinSlot.currentAmount = currentAmount;
	}

	public List<CoinEnum> getCoinReturn() {
		return coinReturn;
	}

	public List<CoinEnum> getCoinsInserted() {
		return coinsInserted;
	}

	public void setCoinsInserted(List<CoinEnum> coinsInserted) {
		CoinSlot.coinsInserted = coinsInserted;
	}
	
	public CoinEnum identifyCoin(double weight, double size) {
		for (CoinEnum coin : CoinEnum.values()) {
			if (coin.getWeight() == weight && 
					coin.getSize() == size){
				return coin;
			}
		}
		return CoinEnum.INVALID_COIN;
	}

	public void insert(CoinLikeObject coinLikeObject) {
		//make new coin object every time, since every coin is different 
		CoinEnum coin = identifyCoin(coinLikeObject.getWeight(), coinLikeObject.getSize());
		if(coin.isValid()) {
			coinsInserted.add(coin);
			//setting the current amount this way is faster than looping through the inserted coins and adding them
			//HOWEVER, perhaps this is bad practice since currentAmount and coinsInserted SHOULD be dependent on each other
			//right now they are independent
			setCurrentAmount(getCurrentAmount() + coin.getValue());
		} else {
			coinReturn.add(coin);
		}
		
	}

}
