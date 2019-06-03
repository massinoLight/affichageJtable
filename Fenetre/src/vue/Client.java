package vue;
import dao.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
  
public class Client extends JFrame {
  private JPanel container = new JPanel();
 
  JOptionPane jop1, jop2, jop3;

  private JTextField nom = new JTextField("  ");
  private JTextField num = new JTextField("  ");
  private JLabel label1 = new JLabel("Nom :");
  private JLabel label2 = new JLabel("Numero :");
  private ButtonGroup bg =	new ButtonGroup();
  private JButton Ajouter = new JButton ("Ajouter");
  private JButton Afficher = new JButton ("Afficher");
  private JButton Supprimer = new JButton ("Supprimer");
  private JButton annuler = new JButton ("Annuler");
  
  
  JPanel bas = new JPanel();
  JPanel centre = new JPanel();
  JPanel top = new JPanel();
  JPanel droite = new JPanel();
  JPanel gauche = new JPanel(); 
  private Thread t;
  
  String[] sexeS = new String[] {"homme","femme","enfant"};
  
  
  
	JComboBox<String> sexe = new JComboBox<>(sexeS);
	String HF;
	


	 JTable tab = new JTable();
	 JScrollPane p=new JScrollPane(tab);
	 JScrollPane pane = new JScrollPane(tab);

  public Client(){
    this.setTitle("Ajouter Client");
    this.setSize(500, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(new BorderLayout());
   
   
   
    
   
    
    nom.setPreferredSize(new Dimension(80, 20));
    num.setPreferredSize(new Dimension(80, 20));
    centre.add(label1);
    centre.add(nom);
    centre.add(label2);
    centre.add(num);
    centre.add(sexe);
    
   // p.add();
    HF= (String) sexe.getSelectedItem();
    
   
   
    bas.add(Ajouter);
    bas.add(Afficher);
    bas.add(Supprimer);
    bas.add(annuler);
    Ajouter.addActionListener(new BoutonListenerAjout());
    Afficher.addActionListener(new BoutonListenerAffiche());
    Supprimer.addActionListener(new BoutonListenerSupprimer());
    annuler.addActionListener(new BoutonListenerannuler());

    
    container.add(top, BorderLayout.NORTH);
    container.add(centre, BorderLayout.CENTER);

    
    container.add(bas, BorderLayout.SOUTH);
    this.setContentPane(container);
    this.setVisible(true);            
  }       
        
  
  
  class BoutonListenerAjout implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	
	    	
	    	String numero=num.getText();
	    	String nomc=nom.getText();
	    	String sexe=HF;
	    	
	    	Ajout a=new Ajout(nomc, numero,sexe);
	    	jop1 = new JOptionPane();

	    	jop1.showMessageDialog(null, "Ajouté avec succé", "Information", JOptionPane.INFORMATION_MESSAGE);

	    }
}
  class BoutonListenerSupprimer implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	
	    	
	    	
	    	String nomc=nom.getText();
	    	
	    	
	    	Supprime a=new Supprime(nomc);
	    	jop1 = new JOptionPane();
	    	jop2 = new JOptionPane();

	    	jop1.showMessageDialog(null, "Voulez vous vraiment Supprimer "+nomc+" de vos clients", "Attention", JOptionPane.WARNING_MESSAGE);
	    	System.out.println("bien supprimé");
	    	jop2.showMessageDialog(null, "Supprimé avec succé", "Information", JOptionPane.INFORMATION_MESSAGE);
	    	
	    }
}
  class BoutonListenerannuler implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	     nom.setText(" ");
	     num.setText(" ");
	    }
}
  
  
  
  
  class BoutonListenerAffiche implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	Affiche aa=new Affiche();
	    	//tab=aa.Setres();
	    	 t = new Thread(new Affiche());
	    	 t.start();
	    	
	    	
	    }
}
  
  
  
  
}