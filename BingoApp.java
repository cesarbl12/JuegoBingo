package Bingo;

import javax.swing.*;

public class BingoApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear una instancia de la ventana de selección de patrón
            Patron patronesWindow = new Patron();

            // Establecer un listener para manejar la selección de patrones
            patronesWindow.setPatternSelectionListener(selectedPatternIndex -> {
                // Crear la instancia de BingoGrid con el patrón seleccionado
                SwingUtilities.invokeLater(() -> new BingoGrid(selectedPatternIndex));
            });

            patronesWindow.setVisible(true);
        });
    }
}
