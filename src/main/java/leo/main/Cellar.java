package leo.main;

import leo.util.CellUtils;

public class Cellar implements Runnable {

    private boolean[][] cells;
    private boolean isPause;
    private long millis;

    public Cellar(int xSize, int ySize, int k, long millis) {
        this.millis = millis;
        cells = CellUtils.create(xSize, ySize, k);
    }

    @Override
    public void run() {
        while (!isPause) {
            iteration(cells);
            sleep(millis);
            cells = CellUtils.next(cells);
        }
    }

    private static void sleep(long millis) {
        if (millis > 0) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void setPause(boolean isPause) {
        this.isPause = isPause;
    }

    protected void iteration(boolean[][] cells) {}
}
