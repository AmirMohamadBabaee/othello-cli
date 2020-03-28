import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

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
    }
}
