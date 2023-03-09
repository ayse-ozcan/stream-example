package StreamProduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Grocery {

	EProduct[] product = EProduct.values();
	List<Product> products = new ArrayList<>();
	Map<String, Integer> basketMap = new HashMap<>();
	Map<String, Double> priceMap = new HashMap<>();

	public Grocery() {

		createProduct();
	}

	public void createProduct() {

		products = Arrays.asList(product).stream().map(product -> new Product(product.name(), product.price))
				.collect(Collectors.toList());

	}

	public void listProducts() {

		// products.forEach(Product::showInfo);
		// products.forEach(System.out::println);
		products.forEach(product -> System.out.println(product.getName()));
	}

	public void createPriceMap() {

		priceMap = products.stream()
				.collect(Collectors.toMap(product -> product.getName(), product -> product.getPrice()));

	}

	public void priceList() {
		priceMap.forEach((key, value) -> System.out.println("product: " + key + " price: " + value));
		// basketMap.entrySet().forEach(System.out::println);
	}

	public void priceGreaterThan50() {

//		List<Product> priceGreaterThan50 = products.stream().filter(product -> urun.getPrice() > 50).collect(Collectors.toList());
//		System.out.println(priceGreaterThan50);

		List<String> products = priceMap.entrySet().stream().filter(entry -> entry.getValue() > 50).map(Entry::getKey)
				.collect(Collectors.toList());
		System.out.println(products);

	}

	public void average() {
		List<Product> avg = products.stream().filter(x -> x.getPrice() > 50).collect(Collectors.toList());
		avg.stream().mapToDouble(x -> x.getPrice()).average()
				.ifPresent(avg1 -> System.out.println("Average found is: " + avg1));

//		double result = avg.stream().collect(Collectors.averagingDouble(Product::getPrice));
//		System.out.println(result);

	}

	public void addProduct() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Add product the basket: ");
		String product = scanner.nextLine();
		if (priceMap.containsKey(product)) {
			if (basketMap.containsKey(product)) {
				basketMap.put(product, basketMap.get(product + 1));

			} else {
				basketMap.put(product, 1);
				System.out.println(product + " added to basket");
			}

		} else {
			System.out.println("this product does not exist");
		}
	}

	public void showBaket() {
		basketMap.forEach((key, value) -> System.out.println(key + "-->" + value));
	}
}
