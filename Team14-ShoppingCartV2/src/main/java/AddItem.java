import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author Ryan Jbaili, RealNub
 */
public class AddItem extends JFrame implements ActionListener {
    private JFrame frame;
    private JPanel panel;

    public AddItem(CardLayout cl, JPanel contentPanel, Inventory inventory,ArrayList<Customer>customers) {
        frame = new JFrame("Add An Item");
        panel = new JPanel();
        panel.setLayout (null);
        JLabel label = new JLabel("New Item");
        label.setBounds (300,50,300,50);
        panel.add(label);

        JLabel name = new JLabel("Product Name:");
        name.setBounds(100,150,100,50);
        panel.add(name);

        JTextField nameField = new JTextField();
        nameField.setBounds(250,150,100,50);
        panel.add(nameField);

        JLabel sellPrice = new JLabel("Sell Price:");
        sellPrice.setBounds(100,250,100,50);
        panel.add(sellPrice);

        JTextField sellPriceField = new JTextField();
        sellPriceField.setBounds(250,250,100,50);
        panel.add(sellPriceField);

        JLabel invPrice = new JLabel("Invoice Price:");
        invPrice.setBounds(100,350,100,50);
        panel.add(invPrice);

        JTextField invPriceField = new JTextField();
        invPriceField.setBounds(250,350,100,50);
        panel.add(invPriceField);

        JLabel quantity = new JLabel("Quantity:");
        quantity.setBounds(100,450,100,50);
        panel.add(quantity);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(250,450,100,50);
        panel.add(quantityField);

        JLabel description = new JLabel("Description:");
        description.setBounds(100,550,200,50);
        panel.add(description);

        JTextField descriptionField = new JTextField();
        descriptionField.setBounds(250,550,300,50);
        panel.add(descriptionField);

        JButton addItemBtn = new JButton( new AbstractAction("Add Item") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.out.println("Add Item Button Selected");
                if(!nameField.getText().equals("") && !invPriceField.getText().equals("") && !sellPriceField.getText().equals("") && !quantityField.getText().equals("")) {
                    inventory.add_item(new Product(nameField.getText(), Double.parseDouble(invPriceField.getText()),
                                    Double.parseDouble(sellPriceField.getText()), descriptionField.getText()),
                            Integer.parseInt(quantityField.getText()));
                    CustomerUIMainWindow newCustomer = new CustomerUIMainWindow(cl, contentPanel, inventory, customers);
                    contentPanel.add(newCustomer.getPanel(), "customer menu");
                    SellerUI newSeller = new SellerUI(cl, contentPanel, inventory, customers);
                    contentPanel.add(newSeller.getPanel(), "seller menu");
                    cl.show(contentPanel, "seller menu");
                    frame.dispose();
                }else{
                    label.setText("Missing Required Fields, Try again");
                }
            }
        });
        addItemBtn.setBounds (325,650,100,50);
        panel.add(addItemBtn);


        frame.add(panel);
        frame.setSize(750, 750);
        frame.setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}