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
        JFrame viewStat = new JFrame("View Statistics");
        viewStat.setLayout(new GridLayout(2, 2));
        viewStat.setSize(500, 500);

        totalInvCost = (inv.getCost());
        revenue = (inv.getRevenue());
        profit = revenue - totalInvCost;

        //Labels
        JLabel rev =new JLabel ("Revenue: $" + revenue);
        viewStat.add(rev);

        JLabel prof= new JLabel ("Total Profits $" + profit);
        viewStat.add(prof);

        viewStat.setVisible(true);
    }
}