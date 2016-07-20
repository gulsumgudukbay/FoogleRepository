package uiManagement;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import restaurantAndFoodManagement.Ingredient;
import restaurantAndFoodManagement.Restaurant;
import userManagement.Admin;

public class AdminScreen extends JFrame {

	Admin a = Admin.getSoleInstance();
	private JPanel contentPane;
	private ArrayList<Restaurant> pendingResList = new ArrayList<Restaurant>();
	private ArrayList<Ingredient> pendingIngList = new ArrayList<Ingredient>();
	private JList ingList;
	private JList resList;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminScreen frame = new AdminScreen();
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
	public AdminScreen() {
		initComponents();
		pendingIngList = a.getPendingIngredients();
		pendingResList = a.getPendingRestaurants();
	}
	
	public void initComponents() {
		
		final DefaultListModel ingModel = new DefaultListModel();
		for (int i = 0; i < pendingIngList.size(); i++) {
		  ingModel.addElement(pendingIngList.get(i));
		}
		ingList = new JList(ingModel);
		
		final DefaultListModel resModel = new DefaultListModel();
		for (int i = 0; i < pendingResList.size(); i++) {
		  ingModel.addElement(pendingResList.get(i));
		}
		ingList = new JList(ingModel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("My Account");
		setBounds(200, 200, 1440, 800);
		
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(250, 240, 230));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
				
		JButton btnRejectIng = new JButton("Reject");
		btnRejectIng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ingredient currentIng = (Ingredient) ingList.getSelectedValue();
				int i = ingList.getSelectedIndex();
				currentIng.setConfirmed(false);
				ingModel.remove(i);
			}
		});
		
		JButton btnConfirmIng = new JButton("Confirm");
		btnConfirmIng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Ingredient currentIng = (Ingredient) ingList.getSelectedValue();
				int i = ingList.getSelectedIndex();
				currentIng.setConfirmed(true);
				ingModel.remove(i);
			}
		});
		
		JButton btnRejectRes = new JButton("Reject");
		btnRejectRes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Restaurant currentRes = (Restaurant) resList.getSelectedValue();
				int i = resList.getSelectedIndex();
				currentRes.setConfirmed(false);
				resModel.remove(i);
			}
		});
		
		JButton btnConfirmRes = new JButton("Confirm");
		btnConfirmRes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Restaurant currentRes = (Restaurant) resList.getSelectedValue();
				int i = resList.getSelectedIndex();
				currentRes.setConfirmed(true);
				resModel.remove(i);
			}
		});
		
		JLabel lblIngredient = new JLabel("Ingredients:");
		
		JLabel lblRestaurants = new JLabel("Restaurants:");
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(282)
							.addComponent(btnConfirmIng)
							.addGap(18)
							.addComponent(btnRejectIng)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnConfirmRes)
							.addGap(18)
							.addComponent(btnRejectRes))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(ingList, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIngredient, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
							.addGap(181)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblRestaurants, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addComponent(resList, GroupLayout.PREFERRED_SIZE, 471, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(301, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIngredient)
						.addComponent(lblRestaurants))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(resList, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ingList, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConfirmIng)
						.addComponent(btnRejectIng)
						.addComponent(btnRejectRes)
						.addComponent(btnConfirmRes))
					.addGap(60))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
