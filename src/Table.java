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
        table[3][3] = 1;
        table[4][4] = 1;
        table[3][4] = 2;
        table[4][3] = 2;
    }


    // Setter & Getter


    /**
     * getter of 2D Array to check cell is empty or not
     *
     * @return 2D Array of number to check emptiness
     */
    public int[][] getTable() {
        return table;
    }

    /**
     * setter of 2D Array to check cell is empty or not
     *
     * @param table 2D Array of number
     */
    public void setTable(int[][] table) {
        this.table = table;
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

        Condition condition = new Condition(this);
        if (condition.checkPlace(color, x, y)) {
            if(color == 0) {
                this.table[x][y] = 1;
            } else if (color == 1) {
                this.table[x][y] = 2;
            }
        } else {
            System.out.println("This cell is full!\nPlease select other cell!!!");
        }
    }


    /**
     * This method check emptiness of a cell
     *
     * @param x x position of cell
     * @param y y position of cell
     * @return true if be empty and false if don't be empty
     */
    public boolean isEmpty(int x, int y) {
        if(table[x][y] == 0) {
            return true;
        }
        return false;
    }


    /**
     * This method build table of game and save it in
     * a new string and return it.
     *
     * @return string table of game
     */
    public String draw() {

        // unicode of this table

        String disc1 = "\u25CF";
        String disc2 = "\u25CB";

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
                        if(table[i/2-1][0] == 0) {
                            res += verticalBar+" "+sol+sol+sol+" "+verticalBar;
                        } else if (table[i/2-1][0] == 1) {
                            res += verticalBar+" "+disc1+" "+verticalBar;
                        } else if (table[i/2-1][0] == 2) {
                            res += verticalBar+" "+disc2+" "+verticalBar;
                        }
                    } else if (j>1) {
                        if(table[i/2-1][j-1] == 0) {
                            res += " "+sol+sol+sol+" "+verticalBar;
                        } else if (table[i/2-1][j-1] == 1) {
                            res += " "+disc1+" "+verticalBar;
                        } else if (table[i/2-1][j-1] == 2) {
                            res += " "+disc2+" "+verticalBar;
                        }
                    }
                }
            }
            res += "\n";
        }

        res += " Player 1: "+sumDisc()[0]+"\t\t\tPlayer 2: "+sumDisc()[1];

        return res;
    }

    private int[] sumDisc() {
        int counter0 = 0;
        int counter1 = 0;

        for (int[] ints : table) {
            for (int i : ints) {
                if(i == 1) {
                    counter0++;
                }else if(i == 2) {
                    counter1++;
                }
            }
        }

        int[] res = new int[]{counter0, counter1};

        return res;
    }
}
