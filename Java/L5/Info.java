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
 * Class Info is a class responsible for showing info dialog
 */
public class Info extends MenuItem {
    /**
     * Constructor of Guide class
     */
    Info(){
    super("Info");
    /**
     * EventHandler responsible for showing the dialog
     */
    setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Dialog<String> dialog = new Dialog<String>();
            dialog.setTitle("Info");
            ButtonType type = new ButtonType("Now i know!", ButtonData.CANCEL_CLOSE);
            dialog.setContentText("Paint 7D\nBrought to you to show you some shapes\nMade by: Jacob Kowal");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
    });
}
}
