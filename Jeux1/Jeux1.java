package Jeux1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Jeux1 {

    public static void main(String[] args) {
        Jeux1();
    }

    public static void Jeux1() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(1000) + 1;
        System.err.println(randomNumber);

        JFrame frame = new JFrame("Jeux du + ou - ");
        JLabel label = new JLabel("Consigne : vous disposez de 3 tentatives avant la fin du jeu", JLabel.CENTER);
        JTextField textField = new JTextField(18);

        frame.add(label);
        frame.add(textField);

        JPanel panel = new JPanel();

        JButton leave = new JButton("Quitter");
        JButton btnD = new JButton("Devinez");

        panel.add(textField);
        panel.add(leave);
        panel.add(btnD);

        frame.setLayout(new GridLayout(3, 1)); // Utilisation d'une grille 3x1
        btnD.setBackground(Color.PINK);

        frame.add(label);
        frame.add(panel);

        frame.pack();
        frame.setSize(300, 300); // Réglage de la taille du cadre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        int score = 0;

        leave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                textField.setText("");
            }
        });

        btnD.addActionListener(new ActionListener() {
            int time = 0;
            int score = 0;
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    int guess = Integer.parseInt(textField.getText());
                    time ++;

                    if ( time <= 3) {
                        System.out.println("Nombre de l'utilisateur : " + guess);

                        if (guess >= 1 && guess <= 1000) {
                            if (guess == randomNumber) {
                            
                                score += 2; 
                                JOptionPane.showMessageDialog(null, "Bravo ! Vous avez deviné le nombre secret ! Votre score est : " + score);
                            } else if (guess < randomNumber) {
                                JOptionPane.showMessageDialog(null, "Le nombre secret est plus grand !");
                            } else {
                                JOptionPane.showMessageDialog(null, "Le nombre secret est plus petit !");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Veuillez saisir un nombre entre 1 et 1000.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Nombre maximum de tentatives atteint. Le nombre secret était " + randomNumber);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Veuillez saisir un nombre valide.");
                }
            }
        });
    }

    private static void addActionListener(ActionListener actionListener) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addActionListener'");
    }
}

