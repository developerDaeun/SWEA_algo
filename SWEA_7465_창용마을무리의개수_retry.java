import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7465_창용마을무리의개수_retry {
	
	static void make() {
		parents = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static void union(int a, int b) {
		a = find(parents[a]);
		b = find(parents[b]);
		if(a==b) return;
		
		parents[b] = a;
	}
	
	static int N, M;
	static int[] parents;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());	// 마을사람 수 (1~N번)
			M = Integer.parseInt(st.nextToken());	// 관계 수(간선 수)
	
			make();	// parents 생성 -> 정점마다 집합 만들기
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				union(start, end);	// 합집합 !
			}
			
			int res = 0;
			for(int i = 1; i <= N; i++) {	// 인덱스와 대표자가 같은것 개수 세기 => 무리의 개수
				if(i==parents[i]) res++;
			}
			
			sb.append("#" + t + " " + res + "\n");
		}
		
		System.out.println(sb);
	}
}