package application;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.BayesianNetwork;


public class Controller {
	private BayesianNetwork network;

	String prices[] = {"", "s01_below_10000", "s02_10000_20000", "s03_20000_30000", "s04_30000_40000", "s05_40000_50000", "s06_50000_60000", "s07_60000_70000", "s08_70000_80000"};
	String years[] = {"", "s1_below_2005", "s2_2005_2009", "s3_2009_2013", "s4_2013_up"};
	String sizes[] = {"", "Compact", "Large", "Midsize"};
	String vehicleStyles[] = {"", "Convertible", "Convertible_SUV", "Coupe", "S_2dr_Hatchback", "S_2dr_SUV", "S_4dr_Hatchback", "S_4dr_SUV", "Sedan", "Wagon"};
	String transmissionTypes[] = {"", "AUTOMATED_MANUAL", "AUTOMATIC", "DIRECT_DRIVE", "MANUAL"};
	String popularities[] = {"", "s01_below_500", "s02_500_1000", "s03_1000_1500", "s04_1500_2000", "s05_2000_2500", "s07_3000_3500", "s08_3500_4000", "s12_5500_up"};
	String numberOfDoors[] = {"", "s1_below_3", "s2_3_up"};
	String engineFuelTypes[] = {"", "diesel", "electric", "flex_fuel__premium_unleaded_recommended_E85_", "flex_fuel__premium_unleaded_required_E85_", "flex_fuel__unleaded_E85_", "premium_unleaded__recommended_", "premium_unleaded__required_", "regular_unleaded"};
	String cityL100km[] = {"", "s2_5_10", "s3_10_15", "s4_15_20", "s5_20_25", "s6_25_up"};
	String drivenWheels[] = {"", "all_wheel_drive", "four_wheel_drive", "front_wheel_drive", "rear_wheel_drive"};
	String engineHP[] = {"", "s01_below_100", "s02_100_200", "s03_200_300", "s04_300_400", "s05_400_500"};
	String engineCylinders[] = {"", "s1_below_2", "s2_2_4", "s3_4_6", "s4_6_8"};
	String highwayL100km[] = {"", "s1_below_10", "s2_10_15", "s3_15_20", "s4_20_25", "s6_30_up"};
	String makes[] = {"", "Alfa_Romeo", "Audi", "BMW", "Cadillac", "Chevrolet", "Chrysler", "Dodge", "FIAT", "GMC", "Honda", "HUMMER", "Hyundai", "Infiniti", "Kia", "Land_Rover", "Lexus", "Lincoln", "Lotus", "Maserati", "Mazda", "MercedesBenz", "Mitsubishi", "Nisssan", "Plymouth", "Pontiac", "Porsche", "Saab", "Subaru", "Suzuki", "Toyota", "Volkswagen", "Volvo"};

    @FXML
    private ChoiceBox<String> makeChoiceBox;
    @FXML
    private ChoiceBox<String> priceChoiceBox;
    @FXML
    private ChoiceBox<String> yearChoiceBox;
    @FXML
    private ChoiceBox<String> popularityChoiceBox;
    @FXML
    private ChoiceBox<String> vehicleSizeChoiceBox;
    @FXML
    private ChoiceBox<String> vehicleStyleChoiceBox;
    @FXML
    private ChoiceBox<String> drivenWheelsChoiceBox;
    @FXML
    private ChoiceBox<String> numberDoorsChoiceBox;
    @FXML
    private ChoiceBox<String> transmissionChoiceBox;
    @FXML
    private ChoiceBox<String> cityChoiceBox;
    @FXML
    private ChoiceBox<String> highwayChoiceBox;
    @FXML
    private ChoiceBox<String> engineHPChoiceBox;
    @FXML
    private ChoiceBox<String> engineFuelChoiceBox;
    @FXML
    private ChoiceBox<String> engineCylindersChoiceBox;

    @FXML
    private TextArea topTenTextArea;

    @FXML
    public void inference(){
    	topTenTextArea.setText("Prueba");
    }

    @FXML
    public void clear(){
    	topTenTextArea.setText("");
    }

