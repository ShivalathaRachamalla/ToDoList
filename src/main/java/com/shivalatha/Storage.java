package com.shivalatha;

/***
 * Storage adds, edits and deletes the Task details to the HashMap.
 */

import java.io.IOException;
import java.util.*;

public class Storage {

    private static Storage storage = null;
    private HashMap<Integer, Task> tasks = new HashMap<Integer, Task>();

    public static Storage getInstance() {

        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    /**
     * Add new Task to the ToDo List.
     * @param t Object of type Task
     */
    public void addRecord(Task t) {

        tasks.put(Integer.valueOf(t.getTaskId()),t);
    }

    /**
     * Deletes new Task from the ToDo List.
     * @param taskId from Task object
     */
    public void removeRecord(int taskId) {

        tasks.remove(Integer.valueOf(taskId));
    }

    /**
     * Get Task Object
     * @param taskNo from Task object
     * @return The taskNo
     */
    public Task getTask(int taskNo) {

        Task t = tasks.get(Integer.valueOf(taskNo));
        return t;
    }

    /**
     * Get all the Task details
     * @return tasks
     */
    public Map getAllTasks() {

        return tasks;
    }

    /**
     * Stores the details into file.
     * @exception IOException if stream to file cannot be written to or closed.
     */
    public void saveToFile() throws IOException {

        FileOperations.getInstance().saveToFile(tasks);
    }

    /**
     * Reads task details from the file.
     * @param filePath to be loaded.
     * @exception Exception if stream to file cannot be read or closed.
     */
    public void readFromFile(String filePath) throws Exception {

        FileOperations.getInstance().readFromFile(tasks, filePath);
    }

    /**
     * Gets the count values for "DONE" and "ON-GOING" task.
     * @return int[] which contains task "DONE" count at '0' index
     * and "ON-GOING" count at index '1'.
     */
    public int[] getTaskCount() {

        int doneCount = 0;
        int inProgress = 0;
        int counts[] = new int[2];
        Iterator i = tasks.entrySet().iterator();

        while (i.hasNext()){

            Map.Entry me =  (Map.Entry)i.next();

            if (((Task)me.getValue()).getStatus() == "DONE"){
                doneCount++;
            } else {
                inProgress++;
            }
        }
        counts[0] = inProgress;
        counts[1] = doneCount;
        return counts;
    }

    /**
     * Sort the Task list based on Project name or Task date.
     * @param option option 1 sorts the list based on Task date and
     * option 2 sorts the list based on Project name.
     */
    public void sortTaskList(int option) {

        ArrayList<Task> p =this.getTaskAsList();

        if (option == 1) {
            Collections.sort(p, Task.compareDate);
        } else {
            Collections.sort(p, Task.compareProject);
        }

        for (Task g : p){

            System.out.println("---------");
            System.out.println(g);
        }
        System.out.println("---------");
    }

    /**
     * Extract Task objects from HashMap and store into ArrayList.
     * @return All Task objects in ArrayList.
     */
    private ArrayList<Task> getTaskAsList() {

        ArrayList<Task> taskList = new ArrayList<Task>();
        Iterator i = tasks.entrySet().iterator();

        while (i.hasNext()){

            Map.Entry me = (Map.Entry)i.next();
            taskList.add((Task)me.getValue());
        }
        return taskList;
    }
}

