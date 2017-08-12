package main;

public class Provider {

	int id;
	
    private String name;
    private double supply;

    public Provider(String name, double supply) {
        this.name = name;
        this.supply = supply;
    }

    public Provider(int id, String name, double supply) {
        this.id = id;
        this.name = name;
        this.supply = supply;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSupply() {
        return supply;
    }

    public void setSupply(double supply) {
        this.supply = supply;
    }

    @Override
    public String toString() {
	return this.id + ", " + this.name + " - " + this.supply;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

