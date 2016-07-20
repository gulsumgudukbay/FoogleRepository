package uiManagement;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import dataManagement.RestDB;
import restaurantAndFoodManagement.Food;
import restaurantAndFoodManagement.Ingredient;
import userManagement.UserResource;
public class MainMenu extends JFrame {

	private JPanel contentPane;
	private JButton loginButton;
	private JLabel lblMeal;
	private JLabel lblDessert;
	private JLabel lblBeverage;
	private JCheckBox checkBoxMeal;
	private JCheckBox checkBoxDessert;
	private JCheckBox checkBoxBeverage;
	private JButton btnSearch;
	private JButton CreateButton;
	private JPanel dessertpanel;
	private JPanel mealpanel;
	private JPanel beveragepanel;
	private JPanel ingpanel;
	
	private JComboBox comboBoxForMeal;
	private JRadioButton btnUnwantedMeal;
	private JRadioButton btnDontCareMeal;
	private JRadioButton btnWantedMeal;
	private JLabel lblSelectMeal;
	
	//Array lists for meal
	private ArrayList<Object> wantedIngredientsMeal;
	private ArrayList<Object> unwantedIngredientsMeal;
	
	//Array lists for dessert
	private ArrayList<Object> wantedIngredientsDessert;
	private ArrayList<Object> unwantedIngredientsDessert;
	
	//Array lists for beverage
	private ArrayList<Object> wantedIngredientsBeverage;
	private ArrayList<Ingredient> testlistBeverage;
	private ArrayList<Object> unwantedIngredientsBeverage;
	
	//Array list for all which is used by send method
	//private ArrayList<Ingredient> ingListToSend;
	
	private JButton btnOkMeal;
	private JLabel labelmealback;
	private JLabel lblSelectBeverage;
	private JComboBox comboBoxForBeverage;
	private JRadioButton btnWantedBeverage;
	private JRadioButton btnDontCareBeverage;
	private JRadioButton btnUnwantedBeverage;
	private JLabel lblbeverageback;
	
	private final ButtonGroup buttonGroupForMeal = new ButtonGroup();
	private final ButtonGroup buttonGroupForDessert = new ButtonGroup();
	private final ButtonGroup buttonGroupForBeverage = new ButtonGroup();
	private JRadioButton btnUnwantedDessert;
	private JRadioButton btnDontCareDessert;
	private JRadioButton btnWantedDessert;
	private JComboBox comboBoxForDessert;
	private JLabel lblSelectDessert;
	private JLabel lbldessertback;
	private JButton btnOkDessert;
	private JButton btnOkBeverage;
	
	//FOR SEARCH RESULTS
	
	private JButton btnFinish;
	public UserResource uR = new UserResource();
	
	////////////////////////////////////////////////////////////////
	// 					THE MEAL PART OF SEARCH					///
	//////////////////////////////////////////////////////////////
	DefaultListModel<Food> searchListMeal = new DefaultListModel<Food>();
	private JList lstResultMeals;
	private JScrollPane scrMeal;
	public ArrayList<Food> searchedFoodListMeal = new ArrayList<Food>();
	
	//CUISINE BASED LISTS OF MEAL
	public ArrayList<Food> searchedfoodListMealTurkish = new ArrayList<Food>();
	public ArrayList<Food> searchedfoodListMealFarEastern = new ArrayList<Food>();
	public ArrayList<Food> searchedfoodListMealFrench = new ArrayList<Food>();
	public ArrayList<Food> searchedfoodListMealRussian = new ArrayList<Food>();
	public ArrayList<Food> searchedfoodListMealOther = new ArrayList<Food>();
	
	////////////////////////////////////////////////////////////////
	// 					THE BEVERAGE PART OF SEARCH				///
	//////////////////////////////////////////////////////////////
	DefaultListModel<Food> searchListBeverage = new DefaultListModel<Food>();
	private JList lstResultBeverages;
	private JScrollPane scrBeverage;
	public ArrayList<Food> searchedFoodListBeverage = new ArrayList<Food>();
	
	//CUISINE BASED LISTS OF BEVERAGE
	public ArrayList<Food> searchedfoodListBeverageTurkish = new ArrayList<Food>();
	public ArrayList<Food> searchedfoodListBeverageFarEastern = new ArrayList<Food>();
	public ArrayList<Food> searchedfoodListBeverageFrench = new ArrayList<Food>();
	public ArrayList<Food> searchedfoodListBeverageRussian = new ArrayList<Food>();
	public ArrayList<Food> searchedfoodListBeverageOther = new ArrayList<Food>();
	
	////////////////////////////////////////////////////////////////
	// 					THE DESSERT PART OF SEARCH				///
	//////////////////////////////////////////////////////////////
	DefaultListModel<Food> searchListDessert = new DefaultListModel<Food>();
	private JList lstResultDesserts;
	private JScrollPane scrDessert;
	public ArrayList<Food> searchedFoodListDessert = new ArrayList<Food>();
	
