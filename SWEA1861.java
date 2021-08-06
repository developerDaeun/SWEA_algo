import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1861 {

	static int N;
	static int[][] map;
	static int[] row = {-1,1,0,0};
	static int[] col = {0,0,-1,1};
	static int num = 1001;	// 출발 방 번호
	static int max = 1;	// 최대 이동한 방 개수
	static int cnt = 1;
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());	// 테케 갯수
		
		for(int t = 1; t <= T; t++) {	// 테케
			N = Integer.parseInt(br.readLine());	// 방 크기
			map = new int[N][N];	
			dp = new int[N][N];
			
			// 방크기 만큼 배열 생성
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");	// 한 줄씩 입력받아 공백 기준으로 arr에 삽입
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {	// 방 한개씩 재귀
				for(int j = 0; j < N; j++) {
					cnt = move(i,j,1);
					if(max < cnt) {	// 현재 최대 방 개수이면 max 값 변경
						max = cnt;
						num = map[i][j];
					}else if(max == cnt && num > map[i][j]) {	// 현재와 최대 방 개수가 같으면 더 작은 방 번호로 변경
						num = map[i][j];
					}
				}
			}
			System.out.println("#" + t + " " + num + " " + max);
			// 변수 초기화
			num = 1001;
			max = 1;
		}
	}
	
	static int move(int startR, int startC, int cnt) {	// 방 이동 함수
		
		if(dp[startR][startC] == 1) return dp[startR][startC];	// 이동할 방이 없는 경우 그대로 1이므로 return
		dp[startR][startC] = 1;
		
		for(int k = 0; k < 4; k++) {	// 사방탐색
			int r = startR + row[k];
			int c = startC + col[k];
			
			if(r < 0 || r >= N || c < 0 || c >= N) {	// 범위 벗어나면 continue
				continue;
			}
			
			if(map[startR][startC] + 1 == map[r][c]) {	// map[startR][startC] : 현재 방, map[r][c] : 다음 방, 현재 방보다 1이 큰 방이 있으면 다음 방 탐색
				dp[startR][startC] += move(r,c,cnt+1);	// 이전에 방문했던 방이 있으면 그 방에서 갈 수있는 방의 count를 dp에 저장
				return dp[startR][startC];	// 한번 방을 이동했으면 중복되는 숫자가 없으므로 더이상 갈 방이 없음 -> return
			}
		}
		
		return dp[startR][startC];
	}
}