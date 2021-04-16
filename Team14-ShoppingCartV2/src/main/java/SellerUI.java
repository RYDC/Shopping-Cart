import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SellerUI {
    JPanel panel;
    JButton addItem, viewStats, logout;

    public SellerUI(CardLayout cl, JPanel contentPanel, Inventory inventory){
        panel = new JPanel();
        panel.setLayout(null);

        //Title
        JLabel title = new JLabel("Seller Menu");
        title.setBounds(400,20,200,50);
        panel.add(title);

        JLabel label = new JLabel("Current Items:");
        //label.setBounds();

        for(int i = 0;i<inventory.getList().size();i++){
         JLabel item =  new JLabel(inventory.getProduct(i).getID());
         //label.setBounds();
         JLabel itemQuantity = new JLabel("Available: " + inventory.getProductQuantity(i));
         //label.setBounds();
            int currentItem = i;
            JButton restock = new JButton(new AbstractAction("+") {
                @Override
                public void actionPerformed( ActionEvent e ) {
                    System.out.println("Restock Clicked");
                    inventory.restock(currentItem,1);
                }
            });

        }

        //Add item button
        JButton addItem = new JButton( new AbstractAction("Add New Item") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.out.println("add item clicked");
                //cl.show(contentPanel,"seller login");
            }
        });
        addItem.setBounds(500,100,200,50);
        panel.add(addItem);

        //View statistics button
        JButton viewStats = new JButton( new AbstractAction("View Statistics") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.out.println("View stats clicked");
                //cl.show(contentPanel,"seller login");
            }
        });
        viewStats.setBounds(300,100,200,50);
        panel.add(viewStats);

        //Logout
        JButton logout = new JButton( new AbstractAction("Logout") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.out.println("Logout selected");
                cl.show(contentPanel,"start");
            }
        });
        logout.setBounds(100,100,100,100);
        panel.add(logout);




    }

    public JPanel getPanel(){
        return panel;
    }
}
