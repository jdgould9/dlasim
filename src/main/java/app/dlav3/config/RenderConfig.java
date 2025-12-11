package app.dlav3.config;
/*
Parameters
    renderWidth = SCREEN_WIDTH
    renderHeight = SCREEN_HEIGHT
    renderSeeds = whether or not to render seed particles
    renderActiveParticle = whether or not to render active particle
 */

public class RenderConfig {
    public int renderWidth;
    public int renderHeight;
    public int cellSize;
    public boolean renderStuckParticles;
    public boolean renderSeedParticles;
    public boolean renderActiveParticle;

    public RenderConfig(int renderWidth, int renderHeight, int cellSize, boolean renderStuckParticles, boolean renderSeedParticles, boolean renderActiveParticle) {
        this.renderWidth = renderWidth;
        this.renderHeight = renderHeight;
        this.cellSize = cellSize;
        this.renderStuckParticles = renderStuckParticles;
        this.renderSeedParticles = renderSeedParticles;
        this.renderActiveParticle = renderActiveParticle;
    }

    public RenderConfig() {
        renderWidth=900;
        renderHeight=900;
        cellSize=3;
        renderStuckParticles=true;
        renderSeedParticles=false;
        renderActiveParticle=false;
    }
}
