import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployeeForm extends JFrame implements ActionListener {

    private TextField firstName;
    private TextField lastName;
    private TextField designation;
    private TextField email;
    private TextField telephone;
    private TextField age;

    public AddEmployeeForm() {
        setTitle("Add Employee");

        // Create the content pane with FlowLayout
        Container container= getContentPane();
        container.setLayout(new GridLayout(7,2));

        add(new Label("First Name :"));
        firstName = new TextField(20);
        add(firstName);
        add(new Label("Last Name :"));
        lastName = new TextField(20);
        add(lastName);
        add(new Label("Designation :"));
        designation = new TextField(20);
        add(designation);
        add( new Label("Email :"));
        email = new TextField(20);
        add(email);
        add(new Label("Telephone :"));
        telephone = new TextField(20);
        add(telephone);
        add(new Label("Age :"));
        age = new TextField(20);
        add(age);

        JButton submitBtn = new JButton("Submit");
        submitBtn.setFocusPainted(false);
        submitBtn.addActionListener(this::actionPerformed);
        JButton backBtn = new JButton("Back");
        backBtn.setFocusPainted(false);
        container.add(submitBtn);
        container.add(backBtn);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the size of the frame
        setSize(400, 400);

        // Set the frame to be visible
        setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AddEmployeeForm());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        DatabaseOperations databaseOperations = new DatabaseOperations();

        String firstNameText = firstName.getText().trim();
        String lastNameText = lastName.getText().trim();
        String designationText = designation.getText().trim();
        String emailText = email.getText().trim();
        String telePhoneText = telephone.getText().trim();
        String ageText = age.getText().trim();


        if(actionCommand == "Submit")
        {
            if(firstNameText.isEmpty())
            {
                JOptionPane.showMessageDialog(getContentPane(),"First Name is mandatory");
            }
            databaseOperations.save(firstNameText,lastNameText,designationText,
                   emailText,telePhoneText,ageText);
            firstName.setText("");
            lastName.setText("");
            designation.setText("");
            email.setText("");
            telephone.setText("");
            age.setText("");
        }

    }
}
