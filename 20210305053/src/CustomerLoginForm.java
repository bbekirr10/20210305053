import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CustomerLoginForm extends JFrame {

    private JTable table1;
    private JScrollBar scrollBar1;
    private JPanel JPanel1;

    CustomerLogin_DAL cDal;
    private ArrayList<CustomerLogin> clist;
    private DefaultTableModel tblModel;
    private final String TableColName[] =
            { "Id", "Email", "Password" };

    public  CustomerLoginForm()
    {
        setContentPane(JPanel1);
        setTitle("Online Shopping System"); // optional
        setMinimumSize(new Dimension(500,300) ); // optional
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);



        cDal = new CustomerLogin_DAL();
        clist = cDal.GetCustomerLogin();

        tblModel = (DefaultTableModel) table1.getModel();
        tblModel.setColumnIdentifiers(TableColName);
        UpdateTable();
    }
    private void UpdateTable()
    {

        while (tblModel.getRowCount()>0)
            tblModel.removeRow(0);

        for (CustomerLogin k: clist) {
            String data[] = { String.valueOf(k.id), k.email, String.valueOf(k.password)};
            tblModel.addRow(data);
        }
    }
    public static void main(String[] args)
    {
        new CustomerLoginForm();
    }

}
