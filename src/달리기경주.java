class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        for(String s : callings){
            int index = -1;
            for(int i=0; i<players.length; i++){
                if(players[i].equals(s)){
                    index = i;
                    break;
                }
            }String temp = players[index-1];
            players[index-1] = s;
            players[index] = temp;
        }
        return players;
    }
}