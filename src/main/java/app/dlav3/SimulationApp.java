package app.dlav3;

import app.dlav3.controller.AppController;
import javafx.application.Application;
import javafx.stage.Stage;


//TODO:
//  Stop control UI from freezing upon rendering
//  Time simulation/rendering
//  Add seed types and sizes
//  Allow simulation to export to table


public class SimulationApp extends Application {
    @Override
    public void start(Stage dlaStage) throws Exception {
        AppController appController = new AppController();
    }
}
