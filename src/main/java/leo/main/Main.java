package leo.main;

import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    private static final int WIDTH= 1200;
    private static final int HEIGHT  = 800;
    private static final int CELL_SIZE = 4;
    private static final int K = 7;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cellar");

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);

        CellarPanel cellarPanel = new CellarPanel(CELL_SIZE);
        frame.add(cellarPanel);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Cellar cellar = new Cellar(WIDTH/CELL_SIZE, HEIGHT/CELL_SIZE, K, 30) {
            @Override
            public void iteration(boolean[][] cells) {
                cellarPanel.repaint(cells);
            }
        };

        new Thread(cellar).start();
    }
}