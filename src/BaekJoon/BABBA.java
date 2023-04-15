import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine().trim());
        ArrayList<Integer> aFibo = new ArrayList<>();
        ArrayList<Integer> bFibo = new ArrayList<>();
        aFibo.add(1);
        aFibo.add(0);
        bFibo.add(0);
        bFibo.add(1);
        for (int i = 2; i <= num; i++) {
            aFibo.add(aFibo.get(i - 2) + aFibo.get(i - 1));
            bFibo.add(bFibo.get(i - 2) + bFibo.get(i - 1));
        }
        System.out.println(aFibo.get(num) + " " + bFibo.get(num));
    }
}