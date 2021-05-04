package algorithm_2105;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 장군_백준16509 {
    static boolean[][] board;
    static Queue<Point> q;
    static int dr1[] = { 0, 0, 1, 1, 0, 0, -1, -1 };
    static int dc1[] = { 1, 1, 0, 0, -1, -1, 0, 0 };
    static int dr2[] = { -1, 1, 1, 1, 1, -1, -1, -1 };
    static int dc2[] = { 1, 1, 1, -1, -1, -1, -1, 1 };
    static int dr3[] = { -1, 1, 1, 1, 1, -1, -1, -1 };
    static int dc3[] = { 1, 1, 1, -1, -1, -1, -1, 1 };
    static Point sang, wang;

    static class Point {
        int x, y, cnt;

        public Point(int x, int y, int cnt) {
            super();
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sang = new Point(0, 0, 0);
        wang = new Point(0, 0, 0);
        sang.x = sc.nextInt();
        sang.y = sc.nextInt();
        sang.cnt = 0;
        wang.x = sc.nextInt();
        wang.y = sc.nextInt();
        board = new boolean[10][9];
        board[sang.x][sang.y] = true;// 상
        // board[wang.x][wang.y] = true; // 왕

        // for (int i = 0; i < 10; i++) {
        // for (int j = 0; j < 9; j++) {
        // System.out.print(board[i][j]);
        // }
        // System.out.println();
        // }
        q = new LinkedList<Point>();
        q.add(sang);
        System.out.println(bfs());
    }

    private static int bfs() {

        while (!q.isEmpty()) {
            Point po = q.poll();
            board[po.x][po.y] = true;

            if (po.x == wang.x && po.y == wang.y) {
                return po.cnt;
            }
            for (int i = 0; i < 8; i++) {
                int nr = po.x + dr1[i];
                int nc = po.y + dc1[i];
                if ((nr == wang.x && nc == wang.y) || nr < 0 || nc < 0 || nr >= 10 || nc >= 9)
                    continue;
                nr = nr + dr2[i];
                nc = nc + dc2[i];
                // 경로의 장애물 & 장기판 범위 확인하기 2
                if ((nr == wang.x && nc == wang.y) || nr < 0 || nc < 0 || nr >= 10 || nc >= 9)
                    continue;
                nr = nr + dr3[i];
                nc = nc + dc3[i];
                // 장기판 범위 & 방문 여부 확인하기
                if (nr < 0 || nc < 0 || nr >= 10 || nc >= 9 || board[nr][nc] == true)
                    continue;

                q.add(new Point(nr, nc, po.cnt + 1));
                board[nr][nc] = true;
            }
        }
        return -1;
    }

}
