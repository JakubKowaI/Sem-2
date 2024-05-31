import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.Dialog;
import javafx.scene.control.MenuItem;
import javafx.scene.input.*;
import javafx.scene.control.*;
/**
 * Class Guide is a class responsible for creating a guide dialog
 */
public class Guide extends MenuItem{
    /**
     * Constructor of Guide class
     */
    Guide(){
        super("Guide");
        /**
         * EventHandler responsible for showing the dialog
         */
        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Dialog<String> dialog = new Dialog<String>();
                dialog.setTitle("Guide");
                ButtonType type = new ButtonType("Got it!", ButtonData.CANCEL_CLOSE);
                dialog.setContentText("Use the buttons to spawn shapes\nYou can drag the shapes\nUse the scroll while having cursor on the shape to scale it\nPress the right mouse button to change color\nTo rotate the shape scroll while holding shift\nHave fun!");
                dialog.getDialogPane().getButtonTypes().add(type);
                dialog.showAndWait();
            }
        });
    }    
}
