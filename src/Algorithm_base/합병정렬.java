package Algorithm_base;

public class 합병정렬 {
	// 더 이상 분할되지 않을 때까지 반절 씩 분할하여 비교
	// mergesort.
	public static void main(String[] args) {
		int[] array = { 230, 10, 60, 550, 40, 220, 20 };

		mergeSort(array, 0, array.length - 1);

		for (int v : array) {
			System.out.println(v);
		}
	}

	private static void mergeSort(int[] array, int i, int j) {
		// TODO Auto-generated method stub

	}
}
