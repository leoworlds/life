package leo.main;

import java.util.Random;
import java.util.stream.Stream;

public class Utils {

    private Utils() {}

    private static final int [][] NEIGHBORS = new int[][] {
            {-1, -1},{0, -1},{1, -1},
            {-1,  0},        {1,  0},
            {-1,  1},{0,  1},{1,  1}
    };

    public static int neighborsNumber(boolean[][] cells, int x, int y) {
        return Stream.of(NEIGHBORS).mapToInt(neighbor -> getNeighbors(cells, neighbor, x, y)).sum();
    }

    private static int getNeighbors(boolean[][] cells, int[] neighbor, int x, int y) {

        if (x + neighbor[0] < 0 || x + neighbor[0] >= cells.length) {
            return 0;
        }

        if (y + neighbor[1] < 0 || y + neighbor[1] >= cells[x].length) {
            return 0;
        }

        return cells[x + neighbor[0]][y + neighbor[1]] ? 1 : 0;
    }

    public static boolean[][] createCells(int xSize, int ySize, int k) {
        var cells = new boolean[xSize][ySize];
        Random random = new Random();

        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                cells[x][y] = random.nextInt(100) < k;
            }
        }

        return cells;
    }
}
