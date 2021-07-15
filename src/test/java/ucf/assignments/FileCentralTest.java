package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FileCentralTest {

    @Test
    void saveList_saves_a_list() {
        // given
        FileCentral fileCentral = new FileCentral();
        //create observable list to save
        ObservableList<Item> expected = FXCollections.observableArrayList(
                new Item("item name", "item description", LocalDate.parse("2021-10-11"), false),
                new Item("yeet", "yote", LocalDate.parse("2021-09-03"), false),
                new Item("Item3", "Don't fail class", LocalDate.parse("2021-10-11"), false)
        );
        //create file location to save to
        File file = new File("src/test/resources/TestOutputFile.txt");

        //when
        //cal save list from list central
        fileCentral.saveList(expected, file);

        //then
        //make sure file has data in it
        assertNotNull(file);
    }

    @Test
    void loadList_loads_a_list() {
        // given
        FileCentral fileCentral = new FileCentral();
        //create file location to load from
        File file = new File("src/test/resources/TestInputFile.txt");

        //when
        //create observable list
        ObservableList<Item> actual = FXCollections.observableArrayList();
        //save file data to observable list
        actual.addAll(fileCentral.loadList(file));

        //then
        //make sure data is in observable list
        assertNotNull(actual);
    }
}