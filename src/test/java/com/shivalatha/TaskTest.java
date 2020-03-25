package com.shivalatha;

import org.junit.Test;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TaskTest {
    Date date;
    DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    Task taskTest;


    void setup() throws ParseException
    {
        date = formatter.parse("25-03-2020");
        Task taskTest = new Task("Test","Test Project","Open",date);
    }

   /**
    * verify whether correct TaskName has been loaded
    */
    @Test
    public void getTaskName() throws ParseException
    {
        Task taskTest = new Task("Test","Test Project","Open",date);
        assertEquals("Test",taskTest.getTaskName());
    }

   /**
    * verify for correct projectName
    */
    @Test
    public void getProjectName()
    {
        Task taskTest = new Task("Test","Test Project","Open",date);
        assertEquals("Test Project",taskTest.getProjectName());
    }

   /**
    * verify for correct Status
    */
    @Test
    public void getStatus()
    {
        Task taskTest = new Task("Test","Test Project","Open",date);
        assertEquals("Open",taskTest.getStatus());
    }

   /**
    * Verify for correct Date
    */
    @Test
    public void getTaskDate()
    {
        Task taskTest = new Task("Test","Test Project","Open",date);
        assertEquals(date,taskTest.getTaskDate());
    }

   /**
    * Check whether the set method for TaskName,ProjectName,Status and Date gives expected result.
    */
    @Test
    public void setGetTaskName() throws ParseException
    {
        Task taskTest = new Task("Test","Test Project","Open",date);
        taskTest.setTaskName("test");
        assertEquals("test",taskTest.getTaskName());

        taskTest.setProjectName("test project");
        assertEquals("test project",taskTest.getProjectName());

        taskTest.setStatus("open");
        assertEquals("open",taskTest.getStatus());

        date = formatter.parse("26-03-2020");
        taskTest.setTaskDate(date);
        assertEquals(date,taskTest.getTaskDate());

    }
}