import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class CustomerRegistrationForm extends JFrame {
    private JScrollBar scrollBar1;
    private JTable table1;
    private JPanel JPanel1;


    CustomerRegistration_DAL crDal;
    private ArrayList<CustomerRegistration> crlist;
    private DefaultTableModel tblModel;
    private final String TableColName[] =
            { "Id", "Name", "Surname", "Email", "Password" };

    public  CustomerRegistrationForm()
    {
        setContentPane(JPanel1);
        setTitle("Online Shopping System"); // optional
        setMinimumSize(new Dimension(600,300) ); // optional
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        crDal = new CustomerRegistration_DAL();
        crlist = crDal.GetCustomerRegistration();

        tblModel = (DefaultTableModel) table1.getModel();
        tblModel.setColumnIdentifiers(TableColName);
        UpdateTable();
    }
    private void UpdateTable()
    {

        while (tblModel.getRowCount()>0)
            tblModel.removeRow(0);

        for (CustomerRegistration k: crlist) {
            String data[] = { String.valueOf(k.id), k.name,k.surname,k.email, String.valueOf(k.password)};
            tblModel.addRow(data);
        }
    }
    public static void main(String[] args)
    {
        new CustomerRegistrationForm();
    }
}
