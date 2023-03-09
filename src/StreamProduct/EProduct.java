package StreamProduct;

public enum EProduct {

	CHIPS(20), COKE(15), SUGAR(65), OIL(140), BREAD(5), EGG(100);

	double price;

	EProduct(double price) {
		this.price = price;

	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
