package model;

public class Car implements Comparable<Car> {
	private String model;
	private String make;
	private double prob;

	public Car(String model, String make, double prob) {
		this.model = model;
		this.make = make;
		this.prob = prob;
	}

	public int compareTo(Car car) {
		if (this.prob < car.prob) {
			return 1;
		} else if (this.prob > car.prob) {
			return -1;
		} else {
			return 0;
		}
	}

	public String getModel() {
		return this.model;
	}

	public String getMake() {
		return this.make;
	}

	public double getProb() {
		return this.prob;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setProb(double prob) {
		this.prob = prob;
	}

}
