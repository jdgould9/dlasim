package app.dlav3.view;

import app.dlav3.config.RenderConfig;
import app.dlav3.config.SimulationConfig;
import app.dlav3.config.ColorConfig;
import app.dlav3.controller.AppController;
import app.dlav3.view.panels.ColorControls;
import app.dlav3.view.panels.RenderControls;
import app.dlav3.view.panels.SimulationControls;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ControlsView {

    private final SimulationControls simulationControls;
    private final RenderControls renderControls;
    private final ColorControls colorControls;
    private final AppController appController;

    public ControlsView(AppController appController) {
        simulationControls = new SimulationControls(new SimulationConfig());
        renderControls = new RenderControls(new RenderConfig());
        colorControls = new ColorControls(new ColorConfig());
        this.appController = appController;
        buildControlsStage();
    }

    private void buildControlsStage() {
        Stage controlsStage = new Stage();
        VBox controlsVBox = new VBox();

        controlsVBox.getChildren().addAll
           (
                  simulationControls.getLayout(), renderControls.getLayout(), colorControls.getLayout(), getActionControlsLayout()
          );

        Scene controlsScene = new Scene(controlsVBox, 650, 710);
        controlsStage.setScene(controlsScene);
        controlsStage.setTitle("Controls");
        controlsStage.setResizable(false);
        controlsStage.show();
    }

    private HBox getActionControlsLayout(){
        HBox simulateRenderSaveHBox = new HBox();

        Button simulateAndRenderButton = new Button("Simulate and render");
        //simulateAndRenderButton.setOnMouseClicked(e->{controlsController.onSimulateAndRender();});
        simulateAndRenderButton.setOnMouseClicked(event -> {
            appController.onSimulateAndRender();
        });

        Button saveRenderButton = new Button("Save render");

        saveRenderButton.setOnMouseClicked(mouseEvent -> {

        });

        simulateRenderSaveHBox.setAlignment(Pos.BOTTOM_CENTER);
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

