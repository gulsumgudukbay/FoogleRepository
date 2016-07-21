package uiManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import restaurantAndFoodManagement.Ingredient;
import restaurantAndFoodManagement.Restaurant;
import userManagement.Admin;
import userManagement.RestaurantOwner;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AdminScreen2 extends JFrame {

	private JPanel contentPane;
	public static String username;
	private JPanel restaurantPanel;
	private JComboBox comboBoxRestaurant;
	private JPanel ingredientPanel;
	private JComboBox comboBoxIngredient;
	private JButton btnSubmit;
	public Admin admin = Admin.getSoleInstance();
	private JCheckBox checkBoxIng;
	private JCheckBox checkBoxRest;
	public ArrayList<Ingredient> pendingIngredients = new ArrayList<Ingredient>();
	public ArrayList<Restaurant> pendingRestaurants = new ArrayList<Restaurant>();
	public ArrayList<ArrayList<Restaurant>> restsArr = new ArrayList<ArrayList<Restaurant>>();
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminScreen2 frame = new AdminScreen2(username);
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
	public AdminScreen2(String username) {

		this.username = username;
		initComponents();
		createEvents();
		
	}

	private void initComponents() {
		
		pendingIngredients = admin.getAllPendingIngredients();
		pendingRestaurants = admin.getAllPendingRestaurants();
		
		
		setTitle("Foogle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setPreferredSize(new Dimension(1440,800));
	    getContentPane().add(contentPane, BorderLayout.SOUTH);
	    pack();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ingredientPanel = new JPanel();
		ingredientPanel.setBackground(new Color(250, 240, 230));
		ingredientPanel.setBorder(new TitledBorder(null, "Ingredients", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		restaurantPanel = new JPanel();
		restaurantPanel.setBackground(new Color(250, 240, 230));
		restaurantPanel.setBorder(new TitledBorder(null, "Restaurants", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setIcon(new ImageIcon(AdminScreen2.class.getResource("/resources/login.png")));

		btnSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(AdminScreen2.class.getResource("/resources/restaurant-cutlery-circular-symbol-of-a-spoon-and-a-fork-in-a-circle.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addComponent(label_2)
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(restaurantPanel, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)
						.addComponent(ingredientPanel, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE))
					.addGap(64)
					.addComponent(btnSubmit)
					.addGap(249))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(97)
					.addComponent(label_2)
					.addContainerGap(311, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(481, Short.MAX_VALUE)
					.addComponent(btnSubmit)
					.addGap(382))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(194, Short.MAX_VALUE)
					.addComponent(ingredientPanel, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(restaurantPanel, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
					.addGap(81))
		);
		
		comboBoxRestaurant = new JComboBox();
		
		DefaultComboBoxModel comboBoxModelRestaurant = (DefaultComboBoxModel) comboBoxRestaurant.getModel();
		
		for(int i=0;i<admin.getAllPendingRestaurants().size();i++)
			comboBoxModelRestaurant.addElement(admin.getAllPendingRestaurants().get(i).getName());
		
		checkBoxRest = new JCheckBox("Check the box if you want to accept the restaurant\n");
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(AdminScreen2.class.getResource("/resources/shop.png")));
		GroupLayout gl_restaurantPanel = new GroupLayout(restaurantPanel);
		gl_restaurantPanel.setHorizontalGroup(
			gl_restaurantPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_restaurantPanel.createSequentialGroup()
					.addContainerGap(194, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(177))
				.addGroup(gl_restaurantPanel.createSequentialGroup()
					.addGap(49)
					.addComponent(comboBoxRestaurant, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(57, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_restaurantPanel.createSequentialGroup()
					.addContainerGap(27, Short.MAX_VALUE)
					.addComponent(checkBoxRest, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
					.addGap(39))
		);
		gl_restaurantPanel.setVerticalGroup(
			gl_restaurantPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_restaurantPanel.createSequentialGroup()
					.addGap(35)
					.addComponent(comboBoxRestaurant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
					.addComponent(checkBoxRest)
					.addGap(18)
					.addComponent(label)
					.addGap(20))
		);
		restaurantPanel.setLayout(gl_restaurantPanel);
		
		comboBoxIngredient = new JComboBox();
		
		DefaultComboBoxModel comboBoxModelIngredient = (DefaultComboBoxModel) comboBoxIngredient.getModel();
		
		for(int i=0;i<admin.getAllPendingIngredients().size();i++)
			comboBoxModelIngredient.addElement(admin.getAllPendingIngredients().get(i).getName());
		
		checkBoxIng = new JCheckBox("Check the box if you want to accept the ingredient");
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AdminScreen2.class.getResource("/resources/hamburguer.png")));

		GroupLayout gl_ingredientPanel = new GroupLayout(ingredientPanel);
		gl_ingredientPanel.setHorizontalGroup(
			gl_ingredientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ingredientPanel.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_ingredientPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(checkBoxIng)
						.addComponent(comboBoxIngredient, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(36, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_ingredientPanel.createSequentialGroup()
					.addContainerGap(186, Short.MAX_VALUE)
					.addComponent(label_1)
					.addGap(185))
		);
		gl_ingredientPanel.setVerticalGroup(
			gl_ingredientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ingredientPanel.createSequentialGroup()
					.addGap(38)
					.addComponent(comboBoxIngredient, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(94)
					.addComponent(checkBoxIng)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(label_1)
					.addGap(25))
		);
		ingredientPanel.setLayout(gl_ingredientPanel);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	private Ingredient searchIngredient(String ingName){
		for(int i=0;i< pendingIngredients.size();i++)
			if(pendingIngredients.get(i).getName().equals(ingName))
				return pendingIngredients.get(i);
		return null;
	}
	
	private Restaurant searchRestaurant(String restName){
		for(int i=0;i< pendingRestaurants.size();i++)
			if(pendingRestaurants.get(i).getName().equals(restName))
				return pendingRestaurants.get(i);
		return null;
	}
	
	private void createEvents() {
		
		checkBoxIng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = comboBoxIngredient.getSelectedItem();
				String strSelected = selected.toString();
				Ingredient newIng = new Ingredient(strSelected);
				if(checkBoxIng.isSelected()){
					admin.confirmIngredient(strSelected);
					newIng = searchIngredient(strSelected);
					newIng.setConfirmed(true);
					
				}
				else{
					admin.rejectIngredient(strSelected);
					newIng = searchIngredient(strSelected);
					newIng.setConfirmed(false);
				}
					
			}
		});
		
		checkBoxRest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = comboBoxRestaurant.getSelectedItem();
				String strSelected = selected.toString();
				Restaurant newRest = new Restaurant(strSelected);
				if(checkBoxRest.isSelected()){
					admin.confirmRestaurant(strSelected);
					newRest = searchRestaurant(strSelected);
					newRest.setConfirmed(true);
				}
					
				else{
					admin.rejectRestaurant(strSelected);
					newRest = searchRestaurant(strSelected);
					newRest.setConfirmed(false);
				}
					
			}
		});
		
		comboBoxIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBoxIng.setSelected(false);
			}
		});
		
		comboBoxRestaurant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBoxRest.setSelected(false);
			}
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestaurantOwner ro  = new RestaurantOwner();
				ro.setUsername(username);
				if(admin.isAllIngredientsProcessed())
					admin.traverseAllFoods(ro);
				
				if(admin.isAllRestaurantsProcessed()){
					admin.traverseAllRestaurants(ro);
				}
				
				JOptionPane.showMessageDialog(null, "Your confirmation is updated!");
			}
		});
		
		
		
		
	}
}
