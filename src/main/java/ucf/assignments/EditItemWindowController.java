/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 John Peachey
 */

package ucf.assignments;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class EditItemWindowController {
    ListCentral listCentral = new ListCentral();

    //button set up
    @FXML
    Button saveEditButton;
    //date picker set up
    @FXML
    DatePicker datePicker;
    //text field set ups
    @FXML
    TextField nameTextField;
    @FXML
    TextField descriptionTextField;

    private MainWindowController.OnItemEdited onItemEdited;

    @FXML
    private void clickedEditSave(Event e) throws IOException {
        if (nameTextField.getText().equals("") || descriptionTextField.getText().equals("") || datePicker.getValue() == null) {
            createDialogue("Please enter data for all fields");
        } else if (descriptionTextField.getText().length() > 256) {
            createDialogue("Description cannot be longer than 256 characters");
        } else {
            // make sure onItemEdited isn't empty
            if (onItemEdited != null) {
                //call on item edited
                onItemEdited.editItem(nameTextField.getText(), descriptionTextField.getText(), datePicker.getValue());
                //go back to main window
                ((Stage) saveEditButton.getScene().getWindow()).close();
            }
        }
    }

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

    //set controller for onItemEdited
    public void setOnItemEdited(MainWindowController.OnItemEdited onItemEdited){
        this.onItemEdited = onItemEdited;
    }

}


