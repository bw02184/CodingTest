import java.io.*;
import java.util.Arrays;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=0; tc<testCase; tc++){
            int floor = Integer.parseInt(br.readLine().trim());
            int number = Integer.parseInt(br.readLine().trim());
            System.out.println(floorNumber(floor, number));
        }

    }
    public static int floorNumber(int floor, int number){
        int[][] array = new int[floor+1][number+1];
        for(int i=0; i<=number; i++) {
            array[0][i] = i;
        }
        for(int i=1;i<=floor;i++){
            for(int j=0;j<=number;j++){
                for(int k=0; k<=j; k++){
                    array[i][j] += array[i-1][k];
                }
            }
        }
        return array[floor][number];
    }
}