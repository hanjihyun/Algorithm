package algorithm_2111;

public class 큰수만들기_Pro {

	
	public static void main(String[] args) {
		String number = "1231234";
		int k = 3;
		StringBuilder answer = new StringBuilder();
	
		int max = -1;
		int idx = 0;
		for(int i=0; i<number.length()-k; i++){
			max = -1;
            for(int j=idx; j<=i+k; j++){
                if(max < number.charAt(j)-'0'){
                	max = number.charAt(j)-'0';
                    idx = j+1;
                }
            }
            answer.append(max);
        }
		System.out.println(answer.toString());
	}

}
