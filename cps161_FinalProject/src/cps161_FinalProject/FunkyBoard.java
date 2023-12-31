package cps161_FinalProject;

public class FunkyBoard {
    private int size;
    protected char[][] board;
    protected FunkyToken[] tokens;

    FunkyBoard(int size) {
        this.size = size;
        board = new char[size][size];
        tokens = new FunkyToken[0];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }

    void placeToken(FunkyToken token, int x, int y) {
        board[x][y] = token.getTokenSymbol();
        addToken(token);
    }

    private void addToken(FunkyToken token) {
        FunkyToken[] temp = new FunkyToken[tokens.length + 1];
        System.arraycopy(tokens, 0, temp, 0, tokens.length);
        temp[tokens.length] = token;
        tokens = temp;
    }

    void displayBoard() {
        System.out.println("---------------");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
            System.out.println("---------------");
        }
        System.out.println();
    }

    FunkyToken getWinner() {
        int activeTokens = 0;
        FunkyToken winner = null;
        for (FunkyToken token : tokens) {
            if (token.isActive()) {
                activeTokens++;
                if (activeTokens > 1) {
                    return null;
                }
                winner = token;
            }
        }
        return winner;
    }

    int getSize() {
        return size;
    }

    boolean isValidMove(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }

    FunkyToken[] getTokens() {
        return tokens;
    }
}
