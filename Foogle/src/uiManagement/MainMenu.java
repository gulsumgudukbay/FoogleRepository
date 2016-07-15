package uiManagement;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JPasswordField;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JCheckBox;

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
		
		
		lblMeal = new JLabel("Meal");
		lblMeal.setIcon(new ImageIcon(MainMenu.class.getResource("/resources/sandwich.png")));
		lblMeal.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblDessert = new JLabel("Dessert");
		lblDessert.setIcon(new ImageIcon(MainMenu.class.getResource("/resources/ice-cream.png")));
		lblDessert.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblBeverage = new JLabel("Beverage");
		lblBeverage.setIcon(new ImageIcon(MainMenu.class.getResource("/resources/cocktail.png")));
		lblBeverage.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		checkBoxMeal = new JCheckBox("");
		
		checkBoxDessert = new JCheckBox("");

		checkBoxBeverage = new JCheckBox("");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		
		JLabel searchLogo = new JLabel("");
		searchLogo.setIcon(new ImageIcon(MainMenu.class.getResource("/resources/foodsearch.png")));
		 
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnSearch.setIcon(new ImageIcon(MainMenu.class.getResource("/resources/plate-fork-and-knife.png")));
		
		CreateButton = new JButton("Create an Account as a Restaurant Owner");
		CreateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(131)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMeal)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(24)
									.addComponent(checkBoxMeal)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(468)
									.addComponent(checkBoxDessert))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(426)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(searchLogo)
										.addComponent(lblDessert))))
							.addPreferredGap(ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(checkBoxBeverage)
									.addGap(46))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(lblBeverage)
									.addGap(29))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(CreateButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
									.addGap(19))))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1217, GroupLayout.PREFERRED_SIZE)))
					.addGap(62))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(searchLogo))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(CreateButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMeal)
						.addComponent(lblDessert)
						.addComponent(lblBeverage))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(checkBoxMeal)
						.addComponent(checkBoxDessert)
						.addComponent(checkBoxBeverage))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	////////////////////////////////////////////////////////////////
	// This method contains all of the code for creating events.///
	//////////////////////////////////////////////////////////////
	private void createEvents() 
	{
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginScreen loginScreen = new LoginScreen();
				loginScreen.setVisible(true);
				
			}
		});
	}
}

