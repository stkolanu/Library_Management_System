
import java.awt.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
public class Transactions  extends Frame implements ActionListener{
Label l1,l2;
TextField t1;
Button b1,b2,b3;
String s4;
int bid;
Transactions(String h,int a)

{
	bid=a;
	s4=h;
	setLayout(null);
	l2=new Label("");
	b1=new Button("Complete");
    b2=new Button("Exit");
    b1.setBounds(100,100,70,20);
    b2.setBounds(180,100,70,20);
    add(b1); add(b2);
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
{  PreparedStatement statement=null,statement1=null;
PreparedStatement statement2=null,statement3=null;
    String s6,s3 = null;
    s6="navail";
  //  int siid=Integer.parseInt(s4);
	if(b1==e.getSource())
	{   try {
		 Class.forName("com.mysql.jdbc.Driver");
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		  statement = con.prepareStatement("update Books set fid="+Integer.parseInt(s4) +" where  bookid="+bid+";"); 
		  
		  statement.executeUpdate();
		  statement3=con.prepareStatement("select noBookIssued from faculty where fid="+Integer.parseInt(s4)+";");
		  statement3.executeQuery();
		  ResultSet result1=statement3.executeQuery();
		  int c = 0;
		while(result1.next())
		  {
			c=result1.getInt(1);
		  }
		  
		int b=c+1;
		Random rand=new Random();
		int rand1=rand.nextInt(1000);
		  statement2=con.prepareStatement("update faculty set noBookIssued='"+ b +"'  where fid= "+Integer.parseInt(s4)+";");
		  statement2.executeUpdate();
	 	   statement1 = con.prepareStatement("update Books set status= 'navail' where  bookid="+bid+";"); 
		  statement1.executeUpdate();  
		  PreparedStatement statement5 = con.prepareStatement("insert into  transaction values (null"+","+Integer.parseInt(s4)+","+ bid +", "+rand1+" );");
		  statement5.executeUpdate();
		  PreparedStatement statement6=con.prepareStatement("update books set dateofpurchase=CURDATE() where bookid="+bid+";");
		  statement6.executeUpdate();
	}
	  catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  l2.setText("completed successfully");
	  l2.setBounds(100,180,150,50);
	  this.add(l2);
	  this.setVisible(false);
	  Fd c=new Fd(s4);
      c.setSize(1000,1000);
      c.setVisible(true);
      c.setTitle("details");
      c.setBackground(Color.cyan);
	}
	if(b2==e.getSource())
	{
		System.exit(0);
	}
}
}

