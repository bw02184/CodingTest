package Programmers.one;

import java.util.HashMap;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
            map2.put(i, players[i]);
        }
        for (int i = 0; i < callings.length; i++) {
            int value = map.get(callings[i]);
            String beforename = map2.get(value - 1);
            map.put(callings[i], value - 1);
            map.put(beforename, map.get(beforename) + 1);
            map2.put(value - 1, callings[i]);
            map2.put(value, beforename);
        }
        int index = 0;
        for (String key : map.keySet()) {
            answer[map.get(key)] = key;
        }
        return answer;
    }
}