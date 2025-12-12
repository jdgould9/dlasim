package app.dlav3.view.panels;

import app.dlav3.config.ColorConfig;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ColorControls {

    public ColorPicker lowZColorPicker;
    public ColorPicker highZColorPicker;
    public ColorPicker backgroundColorPicker;
    public TextField opacityTextField;
    public Rectangle gradientPreview;
    public LinearGradient linearGradient;


    public ColorControls(ColorConfig colorConfig) {
        initializeControls(colorConfig);
    }

    private void initializeControls(ColorConfig colorConfig) {

        gradientPreview = new Rectangle(125, 30);
        Stop[] stops = new Stop[]{new Stop(0, colorConfig.highZColor), new Stop(1, colorConfig.lowZColor)};
        linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.REFLECT, stops);
        gradientPreview.setFill(linearGradient);

        lowZColorPicker = new ColorPicker(colorConfig.lowZColor);
        lowZColorPicker.setOnAction(event -> {
            stops[1] = new Stop(1, getLowZColor());
            linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.REFLECT, stops);
            gradientPreview.setFill(linearGradient);
        });

        highZColorPicker = new ColorPicker(colorConfig.highZColor);
        highZColorPicker.setOnAction(event -> {
            stops[0] = new Stop(0, getHighZColor());
            linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.REFLECT, stops);
            gradientPreview.setFill(linearGradient);
        });

        backgroundColorPicker = new ColorPicker(colorConfig.backgroundColor);
        opacityTextField = new TextField(Double.toString(colorConfig.opacity));
    }

    public ColorConfig buildColorConfigFromControls() {
        return new ColorConfig(
                this.getLowZColor(),
                this.getHighZColor(),
                this.getBackgroundColor(),
                this.getOpacity()
        );
    }

    public HBox getLayout() {
        //Render text and description
        VBox colorTextVBox = new VBox();
        colorTextVBox.setPadding(new Insets(30, 10, 30, 10));
        Text renderText = new Text("Color");
        renderText.setFont(new Font("Georgia", 36));
        Text renderDescriptionText = new Text("Control color parameters");
        renderDescriptionText.setFont(new Font("Georgia", 16));
        colorTextVBox.getChildren().addAll
                (
                        renderText, renderDescriptionText
                );


        VBox colorLeftControlsVBox = new VBox();
        colorLeftControlsVBox.setPadding(new Insets(30, 30, 30, 30));
        colorLeftControlsVBox.getChildren().addAll
                (
                        new Text("Opacity"), opacityTextField,
                        new Text("Gradient"), gradientPreview
                );

        VBox colorRightControlsVBox = new VBox();
        colorRightControlsVBox.setPadding(new Insets(30, 30, 30, 30));
        colorRightControlsVBox.getChildren().addAll
                (

                        new Text("Low z color"), lowZColorPicker,
                        new Text("High z color"), highZColorPicker,
                        new Text("Background color"), backgroundColorPicker
                );

        //Render HBox
        HBox colorHBox = new HBox();
        colorHBox.getChildren().addAll(
                colorTextVBox,
                colorLeftControlsVBox,
                colorRightControlsVBox
        );

        return colorHBox;
    }

    public Color getLowZColor() {
        return lowZColorPicker.getValue();
    }

    public Color getHighZColor() {
        return highZColorPicker.getValue();
    }

    public Color getBackgroundColor() {
        return backgroundColorPicker.getValue();
    }

    public double getOpacity() {
        return Double.parseDouble(opacityTextField.getText());
    }
}
