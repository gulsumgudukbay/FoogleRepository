package uiManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.text.NumberFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;

import userManagement.RestaurantOwner;
import userManagement.UserResource;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;

public class AddFoodScreen extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxForRestaurant;
	public UserResource uR = UserResource.getSoleInstance();
	public RestaurantOwner restOwner = new RestaurantOwner();
	private static String username;
	private JPanel foodTypePanel;
	private JPanel restSelectionpanel;
	private JLabel lblInfoRest;
	private JRadioButton btnMeal;
	private JRadioButton btnDessert;
	private JRadioButton btnBeverage;
	private JLabel lblInfoType;
	private JPanel foodNamePanel;
	private JPanel foodPricePanel;
	private JPanel ingredientPanel;
	private JTextArea lblInfoOtherIng;
	private JTextField textFieldOtherIng;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFoodScreen frame = new AddFoodScreen(username);
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
	public AddFoodScreen(String username) {
		this.username = username;
		initComponents();
		createEvents();
		
	
	}

	private void initComponents() {
		
		restOwner = uR.getRestaurantOwner(username);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setPreferredSize(new Dimension(1440,800));
	    getContentPane().add(contentPane, BorderLayout.SOUTH);
	    pack();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		restSelectionpanel = new JPanel();
		restSelectionpanel.setBackground(new Color(250, 240, 230));
		restSelectionpanel.setBorder(new TitledBorder(null, "Restaurants", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		foodTypePanel = new JPanel();
		foodTypePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Food Type", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		foodTypePanel.setBackground(new Color(250, 240, 230));
		
		btnMeal = new JRadioButton("Meal");
		
		btnDessert = new JRadioButton("Dessert");
		
		btnBeverage = new JRadioButton("Beverage");
		
		lblInfoType = new JLabel("Please select the one of the food types for your new food\n");
		
		foodNamePanel = new JPanel();
		foodNamePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Food Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		foodNamePanel.setBackground(new Color(250, 240, 230));
		
		foodPricePanel = new JPanel();
		foodPricePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Food Price", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		foodPricePanel.setBackground(new Color(250, 240, 230));
		
		ingredientPanel = new JPanel();
		ingredientPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Ingredients", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ingredientPanel.setBackground(new Color(250, 240, 230));
		
		JComboBox comboBoxForIngredients = new JComboBox();
		
		JCheckBox checkBoxForAddIngredient = new JCheckBox("Add this ingredient to the new food");
		
		JLabel lblInfoIngredient = new JLabel("Please select the ingredients you want to add your new food");
		GroupLayout gl_ingredientPanel = new GroupLayout(ingredientPanel);
		gl_ingredientPanel.setHorizontalGroup(
			gl_ingredientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ingredientPanel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_ingredientPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(checkBoxForAddIngredient)
						.addComponent(comboBoxForIngredients, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInfoIngredient, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_ingredientPanel.setVerticalGroup(
			gl_ingredientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ingredientPanel.createSequentialGroup()
					.addGap(37)
					.addComponent(lblInfoIngredient)
					.addGap(34)
					.addComponent(comboBoxForIngredients, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(checkBoxForAddIngredient)
					.addContainerGap(67, Short.MAX_VALUE))
		);
		ingredientPanel.setLayout(gl_ingredientPanel);
		
		JPanel otherIngredientPanel = new JPanel();
		otherIngredientPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Other Ingredients", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		otherIngredientPanel.setBackground(new Color(250, 240, 230));
		
		lblInfoOtherIng = new JTextArea();
		lblInfoOtherIng.setBackground(new Color(250, 240, 230));
		lblInfoOtherIng.setLineWrap(true);
		lblInfoOtherIng.setEditable(false);
		lblInfoOtherIng.setText("Please write the other ingredients which do not exist aboveas a space separated list");
		
		textFieldOtherIng = new JTextField();
		textFieldOtherIng.setColumns(10);
		GroupLayout gl_otherIngredientPanel = new GroupLayout(otherIngredientPanel);
		gl_otherIngredientPanel.setHorizontalGroup(
			gl_otherIngredientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_otherIngredientPanel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_otherIngredientPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textFieldOtherIng, Alignment.LEADING)
						.addComponent(lblInfoOtherIng, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_otherIngredientPanel.setVerticalGroup(
			gl_otherIngredientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_otherIngredientPanel.createSequentialGroup()
					.addGap(22)
					.addComponent(lblInfoOtherIng, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(textFieldOtherIng, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(111, Short.MAX_VALUE))
		);
		otherIngredientPanel.setLayout(gl_otherIngredientPanel);
		
		JButton btnComplete = new JButton("Add!1!1");
		btnComplete.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(Integer.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    // If you want the value to be committed on each keystroke instead of focus lost
	    formatter.setCommitsOnValidEdit(true);
		JFormattedTextField formattedTextField = new JFormattedTextField(formatter);
		
		GroupLayout gl_foodPricePanel = new GroupLayout(foodPricePanel);
		gl_foodPricePanel.setHorizontalGroup(
			gl_foodPricePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_foodPricePanel.createSequentialGroup()
					.addGap(29)
					.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(208, Short.MAX_VALUE))
		);
		gl_foodPricePanel.setVerticalGroup(
			gl_foodPricePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_foodPricePanel.createSequentialGroup()
					.addGap(16)
					.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		foodPricePanel.setLayout(gl_foodPricePanel);
		
		JTextArea textArea = new JTextArea();
		GroupLayout gl_foodNamePanel = new GroupLayout(foodNamePanel);
		gl_foodNamePanel.setHorizontalGroup(
			gl_foodNamePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_foodNamePanel.createSequentialGroup()
					.addGap(32)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(212, Short.MAX_VALUE))
		);
		gl_foodNamePanel.setVerticalGroup(
			gl_foodNamePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_foodNamePanel.createSequentialGroup()
					.addGap(18)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		foodNamePanel.setLayout(gl_foodNamePanel);
		GroupLayout gl_foodTypePanel = new GroupLayout(foodTypePanel);
		gl_foodTypePanel.setHorizontalGroup(
			gl_foodTypePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_foodTypePanel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_foodTypePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDessert)
						.addComponent(btnBeverage, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInfoType, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMeal))
					.addGap(30))
		);
		gl_foodTypePanel.setVerticalGroup(
			gl_foodTypePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_foodTypePanel.createSequentialGroup()
					.addGap(55)
					.addComponent(lblInfoType)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnMeal)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnDessert)
					.addGap(12)
					.addComponent(btnBeverage)
					.addGap(56))
		);
		foodTypePanel.setLayout(gl_foodTypePanel);
		
		comboBoxForRestaurant = new JComboBox();
		DefaultComboBoxModel comboBoxModelRestaurant = (DefaultComboBoxModel) comboBoxForRestaurant.getModel();
		
		for(int i=0;i<restOwner.getAllRestaurantsOfARestaurantOwner(username).size();i++)
			comboBoxModelRestaurant.addElement(restOwner.getAllRestaurantsOfARestaurantOwner(username).get(i).getName());
		
		lblInfoRest = new JLabel("Please select the restaurants for the new food to be added");
		
		JCheckBox chckbxAddTheNew = new JCheckBox("Add the new food to this restaurant");
		GroupLayout gl_restSelectionpanel = new GroupLayout(restSelectionpanel);
		gl_restSelectionpanel.setHorizontalGroup(
			gl_restSelectionpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_restSelectionpanel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_restSelectionpanel.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxAddTheNew)
						.addComponent(lblInfoRest)
						.addComponent(comboBoxForRestaurant, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
					.addGap(25))
		);
		gl_restSelectionpanel.setVerticalGroup(
			gl_restSelectionpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_restSelectionpanel.createSequentialGroup()
					.addGap(38)
					.addComponent(lblInfoRest)
					.addGap(30)
					.addComponent(comboBoxForRestaurant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(chckbxAddTheNew)
					.addGap(69))
		);
		restSelectionpanel.setLayout(gl_restSelectionpanel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(254)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(foodNamePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(foodTypePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(foodPricePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(restSelectionpanel, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(ingredientPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(otherIngredientPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnComplete))
					.addGap(128))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(foodNamePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(foodTypePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(foodPricePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(restSelectionpanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(ingredientPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(otherIngredientPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(56)
							.addComponent(btnComplete)))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	
	private void createEvents() {
		// TODO Auto-generated method stub
		
	}
}
