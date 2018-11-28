/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserData;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nghun
 */
public class Project {
    public String name;
    public int manageID;
    public List<Employee> list ;
    public int prjID;
    public List<Task> task1;
    public int numberEmpl;
    
    public Project(String name, int manageID, int prjID) {
        this.name = name;
        this.manageID = manageID;
        this.prjID = prjID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManageID() {
        return manageID;
    }

    public void setManageID(int manageID) {
        this.manageID = manageID;
    }

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }

    public int getPrjID() {
        return prjID;
    }

    public void setPrjID(int prjID) {
        this.prjID = prjID;
    }

    public List<Task> getTask1() {
        return task1;
    }

    public void setTask1(List<Task> task1) {
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
    
}
