package chapter5;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int k09_i = 1; k09_i < 10; k09_i = k09_i+3) { // i값이 1에서 9까지 3씩 증가하면서 반복
			System.out.printf("********************************************\n"); // 별 출력
			System.out.printf("구구단 %d 단 \t 구구단 %d 단 \t 구구단 %d 단\n", k09_i, k09_i+1, k09_i+2); // 가로로 1씩 늘려가며 구구단 수 출력
			System.out.printf("********************************************\n"); // 별 출력
			for (int k09_j = 1; k09_j < 10; k09_j++) { // j값이 1에서 9까지 1씩 증가하면서 반복
			System.out.printf(" %d * %d = %2d \t %d * %d = %2d \t %d * %d = %2d\n", // i값 * j값 = i*j값을 가로로 3단씩 출력
					k09_i, k09_j, k09_i*k09_j, k09_i+1, k09_j, (k09_i+1)*k09_j, k09_i+2, k09_j, (k09_i+2)*k09_j);
			}			
		}
	}
}