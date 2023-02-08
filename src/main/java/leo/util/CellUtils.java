package leo.util;

import java.util.Random;

public class CellUtils {

    private static final Random RANDOM = new Random();

    private CellUtils() {}

    public static boolean[][] create(int xSize, int ySize, int k) {
        var cells = new boolean[xSize][ySize];

        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                cells[x][y] = RANDOM.nextInt(100) < k;
            }
        }

        return cells;
    }
}
