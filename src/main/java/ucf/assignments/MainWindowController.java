package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    ListCentral listCentral = new ListCentral();


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

    @FXML
    private ChoiceBox<String> choiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //set up choice box
        choiceBox.getItems().add("All");
        choiceBox.getItems().add("Completed");
        choiceBox.getItems().add("Incomplete");
        //set column value types
        itemColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("description"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Item, LocalDate>("date"));
        markColumn.setCellValueFactory(new PropertyValueFactory<Item, Boolean>("mark"));

        //load data from list
        tableView.setItems(listCentral.getList());
    }

//button controls
    //load new windows
    @FXML
    private void clickedHelp(Event e) throws IOException {
        FXMLLoader root = new  FXMLLoader(getClass().getResource("HelpWindow.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Help");
        stage.setScene(new Scene(root.load()));
        stage.show();
    }

    @FXML
    private void clickedNewItemButton(Event e) throws IOException {
        //open New Item Window
        FXMLLoader root = new  FXMLLoader(getClass().getResource("NewItemWindow.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("New Item");
        stage.setScene(new Scene(root.load()));
        //set up controller
        NewItemWindowController newController = root.getController();
        newController.setOnItemAdded(onItemAdded);
//        EditItemWindowController editController = root.getController();
//        editController.setOnItemEdited(onItemEdited);
        //show window
        stage.show();
    }

    //set up interface for adding item
    interface OnItemAdded{
        void addItem(Item item);
    }

    //use interface to override method
    OnItemAdded onItemAdded = new OnItemAdded() {
        @Override
        public void addItem(Item item) {
            list.add(item);
            listCentral.addItem(item);
            tableView.refresh();
        }
    };

    public void addToList(String name, String description, LocalDate date){
        //add new item to list
        list.add(new Item(name, description, date, false));
        //refresh table
        tableView.refresh();
    }

    public void clickedSort(ActionEvent actionEvent) {
        //call sort items from list central
        listCentral.sortItems(choiceBox.getValue());
    }

    public void clickedClearList(ActionEvent actionEvent) {
        listCentral.removeAllItems();
    }

    public void clickedRemoveItem(ActionEvent actionEvent) {
        listCentral.removeItem(getTableIndex());
    }

    public void clickedMarkComplete(ActionEvent actionEvent) {
        int index = tableView.getSelectionModel().getSelectedIndex();
        listCentral.markComplete(index);
    }

    public int getTableIndex(){
        int index = tableView.getSelectionModel().getSelectedIndex();
        return index;
    }

    public void clickedMarkIncomplete(ActionEvent actionEvent) {
    }

    public void clickedEditItem(ActionEvent actionEvent) throws IOException {
        //open New Item Window
        FXMLLoader root = new  FXMLLoader(getClass().getResource("EditItemWindow.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Edit Item");
        stage.setScene(new Scene(root.load()));
        //show window
        stage.show();
    }

    //set up interface for adding item
    interface OnItemEdited{
        void editItem(String name, String description, LocalDate date);
    }

    //override interface method
    OnItemEdited onItemEdited = new OnItemEdited() {
        @Override
        public void editItem(String name, String description, LocalDate date) {
            listCentral.editItemInfo(getTableIndex(), name, description, date);
            tableView.refresh();
        }
    };

    public void clickedSaveList(ActionEvent actionEvent) {
    }

    public void clickedLoadList(ActionEvent actionEvent) {
    }
}
