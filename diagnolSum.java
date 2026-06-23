public class diagnolSum {
    public static int DS(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int primaryDiagnolSum = 0;
        int col1 = 0;
        for(int i = 0; i < m; i++) {
            primaryDiagnolSum += matrix[i][col1];
            col1++;
        }

        int secondaryDiagnolSum = 0;
        int col2 = n-1;
        for(int i = 0; i < m; i++) {
            secondaryDiagnolSum += matrix[i][col2];
            col2--;
        }

        if(m%2!=0) {
            int pos = (m-1)/2;
            return primaryDiagnolSum+secondaryDiagnolSum-matrix[pos][pos];
        }

        return primaryDiagnolSum+secondaryDiagnolSum;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, 
                          {5, 6, 7, 8}, 
                          {9, 10, 11, 12},
                          {13, 14, 15, 16}};
        
        int ans = DS(matrix);
        System.out.println(ans);
    }
}
