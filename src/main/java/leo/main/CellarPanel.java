package leo.main;

import javax.swing.*;
import java.awt.*;

public class CellarPanel extends JComponent {

    private final int cellSize;
    private boolean[][] cells;

    public CellarPanel(int cellSize) {
        this.cellSize = cellSize;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.decode("#2b2b2b"));
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.decode("#ff0000"));

        for (int x = 0; x < cells.length; x++) {
            for (int y = 0; y < cells[x].length; y++) {
                if (cells[x][y]) {
                    g.fillRect(x * cellSize, y * cellSize, cellSize - 1, cellSize - 1);
                }
            }
        }
    }

    public void repaint(boolean[][] cells) {
        this.cells = cells;
        repaint();
    }
}
