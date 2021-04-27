package algorithm_2104;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 프린터큐_백준 {
    static int N, M;
    static Queue<Document> q;

    static class Document {
        int docuNumber; // 문서의 문서번호
        int pri; // 우선순위

        public Document(int docuNumber, int pri) {
            this.docuNumber = docuNumber;
            this.pri = pri;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();
            q = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                int pri = sc.nextInt();
                q.add(new Document(j, pri));
            }
            int result = 1;

            while (!q.isEmpty()) {
                Document doc = q.poll();

                Iterator<Document> it = q.iterator();
                boolean check = false;
                while (it.hasNext()) {
                    if (doc.pri < it.next().pri) {
                        check = true;
                        break;
                    }
                }
                if (check == true) {
                    q.add(new Document(doc.docuNumber, doc.pri));
                } else {
                    if (doc.docuNumber == M) {
                        System.out.println(result);
                    } else {
                        result++;
                    }
                }

            }
        }
    }
}
