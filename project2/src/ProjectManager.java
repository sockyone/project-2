import UserData.*;
import UserData.Task.STATUS;

import java.sql.SQLOutput;
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
import java.util.Scanner;

public class ProjectManager {
    private ArrayList<User> userList;
    private String userFile="user.txt";
    private final String projectFile="project.txt";
    private final String taskFile = "task.txt";
    private ArrayList<Project> listProject;
    private ArrayList<Task> listTask;
    private User user;
    private Scanner scn;
    private final String projectCSV = "projectCSV.txt"; 


    public ProjectManager() {
        this.userList = new ArrayList<>();
        this.listProject = new ArrayList<>();
        this.listTask = new ArrayList<>();
        scn = new Scanner(System.in);
    }

    public void run() throws IOException {
        System.out.println("Loading...");
        try {
            loadUser();
            loadProject();
            loadTask();
        } catch (IOException e) {
            System.out.println("Can't load. Something wrong with your file.");
            return;
        }
        System.out.println("Loading complete.");
        if (!login()) return;

        while (true) {
            System.out.println("Choose: ");
            System.out.println("1. Project list");
            System.out.println("2. Task joined");
            System.out.println("3. User list");
            System.out.println("4. Employee list");
            System.out.println("5. Close");

            boolean isBreak = false;
            int choose;
            try {
                choose = Integer.parseInt(scn.nextLine());
            } catch (Exception e) {
                continue;
            }

            if (choose > 5 || choose < 1) {
                System.out.println("Invalid.");
                continue;
            }

            switch (choose) {
                case 1: projectListDisplay(); break;
                case 2: taskJoinedDisplay(); break;
                case 3: userListDisplay(); break;
                case 4: employeeListDisplay(); break;
                case 5:
                    System.out.println("closing...");
                    isBreak = true;
                    break;
            }
            if (isBreak) break;
        }

    }
    private boolean login() {
        System.out.println("Enter Username :");
        String UserName = scn.nextLine();
        int cnt = 1;
        for(int i = 0;i<this.userList.size();i++)
        {
            if(this.userList.get(i).getUserName().equals(UserName))
            {
                System.out.println("Enter Password :");
                String Password = scn.nextLine();
                int count = 1;
                while(this.userList.get(i).checkPassword(Password) != true && count <= 3)
                {
                    System.out.println("Wrong Password, Enter Password again :");
                    Password = scn.nextLine();
                    count++;
                }
                if(this.userList.get(i).checkPassword(Password) == true ) return true;
                else return false;
                
            }
            else 
            {
                while(this.userList.get(i).getUserName() != UserName && cnt <=3)
                {
                    System.out.println("Enter Username again :");
                    UserName = scn.nextLine();
                    cnt++;
                }
                if (this.userList.get(i).getUserName() == UserName ) return true;
                else return false;
            }
                        
        }

        
        return true;
    }

    private void projectListDisplay() throws IOException {
        if (this.user.getType() == User.TYPE.CEO) showAllProjectAndTaskCount();
        else showProjectAndTaskCountFromId();

        while (true) {
            System.out.println("1. Create new project (CEO only)");
            System.out.println("2. Show task");
            System.out.println("3. CSV project info");
            System.out.println("4. Cancel");
            boolean isBreak = false;
            int choose;
            try {
                choose = Integer.parseInt(scn.nextLine());
            } catch (Exception e) {
                continue;
            }

            if (choose > 4 || choose < 1) {
                System.out.println("Invalid.");
                continue;
            }

            switch (choose) {
                case 1: createNewProject(); break;
                case 2: showTaskInProject(); break;
                case 3: printProjectToCSV(); break;
                case 4: isBreak = true; break;
            }
            if (isBreak) break;
        }
    }

    private void showAllProjectAndTaskCount() {
        System.out.println("Project: ");
        for (int i = 0;i< this.listProject.size();i++)
        {
            this.listProject.get(i).toString();
            System.out.println();
        }
        int avl =0;
        System.out.println("Task available: ");
        for (int i = 0;i< this.listTask.size();i++)
        {
            if(this.listTask.get(i).status != STATUS.CLOSED ) 
            {
                avl++;
            }
        }
        int jn = 0;
        System.out.println("Task closed: ");
        for (int i = 0;i< this.listTask.size();i++)
        {
            if(this.listTask.get(i).status == STATUS.CLOSED ) 
            {
                jn++;
            }
        }

    }

