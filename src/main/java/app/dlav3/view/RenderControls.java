package app.dlav3.view;

import app.dlav3.config.RenderConfig;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class RenderControls {
    public TextField renderHeightTextField;
    public TextField renderWidthTextField;
    public TextField cellSizeTextField;
    public CheckBox renderStuckCellsCheckBox;
    public CheckBox renderSeedCellsCheckBox;
    public CheckBox renderActiveCellsCheckBox;

    public RenderControls(RenderConfig renderConfig) {
        initializeControls(renderConfig);
    }

    public void initializeControls(RenderConfig renderConfig) {
        renderHeightTextField = new TextField(Integer.toString(renderConfig.renderHeight));
        renderWidthTextField = new TextField(Integer.toString(renderConfig.renderWidth));
        cellSizeTextField = new TextField(Integer.toString(renderConfig.cellSize));
        renderStuckCellsCheckBox = new CheckBox();
        renderStuckCellsCheckBox.setSelected(renderConfig.renderStuckParticles);
        renderSeedCellsCheckBox = new CheckBox();
        renderSeedCellsCheckBox.setSelected(renderConfig.renderSeedParticles);
        renderActiveCellsCheckBox = new CheckBox();
        renderActiveCellsCheckBox.setSelected(renderConfig.renderActiveParticle);
    }

    public RenderConfig buildRenderConfigFromControls() {
        return new RenderConfig(
                this.getRenderWidth(),
                this.getRenderWidth(),
                this.getCellSize(),
                this.getRenderStuckCells(),
                this.getRenderSeedCells(),
                this.getRenderActiveCells()
        );
    }


    public int getRenderHeight() {
        return Integer.parseInt(renderHeightTextField.getText());
    }

    public int getRenderWidth() {
        return Integer.parseInt(renderWidthTextField.getText());
    }

    public int getCellSize() {
        return Integer.parseInt(cellSizeTextField.getText());
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

        //Render left controls
        VBox renderLeftControlsVBox = new VBox();
        renderLeftControlsVBox.setPadding(new Insets(30, 30, 30, 30));
        renderLeftControlsVBox.getChildren().addAll
                (
                        new Text("Render width"), renderWidthTextField,
                        new Text("Render height"), renderHeightTextField,
                        new Text("Cell size"), cellSizeTextField,
                        new Text("Render stuck cells"), renderStuckCellsCheckBox,
                        new Text("Render seed cells"), renderSeedCellsCheckBox,
                        new Text("Render active cell"), renderActiveCellsCheckBox
                );



        //Render HBox
        HBox renderHBox = new HBox();
        renderHBox.getChildren().addAll(
                renderTextVBox,
                renderLeftControlsVBox

        );
        return renderHBox;
    }
}
