import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

class DelFrame extends JFrame
{
Container c;
JLabel lblRno;
JTextField txtRno;
JButton btnDel;
JButton btnBack;

DelFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
c.setBackground(Color.black);

lblRno = new JLabel("Enter Rno: ");
txtRno = new JTextField(12);
btnDel = new JButton("DELETE");
btnBack = new JButton("BACK");
btnBack.setBackground(Color.red);
btnDel.setBackground(Color.green);

Font f = new Font("Calibri", Font.BOLD, 40);
btnDel.setFont(f);
lblRno.setFont(f);
txtRno.setFont(f);
btnBack.setFont(f);

lblRno.setForeground(Color.white);
txtRno.setBackground(Color.gray);
txtRno.setForeground(Color.black);

c.add(lblRno);
c.add(txtRno);
c.add(btnDel);
c.add(btnBack);

ActionListener a1 = (ae) -> {MainFrame a = new MainFrame(); dispose();};
btnBack.addActionListener(a1);

ActionListener a2 = (ae) -> {
	Configuration cfg = new Configuration();
    cfg.configure("hibernate.cfg.xml");

    SessionFactory sf = cfg.buildSessionFactory();
    Session s = null;
    Transaction t = null;	
    try
    {
		s = sf.openSession();
		t = s.beginTransaction();
		String Rno = txtRno.getText();
		if(Integer.parseInt(Rno) < 1){	
			throw new Exception("Rno is negative");  
		}
        Student stu = (Student)s.get(Student.class, Integer.parseInt(Rno));
        if (stu != null)
        {
		    s.delete(stu);
		    t.commit();
		    JOptionPane.showMessageDialog(c, "record deleted !");
        }
        else
        {
		    JOptionPane.showMessageDialog(c, "roll no. not found");
        }
    }
    catch(NumberFormatException e){
        JOptionPane.showMessageDialog(c, e);
    }
    catch(Exception e)
    {
		JOptionPane.showMessageDialog(c, e);
		t.rollback();
    }
    finally
    {
        txtRno.setText("");
		s.close();
    }
};
btnDel.addActionListener(a2);

setVisible(true);
setTitle("Delete Student data");
setSize(530, 500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}