import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class loginSelector extends JFrame implements ActionListener {
    private JPanel panel;

    public loginSelector(CardLayout cl,JPanel contentPanel){
        panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel("Welcome, Which are you?");
        label.setBounds(400,20,200,50);
        panel.add(label);

        JButton customerBtn = new JButton( new AbstractAction("Customer") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.out.println("Customer Button clicked");
                cl.show(contentPanel,"customer login");
                //CustomerLogin customerLogin = new CustomerLogin(frm);
                //panel.setVisible(false);
                //frm.add(customerLogin.getPanel());
            }
        });
        customerBtn.setBounds(350,100,100,100);
        panel.add(customerBtn);

        JButton sellerBtn = new JButton( new AbstractAction("Seller") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.out.println("Seller Button clicked");
                cl.show(contentPanel,"seller login");
                //SellerLogin sellerLogin = new SellerLogin(frm);
                //panel.setVisible(false);
                //frm.add(sellerLogin.getPanel());
            }
        });
        sellerBtn.setBounds(500,100,100,100);
        panel.add(sellerBtn);


    }

    public JPanel getPanel(){
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}