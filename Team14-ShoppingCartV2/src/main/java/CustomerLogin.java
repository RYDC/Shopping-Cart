import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 * @author Ryan Jbaili
 */
public class CustomerLogin extends JFrame{
    private JPanel panel;
    private ArrayList<Customer> customers;

    public CustomerLogin(CardLayout cl, JPanel contentPanel,ArrayList<Customer> customerList){
        customers = customerList;
        panel = new JPanel();
        panel.setLayout(null);

        //Setup up labels and fields
        JLabel label = new JLabel("Welcome Customer!");
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


        //BUTTONS
        JButton loginBtn = new JButton( new AbstractAction("Login") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.out.println("Login Button clicked");
                boolean match = false;
                int i = 0;
                //Searching through customers for matching username and password
                while(!match && i<customers.size()){
                    if(userText.getText().equals(customers.get(i).getUsername()) && passText.getText().equals(customers.get(i).getPassword())) {
                        match = true;
                    }else{
                        i++;
                    }
                }
                if(match){//Successful login
                    //Moving logged in user to the top of customers ArrayList for referencing
                    Customer holder = customers.get(i);
                    customers.remove(i);
                    customers.add(0,holder);

                    //Clearing Textfields
                    userText.setText("");
                    passText.setText("");
                    error.setText("");
                    //Sending user to customer menu
                    cl.show(contentPanel,"customer menu");
                }else{//Failed Login
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
                while(!taken && i<customers.size()){
                    if(userText.getText() == customers.get(i).getUsername())
                        taken = true;
                    i++;
                }
                //System.out.println("Username is: '"+userText.getText()+"'");
                if(taken){//If username is already taken
                    error.setText("Username already taken!");
                }else if(userText.getText().equals("")) {//If no username was entered
                    error.setText("Invalid Username!");
                    System.out.println("Invalid username");
                }else{//Successful signup
                    customers.add(new Customer(userText.getText(),passText.getText()));
                    error.setText("Signed Up");
                    //Clearing Textfields
                    userText.setText("");
                    passText.setText("");
                }

            }
        });
        signupBtn.setBounds(600,100,100,100);
        panel.add(signupBtn);
    }

    /**
     * invariant: panel remains unchanged
     * postcondition: panel is returned
     */
    public JPanel getPanel(){
        return panel;
    }
}