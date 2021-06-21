import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.List;
import java.util.*;
import java.sql.*;

class ViewFrame extends JFrame
{
Container c;
TextArea taData;
JButton btnBack;

ViewFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
c.setBackground(Color.black);

taData = new TextArea(10, 40);
JScrollPane scrollPane = new JScrollPane(taData);
btnBack = new JButton("BACK");
btnBack.setBackground(Color.red);

Font f = new Font("Calibri", Font.BOLD, 15);
taData.setFont(f);
Font g = new Font("Calibri", Font.BOLD, 30);
btnBack.setFont(g);

taData.setForeground(Color.black);
taData.setBackground(Color.gray);

c.add(taData);
c.add(btnBack);

ActionListener a1 = (ae) -> {MainFrame a = new MainFrame(); dispose();};
btnBack.addActionListener(a1);


Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sf = cfg.buildSessionFactory();
Session s = null;
Transaction t = null;	
try
{
		/*s = sf.openSession();
		t = s.beginTransaction();
		Student stu = new Student();
		//List<Student> stu = new ArrayList<>();
		list1 = new JList(stu);
		stu = s.createQuery("from student").list();
		//for(Student i : stu)
			taData.setText(stu);
		
		t.commit();*/
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

setVisible(true);
setTitle("View stuent data");
setSize(530, 500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}