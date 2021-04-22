package chapter5;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k09_iWeekday = 6; // 1월 1일이 금요일이기 때문에 6으로 초기화
		int[] k09_iEnd = {31,29,31,30,31,30,31,31,30,31,30,31}; // 매달 마지막일을 배열에 저장
		for (int k09_iMon = 0; k09_iMon < 12; k09_iMon++) { // iMon값이 0에서 11까지 1씩 증가하면서 반복
			System.out.printf("\n\n            %d월\n", k09_iMon + 1); // 월 출력
			System.out.printf("===========================\n"); // = 출력
			System.out.printf(" 일  월  화  수  목  금  토\n"); // 요일 출력
			// i값이 1에서 매달 마지막일까지 1씩 증가하면서 반복
			for (int k09_i = 1; k09_i <= k09_iEnd[k09_iMon]; k09_i++) {
				if (k09_i == 1) { // i값이 1일때
					for (int k09_j = 1; k09_j < k09_iWeekday; k09_j++) { // 매월 1일 까지
						System.out.printf("    "); // 빈칸을 채움
					}
				}
				if (k09_i < 10) { // i값이 10보다 작을 때
					System.out.printf(" "); // 칸을 맞추기위해 빈칸 삽입
				}
					System.out.printf(" "+k09_i+" "); // 날짜를 출력
				if (k09_iWeekday % 7 == 0) { // 요일이 7일때 
					System.out.println(); // 줄을 바꿔줌
					k09_iWeekday = 0; // 요일을 0으로 초기화
				}
				k09_iWeekday++; // 요일을 매일 더함
			}
		}
	}
}