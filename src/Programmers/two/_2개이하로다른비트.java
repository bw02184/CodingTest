class Solution {
  public long[] solution(long[] numbers) {
    long[] answer = new long[numbers.length];
    int index = 0;

    for (long number : numbers) {
      if (number % 2 == 0) answer[index++] = number + 1;
      else {
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
          sb.append(number % 2);
          number /= 2;
        }
        sb.append(0);
        String sNum = sb.toString();
        for (int i = 0; i < sNum.length() - 1; i++) {
          if (sNum.charAt(i) == '1' && sNum.charAt(i + 1) == '0') {
            sb.setCharAt(i, '0');
            sb.setCharAt(i + 1, '1');
            break;
          }
        }
        answer[index++] = Long.parseLong("" + Long.parseLong(sb.reverse().toString()), 2);
      }
    }
    return answer;
  }
}
