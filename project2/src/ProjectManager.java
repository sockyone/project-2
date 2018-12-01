import UserData.*;

import java.util.ArrayList;
import java.io.File;
import java.util.Objects;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ProjectManager {
    private ArrayList<User> userList;
    private String userFile="user.txt";
    private final String projectFile="project.txt";
    private final String taskFile = "task.txt";
    public ArrayList<Project> listProject;
    public ArrayList<Task> listTask;


    public ProjectManager() {
        this.userList = new ArrayList<>();
    }

    public void loadProject() throws IOException {
        FileInputStream fis = new FileInputStream(this.projectFile);
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
                    DATE start = null;
                    if (array.length == 3 )
                    {
                        start.day = array[0];
                        start.month = array[1];
                        start.year = array[2];

                    }
                    line = bfr.readLine();
                    String []arr = line.split("/");
                    DATE end = null;
                    if (array.length == 3 )
                    {
                        end.day = array[0];
                        end.month = array[1];
                        end.year = array[2];

                    }
                    line = bfr.readLine();
                    String stt = line;
                    Task.STATUS stt1 = null ;
                    if(stt.equals("Created")) stt1 = Task.STATUS.CREATED;
                    if(stt.equals("Assigned")) stt1 = Task.STATUS.ASSIGNED;
                    if(stt.equals("Started")) stt1 = Task.STATUS.STARTED;
                    if(stt.equals("Done")) stt1 = Task.STATUS.DONE;
                    if(stt.equals("Completed")) stt1 = Task.STATUS.COMPLETED;
                    if(stt.equals("Reject")) stt1 = Task.STATUS.REJECT;
                    if(stt.equals("Closed")) stt1 = Task.STATUS.CLOSED;
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
                        User.TYPE tmp = null;
                        if(us[0].equals("Tester"))
                        {
                            tmp = User.TYPE.TESTER;
                            Tester t = new Tester(us[5],us[1],us[2],us[3]);
                            emp.add(t);
                        }
                        if (us[0].equals("Developer"))
                        {
                            tmp = User.TYPE.DEVELOPER;
                            Developer d = new Developer(us[5],us[1],us[2],us[3]);
                            emp.add(d);
                        }

                    }
                }
            }
        }
    }



    public void loadTask() throws IOException{
        FileInputStream fis = new FileInputStream(this.taskFile);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bfr = new BufferedReader(isr);
        this.listTask = new ArrayList<>();
        String line = bfr.readLine();
        int i = 0;
        while(line != null)
        {
            String prjID = line;
            line = bfr.readLine();
            String []array = line.split(" ");
            DATE start = null;
            if (array.length == 3 )
            {
                start.hour = array[0];
                start.day = array[1];
                start.month = array[2];
                start.year = array[3];

            }
            line = bfr.readLine();
            String []arr = line.split(" ");
            DATE end = null;
            if (array.length == 4 )
            {
                end.hour = array[0];
                end.day = array[1];
                end.month = array[2];
                end.year = array[3];

            }
            line = bfr.readLine();
            String stt = line;
            Task.STATUS stt1 = null ;
            if(stt.equals("Created")) stt1 = Task.STATUS.CREATED;
            if(stt.equals("Assigned")) stt1 = Task.STATUS.ASSIGNED;
            if(stt.equals("Started")) stt1 = Task.STATUS.STARTED;
            if(stt.equals("Done")) stt1 = Task.STATUS.DONE;
            if(stt.equals("Completed")) stt1 = Task.STATUS.COMPLETED;
            if(stt.equals("Reject")) stt1 = Task.STATUS.REJECT;
            if(stt.equals("Closed")) stt1 = Task.STATUS.CLOSED;
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



    public void saveUser() throws IOException {
        FileWriter writer = new FileWriter(this.userFile);
        BufferedWriter buffer = new BufferedWriter(writer);
        for(int i= 0;i<this.userList.size();i++)
        {
            this.userList.get(i).saveInFile(buffer);
        }
        buffer.close();
    }

    

    public void loadUser () throws IOException {
        FileInputStream fis = new FileInputStream(this.userFile);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bfr = new BufferedReader(isr);
        String line = bfr.readLine();
        while(line != null){
            String []array = line.split(",");
            if(array.length == 5)
            {
                if(array[0].equals("CEO"))
                {
                    CEO ceo = new CEO(array[4],array[1],array[2],array[3]);
                    this.userList.add(ceo);
                }
                if(array[0].equals("Developer"))
                {
                    Developer dev = new Developer(array[4],array[1],array[2],array[3]);
                    this.userList.add(dev);
                }
                if(array[0].equals("Manager"))
                {
                    Manager mn = new Manager(array[4],array[1],array[2],array[3]);
                    this.userList.add(mn);
                }
                if(array[0].equals("Tester"))
                {
                    Tester tst = new Tester(array[4],array[1],array[2],array[3]);
                    this.userList.add(tst);
                }
                
            }
                line = bfr.readLine();
        }
            fis.close();
            isr.close();
            bfr.close();
    }
    
    
}
