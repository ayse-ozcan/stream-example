package StreamProduct;

public class Main {

	public static void main(String[] args) {
	
		Grocery grocery = new Grocery();
		
		grocery.listProducts();
		grocery.createPriceMap();
		grocery.priceList();
		grocery.priceGreaterThan50();
		grocery.average();

		grocery.addProduct();
		grocery.addProduct();
		grocery.addProduct();
		
		grocery.showBaket();
	}

}
