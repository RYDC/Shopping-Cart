import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @authors Ryan Jbaili
 */

//creating button for cart
public class SellerUI extends JFrame {
    JPanel p1;
    JPanel p2;

    SellerUI(CardLayout cl, JPanel contentPanel, Inventory inventory, ArrayList<Customer> customers) {
        p1 = new JPanel(new BorderLayout());
        p2 = new JPanel(new BorderLayout());
        p1.setBorder(BorderFactory.createLineBorder(Color.black));

        //Header
        JLabel heading = new JLabel("Seller Menu");
        heading.setFont(new Font("Verdana", Font.BOLD, 15));
        p1.add(heading, BorderLayout.NORTH);

        //Title
        JLabel title = new JLabel("  AVAILABLE PRODUCTS");
        p2.setBounds(50, 300, 3000, 3000);
        p2.add(title, BorderLayout.NORTH);


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

        //Add Item Button
        JButton addItem = new JButton(new AbstractAction("Add Item") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Item Selected");
                AddItem newItem = new AddItem();
                //ViewCartUI currentCart = new ViewCartUI(cl,contentPanel,customers.get(0).getCart(),inventory,customers);
                //contentPanel.add(currentCart.getPanel(),"current cart");
                //cl.show(contentPanel,"current cart");
            }
        });
        addItem.setBounds(1090, 10, 90, 20);
        p1.add(addItem);

        //View Statistics Button
        JButton viewStatistics = new JButton(new AbstractAction("View Statistics") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("View Statistics Selected");
                //Add viewStats code here
                //You will need to remake the view statistics panel everytime a checkout occurs
            }
        });
        viewStatistics.setBounds(1180, 10, 180, 20);
        p1.add(viewStatistics);

        //----------------- TABLE -----------------
        ArrayList<Product> products = inventory.getList();
        ArrayList<Integer> stock = inventory.getStockList();
        String[] column = {"Product Name", "Price (USD)","Quantity Available","Remove Item","Restock"};
        Object[][] row = new Object[products.size()][5];
        for (int i = 0; i < products.size(); i++) {
            row[i][0] = products.get(i).getID();
            row[i][1] = products.get(i).getSellPrice();
            row[i][2] = stock.get(i);
            row[i][3] = "Remove Item";
            row[i][4] = "Restock";

        }
        JTable table = new JTable(row, column);

        //Listener for interacting with the menu (add to wishlist, add to cart, view description)
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    //System.out.println("ROW IS: " + row+" COLUMN IS: " + column);
                    if (column == 3) {
                        System.out.println("Removing " + inventory.getProduct(row).getID()+" from inventory!");
                        inventory.remove_item(row);
                        SellerUI newMenu = new SellerUI(cl,contentPanel,inventory,customers);
                        CustomerUIMainWindow newCustomerMenu = new CustomerUIMainWindow(cl,contentPanel,inventory,customers);
                        contentPanel.add(newCustomerMenu.getPanel(),"customer menu");
                        contentPanel.add(newMenu.getPanel(),"seller menu");
                        cl.show(contentPanel,"seller menu");
                    }else if(column == 4){
                        //Add Restock Feature
                        inventory.restock(row,1);
                        SellerUI newMenu = new SellerUI(cl,contentPanel,inventory,customers);
                        contentPanel.add(newMenu.getPanel(),"seller menu");
                        cl.show(contentPanel,"seller menu");
                    }
                }
            }
        });
        table.setBorder(BorderFactory.createLineBorder(Color.black));
        table.setRowHeight(30);

        //Model to prevent cells from being edited
        DefaultTableModel tableModel = new DefaultTableModel(row, column) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setModel(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        p2.add(scrollPane, BorderLayout.CENTER);
        p1.add(p2);

    }

    public JPanel getPanel () {
        return p1;
    }

}
