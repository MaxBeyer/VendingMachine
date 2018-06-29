package coins;

public class CoinIdentifierObject {

	public CoinLikeObject identifyCoin(CoinLikeObject coin) {
		CoinLikeObject coinToIdentify = new CoinLikeObject(0, 0);

		if (coin.getWeight() == 5.000 && coin.getSize() == 0.835) {	
			coinToIdentify.setWeight(coin.getWeight());
			coinToIdentify.setSize(coin.getSize());
		} else if (coin.getWeight() == 2.268 && coin.getSize() == 0.053) {
			coinToIdentify.setWeight(coin.getWeight());
			coinToIdentify.setSize(coin.getSize());
		} else if (coin.getWeight() == 5.670 && coin.getSize() == 0.955) {
			coinToIdentify.setWeight(coin.getWeight());
			coinToIdentify.setSize(coin.getSize());
		} else {
			coinToIdentify.setWeight(coin.getWeight());
			coinToIdentify.setSize(coin.getSize());
		}
		return coinToIdentify;
	}
}
