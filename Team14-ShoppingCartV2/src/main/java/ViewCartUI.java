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

public class ViewCartUI {
        JPanel panel;
        JPanel p2;
        JLabel header;
        ArrayList<Product> items;
        ArrayList<Integer> stock;

        public ViewCartUI(CardLayout cl, JPanel contentPanel, Cart cart,Inventory inventory){
            panel = new JPanel();
            p2 = new JPanel();
            panel.setLayout(new BorderLayout());
            p2.setLayout(new BorderLayout());

            header = new JLabel("Your Cart");
            header.setFont(new Font("Verdana", Font.BOLD, 15));
            header.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(header,BorderLayout.NORTH);

            items = cart.getProductList();
            stock = cart.getQuantityList();


            if(items.isEmpty()){
                System.out.println("Cart is empty!");
            }else{
                String[] column = {"Product Name", "Price (USD)", "Remove From Cart"};
                Object[][] row = new Object[items.size()][3];
                for(int i = 0,y = 100;i<items.size();i++,y+=50){
                    row[i][0] = items.get(i).getID();
                    row[i][1] = items.get(i).getSellPrice();
                    row[i][2] = "Remove";
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

                table.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if (e.getClickCount() == 2) {
                            JTable target = (JTable)e.getSource();
                            int row = target.getSelectedRow();
                            int column = target.getSelectedColumn();
                            System.out.println("ROW IS: " + row+" COLUMN IS: " + column);
                            if(column==2){
                                System.out.println("Removing " + items.get(row).getID() + " from cart");
                                cart.remove(row,inventory);
                                ViewCartUI currentCart = new ViewCartUI(cl,contentPanel,cart,inventory);
                                contentPanel.add(currentCart.getPanel(),"current cart");
                                cl.show(contentPanel,"current cart");
                            }
                        }
                    }
                });

            }

            JButton back = new JButton( new AbstractAction("Back") {
                @Override
                public void actionPerformed( ActionEvent e ) {
                    System.out.println("Going Back");
                    cl.show(contentPanel,"customer menu");
                }
            });
            back.setBounds(1390,0,90, 20);
            panel.add(back);
            panel.add(p2);


        }

        public JPanel getPanel(){
            return panel;
        }
    }
