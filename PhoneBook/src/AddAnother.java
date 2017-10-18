import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.mysql.jdbc.Connection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddAnother extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAnother frame = new AddAnother();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AddAnother() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 475, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(116, 47, 71, 14);
		contentPane.add(lblName);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number:");
		lblMobileNumber.setBounds(116, 72, 90, 14);
		contentPane.add(lblMobileNumber);
		
		JLabel lblAddNewMobile = new JLabel("Add new Mobile Number:");
		lblAddNewMobile.setBounds(116, 97, 129, 14);
		contentPane.add(lblAddNewMobile);
		
		textField = new JTextField();
		textField.setBounds(252, 44, 104, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(AddContact.textField.getText().toString());
		
		textField_1 = new JTextField();
		textField_1.setBounds(252, 69, 104, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(AddContact.textField_2.getText().toString());
		
		textField_2 = new JTextField();
		textField_2.setBounds(252, 94, 104, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number;
				number=textField_2.getText().toString();
				String cnumber;
				cnumber=AddContact.textField_2.getText().toString();
				String add=number.concat(",").concat(cnumber);
				AddContact.textField_2.setText(add);
				dispose();
			}
			}
		);
		btnAdd.setBounds(195, 140, 89, 23);
		contentPane.add(btnAdd);
	}
}
