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
        //create example item
        Item item = new Item("name", "description", LocalDate.parse("2020-11-24"), false);
        //create expected list with the item in it
        ObservableList<Item> expected = FXCollections.observableArrayList(
                item
        );
        //create empty actual list
        ObservableList<Item> actual = FXCollections.observableArrayList();

        //when
        //call addItem from list central
        actual.add(listCentral.addItem(item));

        //then
        //make sure the item was added
        assertEquals(expected, actual);
    }

    @Test
    void removeItem_actually_removes_item() {
        // given
        ListCentral listCentral = new ListCentral();
        //create items
        Item item1 = new Item("name1", "description1", LocalDate.parse("2012-12-24"), false);
        Item item2 = new Item("name", "description", LocalDate.parse("2020-11-24"), true);
        //create test list with the items in it
        ObservableList<Item> test = FXCollections.observableArrayList();
        test.add(0, item1);
        test.add(1, item2);
        //set list to display list and list
        listCentral.setList(test);
        //create expected list with 1 of the items
        ObservableList<Item> expected = FXCollections.observableArrayList(
                item2
        );
        //create empty actual list
        ObservableList<Item> actual = FXCollections.observableArrayList();

        //when
        //call remove item from list central
        actual.setAll(listCentral.removeItem(0));

        //then
        assertEquals(expected, actual);
    }

    @Test
    void removeAllItems_actually_makes_the_list_empty() {
        // given
        ListCentral listCentral = new ListCentral();
        //create test list with the items in it
        ObservableList<Item> test = FXCollections.observableArrayList(
            new Item("name1", "description1", LocalDate.parse("2020-12-24"), false),
            new Item("name", "description", LocalDate.parse("2020-11-24"), false)
        );
        //created empty expected list
        ObservableList<Item> expected = FXCollections.observableArrayList();

        //when
        //set list to displayList and list
        listCentral.setList(test);
        //call remove all items from list central
        listCentral.removeAllItems();

        //then
        assertEquals(expected, listCentral.getDisplayList());
    }

    @Test
    void editItemInfo_edits_name() {
        // given
        ListCentral listCentral = new ListCentral();
        //create test list with the item in it
        ObservableList<Item> test = FXCollections.observableArrayList(
                new Item("name", "description", LocalDate.parse("2020-11-24"), false)
        );
        //create expected list with the item in it
        ObservableList<Item> expected = FXCollections.observableArrayList(
                new Item("Gary", "old dude", LocalDate.parse("2019-03-07"), false)
        );
        //create empty actual list
        ObservableList<Item> actual = FXCollections.observableArrayList();

        //when
        //set test to displayList and list
        listCentral.setList(test);
        //call editItemInfo from list central
        actual.add(listCentral.editItemInfo(0, "Gary", "old dude", LocalDate.parse("2019-03-07")));

        //then
        //make sure the item was added
        assertEquals(expected.get(0).getName(), actual.get(0).getName());
    }

    @Test
    void editItemInfo_edits_description() {
        // given
        ListCentral listCentral = new ListCentral();
        //create test list with the item in it
        ObservableList<Item> test = FXCollections.observableArrayList(
                new Item("name", "description", LocalDate.parse("2020-11-24"), false)
        );
        //create expected list with the item in it
        ObservableList<Item> expected = FXCollections.observableArrayList(
                new Item("Gary", "old dude", LocalDate.parse("2019-03-07"), false)
        );
        //create empty actual list
        ObservableList<Item> actual = FXCollections.observableArrayList();

        //when
        //set test to displayList and list
        listCentral.setList(test);
        //call editItemInfo from list central
        actual.add(listCentral.editItemInfo(0, "Gary", "old dude", LocalDate.parse("2019-03-07")));

        //then
        //make sure the item was added
        assertEquals(expected.get(0).getDescription(), actual.get(0).getDescription());
    }

    @Test
    void editItemInfo_edits_date() {
        // given
        ListCentral listCentral = new ListCentral();
        //create test list with the item in it
        ObservableList<Item> test = FXCollections.observableArrayList(
                new Item("name", "description", LocalDate.parse("2020-11-24"), false)
        );
        //create expected list with the item in it
        ObservableList<Item> expected = FXCollections.observableArrayList(
                new Item("Gary", "old dude", LocalDate.parse("2019-03-07"), false)
        );
        //create empty actual list
        ObservableList<Item> actual = FXCollections.observableArrayList();

        //when
        //set test to displayList and list
        listCentral.setList(test);
        //call editItemInfo from list central
        actual.add(listCentral.editItemInfo(0, "Gary", "old dude", LocalDate.parse("2019-03-07")));

        //then
        //make sure the item was added
        assertEquals(expected.get(0).getDate(), actual.get(0).getDate());
    }

    @Test
    void markComplete_sets_mark_to_true() {
        // given
        ListCentral listCentral = new ListCentral();
        //create list with an item
        ObservableList<Item> test = FXCollections.observableArrayList(
                new Item("name", "description", LocalDate.parse("2020-11-24"), false)
        );
        //set list to display list and list
        listCentral.setList(test);

        //when
        //get boolean from list central by calling markComplete
        boolean actual = listCentral.markComplete(0);

        //then
        //make sure value isn't null
        assertTrue(actual);
    }

    @Test
    void markIncomplete_sets_mark_to_false() {
        // given
        ListCentral listCentral = new ListCentral();
        //create list with an item
        ObservableList<Item> test = FXCollections.observableArrayList(
                new Item("name", "description", LocalDate.parse("2020-11-24"), true)
        );
        //set list to display list and list
        listCentral.setList(test);

        //when
        //get boolean from list central by calling markIncomplete
        boolean actual = listCentral.markIncomplete(0);

        //then
        //make sure value isn't null
        assertFalse(actual);
    }

    @Test
    void sortItems_by_completed() {
        // given
        ListCentral listCentral = new ListCentral();
        //create items
        Item item1 = new Item("name1", "description1", LocalDate.parse("2020-12-24"), false);
        Item item2 = new Item("name", "description", LocalDate.parse("2020-11-24"), true);
        //create test list with the items in it
        ObservableList<Item> test = FXCollections.observableArrayList(
                item1,
                item2
        );
        //created empty expected list
        ObservableList<Item> expected = FXCollections.observableArrayList(
                item2
        );
        //create empty actual list
        ObservableList<Item> actual = FXCollections.observableArrayList();

        //when
        //set list to displayList and list
        listCentral.setList(test);
        //call remove all items from list central
        actual.addAll(listCentral.sortItems("Completed"));

        //then
        assertEquals(expected, listCentral.getDisplayList());
    }

    @Test
    void sortItems_by_incomplete() {
        // given
        ListCentral listCentral = new ListCentral();
        //create items
        Item item1 = new Item("name1", "description1", LocalDate.parse("2020-12-24"), false);
        Item item2 = new Item("name", "description", LocalDate.parse("2020-11-24"), true);
        //create test list with the items in it
        ObservableList<Item> test = FXCollections.observableArrayList(
                item1,
                item2
        );
        //created empty expected list
        ObservableList<Item> expected = FXCollections.observableArrayList(
                item1
        );
        //create empty actual list
        ObservableList<Item> actual = FXCollections.observableArrayList();

        //when
        //set list to displayList and list
        listCentral.setList(test);
        //call remove all items from list central
        actual.addAll(listCentral.sortItems("Incomplete"));

        //then
        assertEquals(expected, listCentral.getDisplayList());
    }

    @Test
    void sortItems_by_all() {
        // given
        ListCentral listCentral = new ListCentral();
        //create items
        Item item1 = new Item("name1", "description1", LocalDate.parse("2020-12-24"), false);
        Item item2 = new Item("name", "description", LocalDate.parse("2020-11-24"), true);
        //create test list with the items in it
        ObservableList<Item> test = FXCollections.observableArrayList(
                item1,
                item2
        );
        //created empty expected list
        ObservableList<Item> expected = FXCollections.observableArrayList(
                item1,
                item2
        );
        //create empty actual list
        ObservableList<Item> actual = FXCollections.observableArrayList();

        //when
        //set list to displayList and list
        listCentral.setList(test);
        //call remove all items from list central
        actual.addAll(listCentral.sortItems("All"));

        //then
        assertEquals(expected, listCentral.getDisplayList());
    }
}