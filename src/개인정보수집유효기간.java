import java.util.Arrays;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        String[] todays = today.split("\\.");
        String index="";
        for(int i=0; i<privacies.length; i++){
            String[] expire = privacies[i].split("\\.| ");
            //System.out.println(Arrays.toString(expire));

            String[] newExpire = makeExpired(expire,terms);
            //System.out.println(Arrays.toString(newExpire));
            boolean temp2 = isDeleted(newExpire, todays);
            if(temp2){index +=i+1;
                index += " ";
            }
            //System.out.println(temp2);
            //System.out.println(Arrays.toString(expire));
        }
        String[] temp3 = index.split(" ");
        answer = Arrays.stream(temp3).mapToInt(Integer::parseInt).toArray();

        //System.out.println(index);
        return answer;
    }
    public String[] makeExpired(String[] expire, String[] terms){

        for(String t : terms){
            int term=0;
            if(String.valueOf(t.charAt(0)).equals(expire[3]))  term = Integer.parseInt(t.split(" ")[1]);
            if(Integer.parseInt(expire[1]) + term > 12){
                expire[1] =""+(Integer.parseInt(expire[1]) + term - 12);
                if(expire[1].length() ==1) expire[1] = "0"+expire[1];
                expire[0] = ""+(Integer.parseInt(expire[0]) + 1);
            }
            else{
                expire[1] =""+(Integer.parseInt(expire[1]) + term);
                if(expire[1].length() ==1) expire[1] = "0"+expire[1];
            }
        }

        return expire;
    }

    public boolean isDeleted(String[] newExpire, String[] todays){
        int finalExpired = Integer.parseInt(newExpire[0]+newExpire[1]+newExpire[2]);
        int finalTodays = Integer.parseInt(todays[0]+todays[1]+todays[2]);
        if(finalExpired >finalTodays)
            return false;
        return true;
    }
}