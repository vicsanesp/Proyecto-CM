package com.example.cumslide;

public class Player {
    private int x, y; // Posición del jugador
    private int speed; // Velocidad del jugador
    private int[][] map; // Matriz del mapa del juego

    public Player(int[][] map) {
        this.map = map;
        x = 0;
        y = 0;
        speed = 1;
    }

    public void update() {
        // Mover el jugador hacia abajo
        y += speed;

        // Comprobar si los valores de la matriz están a cero
        int tileX = x / TILE_SIZE;
        int tileY = y / TILE_SIZE;

        if (map[tileY][tileX] != 0) {
            // Si el valor de la matriz no es cero, detener el movimiento hacia abajo
            y = (tileY - 1) * TILE_SIZE;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
