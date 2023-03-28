package com.example.cumslide;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CumSlide {
    List<List<Integer>> matrix = new ArrayList<List<Integer>>();
    Pair player = new Pair(0,0); // Player position: X=row Y=column
    Integer goal = 0; // Column of the goal

    public Map<Integer, Cuarteto> positions = new HashMap<>();

    public CumSlide(){
        matrix = new ArrayList<List<Integer>>();
        player = new Pair(0,0);
        goal = 0;
        positions = new HashMap<>();
    }
    public CumSlide(Integer size) {
        positions = new HashMap<>();
        // Inicializar la matriz con valor 0
        for (int i = 0; i < size; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                row.add(0);
            }
            matrix.add(row);
        }

        for (int i = 1; i < 5; i++) {
            addBridge(matrix, i);
        }
        // System.out.println(this.checkPairs());
    }

    public Boolean checkPairs(){
        // Make a dict with the values of the matrix
        HashMap<Integer, Integer> dict = new HashMap<Integer, Integer>();
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) != 0) {
                    if (dict.containsKey(matrix.get(i).get(j))) {
                        dict.put(matrix.get(i).get(j), dict.get(matrix.get(i).get(j)) + 1);
                    } else {
                        dict.put(matrix.get(i).get(j), 1);
                    }
                }
            }
        }
        List<Integer> values = new ArrayList<Integer>(dict.values());
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) % 2 != 0) {
                return false;
            }
        }
        return true;

    }

    // Función para agregar un puente entre dos columnas adyacentes
    public void addBridge(List<List<Integer>> matrix, int i) {
        int bridgeColumn = new Random().nextInt(3); // seleccionar una columna al azar
        int bridgeRow = new Random().nextInt(20); // seleccionar una fila al azar
        int bridgeRow2 = new Random().nextInt(20); // seleccionar otra fila al azar

        int bridgeValue = i; // el valor del puente es i

        // Comprobar si ya hay un puente en las celdas seleccionadas
        while (matrix.get(bridgeRow).get(bridgeColumn) != 0 || matrix.get(bridgeRow).get(bridgeColumn + 1) != 0) {
            bridgeColumn = new Random().nextInt(3); // seleccionar otra columna al azar
            bridgeRow = new Random().nextInt(20); // seleccionar otra fila al azar
        }

        // agregar el puente a la matriz
        matrix.get(bridgeRow).set(bridgeColumn, bridgeValue);
        matrix.get(bridgeRow2).set(bridgeColumn + 1, bridgeValue);

        // Agregar al diccionario positions, una lista con las parejas del puente
        positions.put(i, new Cuarteto(bridgeColumn, bridgeRow, bridgeColumn+1, bridgeRow2));
        System.out.print("Se ha añadido un cuarteto");
    }


//    public static void main(String[] args) {
//        CumSlide game = new CumSlide(20);
//        for (int i = 0; i < game.matrix.size(); i++) {
//            System.out.println(game.matrix.get(i));
//        }
//        System.out.println("=====================================");
//        for (int i = 0; i < 20; i++) {
//            i = game.printRow();
//            game.movePlayer();
//        }
//    }

    public Integer printRow(){
        String row = "";
        for (int i = 0; i < matrix.get(player.getX()).size(); i++) {
            if (i == player.getY()) {
                row += "P ";
            } else {
                row += matrix.get(player.getX()).get(i) + ((matrix.get(player.getX()).size()-1)==i?"":" ");
            }
        }
        System.out.println( "[" + row + "], " + (player.getX()+1));
        return player.getX();
    }

    public void movePlayer(){
        Integer row = player.getX();
        Integer column = player.getY();
        Integer value = matrix.get(row).get(column);

        if (value!=0){
            // Get the indexes of the matrix where the value = value
            List<Pair> indexes = findIndexes(value);
            // Get the index with the highest X value
            Pair index = indexes.get(0);
            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i).getX() > index.getX()) {
                    index = indexes.get(i);
                }
            }
            // Set the player position to the index
            player.setX(index.getX());
            player.setY(index.getY());
        }
        player.setX(player.getX()+1);
    }

    public List<Pair> findIndexes(int value) {
        List<Pair> result = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> sublist = matrix.get(i);
            for (int j = 0; j < sublist.size(); j++) {
                if (sublist.get(j) == value) {
                    Pair index = new Pair(i, j);
                    result.add(index);
                }
            }
        }
        return result;
    }

}
