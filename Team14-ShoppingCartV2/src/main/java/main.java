import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class main {
    public static void main(String[] args){

        //JFrame Setup
        JFrame frame = new JFrame();
        frame.setSize(1500,750);


        //Card Layout Setup
        CardLayout cl = new CardLayout();
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(cl);

        //DEFINE VARIABLES HERE TO PASS IN AS ARGUMENTS FOR CREATING PANELS
         //Inventory... etc etc
        ArrayList<Customer> customers = new ArrayList<Customer>();
        ArrayList<Seller> sellers = new ArrayList<Seller>();
        Inventory inventory = new Inventory();

        //Hard Coded Items for Inventory
        Product apple = new Product("Apple",50,50,"Apple");
        inventory.add_item(apple,5);
        Product orange = new Product("Orange",50,50,"Orange");
        inventory.add_item(orange,5);


        //Creating each panel
        loginSelector loginSelectorPanel = new loginSelector(cl,contentPanel);
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
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("EXITING!");
                System.exit(0);

            }
        });



        frame.add(contentPanel);
        frame.setVisible(true);





    }
}
