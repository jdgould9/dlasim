package app.dlav3.view;

import app.dlav3.config.ColorConfig;
import app.dlav3.config.RenderConfig;
import app.dlav3.model.Simulation;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.awt.*;

public class SimulationView {
    private Stage simulationStage;

    private RenderConfig renderConfig;
    private ColorConfig colorConfig;
    private Canvas dlaCanvas;
    private GraphicsContext dlaCanvasGraphicsContext;

    public SimulationView(RenderConfig renderConfig, ColorConfig colorConfig) {
        this.renderConfig = renderConfig;
        this.colorConfig = colorConfig;

        this.dlaCanvas = new Canvas(renderConfig.renderWidth, renderConfig.renderHeight);
        this.dlaCanvasGraphicsContext = this.dlaCanvas.getGraphicsContext2D();

        this.simulationStage = createDlaStage();
    }

    public void setRenderConfig(RenderConfig renderConfig){
        this.renderConfig=renderConfig;
    }
    public void setColorConfig(ColorConfig colorConfig){
        this.colorConfig=colorConfig;
    }

    public Stage getStage() {
        return simulationStage;
    }

    public Stage createDlaStage() {
        Stage dlaStage = new Stage();

        Pane dlaPane = new Pane(dlaCanvas);

        dlaStage.setScene(new Scene(dlaPane, renderConfig.renderWidth, renderConfig.renderHeight));
        dlaStage.setResizable(false);
        dlaStage.setTitle("Diffusion-limited Aggregation Simulation");
        return dlaStage;
    }

    public void drawSimulation(Simulation simulation) {
        dlaCanvasGraphicsContext.setFill(colorConfig.backgroundColor);
        dlaCanvasGraphicsContext.fillRect(0, 0, renderConfig.renderWidth, renderConfig.renderHeight);
        int[][] particleField = simulation.getParticleField();
        Point activeParticle = simulation.getActiveParticle();

        if (renderConfig.renderStuckParticles) {
            drawStuckParticles(particleField, findMinZAndMaxZ(particleField), colorConfig, dlaCanvasGraphicsContext);
        }
        if (renderConfig.renderSeedParticles) {
            drawSeeds(particleField, dlaCanvasGraphicsContext);
        }
        if (renderConfig.renderActiveParticle) {
            drawActiveParticle(activeParticle, dlaCanvasGraphicsContext);
        }
    }

    private void drawStuckParticles(int[][] particleField, Pair<Integer, Integer> minZMaxZ, ColorConfig colorConfig, GraphicsContext gc) {
        int minZ = minZMaxZ.getKey();
        int maxZ = minZMaxZ.getValue();
        for (int r = 0; r < particleField.length; r++) {
            for (int c = 0; c < particleField[r].length; c++) {
                int z = particleField[r][c];
                if (z > 0) {
                    double normalizedZ = normalizeZValue(z, minZ, maxZ);

                    javafx.scene.paint.Color gradientColor = calculateGradientColor(colorConfig.lowZColor, colorConfig.highZColor, normalizedZ, colorConfig.opacity);
                    gc.setFill(gradientColor);
                    gc.fillRect(r * renderConfig.cellSize, c * renderConfig.cellSize, renderConfig.cellSize, renderConfig.cellSize);
                }
            }
        }
    }

    private javafx.scene.paint.Color calculateGradientColor(javafx.scene.paint.Color lowZColor, javafx.scene.paint.Color highZColor, double normalizedZ, double opacity) {
        //result = color1_channel + percent * (color2_channel, and color1_channel) to find gradient
        double gradientRed = lowZColor.getRed() + normalizedZ * (highZColor.getRed() - lowZColor.getRed());
        double gradientGreen = lowZColor.getGreen() + normalizedZ * (highZColor.getGreen() - lowZColor.getGreen());
        double gradientBlue = lowZColor.getBlue() + normalizedZ * (highZColor.getBlue() - lowZColor.getBlue());

        return new javafx.scene.paint.Color(gradientRed, gradientGreen, gradientBlue, opacity);
    }

    private void drawSeeds(int[][] particleField, GraphicsContext gc) {
        for (int r = 0; r < particleField.length; r++) {
            for (int c = 0; c < particleField[r].length; c++) {
                int z = particleField[r][c];
                if (z == 1) {
                    gc.setFill(javafx.scene.paint.Color.RED);
                    gc.fillRect(r * renderConfig.cellSize, c * renderConfig.cellSize, renderConfig.cellSize, renderConfig.cellSize);
                }
            }
        }
    }

    private void drawActiveParticle(Point activeParticle, GraphicsContext gc) {
        gc.setFill(Color.BLUE);
        gc.fillRect(activeParticle.x * renderConfig.cellSize, activeParticle.y * renderConfig.cellSize, renderConfig.cellSize, renderConfig.cellSize);
    }

    private Pair<Integer, Integer> findMinZAndMaxZ(int[][] particleField) {
        int maxZ = particleField[0][0];
        int minZ = particleField[0][0];

        for (int[] ints : particleField) {
            for (int z : ints) {
                if (z > maxZ) {
                    maxZ = z;
                }
                if (z < minZ) {
                    minZ = z;
                }
            }
        }
        return new Pair<Integer, Integer>(minZ, maxZ);
    }

    private double normalizeZValue(int z, int minZ, int maxZ) {
        return (double) (z - minZ) / (maxZ - minZ);
    }
}
