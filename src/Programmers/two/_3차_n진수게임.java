import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int index=0;
        while(sb.length()<=t*m){
            sb.append(redix(index++,n));
        }
        String[] sTemp = sb.toString().split("");
        //System.out.println(Arrays.toString(sTemp));
        int i=p-1;
        int count =0;
        while(count++ < t){
            answer +=sTemp[i];
            //System.out.print(i+ " " );
            i+=m;
        }
        return answer;
    }
    public static String redix(int number, int rdx){
        StringBuilder s = new StringBuilder();
        if(number ==0 )return "0";
        while(number >0){
            int n = number%rdx;
            String nString=""+n;
            if(n >=10 && n<16){
                switch(n){
                    case 10:nString="A";break;
                    case 11:nString="B";break;
                    case 12:nString="C";break;
                    case 13:nString="D";break;
                    case 14:nString="E";break;
                    case 15:nString="F";break;
                }
            }
            s.append(nString);
            number /= rdx;
        }
        s.reverse();
        return s.toString();
    }
}