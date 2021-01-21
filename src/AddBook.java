import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddBook extends Frame implements ActionListener {
	Label l1,l2,l3,l4,l5,l6,l7,l8;
	TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	Choice c1;Button b1;
	AddBook(){
		setLayout(null);
		l1=new Label("BookID");
		l2=new Label("Author:");
		l3=new Label("name:");
		l4=new Label("price:");
		l5=new Label("rackNo:");
		l6=new Label("Status:");
		l7=new Label("edition:");
		l8=new Label("Date Of Purchase:");
		b1=new Button("Submit");
		b1.setBounds(40, 450, 100, 30);
		b1.setBackground(Color.red);
		tf1=new TextField();
		tf2=new TextField();
		tf3=new TextField();
		tf4=new TextField();
		tf5=new TextField();
		tf6=new TextField();
		tf7=new TextField();
		c1=new Choice();
		c1.add("---");
		c1.add("avail");
		c1.add("navail");
		l1.setBounds(40, 50, 100, 30);
		tf1.setBounds(140, 50, 200, 30);
		l2.setBounds(40, 100, 100, 30);
		tf2.setBounds(140, 100, 100, 30);
		l3.setBounds(40, 150, 100, 30);
		tf3.setBounds(140, 150, 100, 30);
		l4.setBounds(40, 200, 100, 30);
		tf4.setBounds(140, 200, 100, 30);
		l5.setBounds(40, 250, 100, 30);
		tf5.setBounds(140, 250, 100, 30);
		l6.setBounds(40, 300, 100, 30);
		c1.setBounds(140, 300, 100, 30);
		l7.setBounds(40, 350, 100, 30);
		tf6.setBounds(140, 350, 100, 30);
		l8.setBounds(40, 400, 100, 30);
		tf7.setBounds(140, 400, 100, 30);
		b1.addActionListener(this);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		add(l1);add(l2);add(l3);add(l4);add(l5);add(l6);add(l7);add(l8);
		add(tf1);add(tf2);add(tf3);add(tf4);add(tf5);add(tf6);add(tf7);add(b1);
		add(c1);
	}
	public void actionPerformed(ActionEvent e){
		if(b1==e.getSource()){
			try{
				Class.forName("com.mysql.jdbc.Driver");
			 Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			   //2. create statement
			   Statement myStmt =myConn.createStatement();
			   myStmt.executeUpdate("insert into books values("+Integer.parseInt(tf1.getText())+",'"+tf2.getText()+"','"+tf3.getText()+"',"+Integer.parseInt(tf4.getText())+","+Integer.parseInt(tf5.getText())+",'"+c1.getSelectedItem()+"','"+tf6.getText()+"','"+tf7.getText()+"',"+"null , null );");
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
