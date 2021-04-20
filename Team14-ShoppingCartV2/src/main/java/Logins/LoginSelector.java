package Logins;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author Ryan Jbaili
 */
public class LoginSelector extends JFrame {
    private JPanel panel;

    public LoginSelector(CardLayout cl, JPanel contentPanel){
        panel = new JPanel();
        panel.setLayout(null);

        //Label
        JLabel label = new JLabel("Welcome, Which are you?");
        label.setBounds(400,20,200,50);
        panel.add(label);

        //BUTTONS
        JButton customerBtn = new JButton( new AbstractAction("Customer") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.out.println("Customer Button clicked");
                //Sending user to customer login
                cl.show(contentPanel,"customer login");
            }
        });
        customerBtn.setBounds(350,100,100,100);
        panel.add(customerBtn);

        JButton sellerBtn = new JButton( new AbstractAction("Seller") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.out.println("Seller Button clicked");
                //sending user to seller login
                cl.show(contentPanel,"seller login");
            }
        });
        sellerBtn.setBounds(500,100,100,100);
        panel.add(sellerBtn);


    }
    /**
     * invariant: panel remains unchanged
     * postcondition: panel is returned
     */
    public JPanel getPanel(){
        return panel;
    }

}