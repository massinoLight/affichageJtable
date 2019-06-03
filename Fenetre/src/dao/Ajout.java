package dao;






import java.sql.*;
import java.util.Calendar;

import javax.swing.JOptionPane;
public class Ajout
{
	JOptionPane jop1, jop2, jop3;

  public Ajout(String s,String ss,String sss)
  {
    try
    {
      Connect c=new Connect();
      Connection conn = DriverManager.getConnection(c.url,c.user,c.passwd);
    
      // create a sql date object so we can use it in our INSERT statement
      Calendar calendar = Calendar.getInstance();
      java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

      // the mysql insert statement
      String query = " insert into Client (nom,numero,sexe)"
        + " values (?, ?, ?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setString (1, s);
      preparedStmt.setString (2, ss);
      preparedStmt.setString (3, sss);
      

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
