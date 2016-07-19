package uiManagement;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;


public class AddFoodScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName = new JTextField();
	private JTextField textFieldPrice = new JTextField();
	private JTextField textFieldCuisine = new JTextField();
	private	JPanel foodAddingPanel = new JPanel();
	private JPanel ingChoosingPanel = new JPanel();
	private JLabel lblSelectRestaurant = new JLabel("Please select the restaurant you want to add food ");
	private JLabel lblIngredient = new JLabel("Please select the ingredient from list and click 'add' button to add that ingredient to the food");
	private JComboBox restaurantsBox = new JComboBox();
	private JLabel lblFoodName = new JLabel("Please enter the name of the food you want to add ");
	private JLabel lblTypeSelect = new JLabel("Please select the type of the food ");
	private JComboBox typeBox = new JComboBox();
	private JLabel lblPrice = new JLabel("Please enter the price of the food ");
	private JLabel lblCuisine = new JLabel("If food belongs to a cuisine please enter it below ");
	private JLabel lblCuisineDefault = new JLabel("Otherwise, leave the text field blank");
	private JList list = new JList();
	private JButton btnAdd = new JButton("Add");
	private JLabel lblOthers = new JLabel("If you want to add a new ingredient or ingredients, please enter them below");
	private JLabel lblOthersBlank = new JLabel("Please leave a one character blank between two seperate ingredients");
	private JTextField textFieldOthers = new JTextField();
	private JButton btnSubmit = new JButton("Submit");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFoodScreen frame = new AddFoodScreen();
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
	public AddFoodScreen() {
		textFieldOthers.setColumns(10);
		initComponents();
	}
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Foogle");
		setBounds(200, 200, 1440, 800);
		
		setResizable(false);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		foodAddingPanel.setBackground(new Color(250, 240, 230));
		ingChoosingPanel.setBackground(new Color(250, 240, 230));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addComponent(foodAddingPanel, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					.addComponent(ingChoosingPanel, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(ingChoosingPanel, GroupLayout.PREFERRED_SIZE, 735, GroupLayout.PREFERRED_SIZE)
						.addComponent(foodAddingPanel, GroupLayout.PREFERRED_SIZE, 735, GroupLayout.PREFERRED_SIZE))
					.addGap(24))
		);
		
		GroupLayout gl_ingChoosingPanel = new GroupLayout(ingChoosingPanel);
		gl_ingChoosingPanel.setHorizontalGroup(
			gl_ingChoosingPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ingChoosingPanel.createSequentialGroup()
					.addGroup(gl_ingChoosingPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_ingChoosingPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_ingChoosingPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_ingChoosingPanel.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_ingChoosingPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(list, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblIngredient, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblOthers, Alignment.LEADING)
								.addComponent(lblOthersBlank, Alignment.LEADING)
								.addComponent(textFieldOthers, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 608, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		gl_ingChoosingPanel.setVerticalGroup(
			gl_ingChoosingPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ingChoosingPanel.createSequentialGroup()
					.addGap(32)
					.addComponent(lblIngredient)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAdd)
					.addGap(28)
					.addComponent(lblOthers)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblOthersBlank)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldOthers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		ingChoosingPanel.setLayout(gl_ingChoosingPanel);
		
		textFieldName.setColumns(10);		
		textFieldPrice.setColumns(10);
		textFieldCuisine.setColumns(10);
		
		typeBox.setModel(new DefaultComboBoxModel(new String[] {"Meal", "Dessert", "Beverage"}));
		
		btnSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		
		GroupLayout gl_foodAddingPanel = new GroupLayout(foodAddingPanel);
		gl_foodAddingPanel.setHorizontalGroup(
			gl_foodAddingPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_foodAddingPanel.createSequentialGroup()
					.addGroup(gl_foodAddingPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_foodAddingPanel.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_foodAddingPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCuisine)
								.addComponent(lblPrice)
								.addComponent(lblTypeSelect)
								.addComponent(typeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFoodName)
								.addComponent(restaurantsBox, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSelectRestaurant)
								.addComponent(textFieldPrice, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_foodAddingPanel.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_foodAddingPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textFieldCuisine, Alignment.LEADING)
								.addComponent(lblCuisineDefault, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(354, Short.MAX_VALUE))
		);
		gl_foodAddingPanel.setVerticalGroup(
			gl_foodAddingPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_foodAddingPanel.createSequentialGroup()
					.addGap(34)
					.addComponent(lblSelectRestaurant)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(restaurantsBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(lblTypeSelect)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(typeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(lblFoodName)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(lblPrice)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(lblCuisine)
					.addGap(1)
					.addComponent(lblCuisineDefault)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldCuisine, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(221, Short.MAX_VALUE))
		);
		foodAddingPanel.setLayout(gl_foodAddingPanel);
		getContentPane().setLayout(groupLayout);
	}
}
