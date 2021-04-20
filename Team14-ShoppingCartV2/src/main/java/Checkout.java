import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Checkout {
    JPanel panel;
    JPanel p2;
    JLabel header;
    ArrayList<Product> items;
    ArrayList<Integer> stock;
    boolean transactionComplete;

    public Checkout(CardLayout cl, JPanel contentPanel, Cart cart, Inventory inventory, ArrayList<Customer> customers){
        panel = new JPanel();
        p2 = new JPanel();
        panel.setLayout(new BorderLayout());
        p2.setLayout(new BorderLayout());

        //header = new JLabel("Receipt:  Total: $" + cart.getTotalCost());
        header = new JLabel("Total: $" + cart.getTotalCost());
        header.setFont(new Font("Verdana", Font.BOLD, 15));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(header,BorderLayout.NORTH);

        items = cart.getProductList();
        stock = cart.getQuantityList();
        transactionComplete = false;

        //Logout Button
        JButton logout = new JButton(new AbstractAction("LOG OUT") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Logout selected");
                cl.show(contentPanel, "start");
            }
        });
        logout.setBounds(1390,0,90, 20);
        panel.add(logout);

        if(items.isEmpty()){
            System.out.println("Cart is empty!");
        }else{
            String[] column = {"Product Name", "Price (USD)"};
            Object[][] row = new Object[items.size()][3];
            for(int i = 0,y = 100;i<items.size();i++,y+=50){
                row[i][0] = items.get(i).getID();
                row[i][1] = items.get(i).getSellPrice();
            }
            //Model to prevent cells from being edited
            DefaultTableModel tableModel = new DefaultTableModel(row,column) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            JTable table = new JTable(row,column);
            table.setModel(tableModel);
            table.setBorder(BorderFactory.createLineBorder(Color.black));
            table.setRowHeight(30);

            JScrollPane scrollPane = new JScrollPane(table);
            p2.add(scrollPane,BorderLayout.CENTER);

            JButton cardBtn = new JButton( new AbstractAction("Supply Card Info and Complete Transaction") {
                @Override
                public void actionPerformed( ActionEvent e ) {
                    if(!transactionComplete) {
                        System.out.println("cardBtn clicked");
                        header.setText("Receipt:  Total: $" + cart.getTotalCost());
                        inventory.setRevenue(inventory.getRevenue()+cart.getTotalCost());
                        inventory.setCost(inventory.getCost()+cart.getTotalCost());
                        cart.clearCart();
                        transactionComplete = true;
                        CustomerUIMainWindow newCustomer = new CustomerUIMainWindow(cl,contentPanel,inventory,customers);
                        contentPanel.add(newCustomer.getPanel(),"customer menu");
                    }else{
                        System.out.println("Transaction is already Complete!");
                    }
                }
            });
            //cardBtn.setBounds(350,100,100,100);
            panel.add(cardBtn,BorderLayout.SOUTH);



        }

        panel.add(p2);


    }

    public JPanel getPanel(){
        return panel;
    }
}
