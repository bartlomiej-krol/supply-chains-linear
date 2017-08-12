package main;

public class Shipment {
	final double costPerUnit;
    final int r, c;
    double quantity;

    public Shipment(double q, double cpu, int r, int c) {
        quantity = q;
        costPerUnit = cpu;
        this.r = r;
        this.c = c;
    }

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getCostPerUnit() {
		return costPerUnit;
	}
    
    
}
