package Bingo;

import java.util.List;

public class PatronesData {
    // Definir todos los patrones como matrices 5x5

    static final int[][] PATRON_1 = {
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0}
    };

    static final int[][] PATRON_2 = {
        {0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0},
        {0, 1, 0, 0, 0}
    };

    static final int[][] PATRON_3 = {
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0}
    };

    static final int[][] PATRON_4 = {
        {0, 0, 0, 1, 0},
        {0, 0, 0, 1, 0},
        {0, 0, 0, 1, 0},
        {0, 0, 0, 1, 0},
        {0, 0, 0, 1, 0}
    };

    static final int[][] PATRON_5 = {
        {0, 0, 0, 0, 1},
        {0, 0, 0, 0, 1},
        {0, 0, 0, 0, 1},
        {0, 0, 0, 0, 1},
        {0, 0, 0, 0, 1}
    };

    static final int[][] PATRON_6 = {
        {1, 0, 0, 0, 0},
        {0, 1, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0},
        {0, 0, 0, 0, 1}
    };

    static final int[][] PATRON_7 = {
        {1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };

    static final int[][] PATRON_8 = {
        {0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };

    static final int[][] PATRON_9 = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {1, 1, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };

    static final int[][] PATRON_10 = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1},
        {0, 0, 0, 0, 0}
    };

    static final int[][] PATRON_11 = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1}
    };

    static final int[][] PATRON_12 = {
        {0, 0, 0, 0, 1},
        {0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0},
        {1, 0, 0, 0, 0}
    };

    static final int[][] PATRON_13 = {
        {1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };

    static final int[][] PATRON_14 = {
        {0, 0, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };

    static final int[][] PATRON_15 = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {1, 1, 0, 0, 0}
    };
    static final int[][] PATRON_16 = {
        {0, 1, 1, 0, 0},
        {0, 1, 1, 0, 0},
        {0, 1, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };

    static final int[][] PATRON_17 = {
        {0, 0, 0, 0, 0},
        {0, 1, 1, 0, 0},
        {0, 1, 0, 0, 0},
        {0, 1, 1, 0, 0},
        {0, 0, 0, 0, 0}
    };

    static final int[][] PATRON_18 = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0},
        {0, 1, 1, 0, 0},
        {0, 1, 1, 0, 0}
    };

    static final int[][] PATRON_19 = {
        {0, 0, 1, 1, 0},
        {0, 0, 1, 1, 0},
        {0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };
    static final int[][] PATRON_20 = {
        {0, 0, 0, 0, 0},
        {0, 0, 1, 1, 0},
        {0, 0, 0, 1, 0},
        {0, 0, 1, 1, 0},
        {0, 0, 0, 0, 0}
    };

    static final int[][] PATRON_21 = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0},
        {0, 0, 1, 1, 0},
        {0, 0, 1, 1, 0}
    };

    static final int[][] PATRON_22 = {
        {0, 0, 0, 1, 1},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };
    static final int[][] PATRON_23 = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 0, 0}
    };
    static final int[][] PATRON_24 = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 1, 1}
    };

    static final int[][] PATRON_25 = {
        {1, 1, 1, 0, 0},
        {1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };
    static final int[][] PATRON_26 = {
        {0, 1, 1, 1, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };

    static final int[][] PATRON_27 = {
        {0, 0, 1, 1, 1},
        {0, 0, 1, 1, 1},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };

    static final int[][] PATRON_28 = {
        {0, 0, 0, 0, 0},
        {1, 1, 1, 0, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };

    static final int[][] PATRON_29 = {
        {0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 1, 0, 1, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };

    static final int[][] PATRON_30 = {
        {0, 0, 0, 0, 0},
        {0, 0, 1, 1, 1},
        {0, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    };

    static final int[][] PATRON_31 = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {1, 1, 0, 0, 0},
        {1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0}
    };
    static final int[][] PATRON_32 = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 1, 0, 1, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 0, 0, 0}
    };
    static final int[][] PATRON_33 = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1},
        {0, 0, 1, 1, 1},
        {0, 0, 0, 0, 0}
    };
    static final int[][] PATRON_34 = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {1, 1, 1, 0, 0},
        {1, 1, 1, 0, 0}
    };
    static final int[][] PATRON_35 = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 1, 1, 1, 0}
    };
    static final int[][] PATRON_36 = {
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 1, 1, 1},
        {0, 0, 1, 1, 1}
    };

    static final int[][] PATRON_37 = {
        {0, 0, 1, 0, 0},
        {0, 1, 0, 1, 0},
        {1, 0, 0, 0, 1},
        {0, 1, 0, 1, 0},
        {0, 0, 1, 0, 0}
    };

    static final int[][] PATRON_38 = {
        {0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 1, 0, 1, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 0, 0, 0}
    };
    
    // Almacenar los patrones en un array para fácil acceso por índice
    public static final List<int[][]> PATRONES =List.of(
        PATRON_1, PATRON_2, PATRON_3,PATRON_4,PATRON_5,PATRON_6,PATRON_7, PATRON_8,PATRON_9,PATRON_10,PATRON_11, PATRON_12, PATRON_13,PATRON_14,PATRON_15,PATRON_16,PATRON_17,PATRON_18,PATRON_19,PATRON_20,PATRON_21, PATRON_22, PATRON_23,PATRON_24,PATRON_25,PATRON_26,PATRON_27,PATRON_28,PATRON_29,PATRON_30,PATRON_31, PATRON_32, PATRON_33,PATRON_34,PATRON_35,PATRON_36,PATRON_37,PATRON_38
    );

    /**
     * Devuelve un patrón según el índice.
     * @param index Índice del patrón (comienza en 0).
     * @return Matriz 5x5 representando el patrón.
     */
    public static int[][] getPatron(int index) {
        if (index >= 0 && index < PATRONES.size()) {
            return PATRONES.get(index);
        } else {
            throw new IllegalArgumentException("Índice de patrón no válido: " + index);
        }
    }

    /**
     * Devuelve la cantidad de patrones disponibles.
     * @return Número total de patrones.
     */
    public static int getCantidadPatrones() {
        return PATRONES.size();
    }
}
