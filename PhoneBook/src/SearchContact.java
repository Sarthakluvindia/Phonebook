import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;

import com.mysql.jdbc.Connection;


public class SearchContact extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchContact frame = new SearchContact();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void fill() 
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/phonebook?user=root&password=Sarthak@124");
		String str="select * from contacts";
		java.sql.PreparedStatement ps4=cn.prepareStatement(str);
		ResultSet rs=ps4.executeQuery();
		DefaultTableModel dc=new DefaultTableModel();
		dc.addColumn("Contact ID");
		dc.addColumn("Contact Name");
		dc.addColumn("Contact Pet Name");
		dc.addColumn("Contact Address");
		dc.addColumn("Contact City");
		dc.addColumn("Contact Pincode");
		dc.addColumn("Contact State");
		dc.addColumn("Contact Country");
		dc.addColumn("Important/Not Important");
		
		while(rs.next())
		{
			dc.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
		}
		table.setModel(dc);
		cn.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	void fill(String s) 
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/phonebook?user=root&password=Sarthak@124");
		String str="select * from contacts where cname like '"+s+"%' ";
		java.sql.PreparedStatement ps4=cn.prepareStatement(str);
		ResultSet rs=ps4.executeQuery();
		DefaultTableModel dc=new DefaultTableModel();
		dc.addColumn("Contact ID");
		dc.addColumn("Contact Name");
		dc.addColumn("Contact Pet Name");
		dc.addColumn("Contact Address");
		dc.addColumn("Contact City");
		dc.addColumn("Contact Pincode");
		dc.addColumn("Contact State");
		dc.addColumn("Contact Country");
		dc.addColumn("Important/Not Important");
		
		while(rs.next())
		{
			dc.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
		}
		table.setModel(dc);
		cn.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	
	public SearchContact() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				fill(textField.getText());
			}
		});
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		table = new JTable();
		contentPane.add(table, BorderLayout.CENTER);
		fill();
	}

}
