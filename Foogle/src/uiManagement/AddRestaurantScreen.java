package uiManagement;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dataManagement.RestDB;
import restaurantAndFoodManagement.Restaurant;
import userManagement.RestaurantOwner;
import userManagement.UserResource;

public class AddRestaurantScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtRestaurantName;
	private JButton btnBack;
	private static String username;
	private JLabel lblRestaurantName;
	private JLabel labelIcon;
	private UserResource ur = new UserResource();
	private final RestaurantOwner ro = ur.getRestaurantOwner(username);
	
	
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
		setBackground(new Color(253, 245, 230));
		this.username = username;
		initComponents();
	}
	
	
	public void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Foogle");
		setBounds(200, 200, 1440, 800);
		
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(250, 240, 230));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtRestaurantName = new JTextField();
		txtRestaurantName.setBounds(987, 237, 295, 52);
		contentPane.add(txtRestaurantName);
		txtRestaurantName.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setIcon(new ImageIcon(AddRestaurantScreen.class.getResource("/resources/login.png")));
		btnSubmit.setBounds(1089, 338, 193, 66);
		
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String newRes = txtRestaurantName.getText();
				Restaurant resToAdd = new Restaurant(newRes);
					
				ro.addRestaurant(resToAdd);
				JOptionPane.showMessageDialog(null, "The new restaurant is successfully created!");
				dispose();
				LoggedInScreen loggedInScreen = new LoggedInScreen(username);
				loggedInScreen.setVisible(true);				
			}
		});
		contentPane.add(btnSubmit);
		
		btnSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		btnBack = new JButton("Back");
		btnBack.setBounds(59, 43, 152, 76);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoggedInScreen loggedInScreen = new LoggedInScreen(username);
				loggedInScreen.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnBack);
		
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnBack.setIcon(new ImageIcon(LoginScreen.class.getResource("/resources/back_64.png")));
		
		lblRestaurantName = new JLabel("Restaurant Name:");
		lblRestaurantName.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblRestaurantName.setBounds(787, 236, 199, 52);
		contentPane.add(lblRestaurantName);
		
		labelIcon = new JLabel("");
		labelIcon.setBounds(184, 161, 604, 477);
		labelIcon.setIcon(new ImageIcon(AddRestaurantScreen.class.getResource("/resources/table.png")));
		contentPane.add(labelIcon);
	}
}
