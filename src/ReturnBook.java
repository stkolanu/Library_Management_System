
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class ReturnBook extends Frame implements ActionListener {
Button b1,b2,b3;
Label l1,l2;
TextField t1;
String s4;
ReturnBook(String h)
{
	setLayout(null);
	s4=h;
	l1=new Label("BOOK ID");
	l2=new Label("");
	t1=new TextField(30);
	b1=new Button("RETURN");
	b2=new Button("BACK");
	b3=new Button("BILL");
	b2.setBackground(Color.red);
	b1.setBackground(Color.red);
	l1.setBackground(Color.cyan);
	l1.setBounds(100,100,100,20);
	t1.setBounds(200,100,100,20);
	b1.setBounds(400,400,100,40);
	b2.setBounds(400,450,100,40);
	add(l1); add(t1); add(b1); add(b2);
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
 
public void actionPerformed(ActionEvent e)
{
	PreparedStatement statement=null;
	String s=null;
	  int a=Integer.parseInt(t1.getText());
	  int f1 = 0;
  if(b1==e.getSource())
  {  
	  
	  try {
	  Class.forName("com.mysql.jdbc.Driver");
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		  statement = con.prepareStatement("select sid from books where bookid= "+Integer.parseInt(t1.getText())+";"); 
		  ResultSet result=statement.executeQuery();
		  while(result.next())
		  {
			f1=result.getInt(1);
		  } 
		int  a1=Integer.parseInt(s4);
		  if(f1==a1)
		  {
			  l2.setFont(new Font("Bold",Font.BOLD,18));
			  l2.setText("Book was issued to u !! Complete Bill Process");
			  l2.setBounds(100,210,420,40);
			  l2.setBackground(Color.cyan);
			  add(l2);
			  add(b3);
			  b3.setBounds(100,260,70,40);
			  b3.setBackground(Color.red);
			  b3.addActionListener(this);
		  }
		  else
		  {
			  l2.setFont(new Font("bold",Font.BOLD,18));
			  l2.setText("Oops! error: check bookid ");
			  l2.setBounds(100,210,400,40);
			  add(l2);
		  }
	  }
	  catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
  }
  if(b2==e.getSource())
  {
	  this.setVisible(false);
	  Sd c=new Sd(s4);
      c.setSize(1000,1000);
      c.setVisible(true);
      c.setTitle("details");
      c.setBackground(Color.green);
  }
  if(b3==e.getSource())
  {
	  this.setVisible(false);
	  Bill b=new Bill(s4,a);
	  b.setVisible(true);
	  b.setSize(1000,1000);
	  b.setTitle("Billing process");
	  b.setBackground(Color.cyan);
  }
}
}
