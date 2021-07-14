package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ListCentralTest {

    @Test
    void indexConverter() {
        // given
        FileCentral fileCentral = new FileCentral();

        //when

        //then

    }

    @Test
    void setList() {
        // given
        FileCentral fileCentral = new FileCentral();
        ObservableList<Item> expected = FXCollections.observableArrayList(
                new Item("name", "description", LocalDate.parse("2020-11-24"), false)
        );
        ObservableList<Item> actual = FXCollections.observableArrayList();

        //when


        //then

    }

    @Test
    void addItem() {
    }

    @Test
    void removeItem() {
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