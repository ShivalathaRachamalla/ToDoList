package com.shivalatha;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.*;

public class FileOperationsTest {

    @Test
    public void testReadFile() throws Exception {
        HashMap<Integer, Task> tasks = new HashMap<Integer, Task>();
        FileOperations.getInstance().readFromFile(tasks, "src/test/resources/ToDoLy.txt");
        assertEquals(" File Read failed ", 2, tasks.size());
    }

    @Test
    public void testSaveToFile() throws IOException {
        HashMap<Integer, Task> tasks = new HashMap<Integer, Task>();
        FileOperations.getInstance().saveToFile(tasks);
        File f = new File("ToDoLy.txt");
        assertTrue("ToDoDly.txt file is not created",f.exists());

    }
}