package Algorithm_base;

public class 버블정렬 {
	public static void main(String[] args) {
		//앞의 값이 뒤의 값보다 크면 바꿔라
		int[] arr = {5,1,3,7,2};
		//내림차순
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
//				System.out.println(i+" "+j);
				if(arr[j] < arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
				
			}
			System.out.print(i+1+"단계 : ");
			for (int k = 0; k < arr.length; k++) {
				System.out.print(arr[k]);
			}
			System.out.println();
		}

		for (int k = 0; k < arr.length; k++) {
			System.out.print(arr[k]);
		}
		System.out.println();
	}
}
