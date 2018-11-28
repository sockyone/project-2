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
public class Task {
    public int prjID;
    public List<Developer> developerID;
    public List<Tester> testerID;
    public Date createdDate;
    public Date endDate;
    //public Status stt;

    public Task(int prjID, List<Developer> developerID, List<Tester> testerID, Date createdDate, Date endDate) {
        this.prjID = prjID;
        this.developerID = developerID;
        this.testerID = testerID;
        this.createdDate = createdDate;
        this.endDate = endDate;
    }
    
}
