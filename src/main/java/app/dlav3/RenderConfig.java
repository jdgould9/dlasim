package app.dlav3;
/*
Parameters
    renderWidth = SCREEN_WIDTH
    renderHeight = SCREEN_HEIGHT
    renderSeeds = whether or not to render seed particles
    renderActiveParticle = whether or not to render active particle
 */

public class RenderConfig{
    public int renderWidth;
    public int renderHeight;
    public int cellSize;
    public boolean renderStuckParticles;
    public boolean renderSeeds;
    public boolean renderActiveParticle;

    public RenderConfig(int renderWidth, int renderHeight, int cellSize, boolean renderStuckParticles, boolean renderSeeds, boolean renderActiveParticle) {
        this.renderWidth = renderWidth;
        this.renderHeight = renderHeight;
        this.cellSize = cellSize;
        this.renderStuckParticles = renderStuckParticles;
        this.renderSeeds = renderSeeds;
        this.renderActiveParticle = renderActiveParticle;
    }
}
