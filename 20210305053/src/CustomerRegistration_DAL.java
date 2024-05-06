import java.sql.*;
import java.util.ArrayList;

public class CustomerRegistration_DAL
{
    String user="bekir", pass="bekir123";
    String conUrl = "jdbc:mysql://localhost/20210305053";
    public void Access()
    {
        try
        {
            Connection conn = DriverManager.getConnection(conUrl, user, pass);
            System.out.println("Connected to MySql server.....");
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void ListToConsole()
    {
        String cmd = "SELECT `id`,`name`,`surname`,`email`,`password` from customerregistration";
        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);
            int say=0;
            int id,password;
            String name,surname,email;
            System.out.println("Customer Registration List");
            while(res.next())
            {
                id = res.getInt(1);
                name = res.getString(2);
                surname = res.getString(3);
                email= res.getString(4);
                password = res.getInt(5);
                System.out.printf("Id= %d, Name= %s Surname=%s Email=%s Password=%d %n", id, name, surname,email,password);
                say++;
            }
            System.out.println("End of List.");
            res.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<CustomerRegistration> GetCustomerRegistration()
    {
        ArrayList<CustomerRegistration> crList = new ArrayList<>();

        String cmd = "SELECT `id`,`name`,`surname`,`email`,`password` FROM customerregistration";
        CustomerRegistration cr;

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);
            while(res.next()) {
                cr = new CustomerRegistration();

                cr.id = res.getInt(1);
                cr.name = res.getString(2);
                cr.surname = res.getString(3);
                cr.email = res.getString(4);
                cr.password = res.getInt(5);
                crList.add(cr);
            }
            res.close();

        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        return crList;
    }
}
