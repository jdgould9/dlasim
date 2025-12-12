package app.dlav3.config;
/*
Parameters
    renderWidth = SCREEN_WIDTH
    renderHeight = SCREEN_HEIGHT
    renderSeeds = whether or not to render seed particles
    renderActiveParticle = whether or not to render active particle
 */

public class RenderConfig {
    public boolean renderStuckParticles;
    public boolean renderSeedParticles;
    public boolean renderActiveParticle;

    public RenderConfig(boolean renderStuckParticles, boolean renderSeedParticles, boolean renderActiveParticle) {
        this.renderStuckParticles = renderStuckParticles;
        this.renderSeedParticles = renderSeedParticles;
        this.renderActiveParticle = renderActiveParticle;
    }

    public RenderConfig() {
        renderStuckParticles=true;
        renderSeedParticles=false;
        renderActiveParticle=false;
    }

    @Override
    public String toString() {
        return "RenderConfig{" +
                "renderStuckParticles=" + renderStuckParticles +
                ", renderSeedParticles=" + renderSeedParticles +
                ", renderActiveParticle=" + renderActiveParticle +
                '}';
    }
}
