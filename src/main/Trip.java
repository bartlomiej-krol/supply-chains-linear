package main;

public class Trip {

	int from;
	int to;
	
	String name;
	double cost;
	double value;

	public Trip() {
	}

	public Trip(int from, int to, String name, double cost, double value) {
		super();
		this.from = from;
		this.to = to;
		this.name = name;
		this.cost = cost;
		this.value = value;
	}
        
        @Override
        public String toString() {
            return String.format("%s (%d/%d)| %d->%d", name, (int)cost, (int)value, from, to);
        }
	
	
	
	
}
