package coins;

public class Coin {
	
	private double weight;
	private double size;
	private double value;

	public double getWeight() {
		return weight;
	}

	//weight is in grams
	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getSize() {
		return size;
	}

	//size is in inches
	public void setSize(double size) {
		this.size = size;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
