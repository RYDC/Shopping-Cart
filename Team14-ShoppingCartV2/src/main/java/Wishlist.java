import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Wishlist extends JFrame implements ActionListener {
    JPanel panel;
    JLabel label;

    public Wishlist(ArrayList<Product> wishlist){
        panel = new JPanel();
        panel.setLayout(null);
        label = new JLabel("Wishlist");
        label.setBounds(400,20,200,50);

        if(wishlist.isEmpty()){
            JLabel empty = new JLabel("You have nothing on your wishlist!");
        }else{
            for(int i = 0,y = 100;i<wishlist.size();i++,y+=50){
                JLabel item = new JLabel(wishlist.get(i).getID());
                item.setBounds(200,y,200,50);
                //Remove from wishlist button
                int currentItem = i;
                JButton remove = new JButton( new AbstractAction("Remove") {
                    @Override
                    public void actionPerformed( ActionEvent e ) {
                        System.out.println("Removed: " + wishlist.get(currentItem).getID()+" from wishlist");
                        item.setText(wishlist.get(currentItem).getID()+"*REMOVED*");
                        wishlist.remove(currentItem);
                    }
                });
                remove.setBounds(500,y,200,50);
                panel.add(remove);
            }
        }

        JButton back = new JButton( new AbstractAction("Back") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                System.out.println("Going Back");
                //(cl.show(contentPanel,"customer ui")
            }
        });
        //back.setBounds();
        panel.add(back);


    }

    public JPanel getPanel(){
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
