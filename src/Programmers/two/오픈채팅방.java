import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String, String> map = new HashMap<>();
        LinkedList<String> list = new LinkedList<>();
        for(String rd : record){
            String[] temp = rd.split(" ");
            if(temp[0].equals("Enter")){
                if(!map.containsKey(temp[1])){
                    map.put(temp[1],temp[2]);
                }
                else{
                    int index=-1;
                    for(String name : list){
                        index++;
                        if(name.split("\\|")[0].equals(temp[1])){
                            String temp2[] = name.split("\\|")[1].split(" ");
                            list.set(index,temp[1]+"|"+temp[2]+"님이 "+temp2[1]);
                        }
                    }
                }
                list.add(temp[1]+"|"+temp[2]+"님이 들어왔습니다.");
            }
            else if(temp[0].equals("Leave")){
                list.add(temp[1]+"|"+map.get(temp[1])+"님이 나갔습니다.");
            }
            else{
                map.put(temp[1],temp[2]);
                int index=-1;
                for(String name : list){
                    index++;
                    if(name.split("\\|")[0].equals(temp[1])){
                        String temp2[] = name.split("\\|")[1].split(" ");
                        list.set(index,temp[1]+"|"+temp[2]+"님이 "+temp2[1]);
                    }
                }
            }
        }
        // System.out.println(list);
        // System.out.println(map);
        answer = new String[list.size()];
        int index =0;
        for(String info : list){
            answer[index++]=info.split("\\|")[1];
        }
        return answer;
    }
}