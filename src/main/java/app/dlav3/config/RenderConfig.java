package app.dlav3.config;

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
        renderStuckParticles = true;
        renderSeedParticles = false;
        renderActiveParticle = false;
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
