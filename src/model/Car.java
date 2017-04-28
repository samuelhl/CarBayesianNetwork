package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Car implements Comparable<Car> {
	private String model;
	private String make;
	private double prob;

	public Car(String model, String make, double prob) {
		this.model = model;
		this.make = make;
		this.prob = round(prob, 2);
	}

	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
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
