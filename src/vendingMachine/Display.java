package vendingMachine;

public class Display extends CoinSlot{
	
	
	public String displayValue() {
		String display = "INSERT COIN";
		if(getCurrentAmount() > 0) {
			display = String.valueOf(getCurrentAmount());
		}
		return display;
	}


}
