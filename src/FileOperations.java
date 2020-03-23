/***
 * FileOperations reads and writes the input text file
 */

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FileOperations {

    public static FileOperations fileOperations = null;
    public static FileOperations getInstance(){
             if (fileOperations == null) {
                 fileOperations = new FileOperations();
             }
             return fileOperations;
    }

   /**
    * Reads the input Text file and stores the details into the HashMap of task.
    */
    public void saveToFile(HashMap<Integer, Task> tasks) throws IOException {

        try {
             ObjectOutputStream op = new ObjectOutputStream(new FileOutputStream("ToDoLy.txt"));
            Map n = Storage.getInstance().getAllTasks();
            op.writeObject(n);
        } catch (Exception e) {
            System.out.println("Sorry! Cannot save to the file." + e.toString());
        }

    }

   /**
    * Writes back to the file which should be used when you open the Todo list task next time.
    */
    public void readFromFile(HashMap<Integer,Task> tasks, String filePath) throws Exception {
        try {
            File f = new File(filePath);
            if(f.exists()){
                ObjectInputStream ip = new ObjectInputStream(new FileInputStream(filePath));
                HashMap m = (HashMap<String, Task>)ip.readObject();
                System.out.println(m.size());
                 Iterator r = m.entrySet().iterator();
                 while (r.hasNext()) {
                     Map.Entry me =  (Map.Entry)r.next();
                     int count = Task.getCount();
                     Task s = (Task)me.getValue();
                     s.setTaskId(count);
                     tasks.put(Integer.valueOf(count), s);
                 }
            }
        } catch (Exception e) {
           System.out.println("Sorry! Unable to load file"+e.toString());
           throw e;
        }
    }
}
