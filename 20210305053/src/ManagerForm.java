import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ManagerForm extends  JFrame{
    private JScrollBar scrollBar1;
    private JTable table1;
    private JPanel JPanel1;

    Manager_DAL mngDal;
    private ArrayList<Manager> mngList;
    private DefaultTableModel tblModel;
    private final String TableColName[] ={ "Id", "Item", "Price","CustomerName", "CustomerSurname", "CustomerAddress", "CargoBranch", "DeliverTime"};

    public ManagerForm()
    {
        setContentPane(JPanel1);
        setTitle("Online Shopping System"); // optional
        setMinimumSize(new Dimension(500,300) ); // optional
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        mngDal = new Manager_DAL();
        mngList = mngDal.GetManager();

        tblModel = (DefaultTableModel) table1.getModel();
        tblModel.setColumnIdentifiers(TableColName);
        UpdateTable();
    }

    private void UpdateTable()
    {
        while (tblModel.getRowCount()>0)
            tblModel.removeRow(0);
        for (Manager k: mngList) {
            String data[] = { String.valueOf(k.id), k.item, String.valueOf(k.price), k.customername,k.customersurname,k.customeraddress, k.cargobranch, String.valueOf(k.deliverydate)};
            tblModel.addRow(data);
        }
    }
    public static void main(String[] args)
    {
        new ManagerForm();
    }

}
