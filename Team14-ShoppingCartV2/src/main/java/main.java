import DataObjects.Customer;
import DataObjects.Inventory;
import DataObjects.Product;
import DataObjects.Seller;
import Logins.CustomerLogin;
import Logins.LoginSelector;
import Logins.SellerLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;
import Customer.CustomerUIMainWindow;
import Seller.SellerUI;


/**
 * @author Ryan Jbaili
 */
public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //JFrame Setup
        JFrame frame = new JFrame();
        frame.setSize(1500,750);

        //Card Layout Setup
        CardLayout cl = new CardLayout();
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(cl);

        ArrayList<Customer> customers;
        ArrayList<Seller> sellers;
        Inventory inventory;

        String fileName = "data.txt";
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));
            customers = (ArrayList<Customer>) input.readObject();
            sellers = (ArrayList<Seller>) input.readObject();
            inventory = (Inventory) input.readObject();
            input.close();
        } catch (IOException e) {
            //DEFINE VARIABLES HERE TO PASS IN AS ARGUMENTS FOR CREATING PANELS
            customers = new ArrayList<Customer>();
            sellers = new ArrayList<Seller>();
            inventory = new Inventory();
        }

        //Hard Coded Items for Inventory
        /*Product apple = new Product("Apple",50,50,"Apple");
        inventory.add_item(apple,5);
        Product orange = new Product("Orange",50,50,"Orange");
        inventory.add_item(orange,5);*/

        //Creating each panel
        LoginSelector loginSelectorPanel = new LoginSelector(cl,contentPanel);
        CustomerLogin customerLoginPanel = new CustomerLogin(cl,contentPanel,customers);
        SellerLogin sellerLoginPanel = new SellerLogin(cl,contentPanel,sellers);
        SellerUI sellerMenu = new SellerUI(cl,contentPanel,inventory,customers);
        CustomerUIMainWindow customerMenu = new CustomerUIMainWindow(cl,contentPanel,inventory,customers);

        //Adding each panel into content panel
        contentPanel.add(loginSelectorPanel.getPanel(),"start");
        contentPanel.add(customerLoginPanel.getPanel(),"customer login");
        contentPanel.add(sellerLoginPanel.getPanel(),"seller login");
        contentPanel.add(sellerMenu.getPanel(),"seller menu");
        contentPanel.add(customerMenu.getPanel(),"customer menu");

        //Custom Termination of program
        ArrayList<Customer> finalCustomers = customers;
        ArrayList<Seller> finalSellers = sellers;
        Inventory finalInventory = inventory;
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("EXITING!");
                String fileName = "data.txt";
                try {
                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
                    output.writeObject(finalCustomers);
                    output.writeObject(finalSellers);
                    output.writeObject(finalInventory);
                    output.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }


                System.exit(0);
            }
        });

        frame.add(contentPanel);
        frame.setVisible(true);
    }
}