    public void initialize() {
        makeChoiceBox.setItems(FXCollections.observableArrayList(makes));
        makeChoiceBox.getSelectionModel().selectFirst();
        makeChoiceBox.setTooltip(new Tooltip("Select a make"));

        priceChoiceBox.setItems(FXCollections.observableArrayList(prices));
        priceChoiceBox.getSelectionModel().selectFirst();
        priceChoiceBox.setTooltip(new Tooltip("Select a price interval"));

        yearChoiceBox.setItems(FXCollections.observableArrayList(years));
        yearChoiceBox.getSelectionModel().selectFirst();
        yearChoiceBox.setTooltip(new Tooltip("Select a year interval"));

        popularityChoiceBox.setItems(FXCollections.observableArrayList(popularities));
        popularityChoiceBox.getSelectionModel().selectFirst();
        popularityChoiceBox.setTooltip(new Tooltip("Select a popularity interval"));

        vehicleSizeChoiceBox.setItems(FXCollections.observableArrayList(sizes));
        vehicleSizeChoiceBox.getSelectionModel().selectFirst();
        vehicleSizeChoiceBox.setTooltip(new Tooltip("Select a vehicle size"));

        vehicleStyleChoiceBox.setItems(FXCollections.observableArrayList(vehicleStyles));
        vehicleStyleChoiceBox.getSelectionModel().selectFirst();
        vehicleStyleChoiceBox.setTooltip(new Tooltip("Select a vehicle style"));

        drivenWheelsChoiceBox.setItems(FXCollections.observableArrayList(drivenWheels));
        drivenWheelsChoiceBox.getSelectionModel().selectFirst();
        drivenWheelsChoiceBox.setTooltip(new Tooltip("Select the amount of driven wheels"));

        numberDoorsChoiceBox.setItems(FXCollections.observableArrayList(numberOfDoors));
        numberDoorsChoiceBox.getSelectionModel().selectFirst();
        numberDoorsChoiceBox.setTooltip(new Tooltip("Select a number of doors interval"));

        transmissionChoiceBox.setItems(FXCollections.observableArrayList(transmissionTypes));
        transmissionChoiceBox.getSelectionModel().selectFirst();
        transmissionChoiceBox.setTooltip(new Tooltip("Select a transmission type"));

        cityChoiceBox.setItems(FXCollections.observableArrayList(cityL100km));
        cityChoiceBox.getSelectionModel().selectFirst();
        cityChoiceBox.setTooltip(new Tooltip("Select a fuel consumption interval for city driving"));

        highwayChoiceBox.setItems(FXCollections.observableArrayList(highwayL100km));
        highwayChoiceBox.getSelectionModel().selectFirst();
        highwayChoiceBox.setTooltip(new Tooltip("Select a fuel consumption interval for highway driving"));

        engineHPChoiceBox.setItems(FXCollections.observableArrayList(engineHP));
        engineHPChoiceBox.getSelectionModel().selectFirst();
        engineHPChoiceBox.setTooltip(new Tooltip("Select an engine HP interval"));

        engineFuelChoiceBox.setItems(FXCollections.observableArrayList(engineFuelTypes));
        engineFuelChoiceBox.getSelectionModel().selectFirst();
        engineFuelChoiceBox.setTooltip(new Tooltip("Select an engine fuel type"));

        engineCylindersChoiceBox.setItems(FXCollections.observableArrayList(engineCylinders));
        engineCylindersChoiceBox.getSelectionModel().selectFirst();
        engineCylindersChoiceBox.setTooltip(new Tooltip("Select an engine cylinder interval"));
    }

    private void setMake(){
        String evidence=makeChoiceBox.getSelectionModel().getSelectedItem();
        if(!evidence.equals("")){
            network.setEvidence("make",evidence);
        }
    }

    private void setPrice(){
        String evidence=priceChoiceBox.getSelectionModel().getSelectedItem();
        if(!evidence.equals("")){
            network.setEvidence("price",evidence);
        }
    }

    private void setYear(){
        String evidence=yearChoiceBox.getSelectionModel().getSelectedItem();
        if(!evidence.equals("")){
            network.setEvidence("year",evidence);
        }
    }

    private void setPopularity(){
        String evidence=popularityChoiceBox.getSelectionModel().getSelectedItem();
        if(!evidence.equals("")){
            network.setEvidence("popularity",evidence);
        }
    }

    private void setVehicleSize(){
        String evidence=vehicleSizeChoiceBox.getSelectionModel().getSelectedItem();
        if(!evidence.equals("")){
            network.setEvidence("vehicleSize",evidence);
        }
    }

    private void setVehicleStyle(){
        String evidence=vehicleStyleChoiceBox.getSelectionModel().getSelectedItem();
        if(!evidence.equals("")){
            network.setEvidence("vehicleStyle",evidence);
        }
    }

    private void setDrivenWheels(){
        String evidence=drivenWheelsChoiceBox.getSelectionModel().getSelectedItem();
        if(!evidence.equals("")){
            network.setEvidence("drivenWheels",evidence);
        }
    }

    private void setNumberDoors(){
        String evidence=numberDoorsChoiceBox.getSelectionModel().getSelectedItem();
        if(!evidence.equals("")){
            network.setEvidence("make",evidence);
        }
    }

    private void setTransmission(){
        String evidence=transmissionChoiceBox.getSelectionModel().getSelectedItem();
        if(!evidence.equals("")){
            network.setEvidence("transmission",evidence);
        }
    }

    private void setCity(){
        String evidence=cityChoiceBox.getSelectionModel().getSelectedItem();
        if(!evidence.equals("")){
            network.setEvidence("city",evidence);
        }
    }

    private void setHighway(){
        String evidence=highwayChoiceBox.getSelectionModel().getSelectedItem();
        if(!evidence.equals("")){
            network.setEvidence("highway",evidence);
        }
    }

    private void setEngineHP(){
        String evidence=engineHPChoiceBox.getSelectionModel().getSelectedItem();
        if(!evidence.equals("")){
            network.setEvidence("engineHP",evidence);
        }
    }

    private void setEngineFuel(){
        String evidence=engineFuelChoiceBox.getSelectionModel().getSelectedItem();
        if(!evidence.equals("")){
            network.setEvidence("engineFuel",evidence);
        }
    }

    private void setEngineCylinders(){
        String evidence=engineCylindersChoiceBox.getSelectionModel().getSelectedItem();
        if(!evidence.equals("")){
            network.setEvidence("engineCylinders",evidence);
        }
    }
}