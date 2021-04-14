import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class SellerLogin extends JFrame implements ActionListener {
    private JPanel panel;
    private ArrayList<Seller> sellers;

    public SellerLogin(CardLayout cl, JPanel contentPanel, ArrayList<Seller> sellerList){
        sellers = sellerList;

        panel = new JPanel();
        panel.setLayout(null);
        JLabel label = new JLabel("Welcome Seller!");
        label.setBounds(450,20,150,50);
        panel.add(label);

        JLabel user = new JLabel("Username");
        user.setBounds(100,100,100,50);
        panel.add(user);

        JLabel pass = new JLabel("Password");
        pass.setBounds(100,150,100,50);
        panel.add(pass);

        JLabel error = new JLabel("");
        error.setBounds(305,100,200,50);
        panel.add(error);

        JTextField userText = new JTextField();
        userText.setBounds(200,100,100,50);
        panel.add(userText);

        JPasswordField passText = new JPasswordField();
        passText.setBounds(200,150,100,50);
        panel.add(passText);

        JButton loginBtn = new JButton( new AbstractAction("Login") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.out.println("Login Button clicked");
                boolean match = false;
                int i = 0;
                while(!match && i<sellers.size()){
                    if(userText.getText().equals(sellers.get(i).getUsername()) && passText.getText().equals(sellers.get(i).getPassword())) {
                        match = true;
                    }else{
                        i++;
                    }
                }
                if(match){
                    error.setText("");
                    //Moving current logged in seller to last index on array
                    Seller holder = sellers.get(i);
                    sellers.remove(i);
                    sellers.add(holder);
                    userText.setText("");
                    passText.setText("");
                    cl.show(contentPanel,"seller menu");
                }else{
                    error.setText("Invalid Login");
                }
            }
        });
        loginBtn.setBounds(450,100,100,100);
        panel.add(loginBtn);

        JButton signupBtn = new JButton( new AbstractAction("Signup") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                error.setText("");
                System.out.println("Signup Button clicked");
                //Loop through usernames to make sure it's not taken
                boolean taken = false;
                int i = 0;
                while(!taken && i<sellers.size()){
                    if(userText.getText().equals(sellers.get(i).getUsername()))
                        taken = true;
                    i++;
                }
                //System.out.println("Username is: '"+userText.getText()+"'");
                if(taken){
                    error.setText("Username already taken!");
                }else if(userText.getText().equals("")) {
                    error.setText("Invalid Username!");
                    System.out.println("Invalid username");
                }else{
                    sellers.add(new Seller(userText.getText(),passText.getText()));
                    error.setText("Signed Up");
                    userText.setText("");
                    passText.setText("");
                }

            }
        });
        signupBtn.setBounds(600,100,100,100);
        panel.add(signupBtn);


    }

    public JPanel getPanel(){
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}