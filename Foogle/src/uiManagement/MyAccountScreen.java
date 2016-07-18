package uiManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;

// BACK BUTONU IMAGE EKLENECEK, BAŞKA IMAGE YOK
// COMBO BOX OLAYI VE ONUN DATABASE CONNECTIONU 

public class MyAccountScreen extends JFrame {

	private JPanel contentPane;
	private String[] rests = new String[100]; // Bir adamın sahip olabileceği maximum restoran sayısını 100 varsayarak yapılmış bir liste
	private String[] foods = new String[100]; // Bu iki boyutlu olacak ve reste göre food verecek, combodan hangisi seçildiyse onun arrayi görüntülenecek.
	private String[] foods2 = new String[100]; 
	private JComboBox restaurantsBox = new JComboBox();
	private JList foodList = new JList();
	private JButton btnBack = new JButton("Back");
	private JPanel restaurants = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private JLabel lblRestaurant = new JLabel("Restaurant:");
	private JLabel lblFood = new JLabel("Food:");
	private static String username;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyAccountScreen frame = new MyAccountScreen(username);
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
	public MyAccountScreen(String username) {
		
		this.username = username;
		rests[0] = "THE BEST REST";
		rests[1] = "REST 2";
		rests[2] = "REST 3";
		
		foods[0] = "DELİCİOUS";
		foods[1] = "Salty";
		
		foods2[0] = "Good Meal";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("My Account");
		setBounds(200, 200, 1440, 800);
		
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(250, 240, 230));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
				
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LoggedInScreen loggedInScreen = new LoggedInScreen(username);
				loggedInScreen.setVisible(true);
				dispose();
			}
		});
				
		restaurants.setBackground(new Color(250, 240, 230));
		
		JLabel lblHi = new JLabel("Hi " + username + "!");
		lblHi.setFont(new Font("Lucida Grande", Font.PLAIN, 25));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(54)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addGap(101)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblHi)
						.addComponent(restaurants, GroupLayout.PREFERRED_SIZE, 921, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(209, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHi))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(restaurants, GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
					.addContainerGap())
		);
	
		restaurantsBox.setModel(new DefaultComboBoxModel(rests));
				
		GroupLayout gl_restaurants = new GroupLayout(restaurants);
		gl_restaurants.setHorizontalGroup(
			gl_restaurants.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_restaurants.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_restaurants.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblRestaurant, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFood, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_restaurants.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 708, GroupLayout.PREFERRED_SIZE)
						.addComponent(restaurantsBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		gl_restaurants.setVerticalGroup(
			gl_restaurants.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_restaurants.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_restaurants.createParallelGroup(Alignment.BASELINE)
						.addComponent(restaurantsBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRestaurant))
					.addGap(18)
					.addGroup(gl_restaurants.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 538, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFood))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		
		foodList.setModel(new AbstractListModel() {
			String[] values = foods;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		scrollPane.setViewportView(foodList);

		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblRestaurant.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblFood.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		// btnBack.setIcon(new ImageIcon(LoginScreen.class.getResource("/resources/back_64.png")));
		
		restaurants.setLayout(gl_restaurants);
		contentPane.setLayout(gl_contentPane);

	}
}

