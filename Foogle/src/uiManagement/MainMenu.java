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
	private JButton btnLoginAsA;

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

	public MainMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/duygudurmus/Documents/workspacemars/WindowBuilder/src/windowBuilder/resources/foody_16.png"));
		
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
		setBounds(200, 200, 450, 300);
		
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(900,600));
	    getContentPane().add(contentPane, BorderLayout.CENTER);
	    pack();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(253, 245, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		btnLoginAsA = new JButton("Login as a Restaurant Owner");
		
		JLabel lblMeal = new JLabel("Meal");
		lblMeal.setIcon(new ImageIcon("/Users/duygudurmus/Desktop/Resources/sandwich.png"));
		lblMeal.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblDessert = new JLabel("Dessert");
		lblDessert.setIcon(new ImageIcon("/Users/duygudurmus/Desktop/Resources/ice-cream.png"));
		lblDessert.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblBeverage = new JLabel("Beverage");
		lblBeverage.setIcon(new ImageIcon("/Users/duygudurmus/Desktop/Resources/cocktail.png"));
		lblBeverage.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JCheckBox checkBoxMeal = new JCheckBox("");
		
		JCheckBox checkBoxDessert = new JCheckBox("");
		
		JCheckBox checkBoxBeverage = new JCheckBox("");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel = new JLabel("");
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/duygudurmus/Desktop/Resources/foodsearch.png"));
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setIcon(new ImageIcon("/Users/duygudurmus/Desktop/Resources/plate-fork-and-knife.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(85)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblMeal)
							.addPreferredGap(ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
							.addComponent(lblDessert)
							.addGap(164)
							.addComponent(lblBeverage)))
					.addGap(126))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(122)
					.addComponent(checkBoxMeal)
					.addPreferredGap(ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
					.addComponent(checkBoxDessert)
					.addGap(258)
					.addComponent(checkBoxBeverage)
					.addGap(143))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(383, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addGap(89)
							.addComponent(btnLoginAsA, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)))
					.addGap(20))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLoginAsA, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(41)
									.addComponent(lblNewLabel))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblNewLabel_1)))
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblBeverage)
								.addComponent(lblDessert))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(checkBoxDessert)
								.addComponent(checkBoxBeverage)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblMeal)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(checkBoxMeal)))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel.setLayout(null);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	////////////////////////////////////////////////////////////////
	// This method contains all of the code for creating events.///
	//////////////////////////////////////////////////////////////
	private void createEvents() 
	{
		
	}
}

