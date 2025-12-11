package app.dlav3.config;
/*
Parameters
    renderWidth = SCREEN_WIDTH
    renderHeight = SCREEN_HEIGHT
    renderSeeds = whether or not to render seed particles
    renderActiveParticle = whether or not to render active particle
 */

public class RenderConfig {
    public int cellSize;
    public boolean renderStuckParticles;
    public boolean renderSeedParticles;
    public boolean renderActiveParticle;

    public RenderConfig(int cellSize, boolean renderStuckParticles, boolean renderSeedParticles, boolean renderActiveParticle) {
        this.cellSize = cellSize;
        this.renderStuckParticles = renderStuckParticles;
        this.renderSeedParticles = renderSeedParticles;
        this.renderActiveParticle = renderActiveParticle;
    }

    public RenderConfig() {
        cellSize=3;
        renderStuckParticles=true;
        renderSeedParticles=false;
        renderActiveParticle=false;
    }
}
