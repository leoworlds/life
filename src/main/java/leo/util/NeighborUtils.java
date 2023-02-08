package leo.util;

import java.util.stream.Stream;

public class NeighborUtils {

    private NeighborUtils() {}

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
}
