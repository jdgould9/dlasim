package app.dlav3.controller;

import app.dlav3.config.ColorConfig;
import app.dlav3.config.RenderConfig;
import app.dlav3.model.Simulation;
import app.dlav3.view.SimulationView;
import javafx.scene.canvas.Canvas;

public class RenderController {
    private RenderConfig renderConfig;
    private ColorConfig colorConfig;
    private SimulationView simulationView;

    public RenderController() {
        renderConfig = new RenderConfig();
        colorConfig = new ColorConfig();
        simulationView = new SimulationView();
    }

    public Canvas renderSimulation(Simulation simulation) {
        return simulationView.renderSimulation(simulation, renderConfig, colorConfig);
    }

    public void saveRender() {

    }

    public void setRenderConfig(RenderConfig renderConfig) {
        this.renderConfig = renderConfig;
    }

    public void setColorConfig(ColorConfig colorConfig) {
        this.colorConfig = colorConfig;
    }

}
