package app.dlav3.controller;

import app.dlav3.view.ControlsView;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class AppController {
    private ControlsView controlsView;
    private RenderController renderController;
    private SimulationController simulationController;
    private Canvas currentCanvas;

    public AppController() {
        controlsView = new ControlsView(this);
        renderController = new RenderController();
        simulationController = new SimulationController();
        currentCanvas = null;
    }

    public void onSimulateAndRender() {
        syncControllerConfigs();
        System.out.println(controlsView.buildSimulationConfig());
        System.out.println(controlsView.buildRenderConfig());
        System.out.println(controlsView.buildColorConfig());
        currentCanvas = renderController.renderSimulation(simulationController.runSimulation());
    }

    public void onSaveRender() {
        if (currentCanvas != null) {
            FileChooser fileChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
            fileChooser.getExtensionFilters().add(extFilter);

            File file = fileChooser.showSaveDialog(controlsView.getStage());
            if (file != null) {
                try {
                    WritableImage writableImage = new WritableImage((int) currentCanvas.getWidth(), (int) currentCanvas.getHeight());
                    currentCanvas.snapshot(null, writableImage);
                    RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                    ImageIO.write(renderedImage, "png", file);
                } catch (IOException ex) {
                    System.out.println("File saving error: " + ex);
                }
            }
        }
    }

    public void syncControllerConfigs() {
        simulationController.setSimulationConfig(controlsView.buildSimulationConfig());
        renderController.setRenderConfig(controlsView.buildRenderConfig());
        renderController.setColorConfig(controlsView.buildColorConfig());
    }


}
