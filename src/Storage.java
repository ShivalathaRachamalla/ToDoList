/*
ToDo reads the input file. It adds new Todo task details to arraylist. Edit, Delete the existing Task details.
*/
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.File;
import java.util.Scanner;

    public class Storage {
        private static Storage storage = null;
        private ArrayList<Task> tasks = new ArrayList<>();
        private int option, taskNo, statusOpen = 0, statusClosed = 0;
        private String inputText1,inputText2,inputText3;
        String fileName = null;

        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        public static Storage getInstance() {

            if (storage == null) {
                return new Storage();
            } else {
                return storage;
            }

        }
        /*
        Display the To do list data from ArrayList
        */
        public void displayInput() {
            int choice;
            int counter = 0;

            System.out.println("Please Enter your choice - for sorting");
            System.out.println("1. Sort based on Date");
            System.out.println("2. Sort based on Project");

            choice = Prompt.getInstance().scanInput();
            if (choice == 1) {
                tasks.sort((Task d1, Task d2) -> d1.getTaskDate().compareTo(d2.getTaskDate()));
            } else if (choice == 2) {
                tasks.sort((Task d1, Task d2) -> d1.getProjectName().compareTo(d2.getProjectName()));
            }
            String format1 = "%-9s %-40s %-43s %-12s %-15s";
            System.out.println(String.format("TaskNo", "TaskName", "ProjectName", "Status", "Date"));


            for (Task file : tasks) {
                counter = counter + 1;
                System.out.println(String.format(format1,counter,file.getTaskName(),file.getProjectName(),file.getStatus(),formatter.format(file.getTaskDate())));
                String changeCase = file.getStatus().toUpperCase();
                if (changeCase.equals("OPEN"))
                {
                    statusOpen = statusOpen + 1;
                }
                else if(changeCase.equals("CLOSED"))
                {
                    statusClosed = statusClosed + 1;
                }
            }
            System.out.println("Number of Tasks open : "+statusOpen+" Number of Tasks Closed " + statusClosed);
            statusOpen = 0;
            statusClosed = 0;

        }
/**
 * Read the input text file and store details into Arraylist of task
 */
        public void inputReader() throws IOException {
            //Date date = null;
            //JFileChooser chooser = new JFileChooser();
        }

        public void removeRecord(int taskNo) {

        }
    }
