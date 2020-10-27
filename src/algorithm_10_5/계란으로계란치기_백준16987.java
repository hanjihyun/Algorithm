package algorithm_10_5;

import java.util.Scanner;
public class 계란으로계란치기_백준16987 {
	static int N,result;
	static Data[] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//읽기
		N = sc.nextInt();
		list = new Data[N];
		
		for (int i = 0; i < N; i++) {
			list[i] = new Data(sc.nextInt(), sc.nextInt());
		}
		//솔루션
		dfs(0,0);
		//출력
		System.out.println(result);
	}
	private static void dfs(int idx, int k) {
		//종료
		if(idx == N) {
			result = Math.max(result, k);
			return;
		}
		//손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다
		if(list[idx].s <= 0 || k == N-1) {
			//깰 것이 없을 때
			dfs(idx+1,k);
			return;
		}
		//구현
		int nCnt = k;
		for (int i = 0; i < N; i++) {
//			자기자신하고 하면 안됨
			if(idx == i) {
				continue;
			}
//			깨진 계란 무시
			if(list[i].s <= 0) {
				continue;
			}
			//깨기
			//재귀호출
			list[idx].s -= list[i].w;
			list[i].s -= list[idx].w;
			if(list[idx].s <= 0) {
				k++;
			}
			if(list[i].s <= 0) {
				k++;
			}
			dfs(idx+1,k);
			//백트레킹
			list[idx].s += list[i].w;
			list[i].s += list[idx].w;
			k = nCnt;
		}
	}
	static class Data{
		int s,w;

		Data(int s, int w) {
			super();
			this.s = s;
			this.w = w;
		}
		
	}
}
