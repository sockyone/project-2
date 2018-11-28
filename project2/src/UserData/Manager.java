/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserData;

/**
 *
 * @author nghun
 */
public class Manager extends User {
    
    public int managerID;

    public Manager(int managerID, String Username, String Password, String Realname,boolean CEOrole) {
        super(Username, Password, Realname,false);
        this.managerID = managerID;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }
    private Project addEmp(Project pj,Employee emp)
    {
        pj.AddiEmpl(emp);
        return pj;
    }
     
}
