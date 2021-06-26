import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

class UpdFrame extends JFrame
{
Container c;
JLabel lblRno, lblName, lblmk1, lblmk2, lblmk3;
JTextField txtRno, txtName, txtmk1, txtmk2, txtmk3;
JButton btnUpd, btnBack;

public static boolean onlyDigits(String str, int n)
{
	for (int i = 0; i < n; i++) {
		if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			return true;
		}
		else {
			return false;
		}
	}
    return false;
}
UpdFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
c.setBackground(Color.black);

lblRno = new JLabel("Enter rno to be updated: ");
txtRno = new JTextField(12);
lblName = new JLabel("Enter name: ");
txtName = new JTextField(15);
lblmk1 = new JLabel("Enter sub marks 1: ");
txtmk1 = new JTextField(12);
lblmk2 = new JLabel("Enter sub marks 2: ");
txtmk2 = new JTextField(12);
lblmk3 = new JLabel("Enter sub marks 3: ");
txtmk3 = new JTextField(12);

btnUpd = new JButton("UPDATE");
btnBack = new JButton("BACK");
btnUpd.setBackground(Color.green);
btnBack.setBackground(Color.red);

Font f = new Font("Calibri", Font.BOLD, 40);
btnUpd.setFont(f);
btnBack.setFont(f);
lblRno.setFont(f);
txtRno.setFont(f);
lblName.setFont(f);
txtName.setFont(f);
lblmk1.setFont(f);
txtmk1.setFont(f);
lblmk2.setFont(f);
txtmk2.setFont(f);
lblmk3.setFont(f);
txtmk3.setFont(f);

lblRno.setForeground(Color.white);
lblName.setForeground(Color.white);
lblmk1.setForeground(Color.white);
lblmk2.setForeground(Color.white);
lblmk3.setForeground(Color.white);

txtRno.setBackground(Color.white);
txtName.setBackground(Color.gray);
txtmk1.setBackground(Color.gray);
txtmk2.setBackground(Color.gray);
txtmk3.setBackground(Color.gray);

txtRno.setForeground(Color.black);
txtName.setForeground(Color.black);
txtmk1.setForeground(Color.black);
txtmk2.setForeground(Color.black);
txtmk3.setForeground(Color.black);

c.add(lblRno);
c.add(txtRno);
c.add(lblName);
c.add(txtName);

c.add(lblmk1);
c.add(txtmk1);
c.add(lblmk2);
c.add(txtmk2);
c.add(lblmk3);
c.add(txtmk3);

c.add(btnBack);
c.add(btnUpd);

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
			int Rno = Integer.parseInt(txtRno.getText());
			if(Rno < 1){	
				throw new Exception("Rno is negative");  
			}
			if(txtRno.getText() == ""){}
			Student stu = (Student)s.get(Student.class, Rno);
			
			if (stu != null)
			{
				//String name = txtName.getText();
				String name;
				name = txtName.getText();
				if(name.length() < 2){
					throw new Exception("Name should be atleast 2 letters");
				}
				if(onlyDigits(name, name.length())){
					throw new Exception("name should not be a number");
				}
				stu.setName(name);
				String m1 = txtmk1.getText();
				if(Integer.parseInt(m1) < 1 || Integer.parseInt(m1) > 100){
					throw new Exception("sub1 is either negative or more than 100");
				}
				if(txtmk1.getText() == ""){}
				stu.sets1(Integer.parseInt(m1));
				String m2 = txtmk2.getText();
				if(Integer.parseInt(m2) < 1 || Integer.parseInt(m2) > 100){
					throw new Exception("sub2 is either negative or more than 100");
				}
				if(txtmk2.getText() == ""){}
				stu.sets2(Integer.parseInt(m2));
				String m3 = txtmk3.getText();
				if(Integer.parseInt(m3) < 1 || Integer.parseInt(m3) > 100){
					throw new Exception("sub3 is either negative or more than 100");
				}
				if(txtmk3.getText() == ""){}
				stu.sets3(Integer.parseInt(m3));
				s.save(stu);
				t.commit();
				JOptionPane.showMessageDialog(c, "record updated !","Updated !!",JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(c, "roll no. " + Rno + " not found");
			}
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(c, "Rno cannot be null/alphabetic", "Error", JOptionPane.WARNING_MESSAGE);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(c, e, "Error",JOptionPane.ERROR_MESSAGE);
			t.rollback();
		}
		finally
		{
			txtRno.setText("");
			txtName.setText("");
			txtmk1.setText("");
			txtmk2.setText("");
			txtmk3.setText("");
			txtRno.requestFocus();
			s.close();
		}
};
btnUpd.addActionListener(a2);

setVisible(true);
setTitle("Update Student data");
setSize(530, 700);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}