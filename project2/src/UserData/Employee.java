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
public class Employee extends User {
    public int employeeID;

    public Employee(int employeeID, String Username, String Password, String Realname, boolean CEOrole) {
        super(Username, Password, Realname,false);
        this.employeeID = employeeID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeID=" + employeeID + '}';
    }
    
}
