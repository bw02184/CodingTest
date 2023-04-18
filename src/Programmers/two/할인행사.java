import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String,Integer> map1 = new HashMap<>();
        for(int i=0; i<want.length; i++){
            map1.put(want[i],number[i]);
        }
        HashMap<String,Integer> map2 = new HashMap<>(map1);
        int sum=0;
        for(int num : number)
            sum += num;
        //초기 루프
        for(int i=0; i<sum; i++){
            if(map2.get(discount[i]) !=null)
                map2.put(discount[i],map2.get(discount[i])-1);
        }
        //System.out.println(map2);
        int left=0, right=sum-1;
        while(right < discount.length-1){
            //System.out.println(left + " " + right+ " "+map2);

            //한 사이클 당 원하는 물건이 모두 있는지 확인
            boolean isZero = true;
            for(int value : map2.values()){
                if(value != 0) isZero = false;
            }
            if(isZero) answer++;
            left++; right++;
            //왼쪽은 원복, 오른쪽은 물건있으면 만큼 빼기
            if(map2.get(discount[left-1]) !=null) {
                map2.put(discount[left-1],map2.get(discount[left-1])+1);
            }
            if(map2.get(discount[right]) !=null){
                map2.put(discount[right],map2.get(discount[right])-1);
            }
        }
        //한 사이클 당 원하는 물건이 모두 있는지 확인
        boolean isZero = true;
        for(int value : map2.values()){
            if(value != 0) isZero = false;
        }
        if(isZero) answer++;
        //System.out.println(left + " " + right+ " "+map2);

        return answer;
    }
}