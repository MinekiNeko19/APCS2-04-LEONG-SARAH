import java.lang.IllegalStateException;

public class QueenBoard {
    private int[][] board;

    private boolean addQueen(int r, int c) {
        if (r < 0 || c < 0) return false; // row or column is not a coordinate
        if (board[r][c] != 0) return false; // if the spot is dangerous don't add

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                // marks which boxes are dangerous
                if (i == r || j == c) {board[i][j]+=1;}  // horizontal and virtical
                if (i-r==j-c) {board[i][j]+=1;} // -slope diagonal
                if (r-i==j-c) {board[i][j]+=1;} // +slope diagonal
            }
        }
        board[r][c] = -1;
        return true;
    }
    private void removeQueen(int r, int c) {
        if (r >= 0 && c >= 0 && board[r][c]==-1) { // makes sure this is a queen first otherwise does nothing
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    // marks which boxes are dangerous
                    if (i == r || j == c) {board[i][j]-=1;}  // horizontal and virtical
                    if (i-r==j-c) {board[i][j]-=1;} // -slope diagonal
                    if (r-i==j-c) {board[i][j]-=1;} // +slope diagonal
                }
            }
            board[r][c] = 1; // danger b/c it was a spot that was safe before but we checked and it is now
        }
    }

    public QueenBoard(int size){
        board = new int[size][size];
    }

    public String toString() {
        String ans = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j]==-1) {ans += "Q";}
                //temporary
                else {ans += board[i][j];}
                // else {ans += "_";}
                if (j==board.length-1) {ans += "\n";}
                else {ans += " ";}
            }
        }
        return ans;
    }

    private int columnSafe(int c) { // returns index of a safe row in the column (top down)
        for (int i = 0; i < board.length; i++) {
            if (board[i][c]==0) return i;
        }
        return -1; // no safe 0s
    }

    private int queenRow(int c) { // returns index of a queen in the column
        for (int i = 0; i < board.length; i++) {
            if (board[i][c]==-1) return i;
        }
        return -1; // no queens
    }

    private boolean solveHelp(int numQueens, int r, int c) {
        // base case
        if (columnSafe(c)==-1 || c==board.length) { // stops if no queen in column or end of board
            return numQueens==c; // same num of queens as board size
        }

        if (addQueen(r, c)) {
            return solveHelp(numQueens+1, columnSafe(c+1), c+1);
        }
        removeQueen(r, c); // queen added to board is removed or nothing happens
        return solveHelp(numQueens, columnSafe(c), c);
    }

    public boolean solve(){ //IllegalStateException
        solveHelp(0, 0, 0);
        return false;
    }

    public int countSolutions() {
        return 0;
    }

}