    private void showProjectAndTaskCountFromId() {
        System.out.println("Project joined: ");
        for (int i = 0;i< this.listProject.size();i++)
        {
            if(this.user.getId() == this.listProject.get(i).mnID ) 
            {
                System.out.print(this.listProject.get(i).name + " " + this.listProject.get(i).prjID);
                System.out.println();
            }
           
                
        }
        System.out.println("Task joined: ");
        int count = 0;
        for (int i = 0;i< this.listTask.size();i++)
        {
            for(int j = 0;j<this.listTask.get(i).developer.size();j++)
                {
                    if (this.user.getId() == this.listTask.get(i).developer.get(j).getId() )
                    {
                        count ++;
                    }
                }
            }
        for (int i = 0;i< this.listTask.size();i++)
        {
            for(int j = 0;j<this.listTask.get(i).tester.size();j++)
                {
                    if (this.user.getId() == this.listTask.get(i).tester.get(j).getId() )
                    {
                        count ++;
                    }
                }
            }
        System.out.print(count);
    }
    


    private void createNewProject()
    {
        if (this.user.getType() != User.TYPE.CEO) {
            System.out.println("You have to be CEO to create new project.");
            return;
        }
        else 
        {
            System.out.println("Name of new Project");
            String prjName = scn.nextLine();
            System.out.println("ID of new Project");
            String prjID = scn.nextLine();
            System.out.println("ManagerId of new Project");
            String mnID = scn.nextLine();
            Project newProject = new Project(prjName,prjID,mnID);
            this.listProject.add(newProject);
            
                       
            
        }
    }



    private void showTaskInProject() {
        

    }

    private void printProjectToCSV() throws IOException {
        FileWriter writer = new FileWriter(this.projectCSV);
        BufferedWriter buffer = new BufferedWriter(writer);
        for (int i =0;i<this.listProject.size();i++)
        {
            this.listProject.get(i).CSV(buffer);
        }

    }

    private void taskJoinedDisplay() {
        if (this.user.getType() == User.TYPE.CEO) {
            System.out.println("You have no permision.");
            return;
        }
        



    }

    private void userListDisplay() {
        if (this.user.getType() != User.TYPE.CEO) {
            System.out.println("Only CEO have permission for this option.");
            return;
        }
        for(int i = 0; i< this.userList.size();i++)
            {
                this.userList.get(i).toString();
                System.out.println();
            }




    }

    private void employeeListDisplay() {
        if (this.user.getType() != User.TYPE.MANAGER || this.user.getType() != User.TYPE.CEO) {
            System.out.println("You have no permission");
            System.out.println("Only Manager & CEO");
            return;
        }
        for(int i = 0; i< this.userList.size();i++)
            {
                this.userList.get(i).toString();
                System.out.println();
            }



    }


    private void loadProject() throws IOException {
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
                while(line != null)
                {
                    String []array = line.split("/");
                    Date start = new Date();
                    if (array.length == 3 )
                    {
                        start.day = array[0];
                        start.month = array[1];
                        start.year = array[2];

                    }
                    line = bfr.readLine();
                    String []arr = line.split("/");
                    Date end = new Date();
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
                
            }
            Project ttp = new Project(pjName,prjID,mnID,task);
            this.listProject.add(ttp);
            line = bfr.readLine();
        }
    }



    private void loadTask() throws IOException{
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
            Date start = new Date();
            if (array.length == 3 )
            {
                start.hour = array[0];
                start.day = array[1];
                start.month = array[2];
                start.year = array[3];

            }
            line = bfr.readLine();
            String []arr = line.split(" ");
            Date end = new Date();
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



    private void saveUser() throws IOException {
        FileWriter writer = new FileWriter(this.userFile);
        BufferedWriter buffer = new BufferedWriter(writer);
        for(int i= 0;i<this.userList.size();i++)
        {
            this.userList.get(i).saveInFile(buffer);
        }
        buffer.close();
    }

    

    private void loadUser () throws IOException {
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
