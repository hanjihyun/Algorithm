package algorithm_2104;

class 평균구하기_Pro {
    public double solution(int[] arr) {
        double answer = 0;
        // System.out.println(arr.length);
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        answer = sum / arr.length;
        return answer;
    }
}