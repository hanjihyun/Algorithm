package Algorithm_base;

public class 선택정렬2 {
	public static void main(String[] args) {
		// 비교한 값의 index를 저장하여 index 이후의 값들과 계속 비교한다.
		int[] arr = { 5, 1, 3, 7, 2 };
		// 내림차순
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
//				System.out.println(i+" "+j);
				if (arr[i] < arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}

			}
			System.out.print(i+1 + "단계 : ");
			for (int k = 0; k < arr.length; k++) {
				System.out.print(arr[k]);
			}
			System.out.println();
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
