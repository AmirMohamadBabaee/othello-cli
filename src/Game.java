import java.util.ArrayList;

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
        condition = new Condition(table);

        discs = new ArrayList<>();
        Disc disc1 = new Disc(0, 3, 3);
        Disc disc2 = new Disc(0, 4, 4);
        Disc disc3 = new Disc(1, 3, 4);
        Disc disc4 = new Disc(1, 4, 3);

        discs.add(disc1);
        discs.add(disc2);
        discs.add(disc3);
        discs.add(disc4);

        System.out.println(table.draw(discs));
    }


    // Method


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
            e.printStackTrace();
        }
        return res;
    }


    public void createDisc(String input) {
        int[] res = traslator(input);
        Disc disc = new Disc(0, res[0], res[1], table, condition);
        discs.add(disc);

        System.out.println(table.draw(new ArrayList<>()));

        for (int[] ints : table.getTable()) {
            for (int anInt : ints) {
                System.out.print(anInt+ " ");
            }
            System.out.println();
        }

        System.out.println(res[0] + " " + res[1]);
    }

}
