import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String, String> map = new HashMap<>();
        LinkedList<String> list = new LinkedList<>();
        for(String rd : record){
            String[] temp = rd.split(" ");
            if(temp[0].equals("Enter")){
                map.put(temp[1],temp[2]);
                list.add(temp[1]+"|"+temp[2]+"님이 들어왔습니다.");
            }
            else if(temp[0].equals("Leave")){
                list.add(temp[1]+"|"+map.get(temp[1])+"님이 나갔습니다.");
            }
            else{
                map.put(temp[1],temp[2]);
            }
        }
        //System.out.println(list);
        //System.out.println(map);
        answer = new String[list.size()];
        int index =-1;
        for(String info : list){
            index++;
            String[] temp = info.split("\\|");
            if(!temp[1].split("님이")[0].equals(map.get(temp[0]))){
                list.set(index, temp[0]+"|"+map.get(temp[0])+"님이 "+temp[1].split(" ")[1]);
            }
        }
        index=0;
        for(String info : list){
            answer[index++]=info.split("\\|")[1];
        }
        return answer;
    }
}