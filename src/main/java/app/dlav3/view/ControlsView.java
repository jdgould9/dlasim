package app.dlav3.view;

import app.dlav3.config.RenderConfig;
import app.dlav3.controller.ControlsController;
import app.dlav3.model.SeedType;
import app.dlav3.model.Simulation;
import app.dlav3.config.SimulationConfig;
import app.dlav3.config.ColorConfig;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;


public class ControlsView {

    private ControlsController controlsController;
    private final SimulationControls simulationControls;
    private final RenderControls renderControls;
    private final ColorControls colorControls;

    public ControlsView(ControlsController controlsController, SimulationConfig simulationConfig, RenderConfig renderConfig, ColorConfig colorConfig) {
        this.controlsController=controlsController;
        simulationControls = new SimulationControls(simulationConfig);
        renderControls = new RenderControls(renderConfig);
        colorControls = new ColorControls(colorConfig);
        buildControlsStage();
    }

    private void buildControlsStage() {
        Stage controlsStage = new Stage();
        VBox controlsVBox = new VBox();

        controlsVBox.getChildren().addAll
           (
                  simulationControls.getLayout(), renderControls.getLayout(), colorControls.getLayout(), getActionControlsLayout()
          );

        Scene controlsScene = new Scene(controlsVBox, 600, 1000);
        controlsStage.setScene(controlsScene);
        controlsStage.setTitle("Controls");
        controlsStage.setResizable(false);
        controlsStage.show();
    }

    private HBox getActionControlsLayout(){
        HBox simulateRenderSaveHBox = new HBox();

        Button simulateAndRenderButton = new Button("Simulate and render");
        simulateAndRenderButton.setOnMouseClicked(e->{controlsController.onSimulateAndRender();});

        Button saveRenderButton = new Button("Save render");
        saveRenderButton.setOnMouseClicked(mouseEvent -> {

        });

        simulateRenderSaveHBox.setAlignment(Pos.CENTER);
        simulateRenderSaveHBox.getChildren().addAll
                (
                        simulateAndRenderButton, saveRenderButton
                );

        return simulateRenderSaveHBox;

    }

    public SimulationConfig buildSimulationConfig() {
        return simulationControls.buildSimulationConfigFromControls();
    }

    public RenderConfig buildRenderConfig() {
        return renderControls.buildRenderConfigFromControls();
    }

