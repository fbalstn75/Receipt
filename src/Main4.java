package chapter5;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k09_iPrice = 33000; // 주문합계 액
		double k09_taxRate = 0.1; // 세액 10%	
		int k09_realPrice = (int)(Math.ceil(k09_iPrice / (1+k09_taxRate))); // 세전가격
		int k09_taxPrice = k09_iPrice - k09_realPrice;	// 과세금액		
		DecimalFormat k09_df = new DecimalFormat ( "###,###,###,### "); // 3자리마다 콤마를 찍기위함
		Calendar k09_cal = Calendar.getInstance(); // 현재 시간을 가져옴
		SimpleDateFormat k09_sdt = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss"); // 시간 출력 형식을 지정함
		System.out.printf("신 용 승 인                                     \n"); // 영수증 시작
		System.out.printf("단말기 : 2N68665898            전표번호 : 041218\n"); // 단말기, 전표번호 출력
		System.out.printf("가맹점 : 한양김치찌개\n");							 // 가맹점 출력
		System.out.printf("주  소 : 경기 성남시 분당구 황새울로351번길 10 ,\n"); // 주소 출력
		System.out.printf("1층\n");
		System.out.printf("대표자 : 유창신\n");								  	 // 대표자 출력
		System.out.printf("사업자 : 752-53-00558              TEL : 7055695\n"); // 사업자 출력
		System.out.printf("------------------------------------------------\n"); // 구분선		
		System.out.printf("금  액                               %8s 원\n", k09_df.format(k09_realPrice)); // 금액을 3자리마다 콤마를 찍어 출력		
		System.out.printf("부가세                               %8s 원\n", k09_df.format(k09_taxPrice)); // 부가세를 3자리마다 콤마를 찍어 출력		
		System.out.printf("합  계                               %8s 원\n", k09_df.format(k09_iPrice)); // 합계를 3자리마다 콤마를 찍어 출력
		System.out.printf("------------------------------------------------\n"); // 구분선
		System.out.printf("우 리 카 드                                     \n"); // 카드이름 출력
		System.out.printf("카드번호 : 5387-20**-****-4613(S)         일시불\n"); // 카드번호 출력
		System.out.printf("거래일시 : %s\n", k09_sdt.format(k09_cal.getTime())); // 거래일시 출력
		System.out.printf("승인번호 : 70404427                             \n"); // 승인번호 출력
		System.out.printf("거래번호 : 357734873739                         \n"); // 거래번호 출력
		System.out.printf("매입 : 비씨카드사      가맹 : 720068568         \n"); // 매입 출력
		System.out.printf("알림 : EDC매출표                                \n"); // 알림 출력
		System.out.printf("문의 : TEL)1544-4700                            \n"); // 문의 출력
		System.out.printf("------------------------------------------------\n"); // 구분선
		System.out.printf("                 * 감사합니다 *                 \n"); // 감사합니다 출력
		System.out.printf("                              표준V2.08_20200212\n"); // 영수증 마무리
	}
}