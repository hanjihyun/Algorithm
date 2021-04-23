import java.util.*;
class Solution {
   
    public int solution(int[] people, int limit) {
        int answer = people.length;
        int searchStartIdx = 0;
        Arrays.sort(people);
        int len = people.length - 1;
        
        for(int i=people.length - 1; i>=0; i--){
            if(i == searchStartIdx) break;
          if(people[i] + people[searchStartIdx] <= limit) {
                searchStartIdx += 1;
                answer -= 1;
            }

            if(i == searchStartIdx) break;
        }

        return answer;
    }
}