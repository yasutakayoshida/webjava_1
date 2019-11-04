package jp.co.systena.tigerscave.shoppingapplication.application.model;

public class Item {

	int itemId;
	String name;
	int price;

	public Item(int itemId, String name, int price) {

		this.itemId = itemId;
		this.name = name;
		this.price = price;

	}

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


}
