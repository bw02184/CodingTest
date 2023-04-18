class Solution {

    static int[] dx = {1, 0, 0, -1};  //차례대로 남쪽으로 이동(S), 동쪽으로(E), 서쪽으로(W), 북쪽으로(N)
    static int[] dy = {0, 1, -1, 0};
    static int nx = 0;  //현재 좌표, static으로 두고 계속 업데이트해준다.
    static int ny = 0;

    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2]; //정답 배열 -> 마지막에 nx, ny를 넣는다.
        int sx = 0; //시작 위치 x좌표
        int sy = 0; //시작 위치 y좌표

        for (int i = 0; i < park.length; i++) { //시작 위치 좌표 찾기
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') { //S일 경우 sx, sy에 좌표 저장
                    sx = i;
                    sy = j;
                }
            }
        }

        nx = sx;  //현재 위치에 시작 위치 저장
        ny = sy;


        for (String route : routes) { //명령어 돌기
            char dir = route.charAt(0); //명령어의 방향
            int cnt = route.charAt(2) - '0'; //명령어의 횟수, char를 숫자로 바꿔준다.

            if (dir == 'S') { //남쪽으로 이동할 경우, dx, dy 배열의 0번째 값을 넣게 되므로 0 전달
                check(0, cnt, park);
            } else if (dir == 'E') {
                check(1, cnt, park);
            } else if (dir == 'W') {
                check(2, cnt, park);
            } else {
                check(3, cnt, park);
            }
        }

        answer[0] = nx; //정답 배열 answer에 nx, ny 넣기
        answer[1] = ny;

        return answer;
    }//main

    static void check(int dir, int cnt, String[] park) {
        int nowX = nx; //명령어가 취소될 수 있으므로 임시 변수에 넣어준다.
        int nowY = ny;
        boolean isCompleted = false;  //최종 nx, ny에 업데이트해줘도 되는지 확인하는 변수

        for (int i = 0; i < cnt; i++) {
            int nextX = nowX + dx[dir]; //전달받은 dir값으로 nextX, nextY를 구한다.
            int nextY = nowY + dy[dir];

            //범위를 벗어날 경우 false, break
            if (nextX < 0 || nextX >= park.length || nextY < 0 || nextY >= park[0].length()) {
                isCompleted = false;
                break;
            }

            //장애물이 있을 경우 false, break
            if (park[nextX].charAt(nextY) == 'X') {
                isCompleted = false;
                break;
            }

            //nowX, nowY에 nextX, nextY를 넣고, isCompleted를 true로 해준다.
            nowX = nextX;
            nowY = nextY;
            isCompleted = true;
        }

        if (isCompleted) { //반복문이 끝난 후에도 isCompleted가 true면 올바른 명령이기 때문에 최종 nx, ny에 업데이트한다.
            nx = nowX;
            ny = nowY;
        }

    }//check

}//class