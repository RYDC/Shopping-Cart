
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * @author Suvosree Chatterjee
 */





public class Product_Description extends JFrame {

    JFrame frame=new JFrame("DESCRIPTION");
    JPanel p1;
    String[] description= {"red,sweet,green", "XXL tshirt,100% cotton"};
    String[] quantity = {"10","20"};


    Product_Description (Product item, int quantity){


        p1=new JPanel(new BorderLayout());


        frame.add(p1);


        PopupFactory pf= new PopupFactory();

        JLabel full_description =new JLabel ("Description" +item.getDescription());
        JLabel pricing =new JLabel ("$"+item.getSellPrice());
        JLabel quantity_available =new JLabel ("Quantity:" + quantity);

        p1.add(full_description);
        p1.add(pricing);
        p1.add(quantity_available);



        p1.add(full_description, BorderLayout.NORTH);
        p1.add(pricing, BorderLayout.CENTER);
        p1.add(quantity_available, BorderLayout.SOUTH);

        frame.setSize(300, 300);
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);








    }












    public JPanel getPanel(){
        return p1;
    }

}