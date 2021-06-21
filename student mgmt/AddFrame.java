import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

class AddFrame extends JFrame
{
Container c;
JLabel lblRno, lblName, lblmk1, lblmk2, lblmk3;
JTextField txtRno, txtName, txtmk1, txtmk2, txtmk3;
JButton btnSave, btnBack;

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
AddFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
c.setBackground(Color.black);

lblRno = new JLabel("Enter rno: ");
txtRno = new JTextField(12);
lblName = new JLabel("Enter name: ");
txtName = new JTextField(15);
lblmk1 = new JLabel("Enter sub marks 1: ");
txtmk1 = new JTextField(12);
lblmk2 = new JLabel("Enter sub marks 2: ");
txtmk2 = new JTextField(12);
lblmk3 = new JLabel("Enter sub marks 3: ");
txtmk3 = new JTextField(12);

btnSave = new JButton("SAVE");
btnBack = new JButton("BACK");
btnSave.setBackground(Color.green);
btnBack.setBackground(Color.red);

lblRno.setForeground(Color.white);
lblName.setForeground(Color.white);
lblmk1.setForeground(Color.white);
lblmk2.setForeground(Color.white);
lblmk3.setForeground(Color.white);

txtRno.setBackground(Color.gray);
txtName.setBackground(Color.gray);
txtmk1.setBackground(Color.gray);
txtmk2.setBackground(Color.gray);
txtmk3.setBackground(Color.gray);

txtRno.setForeground(Color.black);
txtName.setForeground(Color.black);
txtmk1.setForeground(Color.black);
txtmk2.setForeground(Color.black);
txtmk3.setForeground(Color.black);

Font f = new Font("Calibri", Font.BOLD, 40);
btnSave.setFont(f);
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
c.add(btnSave);

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
				Student stud = new Student();
				String Rno = txtRno.getText();
				if(Integer.parseInt(Rno) < 1){	
					throw new Exception("Rno is negative");  
				}
				stud.setRno(Integer.parseInt(Rno));
				//if(Rno == ""){
				//	throw new Exception("Rno cannot be null/alphabetic");
				//}
				//stud.setName(txtName.getText());
				String name;
				name = txtName.getText();
				if(name.length() < 2){
					throw new Exception("Name should be atleast 2 letters");
				}
				if(onlyDigits(name, name.length())){
					throw new Exception("name should not be a number");
				}
				stud.setName(name);
				String m1,m2,m3;
				m1 = txtmk1.getText();
				if(Integer.parseInt(m1) < 0 || Integer.parseInt(m1) > 100){
					throw new Exception("sub1 is either negative or more than 100");
				}
				stud.sets1(Integer.parseInt(m1));
				m2 = txtmk2.getText();
				if(Integer.parseInt(m2) < 0 || Integer.parseInt(m2) > 100){
					throw new Exception("sub2 is either negative or more than 100");
				}
				stud.sets2(Integer.parseInt(m2));
				m3 = txtmk3.getText();
				if(Integer.parseInt(m3) < 0 || Integer.parseInt(m3) > 100){
					throw new Exception("sub3 is either negative or more than 100");
				}
				stud.sets3(Integer.parseInt(m3));
				s.save(stud);
				t.commit();
				JOptionPane.showMessageDialog(c, "Record inserted");
		}
		//catch(NumberFormatException e){
		//		JOptionPane.showMessageDialog(c, "Rno is either alphabetic or null");
		//}
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
			txtName.setText("");
			txtmk1.setText("");
			txtmk2.setText("");
			txtmk3.setText("");
			txtRno.requestFocus();
			s.close();
		}
};
btnSave.addActionListener(a2);

setVisible(true);
setTitle("Add Student data");
setSize(530, 700);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}