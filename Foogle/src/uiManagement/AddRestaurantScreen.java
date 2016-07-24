package uiManagement;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import userManagement.Admin;
import userManagement.RestaurantOwner;
import userManagement.UserResource;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AddRestaurantScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtRestaurantName;
	private JButton btnBack;
	private static String username;
	private JLabel lblRestaurantName;
	private JLabel labelIcon;
	private UserResource ur = UserResource.getSoleInstance();
	private  RestaurantOwner ro = new RestaurantOwner();
	public Admin admin = Admin.getSoleInstance();
	private JButton btnSubmit;
	
	
	
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
		createEvents();
	}
	
	public void initComponents() {
		ro = ur.getRestaurantOwner(username);
		setTitle("Foogle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setPreferredSize(new Dimension(1440,800));
	    getContentPane().add(contentPane, BorderLayout.SOUTH);
	    pack();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setResizable(false);
		
		txtRestaurantName = new JTextField();
		txtRestaurantName.setBounds(987, 237, 295, 52);
		txtRestaurantName.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setIcon(new ImageIcon(AddRestaurantScreen.class.getResource("/resources/login.png")));
		btnSubmit.setBounds(1089, 338, 193, 66);
		btnSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		btnBack = new JButton("Back");
		btnBack.setBounds(59, 43, 152, 76);
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnBack.setIcon(new ImageIcon(LoginScreen.class.getResource("/resources/back_64.png")));
		
		labelIcon = new JLabel("");
		labelIcon.setBounds(184, 161, 604, 477);
		labelIcon.setIcon(new ImageIcon(AddRestaurantScreen.class.getResource("/resources/table.png")));
		
		lblRestaurantName = new JLabel("Restaurant Name:");
		lblRestaurantName.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblRestaurantName.setBounds(787, 236, 199, 52);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(181)
							.addComponent(labelIcon)
							.addGap(95)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblRestaurantName)
									.addGap(6)
									.addComponent(txtRestaurantName, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnSubmit)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(239, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addComponent(btnBack)
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addComponent(labelIcon)
					.addGap(109))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(253)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtRestaurantName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRestaurantName))
					.addGap(105)
					.addComponent(btnSubmit)
					.addContainerGap(329, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void createEvents() {
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//check if the text field is leaved empty
				if(txtRestaurantName.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Please enter a name for restaurant!");
				else{
					System.out.println(ro.getUsername());
					String newRes = txtRestaurantName.getText();
					Restaurant resToAdd = new Restaurant(newRes);
					System.out.println(ro.getUsername());
					System.out.println(ro.getRestaurants().toString());
					
					// add the new restaurant to the pending list
					admin.addToPendingRestaurants(username, newRes);
					Restaurant newRestaurant = new Restaurant(newRes);
					newRestaurant.setConfirmed(false);
					admin.addToPendingRestaurants(newRestaurant);
					
					// go to logged in screen
					JOptionPane.showMessageDialog(null, "Your request to add a restaurant will be processed!");
					dispose();
					LoggedInScreen loggedInScreen = new LoggedInScreen(username);
					loggedInScreen.setVisible(true);	
				}
			
			}
		});
		
		//got to logged in screen
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoggedInScreen loggedInScreen = new LoggedInScreen(username);
				loggedInScreen.setVisible(true);
				dispose();
			}
		});
		
	}

}
