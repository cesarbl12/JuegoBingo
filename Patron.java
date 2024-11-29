package Bingo;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.function.Consumer;

public class Patron extends JFrame {

    private static final String IMAGE_DIRECTORY = "C:\\Users\\cesar\\OneDrive\\Escritorio\\POO\\Bingo\\Patrones";
    private int selectedPatternIndex = -1; // Variable de instancia para almacenar el índice del patrón seleccionado
    private Consumer<Integer> patternSelectionListener; // Listener para manejar la selección de patrones

    public Patron() {
        // Configuración de la ventana
        setTitle("Patrones Bingo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800); // Tamaño de la ventana
        setLayout(new GridLayout(0, 8, 10, 10)); // 8 columnas, espaciado entre componentes
        getContentPane().setBackground(new Color(245, 245, 245)); // Fondo gris claro

        // Agregar las imágenes y botones
        for (int i = 1; i <= 38; i++) {
            String imagePath = IMAGE_DIRECTORY + "\\" + i + ".png";
            File imageFile = new File(imagePath);

            if (imageFile.exists()) {
                // Escalar la imagen
                ImageIcon originalIcon = new ImageIcon(imagePath);
                Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);

                // Crear un JLabel para la imagen
                JLabel imageLabel = new JLabel(scaledIcon);
                imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

                // Crear un botón pequeño con diseño moderno
                JButton button = new JButton("P " + i);
                button.setFont(new Font("Roboto", Font.BOLD, 10)); // Fuente moderna
                button.setBackground(new Color(30, 136, 229)); // Azul claro
                button.setForeground(Color.WHITE); // Texto blanco
                button.setFocusPainted(false); // Sin borde de enfoque

                // Capturar el valor de i en una variable final
                final int patternIndex = i - 1;  // Ajuste para base 0

                // Agregar un ActionListener al botón
                button.addActionListener(e -> {
                    // Guardar el índice del patrón seleccionado
                    selectedPatternIndex = patternIndex;  // Usar la variable final

                    // Mostrar el mensaje con el índice correcto
                    JOptionPane.showMessageDialog(this, "Seleccionaste el Patrón " + (patternIndex + 1), "Patrón Seleccionado", JOptionPane.INFORMATION_MESSAGE);
                    
                    // Crear la instancia de BingoGrid y pasar el índice del patrón seleccionado
                    new BingoGrid(selectedPatternIndex);  // Aquí pasas el patrón al BingoGrid
                    setVisible(false); // Ocultar la ventana de patrones después de hacer la selección
                });

                // Crear un panel con borde para agrupar el botón y la imagen (ahora el botón está encima)
                JPanel panel = new JPanel(new BorderLayout());
                panel.setBackground(Color.WHITE); // Fondo blanco para destacar
                panel.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220))); // Borde gris claro
                panel.add(button, BorderLayout.NORTH); // Agregar el botón encima de la imagen
                panel.add(imageLabel, BorderLayout.CENTER); // Agregar la imagen debajo del botón

                // Agregar el panel al JFrame
                add(panel);
            } else {
                System.out.println("Imagen no encontrada: " + imagePath);
            }
        }

        // Mostrar la ventana
        setVisible(true);
    }

    // Método para establecer el listener
    public void setPatternSelectionListener(Consumer<Integer> listener) {
        this.patternSelectionListener = listener;
    }

    // Método para obtener el índice del patrón seleccionado
    public int getSelectedPatternIndex() {
        return selectedPatternIndex;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Patron());
    }
}
