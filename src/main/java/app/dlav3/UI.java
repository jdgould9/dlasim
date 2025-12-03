package app.dlav3;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;


import java.awt.Point;

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


//TODO:
//  Complete controls UI
//  Seprate classes into SimulationView and ControlsUI


public class UI extends Application {
    public final int SCREEN_WIDTH = 900;
    public final int SCREEN_HEIGHT = 900;
    public final int CELL_SIZE = 3;

    public final int SIMULATION_WIDTH = SCREEN_WIDTH / CELL_SIZE;
    public final int SIMULATION_HEIGHT = SCREEN_HEIGHT / CELL_SIZE;

    SimulationConfig simulationConfig =
            new SimulationConfig(SIMULATION_WIDTH, SIMULATION_HEIGHT, -1L, 4, 4_000_000_000L, 5000, 0.3, 1.0);
    RenderConfig renderConfig = new RenderConfig(SCREEN_WIDTH, SCREEN_HEIGHT, CELL_SIZE, true, false, false);
    ColorConfig colorConfig = new ColorConfig(true, Color.WHITE, Color.ORANGERED, Color.DARKBLUE, 1);

    @Override
    public void start(Stage dlaStage) throws Exception {
        //DLA view
        SimulationView simulationView = new SimulationView(renderConfig,colorConfig);
        simulationView.getStage().show();

        //Controls UI
        ControlsUI controlsUI = new ControlsUI(simulationView, simulationConfig, renderConfig, colorConfig);
        controlsUI.getStage().show();
    }
}
