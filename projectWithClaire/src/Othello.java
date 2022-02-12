public class Othello {
    private int[][] board;
    private boolean curPlayer;
    private int blackCount;
    private int whiteCount;
    private final int WHITE = 1;
    private final int BLACK = -1;

    public Othello(){
        board = new int[8][8];
        curPlayer = true;
        board[3][3] = WHITE;
        board[4][4] = WHITE;
        board[3][4] = BLACK;
        board[4][3] = BLACK;
        blackCount = 2;
        whiteCount = 2;
    }

    private void makeMove(int i, int j) {
        int index;
        if (curPlayer) {
            index = 1;
        }
        else {
            index = -1;
        }
        if (checkDirection(i,j,1)) {
            for (int k = 1; k <= i; k++) {
                if (board[i-k][j] == index) {
                    break;
                }
                else {
                    board[i-k][j] = index;
                }
            }
        }
        if (checkDirection(i,j,2)) {
            int maxPossible = Math.min(i, board.length - 1 - j);
            for (int k = 1; k <= maxPossible; k++) {
                if (board[i-k][j+k] == index) {
                    break;
                }
                else {
                    board[i-k][j+k] = index;
                }
            }
        }
        if (checkDirection(i,j,3)) {
            for (int k = 1; k <= j; k++) {
                if (board[i][j+k] == index) {
                    break;
                }
                else {
                    board[i][j+k] = index;
                }
            }
        }
        if (checkDirection(i,j,4)) {
            int maxPossible = Math.min(board.length - 1 - i, board.length - 1 - j);
            for (int k = 1; k <= maxPossible; k++) {
                if (board[i+k][j+k] == index) {
                    break;
                }
                else {
                    board[i+k][j+k] = index;
                }
            }
        }
        if (checkDirection(i,j,5)) {
            for (int k = 1; k <= i; k++) {
                if (board[i+k][j] == index) {
                    break;
                }
                else {
                    board[i+k][j] = index;
                }
            }
        }
        if (checkDirection(i,j,6)) {
            int maxPossible = Math.min(board.length - 1 - i, j);
            for (int k = 1; k <= maxPossible; k++) {
                if (board[i-k][j+k] == index) {
                    break;
                }
                else {
                    board[i-k][j+k] = index;
                }
            }
        }
        if (checkDirection(i,j,7)) {
            for (int k = 1; k <= j; k++) {
                if (board[i][j-k] == index) {
                    break;
                }
                else {
                    board[i][j-k] = index;
                }
            }
        }
        if (checkDirection(i,j,8)) {
            int maxPossible = Math.min(i, j);
            for (int k = 1; k <= maxPossible; k++) {
                if (board[i-k][j-k] == index) {
                    break;
                }
                else {
                    board[i-k][j-k] = index;
                }
            }
        }
        curPlayer = !curPlayer;
    }

    private boolean isValid(int i, int j) {
        for (int k = 1; k <= 8; k++) {
            if (checkDirection(i,j,k)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDirection(int i, int j, int direction) {
        int index;
        if (curPlayer) {
            index = 1;
        }
        else {
            index = -1;
        }
        if (direction == 1) {
            if (i == 0) {
                return false;
            }
            if (board[i-1][j] != -index) {
                return false;
            }
            for (int k = 2; k <= i; k++) {
                if (board[i-k][j] == -index) {
                    continue;
                }
                if (board[i-k][j] == index) {
                    return true;
                }
                if (board[i-k][j] == 0) {
                    return false;
                }
            }
            return false;
        }
        else if (direction == 2) {
            int maxPossible = Math.min(i, board.length - 1 - j);
            if (i == 0 || j == board.length-1) {
                return false;
            }
            if (board[i-1][j+1] != -index) {
                return false;
            }
            for (int k = 2; k <= maxPossible; k++) {
                if (board[i-k][j+k] == -index) {
                    continue;
                }
                if (board[i-k][j+k] == index) {
                    return true;
                }
                if (board[i-k][j+k] == 0) {
                    return false;
                }
            }
            return false;
        }
        else if (direction == 3) {
            if (j == board.length - 1) {
                return false;
            }
            if (board[i][j+1] != -index) {
                return false;
            }
            for (int k = 2; k <= board.length-1-j; k++) {
                if (board[i][j+k] == -index) {
                    continue;
                }
                if (board[i][j+k] == index) {
                    return true;
                }
                if (board[i][j+k] == 0) {
                    return false;
                }
            }
            return false;
        }
        else if (direction == 4) {
            int maxPossible = Math.min(board.length - 1 - i, board.length - 1 - j);
            if (i == board.length - 1 || j == board.length - 1) {
                return false;
            }
            if (board[i+1][j+1] != -index) {
                return false;
            }
            for (int k = 2; k <= maxPossible; k++) {
                if (board[i + k][j + k] == -index) {
                    continue;
                }
                if (board[i + k][j + k] == index) {
                    return true;
                }
                if (board[i + k][j + k] == 0) {
                    return false;
                }
            }
            return false;
        }
        else if (direction == 5) {
            if (i == board.length - 1) {
                return false;
            }
            if (board[i+1][j] != -index) {
                return false;
            }
            for (int k = 2; k <= board.length - 1 - i; k++) {
                if (board[i+k][j] == -index) {
                    continue;
                }
                if (board[i+k][j] == index) {
                    return true;
                }
                if (board[i+k][j] == 0) {
                    return false;
                }
            }
            return false;
        }
        else if (direction == 6) {
            int maxPossible = Math.min(board.length - 1 - i, j);
            if (i == board.length - 1 || j == 0) {
                return false;
            }
            if (board[i+1][j-1] != -index) {
                return false;
            }
            for (int k = 2; k <= maxPossible; k++) {
                if (board[i + k][j - k] == -index) {
                    continue;
                }
                if (board[i + k][j - k] == index) {
                    return true;
                }
                if (board[i + k][j - k] == 0) {
                    return false;
                }
            }
            return false;
        }
        else if (direction == 7) {
            if (j == 0) {
                return false;
            }
            if (board[i][j-1] != -index) {
                return false;
            }
            for (int k = 2; k <= j; k++) {
                if (board[i][j-k] == -index) {
                    continue;
                }
                if (board[i][j-k] == index) {
                    return true;
                }
                if (board[i][j-k] == 0) {
                    return false;
                }
            }
            return false;
        }
        else if (direction == 8) {
            int maxPossible = Math.min(i, j);
            if (i == 0 || j == board.length-1) {
                return false;
            }
            if (board[i-1][j-1] != -index) {
                return false;
            }
            for (int k = 2; k <= maxPossible; k++) {
                if (board[i-k][j-k] == -index) {
                    continue;
                }
                if (board[i-k][j-k] == index) {
                    return true;
                }
                if (board[i-k][j-k] == 0) {
                    return false;
                }
            }
            return false;
        }
        return false;
    }
}