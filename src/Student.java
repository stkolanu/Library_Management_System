
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class Student extends Frame implements ActionListener {
  Button b1,b2;
  Label l1,l2;
  TextField t1,t2;
  Label l3,l4;
  Student()
  {
	  setLayout(null);
	  b1=new Button("Login");
	  b2=new Button("Exit");
	  l1=new Label("USERID");
	  l2=new Label("PASSWORD");
	  l1.setBackground(Color.green);
	  l2.setBackground(Color.green);
	  l3=new Label("");
	  l4=new Label("");
      t1=new TextField(30);
	  t2=new TextField(30);
	  t2.setEchoChar('*');
	  b1.setBounds(400,450,80,40);
	  b2.setBounds(500,450,80,40);
	  b1.setBackground(Color.red);
	  b2.setBackground(Color.red);
	  l1.setBounds(350,350,60,20);
	  l2.setBounds(350,390,80,20);
	  t1.setBounds(440,350,200,50);
	  t2.setBounds(440,400,200,50);
	  add(l1);  add(b2);
	  add(l2);
	  add(t1);
	  add(t2);
	  add(b1);
	  b1.addActionListener(this);
	  b2.addActionListener(this);
	  this.addWindowListener(new WindowAdapter()
		{
	      public void windowClosing(WindowEvent e)
	      {
	    	  System.exit(0);
	      }
		});
  }
public void actionPerformed(ActionEvent e)
	{  
	   String s,s1,s3 = null;
	ResultSet s2 = null;
	Connection con = null;
	  if(b1==e.getSource())
	  {
		  s=t1.getText();
		  s1=t2.getText();
		  try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		  try {
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			 con=con1;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//instead of testdb it was timeline
		  
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement("select password from student  where suid= '"+s+"';");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
         try {
			//s2=statement.executeQuery();
        	 ResultSet result=statement.executeQuery();
			  
			  while(result.next())
			  {
				  s3=result.getString(1);
			  }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      
        
        if(s3.equals(s1))
        {
          l3.setText("login successful and proceed");
          l3.setBounds(400,500,200,30);
          this.add(l3);
          this.setVisible(false);
          Sd c=new Sd(s);
          c.setSize(1000,1000);
          c.setVisible(true);
          c.setTitle("details");
          c.setBackground(Color.green);
        }
        else
        {
        	 l3.setText("");
        	// l4=new Label("invalid login");
        	l4.setText("invalid Login");
        	 l4.setBounds(400,500,100,20);
        	 this.add(l4);
        }
       
	  }
	  if(b2==e.getSource())
	  {
		  System.exit(0);
	  }
	}
}
