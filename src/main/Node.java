package main;

public class Node {
	int id;
	double value;
	Type nodeType;

	public Node() {
	}

	public Node(int id, double value, Type type) {
		super();
		this.id = id;
		this.value = value;
		this.nodeType = type;
	}

	public enum Type {
		BROKER,
		PROVIDER,
		RECEIVER
	}
	
	
}
