package leo.main;

import javax.swing.*;
import java.awt.*;

public class RootPanel extends JComponent {

    private static final int K = 7;
    private static final int CELL_SIZE = 4;

    private boolean[][] cells;

    public RootPanel(int width, int height) {

        Cellar cellar = new Cellar(width/CELL_SIZE, height/CELL_SIZE, K) {
            @Override
            public void before(boolean[][] cells) {
                RootPanel.this.cells = cells;
                repaint();
            }
        };

        new Thread(cellar).start();
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
}
