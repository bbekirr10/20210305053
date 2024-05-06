import java.sql.*;
import java.util.ArrayList;

public class CustomerOrder_DAL
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
        String cmd = "SELECT `id`,`name`,`surname`,`address`,`item`,`price` from customerorder";
        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);
            int say=0;
            int id,price;
            String name,surname,address,item;
            System.out.println("Customer Order List");
            while(res.next())
            {
                id = res.getInt(1);
                name=res.getString(2);
                surname=res.getString(3);
                address=res.getString(4);
                item=res.getString(5);
                price=res.getInt(6);


                System.out.printf("Id= %d, Name=%s, Surname=%s, Address=%s, Item=%s, Price=%d  %n",id,name,surname,address,item,price);
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
    public ArrayList<CustomerOrder> GetCustomerOrder()
    {
        ArrayList<CustomerOrder> coList = new ArrayList<>();

        String cmd = "SELECT `id`,`name`,`surname`,`address`,`item`,`price` FROM customerorder";
        CustomerOrder co;

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);
            while(res.next()) {
                co = new CustomerOrder();

                co.id = res.getInt(1);
                co.name = res.getString(2);
                co.surname = res.getString(3);
                co.address = res.getString(4);
                co.item = res.getString(5);
                co.price= res.getInt(6);
                coList.add(co);
            }
            res.close();

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return coList;
    }

}
