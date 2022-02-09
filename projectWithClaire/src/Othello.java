public class Othello {
    int[][] board;
    boolean curPlayer;
    int blackCount;
    int whiteCount;
    private final int WHITE = 1;
    private final int BLACK = 2;

    public Othello(){
        board = new int[5][5];
        curPlayer = true;
        board[3][3] = WHITE;
        board[4][4] = WHITE;
        board[3][4] = BLACK;
        board[4][3] = BLACK;
        blackCount = 2;
        whiteCount = 2;
    }

    private void makeMove(int i, int j) {
        //somehow need to get i and j from the GUI/input

        if (i == 0 && ((j != 0) || (j != board.length-1))) {
            while(j-1 > 1 && board[i][j-1] == BLACK) {

            }
        }
    }

    private boolean isValid(int i, int j, char direction) {
        if(curPlayer) {
            if (direction == 'U') {
                if (j - 1 < 0 && board[i][j - 1] == BLACK) {
                    
                }
            }
        }




        return false;
    }


}
