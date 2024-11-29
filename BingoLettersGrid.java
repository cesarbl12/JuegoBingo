package Bingo;

import javax.swing.*;
import java.awt.*;

public class BingoLettersGrid {

    JFrame frame;
    private JPanel panel;
    private JLabel[][] labels;

    public BingoLettersGrid() {
        frame = new JFrame("Bingo Letters Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 400);  // Tamaño ajustado para mayor visibilidad

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 15, 10, 10));  // Espaciado entre celdas
        panel.setBackground(new Color(240, 240, 240));  // Fondo suave
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        labels = new JLabel[5][15];

        String[] letters = {"B", "I", "N", "G", "O"};
        for (int row = 0; row < 5; row++) {
            JLabel letterLabel = new JLabel(letters[row], SwingConstants.CENTER);
            letterLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));  // Fuente moderna
            letterLabel.setForeground(new Color(0, 51, 204));  // Azul oscuro para las letras
            letterLabel.setOpaque(true);
            letterLabel.setBackground(new Color(255, 255, 255));
            letterLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
            panel.add(letterLabel);

            for (int col = 0; col < 15; col++) {
                labels[row][col] = new JLabel(String.valueOf(col + 1 + row * 15), SwingConstants.CENTER);
                labels[row][col].setFont(new Font("Segoe UI", Font.PLAIN, 18));
                labels[row][col].setForeground(new Color(0, 0, 0));  // Texto negro
                labels[row][col].setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200))); // Borde suave
                labels[row][col].setOpaque(true);
                labels[row][col].setBackground(new Color(255, 255, 255));  // Fondo blanco
                labels[row][col].setPreferredSize(new Dimension(50, 50));  // Tamaño consistente para las celdas
                panel.add(labels[row][col]);
            }
        }

        frame.add(panel);
        frame.setVisible(true);
    }

    public void markNumber(int number) {
        int letterIndex = (number - 1) / 15;
        int numberIndex = (number - 1) % 15;

        JLabel label = labels[letterIndex][numberIndex];
        // Animación suave: cambia el color a rojo con un retraso
        new Timer(200, e -> {
            label.setForeground(Color.RED);
            label.setBackground(new Color(255, 240, 240));  // Fondo suave cuando está marcado
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BingoLettersGrid::new);
    }
}
