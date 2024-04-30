 package Jeux_Java;

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
 import java.io.IOException;
 import java.nio.file.Files;
 import java.nio.file.Paths;
 import java.util.ArrayList;
 import java.util.Random;

 public class Hangman extends JFrame {

     private String[] mots;
     private String motSecret;
     private ArrayList<Character> lettresIncorrectes = new ArrayList<>();  
     private StringBuilder motCache; 
     private int tentativesMax = 6;  
     private int tentativesRestantes;  
     private int score; 
     private JLabel motCacheLabel, lettresIncorrectesLabel, HangmanLabel, scoreLabel, statutLabel;
     private JTextField lettreField;
     private JButton guessButton, restartButton;

     public static void main(String[] args) {
        new Hangman();
    }

     public Hangman() {
         setTitle("Jeu du Hangman");
         setSize(400, 400);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);

         initWords();
         initGame();
           
    
         JPanel panel = new JPanel(new GridLayout(6, 1));

         motCacheLabel = new JLabel(motCache.toString(), SwingConstants.CENTER);
         panel.add(motCacheLabel);

         lettresIncorrectesLabel = new JLabel("Lettres incorrectes: ", SwingConstants.CENTER);
         panel.add(lettresIncorrectesLabel);

         HangmanLabel = new JLabel("", SwingConstants.CENTER);
         panel.add(HangmanLabel);

         lettreField = new JTextField(1);
         panel.add(lettreField);

         guessButton = new JButton("Devinez !");
         guessButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 devinerLettre();
             }
         });
         panel.add(guessButton);
         System.out.println(motSecret);


         scoreLabel = new JLabel("Score: " + score, SwingConstants.CENTER);
         panel.add(scoreLabel);

         statutLabel = new JLabel("", SwingConstants.CENTER);
         panel.add(statutLabel);

         add(panel);
         setVisible(true);
     }

     private void initGame() {
        
         Random random = new Random();
         motSecret = mots[random.nextInt(mots.length)];
         motCache = new StringBuilder();
         for (int i = 0; i < motSecret.length(); i++) {
             motCache.append("-");
         }
         tentativesRestantes = tentativesMax;
         score = 0;
     }
      private void initWords() {
         try {
            mots = Files.readAllLines(Paths.get("./Game/Jeux_Java/file.txt/fileHangman.txt")).toArray(new String[0]);

         } catch (IOException e) {
             e.printStackTrace();
             JOptionPane.showMessageDialog(this, "Erreur lors de la lecture du fichier de mots.");
             System.exit(1);
         }
     }

     private void devinerLettre() {
         char lettre = lettreField.getText().toUpperCase().charAt(0);
         lettreField.setText("");

         if (!Character.isLetter(lettre)) {
             JOptionPane.showMessageDialog(this, "Veuillez entrer une lettre valide.");
             return;
         }
         if (lettresIncorrectes.contains(lettre) || motCache.indexOf(String.valueOf(lettre)) != -1) {
             JOptionPane.showMessageDialog(this, "Vous avez déjà deviné cette lettre.");
             return;
         }
         if (motSecret.indexOf(lettre) != -1) {
             for (int i = 0; i < motSecret.length(); i++) {
                 if (motSecret.charAt(i) == lettre) {
                     motCache.setCharAt(i, lettre);
                 }
             }
             if (motCache.indexOf("-") == -1) {
                 statutLabel.setText("Vous avez gagné !");
                 score += tentativesRestantes * 10;
                 scoreLabel.setText("Score: " + score);
                 guessButton.setEnabled(false);
             }
         } else {
             lettresIncorrectes.add(lettre);
             HangmanLabel.setText("Nombre de tentatives restantes: " + --tentativesRestantes);
             lettresIncorrectesLabel.setText("Lettres incorrectes: " + lettresIncorrectes.toString());
             if (tentativesRestantes == 0) {
                 statutLabel.setText("Vous avez perdu. Le mot était: " + motSecret);
                 guessButton.setEnabled(false);
             }
         }
         motCacheLabel.setText(motCache.toString());
     }

 }
