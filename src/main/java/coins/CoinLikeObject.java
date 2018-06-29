package coins;

public class CoinLikeObject {
	
	private double weight;
	private double size;
	
	public CoinLikeObject(double weight, double size) {
		super();
		this.weight = weight;
		this.size = size;
	}

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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(size);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoinLikeObject other = (CoinLikeObject) obj;
		if (Double.doubleToLongBits(size) != Double.doubleToLongBits(other.size))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}


}
