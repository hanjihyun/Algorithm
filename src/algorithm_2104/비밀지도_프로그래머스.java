package algorithm_2104;
public class 비밀지도_프로그래머스 {
	
	public static void main(String[] args) {
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		int n = 5;
		
		String[] Ans = solution(n,arr1,arr2);
		
		for (int i = 0; i < n; i++) {
			System.out.println(Ans[i]);
		}
	
		
	}
	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[][] ans  = new String[n][n];
        String[] answer = new String[n];
        int[][] one = new int[n][n];
        int[][] two = new int[n][n];
        
        for (int i = 0; i < arr1.length; i++) {
        	int num = arr1[i];
        	for (int j = n-1; j >= 0; j--) {
        		if(num % 2 == 1) {
        			one[i][j] = 1;
    			}else if(num % 2 == 0) {
    				one[i][j] = 0;
    			}
        		num = num/2;
        		
			}
		}
        for (int i = 0; i < arr2.length; i++) {
        	int num = arr2[i];
        	for (int j = n-1; j >= 0; j--) {
        		if(num % 2 == 1) {
        			two[i][j] = 1;
    			}else if(num % 2 == 0) {
    				two[i][j] = 0;
    			}
				num = num/2;
			
			}
		}
        System.out.println("One------------------");
        for (int i = 0; i < two.length; i++) {
			for (int j = 0; j < two.length; j++) {
				System.out.print(one[i][j]);
			}
			System.out.println();
		}
        System.out.println("Two-------------------");
        for (int i = 0; i < two.length; i++) {
			for (int j = 0; j < two.length; j++) {
				System.out.print(two[i][j]);
			}
			System.out.println();
		}
        
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(one[i][j] == 1 || two[i][j] == 1 ) {
					ans[i][j] = "#";
				}else if(one[i][j] == 0 || two[i][j] == 0) {
					ans[i][j] = " ";
				}
			}
		}
        
   
		for (int i = 0; i < n; i++) {
			String s = "";
			for (int j = 0; j < n; j++) {
				s += ans[i][j];
			}
			answer[i] = s;
		}
        return answer;
    }
}
