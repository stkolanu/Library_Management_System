
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class Main extends Frame implements ActionListener {
Button b1,b2,b3;
Label l1;
Main()
{
    setLayout(null);
    l1=new Label("WELCOME TO LIBRARY MANAGEMENT");
    l1.setForeground(Color.darkGray);
    b1=new Button("STUDENT");
    b3=new Button("ADMIN");
    l1.setFont(new Font("Bold",Font.BOLD,20));
    l1.setBackground(Color.cyan);
    b2=new Button("FACULTY");
    l1.setBounds(350,400,440,50);
    b1.setForeground(Color.yellow);
    b2.setForeground(Color.yellow);
    b3.setForeground(Color.yellow);
    b1.setBackground(Color.red);
    b2.setBackground(Color.red);
    b3.setBackground(Color.red);
    b1.setBounds(300,500,100,40);
    b2.setBounds(600,500,100,40);
    b3.setBounds(450, 560, 100, 40);
    add(l1);
    add(b1);
    add(b2);
    add(b3);
    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    addWindowListener(new WindowAdapter()
    		{
    	      public void windowClosing(WindowEvent e)
    	      {
    	    	  System.exit(0);
    	      }
    		});
}
public void paint(Graphics g){
	paint1((Graphics2D)g);
}
public void paint1(Graphics2D g){
	g.setStroke(new BasicStroke(8));
	g.setColor(Color.red);
	g.drawOval(100, 300, 800, 500);
}
 public void actionPerformed(ActionEvent e)
 {
	 if(b1==e.getSource())
	 {
		 this.setVisible(false);
		 Student s=new Student();
		 s.setSize(1000,1000);
		 s.setTitle("student");
		 s.setVisible(true);
		 s.setBackground(Color.GREEN);
		 
	 }

	 if(b2==e.getSource())
	 {
		 this.setVisible(false);
		 Faculty s=new Faculty();
		 s.setSize(1000,1000);
		 s.setTitle("faculty");
		 s.setVisible(true);
		 s.setBackground(Color.green);	 
	 }
	 if(b3==e.getSource()){
		 this.setVisible(false);
		 Adminlogin a=new Adminlogin();
		 a.setTitle("Admin");
		 a.setSize(1000, 1000);
		 a.setVisible(true);
		 a.setBackground(Color.cyan);
	 }
 }
 public static void main(String args[])
 {
	 Main c=new Main();
	 c.setVisible(true);
	 c.setSize(1000,1000);
	 c.setTitle("LIBRARY SYSTEM");
	 c.setBackground(Color.cyan);
 }

}
