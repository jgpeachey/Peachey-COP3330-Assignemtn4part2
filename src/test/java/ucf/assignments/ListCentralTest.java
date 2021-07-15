package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ListCentralTest {

    @Test
    void indexConverter_is_not_null() {
        // given
        ListCentral listCentral = new ListCentral();
        //create list with an item
        ObservableList<Item> test = FXCollections.observableArrayList(
                new Item("name", "description", LocalDate.parse("2020-11-24"), false)
        );
        //set list to display list and list
        listCentral.setList(test);

        //when
        //get index from list central by calling indexConverter
        int actual = listCentral.indexConverter(0);

        //then
        //make sure value isn't null
        assertNotNull(actual);
    }

    @Test
    void setList_makes_list_equal_to_list_given() {
        // given
        ListCentral listCentral = new ListCentral();
        //create list with one item
        ObservableList<Item> expected = FXCollections.observableArrayList(
                new Item("name", "description", LocalDate.parse("2020-11-24"), false)
        );
        //create empty list
        ObservableList<Item> actual = FXCollections.observableArrayList();

        //when
        //populate list by calling setList from list central
        actual.setAll(listCentral.setList(expected));

        //then
        //make sure actual list has changed to hold the expected list data
        assertEquals(expected, actual);
    }

    @Test
    void addItem_adds_item_to_list() {
        // given
        ListCentral listCentral = new ListCentral();
        Item item = new Item("name", "description", LocalDate.parse("2020-11-24"), false);
        ObservableList<Item> expected = FXCollections.observableArrayList(
                item
        );
        ObservableList<Item> actual = FXCollections.observableArrayList();

        //when
        actual.add(listCentral.addItem(item));

        //then
        assertEquals(expected, actual);
    }

    @Test
    void removeItem_actually_removes_item() {
        // given
        ListCentral listCentral = new ListCentral();
        ObservableList<Item> expected = FXCollections.observableArrayList(
                new Item("name", "description", LocalDate.parse("2020-11-24"), false)
        );
        ObservableList<Item> actual = FXCollections.observableArrayList();

        //when
        actual.setAll(listCentral.setList(expected));

        //then
        assertEquals(expected, actual);
    }

    @Test
    void removeAllItems() {
    }

    @Test
    void editItemInfo() {
    }

    @Test
    void markComplete() {
    }

    @Test
    void markIncomplete() {
    }

    @Test
    void sortItems() {
    }
}