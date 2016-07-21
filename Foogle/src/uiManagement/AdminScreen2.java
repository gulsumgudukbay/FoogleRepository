package uiManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;

import restaurantAndFoodManagement.Ingredient;
import restaurantAndFoodManagement.Restaurant;
import userManagement.Admin;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;

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

		btnSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(523, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(restaurantPanel, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)
						.addComponent(ingredientPanel, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE))
					.addGap(132)
					.addComponent(btnSubmit)
					.addGap(216))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(ingredientPanel, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(restaurantPanel, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(322)
							.addComponent(btnSubmit)))
					.addContainerGap(81, Short.MAX_VALUE))
		);
		
		comboBoxRestaurant = new JComboBox();
		
		DefaultComboBoxModel comboBoxModelRestaurant = (DefaultComboBoxModel) comboBoxRestaurant.getModel();
		
		for(int i=0;i<admin.getAllPendingRestaurants().size();i++)
			comboBoxModelRestaurant.addElement(admin.getAllPendingRestaurants().get(i).getName());
		
		checkBoxRest = new JCheckBox("Check the box if you want to accept the restaurant\n");
		GroupLayout gl_restaurantPanel = new GroupLayout(restaurantPanel);
		gl_restaurantPanel.setHorizontalGroup(
			gl_restaurantPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_restaurantPanel.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_restaurantPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(checkBoxRest, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxRestaurant, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_restaurantPanel.setVerticalGroup(
			gl_restaurantPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_restaurantPanel.createSequentialGroup()
					.addGap(35)
					.addComponent(comboBoxRestaurant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
					.addComponent(checkBoxRest)
					.addGap(102))
		);
		restaurantPanel.setLayout(gl_restaurantPanel);
		
		comboBoxIngredient = new JComboBox();
		
		DefaultComboBoxModel comboBoxModelIngredient = (DefaultComboBoxModel) comboBoxIngredient.getModel();
		
		for(int i=0;i<admin.getAllPendingIngredients().size();i++)
			comboBoxModelIngredient.addElement(admin.getAllPendingIngredients().get(i).getName());
		
		checkBoxIng = new JCheckBox("Check the box if you want to accept the ingredient");

		GroupLayout gl_ingredientPanel = new GroupLayout(ingredientPanel);
		gl_ingredientPanel.setHorizontalGroup(
			gl_ingredientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ingredientPanel.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_ingredientPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(checkBoxIng)
						.addComponent(comboBoxIngredient, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(58, Short.MAX_VALUE))
		);
		gl_ingredientPanel.setVerticalGroup(
			gl_ingredientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ingredientPanel.createSequentialGroup()
					.addGap(38)
					.addComponent(comboBoxIngredient, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(94)
					.addComponent(checkBoxIng)
					.addContainerGap(117, Short.MAX_VALUE))
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
				if(checkBoxIng.isSelected()){
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
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(admin.isAllIngredientsProcessed())
					admin.traverseAllFoods(username);
				
				if(admin.isAllRestaurantsProcessed())
					admin.traverseAllRestaurants(username);
			}
		});
		
		
	}
}
