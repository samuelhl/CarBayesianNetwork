package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import smile.Network;

public class BayesianNetwork {
	private Network net;

	public BayesianNetwork() {
		this.net = new Network();
		this.net.readFile("car-network.xdsl");
	}

	public void setEvidence(String node, String evidence) {
		this.net.setEvidence(node, evidence);
	}

	public List<Car> getTop10() {
		double[] modelProbs = this.net.getNodeValue("Model");
		String[] modelNames = this.net.getOutcomeIds("Model");
		List<Car> cars = new ArrayList<Car>();

		for (int i = 0; i < modelNames.length; i++) {
			cars.add(new Car(modelNames[i], "Audi", modelProbs[i]));
		}
		Collections.sort(cars);

		return cars.subList(0, 10);
	}

	public void updateBeliefs() {
		this.net.updateBeliefs();
	}

}
