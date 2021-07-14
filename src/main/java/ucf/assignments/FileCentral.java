/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 John Peachey
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FileCentral {

    ListCentral listCentral = new ListCentral();

    public void saveList(ObservableList<Item> todoList, File outputFile){
        //create time formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //implement a try catch method
        try {
            //set up file writer
            FileWriter fileWriter = new FileWriter(outputFile);
            PrintWriter writer = new PrintWriter(fileWriter);
            //write appropriate statements to file
            //go through array to print output to file
            for (int i = 0; i < todoList.size(); i++) {
                // print entire item info in one loop
                writer.printf("%s %n", todoList.get(i).getName());
                writer.printf("%s %n", todoList.get(i).getDescription());
                writer.printf("%s %n", todoList.get(i).getDate().format(formatter));
                writer.printf("%b %n%n", todoList.get(i).isMark());
            }
            fileWriter.close();
        }
        catch (IOException e){
            System.out.println("Failed to write file.");
            e.printStackTrace();
        }
        //return file
    }

    public ObservableList loadList(File inputFile){
        //create observable list
        ObservableList<Item> todoList = FXCollections.observableArrayList();
        //load file
        try {
            Scanner in = new Scanner(inputFile);
            // reads next input from file
            while (in.hasNextLine()) {
                //get data for an item
                String name = in.nextLine();
                String description = in.nextLine();
                LocalDate dueDate = null;
                dueDate = dueDate.parse(in.nextLine());
                String mark = in.nextLine();

                if (mark.equals("true") || mark.equals("false")){
                    //set file data to list
                    todoList.add(new Item(name, description, dueDate, Boolean.parseBoolean(mark)));
                    in.nextLine();
                }
                else {
                    //set file data to list
                    todoList.add(new Item(name, description, dueDate, false));
                }
            }
        }
        //catch method to make sure file is found
        catch (FileNotFoundException e){
            System.out.println("File not found.");
            e.printStackTrace();
        }
        //set list in list central
        listCentral.setList(todoList);
        //return
        return todoList;
    }

}
