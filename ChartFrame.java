import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import java.io.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;


class ChartFrame extends JFrame
{
Container c;
JButton btnBack, btnSave;
ChartFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sf = cfg.buildSessionFactory();
Session s = null;
Transaction t = null;
DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
try
{
	s = sf.openSession();
	t = s.beginTransaction();
	List<Student> stud = s.createQuery("from Student order by rno").list();
	for (Student i : stud){
		dataset.addValue(i.gets1(),"Rno " + i.getRno(),"S1");
		dataset.addValue(i.gets2(),"Rno " + i.getRno(),"S2");
		dataset.addValue(i.gets3(),"Rno " + i.getRno(),"S3");
	}
}
catch(Exception e)
{
		JOptionPane.showMessageDialog(c, "issue");
		t.rollback();
}
finally
{
		s.close();
}

JFreeChart chart = ChartFactory.createBarChart("Students performance", "subject", "marks", dataset, PlotOrientation.VERTICAL, true, true, true);
ChartPanel panel = new ChartPanel(chart);
//setContentPane(panel);
c.add(panel);

btnBack = new JButton("BACK");
btnSave = new JButton("SAVE IMG");
btnBack.setBackground(Color.red);
btnSave.setBackground(Color.green);

Font f = new Font("Calibri", Font.BOLD, 25);
btnBack.setFont(f);
btnSave.setFont(f);

c.add(btnBack);
c.add(Box.createRigidArea(new Dimension(30, 0)));
c.add(btnSave);

ActionListener a1 = (ae) -> {MainFrame a = new MainFrame(); dispose();};
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> {
	try
	{
		File marksChart = new File("record.jpg");
		ChartUtilities.saveChartAsJPEG(marksChart, chart, 600, 600);
	}
	catch(IOException e){}
};
btnSave.addActionListener(a2);

setVisible(true);
setLocationRelativeTo(null);
setSize(700, 550);
setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
setTitle("Mark Sheet");
}
}
