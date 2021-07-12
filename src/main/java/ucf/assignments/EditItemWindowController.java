package ucf.assignments;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EditItemWindowController {
    ListCentral listCentral = new ListCentral();

    //button set up
    @FXML
    Button saveButton;
    //date picker set up
    @FXML
    DatePicker datePicker;
    //text field set ups
    @FXML
    TextField nameTextField;
    @FXML
    TextField descriptionTextField;
/*
    private MainWindowController.OnItemEdited onItemEdited;

    @FXML
    private void clickedSave(Event e) throws IOException {
        // make sure onItemEdited isn't empty
        if (onItemEdited != null) {
            //call on item edited
            onItemEdited.editItem(nameTextField.getText(), descriptionTextField.getText(), datePicker.getValue());
            //go back to main window
            ((Stage) saveButton.getScene().getWindow()).close();
        }
    }

    //set controller for onItemEdited
    public void setOnItemEdited(MainWindowController.OnItemEdited onItemEdited){
        this.onItemEdited = onItemEdited;
    }

 */
}


