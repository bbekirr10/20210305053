import java.sql.*;
import java.util.ArrayList;

public class CustomerPurchase_DAL
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
        String cmd = "SELECT `id`,`creditcard`,`customerorderid`from customerpurchase";
        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);
            int say=0;
            int id,creditcard,customerorderid;
            System.out.println("Customer Purchase List");
            while(res.next())
            {
                id = res.getInt(1);
                creditcard = res.getInt(2);
                customerorderid = res.getInt(3);

                System.out.printf("Id= %d, CreditCard= %d, CustomerOrderId=%d  %n", id, creditcard, customerorderid);
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

    public ArrayList<CustomerPurchase> GetCustomerPurchase()
    {
        ArrayList<CustomerPurchase> cpList = new ArrayList<>();

        String cmd = "SELECT `id`,`creditcard`,`customerorderid` FROM customerpurchase";
        CustomerPurchase cp;
        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);
            while(res.next()) {
                cp = new CustomerPurchase();

                cp.id = res.getInt(1);
                cp.creditcard = res.getInt(2);
                cp.customerorderid = res.getInt(3);
                cpList.add(cp);
            }
            res.close();

        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        return cpList;
    }
}
