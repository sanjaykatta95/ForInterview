import java.util.Arrays;

public class Traversal {
    int[][] dirs = {{0, -1}, {1, 0}, {0, 1}};

    int[][] dp;

    public boolean checkIfPathExists(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int j = 0; j < n; j++) {
            boolean visited[][] = new boolean[m][n];
            if (matrix[0][j] == 1) {
                if (dfs(matrix, 0, j, visited) == true)
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(int[][] matrix, int i, int j, boolean[][] visited) {
        if (i == matrix.length - 1 && matrix[i][j] == 1) return true;
        if (i >= matrix.length - 1 || j >= matrix[0].length - 1 || matrix[i][j] == 0) return false;
        for (int[] dir : dirs) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if (isValid(new_i, new_j, matrix.length - 1, matrix[0].length - 1) && matrix[new_i][new_j] == 1) {
                if (dfs(matrix, new_i, new_j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int newI, int newJ, int m, int n) {
        return newI >= 0 && newI <= m && newJ >= 0 && newJ <= n;
    }

    public static void main(String args[]) {
        int[][] matrix = {{0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}};
        Traversal obj = new Traversal();
        boolean b = obj.checkIfPathExists(matrix);
        System.out.println(b);
    }
}
