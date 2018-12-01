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
    public int numberEmpl;

    public Project(String name, Manager mn, ArrayList<User> list, String prjID, ArrayList<Task> task1) {
        this.name = name;

        this.prjID = prjID;
    }
    
   


    
    public void saveinFile(BufferedWriter buffer)   throws IOException {
        buffer.write(this.getPrjID());
        buffer.newLine();
        buffer.write(this.getName());
        buffer.newLine();
        buffer.write(this.getManageID());
        buffer.newLine();
        buffer.write("Task: ");
        buffer.newLine();
        for(int i = 0 ; i< this.task1.size();i++)
        {
            this.task1.get(i).saveInFile(buffer);
            buffer.newLine();
        }
        buffer.newLine();
        buffer.write("Employees ");
        buffer.newLine();
        for(int i = 0 ; i< this.list.size();i++)
        {
            this.list.get(i).saveInFile(buffer);
        }
        buffer.newLine();
    }
    
}
