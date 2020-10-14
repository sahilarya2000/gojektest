package code;


import java.util.ArrayList;
import java.util.List;


public class Solution {

    private static final String B = "B";
    private static final String X = "X";
    private static final String O = "O";
    private static final String E = "_";

    public List<String[][]> battleShip(int m, int s, List<Coordinate> player1Ships, List<Coordinate> player2Ships,
                                       List<Coordinate> missilesPlayer1, List<Coordinate> missilesPlayer2) {

        List<String[][]> result = new ArrayList<>();
        String grid1[][] = initialiseGrid(m, player1Ships);
        String grid2[][] = initialiseGrid(m, player2Ships);

        for (Coordinate coordinate : missilesPlayer1) {
            if (grid2[coordinate.getX()][coordinate.getY()].equalsIgnoreCase(B))
                grid2[coordinate.getX()][coordinate.getY()] = X;
            if (grid2[coordinate.getX()][coordinate.getY()].equalsIgnoreCase(E))
                grid2[coordinate.getX()][coordinate.getY()] = O;
        }

        for (Coordinate coordinate : missilesPlayer2) {
            if (grid1[coordinate.getX()][coordinate.getY()].equalsIgnoreCase(B))
                grid1[coordinate.getX()][coordinate.getY()] = X;
            if (grid1[coordinate.getX()][coordinate.getY()].equalsIgnoreCase(E))
                grid1[coordinate.getX()][coordinate.getY()] = O;
        }
        result.add(grid1);
        result.add(grid2);
        return result;
    }

    private String[][] initialiseGrid(int capacity, List<Coordinate> playerShips) {
        String grid[][] = new String[capacity][capacity];
        for (int i = 0; i < capacity; i++)
            for (int j = 0; j < capacity; j++) {
                grid[i][j] = E;
            }

        for (Coordinate coordinate : playerShips) {
            grid[coordinate.x][coordinate.y] = B;
        }

        return grid;
    }
    /*
    private void fireMissles( List<Coordinate> missilesPlayer)

    {
        for(Coordinate coordinate :missilesPlayer)
        {
            if(grid2[coordinate.x][coordinate.y].equalsIgnoreCase(B))
                grid2[coordinate.x][coordinate.y] = X;
            if(grid2[coordinate.x][coordinate.y].equalsIgnoreCase(E))
                grid2[coordinate.x][coordinate.y] = O;
        }
    }*/


    public static void main(String args[]) {
        Solution solution = new Solution();

    }
}
