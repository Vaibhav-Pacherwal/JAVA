import java.util.HashSet;

public class setMatrixZero {
    public static void setMatrix(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(Integer row : rows) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }
        for(Integer col : cols) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setMatrix(matrix);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
