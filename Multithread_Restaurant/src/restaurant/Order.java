package restaurant;

public class Order {
	int table;
	int amount;

	Order(int table, int amount) {
		this.table = table;
		this.amount = amount;
	}

	public int getTable() {
		return table;
	}

	public void setTable(int table) {
		this.table = table;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
