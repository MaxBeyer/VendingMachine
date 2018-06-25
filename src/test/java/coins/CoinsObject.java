package coins;

import coins.Coin;

public class CoinsObject {
	
	//for testing purposes only
	//This class only exists to quickly assign real coin data values to objects
	//to test the vending machine's capability of identifying valid coins.
	//Doing this in every test case would be redundant and exausting
	public Coin getCoin(String coin) {
		Coin coinToIdentify = new Coin();
		switch (coin) {
		case "penny": 
			coinToIdentify.setWeight(1.55517);
			coinToIdentify.setSize(0.75);
			break;
		case "nickel": 
			coinToIdentify.setWeight(5.000);
			coinToIdentify.setSize(0.835);
			break;
		case "dime": 
			coinToIdentify.setWeight(2.268);
			coinToIdentify.setSize(0.053);
			break;
		case "quarter": 
			coinToIdentify.setWeight(5.670);
			coinToIdentify.setSize(0.955);
			break;
		case "halfDollar": 
			coinToIdentify.setWeight(12.5);
			coinToIdentify.setSize(1.205);
			break;
		default: 
			coinToIdentify.setName("fake coin");
		}
		return coinToIdentify;
	}

}
