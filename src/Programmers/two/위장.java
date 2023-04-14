import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(String[] clothe : clothes){
            map.put(clothe[1],map.getOrDefault(clothe[1],0)+1);
        }
        int mul=1;
        for(int value : map.values()){
            mul *=1+value;
        }
        return mul-1;
    }
}