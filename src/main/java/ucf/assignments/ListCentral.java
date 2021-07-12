/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 John Peachey
 */

package ucf.assignments;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListCentral {



    //create a list of items seen
    private ObservableList<Item> displayList= FXCollections.observableArrayList();
    //create a main list of items
    private ObservableList<Item> list= FXCollections.observableArrayList();
    //create a index conversion

    public int indexConverter(int index){
        int i = 0;
        //convert index
        while (displayList.get(index) != list.get(i)){
            i++;
        }
        return i;
    }

    //get the displayed list
    public ObservableList<Item> getList(){
        //return list
        return displayList;
    }

    //get the whole list
    public ObservableList<Item> getWholeList(){
        //return list
        return list;
    }

    public ObservableList<Item> setList(ObservableList<Item> newList){
        //clear any existing list
        removeAllItems();
        //add loaded list
        list.addAll(newList);
        displayList.addAll(newList);
        //return list
        return list;
    }

    public void addItem(Item item){
        //add new item to list
        list.add(item);
        displayList.add(item);
    }

    public ObservableList removeItem(int index){
        // remove item from display list
        displayList.remove(index);
        // remove item from list
        list.remove(indexConverter(index));
        return list;
    }

    public ObservableList removeAllItems(){
        //remove everything from every list
        displayList.remove(0, displayList.size());
        list.remove(0, list.size());
        return list;
    }

    public void getItemInfo(int index){
        list.get(indexConverter(index));
    }

    public Item editItemInfo(int index, String name, String description, LocalDate date){
        displayList.get(index).setName(name);
        displayList.get(index).setDescription(description);
        displayList.get(index).setDate(date);
        list.get(indexConverter(index)).setName(name);
        list.get(indexConverter(index)).setDescription(description);
        list.get(indexConverter(index)).setDate(date);
        return list.get(indexConverter(index));
    }

    public boolean markComplete(int index){
        displayList.get(index).setMark(true);
        System.out.println(displayList.get(index));
        list.get(indexConverter(index)).setMark(true);
        System.out.println(list.get(indexConverter(index)));
        return list.get(index).isMark();
    }

    public boolean markIncomplete(int index){
        //set incomplete
        displayList.get(index).setMark(false);
        list.get(indexConverter(index)).setMark(false);
        return list.get(index).isMark();
    }

    public void sortItems(String sortBy){
        // create temp list for sorting
        ObservableList<Item> sorted = FXCollections.observableArrayList();
        for (int i = 0; i < list.size(); i++) {
            // determine if item is complete
            boolean complete = list.get(i).isMark();
            //sort by complete
            if(sortBy.equals("Complete")){
                if (complete) {
                    sorted.add(list.get(i));
                }
            }
            //sort by incomplete
            else if (sortBy.equals("Incomplete")){
                if (!complete) {
                    sorted.add(list.get(i));
                }
            }
            // sort by all
            else if (sortBy.equals("All") || sortBy.equals(null)){
                sorted.add(list.get(i));
            }
        }
        // clear displayed list
        displayList.remove(0, displayList.size());
        // set displayed list equal to sorted list
        displayList.addAll(sorted);
    }
}
