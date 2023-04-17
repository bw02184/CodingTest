import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        LinkedList<Paper> list = new LinkedList<>();
        int index=0;
        int max=0;
        for(int priority : priorities){
            list.add(new Paper(priority,index++));
            if(max<priority)
                max = priority;
        }
        //System.out.println(list);
        while(true){
            int num = list.get(0).getNum();
            if(num < max){
                list.add(list.remove(0));
            }
            else{
                if(list.get(0).getIndex() == location)
                    return answer;
                else answer++;
                list.remove(0);
                max = 0;
                for(Paper paper : list){
                    if(max < paper.getNum())
                        max = paper.getNum();
                }
            }

            //System.out.println(list + " " +max+ " "+ answer);
        }
        //return answer;

    }
    class Paper{
        private int num;
        private int index;
        public Paper(int num, int index){
            this.num = num;
            this.index = index;
        }
        public String toString(){
            return this.num + " " + this.index;
        }
        public int getNum(){
            return this.num;
        }
        public int getIndex(){
            return this.index;
        }
    }

}