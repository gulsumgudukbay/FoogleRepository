package uiManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;


public class AddFoodScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldPrice;
	private JTextField textFieldCuisine;

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
		initComponents();
	}
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Foogle");
		setBounds(200, 200, 1440, 800);
		
		setResizable(false);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		JPanel foodAddingPanel = new JPanel();
		foodAddingPanel.setBackground(new Color(250, 240, 230));
		
		JPanel ingChoosingPanel = new JPanel();
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
				.addGap(0, 700, Short.MAX_VALUE)
		);
		gl_ingChoosingPanel.setVerticalGroup(
			gl_ingChoosingPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 735, Short.MAX_VALUE)
		);
		ingChoosingPanel.setLayout(gl_ingChoosingPanel);
		
		JLabel lblSelectRestaurant = new JLabel("Please select the restaurant you want to add food ");
		
		JComboBox restaurantsBox = new JComboBox();
		
		JLabel lblFoodName = new JLabel("Please enter the name of the food you want to add ");
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		
		JLabel lblTypeSelect = new JLabel("Please select the type of the food ");
		
		JComboBox typeBox = new JComboBox();
		typeBox.setModel(new DefaultComboBoxModel(new String[] {"Meal", "Dessert", "Beverage"}));
		
		JLabel lblPrice = new JLabel("Please enter the price of the food ");
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		
		JLabel lblCuisine = new JLabel("If food belongs to a cuisine please enter it below ");
		
		JLabel lblCuisineDefault = new JLabel("Otherwise, leave the text field blank");
		
		textFieldCuisine = new JTextField();
		textFieldCuisine.setColumns(10);
		
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
