class Solution {
  public long[] solution(long[] numbers) {
    long[] answer = new long[numbers.length];
    int index = 0;

    for (long number : numbers) {
      if (number % 2 == 0) answer[index++] = number + 1;
      else {
        StringBuilder sb = new StringBuilder();
        long number2 = number;
        while (number2 > 0) {
          sb.append(number2 % 2);
          number2 /= 2;
        }
        sb.append(0);
        String sNum = sb.toString();
        int temp = 0;
        for (int i = 0; i < sNum.length() - 1; i++) {
          if (sNum.charAt(i) == '1' && sNum.charAt(i + 1) == '0') {
            sb.setCharAt(i, '0');
            sb.setCharAt(i + 1, '1');
            temp = i;
            break;
          }
        }
        answer[index++] = number - (long) Math.pow(2, temp) + (long) Math.pow(2, temp + 1);
        // answer[index++] = Long.parseLong(""+Long.parseLong(sb.reverse().toString()),2);
      }
    }
    return answer;
  }
}
