package uiManagement;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dataManagement.RestDB;

// IMAGE EKLENECEK
// OLUŞAN RESTORAN DATABASEE EKLENECEK

public class AddRestaurantScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtRestaurantName;
	private JButton btnBack;
	private static String username;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRestaurantScreen frame = new AddRestaurantScreen(username);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param username 
	 */
	public AddRestaurantScreen(String username) {
		this.username = username;
		initComponents();
	}
	
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Add a new restaurant");
		setBounds(200, 200, 1440, 800);
		
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(250, 240, 230));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRestaurantName = new JTextField();
		txtRestaurantName.setText("Enter Restaurant Name Here");
		txtRestaurantName.setBounds(362, 103, 295, 45);
		contentPane.add(txtRestaurantName);
		txtRestaurantName.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String newRes = txtRestaurantName.getText();
				RestDB rdb = RestDB.getSoleInstance();
				if(rdb.createRestaurant(newRes, LoginScreen.getUsername())){
					JOptionPane.showMessageDialog(null, "The new restaurant is successfully created!");
					dispose();
					LoggedInScreen loggedInScreen = new LoggedInScreen(username);
					loggedInScreen.setVisible(true);
					
				}
				else
					JOptionPane.showMessageDialog(null,"The restaurant name is invalid, please try again");
					
			}
		});
		
		btnSubmit.setBounds(540, 160, 117, 45);
		contentPane.add(btnSubmit);
		
		btnSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoggedInScreen loggedInScreen = new LoggedInScreen(username);
				loggedInScreen.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(59, 43, 145, 56);
		contentPane.add(btnBack);
		
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnBack.setIcon(new ImageIcon(LoginScreen.class.getResource("/resources/back_64.png")));
	}
}
