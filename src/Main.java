import java.util.Scanner;

/**
 * Main
 *
 * This Class, use all of the components to run this game
 *
 * @author Amir01
 * @version v1.0 (30 Mar 2020)
 */
public class Main {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int input;
        do{

            menu();

            input = scan.nextInt();
            scan.nextLine();

            if(input == 1) { // Single mode of Othello

                Game game = new Game();
                do{

                    try{

                        boolean fail = false;
                        if(!game.getCondition().isEnd(0)) {

                            System.out.print("Player  >>> ");
                            if(!game.createDisc(scan.nextLine(), 0)) {
                                fail = true;
                            }

                        } else {
                            System.out.println("Player Passed!!!");
                        }

                        if(!fail) {
                            if(!game.getCondition().isEnd(1)) {

                                Thread.sleep(5000);

                                game.computerDisc(1);

                            } else {
                                System.out.println("Computer Passed!!!");
                            }
                        }

                    } catch(Exception e) {
                        e.printStackTrace();
                    }

                } while(!game.getCondition().completeGame());

            } else if(input == 2) { // Two player mode of Othello

                int counter = 0;

                Game game = new Game();
                do{

                    try{

                        if(counter%2==0) { // Player 1

                            if(!game.getCondition().isEnd(0)) {

                                System.out.print("Player 1 >>> ");
                                if(!game.createDisc(scan.nextLine(), 0)) {
                                    counter--;
                                }

                            } else {
                                System.out.println("Player 1 Passed");
                            }

                        } else { // Player 2

                            if(!game.getCondition().isEnd(1)) {

                                System.out.print("Player 2 >>> ");
                                if(!game.createDisc(scan.nextLine(), 1)) {
                                    counter--;
                                }

                            } else {
                                System.out.println("Player 1 Passed");
                            }

                        }
                        counter++;

                    } catch(Exception e) {
                        e.printStackTrace();
                    }

                } while(!game.getCondition().completeGame());

            } else if(input == 3) {

                break;

            } else {

                System.out.println("Your Entered number is not true!!!\nPlease try Again!");

            }

        }while(input<1 || input>3);
    }


    private static void menu() {

        head();
        System.out.print("\n" +
                "( 1 ) Single Mode\n( 2 ) Multiplayer Mode\n( 3 ) Exit\n\n"+
                "Please Choose your expected type of Othello >>> ");
        /*System.out.println("\n\u2592");
        System.out.println("\u2593");
        System.out.println("\u2588  "+"\u2588");*/

    }

    private static void head() {

        System.out.println("         ***      ******** **    ** ******** **         **               ***        \n".replaceAll("\\*",
                "\u2592").replaceAll(" ", "\u2591") +
                "      **     **   ******** **    ** ******** **         **            **     **     \n".replaceAll("\\*",
                        "\u2592").replaceAll(" ", "\u2591") +
                "    **         **    **    **    ** **       **         **          **         **   \n".replaceAll("\\*",
                        "\u2592").replaceAll(" ", "\u2591") +
                "   **           **   **    **    ** **       **         **         **           **  \n".replaceAll("\\*",
                        "\u2592").replaceAll(" ", "\u2591") +
                "  **             **  **    ******** ******** **         **        **             ** \n".replaceAll("\\*",
                        "\u2592").replaceAll(" ", "\u2591") +
                "  **             **  **    ******** ******** **         **        **             ** \n".replaceAll("\\*",
                        "\u2592").replaceAll(" ", "\u2591") +
                "   **           **   **    **    ** **       **         **         **           **  \n".replaceAll("\\*",
                        "\u2592").replaceAll(" ", "\u2591") +
                "    **         **    **    **    ** **       **         **          **         **   \n".replaceAll("\\*",
                        "\u2592").replaceAll(" ", "\u2591") +
                "      **     **      **    **    ** ******** ********** **********    **     **     \n".replaceAll("\\*",
                        "\u2592").replaceAll(" ", "\u2591") +
                "         ***         **    **    ** ******** ********** **********       ***        ".replaceAll("\\*",
                        "\u2592").replaceAll(" ", "\u2591"));

    }
}
