package algorithm_2111;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _3차파일명정렬_Pro {
	 public String[] solution(String[] files){
	        Arrays.sort(files, new Comparator<String>() {
	            public int compare(String o1, String o2) {
	                //숫자를 처음 만나는 곳에서 문자열을 자른다
	                String h1 = o1.split("[0-9]")[0];
	                String h2 = o2.split("[0-9]")[0];

	                //대소문자 구분이 없기때문에 소문자로 바꿔주고 copareTo를 해준다.
	                int result = h1.toLowerCase().compareTo(h2.toLowerCase());
	                //문자열로 결정할수 없는 경우
	                if(result == 0){
	                    //findNum메소드를 호출하여 숫자를 비교한다.
	                    result = findNum(o1,h1) - findNum(o2,h2);
	                }
	                return result;
	            }
	        });

	        return files;
	    }
	protected int findNum(String s, String h) {
		 s = s.replace(h,"");
	        String result = "";
	        for(char c : s.toCharArray()){
	            //isDigit은 문자가 숫자인지 아닌지를 판별해주는 메서드다 또한 문제에서 길이가 5이하라고 했으므로 조건을 걸어준다.
	            if(Character.isDigit(c) && result.length()<5){
	                result +=c;
	            }else{
	                break;
	            }
	        }
	        // 결과값을 정수로 만들어서 리턴한다.
	        return Integer.valueOf(result);
	}
	public static void main(String[] args) {
		String[] files = { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" };
		String[] answer = new String[files.length];
		_3차파일명정렬_Pro s = new _3차파일명정렬_Pro();
		System.out.println(Arrays.toString(s.solution(files)));
	}
}
