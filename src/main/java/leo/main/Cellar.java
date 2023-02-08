package leo.main;

import leo.util.CellUtils;
import leo.util.NeighborUtils;

public class Cellar implements Runnable {

    private boolean[][] cells;

    private int xSize;
    private int ySize;

    private boolean isPause;

    public Cellar(int xSize, int ySize, int k) {
        this.xSize = xSize;
        this.ySize = ySize;

        cells = CellUtils.create(xSize, ySize, k);
    }

    @Override
    public void run() {
        while (!isPause) {

            before(cells);

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            var newCells = new boolean[xSize][ySize];

            for (int x = 0; x < cells.length; x++) {
                for (int y = 0; y < cells[x].length; y++) {
                    int neighbors = NeighborUtils.neighborsNumber(cells, x, y);
                    newCells[x][y] = (cells[x][y] && neighbors == 2) || neighbors == 3;
                }
            }

            cells = newCells;
        }
    }

    public void before(boolean[][] cells) {}
}
