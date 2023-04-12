import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashSet<String> set = new HashSet<>();
        for(String s : report){
            set.add(s);
        }
        String[][] array = new String[set.size()][2];

        Iterator<String> iter = set.iterator();
        HashMap<String,Integer> map = new HashMap<>();
        int index=0;
        while(iter.hasNext()){
            String[] temp = iter.next().split(" ");
            array[index++] = temp;
            map.put(temp[1],map.getOrDefault(temp[1],0)+1);

        }
        //System.out.println(Arrays.deepToString(array));
        //System.out.println(map);
        for(String key : map.keySet()){
            if(map.get(key) >=k)continue;
            else
                map.put(key,0);
        }
        //System.out.println(map);
        HashMap<String,Integer> map2 = new HashMap<>();
        //map >0인 것을 신고한 사람 찾기
        for(int i=0; i<array.length; i++){
            for(String key : map.keySet()){
                if(map.get(key)>0 && array[i][1].equals(key))
                    map2.put(array[i][0],map2.getOrDefault(array[i][0],0)+1);
            }
        }
        //System.out.println("map2: "+map2);
        int idx=0;
        for(String id : id_list){
            answer[idx++]=map2.getOrDefault(id,0);
        }


        return answer;
    }
}