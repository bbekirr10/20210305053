import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("\n**********ONLINE SHOPPING SYSTEM**********\n");
        while (true)
        {
            System.out.println("1-List logged in customer.");
            System.out.println("2-List registered customer.");
            System.out.println("3-List Items");
            System.out.println("4-List Order Details");
            System.out.println("5-List Purchases");
            System.out.println("6-Admin Panel");
            System.out.println("7-Manager");
            System.out.println("8-Exit");
            System.out.print("Choose:");
            int chose=input.nextInt();
            if (chose==1)
            {
                System.out.println(" ");
                CustomerLogin_DAL clDal = new CustomerLogin_DAL();
                clDal.ListToConsole();
                System.out.println(" ");
            }
            else if(chose==2)
            {
                System.out.println(" ");
                CustomerRegistration_DAL cr=new CustomerRegistration_DAL();
                cr.ListToConsole();
                System.out.println(" ");
            }
            else if(chose==3)
            {
                System.out.println(" ");
                Items_DAL items = new Items_DAL();
                items.ListToConsole();
                System.out.println(" ");
            }
            else if(chose==4)
            {
                System.out.println(" ");
                CustomerOrder_DAL co= new CustomerOrder_DAL();
                co.ListToConsole();
                System.out.println(" ");
            }
            else if(chose==5)
            {
                System.out.println(" ");
                CustomerPurchase_DAL cp = new CustomerPurchase_DAL();
                cp.ListToConsole();
                System.out.println(" ");
            }
            else if(chose==6)
            {
                System.out.println(" ");
                admin_DAL ad = new admin_DAL();
                ad.ListToConsole();
                System.out.println(" ");
            }
            else if(chose==7)
            {
            System.out.println(" ");
            Manager_DAL mng = new Manager_DAL();
            mng.ListToConsole();
            System.out.println(" ");
            }

            else if(chose==8)
            {
                System.out.println("See you later...");
                break;
            }
        }
    }
}