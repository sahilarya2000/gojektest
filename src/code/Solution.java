package code;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


public class Solution {

    private static final String B = "B";
    private static final String X = "X";
    private static final String O = "O";
    private static final String E = "_";
    private static final String FIRST_PLAYER_WON = "Player 1 wins";
    private static final String FIRST_PLAYER = "Player 1";
    private static final String SECOND_PLAYER = "Player 2";
    private static final String SECOND_PLAYER_WON = "Player 2 wins";
    private static final String DRAW = "Its a draw";

    public List<String[][]> battleShip(int m, int s, List<Coordinate> player1Ships, List<Coordinate> player2Ships,
                                       List<Coordinate> missilesPlayer1, List<Coordinate> missilesPlayer2) {

        List<String[][]> result = new ArrayList<>();
        Long p1hits = 0L;
        Long p2hits = 0L;
        String resultDisplay = null;

        String grid1[][] = initialiseGrid(m, player1Ships);
        String grid2[][] = initialiseGrid(m, player2Ships);

        if(missilesPlayer1 !=null && missilesPlayer1.size()>0)
        {
            for (Coordinate coordinate : missilesPlayer1) {
                if (grid2[coordinate.getX()][coordinate.getY()].equalsIgnoreCase(B)) {
                    grid2[coordinate.getX()][coordinate.getY()] = X;
                    p1hits++;
                }

                if (grid2[coordinate.getX()][coordinate.getY()].equalsIgnoreCase(E))
                    grid2[coordinate.getX()][coordinate.getY()] = O;
            }
        }

        if(missilesPlayer2 !=null && missilesPlayer2.size()>0) {
            for (Coordinate coordinate : missilesPlayer2) {
                if (grid1[coordinate.getX()][coordinate.getY()].equalsIgnoreCase(B)) {
                    grid1[coordinate.getX()][coordinate.getY()] = X;
                    p2hits++;
                }
                if (grid1[coordinate.getX()][coordinate.getY()].equalsIgnoreCase(E))
                    grid1[coordinate.getX()][coordinate.getY()] = O;
            }
        }


        if (p1hits > p2hits)
            resultDisplay = FIRST_PLAYER_WON;
        if (p2hits > p1hits)
            resultDisplay = SECOND_PLAYER_WON;
        if (p2hits == p1hits)
            resultDisplay = DRAW;

        result.add(grid1);
        result.add(grid2);

        System.out.println(FIRST_PLAYER);
        printGrid(grid1);

        System.out.println("\n"+SECOND_PLAYER);
        printGrid(grid2);

        System.out.println("\nP1:");
        System.out.print(p1hits);
        System.out.println("\nP2:");
        System.out.println(p2hits);

        System.out.println(resultDisplay);
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


    private void printGrid(String grid[][]) {

        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println("\n");
        }
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

        Coordinate player1Ship1 = new Coordinate();
        player1Ship1.setX(0);
        player1Ship1.setY(0);

        Coordinate player1Ship2 = new Coordinate();
        player1Ship2.setX(1);
        player1Ship2.setY(1);

        Coordinate player2Ship1 = new Coordinate();
        player2Ship1.setX(0);
        player2Ship1.setY(0);

        Coordinate player2Ship2 = new Coordinate();
        player2Ship2.setX(1);
        player2Ship2.setY(1);

        List<Coordinate> player1Ships = new ArrayList<>();
        player1Ships.add(player1Ship1);
        player1Ships.add(player1Ship2);

        List<Coordinate> player2Ships = new ArrayList<>();
        player2Ships.add(player2Ship1);
        player2Ships.add(player2Ship2);

        Coordinate player1missle1 = new Coordinate();
        player1missle1.setX(0);
        player1missle1.setY(0);

        Coordinate player1missle2 = new Coordinate();
        player1missle2.setX(1);
        player1missle2.setY(1);

        Coordinate player2missle1 = new Coordinate();
        player2missle1.setX(0);
        player2missle1.setY(1);

        Coordinate player2missle2 = new Coordinate();
        player2missle2.setX(1);
        player2missle2.setY(1);

        List<Coordinate> player1Missiles = new ArrayList<>();
        player1Missiles.add(player1missle1);
        player1Missiles.add(player1missle2);

        List<Coordinate> player2Missiles = new ArrayList<>();
        player2Missiles.add(player2missle1);
        player2Missiles.add(player2missle2);

        solution.battleShip(2,2,player1Ships,player2Ships,player1Missiles,player2Missiles);

    }
}
