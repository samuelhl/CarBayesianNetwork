package main;

import model.Car;
import model.BayesianNetwork;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		BayesianNetwork network = new BayesianNetwork();
		network.setEvidence("Make", "Audi");
		network.updateBeliefs();
		for (Car car: network.getTop10()) {
			System.out.println(car.getMake() + " " + car.getModel() + " -> " + String.format("%.4g", car.getProb()*100) + "%");
		}
	}
}
