package app.dlav3.controller;

import app.dlav3.config.ColorConfig;
import app.dlav3.config.RenderConfig;
import app.dlav3.model.Simulation;
import app.dlav3.view.SimulationView;

public class RenderController {
    private RenderConfig renderConfig;
    private ColorConfig colorConfig;
    private SimulationView simulationView;

    public RenderController(){
        renderConfig=new RenderConfig();
        colorConfig=new ColorConfig();
        simulationView = new SimulationView();
    }
    public void renderSimulation(Simulation simulation){
        simulationView.renderSimulation(simulation, renderConfig, colorConfig);
    }

    public void setRenderConfig(RenderConfig renderConfig){
        this.renderConfig=renderConfig;
    }
    public void setColorConfig(ColorConfig colorConfig){
        this.colorConfig=colorConfig;
    }
    public void render(){

    }
}
