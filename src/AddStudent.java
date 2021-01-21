import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddStudent extends Frame implements ActionListener {
	Label l1,l2;
	TextField tf1,tf2;Button b1;
	AddStudent(){
		setLayout(null);
		l1=new Label("Student ID(Should be rollno(First Year)):");
		l2=new Label("Password:");
		b1=new Button("Submit");
		b1.setBounds(40, 450, 100, 30);
		b1.setBackground(Color.red);
		tf1=new TextField();
		tf2=new TextField();
		tf2.setEchoChar('*');
		l1.setBounds(40, 50, 500, 30);
		tf1.setBounds(540, 50, 200, 30);
		l2.setBounds(40, 100, 100, 30);
		tf2.setBounds(140, 100, 100, 30);
		b1.setBounds(40, 150, 100, 30);
		b1.addActionListener(this);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		add(l1);add(l2);add(b1);add(tf1);add(tf2);
	}
	public void actionPerformed(ActionEvent e){
		if(b1==e.getSource()){
			try{
				Class.forName("com.mysql.jdbc.Driver");
			 Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			   //2. create statement
			   Statement myStmt =myConn.createStatement();
			   myStmt.executeUpdate("insert into student values("+Integer.parseInt(tf1.getText())+",'"+tf2.getText()+"', 0 );");
			   this.setVisible(false);
				 Admin a=new Admin();
				 a.setTitle("Admin");
				 a.setSize(1000, 1000);
				 a.setVisible(true);
				 a.setBackground(Color.cyan);
			}
			catch(Exception e4t){
				System.out.println(e4t);
			}
		}
	}

}