class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[] dirY = {1,-1,0,0}; //UDRL
        int[] dirX = {0,0,1,-1}; //UDRL
        int maxUR=5, maxDL=-5;
        int x=0,y=0;
        boolean[][] visited = new boolean[maxUR*2][maxUR*2];
        visited[5][5]=true;
        for(String dir : dirs.split("")){
            int d = -1;
            if(dir.equals("U"))d=0;
            else if(dir.equals("D"))d=1;
            else if(dir.equals("R"))d=2;
            else if(dir.equals("L"))d=3;
            int nextX = x + dirX[d];
            int nextY = y + dirY[d];
            if(nextX>maxUR || nextX<maxDL || nextY>maxUR || nextY<maxDL)
                continue;
            int vX = nextX+maxUR;
            int vY = nextY+maxUR;
            System.out.println(nextY+" "+nextX+ " "+visited[vY][vX]);

            if(!visited[vY][vX])answer++;
            visited[vY][vX]=true;
            x = nextX;
            y = nextY;
        }
        return answer;
    }
}