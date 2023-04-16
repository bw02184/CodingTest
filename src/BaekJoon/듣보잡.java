import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        for(int i=0; i<num1;i++)
            list.add(br.readLine().trim());
        while(answer++<num2){
            String str = br.readLine().trim();
            if(list.contains(str)){
                System.out.println(str);
            }
        }
    }
}