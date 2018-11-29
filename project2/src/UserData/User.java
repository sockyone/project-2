/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserData;

import java.io.File;
import java.util.Objects;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;


/**
 *
 * @author nghun
 */

public class User {

    protected enum TYPE {
        MANAGER, DEVELOPER, TESTER, CEO
    }

    protected String userName;
    protected String password;
    protected String fullName;
    protected TYPE type;

    public User() {

    }

    public User(String userName, String password, String fullName) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = this.MD5(password);
    }

    public String getPassword() {
        return this.password;
    }
    public String getUsername() {
        return this.userName;
    }
    public String getFullname() {
        return this.fullName;
    } 

    public TYPE getType() {
	return this.type;
    }


    private String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {

        }
        return null;
    }

    public boolean checkPassword(String password) {
        if (this.MD5(password).equals(this.password)) return true;
        return false;
    }

    public void saveInFile(String patch)   throws IOException {
        FileWriter writer = new FileWriter(patch);
        BufferedWriter buffer = new BufferedWriter(writer);
        if(this.getType() == TYPE.CEO ) buffer.write("CEO,");
        if(this.getType() == TYPE.DEVELOPER ) buffer.write("Develper,");
        if(this.getType() == TYPE.MANAGER ) buffer.write("Manager,");
        if(this.getType() == TYPE.TESTER ) buffer.write("Tester,");
        buffer.write(this.getUsername());
        buffer.write(",");
        buffer.write(this.getPassword());
        buffer.write(",");
        buffer.write(this.getFullname());
        buffer.newLine();
        buffer.close();
    }

}
