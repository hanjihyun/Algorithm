package algorithm_2110;

public class 최소직사각형_Pro {
	public static void main(String[] args) {
		int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };
		int answer = 0;
		int hei = 0, len = 0;

		for (int j = 0; j < sizes.length; j++) {
			int lenMax = sizes[j][0];
			int heiMax = sizes[j][1];
//			System.out.println(lenMax + " " + heiMax);
			if (lenMax < heiMax) {
				int t = lenMax;
				lenMax = heiMax;
				heiMax = t;
			}
//			System.out.println("::" + lenMax + " " + heiMax);
			if (lenMax > len) {
				len = lenMax;
			}
			if (heiMax > hei) {
				hei = heiMax;
			}
		}
		answer = hei * len;
		System.out.println(answer);
	}
}
