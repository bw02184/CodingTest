import java.util.ArrayList;

class Solution {
    //(최소값,최소값), (최대값,최대값)으로 거리 구하기
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        ArrayList<Paper> list = new ArrayList<>();
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    list.add(new Paper(i, j));
                }
            }
        }
        int minX = 51, minY = 51, maxX = -1, maxY = -1;
        for (int i = 0; i < list.size(); i++) {
            minX = Math.min(list.get(i).getX(), minX);
            minY = Math.min(list.get(i).getY(), minY);
            maxX = Math.max(list.get(i).getX() + 1, maxX);
            maxY = Math.max(list.get(i).getY() + 1, maxY);

        }
        answer[0] = minX;
        answer[1] = minY;
        answer[2] = maxX;
        answer[3] = maxY;

        return answer;
    }

    class Paper {
        private int x;
        private int y;

        public Paper(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public String toString() {
            return x + " " + y;
        }
    }
}