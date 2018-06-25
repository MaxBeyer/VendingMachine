package coins;

//placeholder to replace the CoinIdentifierObject with an enum

public enum CoinEnum {

	NICKLE("nickle", 5.000, 0.835, .05, true),
	DIME("dime", 2.268, 0.053, .10, true),
	QUARTER("quarter", 5.670, 0.955, .25, true);

	private String name;
	private double weight;
	private double size;
	private double value;
	private boolean isValid;

	CoinEnum(String name, double weight, double size, double value, boolean isValid) {
		this.name = name;
		this.weight = weight;
		this.size = size;
		this.value= value;
		this.isValid = isValid;
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}

	public double getSize() {
		return size;
	}

	public double getValue() {
		return value;
	}

	public boolean isValid() {
		return isValid;
	}

	public static CoinEnum identifyBy(Coin insertedObject) {
		for (CoinEnum coin : values()) {
			if (coin.getWeight() == insertedObject.getWeight() && 
					coin.getSize() == insertedObject.getSize()){
				return coin;
			}
		}
		return null;
	}
}
