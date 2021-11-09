package algorithm_2111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 배열합치기_백준 {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		int[] ab = new int[N+M];
		
		st = new StringTokenizer(br.readLine());
        int idx = 0;
        for(int i = 0; i < N; i++) {
            ab[idx++] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            ab[idx++] = Integer.parseInt(st.nextToken());
        }
		Arrays.sort(ab);
		
		
		for (int i = 0; i < ab.length; i++) {
			  sb.append(ab[i] + " ");
		}
		System.out.println(sb.toString());
	}
}
