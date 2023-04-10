import java.util.Stack;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int num : arr)
            stack.push(num);
        while(stack.size() >=2){
            int a = stack.pop();
            int b = stack.pop();
            stack.push(lcm(a,b));
        }
        System.out.println(stack);
        return stack.pop();

    }

    public int gcd(int a, int b){
        int min = Math.min(a,b);
        int factor = 1;
        for(int i=2; i<=min; i++){
            if(a%i ==0 && b%i==0) factor=i;
        }
        return factor;
    }
    public int lcm(int a, int b){
        return a*b/gcd(a,b);
    }

}