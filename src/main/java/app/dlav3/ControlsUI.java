package app.dlav3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
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

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ControlsUI {
    private Stage controlsStage;
    private SimulationView simulationView;

    private SimulationConfig simulationConfig;
    private RenderConfig renderConfig;
    private ColorConfig colorConfig;


    public ControlsUI(SimulationView simulationView, SimulationConfig simulationConfig, RenderConfig renderConfig, ColorConfig colorConfig) {
        this.controlsStage = createControlsStage();
        this.simulationView = simulationView;

        this.simulationConfig = simulationConfig;
        this.renderConfig = renderConfig;
        this.colorConfig = colorConfig;
    }

    public Stage getStage() {
        return controlsStage;
    }

    private Stage createControlsStage() {
        Stage controlsStage = new Stage();
        VBox controlsVBox = new VBox();

        HBox simulationHBox = createSimulationHBox();
        HBox renderHBox = createRenderHBox();
        renderHBox.setBorder(Border.stroke(Color.LIGHTGRAY));
        HBox simulateRenderSaveHBox = createSimulateRenderHBox();

        controlsVBox.getChildren().addAll
                (
                        simulationHBox, renderHBox, simulateRenderSaveHBox
                );

        Scene controlsScene = new Scene(controlsVBox, 600, 525);

        controlsStage.setScene(controlsScene);
        controlsStage.setTitle("Controls");
        controlsStage.setResizable(false);
        return controlsStage;
    }

    private HBox createSimulationHBox() {
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

        TextField maxIterationsTextField = new TextField();
        TextField maxRandomWalkAttemptsTextField = new TextField();
        Slider maxFillRatioSlider = new Slider();
        Slider particleStickingProbabilitySlider = new Slider();

        simulationLeftControlsVBox.getChildren().addAll
                (
                        new Text("Max iterations"), maxIterationsTextField,
                        new Text("Max random walk attempts"), maxRandomWalkAttemptsTextField,
                        new Text("Max fill ratio"), maxFillRatioSlider,
                        new Text("Particle sticking probability"), particleStickingProbabilitySlider
                );

        //Simulation right controls
        VBox simulationRightControlsVBox = new VBox();
        simulationRightControlsVBox.setPadding(new Insets(30, 30, 30, 30));

        ComboBox<SeedType> seedTypeComboBox = new ComboBox<>();
        seedTypeComboBox.getItems().setAll(SeedType.values());
        TextField randomSeedTextField = new TextField();
        TextField numberOfSeedsTextField = new TextField();

        simulationRightControlsVBox.getChildren().addAll
                (
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

    private HBox createRenderHBox() {
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

        TextField renderWidthTextField = new TextField();
        TextField renderHeightTextField = new TextField();
        TextField cellSizeTextField = new TextField();
        CheckBox renderStuckCellsCheckBox = new CheckBox();
        CheckBox renderSeedCellsCheckBox = new CheckBox();
        CheckBox renderActiveCellsCheckBox = new CheckBox();

        renderLeftControlsVBox.getChildren().addAll
                (
                        new Text("Render width"), renderWidthTextField,
                        new Text("Render height"), renderHeightTextField,
                        new Text("Cell size"), cellSizeTextField,
                        new Text("Render stuck cells"), renderStuckCellsCheckBox,
                        new Text("Render seed cells"), renderSeedCellsCheckBox,
                        new Text("Render active cell"), renderActiveCellsCheckBox
                );

        //Render right controls
        VBox renderRightControlsVBox = new VBox();
        renderRightControlsVBox.setPadding(new Insets(30, 30, 30, 30));

        Rectangle gradientPreview = new Rectangle(125, 30);
        Stop[] stops = new Stop[]{new Stop(0, Color.BLUE), new Stop(1, Color.RED)};
        LinearGradient linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.REFLECT, stops);
        gradientPreview.setFill(linearGradient);
        CheckBox gradientCheckBox = new CheckBox();
        ColorPicker lowZColorPicker = new ColorPicker();
        ColorPicker highZColorPicker = new ColorPicker();
        ColorPicker backgroundColorPicker = new ColorPicker();
        Slider opacitySlider = new Slider();

        renderRightControlsVBox.getChildren().addAll
                (
                        gradientPreview, new Text("Gradient"), gradientCheckBox,
                        new Text("Low z color"), lowZColorPicker,
                        new Text("High z color"), highZColorPicker,
                        new Text("Background color"), backgroundColorPicker,
                        new Text("Opacity"), opacitySlider
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
            //Create simulation, run DLA, draw simulation, show drawing
            Simulation simulation = new Simulation(simulationConfig);
            simulation.dla();
            simulationView.drawSimulation(simulation);
            simulationView.getStage().show();

        });
        Button saveRenderButton = new Button("Save render");
        saveRenderButton.setOnMouseClicked(mouseEvent -> {
            WritableImage writableImage = new WritableImage((int)simulationView.getCanvas().getWidth(), (int)simulationView.getCanvas().getHeight());
            simulationView.getCanvas().snapshot(null, writableImage);


        });

        simulateRenderSaveHBox.setAlignment(Pos.CENTER);
        simulateRenderSaveHBox.getChildren().addAll
                (
                        simulateAndRenderButton, saveRenderButton
                );

        return simulateRenderSaveHBox;
    }
}
