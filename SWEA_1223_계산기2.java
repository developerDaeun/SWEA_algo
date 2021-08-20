import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 후위 표기식 사용 안함
 * 곱하기 연산자 '*'를 만나면 다음 피연산자까지 읽어서 미리 계산해서 list에 추가
 * 더하기 연산자 '+'를 만나면 list에 추가
 * 계산식이 끝나면 list에는 더할 피연산자들만 모아져 있으므로 모두 더함
 * */
public class SWEA_1223_계산기2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String N, S;
		int temp, sum;
		char c;
		ArrayList<Integer> list;	// 마지막에 모두 더할 피연산자 저장 리스트
		
		for(int t = 1; t <= 10; t++) {
			N = br.readLine();	// 계산식 길이
			S = br.readLine();	// 계산식
			list = new ArrayList<>();	// 더할 피연산자만 모아둔 리스트
			
			for(int i = 0; i < S.length(); i++) {
				c = S.charAt(i);	// 계산식 한개씩 문자 가져오기
				switch(c) {
				case '+':	// 더하기는 마지막에 한꺼번에 하므로 그냥 넘어가기
					break;
				case '*':
					temp = list.get(list.size()-1);	// 리스트의 마지막값(temp)을 * 뒤의 숫자와 곱하기 연산 후 리스트 마지막으로 수정
					list.set(list.size()-1, temp*(S.charAt(i+1) - '0'));
					i++;	// * 뒤의 숫자를 가져왔으므로 다음 문자로 이동
					break;
				default:	// 피연산자 일때 list에 추가
					list.add(c-'0');
				}
			}
			
			sum = 0;
			for(int i = 0; i < list.size(); i++) {	// 더할 것만 남은 피연산자를 모두 더함
				sum += list.get(i);
			}
			
			sb.append("#" + t + " " + sum + "\n");
		}
		
		System.out.println(sb);
	}
}