package GUIDemo;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Book;
import Model.BookDao;

public class BookManagement extends JFrame implements ActionListener 
{
	
	private JLabel lblBid, lblName, lblAuthor, lblPrice;
	private JTextField txtBid, txtName, txtAuthor, txtPrice;
	private JButton btnInsert, btnUpdate, btnDelete, btnSerach, btnClear, btnShowall;
	private Container cp;
	BookDao dao;
	public BookManagement(String t) throws ClassNotFoundException, SQLException 
	{
		super(t);
		dao= new BookDao();
		cp=getContentPane();
		cp.setLayout(new GridLayout(7,2,10,10));
		cp.setBackground(Color.pink);
		setForeground(Color.gray);
		
		lblBid = new JLabel("Book Id :-");
		txtBid = new JTextField();
		
		lblName = new JLabel("Book Name :-");
		txtName = new JTextField();
		
		lblAuthor = new JLabel("Book Author :-");
		txtAuthor = new JTextField();
		
		lblPrice = new JLabel("Book Price :-");
		txtPrice = new JTextField();
		
		
		
		btnInsert = new JButton("INSERT");
		btnUpdate = new JButton("UPDATE");
		btnDelete = new JButton("DELETE");
		btnSerach = new JButton("SEARCH");
		btnClear = new JButton("CLEAR");
		btnShowall = new JButton("SHOW ALL");
		
		
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSerach.addActionListener(this);
		btnClear.addActionListener(this);
		btnShowall.addActionListener(this);
		
		cp.add(lblBid);
		cp.add(txtBid);
		cp.add(lblName);
		cp.add(txtName);
		cp.add(lblAuthor);
		cp.add(txtAuthor);
		cp.add(lblPrice);
		cp.add(txtPrice);
		
		cp.add(btnInsert);
		cp.add(btnUpdate);
		cp.add(btnDelete);
		cp.add(btnSerach);
		cp.add(btnClear);
		cp.add(btnShowall);
		
		setSize(700,700);
		setVisible(true);
		
	}
	



	@Override
	public void actionPerformed(ActionEvent e)
	{
		try {
			if(e.getSource()==btnInsert)
			{
				int bid=Integer.parseInt(txtBid.getText());
				double Price=Double.parseDouble(txtPrice.getText());
				
				//wrap data to object
				Book obj= new Book(bid,txtName.getText(),txtAuthor.getText(),Price);
				boolean r =dao.insertBook(obj);
				
				if(r)JOptionPane.showMessageDialog(this, "Record Inserted.....");
			}
			
			else if(e.getSource()==btnUpdate)
			{
				int id=Integer.parseInt(txtBid.getText());
				double p=Double.parseDouble(txtPrice.getText());
				 
				
				Book obj= new Book(id,txtName.getText(), txtAuthor.getText(), p);
				
				boolean r=dao.UpdateBook(obj);
				
				if(r)
					JOptionPane.showMessageDialog(this, "Record Updated..");
				else
					JOptionPane.showMessageDialog(this, "Record not FOUND....");
			}
			else if (e.getSource() == btnDelete) {
			    
		        int id = Integer.parseInt(txtBid.getText());
		     
		        boolean r = dao.DeleteBook(id);
		        
		        if (r) {
		            JOptionPane.showMessageDialog(this, "Record Deleted");
		            
		        } 
			
			else if(e.getSource()==btnSerach)
			{
				int bid=Integer.parseInt(txtBid.getText());
				ResultSet rs=dao.SearchBook(bid);
				
				if(rs.next())
				{
					String rec="Id="+rs.getInt(1)+"\nBook name="+rs.getString(2)+"\nAuthor name="+rs.getString(3)+"\n Book Price"+rs.getDouble(4);
					JOptionPane.showMessageDialog(this, "Record Found...."+rec);
				}
				else
					JOptionPane.showMessageDialog(this, "Record not Found....");
			}
			else if(e.getSource()==btnClear)
			{
				txtBid.setText("");
				txtName.setText("");
				txtAuthor.setText("");
			}
		}
		}catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public static void main(String[] args)
	{
		try {
			new BookManagement("GUI OF BOOK MANAGEMENT ");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


}
