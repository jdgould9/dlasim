package app.dlav3;

import app.dlav3.config.ColorConfig;
import app.dlav3.config.RenderConfig;
import app.dlav3.config.SimulationConfig;
import app.dlav3.controller.AppController;
import app.dlav3.model.Simulation;
import app.dlav3.view.ControlsView;
import app.dlav3.view.SimulationView;
import javafx.application.Application;
import javafx.scene.paint.*;
import javafx.stage.Stage;


import static javafx.scene.paint.Color.hsb;

//TODO: IMAGING
//  Allow final drawing to be exported as a high quality image
//  Calculate render time
//  Allow real time render? Or maybe a 'slideshow' of actual hits... See: https://www.reddit.com/r/generative/comments/vz1mxr/diffusionlimited_aggregation_python/
//TODO: SIMULATION
//  SimulationConfig - Add critical distance
//  SimulationConfig - Add ability to 'loop' simulation? So when particle hits the edge, instead of respawning, it appears at opposite edge
//  Add different seed types (enum?) and size - Square, Circle, Triangle, Edges, Center points, random points
//  Calculate simulation time
//  Allow export of simulation info as table of xyz coordinates? What does blender and other 3d software use? https://en.wikipedia.org/wiki/Wavefront_.obj_file
//TODO: UI
//  Complete controls UI

/// 12/10/25
//TODO: IMPORTANT!!!!!!
//  Complete controls UI
//  Split controls UI into Model, View, Controller
//  Stop control UI from freezing upon rendering
//  Clean up because this is kind of shit
//  Allow for image export
//  Time simulation/rendering
//  Add seed types and sizes
//  Allow simulation to export to table



public class SimulationApp extends Application {
    @Override
    public void start(Stage dlaStage) throws Exception {
        //SimulationConfig simulationConfig = new SimulationConfig();
        //Simulation sim = new Simulation(simulationConfig);
        //sim.dla();
        //SimulationView sv = new SimulationView();
        //sv.renderSimulation(sim, new RenderConfig(), new ColorConfig());
        AppController appController = new AppController();




    }
}
