
import UserData.CEO;
import UserData.Employee;
import UserData.Manager;
import UserData.User;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nghun
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //User us1 = new User("thanh","123456","Nguyen Viet Thanh",false);
        CEO ceo = new CEO("huvii","123456","Nguyen Viet Hung",true);
        Manager mn1 = new Manager(01704,"bloom","19121999","Nguyen huyen Thanh",false);
        List<Employee> emp = null ;
        //List<Manager> mn1 = null ;
        System.out.println("username: ");
        String usname;
        Scanner  sc = new Scanner(System.in);
        usname = sc.nextLine();
        System.out.println("password: ");
        String passs;
        Scanner  sc0 = new Scanner(System.in);
        passs = sc0.nextLine();

        int count = 0;
        if (usname.equals(ceo.getUsername()) )
        {
            System.out.println("Chon chuc nang ");
            
            System.out.println("1.Tao Project moi");
            System.out.println("2.Tao User moi");
            System.out.println("3.In danh sach User");
            int n;
            Scanner sc1 = new Scanner(System.in);
            n = sc1.nextInt();
            switch (n){
                case 1 :
                {
                    //System.out.println("Tao Project moi ");
                    System.out.println("Ten du an ");
                    String namae;
                    Scanner  sc3 = new Scanner(System.in);
                    namae = sc3.nextLine();
                    System.out.println("ID du an ");
                    int ID;
                    Scanner  sc4 = new Scanner(System.in);
                    ID = sc4.nextInt();
                    
                    System.out.println("Chon quan ly ");
                    for (int i = 0 ; i <= mn1.size();i++)
                    {
                        mn1.get(i).toString();
                        System.out.println();
                    }
                    int mnID;
                    Scanner sc2 = new Scanner(System.in);
                    mnID = sc2.nextInt();
                    for (int i = 0 ; i <= mn1.size();i++)
                    {
                        if (mnID == mn1.get(i).getManagerID())
                            ceo.CreateProject(namae, mn1.get(i), ID);
                           
                    }
                }
                case 2 :
                {
                    System.out.println("Ten User ");
                    String namae;
                    Scanner  sc3 = new Scanner(System.in);
                    namae = sc3.nextLine();
                    System.out.println("ID User ");
                    int ID;
                    Scanner  sc2 = new Scanner(System.in);
                    ID = sc2.nextInt();
                    System.out.println("Ten That ");
                    String name;
                    Scanner  sc4 = new Scanner(System.in);
                    name = sc4.nextLine();
                    System.out.println("Password ");
                    String pass;
                    Scanner  sc6 = new Scanner(System.in);
                    pass = sc6.nextLine();
                    ceo.CreateUser(namae, pass, name, false);
                }
                case 3 :
                {
                    System.out.println("Danh sach nhan vien ");
                    ceo.PrintEmpl(emp);
                }
        }
        
        
        
    }
       // if (usname.equals(mn1.getUsername()) )
           
    
}
