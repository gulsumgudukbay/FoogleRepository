package uiManagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import restaurantAndFoodManagement.Food;
import restaurantAndFoodManagement.Ingredient;
import restaurantAndFoodManagement.Restaurant;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class SearchResultsScreen extends JFrame {

	private JPanel contentPane;
	private JList lstResults;
	private JLabel lblResults;
	private JScrollPane scrResults;
	private JPanel panel;
	
	//Component Models
	DefaultListModel<Food> searchList = new DefaultListModel<Food>();
	private ArrayList<Food> myTestIngList;
	private ArrayList<Ingredient> testlistDessert;
	private JButton btnFinish;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchResultsScreen frame = new SearchResultsScreen();
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
	public SearchResultsScreen() {
		initComponents();
		createEvents();
	
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setPreferredSize(new Dimension(1440,800));
	    getContentPane().add(contentPane, BorderLayout.CENTER);
	    
	    panel = new JPanel();
	    panel.setBackground(new Color(250, 240, 230));
	    panel.setBorder(new TitledBorder(null, "SearchResults", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	    
	    button = new JButton("Back");
	    button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    button.setIcon(new ImageIcon(SearchResultsScreen.class.getResource("/resources/back_64.png")));
	    button.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
	    
	    btnFinish = new JButton("");
	    btnFinish.setIcon(new ImageIcon(SearchResultsScreen.class.getResource("/resources/finish.png")));
	    btnFinish.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    GroupLayout gl_contentPane = new GroupLayout(contentPane);
	    gl_contentPane.setHorizontalGroup(
	    	gl_contentPane.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_contentPane.createSequentialGroup()
	    			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_contentPane.createSequentialGroup()
	    					.addGap(384)
	    					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 495, GroupLayout.PREFERRED_SIZE))
	    				.addGroup(gl_contentPane.createSequentialGroup()
	    					.addGap(37)
	    					.addComponent(button, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
	    			.addContainerGap(44, Short.MAX_VALUE))
	    		.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
	    			.addContainerGap(1251, Short.MAX_VALUE)
	    			.addComponent(btnFinish, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
	    			.addGap(33))
	    );
	    gl_contentPane.setVerticalGroup(
	    	gl_contentPane.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_contentPane.createSequentialGroup()
	    			.addGap(20)
	    			.addComponent(button, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
	    			.addPreferredGap(ComponentPlacement.RELATED)
	    			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
	    			.addPreferredGap(ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
	    			.addComponent(btnFinish, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
	    			.addGap(51))
	    );
	    
	    scrResults = new JScrollPane();
	    
	    lblResults = new JLabel("Results:");
	    GroupLayout gl_panel = new GroupLayout(panel);
	    gl_panel.setHorizontalGroup(
	    	gl_panel.createParallelGroup(Alignment.LEADING)
	    		.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
	    			.addContainerGap(39, Short.MAX_VALUE)
	    			.addComponent(lblResults)
	    			.addPreferredGap(ComponentPlacement.UNRELATED)
	    			.addComponent(scrResults, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap())
	    );
	    gl_panel.setVerticalGroup(
	    	gl_panel.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_panel.createSequentialGroup()
	    			.addGap(71)
	    			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
	    				.addComponent(lblResults)
	    				.addComponent(scrResults, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE))
	    			.addContainerGap(15, Short.MAX_VALUE))
	    );
	    
	    lstResults = new JList(searchList);
	    scrResults.setViewportView(lstResults);
	    panel.setLayout(gl_panel);
	    contentPane.setLayout(gl_contentPane);
	    pack();
	    
	  //test list for getting ingredient array list
	  	testlistDessert = new ArrayList<Ingredient>();
	  	testlistDessert.add(new Ingredient("dondurma"));
	  	testlistDessert.add(new Ingredient("cikolata"));
	  	testlistDessert.add(new Ingredient("krokan"));
	  	testlistDessert.add(new Ingredient("karamel")); 
	  		
	    myTestIngList = new ArrayList<Food>();
	    myTestIngList.add(new Food("waffle",10.25,testlistDessert));
	    myTestIngList.add(new Food("tiramisu",10.25,testlistDessert));
	    myTestIngList.add(new Food("kek",10.25,testlistDessert));
		initSearchList(myTestIngList);
	}
	
	private void initSearchList(ArrayList<Food> ingList) {
		for(int i=0;i<ingList.size();i++)
			searchList.addElement(new Food(ingList.get(i).getName(),ingList.get(i).getPrice(),ingList.get(i).getIngredients()));
	}

	private void createEvents() {
		
		lstResults.setCellRenderer(new DefaultListCellRenderer(){
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus){
			Component renderer = (Component) super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
			if(renderer instanceof JLabel && value instanceof Food){
				((JLabel) renderer).setText(((Food) value).getName() + "-" + ((Food) value).getPrice() + "-" + ((Food) value).listToString());
			}
			return renderer;
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
	}
}
