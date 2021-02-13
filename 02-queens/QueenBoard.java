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
        board[r][c] = 0; // no danger b/c it was a spot that was safe before
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

    public boolean solve(){
        // if (board[0][0] != 0) throw new IllegalStateException(); // board must be completely cleared tho :// modify
        // int numQueens = 0;

        // // base case
        // if () {

        // }

        // // recursion: place or not place
        // if (solve()) {

        // }
        return true;
    }

    public int countSolutions() {
        return 0;
    }

}
