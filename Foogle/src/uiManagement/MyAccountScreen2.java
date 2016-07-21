package uiManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import dataManagement.RestDB;
import restaurantAndFoodManagement.Food;
import restaurantAndFoodManagement.Restaurant;
import userManagement.RestaurantOwner;

import javax.swing.border.EtchedBorder;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyAccountScreen2 extends JFrame {

	private JPanel contentPane;
	private static String username;
	public RestaurantOwner restOwner = new RestaurantOwner();
	public Restaurant rest = new Restaurant();
	public ArrayList<Food> foods = new ArrayList<Food>();
	DefaultListModel<Food> searchListMeal = new DefaultListModel<Food>();
	DefaultListModel<Food> searchListDessert = new DefaultListModel<Food>();
	DefaultListModel<Food> searchListBeverage = new DefaultListModel<Food>();
	private JScrollPane scrMeal;
	private JList lstMeal;
	private JScrollPane scrDessert;
	private JList lstDessert;
	private JScrollPane scrBeverage;
	private JList lstBeverage;
	private JLabel lblRestaurants;
	private JButton button;
	private JComboBox comboBox;

	RestDB rdb = RestDB.getSoleInstance();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyAccountScreen2 frame = new MyAccountScreen2(username);
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
	public MyAccountScreen2(String username) {
		this.username = username;
		initComponents();
		createEvents();
	}

	private void initComponents() {
		setTitle("Foogle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setPreferredSize(new Dimension(1440,800));
	    getContentPane().add(contentPane, BorderLayout.SOUTH);
	    pack();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		lblRestaurants = new JLabel("Restaurants:");
		lblRestaurants.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
		
		comboBox = new JComboBox();

		DefaultComboBoxModel comboBoxModelRestaurant = (DefaultComboBoxModel) comboBox.getModel();
		
		for(int i=0;i<restOwner.getAllRestaurantsOfARestaurantOwner(username).size();i++)
			comboBoxModelRestaurant.addElement(restOwner.getAllRestaurantsOfARestaurantOwner(username).get(i).getName());
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Included Foods", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(250, 240, 230));
		
		button = new JButton("Back");

		button.setIcon(new ImageIcon(MyAccountScreen2.class.getResource("/resources/back_64.png")));
		button.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(403)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblRestaurants)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(390, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1231, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRestaurants, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 477, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(101, Short.MAX_VALUE))
		);
		
		scrMeal = new JScrollPane();
		scrMeal.setBackground(new Color(250, 240, 230));
		
		scrDessert = new JScrollPane();
		scrDessert.setBackground(new Color(250, 240, 230));
		
		scrBeverage = new JScrollPane();
		scrBeverage.setBackground(new Color(250, 240, 230));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrMeal, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
						.addComponent(scrDessert, GroupLayout.PREFERRED_SIZE, 613, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrBeverage, GroupLayout.PREFERRED_SIZE, 613, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrMeal, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrDessert, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrBeverage, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		
		lstBeverage = new JList(searchListMeal);
		lstBeverage.setBorder(new TitledBorder(null, "Beverage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lstBeverage.setBackground(new Color(250, 240, 230));
		scrBeverage.setViewportView(lstBeverage);
		
		lstDessert = new JList(searchListDessert);
		lstDessert.setBorder(new TitledBorder(null, "Dessert", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lstDessert.setBackground(new Color(250, 240, 230));
		scrDessert.setViewportView(lstDessert);
		
		lstMeal = new JList(searchListBeverage);
		lstMeal.setBorder(new TitledBorder(null, "Meal ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lstMeal.setBackground(new Color(250, 240, 230));
		scrMeal.setViewportView(lstMeal);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
	}
	
private void initSearchList(ArrayList<Food> foodList) {
		
		for(int i=0;i<foodList.size();i++){
			if(foodList.get(i).getType().equals("meal")){
				searchListMeal.addElement(new Food(foodList.get(i).getName(),foodList.get(i).getCuisine(),foodList.get(i).getType(),foodList.get(i).getPrice(),foodList.get(i).getIngredients()));
			}
			else if(foodList.get(i).getType().equals("dessert")){
				searchListDessert.addElement(new Food(foodList.get(i).getName(),foodList.get(i).getCuisine(),foodList.get(i).getType(),foodList.get(i).getPrice(),foodList.get(i).getIngredients()));
			}
			else
				searchListBeverage.addElement(new Food(foodList.get(i).getName(),foodList.get(i).getCuisine(),foodList.get(i).getType(),foodList.get(i).getPrice(),foodList.get(i).getIngredients()));

		}	
	}

	
	private void createEvents() {

		
		lstMeal.setCellRenderer(new DefaultListCellRenderer(){
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus){
				Component renderer = (Component) super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
				if(renderer instanceof JLabel && value instanceof Food){
					System.out.println(((Food)value).getCuisine());
					((JLabel) renderer).setText( "Food name: " + ((Food) value).getName() + "-" + "Price: " + ((Food) value).getPrice() + "-" + ((Food) value).listToString() + "-" + ((Food) value).listToRestaurant());
				}
				return renderer;
			}
			});
		
		lstDessert.setCellRenderer(new DefaultListCellRenderer(){
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus){
				Component renderer = (Component) super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
				if(renderer instanceof JLabel && value instanceof Food){
					System.out.println(((Food)value).getCuisine());
					((JLabel) renderer).setText( "Food name: " + ((Food) value).getName() + "-" + "Price: " + ((Food) value).getPrice() + "-" + ((Food) value).listToString() + "-" + ((Food) value).listToRestaurant());
				}
				return renderer;
			}
			});
		
		lstBeverage.setCellRenderer(new DefaultListCellRenderer(){
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus){
				Component renderer = (Component) super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
				if(renderer instanceof JLabel && value instanceof Food){
					System.out.println(((Food)value).getCuisine());
					((JLabel) renderer).setText( "Food name: " + ((Food) value).getName() + "-" + "Price: " + ((Food) value).getPrice() + "-" + ((Food) value).listToString() + "-" + ((Food) value).listToRestaurant());
				}
				return renderer;
			}
			});
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchListMeal.removeAllElements();
				searchListDessert.removeAllElements();
				searchListBeverage.removeAllElements();
				
				Object selected = comboBox.getSelectedItem();
				String strSelected = selected.toString();
				rest.setName(strSelected);
				rest.setFoodsFromDatabase(username);
				foods = rdb.getAllFoods(strSelected, username);
				System.out.println("FOODS "+ foods.toString());
				initSearchList(foods);
				
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoggedInScreen loggedInScreen = new LoggedInScreen(username);
				loggedInScreen.setVisible(true);
			}
		});
		
	}
}
