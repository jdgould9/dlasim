package app.dlav3;

import app.dlav3.controller.AppController;
import javafx.application.Application;
import javafx.stage.Stage;


public class SimulationApp extends Application {
    @Override
    public void start(Stage dlaStage) throws Exception {
        AppController appController = new AppController();
    }
}
