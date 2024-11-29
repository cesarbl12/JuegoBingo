package Bingo;

import javax.imageio.plugins.tiff.ExifTIFFTagSet;
import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BingoGrid extends PatronesData implements Mensaje{

    private int[][] patronSeleccionado;
    private int[][] tablero;
    private int selectedPatternIndex;
    private int remainingTurns; // Giros restantes

    protected static HashSet<Integer> drawnNumbers = new HashSet<>(); // Números ya sorteados
    private JLabel[][] labels; // Matriz de etiquetas para mostrar los números
    private BingoLettersGrid bingoLettersGrid; // Referencia a 
    
    private List<Integer> remainingNumbers;

    // Constructor
    public BingoGrid(int selectedPatternIndex) {
        this.selectedPatternIndex = selectedPatternIndex;
        this.tablero = new int[5][5];
        this.labels = new JLabel[6][5]; // 6 filas (incluye encabezado), 5 columnas
        setPatronSeleccionado();
        promptForTurns();  // Pedir al usuario la cantidad de giros
    }

    // Solicitar al usuario cuántas veces girará la tómbola
    private void promptForTurns() {
        // Cuadro de diálogo para pedir la cantidad de giros
        String input = JOptionPane.showInputDialog(null, "¿Cuántas veces girará la tómbola? (entre 5 y 75)", "Configuración de Giros", JOptionPane.QUESTION_MESSAGE);
        
        // Validación del input
        if (input != null) {
            try {
                int turns = Integer.parseInt(input);
                if (turns >= 5 && turns <= 75) {
                    remainingTurns = turns;
                    createAndShowGUI();  // Solo abrir la GUI si el valor es válido
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número entre 5 y 75.", "Error", JOptionPane.ERROR_MESSAGE);
                    promptForTurns();  // Volver a preguntar si el número es inválido
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                promptForTurns();  // Volver a preguntar si el valor no es un número
            }
        }
    }

    

    // Configurar el patrón seleccionado
    private void setPatronSeleccionado() {
        if (selectedPatternIndex < 0 || selectedPatternIndex > 38) {
            System.err.println("Índice de patrón inválido: " + selectedPatternIndex);
            return;
        }
    
        // Cargar el patrón desde el array de patrones, HERENCIA
        this.patronSeleccionado = super.getPatron(selectedPatternIndex);
    
        // Imprimir el patrón cargado para ver si está correcto
        System.out.println("Patrón seleccionado (índice " + (selectedPatternIndex - 1) + "):");
        for (int i = 0; i < patronSeleccionado.length; i++) {
            for (int j = 0; j < patronSeleccionado[i].length; j++) {
                System.out.print((patronSeleccionado[i][j] == 1 ? "X " : ". "));
            }
            System.out.println();
        }
    
        // Validar dimensiones del patrón
        if (patronSeleccionado.length != 5 || patronSeleccionado[0].length != 5) {
            throw new IllegalStateException("El patrón seleccionado no tiene dimensiones 5x5.");
        }
    
        // Validación de valores del patrón (solo 0 y 1 son permitidos)
        for (int[] row : patronSeleccionado) {
            for (int cell : row) {
                if (cell != 0 && cell != 1) {
                    throw new IllegalArgumentException("El patrón contiene valores inválidos. Solo se permiten 0 y 1.");
                }
            }
        }
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Bingo Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 5, 5, 5));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] header = {"B", "I", "N", "G", "O"};
        for (int i = 0; i < 5; i++) {
            JLabel label = new JLabel(header[i], SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 24));
            label.setForeground(Color.DARK_GRAY);
            label.setOpaque(true);
            label.setBackground(new Color(0, 153, 255));
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            panel.add(label);
            labels[0][i] = label;
        }

        Random rand = new Random();
        for (int row = 1; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                if (row == 3 && col == 2) {
                    JLabel label = new JLabel("FREE", SwingConstants.CENTER);
                    label.setFont(new Font("Arial", Font.BOLD, 24));
                    label.setBackground(Color.LIGHT_GRAY);
                    label.setOpaque(true);
                    label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    panel.add(label);
                    labels[row][col] = label;
                    tablero[row - 1][col] = -1; // Marcamos esta celda como usada
                } else {
                    int number = 0;
                    boolean isUnique = false;
                    while (!isUnique) {
                        if (col == 0) number = rand.nextInt(15) + 1;
                        else if (col == 1) number = rand.nextInt(15) + 16;
                        else if (col == 2) number = rand.nextInt(15) + 31;
                        else if (col == 3) number = rand.nextInt(15) + 46;
                        else if (col == 4) number = rand.nextInt(15) + 61;

                        if (!drawnNumbers.contains(number)) {
                            drawnNumbers.add(number);
                            isUnique = true;
                        }
                    }

                    JLabel label = new JLabel(String.valueOf(number), SwingConstants.CENTER);
                    label.setFont(new Font("Arial", Font.BOLD, 24));
                    label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    label.setOpaque(true);
                    label.setBackground(Color.WHITE);
                    panel.add(label);
                    labels[row][col] = label;
                    tablero[row - 1][col] = number;
                }
            }
        }

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(new Color(230, 230, 230));

        JButton girarButton = new JButton("Girar");
        girarButton.setFont(new Font("Arial", Font.BOLD, 18));
        girarButton.setForeground(Color.WHITE);
        girarButton.setBackground(new Color(0, 102, 204));
        rightPanel.add(girarButton, BorderLayout.NORTH);

        JLabel numberLabel = new JLabel("Número: ", SwingConstants.CENTER);
        numberLabel.setFont(new Font("Arial", Font.BOLD, 24));
        rightPanel.add(numberLabel, BorderLayout.CENTER);

        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.add(panel, BorderLayout.CENTER);
        containerPanel.add(rightPanel, BorderLayout.EAST);

        List<Integer> remainingNumbers = new ArrayList<>();
        for (int i = 1; i <= 75; i++) {
            remainingNumbers.add(i);
        }
        Collections.shuffle(remainingNumbers);

        girarButton.addActionListener(e -> {
            if (remainingTurns > 0) {
                remainingTurns--;
                int drawnNumber = remainingNumbers.get(remainingNumbers.size() - 1);
                remainingNumbers.remove(remainingNumbers.size() - 1);
                
                // Determinar la letra asociada al número
                String letter = "";
                if (drawnNumber >= 1 && drawnNumber <= 15) {
                    letter = "B-";
                } else if (drawnNumber >= 16 && drawnNumber <= 30) {
                    letter = "I-";
                } else if (drawnNumber >= 31 && drawnNumber <= 45) {
                    letter = "N-";
                } else if (drawnNumber >= 46 && drawnNumber <= 60) {
                    letter = "G-";
                } else if (drawnNumber >= 61 && drawnNumber <= 75) {
                    letter = "O-";
                }
                
                // Actualizar el número con la letra y el número
                numberLabel.setText(letter + drawnNumber);
        
                updateBoardColor(drawnNumber);  // Cambié el color a rojo como pediste
                
                if (bingoLettersGrid == null) {
                    bingoLettersGrid = new BingoLettersGrid(); // Asegúrate de crear la instancia de BingoLettersGrid
                }
                bingoLettersGrid.markNumber(drawnNumber);  // Usar markNumber en lugar de addDrawnNumber
            } else {
                JOptionPane.showMessageDialog(frame, "¡Se acabaron los giros! Has perdido.", "Fin del juego", JOptionPane.INFORMATION_MESSAGE);
                
                if (bingoLettersGrid != null) {
                    bingoLettersGrid.frame.dispose();  // Cerrar la ventana de BingoLettersGrid
                }
                
                SwingUtilities.invokeLater(() -> {
                    new MenuPrincipal().setVisible(true);
                });
                
                frame.dispose();  // Cerrar la ventana actual de BingoGrid
            }
        });
        

        frame.add(containerPanel);
        frame.setVisible(true);
    }

    private void updateBoardColor(int number) {
        for (int row = 1; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                if (tablero[row - 1][col] == number) {
                    labels[row][col].setBackground(Color.RED); // Color original: rojo
                    tablero[row - 1][col] = -1; // Marcamos esta celda como usada
                }
            }
        }
        
        // Verificar si el patrón está cumplido
        if (isPatternComplete()) {
            JOptionPane.showMessageDialog(null, "¡Felicidades! ¡Has ganado el Bingo!", "Victoria", JOptionPane.INFORMATION_MESSAGE);
            
            if (bingoLettersGrid != null) {
                    bingoLettersGrid.frame.dispose();  // Cerrar la ventana de BingoLettersGrid
                }
                
                SwingUtilities.invokeLater(() -> {
                    new MenuPrincipal().setVisible(true);
                });

                //mensajeError("Adios");                
                System.exit(0);
            
        }
    }
    
    // @Override
    // public void mensajeError(String mensaje){
    //     JOptionPane.showMessageDialog(null, mensaje, "Exit", JOptionPane.INFORMATION_MESSAGE);

    // }

    // Método para verificar si el patrón está cumplido
    private boolean isPatternComplete() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                // Si el patrón requiere un 1 pero la celda no está marcada (-1), el patrón no está completo
                if (patronSeleccionado[row][col] == 1 && tablero[row][col] != -1) {
                    return false;
                }
            }
        }
        return true; // Si todas las posiciones requeridas están marcadas, el patrón está completo
    }
    
    

    private void openBingoLettersGrid() {
        bingoLettersGrid = new BingoLettersGrid();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BingoGrid bingoGrid = new BingoGrid(1); // 1 es solo un ejemplo
        });
    }
}
