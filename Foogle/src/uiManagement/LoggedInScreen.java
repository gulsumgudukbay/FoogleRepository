package uiManagement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LoggedInScreen extends JFrame {
	
	private JPanel contentPane;
	private static String username;
	static String origUN;
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				
				try 
				{
					LoggedInScreen frame = new LoggedInScreen(username);
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}	
	
	public LoggedInScreen(String username) {
		this.username = username;
		initComponents();
	}
	
	public static String getorigun(){
		return origUN;
	}
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Foogle");
		setBounds(200, 200, 1440, 800);
		
		setResizable(false);
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(250, 240, 230));
		
		JButton btnAddRes = new JButton("Add a Restaurant");
		btnAddRes.setIcon(new ImageIcon(LoggedInScreen.class.getResource("/resources/shop.png")));
		
		btnAddRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddRestaurantScreen addResScreen = new AddRestaurantScreen(username);
				addResScreen.setVisible(true);
				dispose();
			}
		});
		
		btnAddRes.setBounds(862, 270, 329, 86);
		getContentPane().add(btnAddRes);
		
		
		JButton btnAddFood = new JButton("Add Food");
		btnAddFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddFoodScreen addFoodScreen = new AddFoodScreen(username);
				addFoodScreen.setVisible(true);
				
			}
		});
		btnAddFood.setIcon(new ImageIcon(LoggedInScreen.class.getResource("/resources/hamburguer.png")));
		btnAddFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddFoodScreen2 addFoodScreen = new AddFoodScreen2(username);
				addFoodScreen.setVisible(true);
				dispose();
			}
		});
		
		btnAddFood.setBounds(862, 405, 329, 86);
		getContentPane().add(btnAddFood);
		
		
		
		JButton btnMyAcc = new JButton("My Account");
		btnMyAcc.setIcon(new ImageIcon(LoggedInScreen.class.getResource("/resources/round-account-button-with-user-inside.png")));
		btnMyAcc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyAccountScreen2 myAccScreen = new MyAccountScreen2(username);
				myAccScreen.setVisible(true);
				dispose();
			}
		});
		
		btnMyAcc.setBounds(1214, 24, 196, 76);
		getContentPane().add(btnMyAcc);
		
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setIcon(new ImageIcon(LoggedInScreen.class.getResource("/resources/logout.png")));
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				origUN = username;
				MainMenu mainMenu = new MainMenu();
				mainMenu.setVisible(true);
				dispose();
			}
		});
		
		btnLogout.setBounds(1214, 112, 196, 76);
		getContentPane().add(btnLogout);
		
		JLabel lblicon = new JLabel("");
		lblicon.setIcon(new ImageIcon(LoggedInScreen.class.getResource("/resources/chef-2.png")));
		lblicon.setBounds(187, 156, 542, 413);
		getContentPane().add(lblicon);
		
		JLabel lblHi = new JLabel("Hi " + username + "!");
		lblHi.setFont(new Font("Lantinghei SC", Font.PLAIN, 25));
		lblHi.setBounds(804, 156, 302, 42);
		getContentPane().add(lblHi);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginScreen loginScreen = new LoginScreen("");
				loginScreen.setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon(LoggedInScreen.class.getResource("/resources/back_64.png")));
		btnBack.setBounds(51, 24, 151, 76);
		getContentPane().add(btnBack);
		
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnLogout.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnMyAcc.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAddFood.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		btnAddRes.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
	}
}
