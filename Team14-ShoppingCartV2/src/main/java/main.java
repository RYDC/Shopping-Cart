import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args){

        //JFrame Setup
        JFrame frame = new JFrame();
        frame.setSize(1500,750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Card Layout Setup
        CardLayout cl = new CardLayout();
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(cl);

        //DEFINE VARIABLES HERE TO PASS IN AS ARGUMENTS FOR CREATING PANELS
         //Inventory... etc etc
        ArrayList<Customer> customers = new ArrayList<Customer>();
        ArrayList<Seller> sellers = new ArrayList<Seller>();
        Inventory inventory = new Inventory();

        //Hard Coded Items
        Product apple = new Product("Apple",50,50);
        inventory.add_item(apple,5);




        //Creating each panel
        loginSelector loginSelectorPanel = new loginSelector(cl,contentPanel);
        CustomerLogin customerLoginPanel = new CustomerLogin(cl,contentPanel,customers);
        SellerLogin sellerLoginPanel = new SellerLogin(cl,contentPanel,sellers);
        SellerUI sellerMenu = new SellerUI(cl,contentPanel,inventory);
        CustomerUIMainWindow customerMenu = new CustomerUIMainWindow(cl,contentPanel,inventory,customers);

        //Adding each panel into content panel
        contentPanel.add(loginSelectorPanel.getPanel(),"start");
        contentPanel.add(customerLoginPanel.getPanel(),"customer login");
        contentPanel.add(sellerLoginPanel.getPanel(),"seller login");
        contentPanel.add(sellerMenu.getPanel(),"seller menu");
        contentPanel.add(customerMenu.getPanel(),"customer menu");

        frame.add(contentPanel);
        frame.setVisible(true);
    }
}
