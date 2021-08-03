import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA1289 {

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int num = 1;	// #1, #2 출력을 위한 숫자
		String s = null;	// String 입력받기
		char[] bits = null;	// String을 char Array로 변경
		int cnt = 0;
		while(T-- > 0) {
			cnt = 0;
			s = sc.next();
			bits = s.toCharArray();
			if(bits[0] == '1') {	// 맨 앞 비트가 1이면 카운트 + 1
				cnt++;
			}
			for(int i = 0; i < bits.length - 1; i++) {	// 앞과 뒤 비트가 다르면 + 1
				if(bits[i] != bits[i+1]) {
					cnt++;
				}
			}
			System.out.println(String.format("#%d %d", num, cnt));
			num++;
		}
	}
}