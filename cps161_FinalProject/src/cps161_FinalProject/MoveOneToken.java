package cps161_FinalProject;
import java.util.Random;

public class MoveOneToken extends FunkyToken {
    MoveOneToken(char token) {
        super(token);
    }

    @Override
    void move(FunkyBoard board) {
        Random random = new Random();
        int x = -1, y = -1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!board.isValidMove(x, y) || board.board[x][y] != ' ') {
            int[] direction = directions[random.nextInt(directions.length)];
            x = random.nextInt(board.getSize());
            y = random.nextInt(board.getSize());

            int dx = direction[0];
            int dy = direction[1];
            x += dx;
            y += dy;
        }

        if (board.isValidMove(x, y)) {
            char currentToken = board.board[x][y];
            board.board[x][y] = this.token;
            if (currentToken != ' ') {
                // Remove the old token
                for (int i = 0; i < board.getSize(); i++) {
                    for (int j = 0; j < board.getSize(); j++) {
                        if (board.board[i][j] == currentToken) {
                            board.board[i][j] = ' ';
                            for (FunkyToken token : board.getTokens()) {
                                if (token.getTokenSymbol() == currentToken) {
                                    token.setActive(false);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
}
