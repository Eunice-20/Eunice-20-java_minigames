package Jeux_Java;
import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
  


public class gamepmp implements ActionListener {

public static String file = "score.txt"; 

public static JTextField nbj;

public static JLabel label;

public static JLabel label2;

 public static int tenta = 0;

public static int niv = 1;

public static int devine = (int)(Math.random() * 1000);




    public static void main(String[] args) 
        {
            JFrame frame = new JFrame("+ ou -");

            System.out.println(devine);
            
            label = new JLabel("Devine a quelle nombre je pense.", JLabel.CENTER);

            label2 = new JLabel("Plus ton score est bas, mieux c'est.");
            frame.add(label);
            frame.add(label2);
            JPanel panel = new JPanel();
            
            nbj = new JTextField(4);
            JButton valide = new JButton("valide");

            panel.add(valide);
            valide.addActionListener(new gamepmp());
            panel.add(nbj);

            frame.setLayout(new GridLayout(2, 1));

            frame.add(label);
            frame.add(panel);
            
            frame.pack();
            frame.setSize(500, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        }
        public void actionPerformed(ActionEvent e) {
            System.out.println("Le bouton a été cliqué !");
        
            String s = e.getActionCommand();
            if (s.equals("valide")) {
        
            int devi=Integer.parseInt(nbj.getText());

                System.out.print(nbj.getText());
        
                if(devi < devine)
                {
                label.setText("C'est plus.");
                label2.setText("");
                tenta ++;
                }
                else if(devi > devine)
                {
                label.setText("C'est moin.");
                label2.setText("");
                tenta ++;
                }
                else
                {
                tenta ++;
                niv ++;
                label.setText("C'est juste.\n ton score est de :" + tenta);
                label2.setText("Tu passe niveau " + niv);
                devine = (int)(Math.random() * 1000);
                System.out.println(devine);
                /*     new FileWriter(file);
                    File myObj = new File(file);  
                    if (myObj.createNewFile()) {  
                    System.out.println("File created: " + myObj.getName());  
                    } else {  
                    System.out.println("File already exists.");  
                    }
                    FileWriter fileWriter = new FileWriter(file);
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    printWriter.printf("Product name is %s and its price is %d $", "iPhone", 1000);
                printWriter.close();
                */
            }
            nbj.setText("");
        }

        }  
    }