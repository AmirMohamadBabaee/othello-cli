import java.util.ArrayList;

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

    // list of disk in this game
//    ArrayList<Disc> discs;
    // object of table to check cell condition
    private Table table;
    // direction of Change color
    private int [] direct;


    // Constructor

    public Condition(Table table) {
//        this.discs = discs;
        this.table = table;
    }

    // Method

    /**
     * This method update disc's list per move
     *
     * @param discs new list of disk
     */
    public void updateDiscs(ArrayList<Disc> discs) {
//        this.discs = discs;
    }


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
        return res;
    }


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


    public boolean isEnd(int color) {

        int[][] map = this.table.getTable();

        for(int i=0 ; i<8 ; i++) {
            for(int j=0 ; j<8 ; j++) {
                if(map[i][j] == 0) {
                    if(checkPlace(color, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
