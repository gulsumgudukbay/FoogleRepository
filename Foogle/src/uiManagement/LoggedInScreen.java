package uiManagement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// IMAGE EKLENECEK

public class LoggedInScreen extends JFrame {
	
	private JPanel contentPane;
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				
				try 
				{
					LoggedInScreen frame = new LoggedInScreen();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}	
	
	public LoggedInScreen() {
		initComponents();
	}
	
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Restaurant Owner");
		setBounds(200, 200, 1440, 800);
		
		setResizable(false);
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(250, 240, 230));
		
		JButton btnAddRes = new JButton("Add a Restaurant");
		btnAddRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddRestaurantScreen addResScreen = new AddRestaurantScreen();
				addResScreen.setVisible(true);
				dispose();
			}
		});
		
		btnAddRes.setBounds(371, 149, 199, 56);
		getContentPane().add(btnAddRes);
		
		
		JButton btnAddFood = new JButton("Add Food");
		btnAddFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddFoodScreen addFoodScreen = new AddFoodScreen();
				addFoodScreen.setVisible(true);
				dispose();
			}
		});
		
		btnAddFood.setBounds(371, 217, 199, 56);
		getContentPane().add(btnAddFood);
		
		
		JButton btnMyAcc = new JButton("My Account");
		btnMyAcc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyAccountScreen myAccScreen = new MyAccountScreen();
				myAccScreen.setVisible(true);
				dispose();
			}
		});
		
		btnMyAcc.setBounds(1264, 20, 133, 42);
		getContentPane().add(btnMyAcc);
		
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu mainMenu = new MainMenu();
				mainMenu.setVisible(true);
				dispose();
			}
		});
		
		btnLogout.setBounds(1264, 82, 133, 42);
		getContentPane().add(btnLogout);
		
		
		btnLogout.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnMyAcc.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAddFood.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnAddRes.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
	}
}
