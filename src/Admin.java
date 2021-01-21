import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class Admin extends Frame implements ActionListener{
	 Button b1,b2,b3,b4;
	 Admin(){
		 setLayout(null);
		 b1=new Button("Add Book");
		 b2=new Button("Add Faculty");
		 b3=new Button("Add Student");
		// b4=new Button("Check Transaction Table");
		 b1.setBounds(40, 100, 100, 30);
		 b2.setBounds(40, 150, 100, 30);
		 b3.setBounds(40, 200, 100, 30);
		// b4.setBounds(40, 250, 300, 30);
		 b1.setBackground(Color.red);
		 b2.setBackground(Color.red);
		 b3.setBackground(Color.red);
	//	 b4.setBackground(Color.red);
		 
		 this.addWindowListener(new WindowAdapter(){
			 public void windowClosing(WindowEvent e){
				 System.exit(0);
			 }
		 });
		 add(b1);add(b2);add(b3);//add(b4);
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
	//	 b4.addActionListener(this);
	 }
	 public void actionPerformed(ActionEvent ae){
		 if(b1==ae.getSource()){
			 this.setVisible(false);
			 AddBook ab=new AddBook();
			 ab.setTitle("Form");
			 ab.setVisible(true);
			 ab.setSize(1000, 1000);
			 ab.setBackground(Color.cyan);
		 }
		 if(b2==ae.getSource()){
			 this.setVisible(false);
			 AddFaculty af=new AddFaculty();
			 af.setTitle("Form");
			 af.setVisible(true);
			 af.setSize(1000, 1000);
		 }
		 if(b3==ae.getSource()){
			 this.setVisible(false);
			AddStudent as=new AddStudent();
			 as.setTitle("Form");
			 as.setSize(1000, 1000);
			 as.setVisible(true);
		 }
		 if(b4==ae.getSource()){
			 this.setVisible(false);
	//		 Trans ab=new Trans();
		 
		 }
		 
	 }
	public void paint(Graphics g){
		 g.setFont(new Font("Bold",Font.BOLD,24));
		 g.drawString("Admin  Options are:",100	, 100);
	 }
	 

}
