import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1979_어디에단어가들어갈수있을까 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		int N, K;
		int[][] arr;
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0, total = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] == 1) {	// 흰색일때 (오른쪽, 아래쪽 탐색)
						if(j-1<0 || (j-1 >= 0 && arr[i][j-1]==0)) {	// 오른쪽 탐색 (이전 위치(현재의 왼쪽)가 검정색이었을 때 탐색시작)
							cnt = 1;
							for(int k = j+1; k < N; k++) {	// 흰색 개수 세기
								if(arr[i][k]==1) cnt++;
								else break;
							}
							
							if(cnt==K) {
								total++;
							}
						}
						if(i-1<0 || (i-1 >= 0 && arr[i-1][j]==0)) {	// 아래쪽 탐색 (이전 위치(현재의 위쪽)가 검정색이었을 때 탐색시작)
							cnt = 1;
							for(int k = i+1; k < N; k++) {	// 흰색 개수 세기
								if(arr[k][j]==1) cnt++;
								else break;
							}
							
							if(cnt==K) {
								total++;
							}
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + total);
		}
	}

}
