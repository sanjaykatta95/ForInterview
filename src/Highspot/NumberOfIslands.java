package Highspot;

public class NumberOfIslands {

    static int m, n;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main2(String[] args) {
        m = 4;
        n = 5;
        int count = 0;
        int[][] matrix = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dfs(matrix, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int[][] matrix, int i, int j) {
        matrix[i][j] = 0;
        for (int[] dir : dirs) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if (isValid(new_i, new_j) && matrix[new_i][new_j] == 1) {
                dfs(matrix, new_i, new_j);
            }
        }
    }

    private static boolean isValid(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
