package uiManagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;

import dataManagement.UserDB;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;

public class CreateAccountScreen extends JFrame {

	private JPanel contentPane;
	private JLabel labelforImage;
	private JLabel lblEnterInfo;
	private JButton btnRegister;
	private JButton btnBack;
	private JLabel lblUserName;
	private JTextField textFieldEmail;
	private JTextField textFieldUserName;
	private JPasswordField passwordField;
	public UserDB userdb = UserDB.getSoleInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountScreen frame = new CreateAccountScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateAccountScreen() {
		
		initComponents();
		createEvents();

	}
	
	private void initComponents() {
		setTitle("Foogle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setPreferredSize(new Dimension(1440,800));
	    getContentPane().add(contentPane, BorderLayout.CENTER);
	    pack();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(593, 170, 255, 71);
		lblUserName.setIcon(new ImageIcon(CreateAccountScreen.class.getResource("/resources/chef-hat-with-cutlery-restaurant-symbol-2.png")));
		lblUserName.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(617, 307, 238, 42);
		lblPassword.setIcon(new ImageIcon(CreateAccountScreen.class.getResource("/resources/key-2.png")));
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(671, 434, 178, 64);
		lblEmail.setIcon(new ImageIcon(CreateAccountScreen.class.getResource("/resources/at.png")));
		lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(839, 190, 330, 42);
		textFieldUserName.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(839, 451, 330, 42);
		textFieldEmail.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(839, 313, 330, 42);
		contentPane.setLayout(null);
		
		labelforImage = new JLabel("");
		labelforImage.setBounds(74, 101, 512, 476);
		labelforImage.setIcon(new ImageIcon(CreateAccountScreen.class.getResource("/resources/food.png")));
		contentPane.add(labelforImage);
		contentPane.add(textFieldUserName);
		contentPane.add(passwordField);
		contentPane.add(lblPassword);
		contentPane.add(lblEmail);
		contentPane.add(textFieldEmail);
		contentPane.add(lblUserName);
		
		lblEnterInfo = new JLabel("Please enter required information below.");
		lblEnterInfo.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblEnterInfo.setIcon(new ImageIcon(CreateAccountScreen.class.getResource("/resources/create-new-pencil-button.png")));
		lblEnterInfo.setBounds(598, 55, 439, 71);
		contentPane.add(lblEnterInfo);
		
		btnBack = new JButton("Back");
		
		btnBack.setIcon(new ImageIcon(CreateAccountScreen.class.getResource("/resources/back_64.png")));
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnBack.setBounds(41, 36, 151, 76);
		contentPane.add(btnBack);
		
		btnRegister = new JButton("Register");
		btnRegister.setIcon(new ImageIcon(CreateAccountScreen.class.getResource("/resources/create-group-button-3.png")));
		
		btnRegister.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnRegister.setBounds(999, 599, 170, 76);
		contentPane.add(btnRegister);
		
	}
	
	private void createEvents() {
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String strPassword = String.valueOf(passwordField.getPassword());
				
				if(textFieldUserName.getText().isEmpty() || textFieldEmail.getText().isEmpty() || passwordField.getPassword().length == 0){
					JOptionPane.showMessageDialog(null,"Please check if you enter all of the blanks! ");
				}
				else if(userdb.doesUsernameExist(textFieldUserName.getText())){
					JOptionPane.showMessageDialog(null,"User name already exists, please try another name or check if you already have an account! ");
				}
				else if(userdb.doesEmailExist(textFieldEmail.getText())){
					JOptionPane.showMessageDialog(null,"Email already exists, please try another mail or check if you already have an account! ");
				}
				else{  
					userdb.createRestaurantOwnerAccount(textFieldUserName.getText(),strPassword, textFieldEmail.getText());
					JOptionPane.showMessageDialog(null,"Your account is created! :) ");
					dispose();
					MainMenu mainmenu = new MainMenu();
					mainmenu.setVisible(true);
				}
			}
		});
		
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginScreen loginScreen = new LoginScreen();
				loginScreen.setVisible(true);
			}
		});
	}
}
