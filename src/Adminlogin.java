
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class Adminlogin extends Frame implements ActionListener {
	 Button b1;
	  Label l1,l2;
	  TextField t1,t2;
	  Label l3,l4;
	  Adminlogin()
	  {
		  setLayout(null);
		  b1=new Button("Login");
		  l1=new Label("USERID");
		  l2=new Label("PASSWORD");
		  l3=new Label("");
		  l4=new Label("");
	      t1=new TextField(30);
		  t2=new TextField(30);
		  t2.setEchoChar('*');
		  
		  b1.setBounds(400,450,80,40);
		  l1.setBounds(350,350,60,20);
		  l2.setBounds(350,390,70,20);
		  l1.setBackground(Color.green);
		  l2.setBackground(Color.green);
		  t1.setBounds(440,350,100,40);
		  t2.setBounds(440,390,100,40);
		  b1.setBackground(Color.red);
		  add(l1);
		  add(l2);
		  add(t1);
		  add(t2);
		  add(b1);
		  b1.addActionListener(this);
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
				Connection con=null;
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
						statement = con.prepareStatement("select password from admin where aid= '"+s+"';");
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
			         try {
						
			        	 ResultSet result=statement.executeQuery();
						  
						  while(result.next())
						  {
							  s3=result.getString(1);
						  }
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			      
			        if(s3.equals(s1))
			        {
			        
			          l3.setText("login successful and proceed");
			          l3.setBounds(400,500,200,30);
			          this.add(l3);
			          this.setVisible(false);
			 		 Admin a=new Admin();
			 		 a.setTitle("Admin");
			 		 a.setSize(1000, 1000);
			 		 a.setVisible(true);
			 		 a.setBackground(Color.cyan);
			       
			        }
			        else
			        {
			        	 l3.setText("");
			        	l4.setText("invalid Login");
			        	 l4.setBounds(400,500,100,20);
			        	 this.add(l4);
			        }
			       
				  }
				}
			}
