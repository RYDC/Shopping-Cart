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
                //Add button to remove from wishlist
            }
        }
    }

    public JPanel getPanel(){
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
