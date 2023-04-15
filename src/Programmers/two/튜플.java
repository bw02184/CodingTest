import java.util.*;
class Solution {
    public int[] solution(String s) {

        s=s.replaceAll("\\{|\\}","");
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        for(String str : s.split(",")){
            set.add(Integer.parseInt(str));
            map.put(str,map.getOrDefault(str,0)+1);
        }
        List<Integer> valueList = new ArrayList<>(map.values());
        int[] answer= new int[valueList.size()];

        valueList.sort((s1,s2) -> s2.compareTo(s1));
        for(int i=0; i<valueList.size(); i++){
            for(String key : map.keySet()){
                if(map.get(key) == valueList.get(i)){
                    answer[i] = Integer.parseInt(key);

                }
            }
        }
        return answer;
    }
}