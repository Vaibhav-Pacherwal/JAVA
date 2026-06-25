import java.util.*;

public class wordSearch {
    public static boolean search(char[][] board, String word, int row, int col, int idx) {
        if(idx == word.length()) {
            return true;
        }

        int m = board.length, n = board[0].length;
        char top = (row>0) ? board[row-1][col] : '#';
        char bottom = (row<m-1) ? board[row+1][col] : '#';
        char right = (col<n-1) ? board[row][col+1] : '#';
        char left = (col>0) ? board[row][col-1] : '#';

        if(top == word.charAt(idx)) {
            search(board, word, row-1, col, idx+1);
        } 
        if(bottom == word.charAt(idx)) {
            search(board, word, row+1, col, idx+1);
        }
        if(right == word.charAt(idx)) {
            search(board, word, row, col+1, idx+1);
        }
        if(left == word.charAt(idx)) {
            search(board, word, row, col-1, idx+1);
        }

        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        int m = board.length, n = board[0].length;
        String word = sc.nextLine();

        boolean exists = false;
        outer:
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    exists = search(board, word, i, j, 1);
                    if(exists) {
                        break outer;
                    }
                }
            }
        }

        System.out.println(
            word + " " + 
            (exists ? "exists" : "does not exist") + " " +
            "in the board"
        );

        sc.close();
    }
}
