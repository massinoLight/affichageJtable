package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class Connect {
	//change ici le chemin de ta base de donnée mysql
	String url = "jdbc:mysql://localhost/LaboPhoto";
    String user = "root";
    String passwd = "";
public  Connect(){
	
  try {
    Class.forName("com.mysql.jdbc.Driver");
    System.out.println("Driver O.K.");

    
    Connection conn = DriverManager.getConnection(url, user, passwd);

    
    System.out.println("Connexion effective !");         
  
  } catch (Exception e) {
    e.printStackTrace();
  }      
}




}

