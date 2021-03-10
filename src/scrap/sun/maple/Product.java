package scrap.sun.maple;

public class Product {

	private String name;
	private double proability;

	public Product(String name, double proability) {
		this.name = name;
		this.proability = proability;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getProability() {
		return proability;
	}

	public void setProability(double proability) {
		this.proability = proability;
	}

}
