/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserData;

import java.util.Objects;

/**
 *
 * @author nghun
 */

public class User {
    public String Username;
    protected String Password;
    private String Realname;
    private boolean CEOrole;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRealname() {
        return Realname;
    }

    public void setRealname(String Realname) {
        this.Realname = Realname;
    }

    public User(String Username, String Password, String Realname, boolean CEOrole) {
        this.Username = Username;
        this.Password = Password;
        this.Realname = Realname;
        this.CEOrole = CEOrole;
    }

    public boolean isCEOrole() {
        return CEOrole;
    }

   
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.Username, other.Username)) {
            return false;
        }
        if (!Objects.equals(this.Password, other.Password)) {
            return false;
        }
        return true;
    }
    
    

}
