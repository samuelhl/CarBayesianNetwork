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

    public ArrayList<Car> getTop10() {
        double[] modelProbs = this.net.getNodeValue("Model");
        String[] modelNames = this.net.getOutcomeIds("Model");
        List<Car> cars = new ArrayList<Car>();

        for (int i = 0; i < modelNames.length; i++) {
        	String makeName = getMakeFromModel(modelNames[i]);
            cars.add(new Car(modelNames[i], makeName, modelProbs[i]));
        }
        Collections.sort(cars);

        return new ArrayList<Car>(cars.subList(0, 10));
    }

    public void updateBeliefs() {
        this.net.updateBeliefs();
    }

    public void clearAllEvidence() {
        this.net.clearAllEvidence();
    }

    public String getMakeFromModel(String model) {
        clearAllEvidence();
        setEvidence("Model", model);
        updateBeliefs();
        String[] makeNames = this.net.getOutcomeIds("Make");
        double[] makeProbs = this.net.getNodeValue("Make");
        boolean found = false;
        int i = 0;
        String make = "";
        while (!found && i < makeNames.length) {
        	if (makeProbs[i] > 0.7) {
        		make = makeNames[i];
        		found = true;
        	}
        	i++;
        }
        return make;
    }

}
