import java.sql.*;
import java.util.ArrayList;

public class CustomerLogin_DAL {


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
        String cmd = "SELECT `id`,`email`,`password` from customerlogin";
        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);
            int say=0;
            int id,password;
            String email;
            System.out.println("Customer Login List");
            while(res.next())
            {
                id = res.getInt(1);
                email= res.getString(2);
                password = res.getInt(3);
                System.out.printf("Id= %d, Email= %s Password=%d %n", id, email, password);
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
    public ArrayList<CustomerLogin> GetCustomerLogin()
    {
        ArrayList<CustomerLogin> clList = new ArrayList<>();

        String cmd = "SELECT `id`,`email`,`password` FROM customerlogin";
        CustomerLogin cl;
        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);
            while(res.next()) {
                cl = new CustomerLogin();

                cl.id = res.getInt(1);
                cl.email = res.getString(2);
                cl.password = res.getInt(3);
                clList.add(cl);
            }
            res.close();

        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        return clList;
    }
}
