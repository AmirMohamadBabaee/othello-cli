import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

/**
 * Condition
 *
 * This class has method to check conditions of
 * this game and check end of game
 *
 * @author Amir01
 * @version v1.0 (27 Mar 2020)
 */
public class Condition {

    // Fields

    // list of disk in this game
    ArrayList<Disc> discs;
    // object of table to check cell condition
    Table table;


    // Constructor

    public Condition(ArrayList<Disc> discs, Table table) {
        this.discs = discs;
        this.table = table;
    }

    // Method

    /**
     * This method update disc's list per move
     *
     * @param discs new list of disk
     */
    public void updateDiscs(ArrayList<Disc> discs) {
        this.discs = discs;
    }


    public boolean checkPlace(int color, int x, int y) {

        if(table.isEmpty(x,y)){

            return checkSingle(color, x, y, 1, 0) ||
                    checkSingle(color, x, y, 1, 1) ||
                    checkSingle(color, x, y, 0, 1) ||
                    checkSingle(color, x, y, -1, 1) ||
                    checkSingle(color, x, y, -1, 0) ||
                    checkSingle(color, x, y, -1, -1) ||
                    checkSingle(color, x, y, 0, -1) ||
                    checkSingle(color, x, y, 1, -1) ;

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
}
