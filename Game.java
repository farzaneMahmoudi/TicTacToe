
import java.util.*;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Selular[][] selular = new Selular[3][3];
        TicTacToe game = new TicTacToe(selular);

        String TURN = "X";
        int row;
        int column;
        boolean finished = false;
        game.drawBoard();
        while (!finished) {

            int[] numInput = new int[2];
            System.out.println(TURN + " turn: ");
            try {
                numInput[0] = scanner.nextInt();
                numInput[1] = scanner.nextInt();

                if (TURN == "X") {
                    if (game.getState(numInput[0], numInput[1]) == Selular.X || game.getState(numInput[0], numInput[1]) == Selular.O) {
                        continue;
                    }
                    if (game.getState(numInput[0], numInput[1]) == Selular.E) {
                        game.setState(Selular.X, numInput[0], numInput[1]);
                        finished = game.isGameFinished("X", numInput[0], numInput[1]);
                        if (finished) {
                            game.drawBoard();
                            System.out.println(game.getGameState());
                        } else {
                            TURN = game.switchTurn("X");
                            game.drawBoard();
                        }
                    }

                }
                if (TURN == "O") {
                    if (game.getState(numInput[0], numInput[1]) == Selular.X || game.getState(numInput[0], numInput[1]) == Selular.O) {
                        continue;
                    }
                    if (game.getState(numInput[0], numInput[1]) == Selular.E) {
                        game.setState(Selular.O, numInput[0], numInput[1]);
                        finished = game.isGameFinished("O", numInput[0], numInput[1]);
                        if (finished) {
                            game.drawBoard();
                            System.out.println(game.getGameState());
                        } else {
                            TURN = game.switchTurn("O");
                            game.drawBoard();
                        }
                    }

                }

            }catch (Exception e){
                System.out.println("Bad Format!!!!!!!!!!!!");
                scanner.next();
            }

        }
    }
}
