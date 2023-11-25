import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class EmployeMainScreen extends JFrame implements ActionListener {
    private JPanel navBarPanel;
    private TableScreen tableView;

    public EmployeMainScreen() throws HeadlessException {
        super("NIBM Employees");
        this.navBarPanel = new NavBar();
        initializeUI();
    }

    private void initializeUI() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(navBarPanel,BorderLayout.NORTH);
        JPanel subScreen = new JPanel();
        subScreen.setLayout(new BorderLayout());
        JLabel tableTitle = new JLabel();
        tableTitle.setText("Employee Table");
        tableTitle.setHorizontalAlignment(SwingConstants.CENTER);
        tableTitle.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        subScreen.add(tableTitle,BorderLayout.NORTH);
        //initializing table
        tableView = new TableScreen();
        subScreen.add(tableView,BorderLayout.CENTER);


        //Adding the CRUD operational panel
        //Add Button
        JButton addBtn = new JButton("Add Employee");
        addBtn.addActionListener(this);
        addBtn.setFocusPainted(false);
        //Delete Button
        JButton deleteBtn = new JButton("Delete Employee");
        deleteBtn.addActionListener(this);
        deleteBtn.setFocusPainted(false);
        //Update Button
        JButton updateBtn = new JButton("Update Employee");
        updateBtn.addActionListener(this);
        updateBtn.setFocusPainted(false);

        JPanel operationPanel = new JPanel();
        operationPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,15));
        operationPanel.add(addBtn);
        operationPanel.add(deleteBtn);
        operationPanel.add(updateBtn);

        subScreen.add(operationPanel,BorderLayout.SOUTH);
        container.add(subScreen,BorderLayout.CENTER);

        setSize(new Dimension(800,600));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new EmployeMainScreen();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        DatabaseOperations databaseOperations = new DatabaseOperations();

        String clickedButton = e.getActionCommand();

        if(Objects.equals(clickedButton, "Delete Employee"))
        {
            databaseOperations.deleteEmployee();
            //table auto refreshing
            tableView.getModel().setRowCount(0);
            tableView.fetchDataFromDatabase(tableView.getModel());

            System.out.println("I'm going to delete from the database");
        }else if(Objects.equals(clickedButton, "Add Employee"))
        {
            setVisible(false);
            AddEmployeeForm form = new AddEmployeeForm();
            //System.out.println("I'm going to add a record");
        }else if(Objects.equals(clickedButton, "Update Employee"))
        {
            System.out.println("I'm going to update a record");
        }
        //System.out.println(clickedButton);
    }
}
