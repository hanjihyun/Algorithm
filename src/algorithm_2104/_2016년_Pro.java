package algorithm_2104;
class _2016년_Pro {
        public String solution(int a, int b) {
            String answer = "";
            int[] months = {31,29,31,30,31,30,31,31,30,31,30,31};
            String[] days = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
            int day =0;
            for(int i=0; i<a-1; i++){
                day += months[i];
            }
           
            day = day + b;
            int how = day % 7;
            int dex = how + 4;
            if(dex > 6){dex=dex-7;}
             answer = days[dex];
             System.out.println(answer);
          
            return answer;
        }
    }
