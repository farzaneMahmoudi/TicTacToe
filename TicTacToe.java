
import java.util.Arrays;

public class TicTacToe {

    private Selular selular[][];
    private GameState gameState;
    String[][] board;

    public TicTacToe(Selular[][] selular) {

        this.board = new String[3][3];
        this.selular = selular;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.selular[i][j] = Selular.E;

            }
        }
    }

    public void drawBoard() {

        for (int i = 0; i < this.selular.length; i++) {
            for (int j = 0; (this.selular[i] != null && j < this.selular[i].length); j++) {
                System.out.print(this.selular[i][j] + " ");
            }
            System.out.println();
        }

    }

    public Selular[][] getSelular() {
        return selular;
    }

    public void setSelular(Selular[][] selular) {
        this.selular = selular;
    }

    public Selular getState(int i, int j) {
        return selular[i][j];
    }

    public void setState(Selular state, int i, int j) {
        selular[i][j] = state;
        if (state == Selular.X) {
            board[i][j] = "X";
        }  if (state == Selular.O) {
            board[i][j] = "O";
        }
    }

    public String switchTurn(String turn) {
        if (turn == "X") {
            return "O";
        } else {
            return "X";
        }
    }

    public boolean isGameFinished(String turn, int i, int j) {

        boolean result = false;
        int c=0;

        for(int a = 0; a<3; a++){
            for(int b=0; b<3; b++) {
                if(selular[a][b] != Selular.E) {
                    c++;
                    if(c == 9) {
                        result = true;
                        gameState = GameState.DRAW;
                    }
                }
            }
        }


        if (turn == "X") {



            int count = 0;
            int countC = 0;

            for (int k = 0; k < 3; k++) {
                if (board[i][k] == "X") {
                    count++;
                }

            }

            for (int k = 0; k < 3; k++) {
                if (board[k][j] == "X") {
                    countC++;
                }

            }
            if (count == 3 || countC == 3) {
                gameState = GameState.X_WINS;
                result = true;
            }

        }
        if (turn == "O") {


            int count = 0;
            int countC = 0;

            for (int k = 0; k < 3; k++) {
                if (board[i][k] == "O") {
                    count++;

                }

            }

            for (int k = 0; k < 3; k++) {
                if (board[k][j] == "O") {
                    countC++;
                }

            }
            if (count == 3 || countC == 3) {
                gameState = GameState.O_WINS;
                result = true;
            }
        }

        return result;

    }

    @Override
    public String toString() {
        return "TicTacToe{"
                + "selular=" + Arrays.toString(selular)
                + '}';
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
