package app.dlav3;

import javafx.scene.paint.Color;

public class ColorConfig{
    public boolean gradient;
    public Color lowZColor;
    public Color highZColor;
    public Color backgroundColor;
    public double opacity;

    public ColorConfig(boolean gradient, Color lowZColor, Color highZColor, Color backgroundColor, double opacity) {
        this.gradient = gradient;
        this.lowZColor = lowZColor;
        this.highZColor = highZColor;
        this.backgroundColor = backgroundColor;
        this.opacity = opacity;
    }
}
