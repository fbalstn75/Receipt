package chapter5;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main6 {

	// 일정 수의 칸을 맞추기 위한 메소드
	public static String nameChange(String k09_item, int k09_len) throws UnsupportedEncodingException {		
		String k09_temp, k09_newName; // 스트링 값 temp와 newName를 선언
		byte[] k09_byte1 = k09_item.getBytes("euc-kr");	// euc-kr 형식으로 바이트 단위로 쪼갬
		if (k09_byte1.length < 15) { // byte1의 길이가 15바이트 미만일 경우
			k09_temp = k09_item; // 아이템이름을 그대로 출력
		} else { // 그렇지 않을 경우
			int k09_count = 0; // 정수형 변수 count를 선언하고 0으로 초기화
			for (int k09_i = 0; k09_i <k09_len; k09_i++) { // i값이 len까지 1씩 증가하면서 반복
				if ((k09_byte1[k09_i] & 0x80) == 0x80) k09_count++; // & 연산자를 통해 해당 바이트가 한글인지를 확인
			}
			// 마지막 바이트-1 값이 한글이거나 count를 나눈값이 홀수이면 마지막 바이트를 자름
			if ((k09_byte1[k09_len - 1] & 0x80) == 0x80 && (k09_count % 2) == 1) k09_len--;
			k09_temp = new String(k09_byte1, 0, k09_len, "euc-kr");	// 0에서 len까지 자른 스트링을 저장
		}
		k09_temp = k09_temp + "                          "; // 남은 칸을 빈칸으로 맞추기 위함
		byte[] byte2 = k09_temp.getBytes("euc-kr"); // euc-kr 형식으로 바이트를 다시 쪼갬
		k09_newName = new String(byte2, 0, 15, "euc-kr"); // newName에 euc-kr 형식으로 0에서 15바이트까지 자른 스트링을 저장	
		return k09_newName;	// newName값을 반환
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		int k09_taxfreeSum = 0, k09_iPrice = 0, k09_taxSum = 0, k09_realPrice, k09_taxPrice; // 각종 변수를 선억하고 초기화
		double k09_taxRate = 0.1; // 세율 10%
		DecimalFormat k09_df = new DecimalFormat ( "###,###,###,### "); // 3자리마다 콤마를 찍기위함
		Calendar k09_cal = Calendar.getInstance(); // 현재 시간을 가져옴
		SimpleDateFormat k09_sdt = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss"); // 시간 출력 형식을 지정함
		// 상품 이름을 배열에 저장
		String[] k09_itemname = {"도드람한돈 냉장 앞다리", "오리온 썬칩 오리지널", "허쉬 밀크초콜렛 프레첼", "농심 포스틱", "청양고추 50g",
				"해태 허니버터칩", "2080 스마트케어 칫솔 4입",	"서울우유 1000ml", "오리온 꼬북칩 인절미 80g", "헤시온 옥수수고추맛 콘",
				"오리온 오감자딥 양념바베큐", "빙그레 바나나우유", "마이셰프 wanted양파", "매일 바이오 생크림 요거트", "프레시지 밀푀유나베",
				"3M 베이직 고무장갑 중", "레이즈 솔트 & 비네거", "아임닭 닭가슴살 꾸이칩", "삼립 롱스틱 누네띠네", "신선누리 청상추 100g",
				"농심 새우깡", "MANNA 칠레산 씨없는 청포도", "CJ 밥이랑 야채", "칼로바이 퍼펙트 파워 프로틴바", "Think your dog teeth", 
				"인비바 파인애플칩", "롯데 ABC 초콜릿", "롯데 드림카카오 72%", "KC 썬스위트 노랑옥수수", "페레로로쉐 T-3"};
		// 상품 가격을 배열에 저장
		int[] k09_price = {8500, 1250, 5000, 1500, 1100, 1400, 2600, 2800, 1500, 1100, 1400, 3800, 7500, 3300, 14900,
				2000, 3900, 2500, 2390, 1500, 2500, 6000, 2500, 1800, 6500, 3300, 5300, 2850, 4900, 9990000};
		// 상품 수량을 배열에 저장
		int[] k09_num = {2, 1, 3, 4, 1, 2, 3, 5, 1, 2, 3, 1, 4, 2, 2, 6, 2, 8, 10, 2, 3, 1, 1, 4, 2, 3, 5, 1, 3, 2};
		// 면세물품과 과세물품 여부를 배열에 저장
		boolean[] k09_taxfree = {true, false, false, false, true, false, false, true, false, false, 
				false, true, false, true, false, false, false, false, false, true,
				false, true, true, false, false, false, false, false, true, false};

		for (int k09_a = 0; k09_a < k09_itemname.length; k09_a++) { // a값이 배열 itemname의 길이만큼 1씩 증가하면서 반복
			if (k09_taxfree[k09_a] == true) { // taxfree의 값이 true일 경우
				k09_taxfreeSum += k09_price[k09_a]*k09_num[k09_a]; // 면세합계에 값을 더함
			} else if (k09_taxfree[k09_a] == false) { // taxfree의 값이 false일 경우
				k09_taxSum += k09_price[k09_a]*k09_num[k09_a];  // 과세합계에 값을 더함
			}
		}

		for (int k09_b = 0; k09_b < k09_itemname.length; k09_b++) { // b값이 itemname의 길이만큼 1씩 증가하면서 반복
			k09_iPrice += k09_price[k09_b]*k09_num[k09_b]; // 총합계에 값을 더함
		}
		k09_realPrice = (int)(k09_taxSum/(1+k09_taxRate)); // 세전 가격
		k09_taxPrice = k09_taxSum - k09_realPrice; // 과세 금액	

		System.out.printf("              이마트 죽전점 (031)888-1234\n"); // 영수증 시작
		System.out.printf("    emart     206-86-50913 강희석        \n"); // 대표자 이름
		System.out.printf("              용인 수지구 포은대로 552   \n"); // 가게 위치
		System.out.printf("영수증 미지참시 교환/환불 불가           \n"); 
		System.out.printf("정상상품에 한함, 30일 이내(신선 7일)     \n"); // 환불 약관
		System.out.printf("※일부 브랜드매장 제외(매장 고지물참조)   \n");
		System.out.printf("교환/환불 구매점에서 가능(결제카드 지참) \n");
		System.out.printf("[구 매]%s  POS:0011-9861\n", k09_sdt.format(k09_cal.getTime())); // 구매 날짜 포스기 번호
		System.out.printf("-----------------------------------------\n"); // 구분선
		System.out.printf("  상품명             단 가  수량    금 액\n"); // 상품명, 단가, 수량, 금액
		System.out.printf("-----------------------------------------\n"); // 구분선
		if (k09_itemname.length <= 5) {	// 아이템 항목이 5개 이하인 경우
			for (int k09_i = 0; k09_i < k09_itemname.length; k09_i++) { // j값이 i에서 i+5까지 1씩 증가하면서 반복
				if (k09_taxfree[k09_i] == true) { // taxfree가 true일 경우
					System.out.printf("* %s%11s%4s%11s\n", nameChange(k09_itemname[k09_i], 15), // *을 붙여 단가, 수량, 가격을 출력
							k09_df.format(k09_price[k09_i]), k09_df.format(k09_num[k09_i]), k09_df.format(k09_price[k09_i]*k09_num[k09_i]));
				}	else {	// 그렇지 않을 경우
					System.out.printf("  %s%11s%4s%11s\n", nameChange(k09_itemname[k09_i], 15), // 단가, 수량, 가격을 출력
							k09_df.format(k09_price[k09_i]), k09_df.format(k09_num[k09_i]), k09_df.format(k09_price[k09_i]*k09_num[k09_i]));
				}
			}	System.out.printf("-----------------------------------------\n"); // 구분선
		} else if(k09_itemname.length > 5) { // 아이템 항목이 5개 초과인 경우
			for (int k09_i = 0; k09_i < k09_itemname.length; k09_i = k09_i + 5) {  // i값이 0에서 itemname의 길이만큼 5씩 증가하면서 반복		
				for (int k09_j = k09_i; k09_j < k09_i+5; k09_j++) { // j값이 i에서 i+5까지 1씩 증가하면서 반복
					if (k09_taxfree[k09_j] == true) { // taxfree가 true일 경우
						System.out.printf("* %s%10s%4s%11s\n", nameChange(k09_itemname[k09_j], 15), // *을 붙여 단가, 수량, 가격을 출력
								k09_df.format(k09_price[k09_j]), k09_df.format(k09_num[k09_j]), k09_df.format(k09_price[k09_j]*k09_num[k09_j]));
					}	else {	// 그렇지 않을 경우
						System.out.printf("  %s%10s%4s%11s\n", nameChange(k09_itemname[k09_j], 15), // 단가, 수량, 가격을 출력
								k09_df.format(k09_price[k09_j]), k09_df.format(k09_num[k09_j]), k09_df.format(k09_price[k09_j]*k09_num[k09_j]));
					}			
				}		
				System.out.printf("-----------------------------------------\n"); // 구분선
			}
		}
		System.out.printf("          총 품목 수량         %10d\n", k09_itemname.length); // 총 품목 수량
		System.out.printf("       (*)면 세  물 품         %11s\n", k09_df.format(k09_taxfreeSum)); // 면세 물품 출력
		System.out.printf("          과 세  물 품         %11s\n", k09_df.format(k09_realPrice)); // 과세 물품 출력
		System.out.printf("          부   가   세         %11s\n", k09_df.format(k09_taxPrice)); // 부가세 출력
		System.out.printf("          합        계         %11s\n", k09_df.format(k09_iPrice)); // 합계 출력
		System.out.printf("결제대상금액                   %11s\n", k09_df.format(k09_iPrice)); // 결제대상 금액 출력
		System.out.printf("-----------------------------------------\n"); // 구분선
		System.out.printf("0012 KEB 하나        54170**0484/35860658\n"); // 결제 카드
		System.out.printf("카드결제(IC)          일시불 / %11s\n", k09_df.format(k09_iPrice)); // 일시불 및 금액 출력
		System.out.printf("-----------------------------------------\n"); // 구분선
		System.out.printf("            [신세계포인트 적립]          \n"); // 신세계 포인트
		System.out.printf("홍*두 고객님의 포인트 현황입니다.        \n"); // 포인트 현황
		System.out.printf("금회발생포인트       9350**9995       164\n"); // 포인트 적립 현황
		System.out.printf("누계(가용)포인트         5,637(    5,473)\n"); // 누적 포인트 현황
		System.out.printf("*신셰계포인트 유효기간은 2년입니다.      \n"); // 유효기간
		System.out.printf("-----------------------------------------\n"); // 구분선
		System.out.printf("    구매금액기준 무료주차시간 자동부여   \n"); // 무료주차시간
		System.out.printf("차량번호 :                       34저****\n"); // 차량번호
		System.out.printf("입차시간 :            %s\n", k09_sdt.format(k09_cal.getTime())); // 입차 시간
		System.out.printf("-----------------------------------------\n"); // 구분선
		System.out.printf("캐셔:084599 양OO                     1150\n"); // 캐셔
		System.out.printf("    111111111111111111111111111111111    \n"); // 바코드
		System.out.printf("      20210303/00119861/00164980/31      \n"); // 영수증 마무리
	}
}