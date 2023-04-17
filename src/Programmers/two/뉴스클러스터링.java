import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        System.out.println(str1+ " " +str2);
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        List<String> list = new LinkedList<>();
        for(int i=0; i<str1.length()-1; i++){
            String sub =str1.substring(i,i+2);
            if(isAlpabat(sub)) map1.put(sub,map1.getOrDefault(sub,0)+1);
        }
        for(int i=0; i<str2.length()-1; i++){
            String sub =str2.substring(i,i+2);
            if(isAlpabat(sub)) map2.put(sub,map2.getOrDefault(sub,0)+1);
        }

        //교집합 사이즈 구하기
        for(String key : map1.keySet()){
            if(map2.containsKey(key)){
                int min = Math.min(map1.get(key),map2.get(key));
                for(int i=0; i<min; i++)
                    list.add(key);
            }
            System.out.println(list);
        }
        int subLength = list.size();
        list.clear();
        //합집합 사이즈 구하기
        for(String key : map1.keySet()){
            int max = Math.max(map1.getOrDefault(key,0),map2.getOrDefault(key,0));
            map2.put(key, max);
        }
        int unionLength = 0;
        for(int value : map2.values())
            unionLength += value;
        answer = (int)(1.0*subLength/unionLength*65536);
        //공집합일떄 처리
        if(map1.isEmpty() && map2. isEmpty())
            answer = 1*65536;
        return answer;

    }
    public boolean isAlpabat(String sub){
        boolean isAlpa = true;
        for(char ch : sub.toCharArray()){
            if(!Character.isLetter(ch)) isAlpa = false;
        }
        return isAlpa;
    }
}