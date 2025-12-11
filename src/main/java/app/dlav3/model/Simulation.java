package app.dlav3.model;

import app.dlav3.config.SimulationConfig;

import java.awt.*;
import java.util.Random;

public class Simulation {
    /*
    Simulation
        particleField = 2d array of particles, 0 = empty, 1 = dead particle, 2 = seed
        activeParticle = 2d point, keeps track of the active randomly walking particle
     */
    private int[][] particleField;
    private Point activeParticle;
    private Random random;
    private SimulationConfig simulationConfig;

    private static final int[][] DIRECTIONS = {
            {-1, -1}, {0, -1}, {1, -1},
            {-1, 0},           {1, 0},
            {-1, 1},  {0, 1},  {1, 1}
    };

    /*
    Helpers
        currentNumDeadParticles = current # of dead particles within the particle field
        currentIteration = current iteration #
        currentRandomWalkAttempts = current # of random walk attempts taken before hitting max # of random walk attempts, whereupon currentRandomWalkAttempts resets
     */
    private int currentNumDeadParticles;
    private long currentIteration;
    private int currentRandomWalkAttempts;

    public Simulation(SimulationConfig simulationConfig) {
        this.simulationConfig = simulationConfig;

        this.currentIteration = 0L;
        this.currentRandomWalkAttempts = 0;

        setRandomSeed();
        particleField = new int[simulationConfig.simulationWidth][simulationConfig.simulationHeight];
        activeParticle = new Point(-1, -1);
        placeSeed(simulationConfig.numberOfSeeds);
        placeActiveParticle();
    }

    public void dla() {
        while (!isFieldFull() && checkParameterMaxIterations() && checkParameterMaxFillRatio()) {
            int z = detectCollision();
            if (z > 0) {
                stickParticle(z);
                placeActiveParticle();
                resetCurrentRandomWalkAttempts();
            } else {
                if (checkParameterMaxRandomWalkAttempts()) {
                    randomWalk();
                } else {
                    placeActiveParticle();
                    resetCurrentRandomWalkAttempts();
                }
            }
            if (currentIteration % 100_000 == 0) {
                System.out.println("Progress: " + currentIteration);
            }
            currentIteration++;
        }
        System.out.println("Ending fill ratio: " + getFillRatio());
        System.out.println("Ending iteration: " + currentIteration);
    }



    private void setRandomSeed() {
        if (simulationConfig.randomSeed == -1L) {
            random = new Random();
        } else {
            random = new Random(simulationConfig.randomSeed);
        }
    }

    private boolean checkParameterMaxIterations() {
        if (simulationConfig.maxIterations == -1) {
            return true;
        } else return currentIteration <= simulationConfig.maxIterations;
    }

    private boolean checkParameterMaxFillRatio() {
        if (simulationConfig.maxFillRatio == -1.0) {
            return true;
        } else return getFillRatio() <= simulationConfig.maxFillRatio;

    }

    private boolean checkParameterMaxRandomWalkAttempts() {
        if (simulationConfig.maxRandomWalkAttempts == -1) {
            return true;
        } else return currentRandomWalkAttempts <= simulationConfig.maxRandomWalkAttempts;
    }

    private void resetCurrentRandomWalkAttempts() {
        currentRandomWalkAttempts = 0;
    }

    private void placeSeed(int numSeeds) {
        int placedSeeds = 0;
        while (placedSeeds < numSeeds) {
            int x = random.nextInt(simulationConfig.simulationWidth);
            int y = random.nextInt(simulationConfig.simulationHeight);
            if (particleField[x][y] == 0) {
                particleField[x][y] = 1;
                placedSeeds++;
            }
        }
    }

    private void stickParticle(int z) {
        if (simulationConfig.particleStickingProbability > random.nextDouble(1)) {
            particleField[activeParticle.x][activeParticle.y] = z + 1;
            currentNumDeadParticles++;
        }
    }

    private void placeActiveParticle() {
        if (!isFieldFull()) {
            while (true) {
                int x = random.nextInt(simulationConfig.simulationWidth);
                int y = random.nextInt(simulationConfig.simulationHeight);
                if (particleField[x][y] == 0) {
                    activeParticle.setLocation(x, y);
                    return;
                }
            }
        }
    }

    private boolean isFieldFull() {
        return getFillRatio() == 1.0;
    }

    private double getFillRatio() {
        int maxAvailableParticlesInField = (simulationConfig.simulationWidth * simulationConfig.simulationHeight) - simulationConfig.numberOfSeeds;
        return (double) currentNumDeadParticles / maxAvailableParticlesInField;
    }

    private void randomWalk() {
        currentRandomWalkAttempts++;
        int dx = random.nextInt(3) - 1; //-1, 0, 1
        int dy = random.nextInt(3) - 1;
        if (isValidPos(activeParticle.x + dx, activeParticle.y + dy)) {
            activeParticle.setLocation(activeParticle.x + dx, activeParticle.y + dy);
        }
    }

    private int detectCollision() {
        int x = activeParticle.x;
        int y = activeParticle.y;



        for (int[] direction : DIRECTIONS) {
            int dx = direction[0];
            int dy = direction[1];
            if (isValidPos(x + dx, y + dy) && particleField[x + dx][y + dy] > 0) {
                return particleField[x + dx][y + dy];
            }
        }
        return -1;
    }

    private boolean isValidPos(int x, int y) {
        return x >= 0 && y >= 0 && x < simulationConfig.simulationWidth && y < simulationConfig.simulationHeight;
    }

    public int[][] getParticleField() {
        return particleField;
    }

    public Point getActiveParticle() {
        return activeParticle;
    }

    public int getCurrentNumDeadParticles(){
        return currentNumDeadParticles;
    }
}
