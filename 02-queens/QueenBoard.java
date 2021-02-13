import java.lang.IllegalStateException;

public class QueenBoard {
    private int[][] board;

    public boolean addQueen(int r, int c) {
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
    public void removeQueen(int r, int c) {
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

    private int columnSafe(int c) { // returns index of a safe spot (top down)
        for (int i = 0; i < board.length; i++) {
            if (board[i][c]==0) return i;
        }
        return -1; // no safe 0s
    }

    private boolean solveHelp(int numQueens, int r, int c) {
        // // base case
        // if (numQueens==board.length) {
        //     return true;
        // }

        // // recursion
        // if (columnSafe(c)==-1) {
        //     solveHelp(numQueens+1, r+1, columnSafe(c));
        // }
        // if (solveHelp(numQueens+1, r, columnSafe(c))) {
            
        // } else {}
        return false;
    }

    public boolean solve(){ //IllegalStateException
        return false;
    }

    public int countSolutions() {
        return 0;
    }

}
