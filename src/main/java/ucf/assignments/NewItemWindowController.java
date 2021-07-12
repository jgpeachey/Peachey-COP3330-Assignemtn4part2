package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
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
        // make sure onItemAdded isn't empty
        if(onItemAdded!=null){
            //call on item added
            onItemAdded.addItem(new Item(nameTextField.getText(), descriptionTextField.getText(), datePicker.getValue(), false));
            //go back to main window
            ((Stage) saveButton.getScene().getWindow()).close();
        }
    }

    // set the controller for onItemAdded
    public void setOnItemAdded(MainWindowController.OnItemAdded onItemAdded){
        this.onItemAdded = onItemAdded;
    }
}
