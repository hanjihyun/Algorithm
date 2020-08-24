package algorithm_IM_Review;

import java.util.Arrays;

public class DisJointSetTest {
	static int[] parent = new int[6];
	static int N = 5;
	
	public static void main(String[] args) {
		N = 5;
		makeSet();
		
		union(0,1);
		union(1,2);
		union(1,3);
		union(2,5);
		
		for (int i = 0; i < N; i++) {
			System.out.println(find(i));			
		}		
		System.out.println(Arrays.toString(parent));
	}

	private static int find(int i) {//i의 부모를 찾는 메소드
		if(parent[i] == -1) {
			return i;
			
		}else {
			int pp = find(parent[i]);//부모의 부모(조부모)를 찾아
			parent[i] = pp;//i의 부모로 조부모를 넣어주고
			return pp;//그 조부모 값을 리턴
		}
		
	}

	private static void union(int i, int j) {
		int pi = find(i);
		int pj = find(j);
				
		if(pi != pj) {
			parent[j] = pi;//
		}
		System.out.print(i + "," + j + " union:");
		System.out.println(Arrays.toString(parent));
	}

	private static void makeSet() {
		Arrays.fill(parent, -1);		
	}
}
