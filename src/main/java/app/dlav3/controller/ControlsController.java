package app.dlav3.controller;

import app.dlav3.config.ColorConfig;
import app.dlav3.config.RenderConfig;
import app.dlav3.config.SimulationConfig;
import app.dlav3.model.Simulation;
import app.dlav3.view.ControlsView;
import app.dlav3.view.SimulationControls;

public class ControlsController {
    //Controls ControlsView
    //Pulls info from controls panel to be used in rendercontroller and simulationcontroller
    private ControlsView controlsView;
    private SimulationController simulationController;
    private RenderController renderController;

    public ControlsController(SimulationController simulationController, RenderController renderController) {
        this.simulationController=simulationController;
        this.renderController=renderController;
        controlsView = new ControlsView(this, simulationController.getSimulationConfig(), renderController.getRenderConfig(), renderController.getColorConfig());
    }

    public void onSimulateAndRender(){
        syncConfigsWithControls();
        Simulation simulation = simulationController.simulate();
        renderController.render(simulation);
    }

    public void onLiveSimulateAndRender(){

    }

    private void syncConfigsWithControls(){
        simulationController.setSimulationConfig(controlsView.buildSimulationConfig());
        renderController.setRenderConfig(controlsView.buildRenderConfig());
        renderController.setColorConfig(controlsView.buildColorConfig());
    }
}
