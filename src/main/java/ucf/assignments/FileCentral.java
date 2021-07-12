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

    public void saveList(ObservableList<Item> todoList, String fileLocation){
        //create file
        File output = new File(fileLocation);
        //create time formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //implement a try catch method
        try {
            //set up file writer
            FileWriter fileWriter = new FileWriter(output);
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

    public ObservableList loadList(String fileLocation){
        //create observable list
        ObservableList<Item> list= FXCollections.observableArrayList();
        //load file
        try {
            //takes in file info
            File theList = new File(fileLocation);
            Scanner in = new Scanner(theList);
            // reads next input from file
            while (in.hasNextLine()) {
                String name = in.nextLine();
                String description = in.nextLine();
                LocalDate dueDate = null;
                dueDate = dueDate.parse(in.nextLine());
                String blank = in.nextLine();
                if (blank.equals("true") || blank.equals("false")){
                    in.nextLine();
                }

                //set file data to list
                list.add(new Item(name, description, dueDate, false));
            }
        }
        //catch method to make sure file is found
        catch (FileNotFoundException e){
            System.out.println("File not found.");
            e.printStackTrace();
        }
        //return
        return list;
    }

}
