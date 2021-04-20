package Customer;

import DataObjects.Product;

import javax.swing.*;
import java.awt.*;

/**
 * @author Suvosree Chatterjee
 */
public class Product_Description extends JFrame {
    JFrame frame;
    JPanel p1;

    Product_Description (Product item, int quantity){
        frame = new JFrame("DESCRIPTION");
        p1 = new JPanel(new BorderLayout());
        frame.add(p1);

        //JLabels
        JLabel full_description =new JLabel ("Description: " +item.getDescription());
        JLabel pricing =new JLabel ("$"+item.getSellPrice());
        JLabel quantity_available =new JLabel ("Quantity: " + quantity);

        p1.add(full_description, BorderLayout.NORTH);
        p1.add(pricing, BorderLayout.CENTER);
        p1.add(quantity_available, BorderLayout.SOUTH);

        frame.setSize(300, 300);
        frame.setVisible(true);

    }

}