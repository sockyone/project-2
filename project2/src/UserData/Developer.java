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
public class Developer extends Employee {
    
    public Developer(int employeeID, String Username, String Password, String Realname , boolean CEOrole) {
        super(employeeID, Username, Password, Realname,false);
    }
    
    
}
