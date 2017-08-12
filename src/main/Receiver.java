package main;

/**
 * Created by grzan_000 on 21.03.2017.
 */
public class Receiver {

    int id;

    private String name;
    private double demand;

    public Receiver(double demand, String name) {
        this.demand = demand;
        this.name = name;
    }

    public Receiver(int id, String name, double demand) {
        this.id = id;
        this.name = name;
        this.demand = demand;
    }

    public double getDemand() {
        return demand;
    }

    public void setDemand(double demand) {
        this.demand = demand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
	return this.id + ", " + this.name + " - " + this.demand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
