import java.util.ArrayList;

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

        if (isEmpty(x, y)) {
            if(color == 0) {
                table[x][y] = 1;
            }else if (color == 1) {
                table[x][y] = 2;
            }
        } else {
            System.out.println("This cell is full!\nPlease select other cell!!!");
        }
    }


    private boolean isEmpty(int x, int y) {
        if(table[x][y] == 0) {
            return true;
        }
        return false;
    }


    public String draw(ArrayList<Disc> discs) {

        // unicode of this table

        String up_left = "\u2554";
        String up_right = "\u2557";
        String down_left = "\u255A";
        String down_right = "\u255D";

        String horizentalBar = "\u2550";
        String verticalBar = "\u2551";

        String sol = "\u1690";

        String middleVerLeft = "\u2560";
        String middleVerRight = "\u2563";
        String middleHorUp = "\u2566";
        String middleHorDown = "\u2569";
        String cross = "\u256C";


        // Result String

        String res = "";


        // Drawing Part


        for(int i=0;i<18;i++) {
            for(int j=0;j<9;j++) {

                if (i==1 && j==1) {
                    res += up_left+horizentalBar+sol+sol+sol+horizentalBar+middleHorUp;
                } else if (i==1 && j==8) {
                    res += horizentalBar+sol+sol+sol+horizentalBar+up_right;
                } else if (i==17 && j==1) {
                    res += down_left+horizentalBar+sol+sol+sol+horizentalBar+middleHorDown;
                } else if (i==17 && j==8) {
                    res += horizentalBar+sol+sol+sol+horizentalBar+down_right;
                } else if (j==1 && i%2==1) {
                    res += middleVerLeft+horizentalBar+sol+sol+sol+horizentalBar+cross;
                } else if (j==8 && i%2==1) {
                    res += horizentalBar+sol+sol+sol+horizentalBar+middleVerRight;
                } else if (j==0 && i%2==0 && i!=0) {
                    res += i/2;
                } else if (j==0 && i%2==1) {
                    res += " ";
                } else if (i==0) {
                    char letter = 'A';
                    if (j==1) {
                        res += "   "+letter+"   ";
                    } else if (j>1) {
                        letter+=j-1;
                        res += " "+letter+"  ";
                        if (letter=='D') {
                            res += " ";
                        } else if (letter=='G') {
                            res += " ";
                        }
                    }
                } else if (i==1) {
                    res += horizentalBar+sol+sol+sol+horizentalBar+middleHorUp;
                } else if (i==17) {
                    res += horizentalBar+sol+sol+sol+horizentalBar+middleHorDown;
                } else if(i%2==1) {
                    res += horizentalBar+sol+sol+sol+horizentalBar+cross;
                } else { //check for player disc
                    if (j==1) {
                        res += verticalBar+" "+sol+sol+sol+" "+verticalBar;
                    } else if (j>1) {
                        res += " "+sol+sol+sol+" "+verticalBar;
                    }
                }
            }
            res += "\n";
        }

        return res;
    }
}
