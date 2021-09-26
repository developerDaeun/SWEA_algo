import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_3282_01Knapsack {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		int N, K;
		int[] weights, profits, dp[];
		String[] s;
		for(int t = 1; t <= T; t++) {
			s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);	// 물건 개수
			K = Integer.parseInt(s[1]);	// 가방 부피
			weights = new int[N+1];	// 부피 저장 배열
			profits = new int[N+1];	// 가치 저장 배열
			dp = new int[N+1][K+1];
			
			for(int i = 1; i <= N; i++) {
				s = br.readLine().split(" ");
				weights[i] = Integer.parseInt(s[0]);	// 부피
				profits[i] = Integer.parseInt(s[1]);	// 가치
			}
			
			for(int i = 1; i <= N; i++) {
				for(int w = 1; w <= K; w++) {
					if(weights[i] > w) {	// 해당 물건을 가방에 담을 수 없을 때
						dp[i][w] = dp[i-1][w];
					}else {	// 해당 물건을 가방에 담을 수 있을 때
						dp[i][w] = Math.max(dp[i-1][w], profits[i] + dp[i-1][w-weights[i]]);	// 직전 물건까지의 가치와 현재 물건까지 중 최대값
					}
				}
			}
			
			sb.append("#" + t + " " + dp[N][K] + "\n");
		}
		
		System.out.print(sb);
	}

}