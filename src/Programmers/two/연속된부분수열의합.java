class Solution {
  public int[] solution(int[] sequence, int k) {

    // 투 포인터 (lt, rt), 누적합 (sum), 현재 포인터 간 길이 (ptrLen) 초기화
    int lt = 0;
    int rt = 0;
    int ptrLen = Integer.MAX_VALUE;
    int sum = 0;
    int[] answer = new int[2];
    while (rt < sequence.length && lt <= rt) {

      // 첫 번째 접근 또는 rt가 바라보는 원소가 k와 같을 때
      if (lt == rt) {
        sum = sequence[lt];
      }

      // 현재 누적합이 k와 같은 경우
      if (sum == k) {

        // 현재 포인터 간 길이가 이전 포인터 간 길이보다 짧은 경우
        if (ptrLen > rt - lt + 1) {
          ptrLen = rt - lt + 1;
          answer[0] = lt;
          answer[1] = rt;
        }

        // 모든 원소는 양수이기 때문에 다음 경우의 수를 찾기 위해 lt를 증가 시킬 것이며, 누적합 계산을 위해 현재 sequence[lt] 값을 빼준다.
        sum -= sequence[lt];

        // rt도 마찬가지로 증가시킬 것이기 때문에 현재 누적합에 sequence[rt + 1]을 더해준다.
        if (rt + 1 < sequence.length) {
          sum += sequence[rt + 1];
        }

        // 두 포인터가 같은 경우 가장 짧은 길이이기 때문에 순회를 종료
        if (lt == rt) {
          break;
        }

        // 각 포인터 증가
        lt++;
        rt++;

      } else if (sum > k) {
        // 누적합이 k 보다 큰 경우 lt를 증가해가며 k와 같은 지를 비교
        sum -= sequence[lt];
        lt++;
      } else if (sum < k) {
        // 누적합이 k 보다 작은 경우 rt를 증가해가며 k와 같은 지를 비교
        if (rt + 1 < sequence.length) {
          sum += sequence[rt + 1];
        }
        rt++;
      }
    }
    return answer;
  }
}
