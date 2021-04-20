import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Suvosree Chatterjee
 *
 */
public class ViewStatistics extends JFrame {
    double revenue;
    double profit;
    double totalInvCost;




    ViewStatistics(Inventory inv){

        JFrame viewStat=new JFrame("View Statistics");
        totalInvCost = (inv.getCost());
        revenue = (inv.getRevenue());
        profit= revenue-totalInvCost;


        JLabel rev =new JLabel ("Revenue: $" + revenue);
        viewStat.add(rev);

        JLabel prof= new JLabel ("Total Profits $" +profit);
        viewStat.add(prof);



        viewStat.setLayout(new GridLayout(2, 2));
        viewStat.setSize(500, 500);
        viewStat.setVisible(true);


    }
}