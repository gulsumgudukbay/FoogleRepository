package uiManagement;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
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
	public LoginScreen() {
	
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
		
		JTextField userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		
		JPasswordField passwordField = new JPasswordField();
		
		lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnLogin.setIcon(new ImageIcon(LoginScreen.class.getResource("/resources/login.png")));
		
		JLabel bossImage = new JLabel("");
		bossImage.setIcon(new ImageIcon(LoginScreen.class.getResource("/resources/boss.png")));
		
		JButton btnCreate = new JButton("Don't have an account?");
		btnCreate.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		
		btnback = new JButton("Back");
		
		btnback.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnback.setIcon(new ImageIcon(LoginScreen.class.getResource("/resources/back_64.png")));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(btnback, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 764, Short.MAX_VALUE)
							.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(bossImage)
							.addGap(197)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblUserName)
										.addComponent(lblPassword))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordField, 219, 219, 219))))))
					.addGap(174))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnCreate, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnback, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(71)
							.addComponent(bossImage)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(178)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUserName)
								.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							.addGap(68)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPassword)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addGap(140)
							.addComponent(btnLogin)
							.addGap(150))))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	private void createEvents() {
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainMenu mainmenu = new MainMenu();
				mainmenu.setVisible(true);
			}
		});
		
	}
}

