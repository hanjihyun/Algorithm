package algorithm_2104;

class 행렬의덧셈_Pro {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        // System.out.println(arr1[0].length);
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                int x = arr1[i][j] + arr2[i][j];
                // System.out.println(x);
                answer[i][j] = x;
            }

        }

        return answer;
    }
}