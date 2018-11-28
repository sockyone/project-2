/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserData;

import java.util.List;

/**
 *
 * @author nghun
 */
public class CEO extends User {

    public CEO(String Username, String Password, String Realname, boolean CEOrole) {
        super(Username, Password, Realname, true);
    }
    
    
    
    public Project CreateProject(String namepj,Manager leader,int ID)
    {
        Project proj = new Project(namepj,leader.getManagerID(),ID);
        return proj;
    }
    public User CreateUser (String Username, String Password, String Realname, boolean CEOrole)
    {
        User new1 = new User(Username,Password,Realname,false);
        return new1;
    }
    public void PrintEmpl(List<Employee> emp)
    {
        for (int i = 0; i< emp.size();i++)
        {
            emp.get(i).toString();
            System.out.println();
        }
    }
}
