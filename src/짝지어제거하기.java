class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        while(true){
            int bSize = s.length();
            s=s.replaceAll("aa|bb|cc|dd|ee|ff|gg|hh|ii|jj|kk|ll|mm|nn|oo|pp|qq|rr|ss|tt|uu|vv|ww|xx|yy|zz","");
            if(bSize ==s.length())break;

        }if(s.equals(""))answer = 1;
    else answer = 0;
        return answer;
    }
}