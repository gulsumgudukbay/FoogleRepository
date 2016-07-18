package uiManagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dataManagement.UserDB;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JButton btnLogin;
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JButton btnback;
	private JButton btnCreate;
	private JTextField userNameTextField;
	private JPasswordField passwordField;
	private JLabel bossImage;
	private static String username;
	public UserDB userdb = UserDB.getSoleInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen(username);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param string 
	 */
	public LoginScreen(String username) {
		this.username = username;
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
	    getContentPane().add(contentPane, BorderLayout.SOUTH);
	    pack();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		
		passwordField = new JPasswordField();
		
		lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnLogin.setIcon(new ImageIcon(LoginScreen.class.getResource("/resources/login.png")));
		
		bossImage = new JLabel("");
		bossImage.setIcon(new ImageIcon(LoginScreen.class.getResource("/resources/boss.png")));
		
		btnCreate = new JButton("Don't have an account?\nGet one now!");
		btnCreate.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		
		btnback = new JButton("Back");
		
		btnback.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnback.setIcon(new ImageIcon(LoginScreen.class.getResource("/resources/back_64.png")));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(43)
					.addComponent(btnback, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(bossImage)
							.addGap(101)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblUserName)
										.addComponent(lblPassword))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordField, 219, 219, 219)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(703)
							.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)))
					.addGap(176))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnback))
					.addPreferredGap(ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUserName)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(68)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(140)
					.addComponent(btnLogin)
					.addGap(150))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(181, Short.MAX_VALUE)
					.addComponent(bossImage)
					.addGap(97))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	public static String getUsername(){
		return username;
	}
	
	private void createEvents() {
		
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strPassword = String.valueOf(passwordField.getPassword());
				
				if(userNameTextField.getText().isEmpty() || passwordField.getPassword().length == 0){
					JOptionPane.showMessageDialog(null,"Please check if you enter all of the blanks! ");
				}
				if(userdb.isAuthenticated(userNameTextField.getText(), strPassword)){
					JOptionPane.showMessageDialog(null,"Welcome " + userNameTextField.getText());
					username =userNameTextField.getText();
					dispose();
					LoggedInScreen loggedInScreen = new LoggedInScreen(username);
					loggedInScreen.setVisible(true);
					
				}
				else{
					JOptionPane.showMessageDialog(null,"The username and password does not match, please try again!");
				}
			}
		});
		
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainMenu mainmenu = new MainMenu();
				mainmenu.setVisible(true);
			}
		});
		
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CreateAccountScreen createAccount = new CreateAccountScreen();
				createAccount.setVisible(true);
			}
		});
		
	}
}

