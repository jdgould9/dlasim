package app.dlav3;

/*
Parameters
    simulationSeed = seed used for the Random object (-1 to disable)
    simulationWidth = SCREEN_WIDTH / CELL_SIZE
    simulationHeight = SCREEN_HEIGHT / CELL_SIZE
    numberOfSeeds = # of seeds placed during initialization
    maxIterations = max # of iterations dla can undergo before stopping (-1 to disable)
    maxRandomWalkAttempts = max # of attempts to random walk an active particle before resetting and creating a new active particle (-1 to disable)
    maxFillRatio = max ratio of empty to full particles before stopping. A fill ratio of 1.0 means all available particles (minus seed particles) are filled (-1.0 to disable)
    particleStickProbability = probability that a particle should stick to another (0.0 to 1.0)
 */
public class SimulationConfig{
    public int simulationWidth;
    public int simulationHeight;
    public long randomSeed;
    public int numberOfSeeds;
    public long maxIterations;
    public int maxRandomWalkAttempts;
    public double maxFillRatio;
    public double particleStickingProbability;

    public SimulationConfig(int simulationWidth, int simulationHeight, long randomSeed, int numberOfSeeds, long maxIterations, int maxRandomWalkAttempts, double maxFillRatio, double particleStickingProbability) {
        this.simulationWidth = simulationWidth;
        this.simulationHeight = simulationHeight;
        this.randomSeed = randomSeed;
        this.numberOfSeeds = numberOfSeeds;
        this.maxIterations = maxIterations;
        this.maxRandomWalkAttempts = maxRandomWalkAttempts;
        this.maxFillRatio = maxFillRatio;
        this.particleStickingProbability = particleStickingProbability;
    }
}


