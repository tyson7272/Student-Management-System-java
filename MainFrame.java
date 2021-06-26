import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame
{
Container c;
JButton btnAdd, btnView, btnDel, btnUpd, btnChart;

MainFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 60));
c.setBackground(Color.black);

btnAdd = new JButton("ADD");
btnView = new JButton("VIEW");
btnDel = new JButton("DELETE");
btnUpd = new JButton("UPDATE");
btnChart = new JButton("CHARTS");

btnAdd.setBackground(Color.white);
btnView.setBackground(Color.white);
btnDel.setBackground(Color.white);
btnUpd.setBackground(Color.white);
btnChart.setBackground(Color.white);

Font f = new Font("Calibri", Font.BOLD, 40);
btnAdd.setFont(f);
btnView.setFont(f);
btnDel.setFont(f);
btnUpd.setFont(f);
btnChart.setFont(f);

c.add(btnAdd);
c.add(btnView);
c.add(btnDel);
c.add(btnUpd);
c.add(btnChart);

ActionListener a1 = (ae) -> {AddFrame a = new AddFrame(); dispose();};
btnAdd.addActionListener(a1);

ActionListener a2 = (ae) -> {ViewFrame a = new ViewFrame(); dispose();};
btnView.addActionListener(a2);

ActionListener a3 = (ae) -> {DelFrame a = new DelFrame(); dispose();};
btnDel.addActionListener(a3);

ActionListener a4 = (ae) -> {UpdFrame a = new UpdFrame(); dispose();};
btnUpd.addActionListener(a4);

ActionListener a5 = (ae) -> {ChartFrame a = new ChartFrame();};
btnChart.addActionListener(a5);

setVisible(true);
setTitle("S.M.S");
setSize(530, 500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}