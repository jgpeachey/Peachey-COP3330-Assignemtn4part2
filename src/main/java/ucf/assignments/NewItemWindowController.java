package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class NewItemWindowController {

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

    private MainWindowController.OnItemAdded onItemAdded;

    @FXML
    private void clickedSave(Event e) throws IOException {
        if (nameTextField.getText().equals("") || descriptionTextField.getText().equals("") || datePicker.getValue() == null){
            createDialogue("Please enter data for all fields");
        }
        else if (descriptionTextField.getText().length() > 256){
            createDialogue("Description cannot be longer than 256 characters");
        }
        else {
            // make sure onItemAdded isn't empty
            if (onItemAdded != null) {
                //call on item added
                onItemAdded.addItem(new Item(nameTextField.getText(), descriptionTextField.getText(), datePicker.getValue(), false));
                //go back to main window
                ((Stage) saveButton.getScene().getWindow()).close();
            }
        }
    }

    @FXML
    private void createDialogue(String message){
        //Creating a dialog
        Dialog<String> dialog = new Dialog<String>();
        //Setting the title
        dialog.setTitle("Dialog");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        //Setting the content of the dialog
        dialog.setContentText(message);
        //Adding buttons to the dialog pane
        dialog.getDialogPane().getButtonTypes().add(type);
        //show dialogue
        dialog.showAndWait();
    }

    // set the controller for onItemAdded
    public void setOnItemAdded(MainWindowController.OnItemAdded onItemAdded){
        this.onItemAdded = onItemAdded;
    }
}
