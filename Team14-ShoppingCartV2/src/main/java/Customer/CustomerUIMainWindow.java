package Customer;

import DataObjects.Customer;
import DataObjects.Inventory;
import DataObjects.Product;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Seller.SellerUI;


/**
 * @authors Suvosree Chatterjee, Ryan Jbaili
 */

//creating button for cart
public class CustomerUIMainWindow extends JFrame {
    JPanel p1;
    JPanel p2;

    public CustomerUIMainWindow(CardLayout cl, JPanel contentPanel, Inventory inventory, ArrayList<Customer> customers) {
        p1 = new JPanel(new BorderLayout());
        p2 = new JPanel(new BorderLayout());
        p1.setBorder(BorderFactory.createLineBorder(Color.black));

        //Header
        JLabel heading = new JLabel("Welcome to the Store");
        heading.setFont(new Font("Verdana", Font.BOLD, 15));
        p1.add(heading, BorderLayout.NORTH);

        //Title
        JLabel title = new JLabel("  AVAILABLE PRODUCTS");
        p2.setBounds(50, 300, 3000, 3000);
        p2.add(title, BorderLayout.NORTH);

        //Footer
        JLabel footer = new JLabel("TO ADD AND REMOVE ITEMS PLEASE CLICK ON THE CART ICON OR WISHLIST ICON");
        p1.add(footer, BorderLayout.SOUTH);

        //TotalCost
        JLabel cost;
        if(!customers.isEmpty())
            cost = new JLabel("Total Cost of Cart: $"+customers.get(0).getCart().getTotalCost());
        else
            cost = new JLabel("Total Cost of Cart: $0");
        p2.add(cost,BorderLayout.SOUTH);

        //------------BUTTONS------------

        //Logout Button
        JButton logout = new JButton(new AbstractAction("LOG OUT") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Logout selected");
                cl.show(contentPanel, "start");
            }
        });
        logout.setBounds(1000, 10, 90, 20);
        p1.add(logout);

        //Cart Button
        JButton viewCart = new JButton(new AbstractAction("CART") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("View Cart Selected");
                //Loading ViewCartUI
                ViewCartUI currentCart = new ViewCartUI(cl,contentPanel,customers.get(0).getCart(),inventory,customers);
                contentPanel.add(currentCart.getPanel(),"current cart");
                cl.show(contentPanel,"current cart");
            }
        });
        viewCart.setBounds(1090, 10, 90, 20);
        p1.add(viewCart);

        //Wishlist Button
        JButton wishlist = new JButton(new AbstractAction("WISHLIST") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Wishlist Selected");
                //Loading Wishlist
                Wishlist currentWishlist = new Wishlist(cl, contentPanel, customers.get(0).getWishlist());
                contentPanel.add(currentWishlist.getPanel(), "wishlist");
                cl.show(contentPanel, "wishlist");
            }
        });
        wishlist.setBounds(1180, 10, 90, 20);
        p1.add(wishlist);

        //----------------- TABLE -----------------
        ArrayList<Product> products = inventory.getList();
        ArrayList<Integer> quantity = inventory.getStockList();
        String[] column = {"Product Name", "Price (USD)", "Quantity","Add To Cart", "Add To Wishlist"};
        Object[][] row = new Object[products.size()][5];
        for (int i = 0; i < products.size(); i++) {
            row[i][0] = products.get(i).getID();
            row[i][1] = products.get(i).getSellPrice();
            row[i][2] = quantity.get(i);
            row[i][3] = "Add to Cart";
            row[i][4] = "Add to Wishlist";
        }

        //Model to prevent cells from being edited
        DefaultTableModel tableModel = new DefaultTableModel(row, column) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(row, column);
        table.setBorder(BorderFactory.createLineBorder(Color.black));
        table.setRowHeight(30);
        table.setModel(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        //ACTION LISTENER FOR TABLE COLUMNS
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Customer currentCustomer = customers.get(0);
                if (e.getClickCount() == 2) {//2 Clicks activates a column listener
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    //System.out.println("ROW IS: " + row+" COLUMN IS: " + column);
                    if (column == 3) {//ADD TO CART SELECTED
                        currentCustomer.addToCart(row, inventory);
                        cost.setText("Total Cost: $" + currentCustomer.getCart().getTotalCost());
                        //Reloading SellerUI And CustomerUI
                        CustomerUIMainWindow newCustomerMenu = new CustomerUIMainWindow(cl,contentPanel,inventory,customers);
                        SellerUI newMenu = new SellerUI(cl,contentPanel,inventory,customers);
                        contentPanel.add(newMenu.getPanel(),"seller menu");
                        contentPanel.add(newCustomerMenu.getPanel(),"customer menu");
                        cl.show(contentPanel,"customer menu");
                    } else if (column == 4) {//ADD TO WISHLIST SELECTED
                        System.out.println("Attempting to add to wishlist");
                        ArrayList<Product> wishlist = currentCustomer.getWishlist();
                        int i = 0;
                        boolean match = false;
                        while (i < wishlist.size() && !match) {//Index through wishlist to see if item is already in wishlist
                            if (inventory.getProduct(row) == wishlist.get(i)) {
                                match = true;
                                System.out.println("Item already in wishlist. Removing..");
                                //Item was found in wishlist already, removing from wishlist
                                wishlist.remove(i);
                            }
                            i++;
                        }
                        if (!match) //No match found, adding to wishlist
                            currentCustomer.addToWishlist(inventory.getProduct(row));
                    } else if (column == 0) {//View Product Description
                        Product_Description product = new Product_Description(inventory.getProduct(row), inventory.getStock(row));
                    }
                }
            }
        });
        p2.add(scrollPane, BorderLayout.CENTER);
        p1.add(p2);

    }

    /**
     * invariant: panel remains unchanged
     * postcondition: panel is returned
     */
    public JPanel getPanel () {
        return p1;
    }

}
