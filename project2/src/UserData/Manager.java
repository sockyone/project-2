/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserData;

import UserData.Task;

import UserData.Task;
import UserData.Task.STATUS;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author nghun
 * 
 */
public class Manager extends User {
    
    private final String Prjfile="project.txt";
    private final String Taskfile = "task.txt";
    public ArrayList<Project> listProject;
    public ArrayList<Task> listTask;

    public Manager() {
        super();
        this.type = TYPE.MANAGER;
    }

    public Manager(String userName, String password, String fullName) {
        super(userName, password, fullName);
        this.type = TYPE.MANAGER;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Manager(String id,String userName, String password, String fullName) {
        super(id,userName, password, fullName);
        this.type = TYPE.CEO;
    }

    public void createTask() {

    }
    
    public void loadProject() throws IOException {
        FileInputStream fis = new FileInputStream(this.Prjfile);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bfr = new BufferedReader(isr);
        ArrayList<Task> task = new ArrayList<>();
        ArrayList<User> emp = new ArrayList<>();
        String line = bfr.readLine();
        while(line != null){
            String prjID = line; 
            line = bfr.readLine();
            String pjName = line;
            line = bfr.readLine();
            String mnID = line;
            line = bfr.readLine();
            String tsk = line;
        if(tsk.equals("Task: ")) 
        {
        int i = 0;
        while(line != null && line != "Employees ")
        {
            String []array = line.split("/");
            Date start = null;
            if (array.length == 3 )
            {
                start.day = array[0];
                start.month = array[1];
                start.year = array[2];
               
            }
            line = bfr.readLine();
            String []arr = line.split("/");
            Date end = null;
             if (array.length == 3 )
            {
                end.day = array[0];
                end.month = array[1];
                end.year = array[2];
               
            }
            line = bfr.readLine();
            String stt = line;
            STATUS stt1 = null ;
            if(stt.equals("Created")) stt1 = STATUS.CREATED;
            if(stt.equals("Assigned")) stt1 = STATUS.ASSIGNED;
            if(stt.equals("Started")) stt1 = STATUS.STARTED;
            if(stt.equals("Done")) stt1 = STATUS.DONE;
            if(stt.equals("Completed")) stt1 = STATUS.COMPLETED;
            if(stt.equals("Reject")) stt1 = STATUS.REJECT;
            if(stt.equals("Closed")) stt1 = STATUS.CLOSED;
            line = bfr.readLine();
            String []dev = line.split(",");
            ArrayList<Developer> id = new ArrayList<>();
            for (int j = 0; j<dev.length;j++)
            {
                id.get(j).setId(dev[j]);
            }
            line = bfr.readLine();
            String []tst = line.split(",");
            ArrayList<Tester> id1 = new ArrayList<>();
            for (int j = 0; j<tst.length;j++)
            {
                id.get(j).setId(dev[j]);
            }
            Task temp = new Task(prjID,id,id1,start,end,stt1);
            task.add(temp);
            i++;
            line = bfr.readLine();
          
            }
        if (line.equals("Employees "))
        {
            String []us = line.split(",");
            if (us.length == 5)
            {
                TYPE tmp = null;
                if(us[0].equals("Tester"))
                {
                    tmp = TYPE.TESTER;
                    Tester t = new Tester(us[5],us[1],us[2],us[3]);
                    emp.add(t);
                }
                if (us[0].equals("Developer")) 
                {
                    tmp = TYPE.DEVELOPER;
                    Developer d = new Developer(us[5],us[1],us[2],us[3]);
                    emp.add(d);
                }
                
            }
        }
    }
    }
    }
    
    
    
    public void loadTask() throws IOException{
        FileInputStream fis = new FileInputStream(this.Taskfile);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bfr = new BufferedReader(isr);
        this.listTask = new ArrayList<>();
        String line = bfr.readLine();
        int i = 0;
        while(line != null)
        {
            String prjID = line;
            line = bfr.readLine();
            String []array = line.split("/");
            Date start = null;
            if (array.length == 3 )
            {
                start.day = array[0];
                start.month = array[1];
                start.year = array[2];
               
            }
            line = bfr.readLine();
            String []arr = line.split("/");
            Date end = null;
             if (array.length == 3 )
            {
                end.day = array[0];
                end.month = array[1];
                end.year = array[2];
               
            }
            line = bfr.readLine();
            String stt = line;
            STATUS stt1 = null ;
            if(stt.equals("Created")) stt1 = STATUS.CREATED;
            if(stt.equals("Assigned")) stt1 = STATUS.ASSIGNED;
            if(stt.equals("Started")) stt1 = STATUS.STARTED;
            if(stt.equals("Done")) stt1 = STATUS.DONE;
            if(stt.equals("Completed")) stt1 = STATUS.COMPLETED;
            if(stt.equals("Reject")) stt1 = STATUS.REJECT;
            if(stt.equals("Closed")) stt1 = STATUS.CLOSED;
            line = bfr.readLine();
            String []dev = line.split(",");
            ArrayList<Developer> id = new ArrayList<>();
            for (int j = 0; j<dev.length;j++)
            {
                id.get(j).setId(dev[j]);
            }
            line = bfr.readLine();
            String []tst = line.split(",");
            ArrayList<Tester> id1 = new ArrayList<>();
            for (int j = 0; j<tst.length;j++)
            {
                id.get(j).setId(dev[j]);
            }
            Task temp = new Task(prjID,id,id1,start,end,stt1);
            this.listTask.add(temp);
            i++;
            line = bfr.readLine();
            
        }
        
}

}