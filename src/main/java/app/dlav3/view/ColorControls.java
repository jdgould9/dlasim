package app.dlav3.view;

import app.dlav3.config.ColorConfig;
import app.dlav3.config.SimulationConfig;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
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
    public CheckBox gradientCheckBox;
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
        gradientCheckBox = new CheckBox();
        gradientCheckBox.setSelected(colorConfig.gradient);
        lowZColorPicker = new ColorPicker(colorConfig.lowZColor);
        highZColorPicker = new ColorPicker(colorConfig.highZColor);
        backgroundColorPicker = new ColorPicker(colorConfig.backgroundColor);
        opacityTextField = new TextField(Double.toString(colorConfig.opacity));
        gradientPreview = new Rectangle(125, 30);
        Stop[] stops = new Stop[]{new Stop(0, Color.BLUE), new Stop(1, Color.RED)};
        linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.REFLECT, stops);
        gradientPreview.setFill(linearGradient);

    }

    public ColorConfig buildColorConfigFromControls() {
        return new ColorConfig(
                this.getGradient(),
                this.getLowZColor(),
                this.getHighZColor(),
                this.getBackgroundColor(),
                this.getOpacity()
        );
    }

    public HBox getLayout(){
        //Render text and description
        VBox renderTextVBox = new VBox();
        renderTextVBox.setPadding(new Insets(30, 10, 30, 10));
        Text renderText = new Text("Render");
        renderText.setFont(new Font("Georgia", 36));
        Text renderDescriptionText = new Text("Control render parameters");
        renderDescriptionText.setFont(new Font("Georgia", 16));
        renderTextVBox.getChildren().addAll
                (
                        renderText, renderDescriptionText
                );


        //Render right controls
        VBox renderRightControlsVBox = new VBox();
        renderRightControlsVBox.setPadding(new Insets(30, 30, 30, 30));
        renderRightControlsVBox.getChildren().addAll
                (
                        gradientPreview, new Text("Gradient"), gradientCheckBox,
                        new Text("Low z color"), lowZColorPicker,
                        new Text("High z color"), highZColorPicker,
                        new Text("Background color"), backgroundColorPicker,
                        new Text("Opacity"), opacityTextField
                );

        //Render HBox
        HBox renderHBox = new HBox();
        renderHBox.getChildren().addAll(
                renderTextVBox,

                renderRightControlsVBox
        );
        return renderHBox;
    }

    public boolean getGradient() {
        return gradientCheckBox.isSelected();
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
