import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String calcules = br.readLine().trim();
        String[] calcule = calcules.split("-");
        int[] realCal = new int[calcule.length];
        //System.out.println(Arrays.toString(calcule));
        for (int i = 0; i < calcule.length; i++) {
            int sum=0;
            for (String num : calcule[i].split("\\+")) {
                sum += Integer.parseInt(num);
            }
            realCal[i] = sum;
        }
        int result = realCal[0];
        for(int i=1; i<realCal.length; i++)
            result -=realCal[i];
        System.out.println(result);

    }
}