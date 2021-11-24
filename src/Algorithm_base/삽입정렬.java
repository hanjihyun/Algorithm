package Algorithm_base;

public class 삽입정렬 {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 3, 7, 2 };
		//오름차순
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			
			while(j >= 0 && arr[j]>key) {
				arr[j+1] = arr[j]; //뒤의 값을 앞으로, 우측으로 shift
				j--;
			}
			arr[j+1] = key;
			System.out.print(i+"단계 : ");
			for (int k = 0; k < arr.length; k++) {
				System.out.print(arr[k]);
			}
			System.out.println();
		}
	}
}
