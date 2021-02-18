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
            board[r][c] = 0; // safe b/c the rows are all being checked
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
                // //temporary
                // else {ans += board[i][j];}
                else {ans += "_";}
                if (j==board.length-1) {ans += "\n";}
                else {ans += " ";}
            }
        }
        return ans;
    }

    private boolean solveHelp(int numQueens, int c) {
        //base case
        if (c>=board.length) { // stops if no queen at end of board
            return numQueens==board.length; // same num of queens as board size
        }

        // recursion
        // checks if you can add a queen in each row
        for (int i = 0; i < board.length; i++) {
            if (board[i][c]==0) {
                addQueen(i, c);
                if (solveHelp(numQueens+1, c+1)) {
                    return true;
                }
                removeQueen(i, c);
            }
        }
        // all rows didn't work
        return false;
        // since the former queens weren't marked,
        // backtrack and continue the initial for loop
    }

    public boolean solve(){
        if (board.length != 0 && board[0][0]!=0) {
            throw new IllegalStateException();
        }
        return solveHelp(0, 0);
    }

    public int countSolutions() {
        if (board.length < 2) return board.length;
        int count = 0;
        if (solve()) count += 1; // throws the exception.
        return count;
    }

}
