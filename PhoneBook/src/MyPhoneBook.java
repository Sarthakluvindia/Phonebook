import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MyPhoneBook extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPhoneBook frame = new MyPhoneBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MyPhoneBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMyPhonebook = new JLabel("My Phonebook");
		lblMyPhonebook.setFont(new Font("Arial", Font.BOLD, 30));
		lblMyPhonebook.setBounds(10, 0, 225, 45);
		contentPane.add(lblMyPhonebook);
		
		JLabel lblThisIsA = new JLabel("This is a Phonebook, in which one can add, modify, delete or search for Contacts.");
		lblThisIsA.setFont(new Font("Arial", Font.PLAIN, 11));
		lblThisIsA.setBounds(10, 56, 414, 14);
		contentPane.add(lblThisIsA);
		
		JLabel lblToAddContact = new JLabel("To Add Contact, click on Add Contact button.");
		lblToAddContact.setBounds(10, 81, 243, 14);
		contentPane.add(lblToAddContact);
		
		JLabel lblToModifyContact = new JLabel("To Modify Contact, click on Modify Contact button.");
		lblToModifyContact.setBounds(10, 106, 253, 14);
		contentPane.add(lblToModifyContact);
		
		JLabel lblToSearchFor = new JLabel("To Search for Contacts, click on Search Contact button.");
		lblToSearchFor.setBounds(10, 131, 277, 14);
		contentPane.add(lblToSearchFor);
		
		JLabel lblToDeleteContact = new JLabel("To Delete Contact, click on Delete Contact button.");
		lblToDeleteContact.setBounds(10, 156, 243, 14);
		contentPane.add(lblToDeleteContact);
		
		JLabel lblToExitClick = new JLabel("To Exit, click on Exit button.");
		lblToExitClick.setBounds(10, 181, 175, 14);
		contentPane.add(lblToExitClick);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(20, 214, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnAddContact = new JButton("Add Contact");
		btnAddContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddContact ac=new AddContact();
				ac.setVisible(true);
				ac.setSize(500, 500);
			}
		});
		btnAddContact.setBounds(316, 81, 108, 23);
		contentPane.add(btnAddContact);
		
		JButton btnNewButton = new JButton("Modify Contact");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyContact mc=new ModifyContact();
				mc.setVisible(true);
			}
		});
		btnNewButton.setBounds(316, 115, 108, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSearchContact = new JButton("Search Contact");
		btnSearchContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchContact sc=new SearchContact();
				sc.setVisible(true);
			}
		});
		btnSearchContact.setBounds(316, 152, 108, 23);
		contentPane.add(btnSearchContact);
		
		JButton btnDeleteContact = new JButton("Delete Contact");
		btnDeleteContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteContact dc=new DeleteContact();
				dc.setVisible(true);
			}
		});
		btnDeleteContact.setBounds(316, 188, 108, 23);
		contentPane.add(btnDeleteContact);
	}
}
