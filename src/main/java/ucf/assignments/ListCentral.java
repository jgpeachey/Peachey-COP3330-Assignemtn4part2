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
    private ArrayList<Integer> indexConvert = new ArrayList();

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
        list.removeAll();
        displayList.removeAll();
        //add loaded list
        list.addAll(newList);
        displayList.addAll(newList);
        //return list
        return list;
    }

    public void addItem(String name, String description, LocalDate date){
        //add new item to list
        list.add(new Item(name, description, date, false));
        displayList.add(new Item(name, description, date, false));
    }

    public ObservableList removeItem(int index){
        // remove item from display list
        displayList.remove(index);
        // remove item from list
        list.remove(index);
        return list;
    }

    public ObservableList removeAllItems(){
        displayList.removeAll();
        list.removeAll();
        return list;
    }

    public void getItemInfo(int index){
        index = indexConvert.get(index);
        list.get(index);
    }

    public Item editItemInfo(int index, String name, String description, LocalDate date){
        index = indexConvert.get(index);
        list.get(index).setName(name);
        list.get(index).setDescription(description);
        list.get(index).setDate(date);
        return list.get(index);
    }

    public boolean markComplete(int index){
        index = indexConvert.get(index);
        list.get(index).setMark(true);
        return list.get(index).isMark();
    }

    public boolean markIncomplete(int index){
        index = indexConvert.get(index);
        list.get(index).setMark(false);
        return list.get(index).isMark();
    }

    public void sortItems(String sortBy){
        // create temp list for sorting
        ObservableList<Item> sorted = FXCollections.observableArrayList();
        // clear index Converter list
        indexConvert.removeAll(indexConvert);
        for (int i = 0; i < list.size(); i++) {
            // determine if item is complete
            boolean complete = list.get(i).isMark();
            //sort by complete
            if(sortBy.equals("Complete")){
                if (complete) {
                    sorted.add(list.get(i));
                    indexConvert.add(i);
                }
            }
            //sort by incomplete
            else if (sortBy.equals("Incomplete")){
                if (!complete) {
                    sorted.add(list.get(i));
                    indexConvert.add(i);
                }
            }
            // sort by all
            else if (sortBy.equals("All") || sortBy.equals(null)){
                sorted.add(list.get(i));
            }
        }
        // clear displayed list
        displayList.removeAll();
        // set displayed list equal to sorted list
        displayList.addAll(sorted);
    }
}
