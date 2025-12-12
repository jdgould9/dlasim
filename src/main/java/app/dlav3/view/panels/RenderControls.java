package app.dlav3.view.panels;

import app.dlav3.config.RenderConfig;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class RenderControls {
    public CheckBox renderStuckCellsCheckBox;
    public CheckBox renderSeedCellsCheckBox;
    public CheckBox renderActiveCellsCheckBox;

    public RenderControls(RenderConfig renderConfig) {
        initializeControls(renderConfig);
    }

    public void initializeControls(RenderConfig renderConfig) {
        renderStuckCellsCheckBox = new CheckBox();
        renderStuckCellsCheckBox.setSelected(renderConfig.renderStuckParticles);
        renderSeedCellsCheckBox = new CheckBox();
        renderSeedCellsCheckBox.setSelected(renderConfig.renderSeedParticles);
        renderActiveCellsCheckBox = new CheckBox();
        renderActiveCellsCheckBox.setSelected(renderConfig.renderActiveParticle);
    }

    public RenderConfig buildRenderConfigFromControls() {
        return new RenderConfig(
                this.getRenderStuckCells(),
                this.getRenderSeedCells(),
                this.getRenderActiveCells()
        );
    }

    public boolean getRenderStuckCells() {
        return renderStuckCellsCheckBox.isSelected();
    }

    public boolean getRenderSeedCells() {
        return renderSeedCellsCheckBox.isSelected();
    }

    public boolean getRenderActiveCells() {
        return renderActiveCellsCheckBox.isSelected();
    }

    public HBox getLayout() {
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

        //Render controls
        VBox renderControlsVBox = new VBox();
        renderControlsVBox.setPadding(new Insets(30, 30, 30, 30));
        renderControlsVBox.getChildren().addAll
                (
                        new Text("Render stuck cells"), renderStuckCellsCheckBox,
                        new Text("Render seed cells"), renderSeedCellsCheckBox,
                        new Text("Render active cell"), renderActiveCellsCheckBox
                );

        //Render HBox
        HBox renderHBox = new HBox();
        renderHBox.getChildren().addAll(
                renderTextVBox,
                renderControlsVBox
        );
        renderHBox.setBorder(Border.stroke(Color.BLACK));

        return renderHBox;
    }
}
