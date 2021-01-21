import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class Fd extends Frame implements ActionListener {
 //Label l1;
 Button b1,b2,b3,b4;
 String s4;
 Fd(String h)
 {  
	 s4=h;
   setLayout(null);
   b1=new Button("SEARCH AND ISSUE BOOKS");
   b1.setBounds(100,200,200,40);
   b2=new Button("RETURN BOOKS");
   b2.setBounds(400,200,150,40);
   b1.setBackground(Color.red);
   b2.setBackground(Color.red);
   add(b1);
   add(b2);
   this.addWindowListener(new WindowAdapter()
	{
     public void windowClosing(WindowEvent e)
     {
   	  System.exit(0);
     }
	});
   b1.addActionListener(this);
   b2.addActionListener(this);
 }
 public void paint(Graphics g){
	 g.setFont(new Font("Bold",Font.BOLD,24));
	 g.drawString("Your Options are:",100	, 100);
 }
 public void actionPerformed(ActionEvent e)
 {
	 if(b1==e.getSource())
	 {
		 this.setVisible(false);
	    SearchBookss s=new SearchBookss(s4);
	    s.setSize(1000,1000);
	    s.setVisible(true);
	    s.setTitle("SEARCH BOOKS");
	    s.setBackground(Color.green);
	 }
	 if(b2==e.getSource())
	 {
		 this.setVisible(false);
		  ReturnBooks db=new ReturnBooks(s4);
		 db.setSize(1000,1000);
		 db.setTitle("RETURN BOOK");
		 db.setVisible(true);
		 db.setBackground(Color.cyan);
	 } 
 }
}
