import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.mysql.jdbc.Connection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ModifyContact extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	JComboBox comboBox;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyContact frame = new ModifyContact();
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
		String str="select cname,cmobile,cadd,ccity,cstate,ccountry from contacts where cid=?";
		java.sql.PreparedStatement ps=cn.prepareStatement(str);
		ps.setString(1,comboBox.getSelectedItem().toString());
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			textField.setText(rs.getString(1));
			textField_1.setText(rs.getString(2));
			textField_2.setText(rs.getString(3));
			textField_3.setText(rs.getString(4));
			textField_4.setText(rs.getString(5));
			textField_5.setText(rs.getString(6));
		}
		cn.close();
		
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public ModifyContact() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectName = new JLabel("Select ID:");
		lblSelectName.setBounds(115, 11, 89, 20);
		contentPane.add(lblSelectName);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTextFields();
			}
		});
		comboBox.setBounds(214, 11, 116, 20);
		contentPane.add(comboBox);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(115, 42, 89, 20);
		contentPane.add(lblName);
		
		JLabel lblMobileNumbers = new JLabel("Mobile Numbers: ");
		lblMobileNumbers.setBounds(115, 73, 89, 20);
		contentPane.add(lblMobileNumbers);
		
		JLabel lblAddress = new JLabel("Address: ");
		lblAddress.setBounds(115, 104, 89, 20);
		contentPane.add(lblAddress);
		
		JLabel lblCity = new JLabel("City: ");
		lblCity.setBounds(115, 135, 89, 20);
		contentPane.add(lblCity);
		
		JLabel lblCountry = new JLabel("State: ");
		lblCountry.setBounds(115, 166, 89, 20);
		contentPane.add(lblCountry);
		
		JLabel lblCountry_1 = new JLabel("Country: ");
		lblCountry_1.setBounds(115, 197, 89, 20);
		contentPane.add(lblCountry_1);
		
		textField = new JTextField();
		textField.setBounds(214, 42, 116, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(214, 73, 116, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(214, 104, 116, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(214, 135, 116, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(214, 166, 116, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(214, 197, 116, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/phonebook?user=root&password=Sarthak@124");
					String str="update contacts set cname=?,cmobile=?, cadd=?, ccity=?, cstate=?, ccountry=? where cid=?";
					java.sql.PreparedStatement ps4=cn.prepareStatement(str);
					ps4.setString(1,textField.getText());	
					ps4.setString(2,textField_1.getText() );
					ps4.setString(3,textField_2.getText());
					ps4.setString(4,textField_3.getText());
					ps4.setString(5,textField_4.getText());
					ps4.setString(6,textField_5.getText());
					ps4.setString(7,comboBox.getSelectedItem().toString());
					ps4.executeUpdate();
					cn.close();
					JOptionPane.showMessageDialog(null, "Data Updated");
					textField.setText(" ");
					textField_1.setText(" ");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
				}
				catch(Exception f)
				{
					JOptionPane.showMessageDialog(null, f.getMessage());
				}
			}
		});
		btnModify.setBounds(164, 227, 89, 23);
		contentPane.add(btnModify);
	
		getContactID();
		fillTextFields();
	}
}
