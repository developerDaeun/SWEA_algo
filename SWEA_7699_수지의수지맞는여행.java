import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7699_수지의수지맞는여행 {

	static int R, C;
	static char[][] map;
	static boolean[] v = new boolean[26];	// 알파벳 사용 여부 체크
	static int[] dr = {-1,1,0,0};	// 상하좌우
	static int[] dc = {0,0,-1,1};
	static int res;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			
			for(int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			res = 1;	// 명물개수 최대치를 수지의 위치에 있는 알파벳 개수인 1로 초기화
			
			v[map[0][0]-65] = true;
			dfs(0, 0, 1);
			v[map[0][0]-65] = false;
			
			sb.append("#" + t + " " + res + "\n");
		}
		
		System.out.print(sb);
	}

	static void dfs(int r, int c, int sum) {
				
		if(res < sum) res = sum;	// 명물 개수 최대값 변경
		if(res == 26) return;	// 모든 알파벳을 다 봤으면 return (가지치기)
		
		int nr, nc;
		for(int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			
			if(nr<0 || nr>=R || nc<0 || nc>=C || v[map[nr][nc]-65])	// 범위 벗어나거나 방문한 알파벳이면 continue
				continue;
			
			v[map[nr][nc]-65] = true;
			dfs(nr, nc, sum+1);
			v[map[nr][nc]-65] = false;
		}
	}
}