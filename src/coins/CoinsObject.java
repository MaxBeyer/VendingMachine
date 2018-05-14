package coins;

public class CoinsObject {
	
	public Coin getCoin(String coin) {
		Coin coinToIdentify = new Coin();
		switch (coin) {
		case "penny": 
			coinToIdentify.setName("penny");
			coinToIdentify.setWeight(1.55517);
			coinToIdentify.setSize(0.75);
			break;
		case "nickel": 
			coinToIdentify.setName("nickel");
			coinToIdentify.setWeight(5.000);
			coinToIdentify.setSize(0.835);
			break;
		case "dime": 
			coinToIdentify.setName("dime");
			coinToIdentify.setWeight(2.268);
			coinToIdentify.setSize(0.053);
			break;
		case "quarter": 
			coinToIdentify.setName("quarter");
			coinToIdentify.setWeight(5.670);
			coinToIdentify.setSize(0.955);
			break;
		case "halfDollar": 
			coinToIdentify.setName("halfDollar");
			coinToIdentify.setWeight(12.5);
			coinToIdentify.setSize(1.205);
			break;
		default: 
			coinToIdentify.setName("fake coin");
		}
		return coinToIdentify;
	}

}
