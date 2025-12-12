package app.dlav3.view.panels;

import app.dlav3.config.SimulationConfig;
import app.dlav3.model.SeedType;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class SimulationControls {
    public TextField simulationWidthTextField;
    public TextField simulationHeightTextField;
    public TextField simulationCellSizeTextField;
    public TextField maxIterationsTextField;
    public TextField maxRandomWalkAttemptsTextField;
    public TextField maxFillRatioTextField;
    public TextField particleStickingProbabilityTextField;

    public ComboBox<SeedType> seedTypeComboBox;
    public TextField randomSeedTextField;
    public TextField numberOfSeedsTextField;


    public SimulationControls(SimulationConfig simulationConfig) {
        initializeControls(simulationConfig);
    }

    private void initializeControls(SimulationConfig simulationConfig) {
        simulationWidthTextField = new TextField(Integer.toString(simulationConfig.simulationWidth));
        simulationHeightTextField = new TextField(Integer.toString(simulationConfig.simulationHeight));
        simulationCellSizeTextField = new TextField(Integer.toString(simulationConfig.simulationCellSize));
        maxIterationsTextField = new TextField(Long.toString(simulationConfig.maxIterations));
        maxRandomWalkAttemptsTextField = new TextField(Integer.toString(simulationConfig.maxRandomWalkAttempts));
        maxFillRatioTextField = new TextField(Double.toString(simulationConfig.maxFillRatio));
        particleStickingProbabilityTextField = new TextField(Double.toString(simulationConfig.particleStickingProbability));

        seedTypeComboBox = new ComboBox<>();
        seedTypeComboBox.getItems().setAll(SeedType.values());
        seedTypeComboBox.getSelectionModel().selectFirst();
        randomSeedTextField = new TextField(Long.toString(simulationConfig.randomSeed));
        numberOfSeedsTextField = new TextField(Integer.toString(simulationConfig.numberOfSeeds));
    }

    public HBox getLayout() {
        //Simulation text and description
        VBox simulationTextVBox = new VBox();
        simulationTextVBox.setPadding(new Insets(30, 10, 30, 10));
        Text simulationText = new Text("Simulation");
        simulationText.setFont(new Font("Georgia", 36));
        Text simulationDescriptionText = new Text("Control simulation parameters");
        simulationDescriptionText.setFont(new Font("Georgia", 16));
        simulationTextVBox.getChildren().addAll
                (
                        simulationText, simulationDescriptionText
                );

        //Simulation left controls
        VBox simulationLeftControlsVBox = new VBox();
        simulationLeftControlsVBox.setPadding(new Insets(30, 30, 30, 30));
        simulationLeftControlsVBox.getChildren().addAll
                (
                        new Text("Simulation width"), simulationWidthTextField,
                        new Text("Simulation height"), simulationHeightTextField,
                        new Text("Simulation cell size"), simulationCellSizeTextField,
                        new Text("Max iterations"), maxIterationsTextField,
                        new Text("Max random walk attempts"), maxRandomWalkAttemptsTextField

                );

        //Simulation right controls
        VBox simulationRightControlsVBox = new VBox();
        simulationRightControlsVBox.setPadding(new Insets(30, 30, 30, 30));
        simulationRightControlsVBox.getChildren().addAll
                (
                        new Text("Max fill ratio"), maxFillRatioTextField,
                        new Text("Particle sticking probability"), particleStickingProbabilityTextField,
                        new Text("Seed type"), seedTypeComboBox,
                        new Text("Random seed"), randomSeedTextField,
                        new Text("Number of seeds"), numberOfSeedsTextField
                );

        //Simulation HBox
        HBox simulationHBox = new HBox();
        simulationHBox.getChildren().addAll
                (
                        simulationTextVBox,
                        simulationLeftControlsVBox,
                        simulationRightControlsVBox
                );

        return simulationHBox;
    }

    public SimulationConfig buildSimulationConfigFromControls() {
        return new SimulationConfig(
                this.getSimulationCellSize(),
                this.getSimulationWidth(),
                this.getSimulationHeight(),
                this.getRandomSeed(),
                this.getNumberOfSeeds(),
                this.getMaxIterations(),
                this.getMaxRandomWalkAttempts(),
                this.getMaxFillRatio(),
                this.getParticleStickingProbability(),
                this.getSeedType()
        );
    }

    public int getSimulationWidth() {
        return Integer.parseInt(simulationWidthTextField.getText());
    }

    public int getSimulationHeight() {
        return Integer.parseInt(simulationHeightTextField.getText());
    }

    public int getSimulationCellSize() {
        return Integer.parseInt(simulationCellSizeTextField.getText());
    }

    public long getMaxIterations() {
        return Long.parseLong(maxIterationsTextField.getText());
    }

    public int getMaxRandomWalkAttempts() {
        return Integer.parseInt(maxRandomWalkAttemptsTextField.getText());
    }

    public double getMaxFillRatio() {
        return Double.parseDouble(maxFillRatioTextField.getText());
    }

    public double getParticleStickingProbability() {
        return Double.parseDouble(particleStickingProbabilityTextField.getText());
    }

    public long getRandomSeed() {
        return Long.parseLong(randomSeedTextField.getText());
    }

    public int getNumberOfSeeds() {
        return Integer.parseInt(numberOfSeedsTextField.getText());
    }

    public SeedType getSeedType(){
        return seedTypeComboBox.getValue();
    }


}
