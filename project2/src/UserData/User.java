/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserData;

import java.io.File;
import java.util.Objects;

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
        return this.username;
    }
    public String getFullname() {
        return this.fullname;
    } 

    public Type getType() {
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

    public void saveInFile(String patch) {
	FileOutputStream fout = new FileOutputStream(patch);
        PrintStream pout = new PrintStream(fout);
	if (this.getType = Type.CEO) pout.println("CEO");
	if (this.getType = Type.CEO) pout.println("Manager");
	if (this.getType = Type.CEO) pout.println("Developer");
	if (this.getType = Type.CEO) pout.println("Tester");

        pout.println(this.getUserName);
	pout.println(this.getPassword);
	pout.println(this.getFullname);
        pout.close();
        fout.close();
    }
}


    }

}
