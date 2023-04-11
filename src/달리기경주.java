import java.util.HashMap;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        for (int i = 0; i < callings.length; i++) {
            String findKey = "";
            for (String key : map.keySet()) {
                if (map.get(key) == map.get(callings[i]) - 1) {
                    findKey = key;
                    break;
                }
            }
            map.put(findKey, map.get(findKey) + 1);
            map.put(callings[i], map.get(callings[i]) - 1);
        }
        int index = 0;
        for (String key : map.keySet()) {
            answer[map.get(key)] = key;
        }
        return answer;
    }
}