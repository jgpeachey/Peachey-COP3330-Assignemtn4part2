/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 John Peachey
 */

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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    ListCentral listCentral = new ListCentral();
    FileCentral fileCentral = new FileCentral();

    //file chooser setup
    FileChooser fileChooser = new FileChooser();

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

    //tableview set up
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

    //choice box setup
    @FXML
    private ChoiceBox<String> choiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //set up file chooser
        fileChooser.setInitialDirectory(new File("C:\\"));
        //set up choice box
        choiceBox.setValue("All");
        choiceBox.getItems().add("All");
        choiceBox.getItems().add("Completed");
        choiceBox.getItems().add("Incomplete");
        //set column value types
        itemColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("description"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Item, LocalDate>("date"));
        markColumn.setCellValueFactory(new PropertyValueFactory<Item, Boolean>("mark"));

        //load data from list
        tableView.setItems(listCentral.getDisplayList());
    }
//misc methods
    public int getTableIndex(){
        int index = tableView.getSelectionModel().getSelectedIndex();
        return index;
    }

//interfaces and corresponding methods
    //set up interface for adding item
    interface OnItemEdited{
        void editItem(String name, String description, LocalDate date);
    }

    //override editItem interface method
    OnItemEdited onItemEdited = new OnItemEdited() {
        @Override
        public void editItem(String name, String description, LocalDate date) {
            listCentral.editItemInfo(getTableIndex(), name, description, date);
            tableView.refresh();
        }
    };

    //set up interface for adding item
    interface OnItemAdded{
        void addItem(Item item);
    }

    //override addItem interface method
    OnItemAdded onItemAdded = new OnItemAdded() {
        @Override
        public void addItem(Item item) {
            list.add(item);
            listCentral.addItem(item);
            tableView.refresh();
        }
    };


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
        //show window
        stage.show();
    }

    @FXML
    public void clickedEditItem(ActionEvent actionEvent) throws IOException {
        //open New Item Window
        FXMLLoader root = new  FXMLLoader(getClass().getResource("EditItemWindow.fxml"));
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Edit Item");
        stage.setScene(new Scene(root.load()));
        //set up controller
        EditItemWindowController editController = root.getController();
        editController.setOnItemEdited(onItemEdited);
        //show window
        stage.show();
    }

    //edit items in/view of list
    @FXML
    public void clickedSort(ActionEvent actionEvent) {
        //call sort items from list central
        listCentral.sortItems(choiceBox.getValue());
    }

    //clear current todo list
    @FXML
    public void clickedClearList(ActionEvent actionEvent) {
        //call remove all items from list central
        listCentral.removeAllItems();
    }

    //remove selected item
    @FXML
    public void clickedRemoveItem(ActionEvent actionEvent) {
        // call remove item from list central
        //use the table index as a parameter
        listCentral.removeItem(getTableIndex());
    }

    //mark selected item complete
    @FXML
    public void clickedMarkComplete(ActionEvent actionEvent) {
        //call mark complete from list central
        //use the table index as a parameter
        listCentral.markComplete(getTableIndex());
        tableView.refresh();
    }

    @FXML
    public void clickedMarkIncomplete(ActionEvent actionEvent) {
        //call mark incomplete from list central
        //use the table index as a parameter
        listCentral.markIncomplete(getTableIndex());
        tableView.refresh();
    }

    @FXML
    public void clickedSaveList(ActionEvent actionEvent) {
        File savedList = fileChooser.showSaveDialog(new Stage());
        if (savedList != null){
            fileCentral.saveList(listCentral.getWholeList(), savedList);
        }
    }

    @FXML
    public void clickedLoadList(ActionEvent actionEvent) {
        File chosenList = fileChooser.showOpenDialog(new Stage());
        tableView.setItems(listCentral.setList(fileCentral.loadList(chosenList)));
    }

}
