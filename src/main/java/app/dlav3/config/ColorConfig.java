package app.dlav3.config;

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

    public ColorConfig(){
        gradient=true;
        lowZColor=Color.WHITE;
        highZColor=Color.ORANGE;
        backgroundColor=Color.BLACK;
        opacity=1.0;
    }

    @Override
    public String toString() {
        return "ColorConfig{" +
                "gradient=" + gradient +
                ", lowZColor=" + lowZColor +
                ", highZColor=" + highZColor +
                ", backgroundColor=" + backgroundColor +
                ", opacity=" + opacity +
                '}';
    }
}
