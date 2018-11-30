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
    public Manager mn;
    public ArrayList<User> list ;
    public String prjID;
    public ArrayList<Task> task1;
    public int numberEmpl;

    public Project(String name, Manager mn, ArrayList<User> list, String prjID, ArrayList<Task> task1) {
        this.name = name;
        this.mn = mn;
        this.list = list;
        this.prjID = prjID;
        this.task1 = task1;
    }
    
   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManageID() {
        return mn.getId();
    }

    public void setManageID(Manager mnn) {
        this.mn.setId(mnn.getId());
    }

    public ArrayList<User> getList() {
        return list;
    }

    public void setList(ArrayList<User> list) {
        this.list = list;
    }

    public String getPrjID() {
        return prjID;
    }

    public void setPrjID(String prjID) {
        this.prjID = prjID;
    }

    public ArrayList<Task> getTask1() {
        return task1;
    }

    public void setTask1(ArrayList<Task> task1) {
        this.task1 = task1;
    }

    public int getNumberEmpl() {
        return numberEmpl;
    }

    public void setNumberEmpl(int numberEmpl) {
        this.numberEmpl = numberEmpl;
    }
    
    public void AddiEmpl(Employee emp1)
    {
        numberEmpl++;
        list.add(emp1);
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
            this.task1.get(i).saveinFile(buffer);
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
