package com.example.cumslide;

public class Game {
    private static final int TILE_SIZE = 32;

    public static void main(String[] args) {
        int[][] map = loadMap();

        Player player = new Player(map);

        JFrame frame = new JFrame("Game");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Dibujar el jugador
                g2d.setColor(Color.BLUE);
                g2d.fillRect(player.getX(), player.getY(), TILE_SIZE, TILE_SIZE);
            }
        };
        panel.setPreferredSize(new Dimension(800, 600));
        frame.add(panel);

        while (true) {
            player.update();

            panel.repaint();

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
