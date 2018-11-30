import UserData.CEO;
import UserData.Developer;
import UserData.Manager;
import UserData.Tester;
import UserData.User;

import java.util.ArrayList;
import java.io.File;
import java.util.Objects;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ProjectManager {
    private ArrayList<User> userList;
    private String userFile="user.txt";


    public ProjectManager() {
        this.userList = new ArrayList<>();
    }
    



    public void saveUser() throws IOException {
        FileWriter writer = new FileWriter(this.userFile);
        BufferedWriter buffer = new BufferedWriter(writer);
        for(int i= 0;i<this.userList.size();i++)
        {
            this.userList.get(i).saveInFile(buffer);
        }
        buffer.close();
    }

    

    public void loadUser () throws IOException {
        FileInputStream fis = new FileInputStream(this.userFile);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bfr = new BufferedReader(isr);
        String line = bfr.readLine();
        while(line != null){
            String []array = line.split(",");
            if(array.length == 5)
            {
                if(array[0].equals("CEO"))
                {
                    CEO ceo = new CEO(array[4],array[1],array[2],array[3]);
                    this.userList.add(ceo);
                }
                if(array[0].equals("Developer"))
                {
                    Developer dev = new Developer(array[4],array[1],array[2],array[3]);
                    this.userList.add(dev);
                }
                if(array[0].equals("Manager"))
                {
                    Manager mn = new Manager(array[4],array[1],array[2],array[3]);
                    this.userList.add(mn);
                }
                if(array[0].equals("Tester"))
                {
                    Tester tst = new Tester(array[4],array[1],array[2],array[3]);
                    this.userList.add(tst);
                }
                
            }
                line = bfr.readLine();
        }
            fis.close();
            isr.close();
            bfr.close();
    }
    
    
}
