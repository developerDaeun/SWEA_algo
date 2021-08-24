import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_7465_창용마을무리의개수 {
	
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
	static Set<Integer> set;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());	// 마을사람 수 (1~N번)
			M = Integer.parseInt(st.nextToken());	// 관계 수(간선 수)
			parents = new int[N+1];
			
			make();	// parents 생성 -> 정점마다 집합 만들기
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				union(start, end);	// 합집합 !
			}
			
			for(int i = 1; i <= N; i++) {	// 아직 부모가 업데이트 안된것이 있으면 업데이트
				find(i);
			}
			
			set = new HashSet<>();
			for(int i = 1; i <= N; i++) {	// 중복되는 숫자를 안세도록 Set 사용해서 대표자 세기
				set.add(parents[i]);
			}
			
			sb.append("#" + t + " " + set.size() + "\n");	// set 크기 : 무리 개수
		}
		
		System.out.println(sb);
	}
}