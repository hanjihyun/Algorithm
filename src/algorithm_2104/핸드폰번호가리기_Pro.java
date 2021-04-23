class Solution {
    public String solution(String phone_number) {
        String answer = "";
        // System.out.println(phone_number.length());
        char[] ch = new char[phone_number.length()];
        for(int i=0; i< phone_number.length();i++){
            ch[i] = phone_number.charAt(i);
        }
        
        for(int i=phone_number.length()-5; i>=0; i-- ){
            ch[i] = '*';
        }
        for(int i=0; i< phone_number.length();i++){
        
            answer += ch[i];
        }
        return answer;
    }
}