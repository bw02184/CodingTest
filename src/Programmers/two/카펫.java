package Programmers.two;

import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        int[] array = commonFactors(total);
        System.out.println(Arrays.toString(array));
        for(int i=1; i<=array.length-2;i++){
            if((array[i]-2)*(array[array.length-i-1]-2)==yellow){
                answer[0] = Math.max(array[array.length-i-1],array[i]);
                answer[1] = Math.min(array[array.length-i-1],array[i]);
                break;
            }
        }
        return answer;
    }
    public int[] commonFactors(int num){
        List<Integer> list = new LinkedList<>();
        for(int i=1; i<=num; i++){
            if(num%i == 0) list.add(i);
        }
        int[] array = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            array[i] = list.get(i);
        return array;
    }
}