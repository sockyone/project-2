/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserData;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import UserData.Task;

/**
 *
 * @author nghun
 */
public class Project {
    public String name;
    public String prjID;
    public String mnID;
    public ArrayList<Task> task;
    
    public Project(String name, String prjID, String mnID, ArrayList<Task> task) {
        this.name = name;
        this.prjID = prjID;
        this.mnID = mnID;
        this.task = task;
        
    }

    public Project(String name, String prjID, String mnID) {
        this.name = name;
        this.prjID = prjID;
        this.mnID = mnID;
    }

    
    
    public void saveinFile(BufferedWriter buffer)   throws IOException {
        buffer.write(this.prjID);
        buffer.newLine();
        buffer.write(this.name);
        buffer.newLine();
        buffer.write(this.mnID);
        buffer.newLine();
        buffer.write("Task: ");
        buffer.newLine();
        for(int i = 0 ; i< this.task.size();i++)
        {
            this.task.get(i).saveInFile(buffer);
            buffer.newLine();
        }
        buffer.newLine();
        
    }

    public void CSV(BufferedWriter buffer)   throws IOException {
        buffer.write(this.name + "," +this.prjID + "," + this.mnID);
        buffer.newLine();
    }
    @Override
    public String toString() {
        return "Project{" + "name=" + name + ", prjID=" + prjID + ", mnID=" + mnID + '}';
    }
    
    
}

