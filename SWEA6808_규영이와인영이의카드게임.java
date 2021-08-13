import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA6808_규영이와인영이의카드게임 {

	static int cardSum;
	static int winCnt;
	static int totalCnt = 1;
	static int[] gyuCard = new int[9];
	static int[] inCard = new int[9];
	static int[] inCardTemp = new int[9];

	static boolean[] isSelected = new boolean[9];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= 18; i++) cardSum+=i;	// 1~18까지의 총 카드 합
		for(int i = 2; i <= 9; i++) totalCnt *= i;	// 인영이가 카드를 내는 경우의 수 9!
		
		for(int t = 1; t <= T; t++) {	// 테케
			boolean[] checked = new boolean[19];	// 규영이, 인영이 카드 만들때 체크할 변수
			
			// 규영이 카드 입력
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 9; i++) {	
				gyuCard[i] = Integer.parseInt(st.nextToken());
				checked[gyuCard[i]] = true;
			}
			
			// 인영이 카드 입력
			int num = 0;
			for(int i = 1; i <= 18; i++) {
				if(!checked[i]) {
					inCard[num] = i;
					num++;
				}
			}
			
			calc(0);	// 카드 게임 시작
			
			bw.write("#" + t + " " + winCnt + " " + (totalCnt-winCnt) + "\n");	// 진 것 == (9! - 이긴 횟수)
			bw.flush();
			
			winCnt = 0;
		}
		bw.close();
	}

	static void calc(int cnt) {	// 바뀌는 값은 고른 인영이의 카드
		
		if(cnt == 9) {
			int total = 0;
			for(int i = 0; i < 9; i++) {	// 규영이의 총점 구하기
				if(gyuCard[i] > inCardTemp[i]) {
					total += gyuCard[i] + inCardTemp[i];
				}
			}
			if(total > (cardSum-total)) {	// 규영이의 총점이 (전체 카드 총점-규영의 총점)보다 크면 규영이가 이긴것
				winCnt++;
			}
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(isSelected[i]) continue;	// 이미 선택한 카드이면 continue
			isSelected[i] = true;
			inCardTemp[cnt] = inCard[i];
			calc(cnt+1);
			isSelected[i] = false;	
		}
	}
}