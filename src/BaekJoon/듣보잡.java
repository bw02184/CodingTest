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
        int answer = 0;
        HashSet<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        for(int i=0; i<num1;i++)
            set.add(br.readLine().trim());
        while(answer++<num2){
            int bSize = set.size();
            String str = br.readLine().trim();
            set.add(str);
            if(bSize == set.size()){
                list.add(str);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(String s : list)
            System.out.println(s);
    }
}