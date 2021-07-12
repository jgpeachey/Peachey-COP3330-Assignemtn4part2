package ucf.assignments;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelpWindowController {

    //button set up
    @FXML
    private Button doneButton;

    @FXML
    private void goToMainWindow(Event e) throws IOException {
        ((Stage) doneButton.getScene().getWindow()).close();
    }
}
