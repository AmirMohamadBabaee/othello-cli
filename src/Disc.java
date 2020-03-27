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


    // Constructor


    public Disk(int color, int x, int y) {
        setColor(color);
        setX(x);
        setY(y);
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
}
