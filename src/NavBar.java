import javax.swing.*;
import java.awt.*;

public class NavBar extends JPanel {

    private JLabel topicLabel;
    private JTextField searchField;

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public NavBar() {
        setLayout(new FlowLayout(FlowLayout.LEFT,30,12));
        this.topicLabel = new JLabel();
        this.searchField = new JTextField(20);

        intializeUI();
    }
    private void intializeUI() {
        topicLabel.setText("Employee Management System - NIBM");
        topicLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        //add label to the layout
        add(topicLabel);
        add(searchField);
        //Search Button
        JButton searchBtn = new JButton("Search");
        searchBtn.setBackground(new Color(120,163,220));
        searchBtn.setFocusPainted(false);
        add(searchBtn);
        setBackground(new Color(97,163,186));

    }
}
