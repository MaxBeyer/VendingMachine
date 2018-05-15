package coins;

public class CoinIdentifierObject {

	public Coin identifyCoin(Coin coin) {
		Coin coinToIdentify = new Coin();

		if (coin.getWeight() == 5.000 && coin.getSize() == 0.835) {	
			coinToIdentify.setName("nickel");
			coinToIdentify.setWeight(coin.getWeight());
			coinToIdentify.setSize(coin.getSize());
			coinToIdentify.setValue(.05);
			coinToIdentify.setValid(true);
		} else if (coin.getWeight() == 2.268 && coin.getSize() == 0.053) {
			coinToIdentify.setName("dime");
			coinToIdentify.setWeight(coin.getWeight());
			coinToIdentify.setSize(coin.getSize());
			coinToIdentify.setValue(.10);
			coinToIdentify.setValid(true);
		} else if (coin.getWeight() == 5.670 && coin.getSize() == 0.955) {
			coinToIdentify.setName("quarter");
			coinToIdentify.setWeight(coin.getWeight());
			coinToIdentify.setSize(coin.getSize());
			coinToIdentify.setValue(.25);
			coinToIdentify.setValid(true);
		} else {
			coinToIdentify.setName("invalid coin");
			coinToIdentify.setWeight(coin.getWeight());
			coinToIdentify.setSize(coin.getSize());
			coinToIdentify.setValue(0);
			coinToIdentify.setValid(false);
		}
		return coinToIdentify;
	}
}
