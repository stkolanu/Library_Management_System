

/*public class IssueBooks extends Frame implements ActionListener {
Label l1,l2,l3;
TextField t1,t2;
Button b1,b2;
String s4;
int bid;
IssueBooks(String h,int a)
{
	bid=a;
	s4=h;
	setLayout(null);
	l1=new Label("bookid");
	l2=new Label("");
	t1=new TextField(30);
	t1.setText(Integer.toString(bid));
	t1.setEditable(false);
	b1=new Button("Transaction");
	b2=new Button("Exit");
	l1.setBounds(100,100,40,20);
    t1.setBounds(150,100,40,20);
    b1.setBounds(100,200,90,30);
    b2.setBounds(200,200,90,30);
    add(l1); add(t1); add(b1); add(b2);
    addWindowListener(new WindowAdapter()
	{
      public void windowClosing(WindowEvent e)
      {
    	  System.exit(0);
      }
	});
    b1.addActionListener(this);
    b2.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
	 PreparedStatement statement=null,statement1=null,statement2=null;
	 String s = null,s1=null;
	 int a=0;
 	if(b1==e.getSource())
 	{
 		  try {
 			  Class.forName("com.mysql.jdbc.Driver");
 			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
 			  statement = con.prepareStatement("select status from books where bookid="+Integer.parseInt(t1.getText())+";"); 
 			  ResultSet result=statement.executeQuery();
 			  while(result.next())
 			  {
 				s=result.getString(1);
 			  }  
 			 statement1 = con.prepareStatement("select noBookIssued from faculty where fid="+Integer.parseInt(s4)+";"); 
			  ResultSet result1=statement1.executeQuery();
			  while(result1.next())
			  {
				  int temp=0;
				temp=result1.getInt(1);
				a=temp;
			  }
 			  if((a<10))
 			  {
 				 l2.setText("limit within range and  complete transaction"); 
 				 l2.setBounds(100,250,350,50);
 				
 				 this.add(l2);
 				 
 				 Transactions t=new Transactions(s4,bid);
 				 t.setSize(1000,1000);
 				 t.setVisible(true);
 				 t.setTitle("Transaction");
 				 t.setBackground(Color.green);
 				 
 			  }
 			  else 
 			  {
 				  l2.setText("oops! max limit reached");
 				 l2.setBounds(100,250,350,50);
 				 this.add(l2);
 				 
 			  }
 		  }
 		  catch (SQLException | ClassNotFoundException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
 	  
 	}
 	if(b2==e.getSource())
 	{
 		System.exit(0);
 	}
}
}

*/

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class IssueBooks extends Frame implements ActionListener {
Label l1,l2,l3;
TextField t1,t2;
Button b1,b2;
String s4;
int bid;
IssueBooks(String h,int a)
{
	bid=a;
	s4=h;
	setLayout(null);
	l1=new Label("bookid");
	l2=new Label("");
	t1=new TextField(30);
	t1.setText(Integer.toString(bid));
	t1.setEditable(false);
	b1=new Button("Transaction");
	b2=new Button("Exit");
	l1.setBounds(100,100,40,40);
	l1.setBackground(Color.cyan);
    t1.setBounds(150,100,100,40);
    b1.setBounds(100,200,90,30);
    b2.setBounds(200,200,90,30);
    b1.setBackground(Color.red);
    b2.setBackground(Color.red);
    add(l1); add(t1); add(b1); add(b2);
    addWindowListener(new WindowAdapter()
	{
      public void windowClosing(WindowEvent e)
      {
    	  System.exit(0);
      }
	});
    b1.addActionListener(this);
    b2.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
	 PreparedStatement statement=null,statement1=null,statement2=null;
	 String s = null;
	 int s1=0;
	 int a=0;
 	if(b1==e.getSource())
 	{
 		  try {
 			  Class.forName("com.mysql.jdbc.Driver");
 			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
 			  statement = con.prepareStatement("select status from books where bookid="+Integer.parseInt(t1.getText())+";"); 
 			  ResultSet result=statement.executeQuery();
 			  while(result.next())
 			  {
 				s=result.getString(1);
 			  }  
 			 statement1 = con.prepareStatement("select noBookIssued from faculty where fid='"+s4+"';"); 
			  ResultSet result1=statement1.executeQuery();
			  while(result1.next())
			  {
				s1=result1.getInt(1);
				a=s1;
			  }
 			  if((a>=0 && a<3))
 			  {
 				 l2.setText("limit is within range and complete transaction"); 
 				 l2.setBounds(100,250,350,50);
 				 this.add(l2);
 				 this.setVisible(false);
 				 Transactions t=new Transactions(s4,bid);
 				 t.setSize(1000,1000);
 				 t.setVisible(true);
 				 t.setTitle("Transaction");
 				 t.setBackground(Color.cyan);
 			  }
 			  else 
 			  {
 				  l2.setText("oops! max limit reached");
 				 l2.setBounds(100,250,350,50);
 				 this.add(l2);
 			  }
 		  }
 		  catch (SQLException | ClassNotFoundException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
 	}
 	if(b2==e.getSource())
 	{
 		System.exit(0);
 	}
}
}
