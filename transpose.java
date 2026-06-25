public class transpose {
    public static void transposeMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int transposedMatrix[][] = new int[n][m];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(transposedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
        transposeMatrix(matrix);
    }
}
