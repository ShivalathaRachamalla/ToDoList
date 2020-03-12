/*
 * Gives option to the user for the Action to be performed on ToDoLy.
 */

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Prompt {

    private int option, taskNo;
    private String inputText1, inputText2, inputText3, inputText4;
    private int count = 0;
    private Date date;
    private static Prompt prompt = null;
    private int changeField;

    DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
/**
 * Returns singleton object of Prompt class
 */
    public static Prompt getInstance() {

        if (prompt == null) {
            return new Prompt();
        } else {
            return prompt ;
        }

    }
    public void displayOption() throws Exception {
        try {
            Storage.getInstance().inputReader();  // Read input text file
        } catch(IOException e) {
            System.out.println("Error in reading input file");
        }
        System.out.println(">> Welcome to ToDoLy");
        System.out.println(">> You have X tasks todo and Y tasks are done! ");
        System.out.println(">> Pick an option: ");
        System.out.println(">> (1) Show Task List ");
        System.out.println(">> (2) Add New Task ");
        System.out.println(">> (3) Edit Task (update, mark as done, remove ");
        System.out.println(">> (4) Save and Quit ");
        System.out.println(">>");


        while (true) {

            System.out.println("Enter your option");
            try {
                option = scanInput();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter numbers only");
                continue;
            }
            switch (option) {

                case 1:
                    taskList();  // Display the To Do List
                    break;
                case 2:
                    addTask();  // Add new task
                    break;
                case 3:
                    editTask(); // Edit the task in list
                    break;
                case 4:
                    saveExitTask(); // Save and Exit
                    break;
                default:
                    System.out.println("Please enter correct option");
            }
        }
    }

    public int scanInput() {
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            return i;
    }
/**
 * Read the input File
 */
    public String scanString()
    {
        String line = null;
       try {
           Scanner sc = new Scanner(System.in);
           line = sc.nextLine();
           Integer.parseInt(line);
       } catch (NumberFormatException e) {

       }
        return line;
    }
/**
 * Add task
 */
    private void addTask() throws Exception {

        try {
            System.out.println("Enter the Task Name : ");
            inputText1 = scanString();
            System.out.println("Enter the Project Name : ");
            inputText2 = scanString();
            System.out.println("Enter the Status : ");
            inputText3 = scanString();
            System.out.println("Enter the TaskDate(dd-MM-yyyy) : ");
            inputText4 = scanString();
        } catch (Exception e) {
            System.out.println("Invalid Input. Please retry");
            count++;

            if (count == 3){
                System.out.println("Invalid Input for 3 times. EXIT!");
                this.displayOption();
            } else {
                this.addTask();
            }
        }

        try {
            date = formatter.parse(inputText4);
        } catch (ParseException e) {
            System.out.println("Error occurred while trying to convert date");
        }
    }
/**
 * Edit Task
 */
    private void editTask() throws Exception {
        System.out.println("Enter the task number you want to edit ");
       taskNo = scanInput();

        System.out.println("Enter the field you want to edit");
        System.out.println("(1) Task Name");
        System.out.println("(2) Project Name");
        System.out.println("(3) Status");
        System.out.println("(4) Date");
       option = scanInput();

       switch(option) {

           case 1:
               System.out.println("Edit the Task name: ");
               inputText1 = scanString();
               break;
           case 2:
               System.out.println("Edit the Project Name: ");
               inputText2 = scanString();
               break;
           case 3:
               System.out.println("Edit the status: ");
               inputText3 = scanString();
               break;
           case 4:
               System.out.println("Edit the Task date");
               inputText4 = scanString();
           default:
               System.out.println("Please enter correct option");
       }
    }
/**
 * Delete the task
 */
    private void removeTask() throws Exception {
        System.out.println("Enter the Task number you want to remove: ");
        taskNo = scanInput();
        Storage.getInstance().removeRecord(taskNo);
        System.out.println("Enter the option");
        option = scanInput();
    }
/**
 * Save and Exit task
 */
    private void saveExitTask() {

    }
/**
 * Display Task
 */
    private void taskList() {
        System.out.println("List the task by: ");
        System.out.println("(1) By Date");
        System.out.println("(2) By Project");
       // option = scanInput();
    }
    private Task getTask(int taskNo) {

        return null;
    }
}
