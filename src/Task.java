/***
 *  Prompt class has the details of the Taskname, ProjectName, Status and date
 */

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

public class Task implements Serializable {
    private int taskId;
    private String taskName;
    private String projectName;
    private String status;
    private Date taskDate;
    private static int count = 0;

    Task(String taskName, String projectName, String status, Date taskDate) {
        this.taskName    = taskName;
        this.projectName = projectName;
        this.status      = status;
        this.taskDate    = taskDate;
        this.taskId      = getCount();
    }

   /**
    * @return The taskId
    */
    public int getTaskId() {
        return taskId;
    }

   /**
    * @return The Task name
    */
    public String getTaskName() {
        return taskName;
    }

   /**
    * @return The Project name
    */
    public String getProjectName() {
        return projectName;
    }

   /**
    * @return The Task status
    */
    public String getStatus() {
        return status;
    }

   /**
    * @return The Task date
    */
    public Date getTaskDate() {
        return taskDate;
    }

   /**
    * @return Task Id for the new Task
    */
    public static int getCount() {
        return ++ count;
    }

    /**
     * @set/modify The Task id
     */
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

   /**
    * @set/modify The Task name
    */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

   /**
    * @set/modify The Project name
    */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

   /**
    * @set/modify The Task status
    */
    public void setStatus(String status) {
        this.status = status;
    }

   /**
    *  @set/modify The Task date
    */
    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

   /**
    * Comparator used to sort the tasks by Project name
    */
    public static Comparator<Task> compareProject = new Comparator<Task>() {
        @Override
        public int compare(Task t1, Task t2) {
            String projectName1 = t1.getProjectName();
            String projectName2 = t2.getProjectName();

            return projectName1.compareTo(projectName2);
        }
    };

   /**
    * Comparator used to sort the tasks by Task date
    */
    public static Comparator<Task> compareDate = new Comparator<Task>() {
        @Override
        public int compare(Task d1, Task d2) {
            Date date1 = d1.getTaskDate();
            Date date2 = d2.getTaskDate();

            return date1.compareTo(date2);
        }
    };

    /**
     * The String representation returns Task fields
     */
    public String toString() {
        return  "Task id:           " + this.taskId
                +"\nTask Name:      " + this.taskName
                +"\nProject Name:  " + this.projectName
                +"\nStatus:         " + this.status
                +"\nDate:           " + this.taskDate;
    }



}

