package leo.main;

import javax.swing.*;

public class Main extends JFrame {

    private static final int WIDTH= 1200;
    private static final int HEIGHT  = 800;

    public Main() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        add(new RootPanel(getWidth(), getHeight()));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
