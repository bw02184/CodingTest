import java.util.*;

class Solution {
  public String solution(int[] numbers) {
    String answer = "";
    String[] temp = new String[numbers.length];
    int index = 0;
    Number[] num = new Number[numbers.length];
    for (int n : numbers) {
      String sNum = "" + n;
      num[index] = new Number(n, sNum.length());
      num[index].setbNum(num[index].changeNum(n));
      index++;
    }
    // System.out.println(Arrays.toString(num));
    Arrays.sort(num);
    // System.out.println(Arrays.toString(num));
    for (int i = num.length - 1; i >= 0; i--) answer += num[i].getNum();
    return answer;
  }

  class Number implements Comparable<Number> {
    int num;
    int length;
    String bNum;

    public Number(int num, int length) {
      this.num = num;
      this.length = length;
    }

    public void setbNum(String bNum) {
      this.bNum = bNum;
    }

    public int getNum() {
      return this.num;
    }

    public String changeNum(int num) {
      String sNum = "" + num;
      while (sNum.length() < 3) {
        sNum += sNum.charAt(0);
      }
      return sNum;
    }

    public String toString() {
      return this.num + " " + this.length;
    }

    @Override
    public int compareTo(Number o) {
      return Integer.parseInt(this.bNum) - Integer.parseInt(o.bNum);
    }
  }
}
