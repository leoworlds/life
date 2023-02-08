package leo.main;

import leo.util.CellUtils;
import leo.util.NeighborUtils;

public class Cellar implements Runnable {

    private boolean[][] cells;

    private int xSize;
    private int ySize;

    private boolean isPause;
    private long millis;

    public Cellar(int xSize, int ySize, int k, long millis) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.millis = millis;

        cells = CellUtils.create(xSize, ySize, k);
    }

    @Override
    public void run() {
        while (!isPause) {

            iteration(cells);

            if (millis > 0) {
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            cells = nextCells();
        }
    }

    private boolean[][] nextCells() {
        var nextCells = new boolean[xSize][ySize];

        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                int neighbors = NeighborUtils.neighborsNumber(cells, x, y);
                nextCells[x][y] = (cells[x][y] && neighbors == 2) || neighbors == 3;
            }
        }

        return nextCells;
    }

    protected void iteration(boolean[][] cells) {}
}
