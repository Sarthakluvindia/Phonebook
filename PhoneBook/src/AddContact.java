import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.UIManager;

import com.mysql.jdbc.Connection;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;

import javax.swing.JRadioButton;


public class AddContact extends JFrame {

	private JPanel contentPane;
static	JTextField textField;
	private JTextField textField_1;
	static JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JRadioButton rdbtnImportant;
	private JRadioButton rdbtnNotImportant;
	private JTextArea textArea;
	private JLabel lblAddContactDetails;
	private JLabel lblName;
	private JLabel label;
	private JLabel lblPetNameif;
	private JLabel lblAddContackDetails;
	private JLabel lblMobileNumber;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblPincode;
	private JLabel lblState;
	private JLabel lblCountry;
	private JLabel lblImportance;
	private JButton btnAddAnother;

	public AddContact() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 503, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAddContactDetails = new JLabel("Add Personal details below:-");
		lblAddContactDetails.setBounds(10, 11, 213, 14);
		contentPane.add(lblAddContactDetails);
		
		lblName = new JLabel("Name :");
		lblName.setBounds(100, 36, 82, 14);
		contentPane.add(lblName);
		
		label = new JLabel("");
		label.setBounds(100, 61, 46, 14);
		contentPane.add(label);
		
		lblPetNameif = new JLabel("Pet Name (if any) :");
		lblPetNameif.setBounds(100, 61, 113, 14);
		contentPane.add(lblPetNameif);
		
		lblAddContackDetails = new JLabel("Add Contack details below:-");
		lblAddContackDetails.setBounds(10, 89, 172, 14);
		contentPane.add(lblAddContackDetails);
		
		lblMobileNumber = new JLabel("Mobile Number :");
		lblMobileNumber.setBounds(100, 116, 113, 14);
		contentPane.add(lblMobileNumber);
		
		lblAddress = new JLabel("Address :");
		lblAddress.setBounds(100, 141, 82, 14);
		contentPane.add(lblAddress);
		
		textField = new JTextField();
		textField.setBounds(223, 33, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(223, 58, 131, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(223, 113, 131, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblCity = new JLabel("City :");
		lblCity.setBounds(100, 203, 62, 14);
		contentPane.add(lblCity);
		
		textField_3 = new JTextField();
		textField_3.setBounds(223, 200, 131, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		lblPincode = new JLabel("Pincode :");
		lblPincode.setBounds(100, 228, 82, 14);
		contentPane.add(lblPincode);
		
		textField_4 = new JTextField();
		textField_4.setBounds(223, 225, 131, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		lblState = new JLabel("State :");
		lblState.setBounds(100, 253, 82, 14);
		contentPane.add(lblState);
		
		lblCountry = new JLabel("Country :");
		lblCountry.setBounds(100, 278, 82, 14);
		contentPane.add(lblCountry);
		
		lblImportance = new JLabel("Importance :");
		lblImportance.setBounds(100, 303, 82, 14);
		contentPane.add(lblImportance);
		
		textField_5 = new JTextField();
		textField_5.setBounds(223, 250, 131, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(223, 275, 131, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rdbtnImportant);
		bg.add(rdbtnNotImportant);
		
		btnAddAnother = new JButton("Add Another");
		btnAddAnother.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAnother ad=new AddAnother();
				ad.setVisible(true);
			}
		});
		btnAddAnother.setBounds(364, 112, 113, 23);
		contentPane.add(btnAddAnother);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/phonebook?user=root&password=Sarthak@124");
					String str="insert into contacts(cname,cpname,cmobile,cadd,ccity,cpincode,cstate,ccountry,cimp) values(?,?,?,?,?,?,?,?,?)";
					java.sql.PreparedStatement ps=cn.prepareStatement(str);
					ps.setString(1,textField.getText());	
					ps.setString(2,textField_1.getText());
					ps.setString(3,textField_2.getText());
					ps.setString(4,textArea.getText());
					ps.setString(5,textField_3.getText());
					ps.setString(6, textField_4.getText());
					ps.setString(7,textField_5.getText());
					ps.setString(8,textField_6.getText());
					if(rdbtnImportant.isSelected())
						ps.setString(9,"Important");
					else
						ps.setString(9,"Not Important");
					ps.executeUpdate();
					cn.close();
					JOptionPane.showMessageDialog(null, "Data Saved");
					textField.setText(" ");
					textField_1.setText(" ");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textArea.setText("");
				}
				catch(Exception f)
				{
					JOptionPane.showMessageDialog(null, f.getMessage());
				}
			}
		});
		btnSave.setBounds(180, 365, 89, 23);
		contentPane.add(btnSave);
		
		textArea = new JTextArea();
		textArea.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		textArea.setBounds(223, 137, 131, 57);
		contentPane.add(textArea);
		
	    rdbtnImportant = new JRadioButton("Important");
		rdbtnImportant.setBounds(223, 299, 109, 23);
		contentPane.add(rdbtnImportant);
		
	    rdbtnNotImportant = new JRadioButton("Not Important");
		rdbtnNotImportant.setBounds(223, 325, 109, 23);
		contentPane.add(rdbtnNotImportant);
	}
}
