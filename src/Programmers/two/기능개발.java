import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        LinkedList<Integer> list =new LinkedList<>();
        LinkedList<Integer> speed =new LinkedList<>();
        LinkedList<Integer> number =new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(int num : progresses){
            list.add(num);
        }
        for(int num : speeds)
            speed.add(num);
        int temp=0;
        while(list.size() >0){
            temp++;
            for(int i=0; i<list.size(); i++){
                list.set(i,list.get(i)+speed.get(i));
                //System.out.println(list);
            }
            while(list.size() >0 && list.get(0)>=100){
                list.remove(0);
                speed.remove(0);
                number.add(temp);
                //System.out.println(temp);
            }
        }
        for(int num: number)
            set.add(num);
        answer = new int[set.size()];

        int first =number.get(0);
        int index=0;
        for(int num : number){
            if(first == num)answer[index]++;
            else {
                index++;
                answer[index]++;
                first = num;
            }
        }
        return answer;
    }
}