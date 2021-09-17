import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1767_프로세서연결하기2 {

	static int N;
	static int[][] map;
	static int[] dr = {-1,1,0,0};	// 상하좌우
	static int[] dc = {0,0,-1,1};
	static int coreMax, lineMin;	// 최대 코어수, 최소 전선수
	static ArrayList<Data> list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());	// 멕시노스 크기 N*N
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 가장자리 제외한 cell을 list에 저장
			list = new ArrayList<>();
			for(int i = 1; i < N-1; i++) {
				for(int j = 1; j < N-1; j++) {
					if(map[i][j] == 1) {
						list.add(new Data(i,j));						
					}
				}
			}

			// 코어수, 전선수 값 초기화
			coreMax = 0;
			lineMin = 0;
			
			// dfs 재귀
			dfs(0,0,0,0);
			
			sb.append("#" + t + " " + lineMin + "\n");
		}
		
		System.out.println(sb);
	}
	
	// idx : 현재 list 인덱스
	// cnt : 고른 코어 수
	// coreCnt : 전선을 설치한 코어 수
	// sum : 설치한 전선 수
	static void dfs(int idx, int cnt, int coreCnt, int sum) {
				
		// 모든 코어를 전선에 연결했으면 최소 전선 수 구하기
		if(cnt == list.size()) {
			// 코어수가 같을때 전선 길이의 합 최소값 저장
			if(coreMax == coreCnt) {
				lineMin = Math.min(lineMin, sum);
			}
			// 최대 코어수일때 코어수와 전선수 변경
			else if(coreMax < coreCnt) {
				coreMax = coreCnt;
				lineMin = sum;
			}
			return;
		}
		
		int nr, nc;
		// 리스트에 저장된 코어 순서대로 상하좌우 탐색
		for(int i = idx; i < list.size(); i++) {
			for(int d = 0; d < 4; d++) {
				nr = list.get(i).r + dr[d];
				nc = list.get(i).c + dc[d];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N)	// 범위 벗어나면 continue
					continue;
				
				if(map[nr][nc] != 0)	// 전선을 설치할 수 없는 자리이면 continue
					continue;
								
				// 전선 설치
				boolean check = false;	// 전선을 설치 가능 여부 체크
				int lineSum = 0;
				while(true) {
					// 범위 벗어나면 설치 X
					if(nr<0 || nr>=N || nc<0 || nc>=N)
						break;
					
					if(map[nr][nc] != 0) {	// 전선이나 코어를 만나면 전선을 설치할수 없으므로 break
						check = true;
						break;
					}
					
					map[nr][nc] = 2;	// 전선 설치
					lineSum++;	// 전선 개수 + 1
					
					// 다음 위치로 이동
					nr = nr + dr[d];
					nc = nc + dc[d];
				}
				
				// 전선 설치 가능할때
				if(!check) {
					// 다음 코어 위치로 이동
					dfs(i+1, cnt+1, coreCnt+1, sum+lineSum);
					
					// 전선 다시 해제
					nr = list.get(i).r + dr[d];
					nc = list.get(i).c + dc[d];
					while(true) {
						// 범위 벗어나면 전선을 다 해제했으므로 break
						if(nr<0 || nr>=N || nc<0 || nc>=N)
							break;
						
						if(map[nr][nc] == 2)
							map[nr][nc] = 0;	// 전선 해제
						
						// 다음 위치로 이동
						nr = nr + dr[d];
						nc = nc + dc[d];
					}
				}
				// 전선 설치할 수 없을때
				else {
					// 전선 다시 해제
					int start = list.get(i).r + dr[d];
					int end = list.get(i).c + dc[d];
					while(true) {
						// 범위 벗어나면 전선을 다 해제했으므로 break
						if(start<0 || start>=N || end<0 || end>=N)
							break;
						
						if(start==nr && end==nc)	// 전선을 설치하는 중간에 break로 빠져나왔으므로 전선을 설치했던 곳 까지 해제
							break;
						
						if(map[start][end] == 2)
							map[start][end] = 0;	// 전선 해제
						
						// 다음 위치로 이동
						start = start + dr[d];
						end = end + dc[d];
					}
					
					dfs(i+1, cnt+1, coreCnt, sum);
				}
			}
		}
	}
	
	static class Data{
		int r, c;

		public Data(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}