package app.dlav3.controller;

import app.dlav3.config.ColorConfig;
import app.dlav3.config.RenderConfig;
import app.dlav3.model.Simulation;
import app.dlav3.view.SimulationView;

public class RenderController {


    //Controls SimulationView
    private SimulationView simulationView;
    private RenderConfig renderConfig;
    private ColorConfig colorConfig;

    public RenderController() {
        this.renderConfig = new RenderConfig();
        this.colorConfig = new ColorConfig();
    }

    public void render(Simulation simulation) {
        simulationView.setRenderConfig(renderConfig);
        simulationView.setColorConfig(colorConfig);
        simulationView = new SimulationView(renderConfig, colorConfig, simulation.getSimulationWidth(), simulation.getSimulationHeight());
        simulationView.drawSimulation(simulation);
        simulationView.getStage().show();
    }

    public void setRenderConfig(RenderConfig renderConfig) {
        this.renderConfig = renderConfig;
    }

    public void setColorConfig(ColorConfig colorConfig) {
        this.colorConfig = colorConfig;
    }

    public ColorConfig getColorConfig() {
        return colorConfig;
    }

    public RenderConfig getRenderConfig() {
        return renderConfig;
    }
}
