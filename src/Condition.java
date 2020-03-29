import java.util.ArrayList;
import java.util.List;

/**
 * Condition
 *
 * This class has method to check conditions of
 * this game and check end of game
 *
 * @author Amir01
 * @version v1.0 (28 Mar 2020)
 */
public class Condition {

    // Fields

    // object of table to check cell condition
    private Table table;
    // direction of Change color
    private int [] direct;
    // 2D array to check which place is better to choose
    private int[][] priority;


    // Constructor

    /**
     * This is constructor of Condition class
     *
     * @param table is object of Table class
     */
    public Condition(Table table) {

        this.table = table;
        this.priority = new int[8][8];
    }

    // Method


    /**
     * This method check is selected cell valid or not
     *
     * @param color color of disk
     * @param x x position of cell
     * @param y y position of cell
     * @return is this place is valid or not
     */
    public boolean checkPlace(int color, int x, int y) {

        direct = new int[8];
        if(table.isEmpty(x,y)){

            boolean b1 = checkSingle(color, x, y, 1, 0); // Right
            boolean b2 = checkSingle(color, x, y, 1, 1); // Right-Down
            boolean b3 = checkSingle(color, x, y, 0, 1); // Down
            boolean b4 = checkSingle(color, x, y, -1, 1); // Left-Down
            boolean b5 = checkSingle(color, x, y, -1, 0); // Left
            boolean b6 = checkSingle(color, x, y, -1, -1); // Left-Up
            boolean b7 = checkSingle(color, x, y, 0, -1); // Up
            boolean b8 = checkSingle(color, x, y, 1, -1); // Right-Up

            if(b1) {
                direct[0] = 1;
            } else {
                direct[0] = 0;
            }

            if(b2) {
                direct[1] = 1;
            } else {
                direct[1] = 0;
            }

            if(b3) {
                direct[2] = 1;
            } else {
                direct[2] = 0;
            }

            if(b4) {
                direct[3] = 1;
            } else {
                direct[3] = 0;
            }

            if(b5) {
                direct[4] = 1;
            } else {
                direct[4] = 0;
            }

            if(b6) {
                direct[5] = 1;
            } else {
                direct[5] = 0;
            }

            if(b7) {
                direct[6] = 1;
            } else {
                direct[6] = 0;
            }

            if(b8) {
                direct[7] = 1;
            } else {
                direct[7] = 0;
            }

            return b1 || b2 || b3 || b4 || b5 ||
                    b6 || b7 || b8;
        }
        return false;
    }


    private boolean checkSingle(int color, int x, int y , int delX, int delY) {

        boolean res = false;

        int [][] map = table.getTable();

        int mainX = x;
        int mainY = y;

        int max = -1;

        if(color == 0) {

            try{

                int counter = 0;
                boolean con = false;
                do{
                    x += delX;
                    y += delY;
                    if (map[x][y] == 2) {
                        con =true;
                        counter++;
                    } else {
                        if (counter > 0) {

                            if (map[x][y] == 1) {

                                res = true;
                                if(max < counter) {
                                    max = counter;
                                }

                            }
                            counter = 0;
                            con = false;

                        } else {
                            res = false;
                        }
                    }
                }while(con);

            } catch(Exception e) {
                res = false;
            }

        }else if(color ==1) {

            try{

                int counter = 0;
                boolean con = false;
                do{
                    x += delX;
                    y += delY;
                    if (map[x][y] == 1) {
                        con =true;
                        counter++;
                    } else {
                        if (counter > 0) {

                            if (map[x][y] == 2) {

                                res = true;
                                if(max < counter) {
                                    max = counter;
                                }

                            }
                            counter = 0;
                            con = false;

                        } else {
                            res = false;
                        }
                    }
                }while(con);

            } catch(Exception e) {
                res = false;
            }

        }

        if(res && table.isEmpty(mainX, mainY)) {

            priority[mainX][mainY] = max;

        }
        return res;
    }


    /**
     * This method change all of disc between to special disc
     *
     * @param color color of disc
     * @param x x position of disc
     * @param y y position of disc
     */
    public void makeChange(int color, int x, int y) {

        makeSingleChange(color, x, y, 1, 0, direct[0]); // Right
        makeSingleChange(color, x, y, 1, 1, direct[1]); // Right-Down
        makeSingleChange(color, x, y, 0, 1, direct[2]); // Down
        makeSingleChange(color, x, y, -1, 1, direct[3]); // Left-Down
        makeSingleChange(color, x, y, -1, 0, direct[4]); // Left
        makeSingleChange(color, x, y, -1, -1, direct[5]); // Left-Up
        makeSingleChange(color, x, y, 0, -1, direct[6]); // Up
        makeSingleChange(color, x, y, 1, -1, direct[7]); // Right-Up

    }

    private void makeSingleChange(int color, int x, int y, int delX, int delY, int id) {

        int [][] map = this.table.getTable();

        if(id == 1) {

            if(color == 0) {

                try{

                    do{
                        x += delX;
                        y += delY;
                        if (map[x][y] == 2) {
                            map[x][y] = 1;
                        }
                    }while(map[x+delX][y+delY] == 2);

                } catch(Exception e) {
                    e.printStackTrace();
                }

            }else if(color ==1) {

                try{

                    do{
                        x += delX;
                        y += delY;
                        if (map[x][y] == 1) {
                            map[x][y] = 2;
                        }
                    }while(map[x+delX][y+delY] == 1);

                } catch(Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }


    /**
     * This method check is there any place for this player or not
     *
     * @param color color of disc
     * @return true if there is and false if there is not
     */
    public boolean isEnd(int color) {

        int[][] map = this.table.getTable();

        for(int i=0 ; i<8 ; i++) {
            for(int j=0 ; j<8 ; j++) {
                if(map[i][j] == 0) {
                    if(checkPlace(color, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    /**
     * This method check game ended or not
     *
     * @return true if game ended and false if game is running
     */
    public boolean completeGame() {

        if(isEnd(0) && isEnd(1)) {
            return true;
        }
        return false;

    }


    /**
     * This method check all of the cell and then choose
     * one of them which have more disc between yourself
     * and another disc.
     *
     * @return list of the best choice for computer
     */
    public List<String> checkBetterPlace() {

        int [][] map = table.getTable();
        refreshPriority();

        for(int i=0 ; i<8 ; i++) {
            for(int j=0 ; j<8 ; j++) {
                checkPlace(1, i, j);
            }
        }
        int maxVal = findMax();
        List<String> res = new ArrayList<>();

        for (int i=0; i<8 ; i++) {
            for (int j=0 ; j<8 ; j++) {
                if(priority[i][j] == maxVal) {

                    res.add(""+i+j);

                }
            }
        }
        return res;
    }


    private int findMax() {

        int max = -1;
        for (int[] ints : priority) {
            for (int i : ints) {
                if(i > max) {
                    max = i;
                }
            }
        }

        return max;
    }


    private void refreshPriority() {
        for(int i=0 ; i<8 ;i++){
            for(int j=0; j<8 ; j++) {

                priority[i][j] = 0;

            }
        }
    }
}
