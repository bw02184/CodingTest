import java.io.*;
import java.util.Arrays;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine().trim());
        for(int tc=0; tc<testCase; tc++){
            int num = Integer.parseInt(br.readLine().trim());
            System.out.println(fibonacci(num));
        }

    }
    public static int fibonacci(int num){
        int[] array = new int[num+2];
        array[0]=1;
        array[1]=1;
        for(int i=2;i<=num;i++){
            array[i] = array[i-2]+array[i-1];
        }
        return array[num];
    }
}