	//CUISINE BASED LISTS OF DESSERT
	public ArrayList<Food> searchedfoodListDessertTurkish = new ArrayList<Food>();
	public ArrayList<Food> searchedfoodListDessertFarEastern = new ArrayList<Food>();
	public ArrayList<Food> searchedfoodListDessertFrench = new ArrayList<Food>();
	public ArrayList<Food> searchedfoodListDessertRussian = new ArrayList<Food>();
	public ArrayList<Food> searchedfoodListDessertOther = new ArrayList<Food>();	
	
	
	private static String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/resources/juice.png")));
		initComponents();
		createEvents();
	}
	
	////////////////////////////////////////////////////////////////
	// This method contains all of the code for creating and //////
	// initializing components.///////////////////////////////////
	/////////////////////////////////////////////////////////////
	private void initComponents() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Foogle");
		setBounds(200, 200, 750, 300);
		
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(1440,800));
	    getContentPane().add(contentPane, BorderLayout.NORTH);
	    pack();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		loginButton = new JButton("Login as a Restaurant Owner");
		loginButton.setBounds(1042, 51, 312, 41);
		
		
		lblMeal = new JLabel("Meal");
		lblMeal.setBounds(136, 157, 73, 32);
		lblMeal.setIcon(new ImageIcon(MainMenu.class.getResource("/resources/sandwich.png")));
		lblMeal.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblDessert = new JLabel("Dessert");
		lblDessert.setBounds(647, 157, 95, 32);
		lblDessert.setIcon(new ImageIcon(MainMenu.class.getResource("/resources/ice-cream.png")));
		lblDessert.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblBeverage = new JLabel("Beverage");
		lblBeverage.setBounds(1238, 157, 106, 32);
		lblBeverage.setIcon(new ImageIcon(MainMenu.class.getResource("/resources/cocktail.png")));
		lblBeverage.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		checkBoxMeal = new JCheckBox("");
		checkBoxMeal.setBounds(160, 195, 28, 23);
		
		checkBoxDessert = new JCheckBox("");
		checkBoxDessert.setBounds(677, 195, 28, 23);

		checkBoxBeverage = new JCheckBox("");
		checkBoxBeverage.setBounds(1299, 195, 28, 23);
		
		ingpanel = new JPanel();
		ingpanel.setBounds(136, 236, 1217, 437);
		ingpanel.setBackground(new Color(255, 255, 255));
		
		JLabel searchLogo = new JLabel("");
		searchLogo.setBounds(635, 17, 128, 128);
		searchLogo.setIcon(new ImageIcon(MainMenu.class.getResource("/resources/foodsearch.png")));
		 
		btnSearch = new JButton("Search");
		
		btnSearch.setBounds(1175, 691, 178, 87);
		btnSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnSearch.setIcon(new ImageIcon(MainMenu.class.getResource("/resources/plate-fork-and-knife.png")));
		
		CreateButton = new JButton("Create an Account as a Restaurant Owner");
		CreateButton.setBounds(1042, 98, 312, 41);
		
		
		JLabel lblFoogle = new JLabel("Foogle");
		lblFoogle.setBounds(630, 3, 112, 89);
		lblFoogle.setFont(new Font("SignPainter", Font.BOLD, 26));
		ingpanel.setLayout(null);
		
		mealpanel = new JPanel();
		mealpanel.setVisible(false);
		mealpanel.setBackground(Color.WHITE);
		mealpanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Meal Ingredients", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		mealpanel.setBounds(7, 17, 404, 414);
		ingpanel.add(mealpanel);
		
		lblSelectMeal = new JLabel("Select:");
		lblSelectMeal.setBounds(100, 117, 51, 20);
		lblSelectMeal.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		
		comboBoxForMeal = new JComboBox();
		comboBoxForMeal.setBounds(157, 112, 163, 32);
		comboBoxForMeal.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		
		
		btnDontCareMeal = new JRadioButton("It does not matter");
		btnDontCareMeal.setBounds(100, 199, 220, 25);
		btnDontCareMeal.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnDontCareMeal.setSelected(true);
		buttonGroupForMeal.add(btnDontCareMeal);
		
		btnWantedMeal = new JRadioButton("Add ! :)");
		btnWantedMeal.setBounds(100, 162, 220, 25);
		btnWantedMeal.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		buttonGroupForMeal.add(btnWantedMeal);
		
		btnUnwantedMeal = new JRadioButton("No, please :(");
		btnUnwantedMeal.setBounds(100, 236, 220, 25);
		btnUnwantedMeal.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		buttonGroupForMeal.add(btnUnwantedMeal);
		
		btnOkMeal = new JButton("OK!");
		
		btnOkMeal.setBounds(323, 379, 75, 29);
		mealpanel.setLayout(null);
		mealpanel.add(btnUnwantedMeal);
		mealpanel.add(btnDontCareMeal);
		mealpanel.add(btnWantedMeal);
		mealpanel.add(lblSelectMeal);
		mealpanel.add(comboBoxForMeal);
		mealpanel.add(btnOkMeal);
		
		labelmealback = new JLabel("");
		labelmealback.setIgnoreRepaint(true);
		labelmealback.setForeground(Color.WHITE);
		labelmealback.setIcon(new ImageIcon(MainMenu.class.getResource("/resources/foodformeal.png")));
		labelmealback.setBounds(60, 73, 273, 256);
		mealpanel.add(labelmealback);
		
		scrMeal = new JScrollPane();
		scrMeal.setBounds(6, 18, 392, 390);
		mealpanel.add(scrMeal);
		scrMeal.setVisible(false);
		
		lstResultMeals = new JList(searchListMeal);
		scrMeal.setViewportView(lstResultMeals);
		
		dessertpanel = new JPanel();
		dessertpanel.setVisible(false);
		dessertpanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Dessert Ingredients", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		dessertpanel.setBackground(Color.WHITE);
		dessertpanel.setBounds(414, 17, 398, 414);
		ingpanel.add(dessertpanel);
		dessertpanel.setLayout(null);
		
		btnUnwantedDessert = new JRadioButton("No, please :(");
		buttonGroupForDessert.add(btnUnwantedDessert);
		btnUnwantedDessert.setBounds(90, 238, 220, 25);
		btnUnwantedDessert.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		dessertpanel.add(btnUnwantedDessert);
		
		btnDontCareDessert = new JRadioButton("It does not matter");
		buttonGroupForDessert.add(btnDontCareDessert);
		btnDontCareDessert.setBounds(90, 201, 220, 25);
		btnDontCareDessert.setSelected(true);
		btnDontCareDessert.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		dessertpanel.add(btnDontCareDessert);
		
		btnWantedDessert = new JRadioButton("Add ! :)");
		buttonGroupForDessert.add(btnWantedDessert);
		btnWantedDessert.setBounds(90, 164, 220, 25);
		btnWantedDessert.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		dessertpanel.add(btnWantedDessert);
		
		comboBoxForDessert = new JComboBox();
		comboBoxForDessert.setBounds(147, 114, 163, 32);
		comboBoxForDessert.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		dessertpanel.add(comboBoxForDessert);
		
		lblSelectDessert = new JLabel("Select:");
		lblSelectDessert.setBounds(90, 119, 51, 20);
		lblSelectDessert.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		dessertpanel.add(lblSelectDessert);
		
		lbldessertback = new JLabel("");
		lbldessertback.setIcon(new ImageIcon(MainMenu.class.getResource("/resources/donut.png")));
		lbldessertback.setBounds(62, 71, 276, 256);
		dessertpanel.add(lbldessertback);
		
		btnOkDessert = new JButton("OK!");
		btnOkDessert.setBounds(317, 379, 75, 29);
		dessertpanel.add(btnOkDessert);
		
		scrDessert = new JScrollPane();
		scrDessert.setBounds(6, 19, 386, 389);
		dessertpanel.add(scrDessert);
		
		lstResultDesserts = new JList(searchListDessert);
		scrDessert.setViewportView(lstResultDesserts);
		
		beveragepanel = new JPanel();
		beveragepanel.setVisible(false);
		beveragepanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Beverage Ingredients", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		beveragepanel.setBackground(Color.WHITE);
		beveragepanel.setBounds(813, 17, 398, 414);
		ingpanel.add(beveragepanel);
		beveragepanel.setLayout(null);
		
		lblSelectBeverage = new JLabel("Select:");
		lblSelectBeverage.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblSelectBeverage.setBounds(116, 118, 51, 20);
		beveragepanel.add(lblSelectBeverage);
		
		comboBoxForBeverage = new JComboBox();
		comboBoxForBeverage.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		comboBoxForBeverage.setBounds(173, 113, 163, 32);
		beveragepanel.add(comboBoxForBeverage);
		
		btnWantedBeverage = new JRadioButton("Add ! :)");
		buttonGroupForBeverage.add(btnWantedBeverage);
		btnWantedBeverage.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnWantedBeverage.setBounds(116, 163, 220, 25);
		beveragepanel.add(btnWantedBeverage);
		
		btnDontCareBeverage = new JRadioButton("It does not matter");
		buttonGroupForBeverage.add(btnDontCareBeverage);
		btnDontCareBeverage.setSelected(true);
		btnDontCareBeverage.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnDontCareBeverage.setBounds(116, 200, 220, 25);
		beveragepanel.add(btnDontCareBeverage);
		
		btnUnwantedBeverage = new JRadioButton("No, please :(");
		buttonGroupForBeverage.add(btnUnwantedBeverage);
		btnUnwantedBeverage.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnUnwantedBeverage.setBounds(116, 237, 220, 25);
		beveragepanel.add(btnUnwantedBeverage);
		
		lblbeverageback = new JLabel("");
		lblbeverageback.setIcon(new ImageIcon(MainMenu.class.getResource("/resources/coffee.png")));
		lblbeverageback.setBounds(87, 70, 273, 256);
		beveragepanel.add(lblbeverageback);
		
		btnOkBeverage = new JButton("OK!");
		btnOkBeverage.setBounds(317, 379, 75, 29);
		beveragepanel.add(btnOkBeverage);
		
		scrBeverage = new JScrollPane();
		scrBeverage.setBounds(6, 19, 386, 389);
		beveragepanel.add(scrBeverage);
		
		lstResultBeverages = new JList(searchListBeverage);
		scrBeverage.setViewportView(lstResultBeverages);
		contentPane.setLayout(null);
		contentPane.add(lblMeal);
		contentPane.add(checkBoxMeal);
		contentPane.add(checkBoxDessert);
		contentPane.add(lblFoogle);
		contentPane.add(searchLogo);
		contentPane.add(lblDessert);
		contentPane.add(checkBoxBeverage);
		contentPane.add(lblBeverage);
		contentPane.add(CreateButton);
		contentPane.add(loginButton);
		contentPane.add(btnSearch);
		contentPane.add(ingpanel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 430, 1204, -425);
		ingpanel.add(scrollPane);
		
		btnFinish = new JButton("");
		btnFinish.setIcon(new ImageIcon(MainMenu.class.getResource("/resources/finish.png")));
		btnFinish.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnFinish.setBounds(669, 691, 178, 87);
		btnFinish.setVisible(false);
		contentPane.add(btnFinish);
		
		//FOR MEAL TEST
		//creating a test list model for placing all ingredients to the combo box
		DefaultComboBoxModel testListModelMeal = (DefaultComboBoxModel) comboBoxForMeal.getModel();
		
		for(int i=0;i<uR.getAllIngredients().size();i++)
			testListModelMeal.addElement(uR.getAllIngredients().get(i).getName());
		
		//FOR DESSERT TEST
		//creating a test list model for placing all ingredients to the combo box
		DefaultComboBoxModel testListModelDessert = (DefaultComboBoxModel) comboBoxForDessert.getModel();
				
		for(int i=0;i<uR.getAllIngredients().size();i++)
			testListModelDessert.addElement(uR.getAllIngredients().get(i).getName());
		
		//FOR BEVERAGE TEST
		//creating a test list model for placing all ingredients to the combo box
		DefaultComboBoxModel testListModelBeverage = (DefaultComboBoxModel) comboBoxForBeverage.getModel();
						
		for(int i=0;i<uR.getAllIngredients().size();i++)
			testListModelBeverage.addElement(uR.getAllIngredients().get(i).getName());
		
	}
	
