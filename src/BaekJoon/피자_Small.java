import java.io.*;
import java.util.Arrays;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine().trim());
        int[] array = new int[num+2];
        array[1] =0;
        array[2] = 1;
        for(int i=3; i<=num; i++){
            if(i%2==0)
                array[i] = (i/2)*(i/2) + array[i/2]*2;
            else
                array[i] = (i/2)*(i/2+1) + array[i/2]+array[i/2+1];
        }
        System.out.println(array[num]);

    }
}