package chapter5; // 패키지 선언

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main5 { // 클래스 선언

	// 일정 수의 칸을 맞추기 위한 메소드
	public static String nameChange(String k09_item, int k09_len) throws UnsupportedEncodingException {		
		String k09_temp, k09_newName; // 스트링 값 temp와 newName를 선언
		byte[] k09_byte1 = k09_item.getBytes("euc-kr");	// euc-kr 형식으로 바이트 단위로 쪼갬
		if (k09_byte1.length < 26) { // byte1의 길이가 20바이트 미만일 경우
			k09_temp = k09_item; // 아이템이름을 그대로 출력
		} else { // 그렇지 않을경우
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
		k09_newName = new String(byte2, 0, 26, "euc-kr"); // newName에 euc-kr 형식으로 0에서 26바이트까지 자른 스트링을 저장	
		return k09_newName;	// newName값을 반환
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String k09_itemname1 = "오리온 아이셔 츄잉캔디 청사과맛(케이스)"; // 상품1 이름		
		String k09_itemcode1 = "1031615"; // 상품1 코드
		int k09_price1 = 7000000; // 상품1 가격
		int k09_amount1 = 1; // 상품1 수량

		String k09_itemname2 = "커널스 컵팝콘 크리미카라멜 중 65g"; // 상품2 이름		
		String k09_itemcode2 = "11008152"; // 상품2 코드
		int k09_price2 = 8000000; // 상품2 가격
		int k09_amount2 = 1; // 상품2 수량

		String k09_itemname3 = "레이즈 사워크림 & 어니언 감자칩 184g"; // 상품2 이름		
		String k09_itemcode3 = "1020800"; // 상품2 코드
		int k09_price3 = 9000000; // 상품2 가격
		int k09_amount3 = 1; // 상품2 수량

		int k09_iPrice = k09_price1 + k09_price2 + k09_price3; // 합계 금액
		double k09_taxRate = 0.1; // 세율 10%
		int k09_realPrice = (int)((k09_iPrice / (1+k09_taxRate))); // 세전 가격
		int k09_taxPrice = k09_iPrice - k09_realPrice; // 과세 금액

		DecimalFormat k09_df = new DecimalFormat ( "###,###,###,### "); // 3자리마다 콤마를 찍기위함
		Calendar k09_cal = Calendar.getInstance(); // 현재 시간을 가져옴
		SimpleDateFormat k09_sdt = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss"); // 시간 출력 형식을 지정함			

		System.out.printf("              \"국민가게, 다이소 \"             \n"); // 영수증 시작
		System.out.printf("(주)아성다이소_분당서현점                       \n"); // 가게이름 출력
		System.out.printf("전화:031-702-6016                               \n"); // 전화번호 출력
		System.out.printf("본사:서울 강남구 남부순환로 2748 (도곡동)       \n"); // 본사 출력
		System.out.printf("대표:박정부,신호섭 213-81-52063                 \n"); // 대표 출력
		System.out.printf("매장:경기도 성남시 분당구 분당로53번길 11 (서현 \n"); // 매장 출력
		System.out.printf("동)                                             \n"); // 매장 이어서 출력
		System.out.printf("================================================\n"); // 구분선
		System.out.printf("          소비자중심경영(CCM) 인증기업          \n"); // 기업정보1 출력
		System.out.printf("        ISO 9001 품질경영시스템 인증기업        \n"); // 기업정보2 출력
		System.out.printf("================================================\n"); // 구분선
		System.out.printf("          교환/환불 14일(3월12일)이내,          \n"); // 교환/환불일 출력
		System.out.printf("(전자)영수증, 결제카드 지참 후 구입매장에서 가능\n"); // 교환 방법 출력
		System.out.printf("       포장/가격 택 훼손시 교환/환불 불가       \n"); // 교환 불가 출력
		System.out.printf("         체크카드 취소 시 최대 7일 소요         \n"); // 교환 내용 출력
		System.out.printf("================================================\n"); // 구분선
		System.out.printf("[POS 1058231]                %s\n", k09_sdt.format(k09_cal.getTime())); // 현재 시간을 츌룍
		System.out.printf("================================================\n"); // 구분선
		System.out.printf("%s%9s%2s%11s\n", nameChange(k09_itemname1,26), k09_df.format(k09_price1), // 상품1의 이름, 가격, 수량 출력
				k09_df.format(k09_amount1), k09_df.format(k09_price1*k09_amount1));
		System.out.printf("[%s]\n", k09_itemcode1);								 // 상품1 코드 출력
		System.out.printf("%s%9s%2s%11s\n", nameChange(k09_itemname2,26), k09_df.format(k09_price2), // 상품2의 이름, 가격, 수량 출력
				k09_df.format(k09_amount2), k09_df.format(k09_price2*k09_amount2));
		System.out.printf("[%s]\n", k09_itemcode2);								 // 상품2 코드 출력
		System.out.printf("%s%9s%2s%11s\n", nameChange(k09_itemname3,26), k09_df.format(k09_price3), // 상품3의 이름, 가격 수량 출력
				k09_df.format(k09_amount3), k09_df.format(k09_price3*k09_amount3));
		System.out.printf("[%s]\n", k09_itemcode3);                              // 상품3 코드 출력
		System.out.printf("                과세합계              %11s\n", k09_df.format(k09_realPrice)); // 과세합계 출력
		System.out.printf("                  부가세              %11s\n", k09_df.format(k09_taxPrice)); // 부가세 출력
		System.out.printf("------------------------------------------------\n"); // 구분선
		System.out.printf("판매합계                              %11s\n", k09_df.format(k09_iPrice)); // 판매합계 출력
		System.out.printf("================================================\n"); // 구분선
		System.out.printf("신용카드                              %11s\n", k09_df.format(k09_iPrice)); // 신용카드 출력
		System.out.printf("------------------------------------------------\n"); // 구분선
		System.out.printf("우리카드                        538720**********\n"); // 카드이름 출력
		System.out.printf("승인번호 77982843(0)         승인금액 %11s\n", k09_df.format(k09_iPrice)); // 승인번호 출력
		System.out.printf("================================================\n"); // 구분선
		System.out.printf("         %s 분당서현점\n", k09_sdt.format(k09_cal.getTime())); // 날짜 시간 및 지점 출력
		System.out.printf("상품 및 기타 문의 : 1522-4400                   \n"); // 기타 문의번호 출력
		System.out.printf("멤버십 및 샵다이소 관련 문의 : 1599-2211        \n"); // 멤버십 문의번호 출력
		System.out.printf("             11111 111 11 11111 111             \n"); // 바코드 출력
		System.out.printf("                2112820610158231                \n"); // 바코드 번호 출력
		System.out.printf("------------------------------------------------\n"); // 구분선
		System.out.printf(" ◈ 다이소 멤버십 앱 또는 홈페이지에 접속하셔서  \n"); // 안내 메세지 출력
		System.out.printf("   회원가입 후 다양한 혜택을 누려보세요! ◈");		 // 영수증 끝
	}
}