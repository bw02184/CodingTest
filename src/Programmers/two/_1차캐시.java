import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedHashSet<String> set = new LinkedHashSet<>();
        LinkedList<String> list = new LinkedList<>();
        for(String city : cities){
            int bSize = set.size();
            set.add(city.toLowerCase());
            list.add(city.toLowerCase());
            //캐싱이 되어있을때
            if(set.size() == bSize){
                answer++;
                list.remove(city.toLowerCase());
            }
            else{
                answer +=5;
                if(set.size() !=0 && set.size() >cacheSize){
                    set.remove(list.get(0));
                    list.remove(0);
                }
            }
        }
        return answer;
    }
}