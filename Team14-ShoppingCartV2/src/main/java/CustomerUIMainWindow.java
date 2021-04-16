import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @authors Suvosree Chatterjee, Ryan Jbaili
 */

//creating button for cart
public class CustomerUIMainWindow extends JFrame {
    JPanel p1;
    JPanel p2;

    CustomerUIMainWindow (CardLayout cl, JPanel contentPanel, Inventory inventory, ArrayList<Customer> customers){
        p1 = new JPanel(new BorderLayout());
        p2 = new JPanel(new BorderLayout());
        p1.setBorder(BorderFactory.createLineBorder(Color.black));

        //Header
        JLabel heading=new JLabel("Welcome to the Store");
        heading.setFont(new Font("Verdana", Font.BOLD, 15));
        p1.add(heading, BorderLayout.NORTH);

        //Title
        JLabel title = new JLabel("  AVAILABLE PRODUCTS");
        p2.setBounds(50,300,3000,3000);
        p2.add(title, BorderLayout.NORTH);

        //Footer
        JLabel footer=new JLabel("TO ADD AND REMOVE ITEMS PLEASE CLICK ON THE CART ICON OR WISHLIST ICON");
        p2.add(footer,BorderLayout.SOUTH);

        //Logout Button
        JButton logout=new JButton("LOG OUT");
        logout.setBounds(1000,10,90, 20);
        p1.add(logout);

        //Cart Button
        JButton cart=new JButton("CART");
        cart.setBounds(1090,10,90, 20);
        p1.add(cart);

        //Wishlist Button
        JButton wishlist=new JButton("Wishlist");
        wishlist.setBounds(1180,10,90, 20);
        p1.add(wishlist);

        ArrayList<Product> products = inventory.getList();

        //Hardcoded items for inventory
        Object[][] row = new Object[products.size()][3];
        for(int i = 0;i<products.size();i++){
            row[i][0] = products.get(i).getID();
            row[i][1] = products.get(i).getSellPrice();
        }

        String[] column = {"Product Name", "Price (USD)", "Product Details"};
        JTable table = new JTable(row,column);
        table.setBorder(BorderFactory.createLineBorder(Color.black));
        table.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(table);
        p2.add(scrollPane, BorderLayout.CENTER);
        p1.add(p2);

    }
    public JPanel getPanel(){
        return p1;
    }
}