////////////////////////////////////////////////////////////////
// 						METHODS								///
//////////////////////////////////////////////////////////////	
	
	private void classifyCuisine(ArrayList<Food> foodList){
		for(int i=0;i<foodList.size();i++){
			if(foodList.get(i).getCuisine() == "Turkish"){
				if(foodList.get(i).getType().equals("meal")){
					searchedfoodListMealTurkish.add(foodList.get(i));
				}
				else if(foodList.get(i).getType().equals("dessert")){
					searchedfoodListDessertTurkish.add(foodList.get(i));
				}
				else{
					searchedfoodListBeverageTurkish.add(foodList.get(i));
				}
				
			}
			else if(foodList.get(i).getCuisine() == "Far Eastern"){
				if(foodList.get(i).getType().equals("meal")){
					searchedfoodListMealFarEastern.add(foodList.get(i));
				}
				else if(foodList.get(i).getType().equals("dessert")){
					searchedfoodListDessertFarEastern.add(foodList.get(i));
				}
				else{
					searchedfoodListBeverageFarEastern.add(foodList.get(i));
				}
				
			}
			else if(foodList.get(i).getCuisine() == "French"){
				if(foodList.get(i).getType().equals("meal")){
					searchedfoodListMealFrench.add(foodList.get(i));
				}
				else if(foodList.get(i).getType().equals("dessert")){
					searchedfoodListDessertFrench.add(foodList.get(i));
				}
				else{
					searchedfoodListBeverageFrench.add(foodList.get(i));
				}
			}
			else if(foodList.get(i).getCuisine() == "Russian"){
				if(foodList.get(i).getType().equals("meal")){
					searchedfoodListMealRussian.add(foodList.get(i));
				}
				else if(foodList.get(i).getType().equals("dessert")){
					searchedfoodListDessertRussian.add(foodList.get(i));
				}
				else{
					searchedfoodListBeverageRussian.add(foodList.get(i));
				}		
			}
			else if(foodList.get(i).getCuisine() == "Other"){
				if(foodList.get(i).getType().equals("meal")){
					searchedfoodListMealOther.add(foodList.get(i));
				}
				else if(foodList.get(i).getType().equals("dessert")){
					searchedfoodListDessertOther.add(foodList.get(i));
				}
				else{
					searchedfoodListBeverageOther.add(foodList.get(i));
				}
			}
				
		}
			
	}
	
	//add elements to list of GUI by using the searched food list from database and foodtype
	private void initSearchList(ArrayList<Food> foodList,String foodtype) {
		
		for(int i=0;i<foodList.size();i++)
			if(foodtype.equals("meal"))
				searchListMeal.addElement(new Food(foodList.get(i).getName(),foodList.get(i).getCuisine(),foodList.get(i).getType(),foodList.get(i).getPrice(),foodList.get(i).getIngredients()));
			else if(foodtype.equals("dessert"))
				searchListDessert.addElement(new Food(foodList.get(i).getName(),foodList.get(i).getCuisine(),foodList.get(i).getType(),foodList.get(i).getPrice(),foodList.get(i).getIngredients()));
			else
				searchListBeverage.addElement(new Food(foodList.get(i).getName(),foodList.get(i).getCuisine(),foodList.get(i).getType(),foodList.get(i).getPrice(),foodList.get(i).getIngredients()));
				
	}

	
	//object list from the user desires to ingredient list 	
	private ArrayList<Ingredient> sendIngList(ArrayList<Object> ingredientList) {
		
		ArrayList<Ingredient> ingListToSend = new ArrayList<Ingredient>();
		for(int i=0;i<ingredientList.size();i++){
			ingListToSend.add(new Ingredient(ingredientList.get(i).toString()));
		}
		
		return ingListToSend;
		
	}
	
	
	////////////////////////////////////////////////////////////////
	// This method contains all of the code for creating events.///
	//////////////////////////////////////////////////////////////
	private void createEvents() 
	{
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(checkBoxBeverage.isEnabled() && checkBoxDessert.isEnabled() && checkBoxMeal.isEnabled() )
					JOptionPane.showMessageDialog(null, "Please select at least one of food type and ingredients :)");
				else{
					btnFinish.setVisible(true);
					btnSearch.setVisible(false);
					
					if(!checkBoxMeal.isEnabled()){
						mealpanel.setVisible(true);
						scrMeal.setVisible(true);
						lblSelectMeal.setVisible(false);
						comboBoxForMeal.setVisible(false);
						labelmealback.setVisible(false);
						btnWantedMeal.setVisible(false);
						btnUnwantedMeal.setVisible(false);
						btnDontCareMeal.setVisible(false);
						btnOkMeal.setVisible(false);
					
					}
					if (!checkBoxDessert.isEnabled()){
						dessertpanel.setVisible(true);
						scrDessert.setVisible(true);
						lblSelectDessert.setVisible(false);
						comboBoxForDessert.setVisible(false);
						lbldessertback.setVisible(false);
						btnWantedDessert.setVisible(false);
						btnUnwantedDessert.setVisible(false);
						btnDontCareDessert.setVisible(false);
						btnOkDessert.setVisible(false);
					
					}
					if (!checkBoxBeverage.isEnabled()){
						beveragepanel.setVisible(true);
						scrBeverage.setVisible(true);
						lblSelectBeverage.setVisible(false);
						comboBoxForBeverage.setVisible(false);
						lblbeverageback.setVisible(false);
						btnWantedBeverage.setVisible(false);
						btnUnwantedBeverage.setVisible(false);
						btnDontCareBeverage.setVisible(false);
						btnOkBeverage.setVisible(false);
					}
				}	
			}
		});
		
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	    		String[] options = new String[3];
	    		options[0] = new String("I definetely come back! :)");
	    		options[1] = new String("I want to search again ! :)");
	    		options[2] = new String("Maybe later :/");
	    		
	    		String[] options2 = new String[2];
	    		options2[0] = new String("Give a chance to Foogle");
	    		options2[1] = new String("No thanks.");
	    
	    		int choice = JOptionPane.showOptionDialog(getContentPane(),"Hope you like Foogle ! Will you visit again? :)","Goodbye Foogler", 0,JOptionPane.INFORMATION_MESSAGE,null,options,null);
	    		if(choice == 0){
	    			JOptionPane.showMessageDialog(null, "Thanks Bye!");
	    			System.exit(0);
	    		}
	    		else if(choice == 1){
	    			dispose();
					MainMenu mainmenu = new MainMenu();
					mainmenu.setVisible(true);
	    		}
	    		else{
	    			int choice2 = JOptionPane.showOptionDialog(getContentPane(),"Are you sure? :/","Goodbye Foogler", 0,JOptionPane.INFORMATION_MESSAGE,null,options2,null);
	    			if(choice2 == 0){
	    				dispose();
						MainMenu mainmenu = new MainMenu();
						mainmenu.setVisible(true);
	    			}
	    			else
	    				System.exit(0);
	    		}
	    	}
		});
		////////////////////////////////////////////////////////////////
		// 				THE MEAL PART OF THE EVENTS					///
		//////////////////////////////////////////////////////////////
		
		lstResultMeals.setCellRenderer(new DefaultListCellRenderer(){
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus){
				Component renderer = (Component) super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
				if(renderer instanceof JLabel && value instanceof Food){
					System.out.println(((Food)value).getCuisine());
					((JLabel) renderer).setText( "Food name: " + ((Food) value).getName() + "-" + "Cuisine: " + ((Food) value).getCuisine() + "-" + "Price: " + ((Food) value).getPrice() + "-" + ((Food) value).listToString() + "-" + ((Food) value).listToRestaurant());
				}
				return renderer;
			}
			});
		
		//selection of wanted ingredients for meal
		btnWantedMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = comboBoxForMeal.getSelectedItem();
				if(btnWantedMeal.isSelected() && !wantedIngredientsMeal.contains(selected)){
					wantedIngredientsMeal.add(selected);
				}
				if(btnWantedMeal.isSelected() && unwantedIngredientsMeal.contains(selected)){
					unwantedIngredientsMeal.remove(selected);
				}
				
				System.out.println("Wanted Ingredients For Meal");
				System.out.println(wantedIngredientsMeal.toString());
				System.out.println("Unwanted Ingredients For Meal");
				System.out.println(unwantedIngredientsMeal.toString());
				
			}
		});
		
		//selection of unwanted ingredients for meal
		btnUnwantedMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = comboBoxForMeal.getSelectedItem();
				if(btnUnwantedMeal.isSelected() && wantedIngredientsMeal.contains(selected)){
					wantedIngredientsMeal.remove(selected);
				}
				if(btnUnwantedMeal.isSelected() && !unwantedIngredientsMeal.contains(selected)){
					unwantedIngredientsMeal.add(selected);
				}
				System.out.println("Wanted Ingredients For Meal");
				System.out.println(wantedIngredientsMeal.toString());
				System.out.println("Unwanted Ingredients For Meal");
				System.out.println(unwantedIngredientsMeal.toString());
			}
		});
		
		//update for dont care ingredients for meal
		btnDontCareMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = comboBoxForMeal.getSelectedItem();
				if(btnDontCareMeal.isSelected() && wantedIngredientsMeal.contains(selected)){
					wantedIngredientsMeal.remove(selected);
				}
				if(btnDontCareMeal.isSelected() && unwantedIngredientsMeal.contains(selected)){
					unwantedIngredientsMeal.remove(selected);
				}
				
				System.out.println("Wanted Ingredients For Meal");
				System.out.println(wantedIngredientsMeal.toString());
				System.out.println("Unwanted Ingredients For Meal");
				System.out.println(unwantedIngredientsMeal.toString());
			}
		});
		
		//determines the last design of wanted and unwanted ingredient list
		btnOkMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Wanted Ingredients of Meal list that should be send");
				//for wanted ingredients of meal , convert object to ingredient list
				ArrayList<Ingredient> newListWantedMeal= new ArrayList<Ingredient>(); 
				newListWantedMeal = sendIngList(wantedIngredientsMeal);
				for(int i=0;i<wantedIngredientsMeal.size();i++){
					System.out.println(newListWantedMeal.get(i).getName());
				}
				
				System.out.println("Unwanted Ingredients of Meal list that should be send");
				//for unwanted ingredients of meal , convert object to ingredient list
				ArrayList<Ingredient> newListUnwantedMeal= new ArrayList<Ingredient>(); 
				newListUnwantedMeal = sendIngList(unwantedIngredientsMeal);
				for(int i=0;i<unwantedIngredientsMeal.size();i++){
					System.out.println(newListUnwantedMeal.get(i).getName());
				}
								
				searchedFoodListMeal = uR.searchFood(newListWantedMeal, newListUnwantedMeal, "meal");
				classifyCuisine(searchedFoodListMeal);
				initSearchList(searchedfoodListMealTurkish,"meal");
				initSearchList(searchedfoodListMealFarEastern,"meal");
				initSearchList(searchedfoodListMealFrench,"meal");
				initSearchList(searchedfoodListMealRussian,"meal");
				initSearchList(searchedfoodListMealOther,"meal");
				
				////////////////////
				
				mealpanel.setVisible(false);
				checkBoxMeal.setEnabled(false);
				JOptionPane.showMessageDialog(null,"Your meal ingredients are saved! :) ");
				
		
			}
		});
		
		//if check box of meal is selected - arraylist is created + panel becomes visible
		checkBoxMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBoxMeal.isSelected()){
					mealpanel.setVisible(true);
					wantedIngredientsMeal = new ArrayList<Object>();
					unwantedIngredientsMeal = new ArrayList<Object>();
				}	
				else 
					mealpanel.setVisible(false);
			}
		});
		
		//each time combobox is pushed set dont care as default
		comboBoxForMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDontCareMeal.setSelected(true);
			}
		});
		
		////////////////////////////////////////////////////////////////
		// 			END OF THE MEAL PART OF THE EVENTS				///
		//////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////////////////
		// 				THE DESSERT PART OF THE EVENTS				///
		//////////////////////////////////////////////////////////////
		
		lstResultDesserts.setCellRenderer(new DefaultListCellRenderer(){
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus){
				Component renderer = (Component) super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
				if(renderer instanceof JLabel && value instanceof Food){
					((JLabel) renderer).setText( "Food name: " + ((Food) value).getName() + "-" + "Cuisine: " + ((Food) value).getCuisine() + "-" + "Price: " + ((Food) value).getPrice() + "-" + ((Food) value).listToString());
				}
				return renderer;
			}
			});
	
		//selection of wanted ingredients for dessert
		btnWantedDessert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = comboBoxForDessert.getSelectedItem();
				if(btnWantedDessert.isSelected() && !wantedIngredientsDessert.contains(selected)){
					wantedIngredientsDessert.add(selected);
				}
				if(btnWantedDessert.isSelected() && unwantedIngredientsDessert.contains(selected)){
					unwantedIngredientsDessert.remove(selected);
				}
				
				System.out.println("Wanted Ingredients For Dessert");
				System.out.println(wantedIngredientsDessert.toString());
				System.out.println("Unwanted Ingredients For Dessert");
				System.out.println(unwantedIngredientsDessert.toString());
				
			}
		});
		
		//selection of unwanted ingredients for dessert
		btnUnwantedDessert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = comboBoxForDessert.getSelectedItem();
				if(btnUnwantedDessert.isSelected() && wantedIngredientsDessert.contains(selected)){
					wantedIngredientsDessert.remove(selected);
				}
				if(btnUnwantedDessert.isSelected() && !unwantedIngredientsDessert.contains(selected)){
					unwantedIngredientsDessert.add(selected);
				}
				System.out.println("Wanted Ingredients For Dessert");
				System.out.println(wantedIngredientsDessert.toString());
				System.out.println("Unwanted Ingredients For Dessert");
				System.out.println(unwantedIngredientsDessert.toString());
			}
		});
		
		//update for dont care ingredients for dessert
		btnDontCareDessert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = comboBoxForDessert.getSelectedItem();
				if(btnDontCareDessert.isSelected() && wantedIngredientsDessert.contains(selected)){
					wantedIngredientsDessert.remove(selected);
				}
				if(btnDontCareDessert.isSelected() && unwantedIngredientsDessert.contains(selected)){
					unwantedIngredientsDessert.remove(selected);
				}
				
				System.out.println("Wanted Ingredients For Dessert");
				System.out.println(wantedIngredientsDessert.toString());
				System.out.println("Unwanted Ingredients For Dessert");
				System.out.println(unwantedIngredientsDessert.toString());
			}
		});
		
		//determines the last design of wanted and unwanted ingredient list
		btnOkDessert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Wanted Ingredients of Dessert list that should be send");
				//for wanted ingredients of meal , convert object to ingredient list
				ArrayList<Ingredient> newListWantedDessert= new ArrayList<Ingredient>(); 
				newListWantedDessert = sendIngList(wantedIngredientsDessert);
				for(int i=0;i<wantedIngredientsDessert.size();i++){
					System.out.println(newListWantedDessert.get(i).getName());
				}
				
				System.out.println("Unwanted Ingredients of Dessert list that should be send");
				//for unwanted ingredients of meal , convert object to ingredient list
				ArrayList<Ingredient> newListUnwantedDessert= new ArrayList<Ingredient>(); 
				newListUnwantedDessert = sendIngList(unwantedIngredientsDessert);
				for(int i=0;i<unwantedIngredientsDessert.size();i++){
					System.out.println(newListUnwantedDessert.get(i).getName());
				}
				
				searchedFoodListDessert = uR.searchFood(newListWantedDessert, newListUnwantedDessert, "dessert");
				classifyCuisine(searchedFoodListDessert);
				initSearchList(searchedfoodListDessertTurkish,"dessert");
				initSearchList(searchedfoodListDessertFarEastern,"dessert");
				initSearchList(searchedfoodListDessertFrench,"dessert");
				initSearchList(searchedfoodListDessertRussian,"dessert");
				initSearchList(searchedfoodListDessertOther,"dessert");
				////////////////////
				
				dessertpanel.setVisible(false);
				checkBoxDessert.setEnabled(false);
				JOptionPane.showMessageDialog(null,"Your dessert ingredients are saved! :) ");
				
			}
		});
		
		//change panel visibility of dessert
		checkBoxDessert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBoxDessert.isSelected()){
					dessertpanel.setVisible(true);
					wantedIngredientsDessert = new ArrayList<Object>();
					unwantedIngredientsDessert = new ArrayList<Object>();
				}	
				else 
					dessertpanel.setVisible(false);
			}
		});
		
		//each time combobox is pushed set dont care as default
		comboBoxForDessert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDontCareDessert.setSelected(true);
			}
		});
		
		
		////////////////////////////////////////////////////////////////
		// 			END OF THE DESSERT PART OF THE EVENTS			///
		//////////////////////////////////////////////////////////////
		
		
		
		////////////////////////////////////////////////////////////////
		// 				THE BEVERAGE PART OF THE EVENTS				///
		//////////////////////////////////////////////////////////////
		
		lstResultBeverages.setCellRenderer(new DefaultListCellRenderer(){
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus){
				Component renderer = (Component) super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
				if(renderer instanceof JLabel && value instanceof Food){
					((JLabel) renderer).setText( "Food name: " + ((Food) value).getName() + "-" + "Cuisine: " + ((Food) value).getCuisine() + "-" + "Price: " + ((Food) value).getPrice() + "-" + ((Food) value).listToString());
				}
				return renderer;
			}
			});
		
		//selection of wanted ingredients for beverage
		btnWantedBeverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = comboBoxForBeverage.getSelectedItem();
				if(btnWantedBeverage.isSelected() && !wantedIngredientsBeverage.contains(selected)){
					wantedIngredientsBeverage.add(selected);
				}
				if(btnWantedBeverage.isSelected() && unwantedIngredientsBeverage.contains(selected)){
					unwantedIngredientsBeverage.remove(selected);
				}

				System.out.println("Wanted Ingredients For Beverage");
				System.out.println(wantedIngredientsBeverage.toString());
				System.out.println("Unwanted Ingredients For Beverage");
				System.out.println(unwantedIngredientsBeverage.toString());

			}
		});

		//selection of unwanted ingredients for beverage
		btnUnwantedBeverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = comboBoxForBeverage.getSelectedItem();
				if(btnUnwantedBeverage.isSelected() && wantedIngredientsBeverage.contains(selected)){
					wantedIngredientsBeverage.remove(selected);
				}
				if(btnUnwantedBeverage.isSelected() && !unwantedIngredientsBeverage.contains(selected)){
					unwantedIngredientsBeverage.add(selected);
				}
				System.out.println("Wanted Ingredients For Beverage");
				System.out.println(wantedIngredientsBeverage.toString());
				System.out.println("Unwanted Ingredients For Beverage");
				System.out.println(unwantedIngredientsBeverage.toString());
			}
		});

		//update for dont care ingredients for dessert
		btnDontCareBeverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = comboBoxForBeverage.getSelectedItem();
				if(btnDontCareBeverage.isSelected() && wantedIngredientsBeverage.contains(selected)){
					wantedIngredientsBeverage.remove(selected);
				}
				if(btnDontCareBeverage.isSelected() && unwantedIngredientsBeverage.contains(selected)){
					unwantedIngredientsBeverage.remove(selected);
				}

				System.out.println("Wanted Ingredients For Beverage");
				System.out.println(wantedIngredientsBeverage.toString());
				System.out.println("Unwanted Ingredients For Beverage");
				System.out.println(unwantedIngredientsBeverage.toString());
			}
		});

		//determines the last design of wanted and unwanted ingredient list
		btnOkBeverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("Wanted Ingredients of Beverage list that should be send");
				//for wanted ingredients of meal , convert object to ingredient list
				ArrayList<Ingredient> newListWantedBeverage= new ArrayList<Ingredient>(); 
				newListWantedBeverage = sendIngList(wantedIngredientsBeverage);
				for(int i=0;i<wantedIngredientsBeverage.size();i++){
					System.out.println(newListWantedBeverage.get(i).getName());
				}
				
				System.out.println("Unwanted Ingredients of Beverage list that should be send");
				//for unwanted ingredients of meal , convert object to ingredient list
				ArrayList<Ingredient> newListUnwantedBeverage= new ArrayList<Ingredient>(); 
				newListUnwantedBeverage = sendIngList(unwantedIngredientsBeverage);
				for(int i=0;i<unwantedIngredientsBeverage.size();i++){
					System.out.println(newListUnwantedBeverage.get(i).getName());
				}
			
				searchedFoodListBeverage = uR.searchFood(newListWantedBeverage, newListUnwantedBeverage, "beverage");
				classifyCuisine(searchedFoodListBeverage);
				initSearchList(searchedfoodListBeverageTurkish,"beverage");
				initSearchList(searchedfoodListBeverageFarEastern,"beverage");
				initSearchList(searchedfoodListBeverageFrench,"beverage");
				initSearchList(searchedfoodListBeverageRussian,"beverage");
				initSearchList(searchedfoodListBeverageOther,"beverage");
				////////////////////
				
				beveragepanel.setVisible(false);
				checkBoxBeverage.setEnabled(false);
				JOptionPane.showMessageDialog(null,"Your Beverage ingredients are saved! :) ");

			}
		});
		
		//change panel visibility of beverage
		checkBoxBeverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBoxBeverage.isSelected()){
					beveragepanel.setVisible(true);
					wantedIngredientsBeverage = new ArrayList<Object>();
					unwantedIngredientsBeverage = new ArrayList<Object>();
				}
				else
					beveragepanel.setVisible(false);
			}
		});
		
		//each time combobox is pushed set dont care as default
		comboBoxForBeverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDontCareBeverage.setSelected(true);
			}
		});
				
		
		////////////////////////////////////////////////////////////////
		// 			END OF THE BEVERAGE PART OF THE EVENTS			///
		//////////////////////////////////////////////////////////////
		
		
		//go to the login page 
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginScreen loginScreen = new LoginScreen("");
				loginScreen.setVisible(true);
			
			}
		});
		
		//go to the create account page
		CreateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CreateAccountScreen createAccount = new CreateAccountScreen(username);
				createAccount.setVisible(true);
			}
		});
		
		
	}
}

