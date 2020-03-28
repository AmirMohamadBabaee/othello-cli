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
    private boolean[][] table;



    // Constructor

    /**
     * Default Constructor of Table class
     */
    public Table() {
        this.row = 8;
        table = new boolean[8][8];
    }


    // Setter & Getter


    /**
     * getter of 2D Array to check cell is empty or not
     *
     * @return 2D Array of boolean to check emptiness
     */
    public boolean[][] getTable() {
        return table;
    }


    // Method

    public void fullCell(int x, int y) {

        table[x-1][y-1] = true;
    }
}
