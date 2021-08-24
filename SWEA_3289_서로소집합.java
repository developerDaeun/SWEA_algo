import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {

	static void make() {	// 원소마다 집합 생성
		for (int i = 1; i <= n; i++) {
			parents[i] = i;			
		}
	}
	
	static int find(int a) {	// 자신이 속한 집합에서 대표자 찾기
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);	// 대표자가 바뀌었다면 변경
	}
	
	static void union(int a, int b) {	// 합집합
		a = find(a);
		b = find(b);
		if(a==b) return;
		
		parents[b] = a;
	}
	
	static int n, m;
	static int[] parents;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder res = new StringBuilder();	// 모든 테케 결과값 모은 문자열
		StringBuilder sb;	// 테케마다 결과값
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			sb.append("#" + t + " ");
			
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());	// 원소의 개수 => 1,..n까지 n개의 집합
			m = Integer.parseInt(st.nextToken());	// 연산의 개수
			parents = new int[n+1];
			
			make();	// 원소마다 집합 생성
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int op = Integer.parseInt(st.nextToken());	// 0: 합집합, 1: 같은집합인지 확인
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(op==0) union(a, b);	// 합집합
				else {	// 같은 집합인지 확인
					if(find(a)==find(b)) sb.append(1);	// 같은 집합이면 1 출력
					else sb.append(0);	// 다른 집합이면 0 출력
				}
			}
			res.append(sb).append("\n");
			
		}
		System.out.println(res);
	}
}