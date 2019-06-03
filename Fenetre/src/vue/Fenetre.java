package vue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
  
public class Fenetre extends JFrame {
  private JPanel container = new JPanel();
  private JRadioButton homme = new JRadioButton("Homme");
  private JRadioButton femme= new JRadioButton("Femme");
  private JTextField nom = new JTextField("  ");
  //private JTextField num = new JTextField("  ");
  private JFormattedTextField num = new JFormattedTextField(NumberFormat.getPercentInstance());
  private JLabel label1 = new JLabel("Nom :");
  private JLabel label2 = new JLabel("Numero :");
  private ButtonGroup bg =	new ButtonGroup();
  private JButton ok = new JButton ("Ajouter");
  private JButton annuler = new JButton ("Annuler");

  

  public Fenetre(){
    this.setTitle("Ajouter Client");
    this.setSize(500, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(new BorderLayout());
    JPanel bas = new JPanel();
    JPanel centre = new JPanel();
    JPanel top = new JPanel();
    JPanel droite = new JPanel();
    JPanel gauche = new JPanel();
    homme.addActionListener(new StateListener());
    femme.addActionListener(new StateListener());
    bg.add(homme);
    bg.add(femme);
    nom.setPreferredSize(new Dimension(80, 20));
    num.setPreferredSize(new Dimension(80, 20));
    centre.add(label1);
    centre.add(nom);
    centre.add(label2);
    centre.add(num);
    centre.add(homme);
    centre.add(femme);
    bas.add(ok);
    bas.add(annuler);
    ok.addActionListener(new BoutonListenerok());
    annuler.addActionListener(new BoutonListenerannuler());

    
    container.add(top, BorderLayout.NORTH);
    container.add(centre, BorderLayout.CENTER);

    
    container.add(bas, BorderLayout.SOUTH);
    this.setContentPane(container);
    this.setVisible(true);            
  }       
        
  class StateListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      System.out.println("source : " + ((JRadioButton)e.getSource()).getText() + " - état : " + ((JRadioButton)e.getSource()).isSelected());
    }
   
  }
  
  class BoutonListenerok implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	      System.out.println("nom " + nom.getText());
	      System.out.println("num " + num.getText());
	    }
}
  
  class BoutonListenerannuler implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	     nom.setText(" ");
	     num.setText(" ");
	    }
}
  
  
  
  
}