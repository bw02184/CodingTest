import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer  = {};
        //해싱해서 차량번호를 키값 총 시간을 벨류값으로 정하기
        //in만 있고 out이 없는경우 처리하기 arrayList로 in들어올때 생성 out일때 삭제
        //map2 : OUT이 마지막에 있는지 판단
        HashMap<String,String> map2 = new HashMap<>();
        HashMap<String,Integer> map1 = new HashMap<>();

        for(String record : records){
            String time = record.split(" ")[0];
            String carNum = record.split(" ")[1];
            String inOut = record.split(" ")[2];
            //처음 들어오거나 두번째로 들어올 경우
            if(!map2.containsKey(carNum) || map2.get(carNum).split(" ")[1].equals("OUT")){
                map2.put(carNum,time+" "+inOut);
            }
            else{
                if(map2.get(carNum).split(" ")[1].equals("IN") && inOut.equals("OUT")){
                    map1.put(carNum,map1.getOrDefault(carNum,0) + calTime(map2.get(carNum).split(" ")[0],time));
                    map2.put(carNum,time+" "+inOut);
                }
            }

        }
        //System.out.println(map1);
        //out출차 안한사람 시간 구하기
        for(String key : map2.keySet()){
            if(map2.get(key).split(" ")[1].equals("IN")){
                map1.put(key,map1.getOrDefault(key,0) + calTime(map2.get(key).split(" ")[0],"23:59"));
            }
        }
        //System.out.println(map1);
        //차량번호가 작은 순서대로 정렬
        List<String> keyList = new ArrayList<>(map1.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));
        int index=0;
        answer = new int[map1.size()];
        for(String key : keyList){
            answer[index++] = calPay(fees,map1.get(key));
        }
        return answer;
    }
    public static int calTime(String inTime, String outTime){
        int inTimeCal = Integer.parseInt(inTime.split(":")[0])*60
            + Integer.parseInt(inTime.split(":")[1]);
        int outTimeCal = Integer.parseInt(outTime.split(":")[0])*60
            + Integer.parseInt(outTime.split(":")[1]);
        return outTimeCal - inTimeCal;
    }

    public static int calPay(int[] fees, int time){
        int pay=0;
        if(time > fees[0]){
            pay = fees[1] + (int)(Math.ceil((time-fees[0])*1.0/fees[2]))*fees[3];
        }
        else pay = fees[1];
        return pay;
    }
}