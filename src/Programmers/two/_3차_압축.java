import java.util.*;
class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        char a = 'A';
        int index=1;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i='A'; i<='Z'; i++){
            map.put(String.valueOf((char)i),index++);
        }

        List<Integer> list = new ArrayList<>();
        String alpa = "";
        int start=0, last=1;
        String str = "", mapper="";
        try{
            while(last < msg.length()-1 && start < msg.length()-1){
                str = ""+msg.charAt(start);
                String nextStr = ""+msg.charAt(last);
                mapper = str+nextStr;
                //만약 map에 str키 값이 있으면 nextStr을 str에 더해 줘서 그 값을 키 값으로 넣음 만약 키 값이 넣어지면 start++ 안넣어지면 str = str + nextStr하고 nextSTr구해서 반복 start = start + str.length()
                if(map.get(str) !=null){
                    while(last < msg.length() && start < msg.length() && map.get(mapper) !=null){
                        str +=msg.charAt(last);
                        last++;
                        nextStr = ""+msg.charAt(last);
                        mapper +=nextStr;
                    }
                    map.put(mapper,index++);
                    list.add(map.get(str));

                    start+= str.length();
                    last = start+1;
                }
            }}catch(Exception e){

        }
        System.out.println(list);


        return answer;
    }
}