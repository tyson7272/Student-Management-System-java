import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import java.io.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.awt.*;
import java.awt.event.*;

class ChartFrame extends JFrame
{
Container c;
JButton btnBack, btnSave;
ChartFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
/*// 1-> create dataset
DefaultCategoryDataset ds = new DefaultCategoryDataset();
ds.addValue(45, "Maths");
ds.addValue(78, "chemistry");
ds.addValue(83, "physics");

ds.addValue(78, "sakshi", "Maths");
ds.addValue(35, "sakshi", "chemistry");
ds.addValue(99, "sakshi", "physics");


// 2-> chart designing
JFreeChart chart = ChartFactory.createBarChart("Students performance", "subject", "marks", ds, PlotOrientation.VERTICAL, true, true, true);

// 3-> chart display
ChartPanel panel = new ChartPanel(chart);
setContentPane(panel);

// 4-> save the file
//try
//{
//File marksChart = new File("marks.jpg");
//ChartUtilities.saveChartAsJPEG(marksChart, chart, 600, 600);
//}
//catch(IOException e){}
btnBack = new JButton("BACK");
btnSave = new JButton("SAVE IMG");
btnBack.setBackground(Color.red);
btnSave.setBackground(Color.green);

c.add(btnBack);
c.add(btnSave);

ActionListener a1 = (ae) -> {MainFrame a = new MainFrame(); dispose();};
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> {
	try
	{
		File marksChart = new File("marks.jpg");
		ChartUtilities.saveChartAsJPEG(marksChart, chart, 600, 600);
	}
	catch(IOException e){}
};
btnSave.addActionListener(a2);
*/
setVisible(true);
setLocationRelativeTo(null);
setSize(600, 600);
setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
setTitle("Mark Sheet");
}
}
