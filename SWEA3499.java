import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {	// 테케
			int N = Integer.parseInt(br.readLine());	// 카드 갯수
			st = new StringTokenizer(br.readLine(), " ");
			
			String[] cards = new String[N];
			
			int end = N%2==1 ? N/2 : N/2-1;	// 홀수이면 N/2 까지, 짝수이면 N/2-1까지
			int cnt = 1;	// 카드의 오른쪽 반일때 홀수번에만 넣어야하므로 1,3,5,... 카운트
			
			for(int i = 0; i < N; i++) {
				String s = st.nextToken();
				if(i <= end) {		// 카드의 왼쪽 반 -> 0,2,4,... 인덱스에 저장
					cards[i*2] = s;
				}else{				// 카드의 오른쪽 반 -> 1,3,5,... 인덱스에 저장
					cards[cnt] = s;
					cnt=cnt+2;
				}
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < N; i++) {
				System.out.print(cards[i] + " ");
			}
			System.out.println();
		}
	}
}