import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class adminform extends JFrame {
    private JScrollBar scrollBar1;
    private JTable table1;
    private JPanel JPanel1;

    admin_DAL adDal;
    private ArrayList<admin> adList;
    private DefaultTableModel tblModel;
    private final String TableColName[]={ "Id", "Category", "Item" };

    public  adminform()
    {
        setContentPane(JPanel1);
        setTitle("Online Shopping System"); // optional
        setMinimumSize(new Dimension(500,300) ); // optional
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        adDal = new admin_DAL();
        adList = adDal.GetAdmin();

        tblModel = (DefaultTableModel) table1.getModel();
        tblModel.setColumnIdentifiers(TableColName);
        UpdateTable();
    }
    private void UpdateTable()
    {
        while (tblModel.getRowCount()>0)
            tblModel.removeRow(0);
        for (admin k: adList) {
            String data[] = { String.valueOf(k.id), k.category, k.item};
            tblModel.addRow(data);
        }
    }
    public static void main(String[] args)
    {
        new adminform();
    }

}
