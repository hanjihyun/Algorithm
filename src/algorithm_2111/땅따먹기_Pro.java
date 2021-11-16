package algorithm_2111;

public class 땅따먹기_Pro {

	static boolean[][] v;
	static int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };

	static int ans = 0;

	public static void main(String[] args) {

		v = new boolean[land.length][4];

//		dfs(0, 0);
//		int answer = ans;

		
		int answer = 0;
		
		for (int i = 1; i < land.length; i++) {
			land[i][0]+=Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
			land[i][1]+=Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
			land[i][2]+=Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
			land[i][3]+=Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
			
		}
		
		for (int i = 0; i < 4; i++) {
			answer = Math.max(answer, land[land.length-1][i]);
		}
		System.out.println(answer);

	}

	private static void dfs(int r, int sum) {
		if (r == land.length) {
			ans = Math.max(ans, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (!v[r][i]) {
				sum += land[r][i];
				if (r < land.length - 1) {
					v[r + 1][i] = true;
				}
				dfs(r + 1, sum);
				if (r < land.length - 1) {
					v[r + 1][i] = false;
				}
				sum -= land[r][i];
			}
		}
	}

}
