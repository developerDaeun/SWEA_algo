import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_5215_햄버거다이어트_DP {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int N, L;
		int[] scores, cal, dp[];
		String[] s;
		for(int t = 1; t <= T; t++) {
			s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);	// 재료의 수
			L = Integer.parseInt(s[1]);	// 제한 칼로리
			scores = new int[N+1];	// 맛 점수 저장 배열
			cal = new int[N+1];	// 칼로리 저장 배열
			dp = new int[N+1][L+1];
			
			for(int i = 1; i <= N; i++) {
				s = br.readLine().split(" ");
				scores[i] = Integer.parseInt(s[0]);
				cal[i] = Integer.parseInt(s[1]);
			}
			
			for(int i = 1; i <= N; i++) {
				for(int l = 1; l <= L; l++) {
					if(cal[i] > l) {	// 제한 칼로리보다 크면 담을 수 없음
						dp[i][l] = dp[i-1][l];
					}else {	// 제한 칼로리보다 작거나 같으면 담을 수 있음
						dp[i][l] = Math.max(dp[i-1][l], scores[i] + dp[i-1][l-cal[i]]);
					}
				}
			}
			
			sb.append("#" + t + " " + dp[N][L] + "\n");
		}
		
		System.out.print(sb);
	}

}