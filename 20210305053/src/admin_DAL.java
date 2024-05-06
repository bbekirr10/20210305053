import java.sql.*;
import java.util.ArrayList;

public class admin_DAL
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
        String cmd = "SELECT `id`,`category`,`item`,`price` from admin";
        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);
            int say=0;
            int id,price;
            String category,item;
            System.out.println("Admin List");
            while(res.next())
            {
                id = res.getInt(1);
                category= res.getString(2);
                item = res.getString(3);
                price=res.getInt(4);
                System.out.printf("Id= %d, Category= %s, İtem=%s, Price=%d %n", id, category, item,price);
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

    public ArrayList<admin> GetAdmin()
    {
        ArrayList<admin> adList = new ArrayList<>();

        String cmd = "SELECT `id`,`category`,`item`,`price` FROM admin";
        admin ad;
        try (Connection conn = DriverManager.getConnection(conUrl, user, pass);)
        {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);
            while(res.next()) {
                ad = new admin();

                ad.id = res.getInt(1);
                ad.category = res.getString(2);
                ad.item = res.getString(3);
                ad.price= res.getInt(4);
                adList.add(ad);
            }
            res.close();

        } catch (
                SQLException e) {
            System.out.println(e.getMessage());
        }
        return adList;
    }
}