    public ColorConfig buildColorConfig() {
        return colorControls.buildColorConfigFromControls();
    }


}
    /*
    private SimulationView simulationView;
    private ActionController actionController;

    private final SimulationControls simulationControls;
    private final RenderControls renderControls;
    private final ColorControls colorControls;


    private Stage controlsStage;


    public ControlsView(SimulationView simulationView, SimulationConfig simulationConfig, RenderConfig renderConfig, ColorConfig colorConfig) {
        this.simulationControls = new SimulationControls(simulationConfig);
        this.renderControls = new RenderControls(renderConfig);
        this.colorControls = new ColorControls(colorConfig);

        createControlsStage();
    }

    public SimulationConfig buildSimulationConfig() {
        return simulationControls.buildSimulationConfigFromControls();
    }

    public RenderConfig buildRenderConfig() {
        return renderControls.buildRenderConfigFromControls();
    }

    public ColorConfig buildColorConfig() {
        return colorControls.buildColorConfigFromControls();
    }

    public void setActionController(ActionController actionController) {
        this.actionController = actionController;
    }

    public Stage getStage() {
        return controlsStage;
    }

    private void createControlsStage() {
        controlsStage = new Stage();
        VBox controlsVBox = new VBox();

        //controlsVBox.getChildren().addAll
        //   (
        //          simulationControls.getLayout(), renderControls.getLayout(), colorControls.getLayout()
        //  );

        Scene controlsScene = new Scene(controlsVBox, 600, 550);
        controlsStage.setScene(controlsScene);
        controlsStage.setTitle("Controls");
        controlsStage.setResizable(false);

    }

}

    /*
    private Stage controlsStage;
    private SimulationView simulationView;

    private SimulationControls simulationControls;
    private RenderControls renderControls;
    private ColorControls colorControls;


    public ControlsView(SimulationView simulationView, SimulationConfig simulationConfig, RenderConfig renderConfig, ColorConfig colorConfig) {
        simulationControls = new SimulationControls(simulationConfig);
        renderControls = new RenderControls(renderConfig);
        colorControls = new ColorControls(colorConfig);

        this.controlsStage = createControlsStage();
        this.simulationView = simulationView;
    }

    public SimulationConfig buildSimulationConfig() {
        return simulationControls.buildSimulationConfigFromControls();
    }

    public RenderConfig buildRenderConfig() {
        return renderControls.buildRenderConfigFromControls();
    }

    public ColorConfig buildColorConfig() {
        return colorControls.buildColorConfigFromControls();
    }



    public Stage getStage() {
        return controlsStage;
    }

    private Stage createControlsStage() {
        Stage controlsStage = new Stage();
        VBox controlsVBox = new VBox();

        HBox simulationHBox = createSimulationControls();
        HBox renderHBox = createRenderControls();
        renderHBox.setBorder(Border.stroke(Color.LIGHTGRAY));
        HBox simulateRenderSaveHBox = createSimulateRenderHBox();

        controlsVBox.getChildren().addAll
                (
                        simulationHBox, renderHBox, simulateRenderSaveHBox
                );

        Scene controlsScene = new Scene(controlsVBox, 600, 550);

        controlsStage.setScene(controlsScene);
        controlsStage.setTitle("Controls");
        controlsStage.setResizable(false);
        return controlsStage;
    }

    private HBox createSimulationControls() {
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
                        new Text("Max iterations"), simulationControls.maxIterationsTextField,
                        new Text("Max random walk attempts"), simulationControls.maxRandomWalkAttemptsTextField,
                        new Text("Max fill ratio"), simulationControls.maxFillRatioTextField,
                        new Text("Particle sticking probability"), simulationControls.particleStickingProbabilityTextField
                );

        //Simulation right controls
        VBox simulationRightControlsVBox = new VBox();
        simulationRightControlsVBox.setPadding(new Insets(30, 30, 30, 30));
        simulationRightControlsVBox.getChildren().addAll
                (
                        new Text("Seed type"), simulationControls.seedTypeComboBox,
                        new Text("Random seed"), simulationControls.randomSeedTextField,
                        new Text("Number of seeds"), simulationControls.numberOfSeedsTextField
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

    private HBox createRenderControls() {
        //Render text and description
        VBox renderTextVBox = new VBox();
        renderTextVBox.setPadding(new Insets(30, 10, 30, 10));
        Text renderText = new Text("Render");
        renderText.setFont(new Font("Georgia", 36));
        Text renderDescriptionText = new Text("Control render parameters");
        renderDescriptionText.setFont(new Font("Georgia", 16));
        renderTextVBox.getChildren().addAll
                (
                        renderText, renderDescriptionText
                );

        //Render left controls
        VBox renderLeftControlsVBox = new VBox();
        renderLeftControlsVBox.setPadding(new Insets(30, 30, 30, 30));
        renderLeftControlsVBox.getChildren().addAll
                (
                        new Text("Render width"), renderControls.renderWidthTextField,
                        new Text("Render height"), renderControls.renderHeightTextField,
                        new Text("Cell size"), renderControls.cellSizeTextField,
                        new Text("Render stuck cells"), renderControls.renderStuckCellsCheckBox,
                        new Text("Render seed cells"), renderControls.renderSeedCellsCheckBox,
                        new Text("Render active cell"), renderControls.renderActiveCellsCheckBox
                );

        //Render right controls
        VBox renderRightControlsVBox = new VBox();
        renderRightControlsVBox.setPadding(new Insets(30, 30, 30, 30));
        renderRightControlsVBox.getChildren().addAll
                (
                        colorControls.gradientPreview, new Text("Gradient"), colorControls.gradientCheckBox,
                        new Text("Low z color"), colorControls.lowZColorPicker,
                        new Text("High z color"), colorControls.highZColorPicker,
                        new Text("Background color"), colorControls.backgroundColorPicker,
                        new Text("Opacity"), colorControls.opacityTextField
                );

        //Render HBox
        HBox renderHBox = new HBox();
        renderHBox.getChildren().addAll(
                renderTextVBox,
                renderLeftControlsVBox,
                renderRightControlsVBox
        );
        return renderHBox;
    }


    private HBox createSimulateRenderHBox() {
        HBox simulateRenderSaveHBox = new HBox();

        Button simulateAndRenderButton = new Button("Simulate and render");
        simulateAndRenderButton.setOnMouseClicked(mouseEvent -> {
            Simulation simulation = new Simulation(simulationConfig);
            simulation.dla();
            simulationView.drawSimulation(simulation);
            simulationView.getStage().show();

        });
        Button saveRenderButton = new Button("Save render");
        saveRenderButton.setOnMouseClicked(mouseEvent -> {


        });

        simulateRenderSaveHBox.setAlignment(Pos.TOP_CENTER);
        simulateRenderSaveHBox.getChildren().addAll
                (
                        simulateAndRenderButton, saveRenderButton
                );

        return simulateRenderSaveHBox;
    }


     */

