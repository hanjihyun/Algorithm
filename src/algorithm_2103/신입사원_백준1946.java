package algorithm_2103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 신입사원_백준1946 {
	static int N;
	static List<Employee> list;
	static class Employee implements Comparable<Employee> {
		int doc, intV;

		protected Employee(int doc, int intV) {
			super();
			this.doc = doc;
			this.intV = intV;
		}

		@Override
		public int compareTo(Employee o) {
			// TODO Auto-generated method stub
			return this.doc - o.doc;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<Employee>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.add(new Employee(a, b));
			}

			Collections.sort(list);
			
			int cnt = 1;
			int min = list.get(0).intV;
			
			for (int i = 1; i < N; i++) {
				Employee e = list.get(i);
				if (e.intV <= min) {
					cnt++;
					min = e.intV;
				}
			}
			
			System.out.println(cnt);
		}
	}
}
