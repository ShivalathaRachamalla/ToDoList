/*
 Prompt class has the details of the Taskname, ProjectName, Status and date
 */

import java.util.Date;

public class Task {

    private String taskName;
    private String projectName;
    private String status;
    private Date taskDate;

    public Task(String taskName, String projectName, String status, Date taskDate) {
        this.taskName    = taskName;
        this.projectName = projectName;
        this.status      = status;
        this.taskDate    = taskDate;
    }

    // get Task name
    public String getTaskName() {
        return taskName;
    }

    // get Project name
    public String getProjectName() {
        return projectName;
    }

    // get task status
    public String getStatus() {
        return status;
    }

    // get Task date
    public Date getTaskDate() {
        return taskDate;
    }

    // set Task name
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    // set Project name
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    // set Task status
    public void setStatus(String status) {
        this.status = status;
    }

    // set Task date
    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }
}

