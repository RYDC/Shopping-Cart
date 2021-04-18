import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Wishlist extends JFrame implements ActionListener {
    JPanel panel;
    JPanel p2;
    JLabel header;

    public Wishlist(CardLayout cl, JPanel contentPanel, ArrayList<Product> wishlist){
        panel = new JPanel();
        p2 = new JPanel();
        panel.setLayout(new BorderLayout());
        p2.setLayout(new BorderLayout());

        header = new JLabel("Wishlist");
        header.setFont(new Font("Verdana", Font.BOLD, 15));
        header.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(header,BorderLayout.NORTH);


        if(wishlist.isEmpty()){
            JLabel empty = new JLabel("You have nothing on your wishlist!");
        }else{
            String[] column = {"Product Name", "Price (USD)", "Remove From Wishlist"};
            Object[][] row = new Object[wishlist.size()][3];
            for(int i = 0,y = 100;i<wishlist.size();i++,y+=50){
                row[i][0] = wishlist.get(i).getID();
                row[i][1] = wishlist.get(i).getSellPrice();
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
                            System.out.println("Removing " + wishlist.get(row).getID() + " from wishlist");
                            wishlist.remove(row);
                            Wishlist currentWishlist = new Wishlist(cl,contentPanel,wishlist);
                            contentPanel.add(currentWishlist.getPanel(),"wishlist");
                            cl.show(contentPanel,"wishlist");
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
