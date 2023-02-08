package leo.main;

import javax.swing.*;
import java.awt.*;

public class RootPanel extends JComponent implements Runnable {

    private static final int K = 7;
    private static final int CELL_SIZE = 4;
    private boolean[][] cells;

    private int xSize;
    private int ySize;

    public RootPanel(int width, int height) {
        xSize = width/CELL_SIZE;
        ySize = height/CELL_SIZE;

        cells = Utils.createCells(xSize, ySize, K);

        new Thread(this).start();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.decode("#2b2b2b"));
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.decode("#ff0000"));

        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                if (cells[x][y]) {
                    g.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE - 1, CELL_SIZE - 1);
                }
            }
        }
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            var newCells = new boolean[xSize][ySize];

            for (int x = 0; x < cells.length; x++) {
                for (int y = 0; y < cells[x].length; y++) {
                    int neighbors = Utils.neighborsNumber(cells, x, y);
                    newCells[x][y] = (cells[x][y] && neighbors == 2) || neighbors == 3;
                }
            }

            cells = newCells;

            repaint();
        }
    }
}
