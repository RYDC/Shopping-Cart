import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author Ryan Jbaili, RealNub
 */
public class AddItem extends JFrame implements ActionListener {
    private JFrame frame;
    private JPanel panel;

    public AddItem() {
        frame = new JFrame("Add An Item");
        panel = new JPanel();
        panel.setLayout (null);
        JLabel label = new JLabel("New Item");
        label.setBounds (400,20,200,50);
        panel.add(label);

        JLabel name = new JLabel("Product Name:");
        name.setBounds(100,100,100,50);
        panel.add(name);

        JLabel price = new JLabel("Price:");
        name.setBounds(100,125,100,50);
        panel.add(price);

        JLabel quantity = new JLabel("Quantity:");
        name.setBounds(100,150,100,50);
        panel.add(quantity);

        JLabel description = new JLabel("Description:");
        name.setBounds(100,100,200,50);
        panel.add(description);
        frame.add(panel);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}