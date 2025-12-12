package app.dlav3.controller;

import app.dlav3.config.SimulationConfig;
import app.dlav3.model.Simulation;

public class SimulationController {
    private SimulationConfig simulationConfig;

    public SimulationController() {
        this.simulationConfig = new SimulationConfig();
    }

    public void setSimulationConfig(SimulationConfig simulationConfig) {
        this.simulationConfig = simulationConfig;
    }

    public Simulation runSimulation() {
        Simulation simulation = new Simulation(simulationConfig);
        simulation.dla();
        return simulation;
    }
}
