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

public class ItemWindowController {

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

    @FXML
    private void clickedSave(Event e) throws IOException {
        //add item by calling addItem from listCentral
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Scene mainScene = new Scene(loader.load());
        MainWindowController controller =  loader.getController();
        controller.addToList(nameTextField.getText(), descriptionTextField.getText(), datePicker.getValue());
        //listCentral.addItem(nameTextField.getText(), descriptionTextField.getText(), datePicker.getValue());
        //go back to main window
        goBack();
    }

    @FXML
    private void goBack() throws IOException {
        Stage stage = (Stage) saveButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        stage.setTitle("Todo List");
        stage.setScene(new Scene(root));
    }
}
