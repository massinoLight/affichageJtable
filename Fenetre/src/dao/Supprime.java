package dao;
import java.sql.*;
import java.util.Calendar;

import javax.swing.JOptionPane;
public class Supprime
{
	JOptionPane jop1, jop2, jop3;

  public Supprime(String s)
  {
    try
    {
      Connect c=new Connect();
      Connection conn = DriverManager.getConnection(c.url,c.user,c.passwd);
    
      // create a sql date object so we can use it in our INSERT statement
      Calendar calendar = Calendar.getInstance();
      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

      // the mysql insert statement
      /*String query1 = " insert into Client (nom,numero,sexe)"
        + " values (?, ?, ?)";*/
      String query = " DELETE FROM Client WHERE nom= ?";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setString (1, s);
     
      

      // execute the preparedstatement
      preparedStmt.execute();
      
      conn.close();
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
