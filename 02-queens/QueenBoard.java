import java.lang.IllegalStateException;

public class QueenBoard {
    private int[][] board;

    public boolean addQueen(int r, int c) { // temporarily public
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == -1) {
                    // call removeQueen
                    return false;
                }
                if (i == r || j == c) {board[i][j]+=1;}
            }
        }
        board[r][c] = -1;
        return true;
    }
    private void removeQueen(int r, int c) {

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
        return true;
    }

    public int countSolutions() {
        return 0;
    }

}
