import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Trans extends Frame implements ActionListener {
	Label l1,l2,l3,l4;
	Connection con = null;
	PreparedStatement statement=null;
	Trans()
	{
	setLayout(null);
	l1=new Label("Student ID");
	l2=new Label("Faculty ID");
	l3=new Label("Book ID");
	l4=new Label("Transaction ID");
	l1.setBounds(50, 100, 200, 30);
	l2.setBounds(250, 100, 200, 30);
	l3.setBounds(450, 100, 200, 30);
	l4.setBounds(650, 100, 200, 30);
	add(l1);add(l2);add(l3);add(l4);
	try{
	Class.forName("com.mysql.jdbc.Driver");
	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
	  statement = con.prepareStatement("select * from transaction ;"); 
	  ResultSet result=statement.executeQuery();
	  while(result.next())
	  {
		  
	  }
	}
	catch(Exception e){}
	
	}
	public void paint(Graphics g){
		
	}
	
	public void actionPerformed(ActionEvent e){
		
	}

}
