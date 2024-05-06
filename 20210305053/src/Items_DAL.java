import java.sql.*;
import java.util.ArrayList;

public class Items_DAL
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
        String cmd = "SELECT `id`,`name`,`price`,`brand` from items";
        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);
            int say=0;
            int id,price;
            String name,brand;
            System.out.println("Items List");
            while(res.next())
            {
                id = res.getInt(1);
                name = res.getString(2);
                price = res.getInt(3);
                brand= res.getString(4);
                System.out.printf("Id= %d Name= %s Price=%d Brand=%s  %n", id, name, price,brand);
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
    public ArrayList<Items> GetItems()
    {
        ArrayList<Items> itemList = new ArrayList<>();

        String cmd = "SELECT `id`,`name`,`price`,`brand` FROM items";
        Items items;
        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);
            while(res.next()) {
                items = new Items();

                items.id = res.getInt(1);
                items.name = res.getString(2);
                items.price = res.getInt(3);
                items.brand = res.getString(4);
                itemList.add(items);
            }
            res.close();

        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        return itemList;
    }
}
