
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;




public class CartWindow extends JFrame {



    CartWindow(){


        String[] items = new String[50];
        //private double[] itemPrices = {259.00, 18.50, 12.95, 10.90, 14.50, 30.44, 105.90};


        JFrame frame = new JFrame("YOUR CART");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);


        JPanel p1 = new JPanel();
        JLabel heading = new JLabel("YOUR CART    ");
        heading.setFont(new Font("Verdana",Font.BOLD,15));
        frame.add(p1);
        p1.add(heading);
        p1.setBounds(700,0,200,200);
        p1.setVisible(true);

        JButton checkout=new JButton("CHECK OUT");
        checkout.setSize(20, 20);

        JPanel p2=new JPanel ();
        p1.add(checkout);

        //checkout.addActionListener(new checkoutListener());

        // Add GridLayout manager to the content pane.
        p2.setLayout(new GridLayout(2, 1));

        JLabel viewcart = new JLabel("                                CART");


        JList available_items =new JList ();

        // Set the list to multiple interval selection mode.
        available_items.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Set number of visible rows to 7.
        available_items.setVisibleRowCount(100);

        // Add available_list to a scroll pane
        JScrollPane available_items_scroll = new JScrollPane(available_items);

        // Add label to the panel.
        p2.add(viewcart);

        // Add the list to the panel.
        p2.add(available_items_scroll);



        JPanel p3=new JPanel (new BorderLayout());




        // Add GridLayout manager to the content pane.
        p3.setLayout(new GridLayout(2, 1));

        JLabel items_available = new JLabel("LIST OF ITEMS AVAILABLE TO PURCHASE");
        JList list_of_choose_items =new JList ();

        // Create list model.
        DefaultListModel listModel = new DefaultListModel();

        // Create the list.
        list_of_choose_items = new JList(listModel);

        // Set the list to multiple interval selection mode.
        list_of_choose_items.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Set number of visible rows to 7.
        list_of_choose_items.setVisibleRowCount(100);

        // Add list to a scroll pane
        JScrollPane list_of_items_scroll = new JScrollPane(list_of_choose_items);

        // Add label to the panel.
        p3.add(items_available);

        // Add the list to the panel.
        p3.add(list_of_items_scroll);





        JPanel p4=new JPanel (new BorderLayout());


        frame.add(p4);

        JButton add=new JButton("ADD TO CART");

        p4.add(add);
        p4.add(add,BorderLayout.EAST);



        JButton remove=new JButton("REMOVE FROM CART");
        p4.add(remove);
        p4.add(remove,BorderLayout.WEST);








        //remove.addActionListener(new removeListener());








        frame.setLayout(new BorderLayout());
        frame.add(p1,BorderLayout.NORTH);
        frame.add(p2,BorderLayout.WEST);
        frame.add(p3,BorderLayout.EAST);
        frame.add(p4,BorderLayout.SOUTH);










    }


    /*public static void main(String[] args) {
        new CartWindow ();


    }*/
}