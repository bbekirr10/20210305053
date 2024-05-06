import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CustomerPurchaseForm extends JFrame {
    private JScrollBar scrollBar1;
    private JTable table1;
    private JPanel JPanel1;

    CustomerPurchase_DAL cpDal;
    private ArrayList<CustomerPurchase> cpList;
    private DefaultTableModel tblModel;
    private final String TableColName[] =
            { "Id", "CreditCard", "CustomerOrderId"};

    public  CustomerPurchaseForm()
    {
        setContentPane(JPanel1);
        setTitle("Online Shopping System"); // optional
        setMinimumSize(new Dimension(400,300) ); // optional
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        cpDal = new CustomerPurchase_DAL();
        cpList = cpDal.GetCustomerPurchase();

        tblModel = (DefaultTableModel) table1.getModel();
        tblModel.setColumnIdentifiers(TableColName);
        UpdateTable();
    }

    private void UpdateTable()
    {
        while (tblModel.getRowCount()>0)
            tblModel.removeRow(0);
        for (CustomerPurchase k: cpList) {
            String data[] = { String.valueOf(k.id),String.valueOf(k.creditcard),String.valueOf(k.customerorderid) };
            tblModel.addRow(data);
        }
    }
    public static void main(String[] args)
    {
        new CustomerPurchaseForm();
    }
}
