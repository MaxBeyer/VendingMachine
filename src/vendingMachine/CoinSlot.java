package vendingMachine;

import java.util.ArrayList;
import java.util.List;

import coins.Coin;
import coins.CoinIdentifierObject;

public class CoinSlot {
	
	private static CoinIdentifierObject coinIdentifierObject = new CoinIdentifierObject();
	private double currentAmount = 0;
	private List<Coin> coinReturn = new ArrayList<Coin>();

	public double getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(double currentAmount) {
		this.currentAmount = currentAmount;
	}

	public List<Coin> getCoinReturn() {
		return coinReturn;
	}

	public Coin identifyCoin(Coin coin) {
		Coin identifiedCoin = coinIdentifierObject.identifyCoin(coin);
		return identifiedCoin;
	}

	public void insert(Coin coin) {
		// TODO Auto-generated method stub
		Coin insertedCoin = coinIdentifierObject.identifyCoin(coin);
		if(insertedCoin.isValid()) {
			setCurrentAmount(getCurrentAmount() + insertedCoin.getValue());
		} else {
			coinReturn.add(insertedCoin);
		}
		
	}

	public String display() {
		String display = "INSERT COIN";
		if(getCurrentAmount() > 0) {
			display = String.valueOf(getCurrentAmount());
		}
		return display;
	}


}
