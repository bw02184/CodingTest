package Programmers.one;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    private static final int YEAR = 12;
    private static final int DAY = 28;

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new LinkedList<>();

        Map<String, Integer> termMap = new HashMap<>();

        for (String term : terms) {
            String[] t = term.split(" ");
            termMap.put(t[0], Integer.valueOf(t[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            if (isFire(privacy, termMap, today)) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean isFire(String privacy, Map<String, Integer> term, String today) {
        String[] split = privacy.split(" ");
        String date = split[0];
        String type = split[1];
        int days = getDays(date);
        int fireDays = getFireDays(days, type, term);

        return fireDays <= getDays(today);
    }

    private int getDays(String date) {
        String[] a = date.split("\\.");
        int year = Integer.parseInt(a[0]);
        int month = Integer.parseInt(a[1]);
        int day = Integer.parseInt(a[2]);

        return (year * YEAR * DAY) + (month * DAY) + day;
    }

    private int getFireDays(int days, String type, Map<String, Integer> term) {
        int expirationDays = term.get(type) * DAY;
        return days + expirationDays;
    }

}