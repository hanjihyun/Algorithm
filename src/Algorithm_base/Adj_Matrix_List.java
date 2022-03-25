package Algorithm_base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 *         1
 *     2      3
 *  4    5  6    7
 */
public class Adj_Matrix_List {
	static int N = 7;
	public static void main(String[] args) {
		// 인접행렬
		N = 7;
		int[][] adjMat = new int[N+1][N+1];
		adjMat[1][2] = 1;
		adjMat[2][1] = 1;
		adjMat[1][3] = 1;
		adjMat[3][1] = 1;
		adjMat[2][4] = 1;
		adjMat[4][2] = 1;
		adjMat[2][5] = 1;
		adjMat[5][2] = 1;
		adjMat[3][6] = 1;
		adjMat[6][3] = 1;
		adjMat[3][7] = 1;
		adjMat[7][3] = 1;
		//print(adjMat);
		// 탐색(bfs, dfs)
		//bfs(adjMat,1);
		System.out.println();
		System.out.println("--------------------------------");
		//dfs(adjMat,1,new boolean[N+1]);
		// 인접 리스트
		ArrayList[] adjList = new ArrayList[N+1];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i]=new ArrayList<Integer>();
		}
		adjList[1].add(2);
		adjList[1].add(3);
		adjList[2].add(1);
		adjList[3].add(1);
		adjList[2].add(4);
		adjList[2].add(5);
		adjList[4].add(2);
		adjList[5].add(2);
		adjList[3].add(6);
		adjList[3].add(7);
		adjList[6].add(3);
		adjList[7].add(3);
		
		//bfs(adjList,1);
		dfs(adjList, 1, new boolean[N+1]);
	}

	private static void dfs(ArrayList<Integer>[] adjList, int idx, boolean[] v) {
		ArrayList<Integer>[] aa = new ArrayList[10];
		
		v[idx]=true;
		System.out.print(idx + " ");
		int size = adjList[idx].size();
		for (int i = 0; i < size; i++) {
			Integer n = adjList[idx].get(i);
			if(!v[n]) {
				dfs(adjList,n,v);
			}
		}
		
	}

	private static void dfs(int[][] adjMat, int idx, boolean[] v) {
		v[idx]=true;
		System.out.print(idx + " ");
		for (int i = 1; i < adjMat[idx].length; i++) {
			if(adjMat[idx][i]==1 && !v[i]) {
				dfs(adjMat,i,v);
			}
		}
		
	}

	private static void bfs(ArrayList<Integer>[] adjList, int start) {
		boolean v[] = new boolean[N+1];
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(start);
		v[start]=true;
		while(!Q.isEmpty()) {
			Integer p = Q.poll();
			System.out.print(p+" ");
			int size = adjList[p].size();
			for (int i = 0; i < size; i++) {
				Integer n = adjList[p].get(i);
				if(!v[n]) {
					v[n]=true;
					Q.add(n);
				}
			}
		}
	}
	private static void bfs(int[][] adjMat, int start) {
		boolean v[] = new boolean[N+1];
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(start);
		v[start]=true;
		while(!Q.isEmpty()) {
			Integer p = Q.poll();
			System.out.print(p+" ");
			for (int i = 0; i < adjMat.length; i++) {
				if(adjMat[p][i]==1 && !v[i] ) {
					v[i]=true;
					Q.add(i);
				}
			}
		}
	}

	private static void print(int[][] adjMat) {
		for (int i = 1; i < adjMat.length; i++) {
			for (int j = 1; j < adjMat[i].length; j++) {
				System.out.print(adjMat[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
}
