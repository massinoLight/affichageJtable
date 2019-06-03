package dao;






import java.sql.*;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Affiche implements Runnable
{
	
	JOptionPane jop1, jop2, jop3;
	String query = " Select * FROM Client";
	PreparedStatement preparedStmt;
	ResultSet rs;
	String[] tableColumnsName = {"Nom","Num","Sexe"}; 
	JTable table ;


  /*public JTable  Setres() 
  {
	  try {
	    	
	    	String url = "jdbc:mysql://localhost/LaboPhoto";
	        String user = "root";
	        String passwd = "";
	                Class.forName("com.mysql.jdbc.Driver");
	    	        System.out.println("Driver O.K.");
	    	       Connection conn = DriverManager.getConnection(url, user, passwd);
                      System.out.println("Connexion effective !");         
	    	  
	    	    //Connection conn = DriverManager.getConnection(url, user, passwd);
	      String queryString = "SELECT * FROM Client";
	      Statement stm = conn.createStatement();
	      ResultSet rs = stm.executeQuery(queryString);
	      String col[] = { "Nom", "Numero", "Sexe" };
	      String cont[][] = new String[10][3];
	      int i = 0;
	      while (rs.next()) {
	    	  String id = rs.getString("Nom");
	        String nom = rs.getString("Numero");
	        String prenom = rs.getString("Sexe");
	        cont[i][0] = id + "";
	        cont[i][1] = nom;
	        cont[i][2] = prenom;
	        i++;
	      }
	      DefaultTableModel model = new DefaultTableModel(cont, col);
	      table = new JTable(model);
	      table.setShowGrid(true);
	      table.setShowVerticalLines(true);
	      JScrollPane pane = new JScrollPane(table);
	      JFrame frame = new JFrame("Les Clients enregistré");
	      JPanel panel = new JPanel();
	      panel.add(pane);
	      frame.add(panel);
	      frame.setSize(500, 500);
	      frame.setLocationRelativeTo(null);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setVisible(true);
	    }
    catch (Exception e)
    {
    	

    	jop3 = new JOptionPane();
    	jop3.showMessageDialog(null, "Exeption détécté", "Erreur", JOptionPane.ERROR_MESSAGE);        
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  
    return table;
  }
*/

@Override
public void run() {
	try {
		//change ici le chemin de ta base de donnée mysql
    	String url = "jdbc:mysql://localhost/LaboPhoto";
        String user = "root";
        String passwd = "";
                Class.forName("com.mysql.jdbc.Driver");
    	        System.out.println("Driver O.K.");
    	       Connection conn = DriverManager.getConnection(url, user, passwd);
                  System.out.println("Connexion effective !");         
    	  
    	    //Connection conn = DriverManager.getConnection(url, user, passwd);
      String queryString = "SELECT * FROM Client";
      
      Statement stm = conn.createStatement();
      ResultSet rs = stm.executeQuery(queryString);
      String col[] = { "Nom", "Numero", "Sexe" };
      String cont[][] = new String[100][3];
      int i = 0;
      
      while (rs.next()) {
    	  
    	  String nom = rs.getString("nom");
        String num = rs.getString("numero");
        String sexe = rs.getString("sexe");
        cont[i][0] = nom + "";
        cont[i][1] = num;
        cont[i][2] = sexe;
        i++;
      }
      
      DefaultTableModel model = new DefaultTableModel(cont, col);
      table = new JTable(model);
      table.setShowGrid(true);
      table.setShowVerticalLines(true);
      JScrollPane pane = new JScrollPane(table);
      JFrame frame = new JFrame("Les Clients enregistré");
      JPanel panel = new JPanel();
      panel.add(pane);
      frame.add(panel);
      frame.setSize(500, 500);
      frame.setLocationRelativeTo(null);
      //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
    }
catch (Exception e)
{
	

	jop3 = new JOptionPane();
	jop3.showMessageDialog(null, "Exeption détécté", "Erreur", JOptionPane.ERROR_MESSAGE);        
  System.err.println("Got an exception!");
  System.err.println(e.getMessage());
}

	
}
 
 
  
  
  
  
  
  
  
  
  
}
