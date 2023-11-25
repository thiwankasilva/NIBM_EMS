import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerImpl implements MouseListener {

    private JTable empTable;
    public static int empId;

    public MouseListenerImpl(JTable empTable) {
        this.empTable = empTable;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        empId = (Integer) empTable.getValueAt(empTable.getSelectedRow(),0);
        System.out.println(empId);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
