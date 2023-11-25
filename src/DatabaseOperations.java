import java.sql.*;

public class DatabaseOperations {

    private Connection connection;

    public DatabaseOperations() {
        String url = "jdbc:mysql://localhost:3306/nibm";
        String username = "root";
        String password = "root";
        try{
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);
            // Create a statement

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void deleteEmployee() {
        StringBuilder sb = new StringBuilder("DELETE FROM Employee WHERE ID = ?");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sb.toString());
            preparedStatement.setString(1, String.valueOf(MouseListenerImpl.empId));

            int updated = preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }


    public void save(String firstNameText, String lastNameText, String designationText,
                     String emailText, String telePhoneText, String ageText) {

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("INSERT INTO `nibm`.`employee` (`FirstName`, `LastName`, " +
            "`Designation`, `Email`, `Telephone`, `Age`)" +
            " VALUES (?,?,?,?,?,?)");

    try {
        PreparedStatement preparedStatement = connection.prepareStatement(stringBuilder.toString());
        preparedStatement.setString(1,firstNameText);
        preparedStatement.setString(2,lastNameText);
        preparedStatement.setString(3,designationText);
        preparedStatement.setString(4,emailText);
        preparedStatement.setString(5,telePhoneText);
        preparedStatement.setString(6,ageText);

        int updatedRows = preparedStatement.executeUpdate();
        System.out.println(updatedRows + " Record Added Successfully");
        preparedStatement.close();
    }
    catch (SQLException e)
    {
        e.printStackTrace();
    }
    finally {
        try {
            connection.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }




    }
}
