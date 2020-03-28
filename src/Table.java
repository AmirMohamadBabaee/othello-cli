/**
 * Table
 *
 * This class describe game table of this game
 *
 * @author Amir01
 * @version v1.0 (27 Mar 2020)
 */
public class Table {

    // Field


    // Row and Column of this table
    private int row;
    // elements of 2D Array of this table
    private int[][] table;



    // Constructor

    /**
     * Default Constructor of Table class
     */
    public Table() {
        this.row = 8;
        table = new int[8][8];
    }


    // Setter & Getter


    /**
     * getter of 2D Array to check cell is empty or not
     *
     * @return 2D Array of boolean to check emptiness
     */
    public int[][] getTable() {
        return table;
    }


    // Method


    /**
     * This method full a cell in array for future check
     *
     * @param color color of disc
     * @param x x position of this Disc
     * @param y y position of this Disc
     */
    public void fullCell(int color, int x, int y) {

        if(color == 0) {
            table[x][y] = 1;
        }else if (color == 1) {
            table[x][y] = 2;
        }
    }
}
