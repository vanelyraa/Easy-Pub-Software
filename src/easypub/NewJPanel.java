/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypub;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import java.awt.Menu;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author vanel
 */
public class NewJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public NewJPanel() {
        initComponents();
        initComponents1();
        
    }
    
     Connection cnct = null;
    
    
	 /* Method for getting data from the database which are food names and prices to
	 * create a Menu object.
	
	 */

    /**
     *
     * @param drinktype
     *
     * @return
     */

    public class Menu{
        String name;
        int price; 
        String category;
      
        private Menu(String name, int price, String category) {
      this.name = name;
      this.price = price;
      this.category = category;
    }
    public String getName() {
      return name;
    }
    public int getCost() {
      return price;
    }
    
    public String getCategory() {
      return category;
    }
    @Override
    public String toString() {
      return name;
    }
  };
	
    /**
     *
     * @return
     */
    public List<Menu> getDrinkInfo(String drinktype) {
    List<Menu> tmp = new ArrayList<>();

		
		PreparedStatement stmt = null;
		try {
			stmt = cnct.prepareStatement("SELECT * FROM " + drinktype);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String prod = rs.getString("name");
				int price = rs.getInt("price");
                                String catg = rs.getString("category");
				

				
				String categorie=rs.getString("categorie");

				Menu mn = new Menu(prod,price,catg);

				tmp.add(mn);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return tmp;
	}

    
    // am using an enum here as a quick and dirty way to associate
  // a lunch meat with a cost, but an arraylist of some other
  // class can easily be used instead
  enum LunchMeats {
    PASTRAMI("Pastrami", 8),
    BOLOGNA("Bologna", 5),
    SALAMI("Salami", 8),
    HAM("Ham", 6),
    ROAST_BEEF("Roast Beef", 10),
    CHICKEN_BREAST("Chicken Breast", 7),
    TURKEY_BREAST("Turkey", 7),
    CORNED_BEEF("Corned Beef", 9),
    PROSCIUTTO("Prosciutto", 12),
    PEPPERONI("Pepperoni", 9);
     
    private String name;
    private int cost;
    private LunchMeats(String name, int cost) {
      this.name = name;
      this.cost = cost;
    }
    public String getName() {
      return name;
    }
    public int getCost() {
      return cost;
    }
    @Override
    public String toString() {
      return name;
    }
  };
  
  private void initComponents1() {
    // redundant but for clarification
   // getDrinkInfo=this.add();
    LunchMeats[] lunchMeats = LunchMeats.values();
     
    // give panel an empty border to make less crowded
    setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
     
    // give panel a gridlayout so as to neatly lay out the buttons.
    // the first param of 0 means any number of rows.
    // the second param is the number of columns
    // the last two params are the horizontal and vertical gaps
    // between laid out elements.
    setLayout(new GridLayout(0, lunchMeats.length/2, 10, 10));
     
    // final variable so it can be used inside of an inner class
    for (final LunchMeats lunchMeat : lunchMeats) {
       
      // first create button
      JButton button = new JButton(lunchMeat.getName());
      add(button); // now add to jpanel
       
      // now add anonymous action listener
      button.addActionListener(new ActionListener() {
 
        public void actionPerformed(ActionEvent e) {
          String output = "You chose " + lunchMeat.getName() + " which costs $"
              + lunchMeat.getCost();
          System.out.println(output);
        }
      });
 
    }
  }
   
  private static void createAndShowUI() {
    JFrame frame = new JFrame("AddCompanyRates");
    frame.getContentPane().add(new NewJPanel());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
 
  public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        createAndShowUI();
      }
    });
  }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

/*
 public void bill()
    {
        String total = jTextArea1.getText();
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel)tableSale.getModel(); 
        jTextArea1.setText(jTextArea1.getText() + "****************************************************************\n");
        jTextArea1.setText(jTextArea1.getText() + "                               POSBILL                          \n");
        jTextArea1.setFont(jTextArea1.getFont().deriveFont(Font.BOLD, 13f));

        jTextArea1.setText(jTextArea1.getText() + "****************************************************************\n");   
         //Heading
          jTextArea1.setText(jTextArea1.getText() + "Product" + "\t" + "Price" + "\t" + "Amount" + "\n"  ); 
          
          
        
          for(int i = 0; i < model.getRowCount(); i++)
          {              
              String pname = (String)model.getValueAt(i, 0);
              int price = (Integer)model.getValueAt(i, 1);
              int amount = (Integer)model.getValueAt(i, 3);        
              jTextArea1.setText(jTextArea1.getText() + pname  + "\t" + price + "\t" + amount  + "\n"  );
          }   
          jTextArea1.setText(jTextArea1.getText() + "\n");       
          jTextArea1.setText(jTextArea1.getText() + "\t" +  "Subtotal : " + total + "\n");
          jTextArea1.setText(jTextArea1.getText() + "\n");
          jTextArea1.setText(jTextArea1.getText() + "**************************************************************\n");
          jTextArea1.setText(jTextArea1.getText() + "           THANK YOU COME AGAIN             \n");
    }
*/