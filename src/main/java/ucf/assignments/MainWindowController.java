package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    ListCentral listCentral = new ListCentral();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //set column value types
        itemColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("description"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Item, LocalDate>("date"));
        markColumn.setCellValueFactory(new PropertyValueFactory<Item, Boolean>("mark"));

        //load data from list
        tableView.setItems(list);
    }

    //button set ups
    @FXML
    Button helpButton;
    @FXML
    Button newItemButton;
    @FXML
    Button editItemButton;
    @FXML
    Button removeItemButton;
    @FXML
    Button clearListButton;
    @FXML
    Button markCompleteButton;
    @FXML
    Button markIncompleteButton;
    @FXML
    Button sortButton;
    @FXML
    Button saveListButton;
    @FXML
    Button loadListButton;

    @FXML
    TableView<Item> tableView;
    @FXML
    private TableColumn<Item, String> itemColumn;
    @FXML
    private TableColumn<Item, String> descriptionColumn;
    @FXML
    private TableColumn<Item, LocalDate> dateColumn;
    @FXML
    private TableColumn<Item, Boolean> markColumn;

    ObservableList<Item> list = FXCollections.observableArrayList();

//button controls
    //load new windows
    @FXML
    private void clickedHelp(Event e) throws IOException {
        Stage stage = (Stage) helpButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("HelpWindow.fxml"));
        stage.setTitle("Help");
        stage.setScene(new Scene(root));
    }

    @FXML
    private void clickedNewItemButton(Event e) throws IOException {
        //open New Item Window
        Stage stage = (Stage) newItemButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("NewItemWindow.fxml"));
        stage.setTitle("New Item");
        stage.setScene(new Scene(root));
    }

    @FXML
    public void refreshTable(){
        tableView.setItems(list);
    }

    public void addToList(String name, String description, LocalDate date){
        //add new item to list
        list.add(new Item(name, description, date, false));
    }

    public void clickedSort(ActionEvent actionEvent) {
    }

    public void cilckedClearList(ActionEvent actionEvent) {
    }

    public void clickedRemoveItem(ActionEvent actionEvent) {
    }

    public void clickedMarkComplete(ActionEvent actionEvent) {
    }

    public void clickedMarkIncomplete(ActionEvent actionEvent) {
    }

    public void clickedEditItem(ActionEvent actionEvent) {
    }

    public void clickedSaveList(ActionEvent actionEvent) {
    }

    public void clickedLoadList(ActionEvent actionEvent) {
    }
}
