package algorithm_HW;


import java.util.Arrays;
import java.util.Scanner;

public class 회의실배정_백준1931 {
	static int N;
	static Meeting[] arr;
	static class Meeting implements Comparable<Meeting> {
		int from, to;

		protected Meeting(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}

//		@Override
//		public int compareTo(Meeting o) {
//			// TODO Auto-generated method stub
//			return Integer.compare(this.to, o.to);
//		}

		@Override
        public int compareTo(Meeting o) {
            
            int time = this.to - o.to;
            // 종료시간이 틀리면
            if(time != 0){ 
                return time;
            }
            // 종료시간이 같으면 시작시간이 빠른 순
            return this.from - o.from; 
        }

		@Override
		public String toString() {
			return "Meeting [from=" + from + ", to=" + to + "]";
		}
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 회의의 수
		arr = new Meeting[N];
		int MaxMeet = 0;
	
		int start=0;
		int end=0;
		for (int i = 0; i < N; i++) {
			 start = sc.nextInt();
			 end = sc.nextInt();
			arr[i] = new Meeting(start, end);
		}
//		print(arr);
		Arrays.sort(arr);
//		System.out.println();
//		print(arr);
		
		// 다음 것이 그 전 것 끝난 시간보다 회의가 빨리 시작하면 pass
		int endT = arr[0].to;
		if(arr[0].to>=arr[0].from && arr[0].from>=0) {
			MaxMeet++;
		}
		for (int i = 1; i < N; i++) {
			
			if (endT <= arr[i].from) {
				MaxMeet++;
				endT = arr[i].to;
//				System.out.print(endT+" "+arr[i].from+" ");
			}

		}
		System.out.println(MaxMeet);
	}

//	private static void print(Meeting[] arr) {
//		for (Meeting meeting : arr) {
//			System.out.println(meeting);
//		}
//	}
}
