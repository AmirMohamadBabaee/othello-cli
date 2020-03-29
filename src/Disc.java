/**
 * Disk
 *
 * This class describe a disk in two state
 * White state and Black state
 *
 * @author Amir01
 * @version v1.0 (27 Mar 2020)
 */
public class Disc {

    // Fields


    // Color of this Disk
    private int color;
    // X position
    private int x;
    // Y position
    private int y;
    // unicode of Black Disk and White Disk
    private String unicode;
    // object of table
    private Table table;
    // object of condition
    private Condition condition;


    // Constructor


    /**
     * Constructor of Disc class
     *
     * @param color color id of this Disc
     * @param x x position of Disc
     * @param y y position of Disc
     * @param table this is object of Table class
     * @param condition object of condition class
     */
    public Disc(int color, int x, int y, Table table, Condition condition) {
        this.table = table;
        this.condition = condition;
        if(condition.checkPlace(color, x, y)) {
            table.fullCell(color, x, y);
            condition.makeChange(color, x, y);
            setX(x);
            setY(y);
            setColor(color);
            addUnicode();
        } else {
            System.out.println("You can not place your disc in entered position!!!");
        }

    }


    /**
     * This constructor is for first 4 disk in start of game
     *
     * @param color color of disc
     * @param x x position of Disc
     * @param y y position of Disc
     */
    public Disc(int color, int x, int y) {
        setX(x);
        setY(y);
        setColor(color);
        addUnicode();
    }


    // Setter & Getter



    /**
     * getter of color field
     *
     * @return color id of this disk
     */
    public int getColor() {
        return color;
    }

    /**
     * setter of color field
     *
     * @param color color id of this disk
     */
    public void setColor(int color) {
        if(color == 0) {
            this.color = color;
        } else if(color == 1) {
            this.color = color;
        } else {
            System.out.println("Your entered color is not correct!!!");
        }
        addUnicode();
    }

    /**
     * getter of x position field
     *
     * @return x position of this disk
     */
    public int getX() {
        return x;
    }

    /**
     * setter of x position field
     *
     * @param x x position of this disk
     */
    public void setX(int x) {
        if(x >= 0 && x <=7) {
            this.x = x;
        } else {
            System.out.println("Your entered x position is not correct!!!");
        }
    }

    /**
     * getter of y position field
     *
     * @return y position of this disk
     */
    public int getY() {
        return y;
    }

    /**
     * setter of y position field
     *
     * @param y y position of this disk
     */
    public void setY(int y) {
        if(y >= 0 && y <= 7) {
            this.y = y;
        } else {
            System.out.println("Your entered y position is not correct!!!");
        }
    }

    /**
     * getter of unicode field
     *
     * @return unicode string of this Disk
     */
    public String getUnicode() {
        if(!unicode.isEmpty()) {
            return unicode;
        }
        System.out.println("This Disk has not any unicode");
        return "";
    }


    // Method


    /**
     * this method add unicode of discs to unicode field
     */
    private void addUnicode() {
        if(this.color == 0) {
            this.unicode = "\u25CF";
        } else if(this.color == 1) {
            this.unicode = "\u25CB";
        }
    }

}
