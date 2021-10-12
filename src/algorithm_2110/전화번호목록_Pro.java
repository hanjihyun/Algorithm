package algorithm_2110;

import java.util.HashMap;

public class 전화번호목록_Pro {
	public static void main(String[] args) {
		String[] phone_book = { "119", "97674223", "1195524421" };
		 boolean ans = true;
//       for(int i=0; i<phone_book.length-1; i++){
//           for(int j=i+1; j<phone_book.length; j++){
//               if(phone_book[i].startsWith(phone_book[j])){
//                   return false;
//               }
//               if(phone_book[j].startsWith(phone_book[i])){
//                   return false;
//               }
            
//           }
//       }
      HashMap<String,Integer> hash = new HashMap<>();
      for(int i=0; i<phone_book.length; i++){
          hash.put(phone_book[i],i);
      }
      
      for(int i=0; i<phone_book.length; i++){
           for(int j=1; j<phone_book[i].length(); j++){
               if(hash.containsKey(phone_book[i].substring(0,j))){
                   ans = false;
                   System.out.println(ans);
                   return;
//                   return ans;
               }
           }
      }
		
	}
}
