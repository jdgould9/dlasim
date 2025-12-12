package app.dlav3.config;

import javafx.scene.paint.Color;

public class ColorConfig {
    public Color lowZColor;
    public Color highZColor;
    public Color backgroundColor;
    public double opacity;

    public ColorConfig(Color lowZColor, Color highZColor, Color backgroundColor, double opacity) {
        this.lowZColor = lowZColor;
        this.highZColor = highZColor;
        this.backgroundColor = backgroundColor;
        this.opacity = opacity;
    }

    public ColorConfig() {
        lowZColor = Color.WHITE;
        highZColor = Color.ORANGE;
        backgroundColor = Color.BLACK;
        opacity = 1.0;
    }

    @Override
    public String toString() {
        return "ColorConfig{" +
                "lowZColor=" + lowZColor +
                ", highZColor=" + highZColor +
                ", backgroundColor=" + backgroundColor +
                ", opacity=" + opacity +
                '}';
    }
}
