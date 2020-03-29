import com.sun.deploy.resources.ResourceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Game
 *
 * This class manage all of the condition and elements of
 * this game. all of the element there is in this game such as
 * list of discs in this game.
 *
 * @author Amir01
 * @version v1.0 (28 Mar 2020)
 */
public class Game {

    // Fields

    // list of all of the discs
    private ArrayList<Disc> discs;
    // object of Table
    private Table table;
    // object of Condition
    private Condition condition;


    //Constructor

    public Game() {

        table = new Table();
        condition = new Condition(getTable());

        discs = new ArrayList<>();
        Disc disc1 = new Disc(0, 3, 3);
        Disc disc2 = new Disc(0, 4, 4);
        Disc disc3 = new Disc(1, 3, 4);
        Disc disc4 = new Disc(1, 4, 3);

        discs.add(disc1);
        discs.add(disc2);
        discs.add(disc3);
        discs.add(disc4);

        System.out.println(getTable().draw());
    }


    // Setter & Getter


    /**
     * getter of Table's object
     *
     * @return object of Table class
     */
    public Table getTable() {
        return table;
    }


    /**
     * getter of Condition's object
     *
     * @return object of Condition class
     */
    public Condition getCondition() {
        return condition;
    }


    // Method


    /**
     * This method convert I C format to an array of two
     * elements. first element is x and second element is y
     *
     * @param input entered (I C) format string in stdin
     * @return array of two elements, x and y
     */
    private int[] traslator(String input) {
        int [] res = new int [2];

        input = input.trim();
        input = input.replaceAll(" ", "");
        String p1 = input.substring(0,1);
        char p2 = input.charAt(1);

        try{
            res[0] = Integer.valueOf(p1)-1;
            res[1] = p2 - 'A';
        }catch(Exception e) {
            System.out.println("Your entered input is not valid!!!" +
                    "\nPlease check valid input format then try again!!!");
        }
        return res;
    }


    /**
     * This method add a new disc in game and handle user mistake
     *
     * @param input entered (I C) format String
     * @param color color of disc
     * @return true if selected place is valid and
     *         false if selected place is not valid
     */
    public boolean createDisc(String input, int color) {
        int[] res = traslator(input);

        if(condition.checkPlace(color, res[0], res[1])) {
            Disc disc = new Disc(color, res[0], res[1], getTable(), getCondition());
            discs.add(disc);

            System.out.println(getTable().draw());
            return true;
        }

        return false;
        /*for (int[] ints : getTable().getTable()) {
            for (int anInt : ints) {
                System.out.print(anInt+ " ");
            }
            System.out.println();
        }

        System.out.println(res[0] + " " + res[1]);*/
    }


    public void computerDisc(int color) {

        List<String> validPlace = condition.checkBetterPlace();

        if(validPlace.size() == 1) {

            int x = -1;
            int y = -1;

            try{

                x = Integer.valueOf(validPlace.get(0).substring(0, 1));
                y = Integer.valueOf(validPlace.get(0).substring(1, 2));

                Disc new_disc = new Disc(color, x, y, table, condition);
                discs.add(new_disc);

                System.out.println(getTable().draw());

            } catch(Exception e) {
                System.err.println("Some problem in parsing String to integer!!!");
            }

        } else if(validPlace.size() > 1) {

            int x = -1;
            int y = -1;

            Random random = new Random();

            int randNum = random.nextInt(validPlace.size());

            try{

                x = Integer.valueOf(validPlace.get(randNum).substring(0, 1));
                y = Integer.valueOf(validPlace.get(randNum).substring(1, 2));

                Disc new_disc = new Disc(color, x, y, table, condition);
                discs.add(new_disc);

                System.out.println(getTable().draw());

            } catch(Exception e) {
                System.err.println("Some problem in parsing String to integer!!!");
            }

        }

    }

}
