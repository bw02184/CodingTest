import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = -1;
        StringBuilder sb = new StringBuilder();
        while(n>k){
            int idx = n%k;
            n /= k;
            sb.append(idx);
        }
        sb.append(n);
        sb.reverse();
        List<Long> list = new ArrayList<>();

        for(String s : sb.toString().split("0")){

            if(!s.equals("") && isPrime(Long.parseLong(s))) list.add(Long.parseLong(s));
        }
        System.out.println(list);
        return list.size();
    }
    public static boolean isPrime(long number){
        if(number == 1) return false;
        for(int i=2;i<=(int)(Math.sqrt(number)); i++){
            if(number%i ==0) return false;
        }
        return true;
    }
}