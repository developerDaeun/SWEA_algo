import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247_최적경로 {

	static int[][] points;
	static int N, min; // 고객의수, 최단 경로 이동거리
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());	// 테케 수
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());	// 고객의 수
			points = new int[N+2][2];
			
			st = new StringTokenizer(br.readLine(), " ");
			points[0][0] = Integer.parseInt(st.nextToken());	// 회사 좌표 r
			points[0][1] = Integer.parseInt(st.nextToken());	// 회사 좌표 c
			points[N+1][0] = Integer.parseInt(st.nextToken());	// 집 좌표 r
			points[N+1][1] = Integer.parseInt(st.nextToken());	// 집 좌표 c
			
			for(int i = 1; i <= N; i++) {
				points[i][0] = Integer.parseInt(st.nextToken());	// 고객 좌표 r
				points[i][1] = Integer.parseInt(st.nextToken());	// 고객 좌표 c
			}
			
			min = Integer.MAX_VALUE;
			
			perm(0,0,0,0);
			
			sb.append("#" + t + " " + min + "\n");
		}
		
		System.out.println(sb);
	}
	
	// 매개변수 => 이전좌표인덱스 / 고른 좌표개수 / 지금까지 거리 합 / 비트마스킹
	static void perm(int before, int cnt, int total, int flag) {	
		if(cnt == N) {
			total = total + Math.abs(points[before][0]-points[N+1][0]) + Math.abs(points[before][1] - points[N+1][1]);
			min = Math.min(min, total);
			return;
		}
		
		int dist;
		for(int i = 1; i < N+1; i++) {	// 시작은 회사, 끝은 집이어야 하므로 고객의 좌표만 순열
			if((flag & 1<<i) != 0) continue;	// 사용중이면 continue
			dist = total + Math.abs(points[before][0]-points[i][0]) + Math.abs(points[before][1] - points[i][1]);	// 이전좌표, 현재좌표 거리
			if(dist >= min) continue;	// 최단경로보다 숫자가 커지면 continue
			perm(i, cnt+1, dist, flag|1<<i);	// 현재 좌표를 사용했을 때
		}
	}
}