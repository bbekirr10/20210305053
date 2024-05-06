import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ItemsForm extends JFrame{
    private JPanel JPanel1;
    private JScrollBar scrollBar1;
    private JTable table1;

    Items_DAL itemsDal;
    private ArrayList<Items> itemList;
    private DefaultTableModel tblModel;
    private final String TableColName[] =
            { "Id", "Name", "Price", "Brand" };

    public  ItemsForm()
    {
        setContentPane(JPanel1);
        setTitle("Online Shopping System"); // optional
        setMinimumSize(new Dimension(500,300) ); // optional
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        itemsDal = new Items_DAL();
        itemList = itemsDal.GetItems();

        tblModel = (DefaultTableModel) table1.getModel();
        tblModel.setColumnIdentifiers(TableColName);
        UpdateTable();
    }

    private void UpdateTable()
    {
        while (tblModel.getRowCount()>0)
            tblModel.removeRow(0);
        for (Items k: itemList) {
            String data[] = { String.valueOf(k.id), k.name, String.valueOf(k.price),k.brand};
            tblModel.addRow(data);
        }
    }
    public static void main(String[] args)
    {
        new ItemsForm();
    }
}
