package main;

public class Broker {

	int id;
	private String name;
	int value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Broker(int id, String name, int value) {
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.id + ", " + this.name + " - " + this.value;
	}
}
