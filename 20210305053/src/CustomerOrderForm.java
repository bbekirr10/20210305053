import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CustomerOrderForm extends JFrame {
    private JScrollBar scrollBar1;
    private JTable table1;
    private JPanel JPanel1;

    CustomerOrder_DAL coDal;
    private ArrayList<CustomerOrder> coList;
    private DefaultTableModel tblModel;
    private final String TableColName[] =
            { "Id", "Name", "Surname", "Address", "Details" };

    public  CustomerOrderForm()
    {
        setContentPane(JPanel1);
        setTitle("Online Shopping System"); // optional
        setMinimumSize(new Dimension(550,300) ); // optional
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        coDal = new CustomerOrder_DAL();
        coList = coDal.GetCustomerOrder();

        tblModel = (DefaultTableModel) table1.getModel();
        tblModel.setColumnIdentifiers(TableColName);
        UpdateTable();
    }
    private void UpdateTable()
    {

        while (tblModel.getRowCount()>0)
            tblModel.removeRow(0);

        for (CustomerOrder k: coList) {
            String data[] = { String.valueOf(k.id), k.name,k.surname,k.address, k.item, String.valueOf(k.price)};
            tblModel.addRow(data);
        }

    }
    public static void main(String[] args)
    {
        new CustomerOrderForm();
    }
}
