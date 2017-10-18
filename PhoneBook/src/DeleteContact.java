import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DeleteContact extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteContact frame = new DeleteContact();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	void getContactID()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/phonebook?user=root&password=Sarthak@124");
		String str="select cid from contacts";
		java.sql.PreparedStatement ps=cn.prepareStatement(str);
		ResultSet rs=ps.executeQuery();
		DefaultComboBoxModel dc=new DefaultComboBoxModel();
		while(rs.next())
		{
			dc.addElement(rs.getString(1));
		}
		cn.close();
		comboBox.setModel(dc);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	void fillTextFields()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/phonebook?user=root&password=Sarthak@124");
		String str="select cname from contacts where cid=?";
		java.sql.PreparedStatement ps=cn.prepareStatement(str);
		ps.setString(1,comboBox.getSelectedItem().toString());
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			textField.setText(rs.getString(1));
		}
		cn.close();
		
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public DeleteContact() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectId = new JLabel("Select ID:");
		lblSelectId.setBounds(133, 40, 79, 21);
		contentPane.add(lblSelectId);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(133, 72, 79, 21);
		contentPane.add(lblName);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/phonebook?user=root&password=Sarthak@124");
					String str="delete from contacts where cid=?";
					java.sql.PreparedStatement ps2=cn.prepareStatement(str);
					ps2.setString(1,comboBox.getSelectedItem().toString());
					ps2.executeUpdate();
					cn.close();
					JOptionPane.showMessageDialog(null, "Data Deleted");
					textField.setText(" ");
				}
				catch(Exception f)
				{
					JOptionPane.showMessageDialog(null, f.getMessage());
				}
			}
		});
		btnDelete.setBounds(168, 104, 89, 23);
		contentPane.add(btnDelete);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTextFields();
			}
		});
		comboBox.setBounds(209, 40, 89, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(209, 72, 89, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		getContactID();
		fillTextFields();
	}

}
