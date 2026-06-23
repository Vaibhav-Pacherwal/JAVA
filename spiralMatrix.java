public class spiralMatrix {
    public static void spiral(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int i = 0, j = 0;

        while (i < rows && j < cols) {
            for (int k = j; k < cols; k++) {
                System.out.print(matrix[i][k] + " ");
            }
            i++;

            for (int l = i; l < rows; l++) {
                System.out.print(matrix[l][cols - 1] + " ");
            }
            cols--;

            for (int m = cols - 1; m >= j; m--) {
                System.out.print(matrix[rows - 1][m] + " ");
            }
            rows--;

            for (int n = rows - 1; n >= i; n--) {
                System.out.print(matrix[n][j] + " ");
            }
            j++;
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, 
                          {5, 6, 7}, 
                          {9, 10, 11}};
        spiral(matrix);
    }
}