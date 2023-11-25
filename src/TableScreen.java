import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TableScreen extends JPanel {

    private  JTable table;
    private DefaultTableModel model;

    public TableScreen() {
        initializeUI();

    }
    private void initializeUI() {
         model = new DefaultTableModel();
        // Set column names
        model.setColumnIdentifiers(new Object[]{"ID", "FirstName", "LastName","Designation","Email","Telephone","Age"});
        // Retrieve data from the database
        fetchDataFromDatabase(model);
// Create the JTable with the DefaultTableModel
        model.fireTableDataChanged();
        table = new JTable(model);


        table.addMouseListener(new MouseListenerImpl(table));

        // Add the table to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the JScrollPane to the frame
        add(scrollPane);
        // Display the frame
        setVisible(true);
    }

    public void fetchDataFromDatabase(DefaultTableModel model) {
// JDBC connection parameters
        String url = "jdbc:mysql://localhost:3306/nibm";
        String username = "root";
        String password = "root";
        try {
// Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);
// Create a statement
            Statement statement = connection.createStatement();
// Execute a query to retrieve data
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
// Iterate through the result set and add data to the model
            while (resultSet.next()) {
                model.addRow(new Object[]{
                        resultSet.getInt("ID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("Designation"),
                        resultSet.getString("Email"),
                        resultSet.getString("Telephone"),
                        resultSet.getInt("Age")
                });
            }
            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getModel() {
        return model;
    }
}
