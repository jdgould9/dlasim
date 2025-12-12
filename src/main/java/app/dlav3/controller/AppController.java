package app.dlav3.controller;

import app.dlav3.view.ControlsView;

public class AppController {
    private ControlsView controlsView;
    private RenderController renderController;
    private SimulationController simulationController;

    public AppController() {
        controlsView = new ControlsView(this);
        renderController = new RenderController();
        simulationController = new SimulationController();
    }

    public void onSimulateAndRender() {
        syncControllerConfigs();
        System.out.println(controlsView.buildSimulationConfig());
        System.out.println(controlsView.buildRenderConfig());
        System.out.println(controlsView.buildColorConfig());
        renderController.renderSimulation(simulationController.runSimulation());
    }

    public void syncControllerConfigs() {
        simulationController.setSimulationConfig(controlsView.buildSimulationConfig());
        renderController.setRenderConfig(controlsView.buildRenderConfig());
        renderController.setColorConfig(controlsView.buildColorConfig());

    }
}
