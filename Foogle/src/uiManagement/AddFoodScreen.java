package uiManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;

import dataManagement.OtherIngredientProcessor;
import restaurantAndFoodManagement.Food;
import restaurantAndFoodManagement.Ingredient;
import restaurantAndFoodManagement.Restaurant;
import userManagement.Admin;
import userManagement.RestaurantOwner;
import userManagement.UserResource;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class AddFoodScreen extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxForRestaurant;
	public UserResource uR = UserResource.getSoleInstance();
	public RestaurantOwner restOwner = new RestaurantOwner();
	public OtherIngredientProcessor processor = new OtherIngredientProcessor();
	public Admin admin = Admin.getSoleInstance();
	
	public String foodName;
	public String foodCuisine;
	public String foodOtherIngredients;
	public double foodPrice;
	public String foodType;
	
	public ArrayList<Object> existingFoodIngredientsObject = new ArrayList<Object>();
	public ArrayList<Object> foodRestaurantsObject = new ArrayList<Object>();
	public ArrayList<Ingredient> otherIngredientsSelected = new ArrayList<Ingredient>();
	public ArrayList<Ingredient> allIngredientsForFood = new ArrayList<Ingredient>();
	public ArrayList<Food> pendingFoods = new ArrayList<Food>();
	
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
	private JTextField textFieldFoodName;
	private JComboBox comboBoxForIngredients;
	private JCheckBox checkBoxForAddIngredient;
	private JLabel lblInfoIngredient;
	private JFormattedTextField formattedTextField;
	private JCheckBox checkBoxForAddToRest;
	private JButton btnBack;
	private JRadioButton btnFarEastern;
	private JRadioButton btnFrench;
	private JRadioButton btnRussian;
	private JRadioButton btnOther;
	private JButton btnComplete;
	private final ButtonGroup buttonGroupCuisine = new ButtonGroup();
	private final ButtonGroup buttonGroupType = new ButtonGroup();
	private JRadioButton btnTurkish;
	private JLabel label_3;

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
		setTitle("Foogle");
		restOwner = uR.getRestaurantOwner(username);
		restOwner.setRestaurants(restOwner.getAllRestaurantsOfARestaurantOwner(username));
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
		buttonGroupType.add(btnMeal);
		
		btnDessert = new JRadioButton("Dessert");
		buttonGroupType.add(btnDessert);
		
		btnBeverage = new JRadioButton("Beverage");
		buttonGroupType.add(btnBeverage);
		
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
		
		comboBoxForIngredients = new JComboBox();

		//add all ingredients to the combo box for the selection of ingredients of the new food
		DefaultComboBoxModel comboBoxModelIngredient = (DefaultComboBoxModel) comboBoxForIngredients.getModel();
		
		for(int i=0;i<uR.getAllIngredients().size();i++)
			comboBoxModelIngredient.addElement(uR.getAllIngredients().get(i).getName());
		
		checkBoxForAddIngredient = new JCheckBox("Add this ingredient to the new food");
		
		lblInfoIngredient = new JLabel("Please select the ingredients you want to add your new food");
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AddFoodScreen.class.getResource("/resources/french-fries.png")));
		GroupLayout gl_ingredientPanel = new GroupLayout(ingredientPanel);
		gl_ingredientPanel.setHorizontalGroup(
			gl_ingredientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ingredientPanel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_ingredientPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(checkBoxForAddIngredient)
						.addGroup(gl_ingredientPanel.createSequentialGroup()
							.addComponent(comboBoxForIngredients, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
							.addGap(49)
							.addComponent(lblNewLabel_1))
						.addComponent(lblInfoIngredient, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_ingredientPanel.setVerticalGroup(
			gl_ingredientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ingredientPanel.createSequentialGroup()
					.addGap(37)
					.addComponent(lblInfoIngredient)
					.addGap(34)
					.addGroup(gl_ingredientPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxForIngredients, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(checkBoxForAddIngredient)
					.addContainerGap(83, Short.MAX_VALUE))
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
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AddFoodScreen.class.getResource("/resources/doughnut.png")));
		GroupLayout gl_otherIngredientPanel = new GroupLayout(otherIngredientPanel);
		gl_otherIngredientPanel.setHorizontalGroup(
			gl_otherIngredientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_otherIngredientPanel.createSequentialGroup()
					.addGroup(gl_otherIngredientPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_otherIngredientPanel.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_otherIngredientPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textFieldOtherIng, Alignment.LEADING)
								.addComponent(lblInfoOtherIng, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)))
						.addGroup(gl_otherIngredientPanel.createSequentialGroup()
							.addGap(56)
							.addComponent(label_1)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_otherIngredientPanel.setVerticalGroup(
			gl_otherIngredientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_otherIngredientPanel.createSequentialGroup()
					.addGap(22)
					.addComponent(lblInfoOtherIng, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(textFieldOtherIng, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(label_1)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		otherIngredientPanel.setLayout(gl_otherIngredientPanel);
		
		btnComplete = new JButton("Add");
		btnComplete.setIcon(new ImageIcon(AddFoodScreen.class.getResource("/resources/dish.png")));
		btnComplete.setFont(new Font("Lucida Grande", Font.PLAIN, 20));

		
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Double.class);
	    formatter.setMinimum(0.0);
	    formatter.setMaximum(Double.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    // If you want the value to be committed on each keystroke instead of focus lost
	    formatter.setCommitsOnValidEdit(true);
		formattedTextField = new JFormattedTextField(formatter);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddFoodScreen.class.getResource("/resources/price-tag.png")));
		
		GroupLayout gl_foodPricePanel = new GroupLayout(foodPricePanel);
		gl_foodPricePanel.setHorizontalGroup(
			gl_foodPricePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_foodPricePanel.createSequentialGroup()
					.addGap(29)
					.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addGap(71)
					.addComponent(label)
					.addContainerGap(76, Short.MAX_VALUE))
		);
		gl_foodPricePanel.setVerticalGroup(
			gl_foodPricePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_foodPricePanel.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_foodPricePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		foodPricePanel.setLayout(gl_foodPricePanel);
		
		textFieldFoodName = new JTextField();
		textFieldFoodName.setColumns(10);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(AddFoodScreen.class.getResource("/resources/lemonade.png")));
		GroupLayout gl_foodNamePanel = new GroupLayout(foodNamePanel);
		gl_foodNamePanel.setHorizontalGroup(
			gl_foodNamePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_foodNamePanel.createSequentialGroup()
					.addGap(39)
					.addComponent(textFieldFoodName, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
					.addComponent(label_2)
					.addGap(53))
		);
		gl_foodNamePanel.setVerticalGroup(
			gl_foodNamePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_foodNamePanel.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_foodNamePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldFoodName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		foodNamePanel.setLayout(gl_foodNamePanel);
		
		JLabel lblicon = new JLabel("");
		lblicon.setIcon(new ImageIcon(AddFoodScreen.class.getResource("/resources/meat.png")));
		GroupLayout gl_foodTypePanel = new GroupLayout(foodTypePanel);
		gl_foodTypePanel.setHorizontalGroup(
			gl_foodTypePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_foodTypePanel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_foodTypePanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_foodTypePanel.createSequentialGroup()
							.addComponent(lblInfoType, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
							.addGap(30))
						.addGroup(gl_foodTypePanel.createSequentialGroup()
							.addGroup(gl_foodTypePanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDessert)
								.addComponent(btnBeverage, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnMeal))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblicon, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
							.addGap(38))))
		);
		gl_foodTypePanel.setVerticalGroup(
			gl_foodTypePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_foodTypePanel.createSequentialGroup()
					.addGap(55)
					.addComponent(lblInfoType)
					.addGap(18)
					.addGroup(gl_foodTypePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_foodTypePanel.createSequentialGroup()
							.addComponent(btnMeal)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDessert)
							.addGap(12)
							.addComponent(btnBeverage))
						.addComponent(lblicon, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addGap(33))
		);
		foodTypePanel.setLayout(gl_foodTypePanel);
		
		//add all restaurants of a restaurant owner to the combo box for the selection of restaurants of the new food
		comboBoxForRestaurant = new JComboBox();
		DefaultComboBoxModel comboBoxModelRestaurant = (DefaultComboBoxModel) comboBoxForRestaurant.getModel();
		
		for(int i=0;i<restOwner.getAllRestaurantsOfARestaurantOwner(username).size();i++)
			comboBoxModelRestaurant.addElement(restOwner.getAllRestaurantsOfARestaurantOwner(username).get(i).getName());
		
		lblInfoRest = new JLabel("Please select the restaurants for the new food to be added");
		
		checkBoxForAddToRest = new JCheckBox("Add the new food to this restaurant");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddFoodScreen.class.getResource("/resources/cooker.png")));

		GroupLayout gl_restSelectionpanel = new GroupLayout(restSelectionpanel);
		gl_restSelectionpanel.setHorizontalGroup(
			gl_restSelectionpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_restSelectionpanel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_restSelectionpanel.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxForRestaurant, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_restSelectionpanel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_restSelectionpanel.createSequentialGroup()
								.addComponent(checkBoxForAddToRest)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel))
							.addComponent(lblInfoRest, Alignment.LEADING)))
					.addGap(25))
		);
		gl_restSelectionpanel.setVerticalGroup(
			gl_restSelectionpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_restSelectionpanel.createSequentialGroup()
					.addGap(38)
					.addComponent(lblInfoRest)
					.addGroup(gl_restSelectionpanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_restSelectionpanel.createSequentialGroup()
							.addGap(30)
							.addComponent(comboBoxForRestaurant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(checkBoxForAddToRest)
							.addGap(117))
						.addGroup(Alignment.TRAILING, gl_restSelectionpanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel)
							.addGap(56))))
		);
		restSelectionpanel.setLayout(gl_restSelectionpanel);
		
		btnBack = new JButton("Back");

		btnBack.setIcon(new ImageIcon(AddFoodScreen.class.getResource("/resources/back_64.png")));
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		
		JPanel foodCuisinePanel = new JPanel();
		foodCuisinePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Food Cuisine", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		foodCuisinePanel.setBackground(new Color(250, 240, 230));
		
		JTextArea txtrPleaseSelectOne = new JTextArea();
		txtrPleaseSelectOne.setText("Please select one of the cuisines below for your new food\n");
		txtrPleaseSelectOne.setLineWrap(true);
		txtrPleaseSelectOne.setEditable(false);
		txtrPleaseSelectOne.setBackground(new Color(250, 240, 230));
		
		btnTurkish = new JRadioButton("Turkish");
		buttonGroupCuisine.add(btnTurkish);
		
		btnFarEastern = new JRadioButton("Far Eastern");
		buttonGroupCuisine.add(btnFarEastern);
		
		btnFrench = new JRadioButton("French");
		buttonGroupCuisine.add(btnFrench);
		
		btnRussian = new JRadioButton("Russian");
		buttonGroupCuisine.add(btnRussian);
		
		btnOther = new JRadioButton("Other");
		buttonGroupCuisine.add(btnOther);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(AddFoodScreen.class.getResource("/resources/pizza.png")));
		GroupLayout gl_foodCuisinePanel = new GroupLayout(foodCuisinePanel);
		gl_foodCuisinePanel.setHorizontalGroup(
			gl_foodCuisinePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_foodCuisinePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtrPleaseSelectOne, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
				.addGroup(gl_foodCuisinePanel.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_foodCuisinePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFarEastern)
						.addGroup(gl_foodCuisinePanel.createParallelGroup(Alignment.LEADING)
							.addComponent(btnTurkish)
							.addComponent(btnFrench)
							.addComponent(btnRussian)
							.addComponent(btnOther)))
					.addPreferredGap(ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2)
					.addGap(79))
		);
		gl_foodCuisinePanel.setVerticalGroup(
			gl_foodCuisinePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_foodCuisinePanel.createSequentialGroup()
					.addComponent(txtrPleaseSelectOne, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_foodCuisinePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_foodCuisinePanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnTurkish)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnFarEastern)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnFrench)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRussian)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnOther)
							.addGap(15))
						.addGroup(gl_foodCuisinePanel.createSequentialGroup()
							.addGap(52)
							.addComponent(lblNewLabel_2)
							.addContainerGap())))
		);
		foodCuisinePanel.setLayout(gl_foodCuisinePanel);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(AddFoodScreen.class.getResource("/resources/groceries.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(48)
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(69)
							.addComponent(label_3)))
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(foodPricePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(foodNamePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(foodTypePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(restSelectionpanel, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(ingredientPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(otherIngredientPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(72)
							.addComponent(btnComplete, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addComponent(foodCuisinePanel, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE))
					.addGap(35))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(ingredientPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(otherIngredientPanel, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(foodCuisinePanel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(label_3))
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
											.addComponent(foodNamePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(foodTypePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(6)
									.addComponent(foodPricePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(restSelectionpanel, 0, 0, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(326)
							.addComponent(btnComplete)))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}

	//object list from the user desires to ingredient list 	
	private ArrayList<Ingredient> sendIngList(ArrayList<Object> ingredientList) {
		
		ArrayList<Ingredient> ingListToSend = new ArrayList<Ingredient>();
		for(int i=0;i<ingredientList.size();i++){
			ingListToSend.add(new Ingredient(ingredientList.get(i).toString()));
		}
		
		return ingListToSend;
		
	}
	
	//object list from the user desires to ingredient list 	
	private ArrayList<Restaurant> sendRestList(ArrayList<Object> restList) {
		
		ArrayList<Restaurant> restListToSend = new ArrayList<Restaurant>();
		for(int i=0;i<restList.size();i++){
			Restaurant newRest = new Restaurant();
			newRest.setName(restList.get(i).toString());
			restListToSend.add(newRest);
		}
		
		return restListToSend;
		
	}
	
	private void createEvents() {
		btnBack.addActionListener(new ActionListener() {
			
			//go to logged in screen
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoggedInScreen loggedInScreen= new LoggedInScreen(username);
				loggedInScreen.setVisible(true);
				
			}
		});
		
		checkBoxForAddIngredient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object selected = comboBoxForIngredients.getSelectedItem();
				
				//add food to the food array list if it is not added before
				if(checkBoxForAddIngredient.isSelected() && !existingFoodIngredientsObject.contains(selected)){
					existingFoodIngredientsObject.add(selected);
				}
				
				//remove food from food array list if it is added before
				if(!checkBoxForAddIngredient.isSelected() && existingFoodIngredientsObject.contains(selected)){
					existingFoodIngredientsObject.remove(selected);
				}
			}
		});
		
		checkBoxForAddToRest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object selected = comboBoxForRestaurant.getSelectedItem();
				
				//add restaurant to restaurant array list if it is not added before
				if(checkBoxForAddToRest.isSelected() && !foodRestaurantsObject.contains(selected)){
					foodRestaurantsObject.add(selected);
				}
				//remove restaurant from the restaurant array list if it is added before
				if(!checkBoxForAddToRest.isSelected() && foodRestaurantsObject.contains(selected)){
					foodRestaurantsObject.remove(selected);
				}
			}
		});
		
		
		
		btnComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				//make the object arraylist , an ingredient array list = EXISTING INGREDIENT SELECTED
				ArrayList<Ingredient> existingFoodIngredientsIng= new ArrayList<Ingredient>(); 
				existingFoodIngredientsIng = sendIngList(existingFoodIngredientsObject);
				/*for(int i=0;i<existingFoodIngredientsIng.size();i++){
					System.out.println(existingFoodIngredientsIng .get(i).getName());
				}*/
				
				//make the object arraylist , an restaurant array list foodRestaurantsRest= SELECTED RESTAURANTS
				ArrayList<Restaurant> foodRestaurantsRest= new ArrayList<Restaurant>(); 
				foodRestaurantsRest = sendRestList(foodRestaurantsObject);
				/*for(int i=0;i<foodRestaurantsRest.size();i++){
					System.out.println(foodRestaurantsRest.get(i).getName());
				}*/
				
				admin.addToRestsForCorrFoods(foodRestaurantsRest);
				//otherIngredientsSelected = EXTRA INGREDIENTS,  existingFoodIngredientsIng = EXISTING INGREDIENT SELECTED
				foodOtherIngredients = textFieldOtherIng.getText();
				
				
				otherIngredientsSelected = processor.insertToPending(foodOtherIngredients);
				/*System.out.println("Other Ingredients for new food");
				System.out.println(otherIngredientsSelected.toString());*/
				
				
				//set price of food
				if(formattedTextField.getText() != null && !formattedTextField.getText().equals(""))
					foodPrice = Double.parseDouble(formattedTextField.getText());
				
				//set name of food
				foodName = textFieldFoodName.getText();
				
				//set type of food
				if(btnMeal.isSelected())
					foodType = "meal";
				else if(btnDessert.isSelected())
					foodType = "dessert";
				else
					foodType = "beverage";
				
				//set cuisine of food
				if(btnTurkish.isSelected())
					foodCuisine = "Turkish";
				else if(btnFarEastern.isSelected())
					foodCuisine = "Far Eastern";
				else if(btnFrench.isSelected())
					foodCuisine = "French";
				else if(btnRussian.isSelected())
					foodCuisine = "Russian";
				else
					foodCuisine = "Other";
				
				allIngredientsForFood = restOwner.mergeLists(existingFoodIngredientsIng, otherIngredientsSelected);
				
				//if one of the required fields are leaved empty give warning message
				if(textFieldFoodName.getText().equals("") || formattedTextField.getText().equals("") || 
						(!btnMeal.isSelected() && !btnDessert.isSelected() && !btnBeverage.isSelected()) ||
						(!btnTurkish.isSelected() && !btnFarEastern.isSelected() && !btnRussian.isSelected() && !btnFrench.isSelected() && !btnOther.isSelected()) ||
						allIngredientsForFood.isEmpty())
					JOptionPane.showMessageDialog(null, "Please check if you fill all blanks!");
				else{
					//set all ingredients (other and existing) included in food 
					Food newFood = new Food(foodName,foodCuisine,foodType,foodPrice,allIngredientsForFood);
					pendingFoods.add(newFood);
					//System.out.println("***"+restOwner.getAllRestaurantsOfARestaurantOwner(username).toString());

					//add a food to multiple restaurants
					admin.addToPendingFoods(newFood);
					for(int i=0;i<allIngredientsForFood.size();i++)
						admin.addToPendingIngredients(new Ingredient(allIngredientsForFood.get(i).getName()), foodName);
					
					//go to logged in screen
					JOptionPane.showMessageDialog(null, "Thanks! Your request will be evaluated!");
					dispose();
					LoggedInScreen loggedInScreen = new LoggedInScreen(username);
					loggedInScreen.setVisible(true);
				}
			}
		});
		
		comboBoxForIngredients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBoxForAddIngredient.setSelected(false);
			}
		});
		
		comboBoxForRestaurant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBoxForAddToRest.setSelected(false);
			}
		});
	}
}
