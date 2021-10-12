package algorithm_2110;

public class 다음큰숫자_Pro {
	public static void main(String[] args) {
		int n = 78;
		int answer = 0;
		// int num=n;
		// String str="";
		// str=make(num);
		// str = Integer.toBinaryString(n);
		// System.out.println("str"+str);
		// int cnt = count1(str);
		int cnt = Integer.bitCount(n);

		// System.out.println("num"+num);
		// System.out.println("cnt"+cnt);

		for (int i = n + 1;; i++) {

			if (Integer.bitCount(i) == cnt) {
				answer = i;
				System.out.println(answer);
				return;
			}

		}

		// return answer;
	}
// private static int count1(String str) {
//     int cnt=0;
//     for(int i=0; i<str.length(); i++){
//         if(str.charAt(i) == '1'){
//             cnt++;
//         }
//     }
//     return cnt;
// }
// private static String make(int num) {
//    String str = "";
//      while(num > 0){
//             str += num % 2;
//             num = num/2;
//         }
//     return str;
// }
}
