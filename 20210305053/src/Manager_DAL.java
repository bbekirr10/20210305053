import java.sql.*;
import java.util.ArrayList;

public class Manager_DAL
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
        String cmd = "SELECT `id`,`item`,`price`,`customername`,`customersurname`,`customeraddress`,`cargobranch`,`deliverydate`FROM manageritem";
        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);
            int say=0;
            int id,price;
            String item,customername,customersurname,customeraddress,cargobranch;
            Date deliverydate;
            System.out.println("Manager Order Detail List");
            while(res.next())
            {
                id = res.getInt(1);
                item = res.getString(2);
                price = res.getInt(3);
                customername = res.getString(4);
                customersurname = res.getString(5);
                customeraddress = res.getString(6);
                cargobranch = res.getString(7);
                deliverydate = res.getDate(8);

                System.out.printf("Id= %d, Item= %s, Price=%d, CustomerName=%s, CustomerSurname=%s, CustomerAddress=%s, CargoBranch=%s, DeliveryDate=%s   %n", id, item, price,customername,customersurname,customeraddress,cargobranch,deliverydate);
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
    public ArrayList<Manager> GetManager()
    {
        ArrayList<Manager> mngItem = new ArrayList<>();
        String cmd = "SELECT `id`,`item`,`price`,`customername`,`customersurname`,`customeraddress`,`cargobranch`,`deliverydate` FROM manageritem";
        Manager mngitem;
        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);
            while(res.next())
            {
                mngitem = new Manager();

                mngitem.id = res.getInt(1);
                mngitem.item = res.getString(2);
                mngitem.price = res.getInt(3);
                mngitem.customername= res.getString(4);
                mngitem.customersurname= res.getString(5);
                mngitem.customeraddress= res.getString(6);
                mngitem.cargobranch= res.getString(7);
                mngitem.deliverydate= res.getDate(8);
                mngItem.add(mngitem);
            }
            res.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return mngItem;
    }
}
