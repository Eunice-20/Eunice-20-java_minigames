// package Jeux_Java;

//     import javax.swing.*;
//     import java.awt.*;
//     import java.awt.event.ActionEvent;
//     import java.awt.event.ActionListener;
//     import java.util.Random;
    
//     public class Sudoku extends JFrame {
    
//         private JPanel sudokuPanel;
//         private JTextField[][] sudokuCells;
//         private JButton checkButton;
//         private JLabel statusLabel;
//         private int[][] solution;
    
//         public Sudoku() {
//             setTitle("Sudoku");
//             setSize(400, 400);
//             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//             setLocationRelativeTo(null);
    
//             sudokuPanel = new JPanel(new GridLayout(9, 9));
//             sudokuCells = new JTextField[9][9];
//             solution = generateSolution(); // Generating a solution for the puzzle
    
//             // Initializing sudoku cells and adding them to the panel
//             for (int i = 0; i < 9; i++) {
//                 for (int j = 0; j < 9; j++) {
//                     sudokuCells[i][j] = new JTextField();
//                     sudokuCells[i][j].setHorizontalAlignment(JTextField.CENTER);
//                     sudokuPanel.add(sudokuCells[i][j]);
//                 }
//             }
    
//             checkButton = new JButton("Check");
//             statusLabel = new JLabel("");
    
//             // Adding action listener to the check button
//             checkButton.addActionListener(new ActionListener() {
//                 @Override
//                 public void actionPerformed(ActionEvent e) {
//                     if (isValid()) {
//                         statusLabel.setText("Sudoku is solved correctly!");
//                     } else {
//                         statusLabel.setText("Invalid Sudoku!");
//                     }
//                 }
//             });
    
//             JPanel bottomPanel = new JPanel();
//             bottomPanel.add(checkButton);
//             bottomPanel.add(statusLabel);
    
//             add(sudokuPanel, BorderLayout.CENTER);
//             add(bottomPanel, BorderLayout.SOUTH);
    
//             setVisible(true);
//         }
    
//         // Function to generate a random sudoku solution
//         private int[][] generateSolution() {
//             // Implementation of generating a random solution goes here
//             // For simplicity, let's just return a pre-defined solution
//             int[][] solution = {
//                     {5, 3, 4, 6, 7, 8, 9, 1, 2},
//                     {6, 7, 2, 1, 9, 5, 3, 4, 8},
//                     {1, 9, 8, 3, 4, 2, 5, 6, 7},
//                     {8, 5, 9, 7, 6, 1, 4, 2, 3},
//                     {4, 2, 6, 8, 5, 3, 7, 9, 1},
//                     {7, 1, 3, 9, 2, 4, 8, 5, 6},
//                     {9, 6, 1, 5, 3, 7, 2, 8, 4},
//                     {2, 8, 7, 4, 1, 9, 6, 3, 5},
//                     {3, 4, 5, 2, 8, 6, 1, 7, 9}
//             };
//             return solution;
//         }
    
//         // Function to check if the current sudoku configuration is valid
//         private boolean isValid() {
//             int[][] currentConfiguration = new int[9][9];
    
//             // Reading the current configuration from the text fields
//             for (int i = 0; i < 9; i++) {
//                 for (int j = 0; j < 9; j++) {
//                     String text = sudokuCells[i][j].getText();
//                     if (!text.isEmpty()) {
//                         currentConfiguration[i][j] = Integer.parseInt(text);
//                     } else {
//                         currentConfiguration[i][j] = 0;
//                     }
//                 }
//             }
    
//             // Checking rows, columns, and 3x3 squares for duplicates
//             for (int i = 0; i < 9; i++) {
//                 if (!isValidSet(currentConfiguration[i]) || !isValidSet(getColumn(currentConfiguration, i)) ||
//                         !isValidSet(getSquare(currentConfiguration, i))) {
//                     return false;
//                 }
//             }
    
//             return true;
//         }
    
//         // Function to check if a set of 9 numbers is valid (no duplicates)
//         private boolean isValidSet(int[] set) {
//             boolean[] seen = new boolean[10];
//             for (int num : set) {
//                 if (num != 0 && seen[num]) {
//                     return false;
//                 }
//                 seen[num] = true;
//             }
//             return true;
//         }
    
//         // Function to get a column from the sudoku grid
//         private int[] getColumn(int[][] grid, int col) {
//             int[] column = new int[9];
//             for (int i = 0; i < 9; i++) {
//                 column[i] = grid[i][col];
//             }
//             return column;
//         }
    
//         // Function to get a 3x3 square from the sudoku grid
//         private int[] getSquare(int[][] grid, int square) {
//             int[] squareArray = new int[9];
//             int rowOffset = (square / 3) * 3;
//             int colOffset = (square % 3) * 3;
//             int index = 0;
//             for (int i = rowOffset; i < rowOffset + 3; i++) {
//                 for (int j = colOffset; j < colOffset + 3; j++) {
//                     squareArray[index++] = grid[i][j];
//                 }
//             }
//             return squareArray;
//         }
    
//         public static void main(String[] args) {
//             new Sudoku();
//         }
//     }
    