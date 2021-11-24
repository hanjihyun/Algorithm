package Algorithm_base;

public class 선택정렬 {
	public static void main(String[] args) {
		// 최소값을 찾아 저장
		int[] arr = { 5, 1, 3, 7, 2 };
		// 내림차순
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
//				System.out.println(i + " " + j);
				if (arr[j] > arr[min]) {
					min = j;
				}
			}
			if(min!=i) {
				int tmp = arr[i];
				arr[i] = arr[min];
				arr[min] = tmp;
			}
			System.out.print(i+1+"단계 : ");
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j]);
			}
			System.out.println();
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
